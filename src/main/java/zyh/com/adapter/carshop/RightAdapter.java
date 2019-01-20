package zyh.com.adapter.carshop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zyh.com.bean.carshop02.RightListBean;
import zyh.com.bean.carshop02.RightRlistBean;
import zyh.com.yuekao_lianxi01.R;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyRightViewHolder> {

    private Context mContext;
    private List<RightRlistBean> mDataBeanList = new ArrayList<>();
    private RightGoodsAdapter mRightGoodsAdapter;


    public RightAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addAll(List<RightRlistBean> dataBeans) {
        if (dataBeans != null) {
            mDataBeanList.addAll(dataBeans);
        }
    }

    public void clear() {
        mDataBeanList.clear();
    }

    @NonNull
    @Override
    public MyRightViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.car_rlist_right_item, viewGroup, false);
        return new MyRightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRightViewHolder myRightViewHolder, int i) {
        myRightViewHolder.mTextViewTitle.setText(mDataBeanList.get(i).getName());
        List<RightListBean> rightListBeanList = mDataBeanList.get(i).getList();
        //添加子布局适配器
        mRightGoodsAdapter = new RightGoodsAdapter(mContext);
        //网格布局
        myRightViewHolder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        myRightViewHolder.mRecyclerView.setAdapter(mRightGoodsAdapter);
        mRightGoodsAdapter.addAll(rightListBeanList);
    }

    @Override
    public int getItemCount() {
        return mDataBeanList == null ? 0 : mDataBeanList.size();
    }

    //自定义viewholder
    class MyRightViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextViewTitle;
        private final RecyclerView mRecyclerView;

        public MyRightViewHolder(@NonNull View itemView) {
            super(itemView);

            mRecyclerView = itemView.findViewById(R.id.recyclerView_right_list);
            mTextViewTitle = itemView.findViewById(R.id.textView_right_list);

        }
    }

}
