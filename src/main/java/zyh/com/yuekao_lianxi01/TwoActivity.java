package zyh.com.yuekao_lianxi01;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zyh.com.bean.UserInfo;

public class TwoActivity extends AppCompatActivity {

    private long userId;
    private String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        //控件初始化
        ButterKnife.bind(this);

        Intent intent = getIntent();
        userId = intent.getLongExtra("userId", userId);
        sessionId = intent.getStringExtra("sessionId");

    }

    @OnClick(R.id.imageView_intent_car)
    public void imagescar(){//进入购物车

        Intent intent = new Intent(this, ShoppingCarActivity.class);
        intent.putExtra("userIds",userId);
        intent.putExtra("sessionIds",sessionId);
        //开启跳转
        startActivity(intent);
    }

    @OnClick(R.id.imageView_car02)
    public void car02(){//进入购物车02
        startActivity(new Intent(this, Car02Activity.class));
    }

    @OnClick(R.id.imageView_intent_my)
    public void imagesmy(){//进入个人页面
        startActivity(new Intent(this, MyActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
