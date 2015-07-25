package com.rejulink.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rejulink.R;
import com.rejulink.beans.Event;

import java.util.ArrayList;

/**
 * Created by danielzhang on 15/7/17.
 */
public class EventListAdapter extends BaseAdapter {

    private ArrayList<Event> events = null;
    private Context context;
    private ViewHolder holder;

    public EventListAdapter(Context context) {
        this.context = context;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public int getCount() {
        return events == null ? 0 : events.size();
    }

    @Override
    public Object getItem(int position) {
        return events == null ? null : events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item_event, null);
            holder.image_view_list_item_event_image = (ImageView) convertView.findViewById(R.id.image_view_list_item_event_image);
            holder.text_view_list_item_event_title = (TextView) convertView.findViewById(R.id.text_view_list_item_event_title);
            holder.text_view_list_item_event_text = (TextView) convertView.findViewById(R.id.text_view_list_item_event_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text_view_list_item_event_title.setText(events.get(position).getTitle());
        holder.text_view_list_item_event_text.setText(events.get(position).getText());
        return convertView;
    }

    class ViewHolder {
        ImageView image_view_list_item_event_image;
        TextView text_view_list_item_event_title;
        TextView text_view_list_item_event_text;
    }
}
