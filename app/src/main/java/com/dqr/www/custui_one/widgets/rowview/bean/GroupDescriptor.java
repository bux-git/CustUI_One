package com.dqr.www.custui_one.widgets.rowview.bean;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.listener.OnRowChangedListener;

import java.util.ArrayList;


/**
 * Description：Group 数据bean
 * Author：LiuYM
 * Date： 2017-03-14 19:26
 */

public class GroupDescriptor {


    //头部标签栏设置
    public String headerLabel;
    public boolean isHeaderHtml;
    public int headerSize;
    public int headerTextColor= android.R.color.darker_gray;
    public int headerBgColor =R.color.holo_gray_bright;
    public LinearLayout.LayoutParams headerLayout=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    public int headerPaddingL;
    public int headerPaddingT;
    public int headerPaddingR;
    public int headerPaddingB;

    //底部标签栏设置
    public int bottomSize;
    public int bottomTextColor= android.R.color.darker_gray;
    public int bottomBgColor =R.color.holo_gray_bright;
    public String bottomLabel;
    public LinearLayout.LayoutParams bottomLayout=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    public int bottomPaddingL;
    public int bottomPaddingT;
    public int bottomPaddingR;
    public int bottomPaddingB;

    //分割线设置
    public int dividerColor =android.R.color.darker_gray;
    public LinearLayout.LayoutParams dividerLayout=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1);


    //背景颜色
    public int bgColor =android.R.color.white;

    public boolean isHasPaddingTop=false;

    public ArrayList<BaseRowDescriptor> mDescriptors;
    public OnRowChangedListener mListener;


    public GroupDescriptor headerPadding(int headerPaddingL,int headerPaddingT,int headerPaddingR,int headerPaddingB){
        this.headerPaddingL=headerPaddingL;
        this.headerPaddingT=headerPaddingT;
        this.headerPaddingR=headerPaddingR;
        this.headerPaddingB=headerPaddingB;
        return this;
    }

    public GroupDescriptor bottomPadding(int bottomPaddingL,int bottomPaddingT,int bottomPaddingR,int bottomPaddingB){
        this.bottomPaddingL=bottomPaddingL;
        this.bottomPaddingT=bottomPaddingT;
        this.bottomPaddingR=bottomPaddingR;
        this.bottomPaddingB=bottomPaddingB;
        return this;
    }

    public GroupDescriptor addDescriptor(BaseRowDescriptor descriptor){
        if(mDescriptors==null){
            mDescriptors = new ArrayList<>();
        }
        mDescriptors.add(descriptor);
        return this;
    }

    public GroupDescriptor dividerLayout(LinearLayout.LayoutParams dividerLayout){
        this.dividerLayout=dividerLayout;
        return this;
    }

    public GroupDescriptor bottomLayout(LinearLayout.LayoutParams bottomLayout){
        this.bottomLayout=bottomLayout;
        return this;
    }

    public GroupDescriptor headerLayout(LinearLayout.LayoutParams headerLayout){
        this.headerLayout=headerLayout;
        return this;
    }

    public GroupDescriptor isHasPaddingTop(boolean isHasPaddingTop){
        this.isHasPaddingTop=isHasPaddingTop;
        return this;
    }

    public GroupDescriptor headerLabel(String headerLabel){
        this.headerLabel=headerLabel;
        return this;
    }

    public GroupDescriptor isHeaderHtml(boolean isHeaderHtml){
        this.isHeaderHtml=isHeaderHtml;
        return this;
    }

    public GroupDescriptor headerSize(int headerSize){
        this.headerSize=headerSize;
        return this;
    }

    public GroupDescriptor headerBgColor(int headerBgColor){
        this.headerBgColor=headerBgColor;
        return this;
    }

    public GroupDescriptor bottomLabel(String bottomLabel){
        this.bottomLabel=bottomLabel;
        return this;
    }

    public GroupDescriptor bgColor(int bgColor){
        this.bgColor=bgColor;
        return this;
    }

    public GroupDescriptor dividerColor(int dividerColor){
        this.dividerColor=dividerColor;
        return this;
    }

    public GroupDescriptor headerTextColor(int headerTextColor){
        this.headerTextColor=headerTextColor;
        return this;
    }

    public GroupDescriptor bottomSize(int bottomSize){
        this.bottomSize=bottomSize;
        return this;
    }

    public GroupDescriptor bottomTextColor(int bottomTextColor){
        this.bottomTextColor=bottomTextColor;
        return this;
    }

    public GroupDescriptor bottomBgColor(int bottomBgColor){
        this.bottomBgColor=bottomBgColor;
        return this;
    }
    public GroupDescriptor setListener(OnRowChangedListener listener){
        this.mListener=listener;
        return this;
    }



}
