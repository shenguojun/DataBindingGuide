package com.xshen.databindingguide.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.xshen.databindingguide.BR;

/**
 * 说明：用户model
 *
 * @author shengj E-mail: shengj@rd.netease.com
 * @version 创建时间：2016-07-12 22:11
 */
public class User extends BaseObservable {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String displayName;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
    }

    @Bindable
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        notifyPropertyChanged(BR.displayName);
    }

}
