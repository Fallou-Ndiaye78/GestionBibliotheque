package GestionBibliotheque;
import java.sql.*;

public class DVD {
    private String reference;
    private String titre;
    private int duree;
    private boolean disponible;
    private String sqlArticle;

    // Constructeur
    public DVD(String titre, int duree) {
        this.reference = "DVD" + System.currentTimeMillis(); // Génération d'une référence unique
        this.titre = titre;
        this.duree = duree;
        this.disponible = true;
    }

    // Méthode pour ajouter un DVD
    public void ajouterDVD(Connection conn, int bibliothequeId) {
        try {
            // Insertion dans la table "Article"
            String sql = "INSERT INTO DVD (type, duree,";
            PreparedStatement pstmtArticle = conn.prepareStatement(sqlArticle);
            pstmtArticle.setString(1, this.reference);
            pstmtArticle.setString(2, this.titre);
            pstmtArticle.setBoolean(3, this.disponible);
            pstmtArticle.setInt(4, bibliothequeId);
            pstmtArticle.executeUpdate();

            // Insertion dans la table "DVD"
            String sqlDVD = "INSERT INTO DVD (reference, duree) VALUES (?, ?)";
            PreparedStatement pstmtDVD = conn.prepareStatement(sqlDVD);
            pstmtDVD.setString(1, this.reference);
            pstmtDVD.setInt(2, this.duree);
            pstmtDVD.executeUpdate();

            System.out.println("DVD ajouté avec succès!");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du DVD : " + e.getMessage());
        }
    }

    // Méthode pour rechercher un DVD par référence
    public static void rechercherDVD(Connection conn, String reference) {
        try {
            String sql = "SELECT * FROM Article JOIN DVD ON Article.reference = DVD.reference WHERE Article.reference = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reference);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Titre: " + rs.getString("titre") + ", Durée: " + rs.getInt("duree") + " minutes");
            } else {
                System.out.println("DVD introuvable.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du DVD : " + e.getMessage());
        }
    }

    // Méthode pour supprimer un DVD
    public static void supprimerDVD(Connection conn, String reference) {
        try {
            String sql = "DELETE FROM Article WHERE reference = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reference);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("DVD supprimé avec succès!");
            } else {
                System.out.println("Aucun DVD trouvé avec cette référence.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du DVD : " + e.getMessage());
        }
    }
}
