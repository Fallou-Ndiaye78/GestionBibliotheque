package GestionBibliotheque;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MembreDAO membreDAO = new MembreDAO();
        Article article = new Article();
        CD cd = new CD();
        Livre livre = new Livre();



        // Lister tous les membres
        List<Membre> membres = membreDAO.listerMembres();
        for (Membre membre : membres) {
            System.out.println("ID : " + membre.getId() + ", Nom : " + membre.getNom() + ", Prénom : " + membre.getPrenom());
        }

        // Supprimer un membre par ID
        membreDAO.supprimerMembre(1);
    }
}

