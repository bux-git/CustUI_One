package com.dqr.www.custui_one.widgets.rowview.autograph;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.baseview.BaseRowView;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-16 10:30
 */

public class AutographRowView extends BaseRowView<AutographDescriptor> {

    private TextView mTvAutograph;
    private TextView mTvDetailLife;

    public AutographRowView(Context context) {
        super(context);
    }

    public AutographRowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AutographRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AutographRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void initView(Context context) {
        inflate(context, R.layout.autograph_layout, this);
        mTvAutograph = (TextView) findViewById(R.id.autograph);
        mTvDetailLife = (TextView) findViewById(R.id.personal_detail_life);
    }



    @Override
    public void notifyDataChanged(AutographDescriptor descriptor) {
        if(descriptor!=null){
            mTvAutograph.setText(descriptor.autograph);
            mTvDetailLife.setText(descriptor.detailLife);
        }
    }
}
