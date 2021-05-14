package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import com.example.club.R;
import com.example.club.add_event;
import com.example.club.edittask;
import com.example.club.event;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class eventAdapter extends ArrayAdapter<event> {
    Calendar currentDate;
    List<event> events;
    LayoutInflater inflater;
    List<Date> dates;
    public eventAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View newItem;
         LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         newItem = li.inflate(R.layout.itemweek,parent,false);
         TextView txtHr=newItem.findViewById(R.id.heureL);
        LinearLayout vi = newItem.findViewById(R.id.gris);
        LinearLayout vi2 = newItem.findViewById(R.id.lin);
        TextView txtEvent =newItem.findViewById(R.id.evenements);

        txtEvent.setText(this.getItem(position).getName());
        txtHr.setText(this.getItem(position).getTime());
         return newItem;
    }
}
