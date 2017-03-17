package com.dqr.www.custui_one.widgets.rowview.autograph;

import com.dqr.www.custui_one.widgets.rowview.bean.BaseRowDescriptor;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-16 10:27
 */

public class AutographDescriptor extends BaseRowDescriptor {

    public String autograph;
    public String detailLife;

    public AutographDescriptor(int rowId) {
        super(rowId);
    }

    public AutographDescriptor autograph(String autograph){
        this.autograph=autograph;
        return this;
    }

    public AutographDescriptor detailLife(String detailLife){
        this.detailLife=detailLife;
        return this;
    }
}
