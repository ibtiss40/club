package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.club.R;
import com.example.club.tnote;

import java.util.List;

public  class AdapterN extends ArrayAdapter<tnote> {

    public AdapterN(@NonNull Context context, @NonNull List objects)
    {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View newItem;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        newItem = li.inflate(R.layout.element_note,parent,false);
        return newItem;
    }

}
