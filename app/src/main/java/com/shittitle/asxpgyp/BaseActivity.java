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
        try {
            ShitTitle title_view = findViewById(R.id.shit_title);
            title_view.setLeftFinish(this).setRightGone(false).setLeftImgResourceId(R.mipmap.ic_launcher_round).build();
            /**
             int :textColor, leftImgResourceId, backgroungResourceId, rightImgResourceId;
             boolean :leftGone, rightGone, leftFinish;
             float :titleHeight, titleSize;
             java代码设置优先,如果已经在java代码中设置,再在xml中设置,xml中的设置无效!
             */
        } catch (NullPointerException e) {

        }

    }

    public abstract void onActiityCreate(@Nullable Bundle savedInstanceState);
}
