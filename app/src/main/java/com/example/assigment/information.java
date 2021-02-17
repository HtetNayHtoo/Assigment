package com.example.assigment;

public class information {

    private String hname;
    private String address;
    private String contact;
    private int photo;

    public information(String hname, String address, String contact, int photo) {
        this.hname = hname;
        this.address = address;
        this.contact = contact;
        this.photo = photo;
    }

    public String getHname() {
        return hname;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public int getPhoto(){
        return photo;
    }
}
