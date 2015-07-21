package com.rejulink.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.loopj.android.http.TextHttpResponseHandler;
import com.rejulink.R;
import com.rejulink.activities.BaseActivity;
import com.rejulink.activities.MainActivity;
import com.rejulink.protocols.CMServerAccountProtocol;
import com.rejulink.utils.GlobalDefine;
import com.rejulink.utils.SharedPreferenceHelper;

import org.apache.http.Header;

/**
 * Created by danielzhang on 15/7/2.
 */
public class MoreFragment extends BaseUIFragment implements View.OnClickListener {


    private Button button_more_fragment_sign_out;

    private String account;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        button_more_fragment_sign_out = (Button) view.findViewById(R.id.button_more_fragment_sign_out);
        button_more_fragment_sign_out.setOnClickListener(this);
        account = (String) SharedPreferenceHelper.get(getActivity(), GlobalDefine.SavedAccount, "");
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_more_fragment_sign_out:
                logout();
                break;
        }
    }

    private void logout() {
        CMServerAccountProtocol.logout(getActivity(), account, "123456", new TextHttpResponseHandler() {

            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                backToSignIn();
            }

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                backToSignIn();
            }
        });
    }

    private void backToSignIn() {
        MainActivity activity = (MainActivity) getActivity();
        SharedPreferenceHelper.remove(activity, GlobalDefine.SavedPassword);
        activity.nextActivity = BaseActivity.SIGN_IN_ACTIVITY;
        activity.next();
        activity.finish();
    }
}
