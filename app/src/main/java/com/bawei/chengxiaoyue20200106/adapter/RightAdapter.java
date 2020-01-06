package com.bawei.chengxiaoyue20200106.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.chengxiaoyue20200106.R;
import com.bawei.chengxiaoyue20200106.bean.RightBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightHolder> {
    private List<RightBean.DataBean> list;
    private Context context;

    public RightAdapter(List<RightBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RightHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_right, null);
        return new RightHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightHolder holder, int position) {
        holder.name.setText(list.get(position).getGoods_english_name());
        holder.price.setText(list.get(position).getCurrency_price() + "");
        Glide.with(holder.imageview)
                .load(list.get(position).getGoods_thumb())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RightHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageview)
        ImageView imageview;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;

        public RightHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
