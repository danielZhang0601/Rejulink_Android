package com.rejulink.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.rejulink.R;

/**
 * Created by danielzhang on 15/7/24.
 */
public class PersonInfoActivity extends BaseActivity {

    public static void launchActivity(Context context){
        context.startActivity(new Intent(context,PersonInfoActivity.class));
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_person_info);
    }
}
