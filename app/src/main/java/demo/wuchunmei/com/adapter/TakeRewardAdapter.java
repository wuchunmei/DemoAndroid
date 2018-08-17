package demo.wuchunmei.com.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import demo.wuchunmei.com.bean.Data;
import demo.wuchunmei.com.demoandroid.R;

/**
 * 作者：wuchunmei on 8/8/18 00:38
 */
public class TakeRewardAdapter  extends RecyclerView.Adapter<TakeRewardAdapter.ViewHolder>{

    private List<Data> mList;

    /**
     * 用于把要展示的数据源传进来，并赋值给一个全局变量mFruitList，我们后续的操作都将在这个数据源的基础上进行。
     * @param mFruitList
     */
    public TakeRewardAdapter(List<Data> mFruitList) {
        this.mList = mFruitList;
    }

    /**
     *
     * 用于创建ViewHolder实例的，并把加载出来的布局传入到构造函数当中，最后将viewholder的实例返回
     * @param parent
     * @param viewType
     * @return
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.take_reward_item_layout,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if(position == getItemCount()-1){
                    Data fruit = mList.get(position);
                    Toast.makeText(v.getContext(),"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
                }

            }
        });
        return holder;
    }

    /**
     * 用于对RecyclerView子项的数据进行赋值的，会在每个子项被滚动到屏幕内的时候执行，这里我们通过
     * position参数得到当前项的Fruit实例，然后再将数据设置到ViewHolder的Imageview和textview当中即可，
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data fruit = mList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
    }



    @Override
    public int getItemCount() {
        //最大固定显示６个
        if(mList == null && mList.size() == 0){
            return 0;
        }else if(mList.size() > 7){
            return 6;
        }else {
            return mList.size();
        }
    }


    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView fruitImage;


        View fruitView;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);

        }
    }
}
