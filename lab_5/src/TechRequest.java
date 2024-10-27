import java.util.Date;

// Клас Технічні заявки
public class TechRequest {
    private final String clientId;
    private final String description;
    private final Date requestDate;

    public TechRequest(String clientId, String description) {
        this.clientId = clientId;
        this.description = description;
        this.requestDate = new Date();
    }

    public String getClientId() {
        return clientId;
    }

    public String getDescription() {
        return description;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    @Override
    public String toString() {
        return "TechRequest: client id: " + clientId + ", description: " + description + ", requestDate: " + requestDate;
    }
}