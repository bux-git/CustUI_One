package com.dqr.www.custui_one.widgets.rowview;

import android.widget.LinearLayout;

import com.dqr.www.custui_one.widgets.rowview.bean.BaseRowDescriptor;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-21 9:29
 */

public class BgImageDescriptor extends BaseRowDescriptor {

    public int mBgImgResId;
    public int mTitleResId;
    public int mDetailResId;
    public boolean isShowEdit = false;
    public int mClickType;
    public LinearLayout.LayoutParams mLayoutParams;

    public BgImageDescriptor(int rowId) {
        super(rowId);
    }

    public static class ClickType {
        public static final int EDIT_CLICK = 0;
        public static final int ITEM_CLICK = 1;

        public static final int EDIT_CLICK_TWO = 2;
        public static final int ITEM_CLICK_TWO = 3;
    }

    public BgImageDescriptor bgImgResId(int bgImgResId) {
        this.mBgImgResId = bgImgResId;
        return this;
    }

    public BgImageDescriptor titleResId(int titleResId) {
        this.mTitleResId = titleResId;
        return this;
    }

    public BgImageDescriptor detailResId(int detailResId) {
        this.mDetailResId = detailResId;
        return this;
    }

    public BgImageDescriptor isShowEdit(boolean isShowEdit) {
        this.isShowEdit = isShowEdit;
        return this;
    }

    public BgImageDescriptor clickType(int clickType) {
        this.mClickType = clickType;
        return this;
    }

    public BgImageDescriptor layoutParams(LinearLayout.LayoutParams layoutParams) {
        this.mLayoutParams = layoutParams;
        return this;
    }
}
