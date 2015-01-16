package com.smartdata;

/**
 * User: Binay
 * Date: 16/01/15
 * Time: 2:54 PM
 */
public class Member {
    private String id;
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private String phone_no;


    public void setId(String id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getId() {
        return this.id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getAddress() {
        return this.address;
    }

    public  String getEmail() {
        return this.email;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public String toString() {
        return id + " " + first_name + " " + last_name + " " + address + " " + email + " " + phone_no;
    }
}
