package com.example.taskmodule.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskmodule.R;
import com.example.taskmodule.bean.NewBean;
import com.example.taskmodule.cache.LruUtils;
import com.example.taskmodule.cache.NetUtil;
import com.example.taskmodule.cache.SDUtil;
import java.util.ArrayList;

/**
 * @author rjs
 * @package com.example.taskmodule.adapter
 * @date 2020/6/29
 * @desc
 */
public class NewsRecyAdapter extends RecyclerView.Adapter<NewsRecyAdapter.MyViewHolder> {

    private ArrayList<NewBean> list;
    private Context context;
    private LruUtils lruUtils=new LruUtils();

    public NewsRecyAdapter(ArrayList<NewBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_news_rv_adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_context.setText(list.get(position).getContext());
        Bitmap bitmap = holderGetImg(position);
        holder.iv_img.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private TextView tv_context;
        private ImageView iv_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.item_tv_title);
            tv_context=itemView.findViewById(R.id.item_tv_context);
            iv_img=itemView.findViewById(R.id.item_iv_img);
        }
    }

    private Bitmap holderGetImg(int position) {

        Bitmap lruBitmap = lruUtils.getBitmap("pic_" + position);
        if(lruBitmap==null){
            Bitmap sdBitmap = SDUtil.getBitmap("pic_" + position);
            if(sdBitmap==null){
                try {
                    Log.e("==","net");
                    Bitmap netBitMap = NetUtil.getBitMap(list.get(position).getImgUrl());
                    SDUtil.setBitmap("pic_"+position,netBitMap);
                    lruUtils.setBitmap("pic_"+position,netBitMap);
                    return netBitMap;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                Log.e("==","sd");
                lruUtils.setBitmap("pic_"+position,sdBitmap);
                return sdBitmap;
            }
        }else{
            Log.e("==","huancun");
            return lruBitmap;
        }
        return null;
    }
}
