package com.dqr.www.custui_one.widgets.rowview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.baseview.BaseRowView;

import static com.dqr.www.custui_one.R.id.tv_nice;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-15 19:43
 */

public class MixRowView extends BaseRowView<MixDescriptor> implements View.OnClickListener {

    private Context mContext;

    private ImageView mIvGirl;
    private TextView mNice;
    private TextView mNumber;
    private ImageView mIvAction;

    public MixRowView(Context context) {
        super(context);
        initView(context);
    }

    public MixRowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MixRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MixRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context){
        mContext=context;
        inflate(context, R.layout.img_header_layout, this);
        mIvGirl = (ImageView) findViewById(R.id.iv_girl);
        mNice = (TextView) findViewById(tv_nice);
        mNumber = (TextView) findViewById(R.id.tv_number);
        mIvAction = (ImageView) findViewById(R.id.mRowActionImg);

    }



    @Override
    public void notifyDataChanged(MixDescriptor descriptor) {
        this.descriptor=descriptor;
        if(descriptor!=null){
            if(descriptor.mGirl>0) {
                mIvGirl.setImageResource(descriptor.mGirl);
                mIvGirl.setOnClickListener(this);
                mIvGirl.setVisibility(VISIBLE);
            }else{
                mIvGirl.setVisibility(GONE);
            }
            mNice.setText(descriptor.mNice);
            mNumber.setText(descriptor.mNumber);

            if(descriptor.mHasAction&&descriptor.rowId>0){
                mIvAction.setImageResource(descriptor.mActionResId);
                mIvAction.setVisibility(VISIBLE);
                setOnClickListener(this);
                setBackgroundResource(mBgResId);
            }else{
                mIvAction.setVisibility(GONE);
                setBackgroundResource(mUnNormalBgResId);
            }

            setVisibility(VISIBLE);
        }else{
            setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if(mListener!=null){
            mListener.onRowChanged(descriptor.rowId);
        }
    }
}
