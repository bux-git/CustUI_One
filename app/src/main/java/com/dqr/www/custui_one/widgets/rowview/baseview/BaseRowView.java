package com.dqr.www.custui_one.widgets.rowview.baseview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.bean.BaseRowDescriptor;
import com.dqr.www.custui_one.widgets.rowview.listener.OnRowChangedListener;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-14 19:35
 */

public abstract class BaseRowView<T extends BaseRowDescriptor> extends LinearLayout {

    protected  Context mContext;
    protected int mBgResId = R.drawable.normal_row_selector;
    protected int mUnNormalBgResId =android.R.color.white;
    protected OnRowChangedListener mListener;
    protected T descriptor;

    public BaseRowView(Context context) {
        super(context);
        mContext=context;
        initView(context);
    }

    public BaseRowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView(context);
    }

    public BaseRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext=context;
        initView(context);
    }

    public void setListener(OnRowChangedListener listener) {
        mListener = listener;
    }

    public void setBgResId(int bgResId) {
        mBgResId = bgResId;
    }

    public abstract void initView(Context context);
    public abstract void notifyDataChanged(T descriptor);

    public void notifyDataChanged(String content) {

    }


    public String getContent() {
        return null;
    }

}
