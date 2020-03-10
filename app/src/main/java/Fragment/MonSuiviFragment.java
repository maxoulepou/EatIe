package Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eatit.R;

import Model.BD_Poids;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonSuiviFragment extends Fragment {

    BD_Poids bdp;
    TextView poids_act, poids_dep, tt_act, tt_dep, taille_act, imc_act;

    public MonSuiviFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_mon_suivi, container, false);

        bdp = new BD_Poids(getContext());

        poids_act = (TextView) view.findViewById(R.id.tv_poids_act);
        poids_dep = (TextView) view.findViewById(R.id.tv_poids_dep);
        tt_act = (TextView) view.findViewById(R.id.tv_tt_act);
        tt_dep = (TextView) view.findViewById(R.id.tv_tt_dep);
        taille_act = (TextView) view.findViewById(R.id.tv_taille_act);
        imc_act = (TextView) view.findViewById(R.id.tv_imc_act);

        poids_act.setText(String.valueOf(bdp.getPoidsActuel()));
        poids_dep.setText(String.valueOf(bdp.getPoidsDépart()));
        tt_act.setText(String.valueOf(bdp.getTTActuel()));
        tt_dep.setText(String.valueOf(bdp.getTTDepart()));
        taille_act.setText(String.valueOf(bdp.getTailleActuelle()));
        imc_act.setText(String.valueOf(bdp.getIMC()));

        return view;
    }

}
