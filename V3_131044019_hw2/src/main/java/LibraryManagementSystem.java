import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created and implemented by GozdeDogan on 23.02.2017.
 *
 * Description:
 *
 */
public class LibraryManagementSystem {
    private ArrayList<Person> staffs;
    private ArrayList<Person> users;
    private ArrayList<Books> books;
    private int capacity = 5000;
    private String fileName = "records.txt";

    /**
     * No-parameter constructor
     */
    public LibraryManagementSystem() {
        staffs = new ArrayList(capacity);
        users = new ArrayList(capacity);
        books = new ArrayList(capacity);
    }

    /**
     * three-parameter constructor
     * @param staffs
     * @param users
     * @param books
     */
    public LibraryManagementSystem(ArrayList<Person> staffs, ArrayList<Person> users, ArrayList<Books> books) {
        this.staffs.addAll(staffs);
        this.users.addAll(users);
        this.books.addAll(books);
    }

    /**
     * @return
     */
    public ArrayList<Person> getStaffs() {
        return staffs;
    }

    /**
     * @param staffs
     */
    public void setStaffs(ArrayList<Person> staffs) {
        this.staffs.addAll(staffs);
    }

    /**
     * @return
     */
    public ArrayList<Person> getUsers() {
        return users;
    }

    /**
     * @param users
     */
    public void setUsers(ArrayList<Person> users) {
        this.users.addAll(users);
    }

    /**
     * @return
     */
    public ArrayList<Books> getBooks() {
        return books;
    }

    /**
     * @param books
     */
    public void setBooks(ArrayList<Books> books) {
        this.books.addAll(books);
    }

    /**
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Arraylist parametresi bir ArrayList objesine kopyalanir.
     * parametrenin kapasitesi arttirilir
     * ve kopyalanan arrayden tekrar parametreye kopyalanir.
     * Bu parametre kapasitesi arttirilmis sekilde return edilir.
     * @param list kapasitesi arttirilacak ArrayList parametresi
     * @return -> kapasitesi arttirrilan ArrayList parametresi return edilir.
     */
    public ArrayList reallocate(ArrayList list){
        ArrayList tempList = new ArrayList(getCapacity());
        tempList.addAll(list);

        setCapacity(getCapacity() * 2);

        tempList = new ArrayList(getCapacity());
        list.addAll(tempList);

        return list;
    }

