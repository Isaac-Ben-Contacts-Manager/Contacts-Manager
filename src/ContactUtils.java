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

    public void createContact() {
        List<String> contactLines = readFile();
        for (String contactline : contactLines){
            System.out.println(contactline);
            String[] contactarr = contactline.split("\\|",2);
            Contact contact = new Contact(contactarr[0], contactarr[1]);
            contactList.put(contactarr[0], contact);
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

    public void writeFile (List<String> updatedContacts) {

    }

    public void addContact (Contact newContact) {

    }

    public void delContact (String name) {

    }

    public void modContact (String name) {

    }

    public void displayContacts() {
        System.out.println(contactList);
    }

    public Contact getContact(String name) {
        return contactList.get(name);
    }
}
