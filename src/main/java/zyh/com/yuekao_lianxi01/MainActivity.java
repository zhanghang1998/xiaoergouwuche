package zyh.com.yuekao_lianxi01;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zyh.com.bean.Result;
import zyh.com.bean.UserInfo;
import zyh.com.core.DataCall;
import zyh.com.presenter.LoginPresenter;
import zyh.com.util.MD5Utils;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editText_number)
    EditText mPhone;
    @BindView(R.id.editText_password)
    EditText mPassword;
    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        ButterKnife.bind(this);
        //调用
        loginPresenter = new LoginPresenter(new login());

    }

    @OnClick(R.id.button_login)
    public void login(){//跳转到展示页面

        String phone = mPhone.getText().toString().trim();
        String pwds = mPassword.getText().toString().trim();
        if (phone.equals("")&&pwds.equals("")) {
            Toast.makeText(this, "输入框不能为空!",Toast.LENGTH_SHORT).show();
            return;
        }
        loginPresenter.request(phone,MD5Utils.md5(pwds));
    }

    public class login implements DataCall<Result<UserInfo>> {

        @Override
        public void success(Result<UserInfo> data) {

            Toast.makeText(MainActivity.this, data.getStatus()+""+data.getResult().getUserId()+""+data.getMessage(),Toast.LENGTH_SHORT).show();
            if (data.getStatus().equals("0000")) {
                //获取要传送的类
                UserInfo userInfo = data.getResult();
                Log.v("zyh","data.getResult()and UserInfo:"+userInfo.toString());
                /*//创建message
                Message message = new Message();
                message.what = 100;
                message.obj = userInfo;
                EventBus.getDefault().post(message);*/

                Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                intent.putExtra("userId",userInfo.getUserId());
                intent.putExtra("sessionId",userInfo.getSessionId());
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        loginPresenter.unBind();
    }
}
