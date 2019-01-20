package zyh.com.presenter.car02;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import zyh.com.bean.Result;
import zyh.com.bean.carshop02.MyResult;
import zyh.com.core.DataCall;

public abstract class Base02Presenter {

    private DataCall dataCall;

    public Base02Presenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    protected abstract Observable observable(Object...args);

    public void request(Object...args){

        observable(args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyResult>( ) {
                    @Override
                    public void accept(MyResult myResult) throws Exception {
                        dataCall.success(myResult);
                    }
                });

    }

    public void unBind(){
        this.dataCall=null;
    }

}
