import java.util.Scanner;

public class ContactsManager {

    public static void main(String[] args) {

        String PATH_TO_FILE = "src/contacts.txt";
        Scanner scanner = new Scanner(System.in);
        String userResponse; // Menu choice
        boolean done = false;

        ContactUtils utils = new ContactUtils(PATH_TO_FILE);

        utils.createContacts();

        System.out.println("Welcome to the Contacts Manager!\n");
        // Display menu with choices
        while (!done) {
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.\n");
            System.out.println("Enter an option (1-5).");

            userResponse = scanner.nextLine();
            switch (userResponse) {
                case "1": // View contacts
                    utils.displayContacts();
                    break;
                case "2": // Add a new contact
                    utils.addContact(scanner);
                    break;
                case "3": // Search a contact by name
                    System.out.println("Enter name you would like to search for");
                    String searchName = scanner.nextLine();
                    utils.displaySimilarContacts(searchName.toLowerCase());
                    break;
                case "4": // Delete an existing contact
                    System.out.println("Enter name of contact you would like to delete");
                    String deleteName = scanner.nextLine();
                    utils.delContact(deleteName);
                    break;
                case "5": // Exit
                    utils.writeFile();
                    done = true;
                    break;
                default: // Entered something other than 1-5
                    System.out.println("Invalid response. Try again.\n");
            }
        }
    }
}
