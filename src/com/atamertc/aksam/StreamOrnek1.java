package com.atamertc.aksam;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOrnek1 {

    public static void main(String[] args) {

        List<String> aylar = new ArrayList<>(List.of("Ocak", "Subat", "Mart", "Nisan", "Mayis","Haziran","Temmuz"));

        List<Integer> sayilar = Arrays.asList(1, 2, 3, 4, 5);
        //foreach
        aylar.stream()
                .forEach(x -> System.out.println(x.toLowerCase()));

        System.out.println("********************************************");
        aylar.stream()
                .forEach(x -> {
                    x = x.substring(0, 3);
                    x = "-" + x;
                    System.out.println(x);
                });

        System.out.println("********************************************");
        //map
        aylar.stream()
                .map(x -> x.toLowerCase())
                .forEach(System.out::println);

        System.out.println("********************************************");
        aylar.stream()
                .map(x -> {
                    x = x.substring(0, 3);
                    x = "-" + x;
                    return x;
                }).forEach(System.out::println);

        System.out.println("********************************************");
        List<String> liste = aylar.stream()
                .map(x -> {
                    x = x.substring(0, 3);
                    x = "-" + x;
                    return x;
                }).collect(Collectors.toList());
        liste.forEach(System.out::println);

        System.out.println("********************************************");
        List<String> stringList = sayilar.stream()
                .map(x -> "-" + x).collect(Collectors.toList());
        stringList.forEach(System.out::println);

        //filter
        System.out.println("********************************************");
        aylar.stream()
                .filter(x -> x.startsWith("M"))
                .forEach(System.out::println);

        System.out.println("********************************************");
        List<String> liste2 = aylar.stream()
                .filter(x -> x.startsWith("O"))
                .collect(Collectors.toList());
        liste2.forEach(System.out::println);

        System.out.println("********************************************");
        List<Integer> liste3 = sayilar.stream()
                .filter(x -> x > 2)
                .collect(Collectors.toList());
        liste3.forEach(System.out::println);
        //mutlaka collectiona giren listenin turunde dondurur

        System.out.println("********************************************");
        List<String> liste4 = sayilar.stream()
                .filter(x -> x > 2)
                .map(y->"-" + y)
                .collect(Collectors.toList());
        liste4.forEach(System.out::println);

        Map<String, Integer> map = aylar.stream()
                .collect(Collectors.toMap(k -> k, v -> v.length()));

        Map<Integer, List<String>> map2 = aylar.stream()
                .collect(Collectors.groupingBy(String::length));

        map2.entrySet().stream().forEach(System.out::println);













    }
}
