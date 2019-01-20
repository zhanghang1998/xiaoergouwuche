package zyh.com.presenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import zyh.com.bean.Result;
import zyh.com.core.DataCall;

public abstract class BasePresenter {

    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    protected abstract Observable observable(Object...args);

    public void request(Object...args){

        observable(args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>( ) {
                    @Override
                    public void accept(Result result) throws Exception {
                        dataCall.success(result);
                    }
                });

    }

    public void unBind(){
        this.dataCall=null;
    }

}
