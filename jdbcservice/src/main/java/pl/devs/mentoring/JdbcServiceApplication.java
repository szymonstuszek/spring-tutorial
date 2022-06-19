package pl.devs.mentoring;

import java.sql.*;
import java.util.Random;

public class JdbcServiceApplication {
	private final static String URL = "jdbc:postgresql://localhost:5432/test-pgAdmin";
	private final static String USER = "<username>";
	private final static String PASSWORD = "<password>";
	private final static String QUERY = "SELECT * FROM mentors";
	private final static String PREPARED_QUERY = "SELECT name, surname FROM mentors WHERE id = ?";
	private final static String PREPARED_QUERY_FOR_NAME = "SELECT name, surname FROM mentors WHERE name LIKE ?";

    private final static String INSERT_QUERY = """
            INSERT INTO courses (id, title, description, price, created_on)
            VALUES (?, 'Java basics', 'Introduction to the Java programming language', 49.99, '07-23-2022');
            """;

    private final static String PREPARED_INSERT_QUERY = """
            INSERT INTO courses (id, title, description, price, created_on)
            VALUES (?, 'Course title', 'Course description', 0.00, '2022-06-22');
            """;

    private final static String INCORRECT_PREPARED_INSERT_QUERY = """
            INSERT INTO courses (id, title, description, price, created_on)
            VALUES (?, 'Java basics', 'Introduction to the Java programming language', 49.99, '07-23-2022');
            """;

    private final static String CREATE_TABLE_QUERY = """
            CREATE TABLE courses
            (
               id INT PRIMARY KEY,
               title VARCHAR(50) NOT NULL,
               description VARCHAR(250) NOT NULL,
               price NUMERIC NOT NULL,
               created_on DATE DEFAULT CURRENT_DATE
            );
            """;

    public static void main(String[] args) {
        try (Connection connection = DriverManager
                .getConnection(URL, USER, PASSWORD)) {

            connection.setAutoCommit(false);

            for (int i = 0; i < 3; i++) {
                PreparedStatement statement = connection.prepareStatement(PREPARED_INSERT_QUERY);
                statement.setInt(1, new Random().nextInt());
                statement.execute();
            }

            connection.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void searchForName(String nameLike, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(PREPARED_QUERY_FOR_NAME);
        statement.setString(1, nameLike);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            System.out.println("Retrieved: " + name + " " + surname);
        }
    }
}
