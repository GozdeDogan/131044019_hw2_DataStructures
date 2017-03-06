import junit.framework.TestCase;

import java.awt.print.*;
import java.awt.print.Book;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by GozdeDogan on 25.02.2017.
 */
public class LibraryManagementSystemTest extends TestCase {

    public void testGetStaffs() throws Exception {
        Books[] b = new Books[50];
        Person[] u = new User[25];
        Person[] s = new Staff[5];
        for(int i=0; i<6; i++){
            s[i] = new Staff("-", "*");
        }

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getStaffs(), s); //esit

        Person[] s1 = new Staff[10];
        for(int i=0; i<3; i++){
            s1[i] = new Staff("-", "*");
        }

        assertEquals(lbs.getStaffs(), s1);//esit
    }

    public void testSetStaffs() throws Exception {
        Books[] b = new Books[50];
        Person[] u = new User[25];
        Person[] s = new Staff[5];
        for(int i=0; i<6; i++){
            s[i] = new Staff("-", "*");
        }

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getStaffs(), s); //esit

        Person[] s1 = new Staff[10];
        for(int i=0; i<3; i++){
            s1[i] = new Staff("-", "*");
        }

        lbs.setStaffs(s1);

        assertEquals(lbs.getStaffs(), s); //esit degil
        assertEquals(lbs.getStaffs(), s1); //esit

    }

    public void testGetUsers() throws Exception {
        Books[] b = new Books[50];
        Person[] u = new User[25];
        Person[] s = new Staff[5];
        for(int i=0; i<6; i++){
            s[i] = new Staff("-", "*");
        }

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getUsers(), u); //esit

        Person[] s1 = new Staff[10];
        for(int i=0; i<4; i++){
            s1[i] = new Staff("-", "*");
        }

        assertEquals(lbs.getUsers(), s1);//esit degil
    }

    public void testSetUsers() throws Exception {
        Books[] b = new Books[50];
        Person[] u = new User[25];
        Person[] s = new Staff[5];
        for(int i=0; i<6; i++){
            s[i] = new Staff("-", "*");
        }

        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs.getUsers(), u); //esit

        Person[] s1 = new Staff[10];
        for(int i=0; i<4; i++){
            s1[i] = new Staff("-", "*");
        }

        lbs.setUsers(s1);

        assertEquals(lbs.getUsers(), s);//esit degil
        assertEquals(lbs.getUsers(), s1); //esit
    }

    public void testReallocate() throws Exception {
        LibraryManagementSystem lbs = new LibraryManagementSystem();
        Person[] s = new Staff[10];
        for(int i=0; i<5; i++){
            s[i] = new Staff("-", "*");
        } //LibraryManagementSystem de capacity 5000 oldugu icin 5005 yukleme yaptim

        lbs.setStaffs(s);

        assertEquals(lbs.getCapacity(), s.length); //esit
    }

    public void testEquals() throws Exception {
        Books[] b = new Books[50];
        Person[] u = new User[25];
        Person[] s = new Staff[5];
        Books[] b1 = new Books[50];
        Person[] u1 = new User[25];
        Person[] s1 = new Staff[5];
        LibraryManagementSystem lbs = new LibraryManagementSystem(s, u, b);
        LibraryManagementSystem lbs1 = new LibraryManagementSystem(s1, u1, b1);
        LibraryManagementSystem lbs2 = new LibraryManagementSystem(s, u, b);

        assertEquals(lbs, lbs2); //esit
        assertEquals(lbs, lbs1); //esit degil
    }

}