package com.dqr.www.custui_one.widgets.rowview.bean;

import android.view.View;

/**
 * Description：Row 基类
 * Author：LiuYM
 * Date： 2017-03-14 19:19
 */

public abstract  class BaseRowDescriptor {

    public int rowId= View.NO_ID;

    public BaseRowDescriptor(int rowId) {
        this.rowId = rowId;
    }
}
