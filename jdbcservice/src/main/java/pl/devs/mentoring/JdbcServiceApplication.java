package pl.devs.mentoring;

import java.sql.*;

public class JdbcServiceApplication {

	public static void main(String[] args) throws SQLException {
				final String url = "jdbc:postgresql://localhost:5432/postgres";
		final String user = "postgres";
		final String password = "<your-pass>";
		String sql = "SELECT * FROM \"Mentors\"";


		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();



			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println(resultSet.getString("ID"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("surname"));
			}


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}
	}
}
