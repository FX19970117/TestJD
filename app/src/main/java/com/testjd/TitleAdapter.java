package com.testjd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/31.
 */
public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.viewholder> {


    private Context context;
    private String[] list;

    public TitleAdapter(Context context, String[] list){
        this.context = context;
        this.list = list;
    }

    @Override
    public TitleAdapter.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        viewholder holder = new viewholder(LayoutInflater.from(context).inflate(R.layout.title_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final viewholder holder, int position) {

        holder.tv.setText(list[position]);

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.length;
    }



    public void refresh(String[] list){
        this.list = list;
        notifyDataSetChanged();
    }



    public class viewholder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public viewholder(View itemView) {
            super(itemView);
           tv =  (TextView)itemView.findViewById(R.id.id_num);
        }
    }


    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

}
