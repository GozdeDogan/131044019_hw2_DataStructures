/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *              abstract class da belirtilen attribute'leri kullanir ve
 *              yine abstract class da implement edilen genel metotlar burada da abstract classs metotlari
 *              kullanilarak implement edildi.
 *              Library system icin tutulacak her bir kitap icin olusturulmus class
 */
public class Book extends Books{

    public Book() {
        super();
    }

    public Book(String writerName, String bookName, String bookState) {
        super(writerName, bookName, bookState);
    }

    public String getBookName(){
        return super.getBookName();
    }
    public String getWriterName(){
        return super.getWriterName();
    }

    public String getBookState(){
        return super.getBookState();
    }

    public void setBookName(String bn){
        if(bn != null)
            super.setBookName(bn);
    }
    public void setWriterName(String wn){
        if(wn != null)
            super.setWriterName(wn);
    }
    public void setBookState(String bs){
        if(bs != null)
            super.setBookState(bs);
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
