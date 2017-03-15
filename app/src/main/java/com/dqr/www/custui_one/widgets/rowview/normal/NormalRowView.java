package com.dqr.www.custui_one.widgets.rowview.normal;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.baseview.BaseRowView;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-14 20:11
 */

public class NormalRowView extends BaseRowView<NormalDescriptor> implements View.OnClickListener {

    private Context mContext;
    /**
     * 标签图片
     */
    private ImageView mRowIconImg;
    /**
     * 标签说明
     */
    private TextView mRowLabel;
    /**
     * 事件图片
     */
    private ImageView mRowActionImg;



    protected int mBgResId = R.drawable.normal_row_selector;
    protected int mUnNormalBgResId = Color.WHITE;

    public NormalRowView(Context context) {
        super(context);
        this.mContext=context;
        initView();
    }

    public NormalRowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        initView();
    }

    public NormalRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NormalRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mContext=context;
        initView();
    }

    /**
     * 初始化View
     */
    private void initView(){
        LayoutInflater.from(mContext).inflate(R.layout.normal_view_layout, this);
        mRowIconImg = (ImageView) findViewById(R.id.mRowIconImg);
        mRowLabel = (TextView) findViewById(R.id.mRowLabel);
        mRowActionImg = (ImageView) findViewById(R.id.mRowActionImg);
    }


    @Override
    public void notifyDataChanged(NormalDescriptor descriptor) {
        this.descriptor=descriptor;
        if(descriptor!=null){
            setMinimumHeight((int) (50 * getResources().getDisplayMetrics().density));
            if(descriptor.mIconResId>0){
                mRowIconImg.setImageResource(descriptor.mIconResId);
                mRowIconImg.setVisibility(VISIBLE);
            }else{
                mRowIconImg.setVisibility(GONE);
            }
            mRowLabel.setText(descriptor.mLabel);

            if(descriptor.mHasAction&&descriptor.rowId>0){
                setOnClickListener(this);
                setBackgroundResource(mBgResId);
                mRowActionImg.setImageResource(descriptor.mActionResId);
                mRowActionImg.setVisibility(VISIBLE);
            }else{
                setBackgroundColor(mUnNormalBgResId);
                mRowActionImg.setVisibility(GONE);
            }

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
