package com.dqr.www.custui_one.widgets.rowview.detail;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.baseview.BaseRowView;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-16 10:57
 */

public class DetailRowView extends BaseRowView<DetailDescriptor> {

    private static final String TAG = "DetailRowView";
    
    private TextView mTvItemTitle;
    private TextView mTvItemMsg;
    private Button mBtnControl;


    public DetailRowView(Context context) {
        super(context);
    }

    public DetailRowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DetailRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void initView(Context context) {
        inflate(context, R.layout.item_detail_layout, this);
        mTvItemTitle = (TextView) findViewById(R.id.tv_item_title);
        mTvItemMsg = (TextView) findViewById(R.id.tv_item_msg);
        mBtnControl = (Button) findViewById(R.id.btn_item_control);
    }

    @Override
    public void notifyDataChanged(final DetailDescriptor descriptor) {
        if(descriptor!=null){
            mTvItemTitle.setText(descriptor.itemTitle);
            mTvItemMsg.setText(descriptor.itemMsg);
            if(descriptor.control==0){//显示 钥匙
              mTvItemMsg.setVisibility(GONE);
              mBtnControl.setBackgroundResource(R.drawable.ic_key);
                mBtnControl.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mListener!=null){
                            mListener.onRowChanged(descriptor.rowId);
                        }
                    }
                });
            }else if(descriptor.control==1){//直接显示MSG
                mBtnControl.setVisibility(GONE);
                mTvItemMsg.setVisibility(VISIBLE);
            }else{//显示锁 不显示内容
                mTvItemMsg.setVisibility(GONE);
                mBtnControl.setBackgroundResource(R.drawable.ic_lock);
            }
        }
    }
}
