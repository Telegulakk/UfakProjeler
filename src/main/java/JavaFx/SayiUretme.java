package JavaFx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// seçtiğimiz ortalamaya ve adede uygun şekilde 1-100 arası random sayılar üreten uygulama
public class SayiUretme {
    Scanner scanner = new Scanner(System.in);

    private int kullanicidanOrtalamaAl() {
        int hedefOrt;
        do {
            System.out.print("1-100 arasında istenen ortalamayı belirtin: ");
            String input = scanner.nextLine().trim(); // trim() boşlukları temizler

            if (input.isEmpty()) {
                System.out.println("Boş giriş yapılamaz!");
                continue;
            }

            if (input.matches("\\d+")) {  // sadece rakamlardan oluşmalı
                hedefOrt = Integer.parseInt(input);

                if (hedefOrt >= 1 && hedefOrt <= 100) {
                    break;
                } else {
                    System.out.println("Geçersiz giriş!");
                }
            } else {
                System.out.println("Geçersiz giriş!");
            }

        } while (true);
        return hedefOrt;
    }

    private int kullanicidanSayiAdediAl() {
        int sayiAdedi;
        do {
            System.out.print("İstenilen Sayı Adedini Giriniz");
            String input = scanner.nextLine().trim(); // boşlukları temizle

            if (input.isEmpty()) {
                System.out.println("Boş giriş yapılamaz!");
                continue;
            }

            if (input.matches("\\d+")) { // sadece rakamlardan oluşmalı
                sayiAdedi = Integer.parseInt(input);

                if (sayiAdedi > 0) {
                    break;
                } else {
                    System.out.println("Geçersiz giriş!");
                }
            } else {
                System.out.println("Geçersiz giriş!");
            }

        } while (true);
        return sayiAdedi;
    }

    public List<Integer> sayilariUret() {
        List<Integer> sayilar = new ArrayList<>();
        int hedefOrt = kullanicidanOrtalamaAl();   // private metodlara bu şekilde eriştik
        int sayiAdedi = kullanicidanSayiAdediAl();
        int minDeger = 1;
        int maxDeger = 100;
        int puan = sayiAdedi * hedefOrt;

        while (sayiAdedi > 1) {
            if (100 * (sayiAdedi - 1) < puan && puan <= sayiAdedi * 100) {  // min değer koşulu
                minDeger = puan - (100 * (sayiAdedi - 1));
            }

            if (puan <= 100 + sayiAdedi - 1) {   // max değer koşulu
                maxDeger = puan - (sayiAdedi - 1);
            }

            int randomSayi = (int) (Math.random() * (maxDeger - minDeger + 1) + minDeger);
            sayilar.add(randomSayi); // sayılar Liste ekleniyor. En son Listi direkt yazdırıcaz

            puan -= randomSayi;
            sayiAdedi--;

            minDeger = 1;
            maxDeger = 100;
        }
        // Son sayı (puanı sıfıra indirecek olan)
        sayilar.add(puan);

        return sayilar;
    }

    public void sonucuYazdir(List<Integer> sayilar) {
        Collections.shuffle(sayilar); // Sayıları Karıştırdık
        System.out.println("Üretilen sayılar: ");
        System.out.print(sayilar + ", ");
        int toplam = 0;
        for (int s : sayilar) toplam += s;
        System.out.println();
        System.out.println("Toplam: " + toplam);
        System.out.println("Ortalama: " + (toplam / sayilar.size()));
    }

    public static void main(String[] args) {
        SayiUretme s = new SayiUretme();
        s.sonucuYazdir(s.sayilariUret());
    }

}
