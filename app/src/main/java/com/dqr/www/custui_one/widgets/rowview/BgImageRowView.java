package com.dqr.www.custui_one.widgets.rowview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dqr.www.custui_one.R;
import com.dqr.www.custui_one.widgets.rowview.baseview.BaseRowView;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-21 9:29
 */

public class BgImageRowView extends BaseRowView<BgImageDescriptor> implements View.OnClickListener {

    private ImageView ivBgImageOne;
    private Button btnEditOne;
    private TextView tvTitleOne;
    private TextView tvDetailOne;

    private int mClickType=BgImageDescriptor.ClickType.ITEM_CLICK;


    public BgImageRowView(Context context) {
        super(context);
    }

    public BgImageRowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BgImageRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BgImageRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void initView(Context context) {
        inflate(context, R.layout.bg_img_one_layout, this);
        ivBgImageOne = (ImageView) findViewById(R.id.ivBgImageOne);
        btnEditOne = (Button) findViewById(R.id.btnEditOne);
        tvTitleOne = (TextView) findViewById(R.id.tvTitleOne);
        tvDetailOne = (TextView) findViewById(R.id.tvDetailOne);


    }

    @Override
    public void notifyDataChanged(BgImageDescriptor descriptor) {
        if(descriptor!=null){
            if(descriptor.mLayoutParams!=null) {
                setLayoutParams(descriptor.mLayoutParams);
            }
            if(descriptor.isShowEdit){//编辑按钮事件
                btnEditOne.setVisibility(VISIBLE);
                btnEditOne.setOnClickListener(this);

            }else{
                btnEditOne.setVisibility(GONE);
            }
            if(descriptor.mBgImgResId>0){
                ivBgImageOne.setImageResource(descriptor.mBgImgResId);
                ivBgImageOne.setOnClickListener(this);

            }
            if(descriptor.mTitleResId>0){
                tvTitleOne.setText(descriptor.mTitleResId);
            }
            if(descriptor.mDetailResId>0){
                tvDetailOne.setText(descriptor.mDetailResId);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(mListener!=null){
            switch (v.getId()){
                case R.id.btnEditOne:
                    mClickType= BgImageDescriptor.ClickType.EDIT_CLICK;
                    break;
                case R.id.ivBgImageOne:
                    mClickType= BgImageDescriptor.ClickType.ITEM_CLICK;
                    break;
            }
            mListener.onRowChanged(v.getId(),mClickType);
        }
    }
}
