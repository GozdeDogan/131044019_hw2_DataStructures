import java.util.ArrayList;

/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *              abstract class da belirtilen attribute'leri kullanir ve
 *              yine abstract class da implement edilen genel metotlar burada da abstract classs metotlari
 *              kullanilarak implement edildi.
 *              Library system icin tutulacak her bir user icin olusturulmus class
 */
public class User extends Person {
    /**
     * no-parameter constructor
     */
    public User() {
        super();
    }

    /**
     * two-parameter constructor
     * @param ID
     * @param password
     */
    public User(String ID, String password) {
        super(ID, password);
    }

    /**
     * one-parameter constructor.
     * Bu contructor kendi tipinden bir tane eleman alir ve onu kendisine set eder
     * @param user
     */
    public User(User user){
        super(user.getID(), user.getPassword());
    }

    public String getID(){return super.getID();}
    public void setID(String id){
        if(id != null)
            super.setID(id);
    }

    public String getPassword(){return super.getPassword();}
    public void setPassword(String pw) {
        if (pw != null)
            super.setPassword(pw);
    }
}
