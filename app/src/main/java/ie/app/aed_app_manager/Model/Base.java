package ie.app.aed_app_manager.Model;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Base extends AppCompatActivity
{
    public static List<AED> aed = new ArrayList<>();  //arraylist of aed's

    public void newAed(AED defibrillator)
    {
        aed.add(defibrillator);     //adding an aed to the array
    }
}