package com.dqr.www.custui_one.widgets.rowview.baseview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.dqr.www.custui_one.widgets.rowview.BgImageDescriptor;
import com.dqr.www.custui_one.widgets.rowview.BgImageRowView;
import com.dqr.www.custui_one.widgets.rowview.MixDescriptor;
import com.dqr.www.custui_one.widgets.rowview.MixRowView;
import com.dqr.www.custui_one.widgets.rowview.autograph.AutographDescriptor;
import com.dqr.www.custui_one.widgets.rowview.autograph.AutographRowView;
import com.dqr.www.custui_one.widgets.rowview.bean.BaseRowDescriptor;
import com.dqr.www.custui_one.widgets.rowview.bean.GroupDescriptor;
import com.dqr.www.custui_one.widgets.rowview.detail.DetailDescriptor;
import com.dqr.www.custui_one.widgets.rowview.detail.DetailRowView;
import com.dqr.www.custui_one.widgets.rowview.listener.OnRowChangedListener;
import com.dqr.www.custui_one.widgets.rowview.normal.NormalDescriptor;
import com.dqr.www.custui_one.widgets.rowview.normal.NormalRowView;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-15 9:25
 */

public class GroupView extends LinearLayout {

    private GroupDescriptor mGroupDescriptor;
    private Context mContext;
    private OnRowChangedListener mListener;

    public GroupView(Context context) {
        super(context);
        initView(context);
    }

    public GroupView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GroupView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GroupView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context){
        this.mContext=context;

    }

    public void initData(GroupDescriptor descriptor){
        this.mGroupDescriptor=descriptor;
        setOrientation(descriptor.mOrientation);
        setBackgroundResource(descriptor.bgColor);
        notifyDataChanged();
    }

    public void notifyDataChanged(){
        removeAllViews();
        BaseRowView rowView = null;
        //初始化头label
        if(mGroupDescriptor.headerView!=null){
            addView(mGroupDescriptor.headerView);
        }

        BaseRowDescriptor descriptor=null;
        if(mGroupDescriptor.mDescriptors!=null&&mGroupDescriptor.mDescriptors.size()>0){
            for(int i=0;i<mGroupDescriptor.mDescriptors.size();i++){
                descriptor = mGroupDescriptor.mDescriptors.get(i);

                if(descriptor instanceof NormalDescriptor){
                    rowView = new NormalRowView(mContext);
                }else if(descriptor instanceof MixDescriptor){
                    rowView = new MixRowView(mContext);
                }else if(descriptor instanceof DetailDescriptor){
                    rowView = new DetailRowView(mContext);
                }else if(descriptor instanceof AutographDescriptor){
                    rowView = new AutographRowView(mContext);
                }else if(descriptor instanceof BgImageDescriptor){
                    rowView = new BgImageRowView(mContext);
                }
                rowView.setId(descriptor.rowId);
                if(mListener!=null) {
                    rowView.setListener(mListener);
                }
                rowView.notifyDataChanged(descriptor);
                addView(rowView);
                if(i!=mGroupDescriptor.mDescriptors.size()-1){
                    if(mGroupDescriptor.dividerResId>0) {
                        addView(inflate(mContext, mGroupDescriptor.dividerResId, null), mGroupDescriptor.dividerParams);
                    }
                }
            }
        }
       if(mGroupDescriptor.bottomView!=null){
            addView(mGroupDescriptor.bottomView);
        }


    }

    public void setListener(OnRowChangedListener listener) {
        mListener = listener;
    }
}
