// Клас Послуг
public class Service {
    private final String serviceName;
    private final String description;

    public Service(String serviceName, String description) {
        this.serviceName = serviceName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service " + serviceName + ": " + description;
    }
}