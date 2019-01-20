package zyh.com.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import zyh.com.bean.CarListBean;
import zyh.com.view.MyRecyclerView;
import zyh.com.yuekao_lianxi01.R;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.MyViewHoadler> {

    private Context context;
    private ArrayList<CarListBean> lists = new ArrayList<>();

    public CarListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CarListAdapter.MyViewHoadler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_rlist_item, viewGroup, false);
        MyViewHoadler myViewHoadler = new MyViewHoadler(view);
        return myViewHoadler;
    }

    @Override
    public void onBindViewHolder(@NonNull CarListAdapter.MyViewHoadler myViewHoadler, int i) {

        CarListBean carListBean = lists.get(i);

        myViewHoadler.simpleDraweeView.setImageURI(Uri.parse(carListBean.getPic()));
        myViewHoadler.textPrice.setText(carListBean.getPrice() + "");
        myViewHoadler.textCount.setText(carListBean.getCommodityName() + "");
        myViewHoadler.add_sub_layout.setCount(carListBean.getCount());

    }

    public void addAll(List<CarListBean> listBeanList) {
        if (listBeanList != null) {
            lists.addAll(listBeanList);
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }


    public class MyViewHoadler extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private final TextView textPrice;
        private final TextView textCount;
        private final MyRecyclerView add_sub_layout;

        public MyViewHoadler(@NonNull View itemView) {
            super(itemView);

            simpleDraweeView = itemView.findViewById(R.id.imageView_simple);
            textCount = itemView.findViewById(R.id.textView_car_rlist_count);
            textPrice = itemView.findViewById(R.id.textView_car_rlist_price);
            add_sub_layout = itemView.findViewById(R.id.add_sub_layout);

        }
    }

}
