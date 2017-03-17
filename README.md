# CustUI_One 练习
自定义RowView：它包括RowView，GroupView，ContainerView。实现动态配置生成详情页

![image](https://github.com/bux-git/CustUI_One/raw/master/customui.gif)

参考资料： [有心课堂](http://www.stay4it.com/course/12)


使用：

        mContainerView = (ContainerView) findViewById(R.id.containerView);
        //初始化内容数据
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
        //设置事件
        mContainerView.setListener(this);
        //给ContainerView设置数据
        mContainerView.initData(groupDescriptors);