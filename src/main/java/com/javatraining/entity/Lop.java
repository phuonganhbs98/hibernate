package com.javatraining.entity;

import java.util.ArrayList;
import java.util.List;

public class Lop {

	private Integer id;
	private String name;
	private List<Hocsinh> students = new ArrayList<Hocsinh>();
	private List<Giaovien> teachers = new ArrayList<Giaovien>();
	private Giaovien headTeacher;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Hocsinh> getStudents() {
		return students;
	}
	
	
	public void setStudents(List<Hocsinh> students) {
		for (Hocsinh s : students) {
			if (s.getsClass() == null) {
				s.setsClass(this);				
			}
		}
		this.students = students;
		
	}
	public void addStudent(Hocsinh s) {
		this.getStudents().add(s);
	}
	
	public List<Giaovien> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Giaovien> teachers) {
		for (Giaovien gv : teachers) {
			if (!gv.getClasses().contains(this)) {
				gv.addClass(this);
			}
		}
		this.teachers = teachers;
	}
	public void addTeacher(Giaovien gv) {
		this.teachers.add(gv);
	}
	
	public Giaovien getHeadTeacher() {
		return headTeacher;
	}
	public void setHeadTeacher(Giaovien headTeacher) {
		this.headTeacher = headTeacher;
	}
	@Override
	public String toString() {
		String s = "Lop [id=" + id + ", name=" + name + ", students=\n{";
//		for (Hocsinh hs : students) {
//			s = s + hs.toString()+"\n";
//		}
//		s += "}, teachers=\n{";
//		for(Giaovien g : teachers) {
//			s += g.getName()+", ";
//		}
//		return s + "}]";
		return s;
	}

}
