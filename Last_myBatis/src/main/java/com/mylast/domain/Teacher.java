package com.mylast.domain;

public class Teacher {
    private int techerid;
    private String name;

    public int getId() {
        return techerid;
    }

    public void setId(int techerid) {
        this.techerid=techerid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "techerid=" + techerid +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
