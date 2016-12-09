package nursedemo.com.nursedemo.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import nursedemo.com.nursedemo.R;

/**
 * Created by Administrator on 2016/11/26/026.
 */
public class PatientAdapter extends BaseAdapter {
    Context context;
    ArrayList<Patient> patientArrayList;

    public PatientAdapter(Context context, ArrayList<Patient> patientArrayList) {
        this.context = context;
        this.patientArrayList = patientArrayList;
    }

    @Override
    public int getCount() {
        return patientArrayList.size();
    }

    @Override
    public Patient getItem(int position) {
        return patientArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class PatientHolder
    {
        TextView bingli_NO;
        TextView bed_NO;
        TextView name;
        TextView gender;
        TextView age;
        TextView kebie;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PatientHolder holder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.patient_item, parent, false);
            holder=new PatientHolder();
            holder.bingli_NO=(TextView) convertView.findViewById(R.id.tv1);
            holder.bed_NO=(TextView) convertView.findViewById(R.id.tv2);
            holder.name=(TextView) convertView.findViewById(R.id.tv3);
            holder.gender=(TextView) convertView.findViewById(R.id.tv4);
            holder.age=(TextView) convertView.findViewById(R.id.tv5);
            holder.kebie=(TextView) convertView.findViewById(R.id.tv6);
            convertView.setTag(holder);
        }
        else
        {
            holder=(PatientHolder) convertView.getTag();
        }
        holder.bingli_NO.setText(patientArrayList.get(position).getBingli_NO());
        holder.bed_NO.setText(patientArrayList.get(position).getBed_NO());
        holder.name.setText(patientArrayList.get(position).getName());
        holder.gender.setText(patientArrayList.get(position).getGender());
        holder.age.setText(patientArrayList.get(position).getAge());
        holder.kebie.setText(patientArrayList.get(position).getKebie());

        return convertView;
    }
}
