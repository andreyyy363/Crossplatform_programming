import java.util.Date;

// Клас Платежів
public class Payment {
    private final String clientId;
    private final double amount;
    private final Date date;

    public Payment(String clientId, double amount, Date date) {
        this.clientId = clientId;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment - client id: " + clientId + ", amount: " + amount + ", date: " + date;
    }
}