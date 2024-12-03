package GestionBibliotheque;

public class Livre extends Article {
    private String auteur;
    private int isbn;

    public Livre(String reference, String titre, boolean disponible, int bibliothequeId, String auteur, int isbn) {
        super(reference, titre, "Livre", disponible, bibliothequeId);
        this.auteur = auteur;
        this.isbn = isbn;
        String sql = "INSERT INTO Livre (auteur, isbn,";
    }

    public Livre() {
        Livre livre = new Livre("L001", "les misserables", true, 1, "VICTOR HUGO", 1234567890);
        System.out.println("Livre - Référence : " + livre.getReference() + ", Titre : " + livre.getTitre() + ", Auteur : " + livre.getAuteur());
        System.out.println("Titre : " + livre.getTitre());
        System.out.println("Auteur : " + livre.getAuteur());
        System.out.println("ISBN : " + livre.getIsbn());
        System.out.println("Livre ajouté avec succès !");
    }


    // Getters et setters
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}

