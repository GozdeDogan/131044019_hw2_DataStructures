import junit.framework.TestCase;

/**
 * Created and implemented by GozdeDogan on 25.02.2017.
 *
 * Description:
 *              Person abstract class'ini test eder!
 */
public class PersonTest extends TestCase {

    public void testGetID() throws Exception {
        System.out.println("testGetID");
        System.out.println("For User");
        String s = new String("");
        Person p = new User(s, s);
        Person p1 = new User("-", s);

        String res = p.getID();
        assertEquals(s, res); //esit

        res = p1.getID();
        assertEquals(s, res); //esit degil

        System.out.println("For Staff");
        s = new String("");
        p = new User(s, s);
        p1 = new User("-", s);

        res = p.getID();
        assertEquals(s, res); //esit

        res = p1.getID();
        assertEquals(s, res); //esit degil
    }

    public void testSetID() throws Exception {
        System.out.println("testSetID");
        System.out.println("For User");
        String s = "*";
        Person p = new User();

        p.setID(s);
        assertEquals(p.getID(), s); //esit

        p.setID("-");
        assertEquals(p.getID(), s); //esit degil

        System.out.println("For Staff");
        p = new Staff();

        p.setID(s);
        assertEquals(p.getID(), s); //esit

        p.setID("-");
        assertEquals(p.getID(), s); //esit degil
    }

    public void testGetPassword() throws Exception {
        System.out.println("testGetPassword");
        System.out.println("For User");
        String s = new String("");
        Person p = new User(s, s);
        Person p1 = new User(s, "*");

        String res = p.getPassword();
        assertEquals(s, res); //esit

        res = p1.getPassword();
        assertEquals(s, res); //esit degil

        System.out.println("For Staff");
        s = new String("");
        p = new User(s, s);
        p1 = new User(s, "*");

        res = p.getPassword();
        assertEquals(s, res); //esit

        res = p1.getPassword();
        assertEquals(s, res); //esit degil

    }

    public void testSetPassword() throws Exception {
        System.out.println("testSetPassword");
        System.out.println("For User");
        String s = "*";
        Person p = new User();

        p.setID(s);
        assertEquals(s, p.getPassword()); //esit

        p.setID("-");
        assertEquals(s, p.getPassword()); //esit degil

        System.out.println("For Staff");
        p = new Staff();

        p.setID(s);
        assertEquals(s, p.getPassword()); //esit

        p.setID("-");
        assertEquals(s, p.getPassword()); //esit degil
    }

    public void testEquals() throws Exception {
        System.out.println("testEquals");
        System.out.println("For User");
        Person p1 = new User("ZOR", "Gozde");
        Person p2 = new User("ZOR", "Gozde");
        Person p3 = new User("ZOr", "Gozde");
        Person p4 = new User("ZOR", "ozde");

        boolean res = false;
        boolean result = p1.equals(p2); //esit
        assertEquals(res, result);
        result = p1.equals(p3); //esit degil
        assertEquals(res, result);
        result = p1.equals(p4); // esit degil
        assertEquals(res, result);

        System.out.println("For Staff");
        p1 = new Staff("ZOR", "Gozde");
        p2 = new Staff("ZOR", "Gozde");
        p3 = new Staff("ZOr", "Gozde");
        p4 = new Staff("ZOR", "ozde");

        res = false;
        result = p1.equals(p2); //esit
        assertEquals(res, result);
        result = p1.equals(p3); //esit degil
        assertEquals(res, result);
        result = p1.equals(p4); // esit degil
        assertEquals(res, result);
    }
}