package com.example.lenovo.yourgym1.me;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lenovo.yourgym1.R;
import com.leon.lib.settingview.LSettingItem;

import java.util.ArrayList;
import java.util.List;

public class MeFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private ItemAdapter mAdapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View meLayout = inflater.inflate(R.layout.me_layout, container, false);

        mCrimeRecyclerView = (RecyclerView) meLayout.findViewById(R.id.recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//添加manager?????

        updateUI();

        return meLayout;
    }

    private void updateUI(){
        List<String> crimes;
        crimes = new ArrayList<>();

        crimes.add("钱包");
        crimes.add("收藏");
        crimes.add("商店");
        crimes.add("个人信息");
        crimes.add("购物车");

        mAdapter = new ItemAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);

    }



    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder>{
        private List<String> mCrimes;

        public ItemAdapter(List<String> crimes){
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemHolder itemHolder, int i){

            itemHolder.bind(mCrimes.get(i));
        }

        @Override
        public int getItemCount(){
            return mCrimes.size();
        }
    }


    private class ItemHolder extends RecyclerView.ViewHolder{
        LSettingItem mSettingItemOne;
        public ItemHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.me_list_item, parent, false));
            mSettingItemOne = (LSettingItem) itemView.findViewById(R.id.item_one);
        }

        public void bind(String str){
            mSettingItemOne.setLeftText(str);
        }

    }

}
