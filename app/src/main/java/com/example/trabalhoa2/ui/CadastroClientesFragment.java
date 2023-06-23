package com.example.trabalhoa2.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.trabalhoa2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroClientesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroClientesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AppCompatImageButton botaoCadastrarCliente;

    private TableLayout tabelaClientes;

    ActivityResultLauncher<Intent> activityResultLauncher;

    public CadastroClientesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroClientesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroClientesFragment newInstance(String param1, String param2) {
        CadastroClientesFragment fragment = new CadastroClientesFragment();
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

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String nomeCliente = data.getExtras().getString("nomeCliente");
                        String telefoneCliente = data.getExtras().getString("telefoneCliente");
                        TableRow tr = new TableRow(getActivity().getApplicationContext());

                        TextView nome = new TextView(getActivity().getApplicationContext());
                        nome.setText(nomeCliente);

                        TextView telefone = new TextView(getActivity().getApplicationContext());
                        telefone.setText(telefoneCliente);

                        tr.addView(nome);
                        tr.addView(telefone);
                        tr.setBackgroundResource(R.drawable.lines);

                        tabelaClientes.addView(tr);
                    }
                });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabelaClientes = view.findViewById(R.id.tableClientes);
        botaoCadastrarCliente = view.findViewById(R.id.botaoCadastrarClientes);
        botaoCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), InserirDadosClienteActivity.class);
                activityResultLauncher.launch(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_clientes, container, false);
    }
}