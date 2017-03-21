package com.dqr.www.custui_one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dqr.www.custui_one.widgets.rowview.BgImageDescriptor;
import com.dqr.www.custui_one.widgets.rowview.MixDescriptor;
import com.dqr.www.custui_one.widgets.rowview.baseview.ContainerView;
import com.dqr.www.custui_one.widgets.rowview.bean.GroupDescriptor;
import com.dqr.www.custui_one.widgets.rowview.listener.OnRowChangedListener;

import java.util.ArrayList;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-21 10:16
 */

public class BgImgActivity extends AppCompatActivity implements OnRowChangedListener {

    private static final String TAG = "BgImgActivity";
    public static final int ROW_ZERO = 8;
    public static final int ROW_ONE = 0;
    public static final int ROW_TWO = 1;
    public static final int ROW_THREE = 2;
    public static final int ROW_FOUR = 3;
    public static final int ROW_FIVE = 4;
    public static final int ROW_SIX = 5;
    public static final int ROW_SEVEN = 6;
    public static final int ROW_EIGHT = 7;


    private ContainerView mContainerView;

    private float density = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bg_img_layout);
        mContainerView = (ContainerView) findViewById(R.id.containerView);
        density = getResources().getDisplayMetrics().density;
        initView();


    }

    private void initView() {
        ArrayList<GroupDescriptor> groupDescriptors = new ArrayList<>();


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.weight = 1;
        int left = (int) (5 * density);
        int top = (int) (5 * density);
        int right = (int) (5 * density);
        int bottom = (int) (5 * density);

        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        layoutParams.rightMargin = right;
        layoutParams.bottomMargin = bottom;


        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams2.leftMargin = left;
        layoutParams2.topMargin = top;
        layoutParams2.rightMargin = right;
        layoutParams2.bottomMargin = bottom;


        GroupDescriptor groupDescriptor0 = new GroupDescriptor();
        MixDescriptor mixDescriptor = new MixDescriptor(ROW_ZERO);
        mixDescriptor.girl(R.drawable.girl)
                .hasAction(true)
                .number("471025458")
                .nice("不修");
        groupDescriptor0.addDescriptor(mixDescriptor)
                .headerView(this)
                .bottomView(this);


        //激活中心  地球人收益
        GroupDescriptor groupDescriptor = new GroupDescriptor();
        BgImageDescriptor friend = new BgImageDescriptor(ROW_ONE);
        friend.isShowEdit(true)
                .detailResId(R.string.mine_tv_friend_detail)
                .titleResId(R.string.mine_tv_friend_title)
                .bgImgResId(R.drawable.bg_mine_friend)
                .layoutParams(layoutParams);

        BgImageDescriptor yield = new BgImageDescriptor(ROW_TWO);
        yield.isShowEdit(false)
                .detailResId(R.string.mine_tv_yield_detail)
                .titleResId(R.string.mine_tv_yield)
                .bgImgResId(R.drawable.bg_mine_yield)
                .layoutParams(layoutParams);

        groupDescriptor.addDescriptor(friend)
                .addDescriptor(yield)
                .orientation(LinearLayout.HORIZONTAL)
                .divider(0, null);


        //成长路程
        BgImageDescriptor diary = new BgImageDescriptor(ROW_THREE);
        diary.isShowEdit(false)
                .detailResId(R.string.mine_tv_diary_detail)
                .titleResId(R.string.mine_tv_diary_title)
                .bgImgResId(R.drawable.bg_mine_diary)
                .layoutParams(layoutParams2);

        GroupDescriptor groupDescriptor1 = new GroupDescriptor();
        groupDescriptor1.addDescriptor(diary)
                .divider(0, null)
                .orientation(LinearLayout.HORIZONTAL);

        //时光相册 生活视频
        GroupDescriptor groupDescriptor2 = new GroupDescriptor();
        BgImageDescriptor album = new BgImageDescriptor(ROW_FOUR);
        album.isShowEdit(true)
                .detailResId(R.string.mine_tv_album_detail)
                .titleResId(R.string.mine_tv_album_title)
                .bgImgResId(R.drawable.bg_mine_album)
                .layoutParams(layoutParams);

        BgImageDescriptor video = new BgImageDescriptor(ROW_FIVE);
        video.isShowEdit(true)
                .detailResId(R.string.mine_tv_video_detail)
                .titleResId(R.string.mine_tv_video_title)
                .bgImgResId(R.drawable.bg_mine_video)
                .layoutParams(layoutParams);

        groupDescriptor2.addDescriptor(album)
                .addDescriptor(video)
                .orientation(LinearLayout.HORIZONTAL)
                .divider(0, null);


        //地球人名片
        BgImageDescriptor card = new BgImageDescriptor(ROW_SIX);
        card.isShowEdit(true)
                .detailResId(R.string.mine_tv_card_detail)
                .titleResId(R.string.mine_tv_card_title)
                .bgImgResId(R.drawable.bg_mine_card)
                .layoutParams(layoutParams2);

        GroupDescriptor groupDescriptor3 = new GroupDescriptor();
        groupDescriptor3.addDescriptor(card)
                .divider(0, null)
                .orientation(LinearLayout.HORIZONTAL);


        //智能生活 祝福视频
        GroupDescriptor groupDescriptor4 = new GroupDescriptor();
        BgImageDescriptor smart = new BgImageDescriptor(ROW_SEVEN);
        smart.isShowEdit(true)
                .detailResId(R.string.mine_tv_smart_life_detail)
                .titleResId(R.string.mine_tv_smart_life_title)
                .bgImgResId(R.drawable.bg_mine_smart_life)
                .layoutParams(layoutParams);

        BgImageDescriptor yearVideo = new BgImageDescriptor(ROW_EIGHT);
        yearVideo.isShowEdit(false)
                .detailResId(R.string.mine_tv_new_year_video_detail)
                .titleResId(R.string.mine_tv_new_year_video_title)
                .bgImgResId(R.drawable.my_blessing_video)
                .layoutParams(layoutParams);

        groupDescriptor4.addDescriptor(smart)
                .addDescriptor(yearVideo)
                .orientation(LinearLayout.HORIZONTAL)
                .divider(0, null);


        groupDescriptors.add(groupDescriptor0);
        groupDescriptors.add(groupDescriptor);
        groupDescriptors.add(groupDescriptor1);
        groupDescriptors.add(groupDescriptor2);
        groupDescriptors.add(groupDescriptor3);
        groupDescriptors.add(groupDescriptor4);
        mContainerView.setListener(this);
        mContainerView.initData(groupDescriptors);


    }


    @Override
    public void onRowChanged(int rowId) {
        String toastStr = "";
        switch (rowId) {
            case ROW_ZERO:
                toastStr = "头部Item点击";
                break;
            case R.id.iv_girl:
                toastStr = "头像点击";
                break;
        }
        Toast.makeText(BgImgActivity.this, toastStr, Toast.LENGTH_SHORT).show();
        ;
    }

    @Override
    public void onRowChanged(int rowId, String content) {

    }

    @Override
    public void onRowChanged(int rowId, int clickType) {
        String toastStr = "";
        switch (rowId) {
            case ROW_ZERO:
                toastStr = "头部Item点击";
                break;
            case R.id.iv_girl:
                toastStr = "头像点击";
                break;
            default:
                if (clickType == BgImageDescriptor.ClickType.ITEM_CLICK) {
                    toastStr = "背景点击";
                } else if (clickType == BgImageDescriptor.ClickType.EDIT_CLICK) {
                    toastStr = "编辑按钮点击";
                }
                break;
        }
        Toast.makeText(BgImgActivity.this, toastStr, Toast.LENGTH_SHORT).show();
        ;
    }
}
