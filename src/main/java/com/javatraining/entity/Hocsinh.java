package com.javatraining.entity;

public class Hocsinh {

	private Integer id;
	private String name;
	private Integer classId;
	private Lop sClass;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Lop getsClass() {
		return sClass;
	}
	public void setsClass(Lop sClass) {
		this.sClass = sClass;
	}
	@Override
	public String toString() {
		return "Hocsinh [id=" + id + ", name=" + name + ", classId=" + classId + "]";
	}

}
