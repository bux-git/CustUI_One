package com.dqr.www.custui_one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dqr.www.custui_one.utils.DisplayUtil;
import com.dqr.www.custui_one.widgets.rowview.baseview.ContainerView;
import com.dqr.www.custui_one.widgets.rowview.bean.GroupDescriptor;
import com.dqr.www.custui_one.widgets.rowview.listener.OnRowChangedListener;
import com.dqr.www.custui_one.widgets.rowview.normal.NormalDescriptor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnRowChangedListener
{

    private ContainerView  containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerView = (ContainerView) findViewById(R.id.containerView);


        ArrayList<GroupDescriptor> groupDescriptors = new ArrayList<>();
        GroupDescriptor groupDescriptor = new GroupDescriptor();
        NormalDescriptor descriptor1 = new NormalDescriptor(R.drawable.one);
        descriptor1.iconResId(R.drawable.one)
                .actionResId(R.drawable.ic_row_forward)
                .label("图片one")
                .hasAction(true);
        NormalDescriptor descriptor2 = new NormalDescriptor(R.drawable.two);
        descriptor2.iconResId(R.drawable.two)
                .actionResId(R.drawable.ic_row_forward)
                .label("two")
                .hasAction(true);
        NormalDescriptor descriptor3 = new NormalDescriptor(R.drawable.three);
        descriptor3.iconResId(R.drawable.three)
                .actionResId(R.drawable.ic_row_forward)
                .label("three")
                .hasAction(true);

        NormalDescriptor descriptor4 = new NormalDescriptor(R.drawable.four);
        descriptor4.iconResId(R.drawable.four)
                .actionResId(R.drawable.ic_row_forward)
                .label("four")
                .hasAction(false);

        groupDescriptor.addDescriptor(descriptor1);
        groupDescriptor.addDescriptor(descriptor2);
        groupDescriptor.addDescriptor(descriptor3);
        groupDescriptor.addDescriptor(descriptor4);

        groupDescriptor.dividerLayout.setMargins(DisplayUtil.dip2px(this,12),0,0,0);
        groupDescriptor.isHasPaddingTop(false)
                .headerLayout(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(this, 16)))
                .headerPadding(DisplayUtil.dip2px(this,12),0,0,0)
                .bottomPadding(DisplayUtil.dip2px(this,12),0,0,0)
                .setListener(this);


        GroupDescriptor groupDescriptor2 = new GroupDescriptor();

        NormalDescriptor descriptor5 = new NormalDescriptor(R.drawable.five);
        descriptor5.iconResId(R.drawable.five)
                .actionResId(R.drawable.ic_row_forward)
                .label("five")
                .hasAction(true);
        NormalDescriptor descriptor6 = new NormalDescriptor(R.drawable.six);
        descriptor6.iconResId(R.drawable.six)
                .actionResId(R.drawable.ic_row_forward)
                .label("six")
                .hasAction(true);
        NormalDescriptor descriptor7 = new NormalDescriptor(R.drawable.seven);
        descriptor7.iconResId(R.drawable.seven)
                .actionResId(R.drawable.ic_row_forward)
                .label("seven")
                .hasAction(true);

        NormalDescriptor descriptor8 = new NormalDescriptor(R.drawable.eight);
        descriptor8.iconResId(R.drawable.eight)
                .actionResId(R.drawable.ic_row_forward)
                .label("eight")
                .hasAction(false);

        groupDescriptor2.addDescriptor(descriptor5);
        groupDescriptor2.addDescriptor(descriptor6);
        groupDescriptor2.addDescriptor(descriptor7);
        groupDescriptor2.addDescriptor(descriptor8);

        groupDescriptor2.dividerLayout.setMargins(DisplayUtil.dip2px(this,12),0,0,0);
        groupDescriptor2
                .headerLayout(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(this, 16)))
                .headerPadding(DisplayUtil.dip2px(this,12),0,0,0)
                .bottomPadding(DisplayUtil.dip2px(this,12),0,0,0)
                .setListener(this);

        groupDescriptors.add(groupDescriptor);
        groupDescriptors.add(groupDescriptor2);
        containerView.initData(groupDescriptors);

    }

    @Override
    public void onRowChanged(int rowId) {
        Toast.makeText(this,rowId+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRowChanged(int rowId, String content) {

    }
}
