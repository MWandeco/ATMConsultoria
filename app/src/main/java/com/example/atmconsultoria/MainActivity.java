package com.example.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.atmconsultoria.databinding.ActivityMainBinding;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              enviarEmail();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,R.id.nav_contato,R.id.nav_informacoes)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        String cel = "tel:13999999999";
        String img = "https://www.hypeness.com.br/1/2019/09/Vira-lata_Caramelo_1.jpg";
        String endereço = "https://www.google.com/maps/place/Parque+Ibirapuera/@-23.5874162,-46.6576336,15z/data=!4m5!3m4!1s0x0:0xcb936109af9ce541!8m2!3d-23.5874162!4d-46.6576336";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(cel));
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(img));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereço));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo app");
        intent.putExtra(Intent.EXTRA_TEXT,"Mensagem Automática");

        intent.setType("message/rfc822");
        //intent.setType("text/plain"); abre aplicativos de textos
        //intent.setType("image/*");     abre aplicativos de imagens
        //intent.setType("application/pdf");    abre aplicativos com pdf
        // https://www.sitepoint.com/mime-types-complete-list/

        startActivity(Intent.createChooser(intent,"Compartihar"));


    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}