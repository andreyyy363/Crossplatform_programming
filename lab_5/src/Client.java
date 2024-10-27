// Клас Клієнтів
public class Client {
    private final String id;
    private String name;
    private String email;

    public Client(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client " + id + " - name: " + name + ", email: " + email;
    }
}