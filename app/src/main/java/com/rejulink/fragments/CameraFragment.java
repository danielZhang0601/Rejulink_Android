package com.rejulink.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rejulink.R;
import com.rejulink.adapters.CameraListAdapter;
import com.rejulink.beans.Camera;
import com.rejulink.widgets.waterdroplistview.WaterDropListView;

import java.util.ArrayList;

/**
 * Created by danielzhang on 15/7/2.
 */
public class CameraFragment extends BaseUIFragment implements WaterDropListView.IWaterDropListViewListener {

    private WaterDropListView list_view_camera_fragment_camera;
    private CameraListAdapter cameraListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        list_view_camera_fragment_camera = (WaterDropListView) view.findViewById(R.id.list_view_camera_fragment_cameras);
        list_view_camera_fragment_camera.setPullLoadEnable(false);

        //更新数据
        ArrayList<Camera> cameras = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Camera camera = new Camera();
            camera.setName("Camera" + i);
            cameras.add(camera);
        }
        cameraListAdapter.setCameras(cameras);

        list_view_camera_fragment_camera.setAdapter(cameraListAdapter);
        list_view_camera_fragment_camera.setWaterDropListViewListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cameraListAdapter = new CameraListAdapter(getActivity());
    }


    // onresume onpause
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
