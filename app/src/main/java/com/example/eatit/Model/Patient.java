package com.example.eatit.Model;

/**
 * Gestion des objets de type Patient.
 */
public class Patient {

    private long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String sexe; // restriction homme femme à faire
    private String email;
    private String adresse, ville, contactUrgence;
    private String mdp;
    private int codePostal;


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Patient(String email, String mdp, String nom, String prenom, String sexe, String dateN){ //peut etre ajouter des parametres, a voir lors de la creation du controlleur
        super();
        this.email = email;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateN;
    }

    public Patient(String email, String nom, String prenom, String sexe, String dateN, String ville, String adresse, String codePostal, String NumUrgence){ //peut etre ajouter des parametres, a voir lors de la creation du controlleur
        super();
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateN;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getContactUrgence() {
        return contactUrgence;
    }

    public void setContactUrgence(String contactUrgence) {
        this.contactUrgence = contactUrgence;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }


}
