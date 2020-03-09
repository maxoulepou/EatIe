package Controleur;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Model.BD_Contact;
import Model.Contact;
import Fragment.ContactAdapter;
import Model.UnContactListener;
import Fragment.VerticalSpaceItemDecoration;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

public class AfficherListeContactsActivity extends AppCompatActivity implements UnContactListener {

    private RecyclerView rv;
    private ArrayList<Contact> mes_contacts;
    private ContactAdapter adapter;
    private BD_Contact bdc;
    private static final int espace = 10;
    private Button bouton_ajouter_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_liste_contacts);

        rv = (RecyclerView) findViewById(R.id.recycler_view);
        bouton_ajouter_contact = (Button) findViewById(R.id.but_ajouter_contact);
        bdc = new BD_Contact(this);

        mes_contacts = bdc.getTousLesContacts();

        adapter = new ContactAdapter(mes_contacts, this);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(adapter);
        rv.addItemDecoration(new VerticalSpaceItemDecoration(espace));

        bouton_ajouter_contact.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openNewActivity(AjouterContactActivity.class);
                    }
                }
        );
    }

    @Override
    public void clicSurUnContact(int position) {
        Intent intent = new Intent(this, AfficherUnContactActivity.class);
        intent.putExtra("contact", mes_contacts.get(position));
        startActivity(intent);
    }

    /**
     * Ouvre l'activité renseignée dans le paramètre nouvelle_activité à partir de l'activité courante.
     * @param nouvelle_activite
     */
    public void openNewActivity(Class nouvelle_activite) {
        Intent intent = new Intent(this, nouvelle_activite);
        startActivity(intent);
    }
}