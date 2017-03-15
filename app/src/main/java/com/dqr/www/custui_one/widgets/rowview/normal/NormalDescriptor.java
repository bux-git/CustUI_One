package com.dqr.www.custui_one.widgets.rowview.normal;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.bean.BaseRowDescriptor;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-14 19:52
 */

public class NormalDescriptor extends BaseRowDescriptor {
    /**
     * 图标资源id
     */
    public int mIconResId;
    /**
     * 标签字符
     */
    public String mLabel;
    /**
     * 是否有事件
     */
    public boolean mHasAction;

    /**
     *指示图标
     */
    public int mActionResId= R.drawable.ic_row_forward;

    public NormalDescriptor(int rowId) {
        super(rowId);
    }

    public NormalDescriptor iconResId(int iconResId){
        this.mIconResId=iconResId;
        return this;
    }

    public NormalDescriptor label(String label){
        this.mLabel=label;
        return this;
    }

    public NormalDescriptor hasAction(boolean hasAction){
        this.mHasAction=hasAction;
        return this;
    }

    public NormalDescriptor actionResId(int actionResId){
        this.mActionResId=actionResId;
        return this;
    }

}
