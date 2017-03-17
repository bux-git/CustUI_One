package com.dqr.www.custui_one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dqr.www.custui_one.utils.DisplayUtil;
import com.dqr.www.custui_one.widgets.rowview.autograph.AutographDescriptor;
import com.dqr.www.custui_one.widgets.rowview.baseview.ContainerView;
import com.dqr.www.custui_one.widgets.rowview.bean.GroupDescriptor;
import com.dqr.www.custui_one.widgets.rowview.detail.DetailDescriptor;
import com.dqr.www.custui_one.widgets.rowview.listener.OnRowChangedListener;

import java.util.ArrayList;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-16 11:11
 */

public class DetailActivity extends AppCompatActivity implements OnRowChangedListener {

    private static final String TAG = "DetailActivity";
    private static final int AUTOGRAPH = 0;
    private static final int REAL_NAME = 1;
    private static final int NICE = 2;
    private static final int OCCUPATION = 3;
    private static final int EDUCATION = 4;


    private ContainerView mContainerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_layout);
        setTitle("个人详情");

        init();


    }

    private void init() {
        mContainerView = (ContainerView) findViewById(R.id.containerView);
        //初始化内容也数据
        ArrayList<GroupDescriptor> groupDescriptors = new ArrayList<>();

        //初始化第一组Group数据
        GroupDescriptor group1 = new GroupDescriptor();
        //初始化第一个Item数据
        AutographDescriptor autographDescriptor = new AutographDescriptor(AUTOGRAPH);
        autographDescriptor.autograph("个性签名")
                .detailLife("清明时节雨纷纷");
        group1.addDescriptor(autographDescriptor)
                .headerView(this);
        groupDescriptors.add(group1);

        GroupDescriptor group2 = new GroupDescriptor();
        LinearLayout.LayoutParams group2Header = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(this, 36));
        View view = getLayoutInflater().inflate(R.layout.split_tv_left_layout, null);
        view.setLayoutParams(group2Header);
        DetailDescriptor realDesc = new DetailDescriptor(REAL_NAME);
        realDesc.itemTitle("真实姓名")
                .itemMsg("不修")
                .control(0);

        DetailDescriptor nice = new DetailDescriptor(NICE);
        nice.itemTitle("昵称")
                .itemMsg("不修")
                .control(0);

        group2.addDescriptor(realDesc)
                .addDescriptor(nice)
                .headerView(view);
        groupDescriptors.add(group2);

        GroupDescriptor group3 = new GroupDescriptor();
        DetailDescriptor mOccupation = new DetailDescriptor(OCCUPATION);
        mOccupation.itemTitle("职业")
                .itemMsg("淘宝软件开发")
                .control(0);

        DetailDescriptor education = new DetailDescriptor(EDUCATION);
        education.itemTitle("学历")
                .itemMsg("本科")
                .control(0);

        group3.headerView(this)
                .addDescriptor(mOccupation)
                .addDescriptor(education);
        groupDescriptors.add(group3);

        mContainerView.setListener(this);
        mContainerView.initData(groupDescriptors);

    }


    @Override
    public void onRowChanged(int rowId) {
        DetailDescriptor desc = null;
        switch (rowId) {
            case REAL_NAME:
                desc = new DetailDescriptor(REAL_NAME);
                desc.itemTitle("真实姓名")
                        .itemMsg("不修")
                        .control(1);

                break;
            case NICE:
                desc = new DetailDescriptor(NICE);
                desc.itemTitle("昵称")
                        .itemMsg("不修")
                        .control(1);
                break;
            case OCCUPATION:
                desc = new DetailDescriptor(OCCUPATION);
                desc.itemTitle("职业")
                        .itemMsg("淘宝软件开发")
                        .control(1);
                break;
            case EDUCATION:
                desc = new DetailDescriptor(EDUCATION);
                desc.itemTitle("学历")
                        .itemMsg("本科")
                        .control(1);
                break;

        }
        mContainerView.DataChangeById(rowId, desc);
    }

    @Override
    public void onRowChanged(int rowId, String content) {

    }
}
