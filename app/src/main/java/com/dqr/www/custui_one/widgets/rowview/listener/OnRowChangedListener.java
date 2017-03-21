package com.dqr.www.custui_one.widgets.rowview.listener;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-14 19:37
 */

public interface OnRowChangedListener {
    void onRowChanged(int rowId);

    void onRowChanged(int rowId, String content);

    void onRowChanged(int rowId,int clickType);
}
