package Model;

import java.util.ArrayList;
import java.util.Date; //possible import java.sql, à voir si il y a une différence

public class Patient {

    private long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe; // restriction homme femme à faire
    private String email;
    private String adresse, ville, contactUrgence;
    private int codePostal;
    private ArrayList<Repas> lCarnetRepas;
    private ArrayList<Intervention> lIntervention;
    private ArrayList<Contact> lContact;
    private ArrayList<Objectifs> lObjectif;
    private ArrayList<Ressenti> lCarnetEmotion;
    private ArrayList<Poids> lPoids;


    public Patient(long id, String nom, String prenom, String sexe, Date date){ //peut etre ajouter des parametres, a voir lors de la creation du controlleur
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = date;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
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

    public ArrayList getlIntervention() {
        return lIntervention;
    }

    public void setlIntervention(ArrayList lIntervention) {
        this.lIntervention = lIntervention;
    }

    public ArrayList getlContact() {
        return lContact;
    }

    public void setlContact(ArrayList lContact) {
        this.lContact = lContact;
    }

    public ArrayList getlObjectif() {
        return lObjectif;
    }

    public void setlObjectif(ArrayList lObjectif) {
        this.lObjectif = lObjectif;
    }

    public ArrayList getlCarnetRepas() {
        return lCarnetRepas;
    }

    public void setlCarnetRepas(ArrayList lCarnetRepas) {
        this.lCarnetRepas = lCarnetRepas;
    }

    public ArrayList getlCarnetEmotion() {
        return lCarnetEmotion;
    }

    public void setlCarnetEmotion(ArrayList lCarnetEmotion) {
        this.lCarnetEmotion = lCarnetEmotion;
    }

    public ArrayList getlPoids() {
        return lPoids;
    }

    public void setlPoids(ArrayList lPoids) {
        this.lPoids = lPoids;
    }
}
