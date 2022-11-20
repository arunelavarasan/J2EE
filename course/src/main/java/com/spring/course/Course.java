package com.spring.course;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Course {

	private int id;
	private String name;
	private String course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Course(int id,String name, String course) {
		this.id=id;
		this.name = name;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
}
