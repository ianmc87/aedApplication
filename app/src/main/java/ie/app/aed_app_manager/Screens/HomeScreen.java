package ie.app.aed_app_manager.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ie.app.aed_app_manager.Model.Base;
import ie.app.aed_app_manager.R;

public class HomeScreen extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void addButtonPressed(View view){

        Intent intent = new Intent(HomeScreen.this, AddScreen.class);
        startActivity(intent);
    }

    public void listButtonPressed(View view){

        Intent intent = new Intent(HomeScreen.this, ListScreen.class);
        startActivity(intent);
    }
}
