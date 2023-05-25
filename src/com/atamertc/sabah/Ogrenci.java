package com.atamertc.sabah;

public class Ogrenci {
    private int id;
    private String ad;
    private String soyad;
    private String bolum;
    private double not;

    public Ogrenci(int id, String ad, String soyad, String bolum, double not) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.bolum = bolum;
        this.not = not;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public double getNot() {
        return not;
    }

    public void setNot(double not) {
        this.not = not;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", bolum='" + bolum + '\'' +
                ", not=" + not +
                '}';
    }
}
