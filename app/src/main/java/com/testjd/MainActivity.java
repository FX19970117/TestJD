package com.testjd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.title)
    RecyclerView title;
    @InjectView(R.id.content)
    RecyclerView content;
    @InjectView(R.id.list_fenlei)
    LinearLayout listFenlei;
    private TitleAdapter titleAdapter;
    private FenleiAdapter fenleiAdapter;



    private String firstItem[] = { "全部", "电影", "旅游", "酒店", "美食", "娱乐" };
    String secondItem[][] = new String[][] {
            new String[] { "全部", "铁路票务", "航空票务", "租车服务", "公路票务", "接车服务",
                    "包车服务", "游船" },
            new String[] { "全部", "导游预定", "工业园", "民俗庙会", "温泉养生", "签证办理", "景区门票",
                    "旅游向导", "景区餐饮" },
            new String[] { "全部", "酒店预订", "度假别墅", "农家乐预订", "景区户外露宿点", "提醒服务" },
            new String[] { "全部", "经典名吃", "旅游团餐", "自助餐", "特色美食", "特色美食咨询" },
            new String[] { "全部", "景区娱乐项目", "大型演出", "水上项目", "主题游乐园", "滑雪场",
                    "主题公园", "游轮" },
            new String[] { "全部", " 特色产品订购", "旅游纪念品订购", "户外用品订购", "工艺品订购",
                    " 收藏品订购", "奢侈品订购" } };

//    List<String> list = new ArrayList<>();
//    List<String> clickList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);



        initData();




        LinearLayoutManager layoutManager  = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        titleAdapter = new TitleAdapter(this,firstItem);
        title.setLayoutManager(layoutManager);
        //设置Adapter
        title.setAdapter( titleAdapter);
        //设置分隔线
        title.addItemDecoration( new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //设置增加或删除条目的动画
        title.setItemAnimator( new DefaultItemAnimator());


        LinearLayoutManager Manager  = new LinearLayoutManager(getApplicationContext());
        Manager.setOrientation(LinearLayoutManager.VERTICAL);
        fenleiAdapter = new FenleiAdapter(this,secondItem[0]);
        content.setLayoutManager(Manager);
        //设置Adapter
        content.setAdapter( fenleiAdapter);
        //设置分隔线
        content.addItemDecoration( new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //设置增加或删除条目的动画
        content.setItemAnimator( new DefaultItemAnimator());



        titleAdapter.setOnItemClickLitener(new TitleAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                fenleiAdapter.refresh(secondItem[position]);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });


    }

    private void initData() {

    }
}
