package com.rejulink.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rejulink.R;
import com.rejulink.beans.Camera;

import java.util.ArrayList;

/**
 * Created by danielzhang on 15/7/17.
 */
public class CameraListAdapter extends BaseAdapter {

    private ArrayList<Camera> cameras = null;
    private Context context;

    public CameraListAdapter(Context context) {
        this.context = context;
    }

    public void setCameras(ArrayList<Camera> cameras) {
        this.cameras = cameras;
    }

    @Override
    public int getCount() {
        return cameras == null ? 0 : cameras.size();
    }

    @Override
    public Object getItem(int position) {
        return cameras == null ? null : cameras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item_camera, null);
            holder.image_view_list_item_camera_photo = (ImageView) convertView.findViewById(R.id.image_view_list_item_camera_photo);
            holder.image_view_list_item_camera_play = (ImageView) convertView.findViewById(R.id.image_view_list_item_camera_play);
            holder.text_view_list_item_camera_name = (TextView) convertView.findViewById(R.id.text_view_list_item_camera_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (cameras.get(position).getImagePath().isEmpty()) {
            holder.image_view_list_item_camera_play.setVisibility(View.GONE);
        }
        if (cameras.get(position).getName().isEmpty())
            holder.text_view_list_item_camera_name.setText(R.string.list_item_camera_default_name);
        else
            holder.text_view_list_item_camera_name.setText(cameras.get(position).getName());
        return convertView;
    }

    private ViewHolder holder;

    class ViewHolder {
        ImageView image_view_list_item_camera_photo;
        ImageView image_view_list_item_camera_play;
        TextView text_view_list_item_camera_name;
    }
}
