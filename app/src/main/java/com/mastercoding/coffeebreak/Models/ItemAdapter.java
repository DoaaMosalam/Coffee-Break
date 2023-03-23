package com.mastercoding.coffeebreak.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mastercoding.coffeebreak.ItemOfProducts.CoffeeFragment;
import com.mastercoding.coffeebreak.ItemOfProducts.PagerAdapter;
import com.mastercoding.coffeebreak.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private Context mContext;
    private List<Categories> list = new ArrayList<>();
    private OnFragmentClickListener listener;
    //constructor.
    public ItemAdapter(Context mContext, List<Categories> list, OnFragmentClickListener listener) {
        this.mContext = mContext;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products,parent,false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return (list == null)?0: list.size();
    }

    //inner Class ItemHolder.
     class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Categories categories;
        List<Categories> categoriesList;
        ImageView image;
        TextView _name;
        TextView _description;
        TextView _price;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_item);
            _name = itemView.findViewById(R.id.tv_nameItem);
            _description = itemView.findViewById(R.id.tv_descriptionItem);
            _price = itemView.findViewById(R.id.tv_priceItem);

        }

        void onBind(final Categories cat) {
//             this.categoriesList = (List<Categories>) cat;
            image.setImageResource(cat.getImageItem());
            _name.setText(cat.getNameItem());
            _description.setText(cat.getDescriptionItem());
            _price.setText(cat.getPrice());
        }


        @Override
        public void onClick(View v) {
            listener.onFragmentInterAction(categories);

        }
    }

    public interface OnFragmentClickListener{
        void  onFragmentInterAction(Categories categories);
    }


//        @Override
//        public void onClick(View v) {
//            listener.onClick(v,getAdapterPosition());
//        }
//    }
//    //    to transfer data to detail activity
//    public interface RecyclerViewClickListener{
//        void onClick(View v, int position);
//    }

}
