import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class ContactUtils {

    private HashMap<String, Contact> contactList;
    Path filePath;

    public ContactUtils (String fileName) {
        filePath = Paths.get(fileName);
    }

    public List<String> readFile() {
        return null;
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

    }

    public Contact getContact(String name) {
        return contactList.get(name);
    }
}
