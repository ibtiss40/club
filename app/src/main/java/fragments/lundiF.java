package fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.club.R;
import com.example.club.calendar;
import com.example.club.edittask;
import com.example.club.event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.eventAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link lundiF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class lundiF extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static final String HTTP_BASE ="https://emploisclub.000webhostapp.com/GetTache.php";
    private event evt;
    public static List<event> evts = new ArrayList<>();
    RequestQueue requestQueue;



    public lundiF() {
        // Required empty public constructor
    }

    public static lundiF newInstance() {
        
        Bundle args = new Bundle();
        
        lundiF fragment = new lundiF();
        fragment.setArguments(args);
        return fragment;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lundiF.
     */
    // TODO: Rename and change types and number of parameters
    public static lundiF newInstance(String param1, String param2) {
        lundiF fragment = new lundiF();
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
       View b = inflater.inflate(R.layout.fragment_lundi, container, false);
        // Inflate the layout for this fragment

        return b;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listeNotes =view.findViewById(R.id.ListLundi);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, HTTP_BASE, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("4","ay haja2");
                        Log.d(MardiF.class.getSimpleName(), response.toString());
                        try {
                            if(response.has("error")){
                                Log.d("4","ay ereur");
                                Toast.makeText(lundiF.this.getContext(),response.getString("error"),Toast.LENGTH_LONG).show();
                            }
                            else{
                                if(response !=null)
                                {
                                evt = new event(response.getString("name"),response.getString("dateStart"));
                                if(response.has("data")){
                                    JSONArray data = response.getJSONArray("data");
                                    Log.d("4","ay 1");
                                    for (int i = 0; i < data.length(); i++) {
                                        String name = data.getJSONObject(i).getString("name");
                                        String time = data.getJSONObject(i).getString("dateStart");
                                        evt = new event(name, time);
                                        Log.d("4","ay 2");
                                        evts.add(evt); }
                                }  }
                                if(evts !=null)
                                {    eventAdapter na = new eventAdapter(lundiF.this.getContext(),evts);
                                    Log.d("4","ay 3");
                                    //dkhelna les info li f ladapter f listeNotes
                                    listeNotes.setAdapter(na);
                                    Log.d("4","ay 4");
                                }
                            }
                        } catch (JSONException e) {
                            e.getMessage();
                            e.printStackTrace();
                            Log.d("1","err");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("2","ay erreur");
                        Log.e(MardiF.class.getSimpleName(), volleyError.getMessage());
                    }
                }
        );
        Volley.newRequestQueue(this.getContext()).add(request);
    }
}