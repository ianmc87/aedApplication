package ie.app.aed_app_manager.Screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import ie.app.aed_app_manager.Model.AED;
import ie.app.aed_app_manager.Model.Base;
import ie.app.aed_app_manager.R;

public class AddScreen extends Base {

    // DatabaseHelper myDB; //creating instance of DB

    Button saveButton;
    EditText aedID;
    EditText aedLocation;
    EditText aedCondition;
    EditText aedService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);

        // myDB = new DatabaseHelper(this); //creating new instance of DB, will call constructor of DatabaseHelper class

        homeIcon();
        logoutIcon();

        saveButton=(Button)findViewById(R.id.saveButton);
        aedID=(EditText)findViewById(R.id.aedID);
        aedLocation=(EditText)findViewById(R.id.aedLocation);
        aedCondition=(EditText)findViewById(R.id.aedCondition);
        aedService=(EditText)findViewById(R.id.aedService);

        saveButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){

                String id = aedID.getText().toString();
                String location = aedLocation.getText().toString();
                String condition = aedCondition.getText().toString();
                String date = aedService.getText().toString();

                if(id.length()==0)
                {
                    aedID.requestFocus();
                    aedID.setError("Please enter an AED ID");
                }
                else if(location.length()==0)
                {
                    aedLocation.requestFocus();
                    aedLocation.setError("Please enter an AED location");
                }
                else if(condition.length()==0)
                {
                    aedCondition.requestFocus();
                    aedCondition.setError("Please enter an AED condition");
                }
                else if(date.length()==0)
                {
                    aedService.requestFocus();
                    aedService.setError("Please enter the AED service date");
                }
                else
                {

                    Toast.makeText(AddScreen.this,"AED details entered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddScreen.this, HomeScreen.class);
                    startActivity(intent);

                    newAed(new AED(id,location,condition,date));   //adding 4 string values to the array
                    //   Log.d("filter1", "Arraylist " + aed);
                }

            }
        });
    }

    public void homeIcon()
    {
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
}
