package com.xrd.www.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by user on 2018/8/14.
 */
@Entity
public class Person {
    @Id(autoincrement = true)
    private Long id;//保证自增长必须是Long类型的
    public String name="";
    public String xueli="";
    public String school="";
    public String getSchool() {
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getXueli() {
        return this.xueli;
    }
    public void setXueli(String xueli) {
        this.xueli = xueli;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 812558728)
    public Person(Long id, String name, String xueli, String school) {
        this.id = id;
        this.name = name;
        this.xueli = xueli;
        this.school = school;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
}
