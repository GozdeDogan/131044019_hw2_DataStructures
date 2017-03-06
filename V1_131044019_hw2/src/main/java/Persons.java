/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *              Kutuphane de farkli tiplerde kullanicilar olabilir.
 *              Ama hepsi bir ID ve bir password'e sahip olamk zorundadýr.
 */
public interface Persons {
    public String getID();
    public String getPassword();
    public void setID(String id);
    public void setPassword(String Pass);
}
