package Fragment;

import com.example.eatit.R;
import com.squareup.timessquare.CalendarPickerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import Controleur.AfficherListeContactsActivity;
import Controleur.MesRepasActivity;
import Controleur.MonProfilEtEvntActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.Date;

public class AccueilFragment extends Fragment {

    private Date mDate;
    private Calendar nextYear, lastYear, nextMonth;
    private CalendarPickerView mCalendarPickerView;
    private int mois, jour, annee;
    ImageButton menu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accueil, container, false);
        nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        nextMonth = Calendar.getInstance();
        nextMonth.add(Calendar.DAY_OF_MONTH, 1);
        mDate = new Date();
        lastYear = Calendar.getInstance();
        lastYear.add(Calendar.YEAR, -1);

        mCalendarPickerView = (CalendarPickerView) view.findViewById(R.id.calendar);
        menu = (ImageButton) view.findViewById(R.id.menu);

        mCalendarPickerView.init(lastYear.getTime(), nextMonth.getTime())
                .inMode(CalendarPickerView.SelectionMode.SINGLE).withSelectedDate(new Date());

        mCalendarPickerView.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);
                mois = calSelected.get(Calendar.MONTH);
                jour = calSelected.get(Calendar.DAY_OF_MONTH);
                annee = calSelected.get(Calendar.YEAR);
//                String selectedDate = "" + Integer.toString(jour)
//                        + " " + Integer.toString(mois + 1)
//                        + " " + Integer.toString(annee);

                //Toast.makeText(AccueilFragment.super.getContext(), selectedDate, Toast.LENGTH_SHORT).show();
//                Intent MonRessenti = new Intent(AccueilFragment.super.getContext(), com.example.eatit.MonRessenti.class);
//                startActivity(MonRessenti);
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                PopupMenu popupMenu= new PopupMenu(getActivity().getApplicationContext(),menu);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item1:
                                openNewActivity(MonProfilEtEvntActivity.class);
                                break;
                            case R.id.item2:
                                openNewActivity(AfficherListeContactsActivity.class);
                                break;
                            case R.id.item3:
                                openNewActivity(MesRepasActivity.class);
                                break;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });

         return view;
    }

    public void openNewActivity(Class nouvelle_classe) {
        Intent intent = new Intent(getContext(), nouvelle_classe);
        startActivity(intent);
    }
}
