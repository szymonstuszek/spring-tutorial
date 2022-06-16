package pl.devs.mentoring;

import java.sql.*;

public class JdbcServiceApplication {
	private final static String URL = "jdbc:postgresql://localhost:5432/test-pgAdmin";
	private final static String USER = "<username>";
	private final static String PASSWORD = "<password>";
	private final static String QUERY = "SELECT * FROM mentors";

	private final static String INSERT_QUERY = """
			INSERT INTO courses (id, title, description, price, created_on)
			VALUES (5, 'Java basics', 'Introduction to the Java programming language', 49.99, '07-23-2022');
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

			Statement statement = connection.createStatement();
			statement.execute(INSERT_QUERY);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
