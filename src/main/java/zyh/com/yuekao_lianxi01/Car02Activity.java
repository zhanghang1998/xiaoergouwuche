package zyh.com.yuekao_lianxi01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zyh.com.adapter.carshop.LeftAdapter;
import zyh.com.adapter.carshop.RightAdapter;
import zyh.com.bean.carshop02.LeftRlistBean;
import zyh.com.bean.carshop02.MyResult;
import zyh.com.bean.carshop02.RightRlistBean;
import zyh.com.core.DataCall;
import zyh.com.presenter.car02.LeftPresenter;
import zyh.com.presenter.car02.RightPresenter;

public class Car02Activity extends AppCompatActivity {

    @BindView(R.id.recyclerView_Left)
    RecyclerView recyclerLeft;
    @BindView(R.id.recyclerView_Right)
    RecyclerView recyclerRight;
    private LeftPresenter leftPresenter;
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    private RightPresenter rightPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car02);
        //
        ButterKnife.bind(this);

        //列表样式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //调用系统自带分割线
        recyclerLeft.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerLeft.setLayoutManager(linearLayoutManager);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //调用系统自带分割线
        recyclerRight.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerRight.setLayoutManager(manager);

        //调用方法
        leftPresenter = new LeftPresenter(new leftData());
        rightPresenter = new RightPresenter(new rightData());

        //适配器
        leftAdapter = new LeftAdapter(this);
        //实现左右联动
        leftAdapter.setLeftCheckListener(new LeftAdapter.LeftCheckListener() {
            @Override
            public void onItemClick(int position) {
                //每次点击获取cid 传给相应的接口相应
                rightPresenter.request(position);
            }
        });
        recyclerLeft.setAdapter(leftAdapter);


        rightAdapter = new RightAdapter(this);
        recyclerRight.setAdapter(rightAdapter);

        leftPresenter.request();
        rightPresenter.request(1);
    }

    //购物车left列表
    public class leftData implements DataCall<MyResult<List<LeftRlistBean>>> {

        @Override
        public void success(MyResult<List<LeftRlistBean>> data) {

            if (data.getCode().equals("0")) {
                List<LeftRlistBean> rlistBeans = data.getData();
                leftAdapter.addAll(rlistBeans);
                leftAdapter.notifyDataSetChanged();//刷新适配器
            }

        }
    }

    //购物车right列表
    public class rightData implements DataCall<MyResult<List<RightRlistBean>>> {

        @Override
        public void success(MyResult<List<RightRlistBean>> data) {

            if (data.getCode().equals("0")) {
                List<RightRlistBean> dataData = data.getData();
                rightAdapter.clear();
                rightAdapter.addAll(dataData);
                rightAdapter.notifyDataSetChanged();//刷新适配器
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        leftPresenter.unBind();
        rightPresenter.unBind();
    }
}
