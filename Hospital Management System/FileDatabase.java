import java.io.*;
import java.util.*;

public class FileDatabase {
    private static FileDatabase instance;
    private final String fileName = "hospital_data.txt";
    private List<User> users;

    private FileDatabase() {
        users = new ArrayList<>();
        loadFromFile();
    }

    public static FileDatabase getInstance() {
        if (instance == null) {
            instance = new FileDatabase();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
        saveToFile();
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(users);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            users = (List<User>) ois.readObject();
        } 
        catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
        }
    }
}
