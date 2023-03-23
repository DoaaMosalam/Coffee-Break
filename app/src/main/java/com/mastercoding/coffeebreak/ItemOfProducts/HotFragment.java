package com.mastercoding.coffeebreak.ItemOfProducts;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mastercoding.coffeebreak.R;

import java.util.ArrayList;
import java.util.List;

import com.mastercoding.coffeebreak.Models.Categories;
import com.mastercoding.coffeebreak.Models.ItemAdapter;
import com.mastercoding.coffeebreak.main.DetailActivity;

public class HotFragment extends Fragment {


    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Categories> list = new ArrayList<>();
    private ItemAdapter.OnFragmentClickListener listener;
    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);
        insertData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_hot, container, false);
        return v;
    }
    //This code initialization recycler view of hot layout.
    public void initRecyclerView(View view){
        recyclerView = view.findViewById(R.id.rv_hot);
        adapter =new ItemAdapter(getContext(),list,listener);
//        setOnClickListener();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.invalidateItemDecorations();
        recyclerView.setAdapter(adapter);

    }
    //this code insert data in recycler view from model.
    public void insertData(){
        list.add(new Categories(R.drawable.tea,"Tea","Tea","5 £E"));
        list.add(new Categories(R.drawable.milktea,"Milk tea","Tea+Milk","10 £E"));
        list.add(new Categories(R.drawable.coffeemix,"Coffee Mix","coffee mix","10 £E"));
        list.add(new Categories(R.drawable.roselle," Hot Roselle","Hot Roselle ","7 £E"));
        list.add(new Categories(R.drawable.ginger,"Ginger","Hot ginger","7 £E"));
        list.add(new Categories(R.drawable.cinnamon,"Cinnamon","Hot cinnamon","7 £E"));
        list.add(new Categories(R.drawable.limon,"Lemon","Hot Lemon","7 £E"));
        list.add(new Categories(R.drawable.hotchocolate,"Hot Chocolate","Hot Chocolate","20 £E"));
        list.add(new Categories(R.drawable.hotsider,"Hot Sider","Hot Fruits","20 £E"));
        list.add(new Categories(R.drawable.mint,"Mint","Hot Mint","7 £E"));
        list.add(new Categories(R.drawable.orchid,"Orchid","Milk+Orchid","20 £E"));
        list.add(new Categories(R.drawable.sahlabnuts,"Sahlab Nuts","Orchid+Nuts","23 £E"));
        list.add(new Categories(R.drawable.homssham,"Homs ElSham","chickpeas","15 £E"));
    }
//    private void setOnClickListener() {
//        listener = new ItemAdapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View v, int position) {
//                Intent intent = new Intent(getContext(), DetailActivity.class);
//                intent.putExtra("name", list.get(position).getNameItem());
//                intent.putExtra("description", list.get(position).getDescriptionItem());
//                intent.putExtra("price", list.get(position).getPrice());
//                intent.putExtra("image", list.get(position).getImageItem());
//                startActivity(intent);
//            }
//        };
//    }

}