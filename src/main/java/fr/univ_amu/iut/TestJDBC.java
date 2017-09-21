package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc
import java.sql.*;

public class TestJDBC {
	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://mysql-places.alwaysdata.net:3306/places_bdcours";
	static final String LOGIN = "places_";
	static final String PASSWORD = "Yotti";

	// La requete de test
	static final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
	                          "FROM ETUDIANT " +
	                          "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

	static int[] num_et = {3013,3015,3016,3017};
	static String[] prenom_et = {"Samuel", "Etienne", "Andréi" , "Maxime"};

	public static void main(String[] args) throws SQLException {
		// Connexion a la base
		System.out.println("Connexion a " + CONNECT_URL);
		try (Connection conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD)){
			System.out.println("Connecte\n");

			// Creation d'une instruction SQL
			Statement stmt = conn.createStatement();

			// Execution de la requete
			System.out.println("Execution de la requete : " + req );
			ResultSet rset = stmt.executeQuery(req);


            // Affichage du resultat
            while (rset.next()){
				System.out.print(rset.getInt("NUM_ET") + " ");
				System.out.print(rset.getString("NOM_ET") + " ");
				System.out.println(rset.getString("PRENOM_ET"));
			}

			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			System.out.println("\nOk.\n");
		} catch (SQLException e) {
			e.printStackTrace();// Arggg!!!
			System.out.println(e.getMessage() + "\n");
		}
	}
}
