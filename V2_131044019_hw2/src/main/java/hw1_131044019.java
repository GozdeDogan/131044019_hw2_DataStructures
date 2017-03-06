/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *              main dosyasi.
 *              Programi calistiran ana yer!
 */
public class hw1_131044019 {
    public static void main(String[] args) {
        try {
            System.out.println("Usage>>>\nEkrana gelen menuden bir secim yapin. \n" +
                    "(Menude belirtilen islem basindaki sayilari yazacaksiniz)\n" +
                    "Dogru secim yaparsaniz gerekli islem yapilir.\n" +
                    "Yanlis secimde yeni secim yapilmasi beklenir.\n" +
                    "Menuler sunuldugunda sayi girilmesi beklenir.\n" +
                    "Kitap adi, yazari, ID, password gibi seyler istendiginde ise string girilmesi beklenir!\n" +
                    "Buyuk-Kucuk harf duyarli, (Mesela -> Zor != ZOR)");

            /**Kutuphane sistemi olusturulur ve giris yapilmasi beklenilir*/
            LibraryManagementSystem librarySystem = new LibraryManagementSystem();
            librarySystem.showMenu();
        }catch (Exception e){

        }
    }
}
