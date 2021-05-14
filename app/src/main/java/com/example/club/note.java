package com.example.club;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.AdapterN;
import adapters.eventAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link note#newInstance} factory method to
 * create an instance of this fragment.
 */
public class note extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    AlertDialog.Builder builder;
    private tnote tnote;
    private List<tnote> lnote = new ArrayList<>();
    AdapterN adanpter;
    private ArrayAdapter<tnote> adapter ;

    public note() {
        // Required empty public constructor
    }
    public static note newInstance(String param1, String param2) {
        note fragment = new note();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton plus = view.findViewById(R.id.plusnote);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createnote cn = new createnote(getContext());
                cn.show();
            }
        });

        ListView listenotes = view.findViewById(R.id.notelist);
        AdapterN an = new AdapterN(note.this.getContext(),lnote);
        listenotes.setAdapter(an);

        builder = new AlertDialog.Builder(this.getContext());
        lnote.add(new tnote("titre", "contenu"));
        an.notifyDataSetChanged();
        listenotes.post(new Runnable() {
            @Override
            public void run() {
                listenotes.setSelection(lnote.size()-1);
            }
        });

    }
//had chi li zedto 9bl man3es mais masalhch

   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.plusnote:
                showDialog(); //calling the showDialog() method
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void showDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this.getContext());
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.createnote, null);
        dialogBuilder.setView(dialogView);
        final EditText titrenote = (EditText) dialogView.findViewById(R.id.titrenote);

        dialogBuilder.setTitle("New Item");
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(!titrenote.getText().toString().equals("")){
// code here to add item
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Item added!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        dialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog build = dialogBuilder.create();
        build.show();
    } */
}