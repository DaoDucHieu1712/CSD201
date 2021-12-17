/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author Kien
 */
public class Book implements Serializable{
    private String bcode;
    private String title;
    private int quality;
    private int lended;
    private double price;

    public Book() {
    }

    public Book(String bcode, String title, int quality, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quality = quality;
        this.lended = lended;
        this.price = price;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }

    public void setDepart_time(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.bcode + " | " + this.title + " | " + this.quality + " | " + this.lended
                + " | " + this.price;
    }
    
    
}
