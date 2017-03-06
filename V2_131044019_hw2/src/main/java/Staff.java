import java.util.ArrayList;

/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *              abstract class da belirtilen attribute'leri kullanir ve
 *              yine abstract class da implement edilen genel metotlar burada da abstract classs metotlari
 *              kullanilarak implement edildi.
 *              Library system icin tutulacak her bir staff icin olusturulmus class
 */
public class Staff extends Person{

    public Staff() {
        super();
    }

    public Staff(String ID, String password) {
        super(ID, password);
    }

    public String getID(){return super.getID();}
    public void setID(String id){
        if(id != null)
            super.setID(id);
    }

    public String getPassword(){return super.getPassword();}
    public void setPassword(String pw){
        if(pw != null)
            super.setPassword(pw);
    }


}
