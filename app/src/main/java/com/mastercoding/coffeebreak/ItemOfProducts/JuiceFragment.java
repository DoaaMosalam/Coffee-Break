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

public class JuiceFragment extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Categories> list = new ArrayList<>();

    private ItemAdapter.OnFragmentClickListener listener;

    public JuiceFragment() {
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
        // Inflate the layout for this fragment
       view=inflater.inflate(R.layout.fragment_juice, container, false);
       return view;
    }

    //This code initialization recycler view of hot layout.
    public void initRecyclerView(View view){
        recyclerView = view.findViewById(R.id.rv_juice);
        adapter =new ItemAdapter(getContext(),list,listener);
//        setOnClickListener();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.invalidateItemDecorations();
        recyclerView.setAdapter(adapter);
    }

    public void insertData(){
        //this code insert data in recycler view from model.
        list.add(new Categories(R.drawable.guava,"Guava juice","Guava","15 £E"));
        list.add(new Categories(R.drawable.banana,"Banana juice","banana","15 £E"));
        list.add(new Categories(R.drawable.orange,"Orange juice","orange ","15 £E"));
        list.add(new Categories(R.drawable.limon,"Lemon juice","Lemon","15 £E"));
        list.add(new Categories(R.drawable.limon_mint,"Lemon mint juice","Lemon+mint","20 £E"));
        list.add(new Categories(R.drawable.fruitsaladbanana,"Fruit Salad","Collection from fruits","25 £E"));
        list.add(new Categories(R.drawable.strawable,"Strawberry juice","strawberry","15 £E"));
        list.add(new Categories(R.drawable.mango,"Mango juice","Mango","20 £E"));
        list.add(new Categories(R.drawable.orio,"Oreo juice","Oreo+milk+ice cream","25 £E"));

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