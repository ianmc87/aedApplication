package ie.app.aed_app_manager.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import ie.app.aed_app_manager.R;

public class LoginScreen extends AppCompatActivity {

    Button loginButton;
    EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        loginButton =(Button)findViewById(R.id.loginButton);
        usernameField =(EditText)findViewById(R.id.usernameField);
        passwordField = (EditText)findViewById(R.id.passwordField);
    }

    public void loginButtonPressed(View view){

        String user = usernameField.getText().toString();
        String pass = passwordField.getText().toString();

        if(user.length()==0 ||!user.matches("[a-zA-Z ]+") || user.length()<6)
        {
            usernameField.requestFocus();
            usernameField.setError("Your username must be at least 6 characters in length");
        }
        else if(pass.length()==0 || pass.length() <6)
        {
            passwordField.requestFocus();
            passwordField.setError("Your password must be at least 6 characters in length");
        }
        else
        {
            Toast.makeText(LoginScreen.this,"Login Successful",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginScreen.this, ie.app.aed_app_manager.Screens.HomeScreen.class);
            startActivity(intent);
        }
    }

}
