package GestionBibliotheque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDAO {
    public void ajouterMembre(Membre membre) {
        String sql = "INSERT INTO Membre (prenom, nom, adresse, telephone, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, membre.getPrenom());
            stmt.setString(2, membre.getNom());
            stmt.setString(3, membre.getAdresse());
            stmt.setString(4, membre.getTelephone());
            stmt.setString(5, membre.getEmail());

            stmt.executeUpdate();
            System.out.println("Membre ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Membre> listerMembres() {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT * FROM Membre";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Membre membre = new Membre(
                        rs.getInt("id"),
                        rs.getString("prenom"),
                        rs.getString("nom"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("email")
                );
                membres.add(membre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membres;
    }

    public void supprimerMembre(int id) {
        String sql = "DELETE FROM Membre WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Membre supprimé avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
