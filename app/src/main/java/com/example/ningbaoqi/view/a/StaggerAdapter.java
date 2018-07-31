package com.example.ningbaoqi.view.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ningbaoqi.view.R;

import java.util.ArrayList;
import java.util.List;

public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.AViewHolder> {
    private LayoutInflater inflator;
    private Context context;
    private List<String> mdatas;
    private List<Integer> mHeights;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onLongClickListener(View view, int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public StaggerAdapter(Context context, List<String> datas) {
        this.context = context;
        this.mdatas = datas;
        inflator = LayoutInflater.from(context);
        mHeights = new ArrayList<>();
        for (int i = 0; i < mdatas.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public StaggerAdapter.AViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.item_main, parent, false);
        StaggerAdapter.AViewHolder viewHolder = new StaggerAdapter.AViewHolder(view);
        return viewHolder;
    }

    /**
     * 绑定ViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final StaggerAdapter.AViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.textView.getLayoutParams();
        params.height = mHeights.get(position);
        holder.textView.setLayoutParams(params);
        holder.textView.setText(mdatas.get(position));
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    listener.onItemClick(holder.textView, layoutPosition);
                }
            });
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    listener.onLongClickListener(holder.textView, layoutPosition);
                    return false;
                }
            });
        }
    }

    /**
     * 获取item数目
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    class AViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public AViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }

    public void addData(int position) {
        mdatas.add("inset one");
        notifyItemInserted(position);//使用它来通知
    }

    public void deleteData(int position) {
        mdatas.remove(position);
        notifyItemRemoved(position);//使用它来通知
    }
}
