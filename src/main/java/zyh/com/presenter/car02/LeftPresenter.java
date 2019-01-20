package zyh.com.presenter.car02;

import io.reactivex.Observable;
import zyh.com.core.DataCall;
import zyh.com.core.IResult;
import zyh.com.presenter.BasePresenter;
import zyh.com.util.Http02;
import zyh.com.util.NetWorkHttp;

public class LeftPresenter extends Base02Presenter {

    public LeftPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        IResult iResult = Http02.instance().create02(IResult.class);
        return iResult.lefttData();
    }
}
