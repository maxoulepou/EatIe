package Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import com.example.eatit.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MesEvntsSanteFragment extends Fragment {


    public MesEvntsSanteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mes_evnt_sante, container, false);
    }

}