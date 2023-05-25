package com.atamertc.aksam.streamOrnek3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OgrenciManager {
    static List<Ogrenci> ogrenciler;

    public void baslangicVerisi() {
        ogrenciler = new ArrayList<>();
        Ogrenci Ogrenci1 = new Ogrenci(1, "Mustafa", "mat");
        Ogrenci1.getNotlar().add(50D);
        Ogrenci1.getNotlar().add(50.0);
        Ogrenci1.getNotlar().add(50D);
        Ogrenci Ogrenci2 = new Ogrenci(2, "Ayşe", "tm");
        Ogrenci2.getNotlar().add(80D);
        Ogrenci2.getNotlar().add(55D);
        Ogrenci2.getNotlar().add(79.5);
        Ogrenci Ogrenci3 = new Ogrenci(3, "Hakan", "tm");
        Ogrenci3.getNotlar().add(86D);
        Ogrenci3.getNotlar().add(97.5);
        Ogrenci3.getNotlar().add(50.5);
        Ogrenci Ogrenci4 = new Ogrenci(4, "Mert", "mat");
        Ogrenci4.getNotlar().add(80D);
        Ogrenci4.getNotlar().add(30D);
        Ogrenci4.getNotlar().add(82.5);
        Ogrenci Ogrenci5 = new Ogrenci(5, "Gamze", "mat");
        Ogrenci5.getNotlar().add(10D);
        Ogrenci5.getNotlar().add(35.7);
        Ogrenci5.getNotlar().add(58.3);
        Ogrenci Ogrenci6 = new Ogrenci(6, "Merve", "tm");
        Ogrenci6.getNotlar().add(36D);
        Ogrenci6.getNotlar().add(23.5D);
        Ogrenci6.getNotlar().add(57.5);
        ogrenciler = List.of(Ogrenci1, Ogrenci2, Ogrenci3, Ogrenci4, Ogrenci5, Ogrenci6);
    }

    public static void main(String[] args) {
        OgrenciManager ogrenciManager = new OgrenciManager();
        ogrenciManager.baslangicVerisi();
        //Ogrencileri bolume gore mapleyelim
        Map<String, List<Ogrenci>> bolumMap = ogrenciler.stream()
                .collect(Collectors.groupingBy(Ogrenci::getBolum));
        bolumMap.entrySet().forEach(System.out::println);
//        bolumMap.forEach((k,v)-> System.out.println(k+"-"+v));

        //Butun ogrencilerin not ortalamasini hesaplayin
        Double ortOrt = ogrenciler.stream()
                .collect(Collectors.averagingDouble(Ogrenci::notOrtalamalari));
        System.out.println(ortOrt);

        //Ogrenci ismine karsilik not ortalamasi olan bir map yapisi yapalim
        Map<String, Double> bolumOgrenci = ogrenciler.stream()
                .collect(Collectors.toMap(Ogrenci::getIsim, Ogrenci::notOrtalamalari));
        bolumOgrenci.entrySet().forEach(System.out::println);

        //Not ortalamasi 50 den kucuk olanlarin durumu kaldi buyuk olanlarin ki gecti olacak
        // 1.YONTEM
        ogrenciler.stream().forEach(o->{
            if (o.notOrtalamalari() > 50) {
                o.setDurum("Gecti");
            } else {
                o.setDurum("Kaldi");
            }
        });
        ogrenciler.stream().forEach(System.out::println);
        // 2.YONTEM
        ogrenciler.stream()
                .filter(x->x.notOrtalamalari()>50)
                .forEach(x->x.setDurum("Gecti"));
        ogrenciler.stream()
                .filter(x->x.notOrtalamalari()<=50)
                .forEach(x->x.setDurum("Kaldi"));

        //Her bir ogrenciye bir tanede sozlu notu ekleyelim yani 4. notu ekleyelim
        ogrenciler.stream().forEach(o->o.getNotlar().add(80D));

        //Her bir ogrencinin notuna 5 puan daha ekleyelim
        ogrenciler.stream()
                .forEach(o -> o.setNotlar(o.getNotlar()
                        .stream()
                        .map(x -> x + 5.0)
                        .collect(Collectors.toList())));

    }


}
