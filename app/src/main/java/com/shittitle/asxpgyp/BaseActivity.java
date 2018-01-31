package com.shittitle.asxpgyp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shittitle.asxpgyp.shittitle.ShitTitle;

/**
 * Created by user on 2018/1/31.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onActiityCreate(savedInstanceState);
        ShitTitle title_view = findViewById(R.id.shit_title);
        if (null != title_view) {
            title_view.setLeftFinish(this);
        }
    }

    public abstract void onActiityCreate(@Nullable Bundle savedInstanceState);
}
