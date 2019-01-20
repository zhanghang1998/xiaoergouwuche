package zyh.com.adapter.carshop;

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

import zyh.com.bean.carshop02.RightListBean;
import zyh.com.yuekao_lianxi01.R;

public class RightGoodsAdapter extends RecyclerView.Adapter<RightGoodsAdapter.MyGoodsViewHolder> {

    private Context mContext;
    private List<RightListBean> mListBeans = new ArrayList<>();

    public RightGoodsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addAll(List<RightListBean> dataBeans) {
        if (dataBeans != null) {
            mListBeans.addAll(dataBeans);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public MyGoodsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.car_rlist_right_image, viewGroup, false);
        return new MyGoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyGoodsViewHolder myGoodsViewHolder, int i) {
        myGoodsViewHolder.imageright.setImageURI(Uri.parse(mListBeans.get(i).getIcon()));
        myGoodsViewHolder.mTextViewName.setText(mListBeans.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mListBeans == null ? 0 : mListBeans.size();
    }

    //自定义viewholder
    class MyGoodsViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView imageright;
        TextView mTextViewName;

        public MyGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageright = itemView.findViewById(R.id.simpleDraweeView_rlist_image);
            mTextViewName = itemView.findViewById(R.id.textView_right_name);
        }
    }
}
