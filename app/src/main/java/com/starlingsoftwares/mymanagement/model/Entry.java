package com.starlingsoftwares.mymanagement.model;

public class Entry {
    String jodi;
    String price;
    int serial;

    public Entry() {
    }

    public Entry(String jodi, String price, int serial) {
        this.jodi = jodi;
        this.price = price;
        this.serial = serial;
    }

    public String getJodi() {
        return jodi;
    }

    public void setJodi(String jodi) {
        this.jodi = jodi;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
}
