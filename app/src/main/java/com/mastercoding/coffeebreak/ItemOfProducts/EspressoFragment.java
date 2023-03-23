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


public class EspressoFragment extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Categories> list = new ArrayList<>();

    private ItemAdapter.OnFragmentClickListener listener;

    public EspressoFragment() {
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
        view = inflater.inflate(R.layout.fragment_espresso, container, false);
      return view;
    }

    //This code initialization recycler view of hot layout.
    public void initRecyclerView(View view){
        recyclerView = view.findViewById(R.id.rv_espresso);
//        setOnClickListener();
        adapter =new ItemAdapter(getContext(),list,listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.invalidateItemDecorations();
        recyclerView.setAdapter(adapter);
    }

    public void insertData(){
        //this code insert data in recycler view from model.
            list.add(new Categories(R.drawable.single_espresso,"Single espresso","espresso","15 £E"));
            list.add(new Categories(R.drawable.double_espresso,"Double espresso","Double espresso","20 £E"));
            list.add(new Categories(R.drawable.espresso_moka,"Espresso macchiato","Coffee+milk+Caramel","25 £E"));
            list.add(new Categories(R.drawable.frappuccino,"Frappuccino","Ice milk,Hot milk+Caramel+cream ","25 £E"));
            list.add(new Categories(R.drawable.late_espresso,"Late espresso","Milk + coffee + Caramel","25 £E"));
            list.add(new Categories(R.drawable.espresso_moka,"Moka espresso","Coffee espresso + chocolate + Milkshake","25 £E"));
            list.add(new Categories(R.drawable.falt_white_espresso,"Flat White","Coffee espresso + chocolate + Milkshake light  ","25 £E"));
            list.add(new Categories(R.drawable.amrecan_coffee,"American Coffee","Coffee american","25 £E"));
            list.add(new Categories(R.drawable.hot_caramial,"Hot Caramel ","Hot milk+coffee+hot caramel","25 £E"));
            list.add(new Categories(R.drawable.kapatchino,"cappuccino","Nescafe cappuccino","25 £E"));
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