package com.nnxy.boot.web01.bean;

import java.util.Date;
import java.util.Objects;

/**
 * @author：MengYinChang
 * @create at: 2021-05-02  19:21
 */
public class Person {
    private String name;

    private Date brith;

    private Integer age;

    private Pet pet;

    public Person() {

    }

    public Person(String name, Date brith, Integer age, Pet pet) {
        this.name = name;
        this.brith = brith;
        this.age = age;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(brith, person.brith) &&
                Objects.equals(age, person.age) &&
                Objects.equals(pet, person.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brith, age, pet);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", brith=" + brith +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}
