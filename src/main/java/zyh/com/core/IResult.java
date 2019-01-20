package zyh.com.core;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import zyh.com.bean.CarListBean;
import zyh.com.bean.Result;
import zyh.com.bean.UserInfo;
import zyh.com.bean.carshop02.LeftRlistBean;
import zyh.com.bean.carshop02.MyResult;
import zyh.com.bean.carshop02.RightRlistBean;

public interface IResult {

    //登录
    @FormUrlEncoded
    @POST("user/v1/login")
    public Observable<Result<UserInfo>> login(@Field("phone") String m, @Field("pwd") String p);

    //查询购物车信息
    @GET("order/verify/v1/findShoppingCart")
    public Observable<Result<List<CarListBean>>> queryShopping(
            @Header("userId") long users,
            @Header("sessionId") String sessions);

    //购物车JD分类 , 分类列
    @GET("product/getCatagory")
    public Observable<MyResult<List<LeftRlistBean>>> lefttData();

    //关键字搜索
    @GET("product/getProductCatagory")
    public Observable<MyResult<List<RightRlistBean>>> rightData(
            @Query("cid") int cid);

}
