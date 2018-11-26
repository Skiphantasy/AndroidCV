/**
 * Author: Skipha
 * Date: 26 Oct 2018
 */

package com.skipha.cv;

import java.io.Serializable;

public class Education implements Serializable {

    private String name;
    private String year;
    private String school;

    public Education(String name, String year, String school) {
        this.name = name;
        this.year = year;
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNameTitle() {
        return name;
    }

    public void setNameTitle(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }
}
