package com.bignerdranch.android.scrollstickydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        List<String> itemStrList = getTestList();
        mRecyclerView.setAdapter(new ItemViewAdapter(itemStrList));

    }
    private List<String> getTestList(){
        List<String> list = new ArrayList<>();
        for (int i =0;i<25;i++){
            list.add("Item "+i);
        }
        return list;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView itemView;

        public ItemViewHolder(View view) {
            super(view);
            itemView = (TextView)view;
        }

        public void bind(String itemStr){
            itemView.setText(itemStr);
        }
    }

    private class ItemViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        private List<String> mItemList;

        public ItemViewAdapter(List<String> itemList) {
            mItemList = itemList;
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            View itemView = layoutInflater.inflate(android.R.layout.simple_list_item_1, null);
            return new ItemViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            holder.bind(mItemList.get(position));
        }

        public int getItemCount() {
            if (mItemList == null) {
                return 0;
            }
            return mItemList.size();
        }
    }
}
