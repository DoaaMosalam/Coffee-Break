package com.mastercoding.coffeebreak.ItemOfProducts;

import android.content.Context;
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

public class CoffeeFragment extends Fragment{

    private List<Categories> list = new ArrayList<>();
   private ItemAdapter.OnFragmentClickListener listener;


    public CoffeeFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof ItemAdapter.OnFragmentClickListener)
//            listener = (ItemAdapter.OnFragmentClickListener) context;
//        else
//            throw new ClassCastException("Your activity does not implements on fragment");
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener = null;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public static CoffeeFragment newInstance(String param1, String param2) {

        CoffeeFragment fragment = new CoffeeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycler(view);
        insertData();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_coffee, container, false);
//       initRecycler(view);
       return view;
    }
    //this code insert data in recycler view from model.
    public void insertData(){
        list.add(new Categories(R.drawable.cooffee,"Coffee","Dark coffee","15 £E"));
        list.add(new Categories(R.drawable.coffee_hazelnut,"Hazelnut coffee","Coffee+Hazelnut","20 £E"));
        list.add(new Categories(R.drawable.coffee_with_milk,"coffee with milk","Coffee+Milk","15 £E"));
        list.add(new Categories(R.drawable.nescafe_black,"Nescafe black","Nescafe black","10 £E"));
        list.add(new Categories(R.drawable.nescafe_milk,"Nescafe with milk","Nescafe+milk","20 £E"));

    }
    public void initRecycler(View view){
        RecyclerView recyclerView = view.findViewById(R.id.rv_coffee);
//        setOnClickListener();
        ItemAdapter adapter = new ItemAdapter(getContext(),list,listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.invalidateItemDecorations();
        recyclerView.setAdapter(adapter);

    }
}