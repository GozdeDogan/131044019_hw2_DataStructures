import junit.framework.TestCase;

/**
 * Created by GozdeDogan on 25.02.2017.
 */
public class UserTest extends TestCase {

    public void testGetID() throws Exception {
        System.out.println("testGetID");
        System.out.println("For User");
        String s = new String("");
        User p = new User(s, s);
        User p1 = new User("-", s);

        String res = p.getID();
        assertEquals(s, res); //esit

        res = p1.getID();
        assertEquals(s, res); //esit degil

    }

    public void testSetID() throws Exception {
        System.out.println("testSetID");
        System.out.println("For User");
        String s = "*";
        User p = new User();

        p.setID(s);
        assertEquals(p.getID(), s); //esit

        p.setID("-");
        assertEquals(p.getID(), s); //esit degil
    }

    public void testGetPassword() throws Exception {
        System.out.println("testGetPassword");
        String s = new String("");
        User p = new User(s, s);
        User p1 = new User(s, "*");

        String res = p.getPassword();
        assertEquals(s, res); //esit

        res = p1.getPassword();
        assertEquals(s, res); //esit degil
    }

    public void testSetPassword() throws Exception {
        System.out.println("testSetPassword");
        String s = "*";
        User p = new User();

        p.setID(s);
        assertEquals(s, p.getPassword()); //esit

        p.setID("-");
        assertEquals(s, p.getPassword()); //esit degil
    }
}