package uk.ac.northumbria.securephonebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    Database database;

    EditText etFirstname, etSurname, etEmail, etTelephone ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        database = new Database(this);
        etFirstname = (EditText) findViewById(R.id.firstnametext);
        etSurname = (EditText)findViewById(R.id.surnametext);
        etEmail = (EditText)findViewById(R.id.emailtext);
        etTelephone = (EditText)findViewById(R.id.telephonetext);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void saveData (View V){
            String firstname = etFirstname.getText().toString();
            String surname = etSurname.getText().toString();
            String email = etEmail.getText().toString();
            String telephone = etTelephone.getText().toString();
            etFirstname.setText("");
            etSurname.setText("");
            etEmail.setText("");
            etTelephone.setText("");
            database.addContact(firstname,surname,email,telephone);
            Toast.makeText(this,"Contact Saved Successfully",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,MainActivity.class));
    }
    public void goBack (View V){
        startActivity(new Intent(this,MainActivity.class));

    }
}
