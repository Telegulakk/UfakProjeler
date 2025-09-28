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
        int minDeger;
        int maxDeger;
        int puan = sayiAdedi * hedefOrt; // sayıların olması gerekn toplam değeri
        int azamUstPuanSiniri = sayiAdedi * 100;

        System.out.println("ORTLAMA : " + hedefOrt);
        System.out.println("Sayı Adedi : " + sayiAdedi);

        if (hedefOrt == 100 || hedefOrt == 0) { // uç değerler neyse o kadar sayı üretecek
            for (int i = 0; i < sayiAdedi; i++) {
                System.out.print(hedefOrt + " ");
            }
            return;
        }

        do { //  iki koşula aynı anda bakmam da gerekiyor UNUTMA
            if (100 < puan && puan < 200) {  // min değer koşulu  HATA VAR BURDA
                minDeger = puan - 100;
                randomSayi = (int) (Math.random() * (101 - minDeger) + minDeger);
                System.out.println(randomSayi);
            } else if (puan <= 100) { // max değer koşulu
                maxDeger = puan - ((sayiAdedi - 1));
                randomSayi = (int) (Math.random() * (maxDeger + 1));
                System.out.println(randomSayi);
            } else {  // sınır değerler yoksa 1-100 arası istedği sayıyı seçebilir
                randomSayi = (int) (Math.random() * 101);
            }

            puan -= randomSayi;
            sayiAdedi--;

        } while (sayiAdedi != 1);
        System.out.print(puan);
    }
}
