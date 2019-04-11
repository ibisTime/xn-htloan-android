package com.cdkj.huatuweitong.adapters;

import android.support.annotation.Nullable;

import com.cdkj.huatuweitong.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by lei on 2017/8/26.
 */

public class LetterRVAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public LetterRVAdapter(@Nullable List<String> data) {
        super(R.layout.item_letter_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_sort, item);
    }

//    private Context context;
//    private String[] list;
//
//    private ViewHolder holder;
//
//    public LetterRVAdapter(Context context, String[] list){
//        this.list = list;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return list == null ? 0 : list.length;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        if (view == null || view.getTag() == null) {
//            view = LayoutInflater.from(context).inflate(R.layout.item_letter_list, null);
//            holder = new ViewHolder(view);
//            view.setTag(holder);
//        } else {
//            holder = (ViewHolder) view.getTag();
//        }
//
//        holder.tvSort.setText(list[i]);
//
//        return view;
//    }

//    static class ViewHolder {
//        TextView tvSort;
//
//        ViewHolder(View view) {
//            tvSort = view.findViewById(R.id.tv_sort);
//        }
//    }
}