    /**
     * "records.csv" dosyasindaki veriler tiplerine gore (user, staff or book)
     * ait olduklari ArrayList attribute'lerine eklenir.
     * ArrayList'e ekleme yapilirken ayrilan kapasite yetersiz gelince reallocate metodu ile
     * list'in kapasitesi arttrilir.
     */
    private void readFileAndFillArrays(){
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp = new String("");
            while((line = bufferedReader.readLine()) != null) {
                StringTokenizer tok = new StringTokenizer(line, ",");
                while (tok.hasMoreElements()) { /**Her satir ait oldugu arraye eklenir.*/
                    temp = (String)tok.nextElement();
                    Person tempp;
                    Books tempb;
                    if (temp.equals("s")) {
                        if (staffs.size() >= getCapacity())
                            reallocate(staffs);
                        tempp = new Staff();
                        tempp.setID(((String) tok.nextElement()));
                        tempp.setPassword(((String) tok.nextElement()));
                        staffs.add(tempp);

                    } else if (temp.equals("u")) {
                        if (users.size() >= getCapacity())
                            reallocate(users);
                        tempp = new User();
                        tempp.setID((String) tok.nextElement());
                        tempp.setPassword((String) tok.nextElement());
                        users.add(tempp);

                    } else if (temp.equals("b")) {
                        if (books.size() >= getCapacity())
                            reallocate(books);
                        tempb = new Book();
                        tempb.setBookName(((String) tok.nextElement()));
                        tempb.setWriterName(((String) tok.nextElement()));
                        tempb.setBookState((String) tok.nextElement());
                        books.add(tempb);

                    } else {
                        System.out.println("System has not this indicator!");
                    }
                }
            }
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    /**
     * program sonlandiginda (staff or user) cikis yaptiginda arraylerdeki degisiklikler kaybedilmesin diye
     * "recors.csv" dosyasina tekrar yazilir.
     */
    public void printToFileArrays(){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            for(int i=0; i<staffs.size(); i++) {
                bw.write("s," + staffs.get(i).toString() + "\n");
            }
            for(int i=0; i<users.size(); i++) {
                bw.write("u," + users.get(i).toString() + "\n");
            }
            for(int i=0; i<books.size(); i++) {
                bw.write("b," + books.get(i).toString() + "," + books.get(i).getBookState()+ "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * program baslatildiginda ekrana bir menu gelir. Bu metot ile o menu ekrana yazilir
     * Ve sisteme giriþ yapandan secim yapmasi beklenir.
     * Bu metot da staff ve user ayrilarak onlara ait menuler de ekrana yazilip
     * staff or user 'dan secim yapmasi beklenir.
     */
    public void showMenu() throws IOException {
        readFileAndFillArrays();
        Scanner in = new Scanner(System.in);
        int choose;
        do {
            System.out.println("MENU>>>>>>>\n1.LogIn\n2.LogOut\n");
            choose = in.nextInt();
            switch (choose) {
                case 1:
                    logIn();
                    break;
                case 2:
                    printToFileArrays();
                    System.out.println("System is shutting down!!");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Choose isn't TRUE!!! Again>>>");
            }
        }while(choose != 2);
    }

    /**
     * Kullanici giris yapar
     * Staff ya da User olma durumuna gore gerekli metotlar cagirilir
     */
    public void logIn() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Person newUser=new User();
        String tempCH = new String();
        boolean select = false;

        while(select != true) {                                     /**Var olan bir kullanici girilmedigi muddetce
         kullanicidan tekrar giris yapmasi istenir*/
            System.out.println("\nLIST OF STAFFS>>>>>");
            listArray(staffs);
            System.out.println("\nLIST OF USERS>>>>>");
            listArray(users);
            System.out.println("\n");

            do {                                                    /**Kullanici dogru bir kullanici tip (staff->s OR user->u)
             girene kadar kullanicidan tekrar input ister*/
                System.out.println("Enter user type(s or u):");
                tempCH = br.readLine();
                if (tempCH.equals("s"))
                    newUser = new Staff();
            }while(tempCH.equals("s") && tempCH.equals("u"));


            int index = -1;

            if (tempCH.equals("s")){
                do {                                                /**Kullanici dogru bir kullanici ID'si ve password
                 girene kadar kullanicidan tekrar input ister*/
                    System.out.println("Enter ID:");
                    newUser.setID(br.readLine());
                    System.out.println("Enter password:");
                    newUser.setPassword(br.readLine());

                    for (int i = 0; i < staffs.size() && select != true; i++)  /**Giris yapan kullanicinin var olan
                     kullanici olup olamdigina bakilir*/
                        if (newUser.equals(staffs.get(i))) {
                            select = true;
                            index = i;
                        }
                    if(select == true)
                        showStaffMenu();
                    else
                        System.out.println("This staff isn't in the library system! Again ");

                }while(select != true);
            }
            else if(tempCH.equals("u")){
                do {                                                    /**Kullanici dogru bir kullanici ID'si ve password
                 girene kadar kullanicidan tekrar input ister*/
                    System.out.println("Enter ID:");
                    newUser.setID(br.readLine());
                    System.out.println("Enter password:");
                    newUser.setPassword(br.readLine());

                    for (int i = 0; i < users.size() && select != true; i++) /**Giris yapan kullanicinin var olan
                     kullanici olup olamdigina bakilir*/
                        if (users.get(i).equals(newUser))
                            select = true;

                    if(select == true)
                        showUserMenu(index);
                    else
                        System.out.println("This staff isn't in the library system! Again ");

                }while(select != true);
            } else
                System.out.println("Your choice isn't true choice!");
        }
    }

    /**
     * staff icin uygun menu ekrana bastirilir.
     * staff'tan secim beklenir, secime gore gerekli islem gerceklestirilir.
     * Secim dogru olmadigi muddetce de staff'tan tekrar secim yapmasi istenir.
     */
    private void showStaffMenu() throws IOException {
        int choose = 0;
        do {
            System.out.println("\n\nMENU>>>>>\n2.AddBook\n3.AddUser\n4.RemoveBook\n5.Exit");
            Scanner in = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            choose = in.nextInt();
            switch (choose) {
                case 2:
                    boolean choice = false;
                    do {                                                /**staff sistemde bulunan kitap girdigi muddetce
                     stafftan yeni kitap adi ve yazari istemeye devam eder*/
                        choice = false;
                        System.out.println("\nLIST OF BOOKS>>>>>");
                        listArray(books);
                        System.out.println("\n");
                        Books book = new Book();
                        System.out.println("Enter bookName:");
                        book.setBookName(br.readLine());
                        System.out.println("Enter bookWriterName:");
                        book.setWriterName(br.readLine());
                        book.setBookState("e");

                        for (int i = 0; i < books.size() && choice != true; i++) {  /**Kitabin sistemde olup olmadigina bakar*/
                            if (book.equals(books.get(i)))
                                choice = true;
                        }
                        if (choice == false) {                                       /**Kitap sistemde yoksa ekler*/
                            books.add(book);
                            FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
                            fw.write("b," + book.toString() + "," + book.getBookState().toString() + "\n");
                            fw.close();
                        }
                        else
                            System.out.println("This book already exists in the library system! Again ");
                    }while(choice != false);
                    break;
                case 3:
                    choice = false;
                    do {                                                    /**staff sistemde bulunan bir user girdigi
                     muddetce stafftan yeni user Id ve password istemeye devam eder*/
                        choice = false;
                        User user = new User();
                        System.out.println("Enter user ID:");
                        user.setID(br.readLine());
                        System.out.println("Enter parola:");
                        user.setPassword(br.readLine());

                        for (int i = 0; i < users.size() && choice != true; i++) {              /**user'in sistemde olup olmadigina bakar*/
                            if (user.equals(users.get(i)))
                                choice = true;
                        }
                        if (choice == false) {
                            users.add(user); /**user sistemde yoksa ekler*/
                            FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
                            fw.write("u," + user.toString() + "\n");
                            fw.close();
                        }
                        else
                            System.out.println("This user already exists in the library system! Again ");
                    }while(choice != false);
                    break;
                case 4:                                                     /**staff'tan kaldirmak istedigi kitabi isaret
                 eden sayiyi(index) girmesi beklenir*/
                    System.out.println("\nLIST OF BOOKS>>>>>");
                    books.remove(books.get(polling(books)));                /**Girilen index dogru ise sistemden kitap cikartilir*/
                    System.out.println("\nLIST OF BOOKS>>>>>");
                    listArray(books);
                    System.out.println("\n");
                    break;
                case 5:                                                        /**exit yapildiginda arrayler tekrar dosyaya yazilir*/
                    System.out.println("\n");
                    printToFileArrays();
                    break;
                default:                                                        /**Dogru bir secim yapilmayinca hata
                 verip tekrar secim yapilmasi beklenir*/
                    System.out.println("Your choose isn't true.");
            }
        }while(choose != 5);
    }

    /**
     * user'dan secim beklenir, secime gore gerekli islem gerceklestirilir.
     * Secim dogru olmadigi muddetce de user'dan tekrar secim yapmasi istenir.
     * @param index
     */
    private void showUserMenu(int index){
        int choose = 0;
        do {                                                                /**Menuden dogru bir secim yapilana kadar beklenir*/
            System.out.println("\n\nMENU>>>>>\n2.BarrowBook\n3.ReturnBook\n4.Exit\n");
            Scanner in = new Scanner(System.in);
            choose = in.nextInt();

            switch (choose) {
                case 2:
                    System.out.println("\nLIST OF BOOKS>>>>>");
                    int i = polling(books);                                 /**userdan odunc almak istedigi kitabi isaret
                 eden sayiyi girmesi beklenir.*/
                    if(books.get(i).getBookState().equals("e")) {               /**Kitap odunc alinabilir durumda ise*/
                        books.get(i).setBookState("notE");                      /**user'a kitap odunc verilir. Kitap
                         baskalarinin odunc almasina kapatilir*/
                    }else
                        System.out.println("This book isn't eligible!");
                    break;
                case 3:
                    System.out.println("\nLIST OF BOOKS>>>>>");
                    i = polling(books);                                          /**userdan geri birakmak istedigi kitabi
                 isaret eden sayiyi girmesi beklenir.*/
                    if(books.get(i).getBookState().equals("notE")){              /**Kitap odunc alinmis durumda ise*/
                        books.get(i).setBookState("e");                         /**Kitap baskalarinin odunc almasina acilir*/
                    } else
                        System.out.println("There isn't this book in Library System!");
                    break;
                case 4:                                                         /**exit yapildiginda arrayler tekrar dosyaya yazilir*/
                    System.out.println("\n");
                    printToFileArrays();
                    break;
                default:                                                        /**Dogru bir secim yapilmayinca hata verip
                 tekrar secim yapilmasi beklenir*/
                    System.out.println("Your choose isn't true.");
            }
        }while(choose != 4);
    }

    /**
     * Verilen listedeki bir elemanin secilmesi beklenir.
     * Secim secilmek istenen elemani isaret eden sayinin girilmesi ile gerceklestirilir
     * @param list secim yapilmasi istenilen ArrayList parametresi
     * @return secim yapilan index(integer) return edilir
     */
    private int polling(ArrayList list){
        listArray(list);
        System.out.println("\n");
        Scanner in = new Scanner(System.in);
        int index = -1;
        do {                                                            /**Olmayan bir sayi girildigi muddetce tekrar sayi girilmesi beklenir*/
            System.out.println("Enter a number whose choose book>>");
            index = in.nextInt()-1;                                     /**girilen sayinin bir eksigi her zaman listedeki konumunu verir*/

            if(!(index >= 0 && index < list.size()))
                System.out.print("Your choose isn't true. Again ");
        }while (!(index >= 0 && index < list.size()));

        return index;
    }

    /**
     * verilen liste ekrana yazdirilir
     * @param list listelenmesi istenen ArrayList parametresi
     */
    private void listArray(ArrayList list){
        for(int i=0; i<list.size(); i++){
            System.out.println(i+1 + "." + list.get(i).toString());
        }
    }

    /**
     * attributelarin hepsi parametrenin attributeleri ile karsilastirilir
     * @param o karsilastirma yapilacak parametre
     * @return parametre liste de varsa true yoksa false return edilir
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryManagementSystem that = (LibraryManagementSystem) o;

        if (capacity != that.capacity) return false;
        if (staffs != null ? !staffs.equals(that.staffs) : that.staffs != null) return false;
        if (users != null ? !users.equals(that.users) : that.users != null) return false;
        return !(books != null ? !books.equals(that.books) : that.books != null);

    }

    @Override
    public String toString() {
        return "LibraryManagementSystem>>>>\n" + "staffs>>>>\n" + staffs.toString() + "\nusers>>>>\n" + users.toString() +
                "\nbooks>>>>\n" + books.toString() + "\ncapacity>" + capacity + '\n';
    }
}
