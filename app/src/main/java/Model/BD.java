package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Connection;
import java.sql.Statement;

public class BD extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dataBase";
    private Connection mConnection;
    private String idCo;

    public static final String TABLE_NAME_UTILISATEUR = "tableUtilisateur";
    public static final String col_idUtilisateur = "id";
    public static final String col_Email = "email";
    public static final String col_Mdp = "Mot_de_passe";
    public static final String col_Nom = "Nom";
    public static final String col_Prenom = "Prenom";
    public static final String col_DateNaissance = "Date_de_naissance";
    public static final String col_Sexe = "Sexe";

    public static String TABLE_NAME_BD_OBJ = "tableObjectifs";
    public static String col_id_obj = "IdObjectif";
    public static String col_type_obj = "TypeObjectif";
    public static String col_intitule = "Intitule";
    public static String col_date_debut = "dateDeDebut";
    public static String col_date_fin = "dateDeFin";
    public static String col_accomplissement = "Accomplissement";
    public static String col_Commentaire = "Commentaire";

    public BD(@Nullable Context context){
        super(context, DATABASE_NAME, null, 1);

    }

    public void onCreate(SQLiteDatabase db){
        String strSQLUtilisateur = "create table " + TABLE_NAME_UTILISATEUR +" ("
                + col_idUtilisateur + " integer primary key autoincrement, "
                + col_Email + " text not null, "
                + col_Mdp + " text not null, "
                + col_Nom + " text, "
                + col_Prenom + " text, "
                + col_DateNaissance + " text, "
                + col_Sexe + " text)";
        db.execSQL(strSQLUtilisateur);
        System.out.println("BD_Repas créer");

        String strSQLObj = "create table " + TABLE_NAME_BD_OBJ +" ("
                + col_id_obj + " integer primary key autoincrement, "
                + col_idUtilisateur + " integer not null, "
                + col_intitule + " text not null, "
                + col_type_obj + " text not null, "
                + col_date_debut + " text, "
                + col_date_fin + " text, "
                + col_Commentaire + "text, "
                + col_accomplissement + " text not null)";
        db.execSQL(strSQLObj);
        System.out.println("BD_Repas créer");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_UTILISATEUR);
        onCreate(db);
    }

    public void ChangerMotDePasse(String mail, String newmdp) {
        try {

            //Création d'un objet Statement
            Statement state = mConnection.createStatement();
            String query = "UPDATE connexion\n" + "SET " + col_Mdp + " ='" + "'\nWHERE idpersonnel='" + this.getId(mail) + "'";
            state.executeUpdate(query);
            state.close();

            System.out.println("Modification du mot de passe réussi");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creerCompte(Patient p) {
        ContentValues cv = new ContentValues();
//        formatedDate = sdf.format(date);

        cv.put(col_Email, p.getEmail());
        cv.put(col_Mdp, p.getMdp());
        cv.put(col_Nom, p.getNom());
        cv.put(col_Prenom, p.getPrenom());
        cv.put(col_DateNaissance, p.getDateNaissance());
        cv.put(col_Sexe, p.getSexe());

        System.out.println("Le patient a bien été ajouté à la BD");
        System.out.println(p.getEmail());
        System.out.println(p.getMdp());
        this.getWritableDatabase().insert(TABLE_NAME_UTILISATEUR, null, cv);
    }

    public String getId(String mail){
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_UTILISATEUR + " where " + col_Email + " = '" + mail + "'", null);
                for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
                    String mID = result.getString(0);
                    return mID;
                }
                return "Pas de mail trouve";
    }

    public boolean seConnecter(String mail, String mdp){
        boolean peutSeConnecter = false;
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_UTILISATEUR + " where " + col_Email + " = '" + mail +"'", null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){ //J'aurai bien mis juste result.moveTofirst() mais fonctionne pas...
            String mMail = result.getString(1);
            System.out.println(mMail);
            String mMdp = result.getString(2);
            System.out.println(mMdp);

            if (mail.equals(mMail) && mdp.equals(mMdp)){
                System.out.println(mail);
                System.out.println(mdp);
                peutSeConnecter = true;
            }
        }
        return peutSeConnecter;
    }

    public void estConnecte(String mail) {
        String requete = "select " + col_idUtilisateur + " from " + TABLE_NAME_UTILISATEUR + " where " + col_Email + " = '" + mail +"'";
        Cursor result = this.getWritableDatabase().rawQuery(requete, null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            idCo = result.getString(0);
        }
    }
}