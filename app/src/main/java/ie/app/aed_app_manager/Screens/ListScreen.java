package ie.app.aed_app_manager.Screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import ie.app.aed_app_manager.Model.AED;
import ie.app.aed_app_manager.Model.Base;
import ie.app.aed_app_manager.R;

public class ListScreen extends Base {

    ListView aedDetails;;
    AedAdapter adapter;   //array adapter and list view created to display data in a list format

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);

        homeIcon();
        logoutIcon();

        aedDetails = (ListView)findViewById(R.id.aedListView);
        adapter = new AedAdapter(this,aed);     //linking the list view instance to the adapter
        aedDetails.setAdapter(adapter);

        //----------------------------DELETE--------------------------------------------------------
        aedDetails.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                aed.remove(position);
                adapter.notifyDataSetChanged();    //using a long onclick event to delete a row
                Toast.makeText(ListScreen.this,"AED item deleted", Toast.LENGTH_LONG).show();

                return false;
            }
        });
        //------------------------------------------------------------------------------------------
    }

    private void homeIcon() {

        ImageButton homeIconLink = (ImageButton) findViewById(R.id.homeIcon);
        final Context context = this;
        homeIconLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, HomeScreen.class);
                startActivity(intent);
            }
        });
    }

    public void logoutIcon()
    {
        ImageButton logoutIconLink = (ImageButton) findViewById(R.id.logoutIcon);
        final Context context2 = this;
        logoutIconLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context2, LoginScreen.class);
                startActivity(intent);
            }
        });
    }

//----------------------------Custom Adapter--------------------------------------------------------

    class AedAdapter extends ArrayAdapter<AED>
    {
        public Context context;
        public List<AED> aed;

        public AedAdapter(Context context, List<AED> aed)
        {
            super(context, R.layout.row_aed, aed);    //custom row layout of 4 populated textviews
            this.context = context;
            this.aed = aed;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)    //creates and populates the list view
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.row_aed, parent, false);
            AED defibrillator = aed.get(position);

            TextView idView = (TextView) view.findViewById(R.id.row_id);
            TextView locationView = (TextView) view.findViewById(R.id.row_location);
            TextView conditionView = (TextView) view.findViewById(R.id.row_condition);
            TextView rowView = (TextView) view.findViewById(R.id.row_date);

            idView.setText(defibrillator.id);
            locationView.setText(defibrillator.location);
            conditionView.setText(defibrillator.condition);
            rowView.setText(defibrillator.date);

            return view;
        }
    }
}