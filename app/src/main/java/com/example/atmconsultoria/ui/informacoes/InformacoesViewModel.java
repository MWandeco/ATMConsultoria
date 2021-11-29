package com.example.atmconsultoria.ui.informacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.atmconsultoria.R;
import com.example.atmconsultoria.ui.informacoes.ui.informacoes.InformacoesFragment;

public class InformacoesViewModel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacoes_view_model_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, InformacoesFragment.newInstance())
                    .commitNow();
        }
    }
}