package com.dqr.www.custui_one.widgets.rowview.bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dqr.www.custui_one.R;

import java.util.ArrayList;


/**
 * Description：Group 数据bean
 * Author：LiuYM
 * Date： 2017-03-14 19:26
 */

public class GroupDescriptor {


    public View headerView;
    //底部标签栏设置
    public View bottomView;

    //分割线设置
    public int dividerResId= R.layout.divider_line_layout;
    public LinearLayout.LayoutParams dividerParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);

    //背景颜色
    public int bgColor = android.R.color.white;

    //方向
    public int mOrientation=LinearLayout.VERTICAL;

    public ArrayList<BaseRowDescriptor> mDescriptors;



    public GroupDescriptor addDescriptor(BaseRowDescriptor descriptor) {
        if (mDescriptors == null) {
            mDescriptors = new ArrayList<>();
        }
        mDescriptors.add(descriptor);
        return this;
    }


    public GroupDescriptor bgColor(int bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public GroupDescriptor headerView(Context context){
        this.headerView= LayoutInflater.from(context).inflate(R.layout.normal_split_view,null);
        headerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,40));
        return this;
    }

    public GroupDescriptor headerView(View  headerView){
        this.headerView=headerView;
        return this;
    }



    public GroupDescriptor bottomView(Context context){
        this.bottomView= LayoutInflater.from(context).inflate(R.layout.normal_split_view,null);
        bottomView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,40));
        return this;
    }

    public GroupDescriptor bottomView(View  bottomView){
        this.bottomView=headerView;
        return this;
    }

    public GroupDescriptor divider(int resId,LinearLayout.LayoutParams params){
            this.dividerResId=resId;
            dividerParams=params;


        return this;
    }


    public GroupDescriptor orientation(int orientation){
        this.mOrientation=orientation;
        return this;
    }

}
