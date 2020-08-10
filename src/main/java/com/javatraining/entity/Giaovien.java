package com.javatraining.entity;

import java.util.ArrayList;
import java.util.List;

public class Giaovien {
	private Integer id;
	private String name;
	private Integer age;
	private List<Lop> classes = new ArrayList<Lop>();
	private Lop respondClass;
	
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

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List<Lop> getClasses() {
		return classes;
	}
	public void setClasses(List<Lop> classes) {
		for (Lop l : classes) {
			if (!l.getTeachers().contains(this)) {
				l.addTeacher(this);
			}
		}
		this.classes = classes;
	}
	public void addClass(Lop lop) {
		this.classes.add(lop);
	}
	
	public Lop getRespondClass() {
		return respondClass;
	}
	public void setRespondClass(Lop respondClass) {
		this.respondClass = respondClass;
	}
	@Override
	public String toString() {
		String s = "Giaovien [id=" + id + ", name=" + name + ", age=" + age + ",\n{";
		for (Lop l : classes) {
			s += l.getName()+", ";
		}
		return s+"}]";
	}
}
