package com.example.ningbaoqi.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Simple1Adapter extends RecyclerView.Adapter<MyView1Holder> {
    private LayoutInflater inflator;
    private Context context;
    private List<String> mdatas;

    public Simple1Adapter(Context context, List<String> datas) {
        this.context = context;
        this.mdatas = datas;
        inflator = LayoutInflater.from(context);
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
    public MyView1Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.item_main, parent, false);
        MyView1Holder viewHolder = new MyView1Holder(view);
        return viewHolder;
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

    public void addData(int position) {
        mdatas.add("inset one");
        notifyItemInserted(position);//使用它来通知
    }

    public void deleteData(int position) {
        mdatas.remove(position);
        notifyItemRemoved(position);//使用它来通知
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onLongClickListener(View view, int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyView1Holder holder, final int position) {
        holder.textView.setText(mdatas.get(position));
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();//获取在布局中的位置，为了避免在单击的时候由于不是全部刷新造成toast出的position混淆
                    listener.onItemClick(holder.textView, layoutPosition);
                }
            });
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongClickListener(holder.textView, position);
                    return false;
                }
            });
        }
    }
}

class MyView1Holder extends RecyclerView.ViewHolder {
    TextView textView;

    public MyView1Holder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv);
    }
}

