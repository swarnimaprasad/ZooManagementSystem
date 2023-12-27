package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Visitor {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String phoneNumber;
    private double balance;
    private String email;
    private String password;
    private String membershipType;
    HashMap<Integer,Integer> visitor_attraction_list;
    public Visitor(String name, int age, String phoneNumber, double balance, String email, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        visitor_attraction_list=new HashMap<>();

    }
    public String getMembershipType() {
        return membershipType;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getBalance() {
        return balance;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                '}';
    }
}
