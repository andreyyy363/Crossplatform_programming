/*
Варіант 19:
Створити базу даних "Музей" із таблицями "Експонати" та
"Відвідувачі". Реалізувати CRUD-операції для таблиці "Експонати".
*/

import java.sql.*;

public class MuseumDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/museum";
    private static final String USER = "user";
    private static final String PASSWORD = "user_password";

    public static void createExhibit(Connection connection, String name, String description, int year, String category) throws SQLException {
        String query = "INSERT INTO Exhibits (name, description, year, category) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, year);
            statement.setString(4, category);
            statement.executeUpdate();
        }
    }

    public static void readExhibits(Connection connection) throws SQLException {
        String query = "SELECT * FROM Exhibits";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Year: " + resultSet.getInt("year"));
                System.out.println("Category: " + resultSet.getString("category"));
                System.out.println();
            }
        }
    }

    public static void updateExhibit(Connection connection, int id, String name, String description, int year, String category) throws SQLException {
        String query = "UPDATE Exhibits SET name = ?, description = ?, year = ?, category = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, year);
            statement.setString(4, category);
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }

    public static void deleteExhibit(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM Exhibits WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static void createVisitor(Connection connection, String name, Date visitDate, String phoneNumber) throws SQLException {
        String query = "INSERT INTO Visitors (name, visit_date, phone_number) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setDate(2, visitDate);
            statement.setString(3, phoneNumber);
            statement.executeUpdate();
        }
    }

    public static void readVisitors(Connection connection) throws SQLException {
        String query = "SELECT * FROM Visitors";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Visit Date: " + resultSet.getDate("visit_date"));
                System.out.println("Phone Number: " + resultSet.getString("phone_number"));
                System.out.println();
            }
        }
    }

    public static void updateVisitor(Connection connection, int id, String name, Date visitDate, String phoneNumber) throws SQLException {
        String query = "UPDATE Visitors SET name = ?, visit_date = ?, phone_number = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setDate(2, visitDate);
            statement.setString(3, phoneNumber);
            statement.setInt(4, id);
            statement.executeUpdate();
        }
    }

    public static void deleteVisitor(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM Visitors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            connection.setAutoCommit(false);

            // Create multiple exhibits
            createExhibit(connection, "Mona Lisa", "A portrait by Leonardo da Vinci", 1503, "Painting");
            createExhibit(connection, "The Starry Night", "A painting by Vincent van Gogh", 1889, "Painting");
            createExhibit(connection, "The Thinker", "A sculpture by Auguste Rodin", 1902, "Sculpture");
            createExhibit(connection, "The Scream", "A painting by Edvard Munch", 1893, "Painting");
            createExhibit(connection, "David", "A sculpture by Michelangelo", 1504, "Sculpture");
            connection.commit();

            // Read exhibits
            readExhibits(connection);

            // Update one exhibit
            updateExhibit(connection, 1, "Mona Lisa", "A famous portrait by Leonardo da Vinci", 1503, "Painting");
            connection.commit();

            // Delete one exhibit
            deleteExhibit(connection, 1);
            connection.commit();

            // Create multiple visitors
            createVisitor(connection, "John Doe", Date.valueOf("2023-10-01"), "123-456-7890");
            createVisitor(connection, "Jane Smith", Date.valueOf("2023-10-02"), "098-765-4321");
            createVisitor(connection, "Alice Johnson", Date.valueOf("2023-10-03"), "555-123-4567");
            createVisitor(connection, "Bob Brown", Date.valueOf("2023-10-04"), "555-765-4321");
            createVisitor(connection, "Charlie Davis", Date.valueOf("2023-10-05"), "555-987-6543");
            connection.commit();

            // Read visitors
            readVisitors(connection);

            // Update visitor
            updateVisitor(connection, 1, "John Doe", Date.valueOf("2023-10-01"), "321-654-0987");
            connection.commit();

            // Delete visitor
            deleteVisitor(connection, 1);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}