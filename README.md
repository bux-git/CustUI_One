# CustUI_One 练习
自定义RowView：它包括RowView，GroupView，ContainerView。实现动态配置生成详情页

![image](https://github.com/bux-git/CustUI_One/raw/master/custui.gif)

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