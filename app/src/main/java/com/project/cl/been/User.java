package com.project.cl.been;

import java.io.Serializable;

/**
 * Created by PC on 2017/4/12.
 */

public class User implements Serializable {
    private String name;
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
