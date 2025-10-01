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
        int puan = sayiAdedi * hedefOrt; // sayıların olması gerekn toplam değeri
        int sayilarinToplami = 0;

        System.out.println("ORTLAMA : " + hedefOrt);
        System.out.println("Sayı Adedi : " + sayiAdedi);

        if (hedefOrt == 100 || hedefOrt == 0) { // uç değerler neyse o kadar sayı üretecek
            for (int i = 0; i < sayiAdedi; i++) {
                System.out.print(hedefOrt + " ");
            }
            System.out.println("TOPLAM : " + (puan));
            return;
        }

        do { //  iki koşula aynı anda bakmam da gerekiyor UNUTMA
            if (100 * (sayiAdedi - 1) < puan && puan <= sayiAdedi * 100) {  // min değer koşulu  HATAA
                minDeger = puan - (100 * (sayiAdedi - 1));
            }

            if (puan <= 100 + sayiAdedi - 1) { // max değer koşulu
                maxDeger = puan - ((sayiAdedi - 1));
            }

            randomSayi = (int) (Math.random() * (maxDeger - minDeger + 1) + minDeger);  // min max arası üretilecek sayı
            System.out.println(randomSayi);

            sayilarinToplami += randomSayi;
            puan -= randomSayi;
            sayiAdedi--;
            minDeger = 0;
            maxDeger = 100;

        } while (sayiAdedi != 1);
        System.out.println(puan);
        System.out.println("TOPLAM : " + (sayilarinToplami + puan));
    }
}
