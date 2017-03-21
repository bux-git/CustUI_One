package com.dqr.www.custui_one.widgets.rowview;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.bean.BaseRowDescriptor;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-15 19:37
 */

public class MixDescriptor extends BaseRowDescriptor {

    public int mGirl;
    public String mNice;
    public String mNumber;
    public boolean mHasAction;
    /**
     * 指示图标
     */
    public int mActionResId = R.drawable.ic_row_forward;

    public MixDescriptor(int rowId) {
        super(rowId);
    }




    public MixDescriptor girl(int girl) {
        this.mGirl = girl;
        return this;
    }

    public MixDescriptor nice(String nice) {
        this.mNice = nice;
        return this;
    }


    public MixDescriptor number(String number) {
        this.mNumber = number;
        return this;
    }

    public MixDescriptor hasAction(boolean hasAction) {
        this.mHasAction = hasAction;
        return this;
    }

    public MixDescriptor actionResId(int actionResId) {
        this.mActionResId = actionResId;
        return this;
    }
}
