package GestionBibliotheque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Article {
    private static String reference;
    private static String titre;
    private static String type;
    private static boolean disponible;
    private static int bibliothequeId;

    // Constructeur
    public Article(String reference, String titre, String type, boolean disponible, int bibliothequeId) {
        this.reference = reference;
        this.titre = titre;
        this.type = type;
        this.disponible = disponible;
        this.bibliothequeId = bibliothequeId;
        String sql = "INSERT INTO Article (reference, titre, type, disponible,";
    }

    public Article() {
        System.out.println("Référence : 222a2 " + Article.getReference());
        System.out.println("Titre : " + Article.getTitre());
        System.out.println("Type : " + Article.getType());
        System.out.println("Disponible : " + Article.isDisponible());
    System.out.println("ID Bibliothèque : " + Article.getBibliothequeId());
    }

    // Getters et setters
    public static String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public static String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public static String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public static int getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(int bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }
}

