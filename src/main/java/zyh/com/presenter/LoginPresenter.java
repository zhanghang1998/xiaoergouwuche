package zyh.com.presenter;

import io.reactivex.Observable;
import zyh.com.core.DataCall;
import zyh.com.core.IResult;
import zyh.com.util.NetWorkHttp;

public class LoginPresenter extends BasePresenter {

    public LoginPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        IResult iResult = NetWorkHttp.instance().create(IResult.class);
        return iResult.login((String) args[0],(String) args[1]);
    }
}
