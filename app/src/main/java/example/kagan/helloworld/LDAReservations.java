package example.kagan.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kagan on 13.12.2015.
 */
public class LDAReservations extends ArrayAdapter {
    List list = new ArrayList();

    public LDAReservations(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {

        TextView NAME,PEOPLE,PHONE,DATE,HOUR;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(0,object);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.reservations_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME =(TextView) row.findViewById(R.id.text_name);
            layoutHandler.PEOPLE =(TextView) row.findViewById(R.id.text_people);
            layoutHandler.PHONE =(TextView) row.findViewById(R.id.text_phone);
            layoutHandler.DATE =(TextView) row.findViewById(R.id.text_date);
            layoutHandler.HOUR =(TextView) row.findViewById(R.id.text_hour);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        DPReservation dataProvider = (DPReservation)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.PEOPLE.setText(dataProvider.getPeople());
        layoutHandler.PHONE.setText(dataProvider.getPhone());
        layoutHandler.DATE.setText(dataProvider.getDate());
        layoutHandler.HOUR.setText(dataProvider.getHour());

        return row;
    }
}
