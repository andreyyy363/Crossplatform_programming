import java.util.*;

public class Main {
    private static final TelecomCompany company = new TelecomCompany();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nTelecom Company System");
            System.out.println("1. Add Client");
            System.out.println("2. Update Client");
            System.out.println("3. Delete Client");
            System.out.println("4. List Clients");
            System.out.println("5. Add Tariff");
            System.out.println("6. List Tariffs");
            System.out.println("7. Add Service");
            System.out.println("8. List Services");
            System.out.println("9. Add Payment");
            System.out.println("10. List Payments");
            System.out.println("11. Add Tech Request");
            System.out.println("12. Process Tech Request");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addClient();
                case 2 -> updateClient();
                case 3 -> deleteClient();
                case 4 -> company.listClients();
                case 5 -> addTariff();
                case 6 -> company.listTariffs();
                case 7 -> addService();
                case 8 -> company.listServices();
                case 9 -> addPayment();
                case 10 -> company.listPayments();
                case 11 -> addTechRequest();
                case 12 -> company.processTechRequest();
                case 0 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addClient() {
        System.out.print("Enter client ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client email: ");
        String email = scanner.nextLine();
        company.addClient(id, name, email);
    }

    private static void updateClient() {
        System.out.print("Enter client ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new email: ");
        String newEmail = scanner.nextLine();
        company.updateClient(id, newName, newEmail);
    }

    private static void deleteClient() {
        System.out.print("Enter client ID: ");
        String id = scanner.nextLine();
        company.deleteClient(id);
    }

    private static void addTariff() {
        System.out.print("Enter tariff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter tariff price: ");
        double price = scanner.nextDouble();
        company.addTariff(name, price);
    }

    private static void addService() {
        System.out.print("Enter service name: ");
        String name = scanner.nextLine();
        System.out.print("Enter service description: ");
        String description = scanner.nextLine();
        company.addService(name, description);
    }

    private static void addPayment() {
        System.out.print("Enter client ID: ");
        String clientId = scanner.nextLine();
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        company.addPayment(clientId, amount);
    }

    private static void addTechRequest() {
        System.out.print("Enter client ID for tech request: ");
        String clientId = scanner.nextLine();
        System.out.print("Enter tech request description: ");
        String description = scanner.nextLine();
        company.addTechRequest(clientId, description);
    }
}