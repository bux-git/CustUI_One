package com.dqr.www.custui_one.widgets.rowview.bean;

import android.view.View;
import android.widget.LinearLayout;

/**
 * Description：Row 基类
 * Author：LiuYM
 * Date： 2017-03-14 19:19
 */

public abstract  class BaseRowDescriptor {

    public int rowId= View.NO_ID;

    public LinearLayout.LayoutParams mLayoutParams;

    public BaseRowDescriptor(int rowId) {
        this.rowId = rowId;
    }

    public BaseRowDescriptor layoutParams(LinearLayout.LayoutParams layoutParams) {
        this.mLayoutParams = layoutParams;
        return this;
    }


}
