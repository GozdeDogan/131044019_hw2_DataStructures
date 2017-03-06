/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *              Persons interface'ini implement eder.
 *              Attributeler burada belirlendi.
 *              Bu abstract class'i extend eden her class bu attribute'lere ulasabilir.
 *              Interface de belirtilen genel metotlar implement edildi.
 *              equals ve toString metotlari overrride edildi.
 */
public abstract class Person implements Persons{
    private String ID;
    private String password;

    public Person() {
        this.ID = new String();
        this.password = new String();
    }

    public Person(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    public String getID(){return ID;}
    public void setID(String id){
        if(id != null)
            this.ID = id;
    }

    public String getPassword(){return password;}
    public void setPassword(String pw){
        if(pw != null)
            this.password = pw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (this.getID() != null && person.getID() != null && this.getPassword() != null && person.getPassword() != null
                && getID().equals(person.getID()) && getPassword().equals(person.getPassword()) )
            return true;
        return false;
    }

    @Override
    public String toString() {
        return getID().toString() + ',' + getPassword().toString();
    }
}
