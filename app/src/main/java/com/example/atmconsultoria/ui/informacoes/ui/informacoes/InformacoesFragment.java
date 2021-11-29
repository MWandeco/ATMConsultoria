package com.example.atmconsultoria.ui.informacoes.ui.informacoes;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class InformacoesFragment extends Fragment {

    private InformacoesViewModel2 mViewModel;

    public static InformacoesFragment newInstance() {

        return new InformacoesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.informacoes_fragment, container, false);
        Element versao = new Element();
        versao.setTitle("Versão 1.1.0");

        return new AboutPage(getActivity())
                .setDescription("Atm Consultoria, com você a mais de 15 anos.") // or Typeface
                .setImage(R.drawable.logo)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com","Envie um Email")

                .addGroup("Redes Sociais")
                .addWebsite("atmconsultoria.com","Acesse nosso site")
                .addFacebook("atm.consultoria","Facebook")
                .addInstagram("atm.consultoria","Instagram")
                .addTwitter("atm.consultoria","Twitter")
                .addYoutube("atm.consultoria","YouTube")
                .addItem(versao)

                .create();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InformacoesViewModel2.class);
        // TODO: Use the ViewModel
    }

}