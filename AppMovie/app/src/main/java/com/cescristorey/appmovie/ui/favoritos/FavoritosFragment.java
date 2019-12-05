package com.cescristorey.appmovie.ui.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.cescristorey.appmovie.R;

public class FavoritosFragment extends Fragment {


    TextView textViewFavoritos;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_favoritos, container, false);

        textViewFavoritos = vista.findViewById(R.id.text_dashboard);
        return vista;
    }
}