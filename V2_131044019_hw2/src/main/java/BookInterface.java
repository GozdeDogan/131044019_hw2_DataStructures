/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *              Book classý için yazildi. Farklý turde kitaplar olma ihtimali icin.
 *              Ama Bu programda farklý tipte kitap kullanmadým.
 *              Genel metotlar icerir. Bu interface 'i implements eden class'lar,n rahatlýkla
 *              kullanabilecegi genellikte metotlar.
 *              Metotlar implement edilmedi.
 *              Sadece metot signature'larini vermek icin olusturulmus bir yapi oldugu icin implement edilmez.
 */
public interface BookInterface {
    public String getBookName();
    public String getWriterName();
    public String getBookState();
    public void setBookName(String bn);
    public void setWriterName(String wn);
    public void setBookState(String bs);
}
