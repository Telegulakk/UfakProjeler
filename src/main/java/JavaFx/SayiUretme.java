package JavaFx;

import java.util.Scanner;

// seçtiğimiz ortalamaya göre random sayı üreten uygulama
// sayılar 1-100 arası ikisi de dahil olmak üsere üretilecek
public class SayiUretme {
    Scanner scanner = new Scanner(System.in);

    public void randomSayilarUret() {
        System.out.println("istenen ortalamayı belirtin");
        int hedefOrt = scanner.nextInt();   // istenilen ortalama
        System.out.println("kaç sayı olacak ?");
        int sayiAdedi = scanner.nextInt();  // kullanılacak sayı adedi
        scanner.close();

        int randomSayi;  // o anlık üretilecek random sayımız
        int minDeger = 1;
        int maxDeger = 100;
        int puan = sayiAdedi * hedefOrt; // sayıların toplam değeri. Amaç son sayı ile bunu sıfıra indirebilmek
        int sayilarinToplami = 0;

        System.out.println("ORTLAMA : " + hedefOrt);
        System.out.println("Sayı Adedi : " + sayiAdedi);

        do { //  iki koşula aynı anda bakmam da gerekiyor UNUTMA
            if (100 * (sayiAdedi - 1) < puan && puan <= sayiAdedi * 100) {  // min değer koşulu
                minDeger = puan - (100 * (sayiAdedi - 1));
            }

            if (puan <= 100 + sayiAdedi - 1) { // max değer koşulu
                maxDeger = puan - ((sayiAdedi - 1));
            }

            randomSayi = (int) (Math.random() * (maxDeger - minDeger + 1) + minDeger);  // min ve  max arası üretilecek sayı aralığı
            System.out.println(randomSayi);

            // bir sonraki tur için gerekli değişikler
            sayilarinToplami += randomSayi;
            puan -= randomSayi;
            sayiAdedi--;
            minDeger = 1;
            maxDeger = 100;

        } while (sayiAdedi != 1);  // son sayı için random sayı üretmek yerine puanı 0'a indirecek o değeri yazarız ki ortalama tutsun
        System.out.println(puan);
        System.out.println("ÜRETİLEN SAYILARIN TOPLAMI : " + (sayilarinToplami + puan)); // toplamlarının ortalama x sayı adedine eşit olduğunu kontrol etmen için
    }
}
