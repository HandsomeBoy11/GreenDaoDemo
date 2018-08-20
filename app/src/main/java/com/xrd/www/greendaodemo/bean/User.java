package com.xrd.www.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;

/**
 * Created by user on 2018/8/14.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;//保证自增长必须是Long类型的
    public String name="";
    public int age;
    public String phone="";
    public String sex="";
//    public String live="";
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
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
    public void setId(long id) {
        this.id = id;
    }
//   @Generated(hash = 1370434209)
   @Keep  //使用keep可以修改和删除字段
public User(Long id, String name, int age, String phone, String sex/*, String live*/) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.sex = sex;
//    this.live = live;
}
    @Generated(hash = 586692638)
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
/*    public String getLive() {
        return this.live;
    }
    public void setLive(String live) {
        this.live = live;
    }*/
    public void setId(Long id) {
        this.id = id;
    }
}
