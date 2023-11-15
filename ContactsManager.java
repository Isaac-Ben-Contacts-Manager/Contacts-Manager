import java.util.Scanner;

public class ContactsManager {

    public static void main(String[] args) {

        String PATH_TO_FILE = "contacts.txt";
        Scanner scanner = new Scanner(System.in);
        String userResponse;
        boolean done = false;

        ContactUtils utils = new ContactUtils(PATH_TO_FILE);

        // Display menu with choices
        while (!done) {
            System.out.println("Welcome to the Contacts Manager!\n");
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1-5).");

            userResponse = scanner.nextLine();
            switch (userResponse) {
                case "1":
                    utils.displayContacts();
                    break;
                case "2":
                    System.out.println("Enter name of new contact.");
                    String newName = scanner.nextLine();
                    System.out.println("Enter phone number of new contact.");
                    String newNumber = scanner.nextLine();
                    Contact newContact = new Contact(newName, newNumber);
                    utils.addContact(newContact);
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid response. Try again.");
            }
        }
    }
}
