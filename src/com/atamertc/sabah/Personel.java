package com.atamertc.sabah;

public class Personel implements Comparable<Personel> {
    private int id;
    private String ad;
    private String soyad;
    private String departman;
    private double maas;

    public Personel(int id, String ad, String soyad, String departman, double maas) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.departman = departman;
        this.maas = maas;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getDepartman() {
        return departman;
    }

    public double getMaas() {
        return maas;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", departman='" + departman + '\'' +
                ", maas=" + maas +
                '}';
    }

    public void maasArtir(double d) {
        this.maas+=maas*d/100;
    }

    @Override
    public int compareTo(Personel o) {
        if (this.maas > o.maas) {
            return 1;
        } else if (this.maas < o.maas) {
            return -1;
        } else {
            return 0;
        }
    }
}
