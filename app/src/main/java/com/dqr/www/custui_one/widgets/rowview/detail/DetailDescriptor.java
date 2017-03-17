package com.dqr.www.custui_one.widgets.rowview.detail;

import com.dqr.www.custui_one.widgets.rowview.bean.BaseRowDescriptor;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-16 10:52
 */

public class DetailDescriptor extends BaseRowDescriptor {

    public String itemTitle;
    public String itemMsg;
    public int control;

    public DetailDescriptor(int rowId) {
        super(rowId);
    }

    public DetailDescriptor itemTitle(String itemTitle){
        this.itemTitle=itemTitle;
        return this;
    }


    public DetailDescriptor itemMsg(String itemMsg){
        this.itemMsg=itemMsg;
        return this;
    }


    public DetailDescriptor control(int control){
        this.control=control;
        return this;
    }
}
