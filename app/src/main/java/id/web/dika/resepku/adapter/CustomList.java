package id.web.dika.resepku.adapter;

/**
 * Created by ferdhika on 05/05/17.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import id.web.dika.resepku.R;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] nama;
    private final Integer[] imageId;

    public CustomList(Activity context, String[] namaNa, Integer[] imageId) {
        super(context, R.layout.list_single, namaNa);
        this.context = context;
        this.nama = namaNa;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(nama[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
