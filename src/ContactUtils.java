import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    public void addContact (Contact newContact) {
        contactList.put(newContact.getName(), newContact);
    }

    public void delContact (String name) {
        contactList.remove(name);
    }

    public void modContact (String name) {

    }

    public void displayContacts() {
        System.out.println("Name | Phone number");
        System.out.println("---------------------------");
        for (String name : contactList.keySet()) {
            System.out.println(name + " | " + contactList.get(name).getNumber());
        }
        System.out.println();
    }

    public Contact getContact(String name) {
        return contactList.get(name);
    }
}
