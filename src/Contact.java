import java.util.ArrayList;

class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(int id, String name, String phoneNumber) {
        return new Contact(id, name, phoneNumber);
    }

    ArrayList<String> contactList = new ArrayList<String>();

    public ArrayList<String> getContactList() {
        return contactList;
    }

    public void storeContacts(String names) {
        contactList.add(names);
    }

    public void printContactList() {
        System.out.println("Kamu punya " + contactList.size() + " Kontak di daftar Anda.");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(i + " - " + contactList.get(i));
        }
    }

}