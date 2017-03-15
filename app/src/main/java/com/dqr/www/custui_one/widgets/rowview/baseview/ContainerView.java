package com.dqr.www.custui_one.widgets.rowview.baseview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dqr.www.custui_one.widgets.rowview.bean.GroupDescriptor;

import java.util.ArrayList;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-15 17:11
 */

public class ContainerView extends LinearLayout {

    private Context mContext;
    private ArrayList<GroupDescriptor> mGroupDescriptors;
    private boolean hasPaddingTop;

    public ContainerView(Context context) {
        super(context);
        initView(context);
    }

    public ContainerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ContainerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ContainerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context){
        this.mContext=context;
        setOrientation(VERTICAL);
    }

    public void initData(ArrayList<GroupDescriptor> groupDescriptors){
        this.mGroupDescriptors=groupDescriptors;
        notifyDataChanged();
    }

    private void notifyDataChanged() {
        removeAllViews();
        if(mGroupDescriptors!=null&&mGroupDescriptors.size()>0){
            GroupView groupView=null;
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            for(int i=0;i<mGroupDescriptors.size();i++){
                groupView = new GroupView(mContext);
                groupView.initData(mGroupDescriptors.get(i).isHasPaddingTop(true));

                addView(groupView,params);
            }
            setVisibility(VISIBLE);
        }else{
            setVisibility(GONE);
        }
    }


}
