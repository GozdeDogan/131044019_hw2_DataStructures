import junit.framework.TestCase;

/**
 * Created and implemented by GozdeDogan on 25.02.2017.
 *
 * Description:
 *              Books abstract class'ini test eder!
 */
public class BooksTest extends TestCase {

    public void testGetBookName() throws Exception {
        System.out.println("testGetBookName");
        String s = new String("");
        Book b = new Book(s, s, s);
        Book b1 = new Book("-", s, s);

        String res = b.getBookName();
        assertEquals(s, res); //esit

        res = b1.getBookName();
        assertEquals(s, res); //esit degil
    }

    public void testGetWriterName() throws Exception {
        System.out.println("testGetWriterName");
        String s = new String("");
        Book b = new Book(s, s, s);
        Book b1 = new Book(s, "-", s);

        String res = b.getWriterName();
        assertEquals(s, res); //esit

        res = b1.getWriterName();
        assertEquals(s, res); //esit degil
    }

    public void testGetBookState() throws Exception {
        System.out.println("testGetBookState");
        String s = new String("");
        Book b = new Book(s, s, s);
        Book b1 = new Book(s, s, "-");

        String res = b.getBookState();
        assertEquals(s, res); //esit

        res = b1.getBookState();
        assertEquals(s, res); //esit degil
    }

    public void testSetBookName() throws Exception {
        System.out.println("testSetBookName");
        String s = "*";
        Book b = new Book();

        b.setBookName(s);
        assertEquals(b.getBookName(), s); //esit

        b.setBookName("-");
        assertEquals(b.getBookName(), s); //esit degil
    }

    public void testSetWriterName() throws Exception {
        System.out.println("testSetWriterName");
        String s = "*";
        Book b = new Book();

        b.setWriterName(s);
        assertEquals(b.getWriterName(), s); //esit

        b.setWriterName("-");
        assertEquals(b.getWriterName(), s); //esit degil
    }

    public void testSetBookState() throws Exception {
        System.out.println("testSetBookState");
        String s = "*";
        Book b = new Book();

        b.setBookState(s);
        assertEquals(b.getBookState(), s); //esit

        b.setBookState("-");
        assertEquals(b.getBookState(), s); //esit degil
    }

    public void testEquals() throws Exception {
        System.out.println("testEquals");
        Book b1 = new Book("ZOR", "Gozde", "e");
        Book b2 = new Book("ZOR", "Gozde", "e");
        Book b3 = new Book("ZOR", "Gozde", "notE");
        Book b4 = new Book("ZOR", "Kadir", "e");
        Book b5 = new Book("Zor", "Gozde", "notE");
        Book b6 = new Book("ZOR", "Gozde", "e");

        boolean res = false;
        boolean result = b1.equals(b2); //esit
        assertEquals(res, result);
        result = b1.equals(b3); //esit
        assertEquals(res, result);
        result = b1.equals(b4); // esit degil
        assertEquals(res, result);
        result = b1.equals(b5); //esit degil
        assertEquals(res, result);
        result = b1.equals(b6); //esit
        assertEquals(res, result);
    }
}