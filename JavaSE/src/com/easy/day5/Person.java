package com.easy.day5;

public class Person extends Object{
    //希望子类访问
    protected int id;
    protected String name;
    protected int age;
    protected String gender;

    public Person() {
        super();
        System.out.println("Person.Person1");
    }

    public Person(int id, String name, int age, String gender) {
        super();
        System.out.println("Person.Person2");
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void show() {
        System.out.println("Person.show");
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
