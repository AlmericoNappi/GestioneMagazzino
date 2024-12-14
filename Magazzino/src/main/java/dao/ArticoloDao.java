package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Articolo;

public class ArticoloDao {

	public void insert(Articolo a) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "INSERT INTO articolo(descrizione, quantita) VALUES(?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, a.getDescrizione());
			cmd.setInt(2, a.getQuantita());
			
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}
			if (dbConnection != null) {
				dbConnection.close();

			}
		}

	}

	public void update(Articolo a) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "update articolo set descrizione = ?, quantita =? where codice = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, a.getDescrizione());
			cmd.setInt(2, a.getQuantita());
			cmd.setInt(3, a.getCodice());

			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}
			if (dbConnection != null) {
				dbConnection.close();

			}
		}

	}

	public void delete(int codice) throws SQLException {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String updateTableSQL = "delete from articolo where codice =?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, codice);

			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}
			if (dbConnection != null) {
				dbConnection.close();

			}
		}

	}

	public void getByCode(int codice) {
		try {

			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String qry = "SELECT * FROM articolo WHERE codice = ? ";

			PreparedStatement cmd = dbConnection.prepareStatement(qry);

			cmd.setInt(1, codice);

			ResultSet res = cmd.executeQuery();

//			boolean esiste = res.next();

			int idC;

			idC = res.getInt("codice");

			System.out.println(idC);
			
			System.out.println(res.getString("descrizione"));
			System.out.println(res.getInt("quantita"));
		
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public List<Articolo> getAll() {
		
		List<Articolo> listaArticoli = new ArrayList<>();
		
		try {

			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/eserciziocompleto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection dbConnection = DriverManager.getConnection(url, "root", "Alme191");

			String qry = "SELECT * FROM articolo ";

			PreparedStatement cmd = dbConnection.prepareStatement(qry);

			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();
			
			while(esiste) {
				
				Articolo a = new Articolo();
				
			int idC;

			idC = res.getInt("codice");

			System.out.println(idC);
			
			System.out.println(res.getString("descrizione"));
			System.out.println(res.getInt("quantita"));
			
			a.setCodice(idC);
			a.setDescrizione(res.getString("descrizione"));
			a.setQuantita(res.getInt("quantita"));

			listaArticoli.add(a);
			
			esiste = res.next();
			
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaArticoli;
	}

}
