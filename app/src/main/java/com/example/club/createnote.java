package com.example.club;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import adapters.AdapterN;

public class createnote extends Dialog implements AdapterView.OnItemSelectedListener,android.view.View.OnClickListener {
    AlertDialog.Builder builder;
    private tnote tnote;
    private List<tnote> lnote = new ArrayList<>();
    AdapterN adapter;
public createnote(@NonNull Context context) {
        super(context);
        }

@Override
public void onClick(View v) {

        }

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnote);

    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
            R.array.categorie, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    Button close =(Button)findViewById(R.id.btnX);
    close.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            createnote.this.dismiss();
        }
    });
Button ajouter = findViewById(R.id.close);
ajouter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    }
});
}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


}
