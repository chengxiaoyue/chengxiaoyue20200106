package com.bawei.chengxiaoyue20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.chengxiaoyue20200106.MainActivity;
import com.bawei.chengxiaoyue20200106.R;
import com.bawei.chengxiaoyue20200106.bean.LeftBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftHolder> {
    private List<LeftBean> list;
    private Context context;

    public LeftAdapter(List<LeftBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public LeftHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_left, null);
        return new LeftHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftHolder holder, int position) {
        holder.text.setText(list.get(position).getCategory()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClick != null) {
                    itemClick.setItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LeftHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView text;

        public LeftHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface ItemClick {
        void setItemClick(int position);
    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

}
