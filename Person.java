/**
 * Author: Skipha
 * Date: 26 Oct 2018
 */

package com.skipha.cv;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
    private String name;
    private String sex;
    private String address;
    private String phone;
    private String email;
    private ArrayList<Education> educations;
    private ArrayList<Work> works;

    public Person(String name, String sex, String address, String phone, String email) {
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Education> getEducations() {
        return educations;
    }

    public void setEducations(ArrayList<Education> educations) {
        this.educations = educations;
    }

    public ArrayList<Work> getWorks() {
        return works;
    }

    public void setWorks(ArrayList<Work> works) {
        this.works = works;
    }
}
