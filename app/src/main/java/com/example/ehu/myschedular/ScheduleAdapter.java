package com.example.ehu.myschedular;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;


/*DBのデータをリストビューに表示させるAdapter*/
public class ScheduleAdapter extends RealmBaseAdapter<Schedule> {

    private static class ViewHolder {
        TextView date;
        TextView title;
    }

    public ScheduleAdapter(@Nullable OrderedRealmCollection<Schedule> data) {
        super(data);
    }

    //リストビューの1ビューが読み込まれる時、そのビューを生成。ここには、
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            //1リストの見た目の決定
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(android.R.layout.simple_expandable_list_item_2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.date = convertView.findViewById(android.R.id.text1);
            viewHolder.title = convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Schedule schedule = adapterData.get(position);
        SimpleDateFormat adf = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = adf.format(schedule.getDate());
        viewHolder.date.setText(formatDate);
        viewHolder.title.setText(schedule.getTitle());
        return convertView;
    }
}
