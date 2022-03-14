package com.example.practica3molcri;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practica3molcri.databinding.ActivityMainBinding;
import com.example.practica3molcri.databinding.ActivityOrderBinding;

public class order extends AppCompatActivity {

    private ActivityOrderBinding binding;
    TextView dadaRecollida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        dadaRecollida = findViewById(R.id.dadaTraida);

        String mesage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if(mesage.equals("Hamburguesa")){
            dadaRecollida.setText(getResources().getText(R.string.selHambur));
        }else if(mesage.equals("Pizza")){
            dadaRecollida.setText(getResources().getText(R.string.selPizza));
        }else if(mesage.equals("Frankfurt")){
            dadaRecollida.setText(getResources().getText(R.string.selFrank));
        }
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        TextView textView = (TextView) findViewById(R.id.mostrarData);
        textView.setText(dateMessage);
        Toast toast = Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_LONG);
        toast.show();
    }

    public void clickComprar(View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(this);
        myAlertBuilder.setTitle("Informació");
        myAlertBuilder.setMessage("Premi D'acord per a continuar, o Cancelar per a sortir");

        myAlertBuilder.setPositiveButton("D'ACORD", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(), "D'ACORD pressed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.setNegativeButton("CANCELAR", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), "CANCELAR pressed",
                                Toast.LENGTH_SHORT).show();
                    }
                });

        myAlertBuilder.show();
    }
}