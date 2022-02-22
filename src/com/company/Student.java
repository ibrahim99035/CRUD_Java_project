package com.company;
public class Student {
    String name;
    String id;
    String department;
    int level;
    public void Student(String name, String id, String department, int level){
        this.name = name;
        this.id = id;
        this.department = department;
        this.level = level;
    }
    String getStudentData(){
        return "Name : " + name + " , " + "Level : " + level + " , " + "Department : "+ department + " , " + "ID : " +  id;
    }
}
