import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ContactList contactList;
    private static User user = new User();

    public static void main(String[] args) {
        boolean login, run;
        int pilMenu;
        int id;
        String nama, username, password, phoneNumber;

        while (true) {
            login = false;
            System.out.println("Book Phone");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilMenu = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\n");

            if (pilMenu == 1) {
                System.out.print("Masukkan ID: ");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan nama: ");
                nama = scanner.nextLine();
                System.out.print("Masukkan username: ");
                username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                password = scanner.nextLine();
                // melakukan cek saat login
                if (user.checkUser(id, nama, username, password)) {
                    login = true;
                } else
                    System.out.println("Gagal login!\n");
            } else if (pilMenu == 2) {
                System.out.print("Masukkan ID user: ");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan nama: ");
                nama = scanner.nextLine();
                System.out.print("Masukkan username: ");
                username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                password = scanner.nextLine();
                user.setUser(id, nama, username, password);
                System.out.print("Masukkan nomor telpon Anda: ");
                phoneNumber = scanner.nextLine();
                contactList = new ContactList(id, nama, phoneNumber);
                login = true;
            } else {
                break;
            }

            if (login) {
                run = true;
                while (run) {
                    printAction();
                    System.out.println("\nPilihan: (1 - 6)");
                    int action = scanner.nextInt();
                    scanner.nextLine();

                    switch (action) {
                        case 0:
                            System.out.println("\nKeluar dari aplikasi..");
                            run = false;
                            login = false;
                            break;

                        case 1:
                            contactList.printContacts();
                            break;

                        case 2:
                            addNewContact();
                            break;

                        case 3:
                            updateContact();
                            break;
                        case 4:
                            removeContact();
                            break;
                        case 5:
                            queryContact();
                            break;
                    }
                }
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Masukan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Masukan Nama: ");
        String name = scanner.nextLine();
        System.out.println("Masukan Nomer: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(id, name, phone);
        if (contactList.addNewContact(newContact)) {
            System.out.println("Kontak baru ditambah: nama = " + name + " , phone" + phone);
        } else {
            System.out.println("Tidak dapat menambahkan, " + name + " tersedia dalam file");
        }
    }

    private static void updateContact() {
        System.out.println("Masukkan nama kontak yang ada : ");
        String name = scanner.nextLine();
        Contact extContact = contactList.queryContact(name);
        if (extContact == null) {
            System.out.println("Tidak dapat menemukan");
            return;
        }

        System.out.println("Masukan ID: ");
        int newId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Masukan Nama: ");
        String newName = scanner.nextLine();
        System.out.println("Masukan Nomer: ");
        String newNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(newId, newName, newNumber);
        if (contactList.updateContact(extContact, newContact)) {
            System.out.println("Successfull updated");
        } else {
            System.out.println("Error Updating Contact");
        }
    }

    private static void removeContact() {
        System.out.println("Masukkan nama kontak yang ada : ");
        String name = scanner.nextLine();
        Contact extContact = contactList.queryContact(name);
        if (extContact == null) {
            System.out.println("Tidak dapat menemukan");
            return;
        }

        if (contactList.removeContact(extContact)) {
            System.out.println("Successfull deleted");
        } else {
            System.out.println("Error Deleting Contact");
        }
    }

    private static void queryContact() {
        System.out.println("Masukkan nama kontak yang ada : ");
        String name = scanner.nextLine();
        Contact extContact = contactList.queryContact(name);
        if (extContact == null) {
            System.out.println("Tidak dapat menemukan");
            return;
        }

        System.out.println("Nama : " + extContact.getName() +
                " Phone : " + extContact.getPhoneNumber());
    }

    private static void printAction() {
        System.out.println("\nPilihan:");
        System.out.println("0. Keluar\n" +
                "1. print Contact\n" +
                "2. Tambah kontak\n" +
                "3. Update kontak\n" +
                "4. Hapus kontak \n" +
                "5. Melihat kontak yang tersedia\n" +
                "6. Print List.");
        System.out.println("Pilih: ");
    }

}