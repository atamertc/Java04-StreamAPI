package com.atamertc.aksam.streamOrnek2;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/*
 * 1-Şehir sınıfımız olacak ==> isim plakakodu nufus
 * uygulma sınıfında sehirleri olustur diye bir metodumuz olsun 
 * bu metot iller arrayındeki sehirleri alarak herbirinden birer şehir nesnesi yaratalım
 * ve bunları bir listeye ekleyelim 
 * sehir sınıfında bir metot olsun plak kodlarını bizim için olustursun 
 * ornek==> 01,02......08,09,10,11
 * 
 * 2- Dışardan girilen harfle başlayan illeri donduren bir metot yazalım 
 * 
 * 3- nufusa göre sıralama kucukten buyuge
 * 4- isme gore bir sıralama yapalım 
 * 5-Listemin son 10 değerini isme gore sıralasın
 * 6- Comparable kullanarak plakaya gore sırala
 * 
 */
public class Uygulama {

	ArrayList<Sehir> sehirler = new ArrayList<>();

	public Uygulama() {
		sehirleriOlustur();
	}

	public static void main(String[] args) {

		Uygulama uygulama = new Uygulama();
		//uygulama.sehirler.forEach(System.out::println);
		//nufusu 1 milyondan az olan sehirleri getiren stream yapisi
		uygulama.sehirler.stream()
				.filter(x -> x.getNufus() < 1000000)
				.forEach(System.out::println);

		System.out.println("********************************************");
		//plaka kodlarini integer bir listede tutalim
		List<Integer> plakas = uygulama.sehirler.stream()
				.map(x -> Integer.parseInt(x.getPlaka()))
				.collect(Collectors.toList());
		plakas.forEach(System.out::println);

		System.out.println("********************************************");
		//bolgelere gore sehirleri mapleyelim
		Map<String, List<Sehir>> bolgeMap = uygulama.sehirler.stream()
				.collect(Collectors.groupingBy(Sehir::getBolge));
		bolgeMap.entrySet().stream().forEach(System.out::println);

		//sehirin plaka koduna karsilik sehrin ismi gelsin
		Map<Integer, String> map = uygulama.sehirler.stream()
				.collect(Collectors.toMap(x -> Integer.parseInt(x.getPlaka()), y -> y.getIsim()));
//		map.forEach((x,y)-> System.out.println(x+" - "+y));
		map.entrySet().stream().forEach(System.out::println);
	}

	public void sehirleriOlustur() {
		Random random = new Random();
		for (int i = 0; i < SehirDatabase.iller.length; i++) {
			String sehirIsım = SehirDatabase.iller[i];
			Sehir sehir = new Sehir(sehirIsım, i);
			sehir.setBolge(random.nextInt(1,4)+" .bolge");
			// sehir.setPlaka(sehir.plakaKoduUret(i));
			sehirler.add(sehir);
		}
	}

	public ArrayList<Sehir> sehirBul() {
		ArrayList<Sehir> sehirListesi = new ArrayList<>();
		System.out.println("Bulmak istediğiniz şehirlerin baş harfini giriniz");
		Scanner scanner = new Scanner(System.in);
		String harf = scanner.nextLine().toUpperCase();

		for (int i = 0; i < sehirler.size(); i++) {
			if (sehirler.get(i).getIsim().startsWith((harf.charAt(0) + ""))) {
				sehirListesi.add(sehirler.get(i));
			}
		}
		return sehirListesi;
	}

	public ArrayList<Sehir> nufusSırala(ArrayList<Sehir> liste) {

		Comparator<Sehir> comparator = new Comparator<Sehir>() {

			@Override
			public int compare(Sehir o1, Sehir o2) {
				return o1.getNufus() - o2.getNufus();
			}

		};

		Collections.sort(liste, comparator);

		return liste;

	}

	public List<Sehir> ismeGoreSirala(List<Sehir> liste) {
		Collator collator = Collator.getInstance(); // Türkçe karakter sorununu aşmak için kullandığımız bir sınıf

		Comparator<Sehir> comparator = new Comparator<Sehir>() {

			@Override
			public int compare(Sehir o1, Sehir o2) {
				return collator.compare(o1.getIsim(), o2.getIsim());
			}

		};

		Collections.sort(liste, comparator);

		return liste;
	}

}
