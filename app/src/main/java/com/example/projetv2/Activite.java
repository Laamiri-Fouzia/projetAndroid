package com.example.projetv2;

public class Activite {
    private int img;
    private String nom;
    private String desc;
    private String date;
    private String status;

    public int getImg() {
        return img;
    }

    public Activite(int img, String nom, String desc, String date, String status) {
        this.img = img;
        this.nom = nom;
        this.desc = desc;
        this.date = date;
        this.status = status;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
