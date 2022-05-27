package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Esta clase Java realiza la conexión con la base de datos.
 */
public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host = "localhost:3306/examenprogramacion";
	final private String user = "root";
	final private String passwd = "";
	
	/*
	 * Pre:---
	 * Post: Este método Java realiza inserts sobre la base de datos con la información que recibe
	 * 		 desde la clase Main.
	 */
	public void insertInfoDataBase(String letra, String palabra, int linea) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?"
							+ "user=" + user + "&password=" + passwd );

		  
		   statement = connect.createStatement();
		   
		   preparedStatement = connect
		       .prepareStatement("insert into registro(Letra, Palabra, Linea) values (?, ?, ?)");
		   
		   preparedStatement.setString(1, letra);
		   preparedStatement.setString(2, palabra);
		   preparedStatement.setInt(3, linea);
		   preparedStatement.executeUpdate();
		
		} catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			} if (statement != null) {
				statement.close();
			} if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {}
	}
}
