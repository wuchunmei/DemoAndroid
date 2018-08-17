package demo.wuchunmei.com.demoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import demo.wuchunmei.com.adapter.TakeRewardAdapter;
import demo.wuchunmei.com.bean.Data;

/**
 * 作者：wuchunmei on 8/8/18 00:08
 */
public class RecyclerViewActivity extends Activity{
    private RecyclerView mRecyclerView;
    private List<Data> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_layout);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        initFruit();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        mRecyclerView.setLayoutManager(linearLayoutManager);
        TakeRewardAdapter adapter = new TakeRewardAdapter(fruitList);
        mRecyclerView.setAdapter(adapter);
    }

    private void initFruit() {
        Data a = new Data("a", R.mipmap.ic_launcher);
        fruitList.add(a);
        Data b = new Data("b", R.mipmap.ic_launcher);
        fruitList.add(b);
        Data c = new Data("c", R.mipmap.ic_launcher);
        fruitList.add(c);
        Data d = new Data("d", R.mipmap.ic_launcher);
        fruitList.add(d);
        Data e = new Data("e", R.mipmap.ic_launcher);
        fruitList.add(e);
        Data f = new Data("f", R.mipmap.ic_launcher);
        fruitList.add(f);
    }
}
