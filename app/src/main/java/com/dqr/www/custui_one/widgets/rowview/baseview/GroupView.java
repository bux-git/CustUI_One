package com.dqr.www.custui_one.widgets.rowview.baseview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dqr.www.custui_one.widgets.rowview.MixDescriptor;
import com.dqr.www.custui_one.widgets.rowview.MixRowView;
import com.dqr.www.custui_one.widgets.rowview.bean.BaseRowDescriptor;
import com.dqr.www.custui_one.widgets.rowview.bean.GroupDescriptor;
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
        setOrientation(VERTICAL);
    }

    public void initData(GroupDescriptor descriptor){
        this.mGroupDescriptor=descriptor;
        setBackgroundResource(descriptor.bgColor);
        notifyDataChanged();
    }

    public void notifyDataChanged(){
        removeAllViews();
        BaseRowView rowView = null;
        View line=null;

        //初始化头label
        if(mGroupDescriptor.isHasPaddingTop||mGroupDescriptor.headerLabel!=null){
            TextView headerView = new TextView(mContext);
            headerView.setBackgroundResource(mGroupDescriptor.headerBgColor);
            headerView.setPadding(mGroupDescriptor.headerPaddingL
                    ,mGroupDescriptor.headerPaddingT
                    ,mGroupDescriptor.headerPaddingR
                    ,mGroupDescriptor.headerPaddingB);
            if(mGroupDescriptor.headerLabel!=null){
                if(mGroupDescriptor.headerTextColor>0){
                    headerView.setTextColor(getResources().getColor(mGroupDescriptor.headerTextColor));
                }
                if(mGroupDescriptor.headerSize>0){
                    headerView.setTextSize(TypedValue.COMPLEX_UNIT_SP,mGroupDescriptor.headerSize);
                }
                if(mGroupDescriptor.isHeaderHtml){
                    headerView.setText(Html.fromHtml(mGroupDescriptor.headerLabel));
                    headerView.setMovementMethod(LinkMovementMethod.getInstance());
                }else{
                    headerView.setText(mGroupDescriptor.headerLabel);
                }
            }
            addView(headerView, mGroupDescriptor.headerLayout);
        }


        BaseRowDescriptor descriptor=null;
        if(mGroupDescriptor.mDescriptors!=null&&mGroupDescriptor.mDescriptors.size()>0){
            for(int i=0;i<mGroupDescriptor.mDescriptors.size();i++){
                descriptor = mGroupDescriptor.mDescriptors.get(i);

                if(descriptor instanceof NormalDescriptor){
                    rowView = new NormalRowView(mContext);
                }else if(descriptor instanceof MixDescriptor){
                    rowView = new MixRowView(mContext);
                }
                rowView.setId(descriptor.rowId);
                rowView.setListener(mGroupDescriptor.mListener);
                rowView.notifyDataChanged(descriptor);
                addView(rowView);
                if(i!=mGroupDescriptor.mDescriptors.size()-1){
                    line = new View(mContext);
                    line.setBackgroundResource(mGroupDescriptor.dividerColor);
                    addView(line,mGroupDescriptor.dividerLayout);
                }
            }
        }
        if(mGroupDescriptor.bottomLabel!=null){
            TextView bottomView = new TextView(mContext);
            bottomView.setText(mGroupDescriptor.bottomLabel);
            bottomView.setTextColor(getResources().getColor(mGroupDescriptor.bottomTextColor));
            bottomView.setBackgroundResource(mGroupDescriptor.bottomBgColor);
            bottomView.setPadding(mGroupDescriptor.bottomPaddingL
                    ,mGroupDescriptor.bottomPaddingT
                    ,mGroupDescriptor.bottomPaddingR
                    ,mGroupDescriptor.bottomPaddingB);
            addView(bottomView,mGroupDescriptor.bottomLayout);
        }


    }


}
