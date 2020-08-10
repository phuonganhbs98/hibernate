package com.javatraining.DemoHib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.javatraining.entity.Giaovien;
import com.javatraining.entity.Hocsinh;
import com.javatraining.entity.Lop;
import com.javatraining.util.HibernateUtil;
import com.mysql.cj.Query;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		SessionFactory ssFac = HibernateUtil.getSessionFactory();
		Session session = ssFac.openSession();
        Transaction tx = session.beginTransaction();
		try {
            Lop lop1 = new Lop();
            lop1.setName("10D1");
            Lop lop2 = new Lop();
            lop2.setName("10D2");
            
            int n = 5;
            List<Giaovien> gv = new ArrayList<Giaovien>(n);
            for (int i = 0; i < n; i++) {
            	Giaovien g = new Giaovien();
            	g.setName("Giao vien "+(i+1));
            	if (i<=n/2) g.addClass(lop1);
            	if (i>=n/2) g.addClass(lop2);
            	gv.add(g);
            }
            
            List<Hocsinh> students2 = new ArrayList<Hocsinh>();
            for (int i = 0; i < 5; i++) {
                Hocsinh s = new Hocsinh();
                s.setName("Hoc Sinh D2 "+(i+1));
                s.setsClass(lop2);
                students2.add(s);
            }
            lop2.setStudents(students2);
            
            List<Hocsinh> students1 = new ArrayList<Hocsinh>();
            for (int i = 0; i < 5; i++) {
                Hocsinh s = new Hocsinh();
                s.setName("Hoc Sinh D1 "+(i+1));
             // hoc sinh co quan he vs lop nen no phai chua 1 obj lop
                s.setsClass(lop1);
                students1.add(s);
            }
         // lop co hs nen trong obj lop phai co obj hs
            lop1.setStudents(students1);
		    for (Giaovien g : gv) {
		    	session.save(g);
		    }
            lop1.setTeachers(gv.subList(0, n/2+1));
            lop2.setTeachers(gv.subList(n/2, n));
            lop1.setHeadTeacher(gv.get(0));
            lop2.setHeadTeacher(gv.get(n-1));
            session.save(lop1);
            session.save(lop2);
            for (Hocsinh s : students2) {
            	session.save(s);
            }
            for (Hocsinh s : students1) {
            	session.save(s);
            }
            tx.commit();
			Lop l = session.load(Lop.class,1);
			for (Hocsinh hs : l.getStudents()) {
				System.out.println(hs.getName());
			}	
//			System.out.println(l.getName()+" has head teacher: ");
//			System.out.println("Fetch teacher: "+l.getHeadTeacher().getName());
//			System.out.println("Fetch teacher: ");
//			Giaovien g = session.find(Giaovien.class, 3);
//			System.out.println("Fetch teacher: "+g.getName());
//			for (Lop lop : g.getClasses()) {
//				System.out.println("Fetch teaching class: "+lop.getName());
//			}
//			System.out.println("Fetch students of class:"+l.getName());
//			for (Hocsinh hs : l.getStudents()) {
//				System.out.println(hs.getName());
//			}			
			session.close();
			ssFac.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
