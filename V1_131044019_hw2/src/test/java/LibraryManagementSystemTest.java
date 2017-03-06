import junit.framework.TestCase;

import java.awt.print.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by GozdeDogan on 25.02.2017.
 */
public class LibraryManagementSystemTest extends TestCase {

    public void testGetStaffs() throws Exception {
        LinkedList<Books> b = new LinkedList();
        LinkedList<Person> u = new LinkedList();
        LinkedList<Person> s = new LinkedList();
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getStaffs(), s); //esit

        LinkedList<Person> s1 = new LinkedList();
        s1.add(new Staff("-", "*"));
        s1.add(new Staff("-", "*"));
        s1.add(new Staff("-", "*"));

        assertEquals(lbs.getStaffs(), s1);//esit
    }

    public void testSetStaffs() throws Exception {
        LinkedList<Books> b = new LinkedList();
        LinkedList<Person> u = new LinkedList();
        LinkedList<Person> s = new LinkedList();
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));
        s.add(new Staff("-", "*"));

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getStaffs(), s); //esit

        LinkedList<Person> s1 = new LinkedList();
        s1.add(new Staff("-", "*"));
        s1.add(new Staff("-", "*"));
        s1.add(new Staff("-", "*"));

        lbs.setStaffs(s1);

        assertEquals(lbs.getStaffs(), s); //esit degil
        assertEquals(lbs.getStaffs(), s1); //esit

    }

    public void testGetUsers() throws Exception {
        LinkedList<Books> b = new LinkedList();
        LinkedList<Person> u = new LinkedList();
        LinkedList<Person> s = new LinkedList();
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getUsers(), u); //esit

        LinkedList<Person> s1 = new LinkedList();
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));

        assertEquals(lbs.getUsers(), s1);//esit degil
    }

    public void testSetUsers() throws Exception {
        LinkedList<Books> b = new LinkedList();
        LinkedList<Person> u = new LinkedList();
        LinkedList<Person> s = new LinkedList();
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));
        u.add(new User("-", "*"));

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getUsers(), u); //esit

        LinkedList<Person> s1 = new LinkedList();
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));
        s1.add(new User("*", "-"));

        lbs.setUsers(s1);

        assertEquals(lbs.getUsers(), s);//esit degil
        assertEquals(lbs.getUsers(), s1); //esit
    }

    public void testEquals() throws Exception {
        LinkedList<Books> b = new LinkedList();
        LinkedList<Person> u = new LinkedList();
        LinkedList<Person> s = new LinkedList();
        LinkedList<Books> b1 = new LinkedList();
        LinkedList<Person> u1 = new LinkedList();
        LinkedList<Person> s1 = new LinkedList();
        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);
        LibraryManagementSystem lbs1 = new LibraryManagementSystem(s1, u1, b1);
        LibraryManagementSystem lbs2 = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs, lbs2); //esit
        assertEquals(lbs, lbs1); //esit degil
    }

}