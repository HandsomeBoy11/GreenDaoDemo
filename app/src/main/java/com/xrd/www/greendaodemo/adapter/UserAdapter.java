package com.xrd.www.greendaodemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xrd.www.greendaodemo.R;
import com.xrd.www.greendaodemo.bean.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by user on 2018/8/14.
 */

public class UserAdapter extends BaseAdapter {
    private Context mContext;
    private List<User> mUserList;
    private final LayoutInflater from;

    public UserAdapter(Context mContext, List<User> userList) {
        this.mContext = mContext;
        this.mUserList = userList;
        from = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view == null) {
            view = from.inflate(R.layout.item, viewGroup, false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        User user = mUserList.get(i);
        viewHolder.tvId.setText(user.getId()+"");
        viewHolder.tvName.setText(user.getName());
        viewHolder.tvAge.setText(user.getAge()+"");
        viewHolder.tvSex.setText(user.getSex());
        viewHolder.tvPhone.setText(user.getPhone());
//        viewHolder.tvLive.setText(user.getLive());

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_age)
        TextView tvAge;
        @BindView(R.id.tv_phone)
        TextView tvPhone;
        @BindView(R.id.tv_sex)
        TextView tvSex;
        @BindView(R.id.tv_live)
        TextView tvLive;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
