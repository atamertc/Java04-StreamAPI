package com.atamertc.sabah;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGiris {
    public static void main(String[] args) {
        //Stream veri saklamaz. Bir veri yapisi degildir. Veri tabani gibi kullanilmaz
        //Stream olusturmak verinin kaynaginda bir degisiklige sebep olmaz

        //Stream Olusturma
        Stream<String> bosKayit = Stream.empty(); // bos bir stream olusturur
        Stream<String> tekKayit = Stream.of("Pazartesi"); //tek kayitli stream
        Stream<Double> cokKayit = Stream.of(2.0, 5d, 15d, 20d); // cok kayitli stream

        List<String> gunler = List.of("Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar");
        //listeyi akisa cevirme:
        Stream<String> gunlerStream = gunler.stream();
        //forEach terminali icine suslu parantez birden cok islem yaptirabilir
//        gunlerStream.forEach(x->{
//            //yapilacak islemleri yaz
//            x = x.toUpperCase();
//            System.out.println(x);
//        });


        List<Personel> personeller = new ArrayList<>();
        personeller.add(new Personel(1, "Tarkan", "Tevetoğlu", "Müzik", 10000));
        personeller.add(new Personel(2, "Cem", "Yılmaz", "Sinema", 15000));
        personeller.add(new Personel(3, "Seda", "Sayan", "Televizyon", 12000));
        personeller.add(new Personel(4, "Kıvanç", "Tatlıtuğ", "Dizi", 20000));
        personeller.add(new Personel(5, "Demet", "Akbağ", "Sinema", 13000));
        personeller.add(new Personel(6, "Kenan", "İmirzalıoğlu", "Dizi", 18000));
        personeller.add(new Personel(7, "Beren", "Saat", "Dizi", 18000));
        personeller.add(new Personel(8, "Murat", "Boz", "Müzik", 12000));
        personeller.add(new Personel(9, "Cansu", "Dere", "Dizi", 16000));
        personeller.add(new Personel(10, "Serenay", "Sarıkaya", "Dizi", 16000));

        //stream metodu her cagrildiginda yeni bir stream olusturur
        //streamler kullanildiktan sonra kapandigi icin stream nesnesi olusturursak
        //o nesne ile sadece bir islem yapilabilir sonra stream sonlanir
        //ancak personeller.stream() metodu ile yaparsak her defasinda yeni bir
        //stream olusturur ->->->->->->
        personeller.stream();
        //Bu sekilde yaptigimizdada tek bir nesneye bagli oluyor
        Stream<Personel> personelStream = personeller.stream();
        //Stream.of icerisine atilan arraydan akis olusturma
        Stream<Personel> personelStream1 = Stream.of(personeller.toArray(new Personel[personeller.size()]));
        //Array.stream ile ayni seyi yapma
        Stream<Personel> personelStream2 = Arrays.stream(personeller.toArray(new Personel[personeller.size()]));

        //Stream olusturmak icin Stream.builder() da kullanilabilir

//        //Metod 1: forEach: Streamdeki her bir oge icin verilen islemi gerceklestirir
//        //personelStream.forEach(p -> System.out.println(p));
//
//        for (Personel personel :
//                personeller) {
//            System.out.println(personel);
//        }
//        //personellerin maasina %10 zam yap (Stream forEach ile)
//        personeller.stream().forEach(p -> p.maasArtir(10.0));
//        for (Personel personel :
//                personeller) {
//            System.out.println(personel);
//        }
//
//        personeller.stream().forEach(p -> System.out.println(p));

//        System.out.println("*******************************************");
//        //Metod 2: filter() streamdeki verileri kosula gore filtreleyecek ve yeni bir
//        //stream olusturacak
//        personeller.stream()
//                .filter(p -> p.getAd().contains("e"))
//                .forEach(p->p.maasArtir(10.0));
//
//        for (Personel person :
//                personeller) {
//            System.out.println(person);
//        }
//
//        personeller.stream()
//                .filter(p -> p.getMaas()<18000)
//                .forEach(p->p.maasArtir(10.0));
//
//        for (Personel person :
//                personeller) {
//            System.out.println(person);
//        }

        System.out.println("*******************************************");
        //Metod 3: distinct(): 1,2,2,3,3,4 -> 1,2,3,4 birbirinden farkli elemanlar
        personeller.stream()
                .map(p->p.getDepartman())
                .distinct()
                .forEach(System.out::println);

        System.out.println("*******************************************");
        //Metod 5: sorted(): siralar
        personeller.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("*******************************************");
        //Metod 6: limit(): Akistan kac eleman alinacagini belirler
        personeller.stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("*******************************************");
        //Metod7: skip() Akista kac eleman atlanacagini belirler
        personeller.stream()
                .skip(6)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("*******************************************");
        //Metod 8: count(): Akistaki eleman sayisini verir
        Long elemanSayisi = personeller.stream()
                .map(p -> p.getDepartman())
                .distinct().count();
        System.out.println(elemanSayisi);

        Long elemanSayisi2 = personeller.stream()
                .filter(p -> p.getAd().startsWith("K"))
                .count();
        System.out.println(elemanSayisi2);

        Long elemansayisi3 = personeller.stream().count();
        System.out.println(elemansayisi3);

        System.out.println("*******************************************");
        //Metod 9: anyMatch(): Kosula uygun en az 1 tane donus varsa true donecek
        //bir sey var mi yok mu kontrolu gibi mesela
        System.out.println(personeller.stream()
                .anyMatch(p -> p.getMaas() < 18000));

        //Metod 10: allMatch() Tum elemanlar kosula uyuyorsa true donecek
        System.out.println(personeller.stream()
                .allMatch(p -> p.getMaas() < 18000));

        //Metod 11: nonMatch() Kosula hicbiri uymuyorsa true donecek
        System.out.println(personeller.stream()
                .noneMatch(p -> p.getMaas() < 5000));

        System.out.println("*******************************************");
        //Metod 12: map(): Stream uzerindeki elemanlarda islemler yapip yeni bir akis olusturur
        personeller.stream()
                .filter(p->p.getMaas()<15000)
                .map(p -> p.getMaas() + 5000)
                .forEach(System.out::println);

        System.out.println("*******************************************");
        //Metod 13: reduce() Elemanlari tek bir degerde islemek icin kullanilir
        //reduce(baslangic degeri, lambda expression)
        List<Integer> sayilar = Arrays.asList(1, 2, 3, 4, 5);
        int toplam = sayilar.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(toplam);

        List<Integer> sayilar2 = Arrays.asList(1, 2, 3, 4, 5);
        int carpma = sayilar2.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(carpma);

        //Optional: Bu degisken bos olabilir, buda onu optional yapar ve boyle yazilmali
        Optional<Integer> max = sayilar.stream()
                .reduce(Integer::max);

        if (max.isPresent()) { //isPresent: icinde eleman varsa demek, isEmpty nin tersi
            System.out.println(max.get()); // get() kullanmazsak Optional[5] diye donuyor
        }

        System.out.println("*******************************************");
        //Metod 14: collect(): Streamden collection olusturmayi saglar
        //Metod 15: peek(): Goz gezdirmek
        Set<String> zamliMaas = personeller.stream()
                .peek(p -> System.out.println("Zamdan once: " + p.getMaas()))
                .map(p -> p.getMaas() * 2 + " TL")
                .peek(s -> System.out.println("Zamdan sonra: " + s))
                .collect(Collectors.toSet());

        //Collectors.joining(): Birlestirme islemi yapar
        List<String> kelimeler = List.of("Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar");
        String yeniHal = kelimeler.stream()
                .collect(Collectors.joining("-"));

        System.out.println(yeniHal);






















    }
}
