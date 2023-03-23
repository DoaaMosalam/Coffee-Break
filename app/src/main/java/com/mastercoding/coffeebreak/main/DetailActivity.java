package com.mastercoding.coffeebreak.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mastercoding.coffeebreak.ItemOfProducts.CoffeeFragment;
import com.mastercoding.coffeebreak.Models.Categories;
import com.mastercoding.coffeebreak.Models.ItemAdapter;
import com.mastercoding.coffeebreak.R;

public class DetailActivity extends AppCompatActivity implements ItemAdapter.OnFragmentClickListener {
    ImageView image;
    TextView name;
    TextView description;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //init variables.
        image = findViewById(R.id.image_item);
        name=findViewById(R.id.tv_name);
        description=findViewById(R.id.tv_description);
        price = findViewById(R.id.tv_price);
        Intent intent = getIntent();
        String n = intent.getStringExtra("name");
        String de = intent.getStringExtra("description");
        String p = intent.getStringExtra("price");
        int im = intent.getIntExtra("image",0);


//        Bundle extras = getIntent().getExtras();
//        String n = extras.getString("name");
//        String de = extras.getString("description");
//        String p = extras.getString("price");
//        int im = extras.getInt("image");
//
        name.setText(n);
        description.setText(de);
        price.setText(p);
        image.setImageResource(im);

    }


    @Override
    public void onFragmentInterAction(Categories categories) {
        Toast.makeText(this, categories.getNameItem(), Toast.LENGTH_SHORT).show();
    }
}