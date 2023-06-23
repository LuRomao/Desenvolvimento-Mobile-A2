package com.example.trabalhoa2.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.trabalhoa2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReservasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReservasFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ReservasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReservasFragment.
     */
    public static ReservasFragment newInstance(String param1, String param2) {
        ReservasFragment fragment = new ReservasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinner = view.findViewById(R.id.spinnerAro);
        String[] aros = new String[] {"Aro 12", "Aro 16", "Aro 20", "Aro 24", "Aro 26"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(),
                android.R.layout.simple_spinner_dropdown_item, aros);
        spinner.setAdapter(adapter);

        Button buttonReservar = view.findViewById(R.id.botaoReservar);
        Button buttonLimpar = view.findViewById(R.id.buttonLimparReserva);

        View.OnClickListener limpar = v -> {
            EditText nomeCliente = view.findViewById(R.id.editTextNomeDoClienteReserva);
            nomeCliente.setText("");

            EditText data = view.findViewById(R.id.editTextDataReserva);
            data.setText("");

            spinner.setSelection(0);
        };

        //Ambos limpa já que é um mock
        buttonReservar.setOnClickListener(limpar);
        buttonLimpar.setOnClickListener(limpar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservas, container, false);
    }
}