package pl.devs.mentoring;

import java.sql.*;

public class JdbcServiceApplication {
	private final static String URL = "jdbc:postgresql://localhost:5432/test-pgAdmin";
	private final static String USER = "<username>";
	private final static String PASSWORD = "<password>";
	private final static String QUERY = "SELECT * FROM mentors";


	public static void main(String[] args) {
		try (Connection connection = DriverManager
				.getConnection(URL, USER, PASSWORD)) {

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(QUERY);

			if (resultSet != null) {
				int rowCount = 0;

				while (resultSet.next()) {
					System.out.println(resultSet.getString("ID"));
					System.out.println(resultSet.getString("name"));
					System.out.println(resultSet.getString("surname"));
				}
				System.out.println("Count of registered mentors: " + rowCount);
			}


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
