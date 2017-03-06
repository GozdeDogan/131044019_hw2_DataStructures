/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *              BookInterface interface'ini implement eder.
 *              Attributeler burada belirlendi.
 *              Bu abstract class'i extend eden her class bu attribute'lere ulasabilir.
 *              Interface de belirtilen genel metotlar implement edildi.
 *              equals ve toString metotlari overrride edildi.
 */
public abstract class Books implements BookInterface {
    private String bookName;
    private String writerName;
    private String bookState;

    public Books(String writerName, String bookName, String bookState) {
        this.writerName = new String(writerName);
        this.bookName = new String(bookName);
        this.bookState = new String(bookState);
    }

    public Books() {
        bookName = new String();
        writerName = new String();
        bookState = new String();
    }

    public String getBookName(){
        return bookName;
    }
    public String getWriterName(){
        return writerName;
    }

    public String getBookState(){
        return bookState;
    }

    public void setBookName(String bn){
        if(bn != null)
            this.bookName = bn;
    }
    public void setWriterName(String wn){
        if(wn != null)
            this.writerName = wn;
    }
    public void setBookState(String bs){
        if(bs != null)
            this.bookState = bs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (bookName != null ? !bookName.equals(books.bookName) : books.bookName != null) return false;
        if (writerName != null ? !writerName.equals(books.writerName) : books.writerName != null) return false;
        return !(bookState != null ? !bookState.equals(books.bookState) : books.bookState != null);

    }


    @Override
    public String toString() {
        return getBookName().toString() + ',' + getWriterName().toString();
    }
}
