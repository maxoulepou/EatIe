package Controleur;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eatit.R;

import Model.BD_Contact;

public class AjouterContactActivity extends AppCompatActivity {

    BD_Contact bdc;

    // On crée des variables qui correspondent aux différents EditText + bouton du layout
    // "activity_ajouter_contact"

    EditText editPrenom, editNom, editProfession, editEmail, editTelephone;
    Button boutonAjouter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_contact);
        bdc = new BD_Contact(this);

        // On cast les variables EditText et Button

        editPrenom = (EditText) findViewById(R.id.et_contact_prenom);
        editNom = (EditText) findViewById(R.id.et_contact_nom);
        editProfession = (EditText) findViewById(R.id.et_contact_profession);
        editEmail = (EditText) findViewById(R.id.et_contact_email);
        editTelephone = (EditText) findViewById(R.id.et_contact_telephone);
        boutonAjouter = (Button) findViewById(R.id.but_contact_enregistrer);

        ajouterContact();
    }

    public void ajouterContact () {
        boutonAjouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = bdc.insererContact(editPrenom.getText().toString(),
                                editNom.getText().toString(),
                                editProfession.getText().toString(),
                                editEmail.getText().toString(),
                                editTelephone.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(AjouterContactActivity.this, "Contact ajouté", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AjouterContactActivity.this, "Contact pas ajouté", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}