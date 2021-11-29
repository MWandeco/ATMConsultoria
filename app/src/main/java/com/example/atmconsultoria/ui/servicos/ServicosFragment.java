package com.example.atmconsultoria.ui.servicos;

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
import com.example.atmconsultoria.databinding.FragmentServicosBinding;

public class ServicosFragment extends Fragment {

    private ServicosViewModel servicosViewModel;
    private FragmentServicosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        servicosViewModel =
                new ViewModelProvider(this).get(ServicosViewModel.class);

        binding = FragmentServicosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView1 = binding.textViewSGQ;
        final TextView textView2 = binding.textViewID;
        servicosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView1.setText(R.string.lorem);
                textView2.setText(R.string.lorem);
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