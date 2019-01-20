package zyh.com.adapter.carshop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zyh.com.bean.carshop02.LeftRlistBean;
import zyh.com.yuekao_lianxi01.R;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyViewHolder> {

    private Context mContext;
    private List<LeftRlistBean> list = new ArrayList<>();

    public LeftAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void addAll(List<LeftRlistBean> dataBeans) {
        if (dataBeans != null) {
            list.addAll(dataBeans);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.car_rlist_left_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.mTextViewTitle.setText(list.get(i).getName());
        myViewHolder.mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLeftCheckListener.onItemClick(list.get(i).getCid());
                Toast.makeText(mContext, "点击了:" + list.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    /**
     * 内部类
     */
    //自定义viewholder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextViewTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.textView_left_list);
        }
    }


    private LeftCheckListener mLeftCheckListener;

    public void setLeftCheckListener(LeftCheckListener leftCheckListener) {
        mLeftCheckListener = leftCheckListener;
    }

    //自定义接口
    public interface LeftCheckListener {
         void onItemClick(int position);
    }


}
