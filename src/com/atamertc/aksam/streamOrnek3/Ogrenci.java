package com.atamertc.aksam.streamOrnek3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ogrenci {
    private int id;
    private String isim;
    private String bolum;
    private String durum;
    private List<Double> notlar;

    public Ogrenci(int id, String isim, String bolum) {
        this.id = id;
        this.isim = isim;
        this.bolum = bolum;
        this.notlar = new ArrayList<>();
    }

    public double notOrtalamalari() {
        return notlar.stream()
                .collect(Collectors.averagingDouble(x->x));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public List<Double> getNotlar() {
        return notlar;
    }

    public void setNotlar(List<Double> notlar) {
        this.notlar = notlar;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", bolum='" + bolum + '\'' +
                ", durum='" + durum + '\'' +
                ", notlar=" + notlar +
                '}';
    }
}
