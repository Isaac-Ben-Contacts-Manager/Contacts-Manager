import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactUtils {

    private HashMap<String, Contact> contactList;
    Path filePath;

    public ContactUtils (String fileName) {
        filePath = Paths.get(fileName);
        contactList = new HashMap<>();
    }

    public void createContacts() {
        List<String> contactLines = readFile();
        for (String contactline : contactLines){
            System.out.println(contactline);
            String[] contactarr = contactline.split("\\|",2);
            Contact contact = new Contact(contactarr[0].trim(), contactarr[1].trim());
            contactList.put(contactarr[0].trim(), contact);
            System.out.println(Arrays.toString(contactarr));
        }
    }

    public List<String> readFile() {
        List<String> linesInFile = new ArrayList<>();
        try {
            linesInFile = Files.readAllLines(filePath);
        } catch (IOException iox){
            iox.printStackTrace();
        }
        return linesInFile;
    }

    public void writeFile () {
        List<String> listToWrite = new ArrayList<>();

        // Build list of contacts from HashMap
        for (String name : contactList.keySet()) {
            listToWrite.add(contactList.get(name).toString());
        }
        // Write list to file
        try {
            Files.write(filePath, listToWrite);
        } catch (IOException iox) {
            System.out.println("Error writing to file " + iox.getMessage());
        }
    }

    public void addContact (Scanner scanner) {

        String newName = "";
        String newNumber = "";

        System.out.println("Enter name of new contact.");
        newName = scanner.nextLine();
        if (getContact(newName) != null) {
            System.out.println("That name is already in your contacts. Overwrite (y/n)?");
            String overwrite = scanner.nextLine();
            if (!overwrite.equalsIgnoreCase("y") && !overwrite.equalsIgnoreCase("yes")) {
                addContact (scanner);
                return;
            }
            else {
                System.out.println("Enter phone number of new contact.");
                newNumber = scanner.nextLine();
                contactList.get(newName).setNumber(newNumber);
                return;
            }
        }
        System.out.println("Enter phone number of new contact.");
        newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName, newNumber);

        contactList.put(newContact.getName(), newContact);
    }

    public void delContact (String name) {
        contactList.remove(name);
    }

    public static void displayHeaders() {
        System.out.println("Name | Phone number");
        System.out.println("---------------------------");
    }

    public void displayContacts() {
        displayHeaders();
        for (String name : contactList.keySet()) {
            System.out.println(contactList.get(name).toString());
        }
        System.out.println();
    }

    public Contact getContact(String name) {
        return contactList.get(name);
    }

    public void displaySimilarContacts (String searchName) {
        displayHeaders();

        // Build list of contacts whose names start with that specified by the user
        for (String name : contactList.keySet()) {
            if (name.toLowerCase().startsWith(searchName)) {
                System.out.println(contactList.get(name).toString());
            }
        }
        System.out.println();
    }
}
