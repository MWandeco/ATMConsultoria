package com.example.atmconsultoria.ui.clientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.atmconsultoria.R;
import com.example.atmconsultoria.databinding.FragmentClientesBinding;

public class ClientesFragment extends Fragment {

    private ClientesViewModel clientesViewModel;
    private FragmentClientesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clientesViewModel =
                new ViewModelProvider(this).get(ClientesViewModel.class);

        binding = FragmentClientesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textViewClientes;
        clientesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(R.string.lorem);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}