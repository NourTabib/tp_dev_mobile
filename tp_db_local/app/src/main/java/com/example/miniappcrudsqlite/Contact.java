package com.example.miniappcrudsqlite;

public class Contact {
    private int id;
    private String Name;
    private String number;
    public Contact(){

    }
    public Contact(String name, String num) {

        Name = name;
        number = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNum() {
        return number;
    }

    public void setNumber(String num) {
        number = num;
    }
}
