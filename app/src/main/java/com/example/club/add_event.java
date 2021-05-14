package com.example.club;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import fragments.JeudiF;
import fragments.lundiF;

public class add_event extends BottomSheetDialogFragment {
    private int lastSelectedHour = -1;
    private int lastSelectedMinute = -1;
    boolean is24HView = true;
    private EditText editTextTime;
    private Button buttonTime;
    private CheckBox checkBoxIsSpinnerMode;
    private CheckBox checkBoxIs24HView;

    private event evt;
    private List<event> evts = new ArrayList<>();
    public add_event() {

    }

    // TODO: Rename and change types and number of parameters
    public static add_event newInstance() {
        add_event fragment = new add_event();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("98","click");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("98","click");
      //  View v = inflater.inflate(R.layout.fragment_calendar, container, false);


        return  inflater.inflate(R.layout.add_event, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("98","click 1");
        Button button = (Button) getView().findViewById(R.id.setEventTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              buttonSelectTime();
            }});
      final  View ve = getView() ;
        Button btnadd = (Button) ve.findViewById(R.id.wldlhram);
        Log.i("68","27");
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("98","click9");
                TextView evttime = ve.findViewById(R.id.eventtime);
                EditText evtname = ve.findViewById(R.id.eventname);
                if(!TextUtils.isEmpty(evtname.getText().toString())&&!TextUtils.isEmpty(evttime.getText().toString()))
                {
                    String name = evtname.getText().toString();
                    String time = evttime.getText().toString();

                    Bundle bundle = new Bundle();
                    bundle.putString("dataname", name);
                    bundle.putString("datatime",time);
                    JeudiF fragobj = new JeudiF();
                    fragobj.setArguments(bundle);
                    Log.i("98","click14");
                    FragmentManager frgManager = getFragmentManager();
                    frgManager.beginTransaction().replace(R.id.container,fragobj).show(fragobj).commit();

                }
                else{
                    Log.i("98","erreur");
                    Toast.makeText(getContext(),"entrer les champs",Toast.LENGTH_LONG).show();}

            }
        });


    }



    private void buttonSelectTime()  {
        final TimePicker timePicker = new TimePicker(this.getContext());
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(20);
        timePicker.setCurrentMinute(15);

        new AlertDialog.Builder(this.getContext())
                .setTitle("time")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Picker", timePicker.getCurrentHour() + ":"
                                + timePicker.getCurrentMinute());
                        TextView textTime = (TextView) getView().findViewById(R.id.eventtime);
                        textTime.setText(timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());


                    }
                })
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Log.d("Picker", "Cancelled!");
                            }
                        }).setView(timePicker).show();
    }


}