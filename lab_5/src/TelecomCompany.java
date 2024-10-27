import java.util.*;

// Клас Телекомунікаційна компанія
class TelecomCompany {
    private final Map<String, Client> clients = new HashMap<>();
    private final List<Tariff> tariffs = new ArrayList<>();
    private final List<Service> services = new ArrayList<>();
    private final Map<Date, Payment> payments = new TreeMap<>();
    private final Queue<TechRequest> techRequests = new LinkedList<>();

    public void addClient(String id, String name, String email) {
        if (!clients.containsKey(id)) {
            clients.put(id, new Client(id, name, email));
            System.out.println("Client added.");
        } else {
            System.out.println("Client with this ID already exists.");
        }
    }

    public void updateClient(String id, String newName, String newEmail) {
        Client client = clients.get(id);
        if (client != null) {
            client.setName(newName);
            client.setEmail(newEmail);
            System.out.println("Client updated.");
        } else {
            System.out.println("Client not found.");
        }
    }

    public void deleteClient(String id) {
        if (clients.remove(id) != null) {
            System.out.println("Client deleted.");
        } else {
            System.out.println("Client not found.");
        }
    }

    public void listClients() {
        clients.values().forEach(System.out::println);
    }

    public void addTariff(String name, double price) {
        tariffs.add(new Tariff(name, price));
        System.out.println("Tariff added.");
    }

    public void listTariffs() {
        tariffs.forEach(System.out::println);
    }

    public void addService(String name, String description) {
        services.add(new Service(name, description));
        System.out.println("Service added.");
    }

    public void listServices() {
        services.forEach(System.out::println);
    }

    // CRUD for Payments
    public void addPayment(String clientId, double amount) {
        payments.put(new Date(), new Payment(clientId, amount, new Date()));
        System.out.println("Payment recorded.");
    }

    public void listPayments() {
        payments.values().forEach(System.out::println);
    }

    public void addTechRequest(String clientId, String description) {
        techRequests.offer(new TechRequest(clientId, description));
        System.out.println("Tech request added.");
    }

    public void processTechRequest() {
        TechRequest request = techRequests.poll();
        if (request != null) {
            System.out.println("Processing request: " + request);
        } else {
            System.out.println("No tech requests to process.");
        }
    }
}