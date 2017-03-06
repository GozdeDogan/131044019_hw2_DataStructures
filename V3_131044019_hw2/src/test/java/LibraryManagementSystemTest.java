import junit.framework.TestCase;

import java.awt.print.*;
import java.awt.print.Book;
import java.util.ArrayList;

/**
 * Created by GozdeDogan on 25.02.2017.
 */
public class LibraryManagementSystemTest extends TestCase {

    public void testGetStaffs() throws Exception {
        ArrayList<Books> b = new ArrayList(50);
        ArrayList<Person> u = new ArrayList(25);
        ArrayList<Person> s = new ArrayList(5);
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getStaffs(), s); //esit

        ArrayList<Person> s1 = new ArrayList(10);
        s1.add(new Staff("-", "*"));
        s1.add(new Staff("-", "*"));
        s1.add(new Staff("-", "*"));

        assertEquals(lbs.getStaffs(), s1);//esit
    }

    public void testSetStaffs() throws Exception {
        ArrayList<Books> b = new ArrayList(50);
        ArrayList<Person> u = new ArrayList(25);
        ArrayList<Person> s = new ArrayList(5);
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getStaffs(), s); //esit

        ArrayList<Person> s1 = new ArrayList(10);
        s1.add(new Staff("-", "*"));
        s1.add(new Staff("-", "*"));
        s1.add(new Staff("-", "*"));

        lbs.setStaffs(s1);

        assertEquals(lbs.getStaffs(), s); //esit degil
        assertEquals(lbs.getStaffs(), s1); //esit

    }

    public void testGetUsers() throws Exception {
        ArrayList<Books> b = new ArrayList(50);
        ArrayList<Person> u = new ArrayList(25);
        ArrayList<Person> s = new ArrayList(5);
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getUsers(), u); //esit

        ArrayList<Person> s1 = new ArrayList(10);
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));

        assertEquals(lbs.getUsers(), s1);//esit degil
    }

    public void testSetUsers() throws Exception {
        ArrayList<Books> b = new ArrayList(50);
        ArrayList<Person> u = new ArrayList(25);
        ArrayList<Person> s = new ArrayList(5);
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getUsers(), u); //esit

        ArrayList<Person> s1 = new ArrayList(10);
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));

        lbs.setUsers(s1);

        assertEquals(lbs.getUsers(), s);//esit degil
        assertEquals(lbs.getUsers(), s1); //esit
    }

    public void testReallocate() throws Exception {
        LibraryManagementSystem lbs = new LibraryManagementSystem();
        ArrayList<Person> s = new ArrayList();
        for(int i=0; i<5005; i++){
            s.add(new Staff());
        } //LibraryManagementSystem de capacity 5000 oldugu icin 5005 yukleme yaptim

        lbs.setStaffs(s);

        assertEquals(lbs.getCapacity(), s.size()); //esit
    }

    public void testEquals() throws Exception {
        ArrayList<Person> s = new ArrayList();
        ArrayList<Person> u = new ArrayList();
        ArrayList<Books> b = new ArrayList();
        ArrayList<Person> s1 = new ArrayList();
        ArrayList<Person> u1 = new ArrayList();
        ArrayList<Books> b1 = new ArrayList();
        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);
        LibraryManagementSystem lbs1 = new LibraryManagementSystem(s1, u1, b1);
        LibraryManagementSystem lbs2 = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs, lbs2); //esit
        assertEquals(lbs, lbs1); //esit degil
    }

}