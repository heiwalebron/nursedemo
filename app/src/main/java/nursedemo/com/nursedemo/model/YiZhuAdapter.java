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
public class YiZhuAdapter extends BaseAdapter {
    Context context;
    ArrayList<YiZhu> yiZhuArrayList;

    public YiZhuAdapter(Context context, ArrayList<YiZhu> yiZhuArrayList) {
        this.context = context;
        this.yiZhuArrayList = yiZhuArrayList;
    }

    @Override
    public int getCount() {
        return yiZhuArrayList.size();
    }

    @Override
    public YiZhu getItem(int position) {
        return yiZhuArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class YiZhuHolder
    {
        TextView day;
        TextView starttime;
        TextView yizhu;
        TextView way;
        TextView yishi;
        TextView fa_yao_p;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        YiZhuHolder holder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.yizhu_item, parent, false);
            holder=new YiZhuHolder();
            holder.day=(TextView) convertView.findViewById(R.id.tv1);
            holder.starttime=(TextView) convertView.findViewById(R.id.tv2);
            holder.yizhu=(TextView) convertView.findViewById(R.id.tv3);
            holder.way=(TextView) convertView.findViewById(R.id.tv4);
            holder.yishi=(TextView) convertView.findViewById(R.id.tv5);
            holder.fa_yao_p=(TextView)convertView.findViewById(R.id.tv6);
            convertView.setTag(holder);
        }
        else
        {
            holder=(YiZhuHolder) convertView.getTag();
        }
        holder.day.setText(yiZhuArrayList.get(position).getDay());
        holder.starttime.setText(yiZhuArrayList.get(position).getStarttime());
        holder.yizhu.setText(yiZhuArrayList.get(position).getYizhu());
        holder.way.setText(yiZhuArrayList.get(position).getWay());
        holder.yishi.setText(yiZhuArrayList.get(position).getYishi());
        holder.fa_yao_p.setText(yiZhuArrayList.get(position).getFa_yao_p());

        return convertView;
    }
}
