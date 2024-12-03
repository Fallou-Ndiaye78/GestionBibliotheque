package GestionBibliotheque;

public class CD extends Article {
    private static int duree; // Durée en minutes

    public CD(String reference, String titre, boolean disponible, int bibliothequeId, int duree) {
        super(reference, titre, "CD", disponible, bibliothequeId);
        this.duree = duree;
        String sql = "INSERT INTO CD (type, duree,";
    }

    public CD() {
        System.out.println("Référence : " + CD.getReference());
        System.out.println("Titre : " + CD.getTitre());
        System.out.println("Durée : " + CD.getDuree() + " minutes");
        System.out.println("Type : " + CD.getType());
    }

    // Getters et setters
    public static int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}

