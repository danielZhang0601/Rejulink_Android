package com.rejulink.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rejulink.R;
import com.rejulink.adapters.EventListAdapter;
import com.rejulink.beans.Event;
import com.rejulink.utils.DensityUtil;
import com.rejulink.widgets.swipemenulistview.SwipeMenu;
import com.rejulink.widgets.swipemenulistview.SwipeMenuCreator;
import com.rejulink.widgets.swipemenulistview.SwipeMenuItem;
import com.rejulink.widgets.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

/**
 * Created by danielzhang on 15/7/2.
 */
public class EventFragment extends BaseUIFragment implements SwipeMenuListView.OnMenuItemClickListener {

    private SwipeMenuListView list_view_event_fragment_events;
    private EventListAdapter eventListAdapter;
    private ArrayList<Event> events = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        list_view_event_fragment_events = (SwipeMenuListView) view.findViewById(R.id.list_view_event_fragment_events);
        eventListAdapter = new EventListAdapter(getActivity());
        events = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Event event = new Event();
            event.setTitle("相机" + i + "事件");
            event.setText("人体侦测报警");
            event.setTime(System.currentTimeMillis());
            events.add(event);
        }
        eventListAdapter.setEvents(events);

        list_view_event_fragment_events.setAdapter(eventListAdapter);
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(DensityUtil.dp2px(getActivity(), 90));
                // set a icon
                deleteItem.setIcon(R.mipmap.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        list_view_event_fragment_events.setMenuCreator(creator);
        list_view_event_fragment_events.setOnMenuItemClickListener(this);
        return view;
    }

    @Override
    public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
        events.remove(position);
        eventListAdapter.notifyDataSetChanged();
        return false;
    }
}
