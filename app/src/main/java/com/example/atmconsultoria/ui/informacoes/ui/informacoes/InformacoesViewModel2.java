package com.example.atmconsultoria.ui.informacoes.ui.informacoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InformacoesViewModel2 extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public InformacoesViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}