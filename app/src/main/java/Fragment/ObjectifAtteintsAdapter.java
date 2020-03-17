package Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatit.R;

import java.util.ArrayList;

import Model.ObjectifPartage;
import Model.ObjectifPersonnel;
import Model.Objectifs;
import Model.UnItemListener;

public class ObjectifAtteintsAdapter extends RecyclerView.Adapter<ObjectifAtteintsViewHolder> {

    ArrayList<Objectifs> mes_obj;

    public ObjectifAtteintsAdapter(ArrayList<Objectifs> mes_obj) {
        this.mes_obj = mes_obj;
    }

    public ObjectifAtteintsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Permet de chercher la vue
//        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
//        View view = layoutinflater.inflate(R.layout.ligne_objectifs_partage, parent, false);
//        return new ObjectifAtteintsViewHolder(view);

        View view;
        if (viewType == 0) {
            LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
            view = layoutinflater.inflate(R.layout.ligne_objectif_atteint_pers, parent, false);
            return new ObjectifAtteintsViewHolder(view);
        }
        else {
            LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
            view = layoutinflater.inflate(R.layout.ligne_objectif_atteint_part, parent, false);
            return new ObjectifAtteintsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectifAtteintsViewHolder holder, int position) {
        holder.display(mes_obj.get(position));
    }

    @Override
    public int getItemCount() {
        return mes_obj.size();
    }

    @Override
    public int getItemViewType(int position){
        if(mes_obj.get(position) instanceof ObjectifPersonnel){
            return 0;
        }
        else
            return 1;
    }

}