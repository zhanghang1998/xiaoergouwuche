package zyh.com.yuekao_lianxi01;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zyh.com.adapter.CarListAdapter;
import zyh.com.bean.CarListBean;
import zyh.com.bean.Result;
import zyh.com.bean.UserInfo;
import zyh.com.core.DataCall;
import zyh.com.presenter.CarShoppingPresenter;
import zyh.com.presenter.LoginPresenter;

public class ShoppingCarActivity extends AppCompatActivity {

    private CarShoppingPresenter carShoppingPresenter;
    private long userId;
    private String sessionId;
    private RecyclerView recyclerViewCar;
    private CarListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        userId = intent.getLongExtra("userIds", userId);
        sessionId = intent.getStringExtra("sessionIds");

        setContentView(R.layout.activity_shopping_car);
        //
        recyclerViewCar = findViewById(R.id.recyclerView_car_shopping);
        //调用presenter层
        carShoppingPresenter = new CarShoppingPresenter(new carShope());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewCar.setLayoutManager(linearLayoutManager);

        //适配器
        listAdapter = new CarListAdapter(this);
        recyclerViewCar.setAdapter(listAdapter);

        carShoppingPresenter.request(userId, sessionId);
    }

    public class carShope implements DataCall<Result<List<CarListBean>>> {
        @Override
        public void success(Result<List<CarListBean>> data) {


            List<CarListBean> listBeans = data.getResult();
            listAdapter.addAll(listBeans);
            listAdapter.notifyDataSetChanged();//刷新适配器

            //list.addAll(listBeans);

        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //carShoppingPresenter.unBind();
        //finish();
    }
}
