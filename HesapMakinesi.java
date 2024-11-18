import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HesapMakinesi {
    public static void main(String[] args) {
        boolean devam = true;
        List<String> islemGecmisi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (devam) {
            System.out.println("Hesap Makinesi\n");
            System.out.println("Yapmak istediğiniz işlemi seçin:");
            System.out.println("1. Toplama");
            System.out.println("2. Çıkarma");
            System.out.println("3. Çarpma");
            System.out.println("4. Bölme");
            System.out.println("5. Üs Alma");
            System.out.println("6. Karekök Alma");
            System.out.println("7. Ortalama Hesaplama");
            System.out.println("8. Faktoriyel Hesaplama");
            System.out.println("9. Geçmiş İşlemleri Görüntüle");
            System.out.println("Çıkmak için q'ya basın\n");

            System.out.print("Seçiminizi yapın: ");
            String secim = scanner.nextLine();

            if (secim.equalsIgnoreCase("q")) {
                devam = false;
                break;
            }

            double sonuc = 0;
            boolean gecerliIslem = true;

            switch (secim) {
                case "1":
                    System.out.print("Birinci sayıyı girin: ");
                    double sayi1 = getValidDoubleInput(scanner);

                    System.out.print("İkinci sayıyı girin: ");
                    double sayi2 = getValidDoubleInput(scanner);

                    sonuc = sayi1 + sayi2;
                    islemGecmisi.add(sayi1 + " + " + sayi2 + " = " + sonuc);
                    break;
                case "2":
                    System.out.print("Birinci sayıyı girin: ");
                    sayi1 = getValidDoubleInput(scanner);

                    System.out.print("İkinci sayıyı girin: ");
                    sayi2 = getValidDoubleInput(scanner);

                    sonuc = sayi1 - sayi2;
                    islemGecmisi.add(sayi1 + " - " + sayi2 + " = " + sonuc);
                    break;
                case "3":
                    System.out.print("Birinci sayıyı girin: ");
                    sayi1 = getValidDoubleInput(scanner);

                    System.out.print("İkinci sayıyı girin: ");
                    sayi2 = getValidDoubleInput(scanner);

                    sonuc = sayi1 * sayi2;
                    islemGecmisi.add(sayi1 + " * " + sayi2 + " = " + sonuc);
                    break;
                case "4":
                    System.out.print("Birinci sayıyı girin: ");
                    sayi1 = getValidDoubleInput(scanner);

                    System.out.print("İkinci sayıyı girin: ");
                    sayi2 = getValidDoubleInput(scanner);

                    if (sayi2 != 0) {
                        sonuc = sayi1 / sayi2;
                        islemGecmisi.add(sayi1 + " / " + sayi2 + " = " + sonuc);
                    } else {
                        System.out.println("Hata: Bir sayı sıfıra bölünemez.\n");
                        gecerliIslem = false;
                    }
                    break;
                case "5":
                    System.out.print("Taban sayıyı girin: ");
                    sayi1 = getValidDoubleInput(scanner);

                    System.out.print("Üös değerini girin: ");
                    double us = getValidDoubleInput(scanner);

                    sonuc = Math.pow(sayi1, us);
                    islemGecmisi.add(sayi1 + " ^ " + us + " = " + sonuc);
                    break;
                case "6":
                    System.out.print("Sayıyı girin: ");
                    sayi1 = getValidDoubleInput(scanner);

                    if (sayi1 >= 0) {
                        sonuc = Math.sqrt(sayi1);
                        islemGecmisi.add("\u221A" + sayi1 + " = " + sonuc);
                    } else {
                        System.out.println("Hata: Negatif bir sayının karekökü alınamaz.\n");
                        gecerliIslem = false;
                    }
                    break;
                case "7":
                    System.out.print("Kaç sayı gireceksiniz?: ");
                    int adet = (int) getValidDoubleInput(scanner);
                    double toplam = 0;

                    for (int i = 1; i <= adet; i++) {
                        System.out.print(i + ". sayıyı girin: ");
                        toplam += getValidDoubleInput(scanner);
                    }

                    sonuc = toplam / adet;
                    islemGecmisi.add("Girilen " + adet + " sayının ortalaması = " + sonuc);
                    break;
                case "8":
                    System.out.print("Faktoriyelini almak istediğiniz sayıyı girin: ");
                    int faktoriyelSayisi = (int) getValidDoubleInput(scanner);
                    sonuc = 1;

                    for (int i = 1; i <= faktoriyelSayisi; i++) {
                        sonuc *= i;
                    }

                    islemGecmisi.add(faktoriyelSayisi + "! = " + sonuc);
                    break;
                case "9":
                    System.out.println("Geçmiş İşlemler:");
                    for (String islem : islemGecmisi) {
                        System.out.println(islem);
                    }
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1-9 arasında bir seçim yapın.\n");
                    gecerliIslem = false;
                    break;
            }

            if (gecerliIslem && !secim.equals("9")) {
                System.out.println("Sonuç: " + sonuc + "\n");
            }
        }

        System.out.println("Programdan çıkılıyor. Görüşürüz!");
        scanner.close();
    }

    private static double getValidDoubleInput(Scanner scanner) {
        while (true) {
            String giris = scanner.nextLine();
            try {
                return Double.parseDouble(giris);
            } catch (NumberFormatException e) {
                System.out.print("Hata: Geçerli bir sayı girin: ");
            }
        }
    }
}
