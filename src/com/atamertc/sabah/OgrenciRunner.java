package com.atamertc.sabah;

import java.util.*;
import java.util.stream.Collectors;

public class OgrenciRunner {

    public static void main(String[] args) {

        List<Ogrenci> ogrenciler = new ArrayList<>();
        ogrenciler.add(new Ogrenci(1, "Ahmet", "Yılmaz", "Makine Mühendisliği", 80.0));
        ogrenciler.add(new Ogrenci(2, "Mehmet", "Aksoy", "Elektrik Elektronik Mühendisliği", 60.0));
        ogrenciler.add(new Ogrenci(3, "Ayşe", "Kara", "Bilgisayar Mühendisliği", 90.0));
        ogrenciler.add(new Ogrenci(4, "Fatma", "Şahin", "Endüstri Mühendisliği", 75.0));
        ogrenciler.add(new Ogrenci(5, "Ali", "Yıldız", "Makine Mühendisliği", 85.0));
        ogrenciler.add(new Ogrenci(6, "Zeynep", "Süre", "Bilgisayar Mühendisliği", 95.0));
        ogrenciler.add(new Ogrenci(7, "Hakan", "Demir", "Elektrik Elektronik Mühendisliği", 55.0));
        ogrenciler.add(new Ogrenci(8, "Emine", "Kara", "Endüstri Mühendisliği", 65.0));
        ogrenciler.add(new Ogrenci(13, "Gül", "Kaya", "Bilgisayar Mühendisliği", 85.0));
        ogrenciler.add(new Ogrenci(14, "Ahmet", "Güçlü", "İnşaat Mühendisliği", 60.0));
        ogrenciler.add(new Ogrenci(19, "Ayşe", "Yıldız", "Gıda Mühendisliği", 80.0));
        ogrenciler.add(new Ogrenci(20, "Veli", "Öz", "Elektrik Elektronik Mühendisliği", 88.0));
        ogrenciler.add(new Ogrenci(21, "Fatma", "Tek", "Endüstri Mühendisliği", 75.0));
        ogrenciler.add(new Ogrenci(24, "Deniz", "Aksoy", "Bilgisayar Mühendisliği", 95.0));
        ogrenciler.add(new Ogrenci(25, "Merve", "Özdemir", "İnşaat Mühendisliği", 55.0));
        ogrenciler.add(new Ogrenci(30, "Hüseyin", "Yılmaz", "Gıda Mühendisliği", 70.0));

        //Soru 1: Ogrencilerin tamamini yazdirin
        ogrenciler.stream()
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");
        //Soru 2: Not ortalamasi 70'in uzerinde olan ogrencileri yazdirin
        ogrenciler.stream()
                .filter(p -> p.getNot() > 70)
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");
        //Soru 3: Muhendislik fakultesinde okuyan ogrencilerin sayisini yazdirin
        Long ogrenciSayisi = ogrenciler.stream()
                .filter(o -> o.getBolum().contains("Bilgisayar"))
                .count();
        System.out.println(ogrenciSayisi);
        System.out.println("------------------------------------------------");
        //Soru 4: Adi "Ali" olan ogrencinin bilgilerini yazdirin.
        ogrenciler.stream()
                .filter(o -> o.getAd().equals("Ali"))
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");
        //Soru 5: Adi "Hakan" olan ogrenci var mi yok mu donsun
        System.out.println(ogrenciler.stream()
                .anyMatch(o -> o.getAd().equals("Hakan")));
        System.out.println("------------------------------------------------");
        //Soru 6: Not ortalamasina gore ogrencileri siralayin
        ogrenciler.stream()
                .sorted(Comparator.comparing(Ogrenci::getNot).reversed())
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");
        //Soru 7: Not ortalamasi 70 ve ustu olan ogrencilern isimlerini ve bolumleri yazdir
        ogrenciler.stream()
                .filter(o -> o.getNot() > 70)
                .forEach(o -> System.out.println(o.getAd() + " " + o.getBolum()));
        System.out.println("------------------------------------------------");
        //Soru 8: En yuksek not ortalamasina sahip ogrencinin bilgilerini yazdirin
        ogrenciler.stream()
                .sorted(Comparator.comparing(Ogrenci::getNot).reversed())
                .limit(1)
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");
        //Soru 9: Bolumlere gore ogrencilerin not ortalamalarinin ortalamasini hesaplayin
        Map<String, Double> bolumOrt = ogrenciler.stream()
                .collect(Collectors.groupingBy(Ogrenci::getBolum,
                        Collectors.averagingDouble(Ogrenci::getNot)));
        bolumOrt.forEach((k, v) -> System.out.println(k + "-" + v));
        System.out.println("------------------------------------------------");
        //Soru 11: Not ortalaması 60 ile 80 arasında olan öğrencilerin sayısını bulun.
        System.out.println(ogrenciler.stream()
                .filter(o -> o.getNot() > 60 && o.getNot() < 80)
                .count());
        System.out.println("------------------------------------------------");
        //Soru 12: En düşük not ortalamasına sahip öğrencinin bölümünü yazdırın.
        ogrenciler.stream()
                .sorted(Comparator.comparing(Ogrenci::getNot))
                .limit(1)
                .forEach(o -> System.out.println(o.getAd() + " " + o.getBolum()));
        System.out.println("------------------------------------------------");
        //Soru 13: Not ortalamalarının ortalaması kaçtır?
        Double ortOrt = ogrenciler.stream()
                .collect(Collectors.averagingDouble(Ogrenci::getNot));
        System.out.println(ortOrt);
        System.out.println("------------------------------------------------");
        //Soru 14: Notu 60'ın üstünde olan öğrencilerin sayısı kaçtır?
        System.out.println(ogrenciler.stream()
                .filter(o -> o.getNot() > 60)
                .count());
        System.out.println("------------------------------------------------");
        //Soru 15: Bölümü "Bilgisayar Mühendisliği" olan öğrencilerin isimleri nelerdir?
        ogrenciler.stream()
                .filter(o -> o.getBolum().equals("Bilgisayar Mühendisliği"))
                .map(ogrenci -> ogrenci.getAd())
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");
        //Soru 16: Not ortalaması en yüksek olan öğrencinin adı nedir?
        ogrenciler.stream()
                .sorted(Comparator.comparing(Ogrenci::getNot).reversed())
                .limit(1)
                .forEach(ogrenci -> System.out.println(ogrenci.getAd()));
        System.out.println("------------------------------------------------");
        //Soru 17: Her bölümden kaç tane öğrenci olduğunu bulun.
        Map<String, List<Ogrenci>> bolumOgrenci = ogrenciler.stream()
                .collect(Collectors.groupingBy(Ogrenci::getBolum));

        for (Map.Entry<String, List<Ogrenci>> entry :
                bolumOgrenci.entrySet()) {
            int ogrNo = 0;
            for (Ogrenci ogrenci :
                    entry.getValue()) {
                ogrNo++;
            }
            System.out.println(entry.getKey() + "->" + ogrNo);
        }
        System.out.println("------------------------------------------------");
        //Soru 18: Not ortalaması 70'in altında olan öğrencilerin bölümlerinde kaç tane öğrenci var?
        ogrenciler.stream()
                .filter(x->x.getNot() <70)
                .forEach(x-> {
                });


        //Soru 19: Bölümü "İnşaat Mühendisliği" olan öğrencilerin not ortalaması kaçtır?
        Double i̇nşaatMühendisliği = ogrenciler.stream()
                .filter(o -> o.getBolum().equals("İnşaat Mühendisliği"))
                .collect(Collectors.averagingDouble(Ogrenci::getNot));
        System.out.println(i̇nşaatMühendisliği);

    }
}
