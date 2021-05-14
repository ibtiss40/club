package com.example.club;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

import adapters.eventAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calendar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calendar extends Fragment implements TimePickerDialog.OnTimeSetListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public  event evt;
    public static List<event> evts = new ArrayList<>();

    public calendar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calendar.
     */
    // TODO: Rename and change types and number of parameters
    public static calendar newInstance(String param1, String param2) {
        calendar fragment = new calendar();
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
            mParam2 = getArguments().getString(ARG_PARAM2); }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendar, container, false);
        return v;

    }

    @Override
    public void onStart() {
        super.onStart();
        CalendarView calendarView=(CalendarView) getActivity().findViewById(R.id.agenda);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                showBottomSheetDialog();
            } });
       }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    //fonction d affichage le dialogue
    private void showBottomSheetDialog() {

        add_event addPhotoBottomDialogFragment =  add_event.newInstance();
        addPhotoBottomDialogFragment.show(getFragmentManager(),
                "add_photo_dialog_fragment");
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!TextUtils.isEmpty(getArguments().getString("dataname"))&&!TextUtils.isEmpty(getArguments().getString("datatime")))
        {
            String name2 = getArguments().getString("dataname");
        String time2 = getArguments().getString("datatime");
        evt = new event(name2,time2);
        evts.add(evt);
        Log.i("98","fat");
        eventAdapter ea = new eventAdapter(calendar.this.getContext(),evts);
        ListView listeEvenement = getView().findViewById(R.id.list_events);
        listeEvenement.setAdapter(ea);}
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
/*
        ListView listeEvenement = view.findViewById(R.id.list_events);
        eventAdapter ea = new eventAdapter(calendar.this.getContext(),evts);
        listeEvenement.setAdapter(ea);
        //click list
        listeEvenement.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("2", "dazzz");
                edittask et = new edittask(getContext());
                et.show();}

     }); */
}
}
/* suppresion et.btnsup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        evts.remove(position);
                        ea.notifyDataSetChanged();
                        listeEvenement.post(new Runnable() {
                            @Override
                            public void run() {
                                listeEvenement.setSelection(evts.size() - 1);
                            }
                        });
                    }
                });
                */