package com.shittitle.asxpgyp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.shittitle.asxpgyp.shittitle.ShitTitle;

public class MainActivity extends BaseActivity {

    @Override
    public void onActiityCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ShitTitle title_view = findViewById(R.id.shit_title);
    }
}
