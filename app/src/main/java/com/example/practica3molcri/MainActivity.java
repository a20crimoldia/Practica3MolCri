package com.example.practica3molcri;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.practica3molcri.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String fotoClickada= " ";
    private static final String LOG_TAG = null;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    public static String EXTRA_MESSAGE = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCarretCompra();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void clickHambur(View view) {
        Log.d(LOG_TAG, "INFO: Hamburguesa seleccionada");
        fotoClickada = "Hamburguesa";
        Toast toast = Toast.makeText(this, getResources().getText(R.string.selHambur), Toast.LENGTH_LONG);
        toast.show();
    }

    public void clickPizza(View view) {
        Log.d(LOG_TAG, "INFO: Pizza seleccionada");
        fotoClickada = "Pizza";
        Toast toast = Toast.makeText(this, getResources().getText(R.string.selPizza), Toast.LENGTH_LONG);
        toast.show();
    }
//
    public void clickFrank(View view) {
        Log.d(LOG_TAG, "INFO: Frankfurt seleccionada");
        fotoClickada = "Frankfurt";
        Toast toast = Toast.makeText(this, getResources().getText(R.string.selFrank), Toast.LENGTH_LONG);
        toast.show();
    }

    public void onCarretCompra(){
        Log.d(LOG_TAG, "INFO: Carret clicat");
        if(fotoClickada.equals(" ")){
            Toast toast = Toast.makeText(this, "Selecciona un aliment abans", Toast.LENGTH_LONG);
            toast.show();
        }else {
            Intent intent = new Intent(this, order.class);
            intent.putExtra(EXTRA_MESSAGE, fotoClickada);
            startActivity(intent);
        }
    }
}