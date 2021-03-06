package com.shittitle.asxpgyp.shittitle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 2018/1/23.
 */

public class ShitTitle extends LinearLayout {
    private Context context;
    private TextView title_text;
    private ImageView left_img, right_img;
    private String title;
    private LinearLayout back_ground;
    private int textColor, leftImgResourceId, backgroungResourceId, rightImgResourceId;
    private boolean leftGone, rightGone, leftFinish;
    private float titleHeight, titleSize;

    public ShitTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public ShitTitle setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public ShitTitle setLeftImgResourceId(int leftImgResourceId) {
        this.leftImgResourceId = leftImgResourceId;
        return this;
    }

    public ShitTitle setBackgroungResourceId(int backgroungResourceId) {
        this.backgroungResourceId = backgroungResourceId;
        return this;
    }

    public ShitTitle setRightImgResourceId(int rightImgResourceId) {
        this.rightImgResourceId = rightImgResourceId;
        return this;
    }

    public ShitTitle setLeftGone(boolean leftGone) {
        this.leftGone = leftGone;
        return this;
    }

    public ShitTitle setRightGone(boolean rightGone) {
        this.rightGone = rightGone;
        return this;
    }

    public ShitTitle setLeftFinish(boolean leftFinish) {
        this.leftFinish = leftFinish;
        return this;
    }

    public ShitTitle setTitleHeight(float titleHeight) {
        this.titleHeight = titleHeight;
        return this;
    }

    public ShitTitle setTitleSize(float titleSize) {
        this.titleSize = titleSize;
        return this;
    }

    public void build() {
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater inflater = LayoutInflater.from(context);
        View root = inflater.inflate(R.layout.shit_title, this, true);
        title_text = root.findViewById(R.id.title_text);
        title_text.setText(title);
        title_text.setTextSize(titleSize);
        title_text.setTextColor(textColor);
        left_img = root.findViewById(R.id.left_img);
        left_img.setImageResource(leftImgResourceId);
        back_ground = root.findViewById(R.id.back_ground);
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) back_ground.getLayoutParams(); //取控件textView当前的布局参数 linearParams.height = 20;// 控件的高强制设成20
        linearParams.height = (int) titleHeight;
        back_ground.setLayoutParams(linearParams);
        back_ground.setBackgroundResource(backgroungResourceId);
        right_img = root.findViewById(R.id.right_img);
        right_img.setImageResource(rightImgResourceId);
        if (leftGone) {
            left_img.setVisibility(GONE);
        }
        if (rightGone) {
            right_img.setVisibility(GONE);
        }
    }

    @SuppressLint("ResourceAsColor")
    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ShitTitle);
        title = typedArray.getString(R.styleable.ShitTitle_titleText);
        titleHeight = typedArray.getDimension(R.styleable.ShitTitle_titleHeight, 200);
        textColor = typedArray.getColor(R.styleable.ShitTitle_titleColor, R.color.white);
        titleSize = typedArray.getDimension(R.styleable.ShitTitle_titleSize, 15);
        leftImgResourceId = typedArray.getResourceId(R.styleable.ShitTitle_leftImg, R.mipmap.ic_launcher);
        backgroungResourceId = typedArray.getResourceId(R.styleable.ShitTitle_background, R.mipmap.test);
        rightImgResourceId = typedArray.getResourceId(R.styleable.ShitTitle_rightImg, R.mipmap.ic_launcher);
        leftGone = typedArray.getBoolean(R.styleable.ShitTitle_leftGone, false);
        rightGone = typedArray.getBoolean(R.styleable.ShitTitle_rightGone, true);
        leftFinish = typedArray.getBoolean(R.styleable.ShitTitle_leftFinish, true);
        typedArray.recycle();

    }

    public ShitTitle setLeftFinish(final Activity activity) {
        if (leftFinish) {
            left_img.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
        return this;
    }

    public void setLeftListenter(OnClickListener listener) {
        left_img.setOnClickListener(listener);
    }


    public void setRightListenter(OnClickListener listener) {
        right_img.setOnClickListener(listener);
    }
}
