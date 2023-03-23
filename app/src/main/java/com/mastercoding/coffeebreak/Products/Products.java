package com.mastercoding.coffeebreak.Products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.mastercoding.coffeebreak.R;

import java.util.ArrayList;
import java.util.List;

import com.mastercoding.coffeebreak.ItemOfProducts.CocktailFragment;
import com.mastercoding.coffeebreak.ItemOfProducts.CoffeeFragment;
import com.mastercoding.coffeebreak.ItemOfProducts.EspressoFragment;
import com.mastercoding.coffeebreak.ItemOfProducts.HotFragment;
import com.mastercoding.coffeebreak.ItemOfProducts.Ice_Coffeeragment;
import com.mastercoding.coffeebreak.ItemOfProducts.JuiceFragment;
import com.mastercoding.coffeebreak.ItemOfProducts.PagerAdapter;
import com.mastercoding.coffeebreak.ItemOfProducts.ZabadoFragment;
import com.mastercoding.coffeebreak.Models.Categories;
import com.mastercoding.coffeebreak.main.DetailActivity;

public class Products extends AppCompatActivity {
   private ViewPager2 viewPager;
   private TabLayout tabProduct;
   private EditText editText_SearchItem;
    List<Categories> list = new ArrayList<>();
    FirebaseAuth mAuth=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        viewPager=(ViewPager2) findViewById(R.id.viewPager_product);
        tabProduct =findViewById(R.id.tab_product);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), getLifecycle());

        tabProduct.addTab(tabProduct.newTab().setText("COFFEE"));
        tabProduct.addTab(tabProduct.newTab().setText("HOT"));
        tabProduct.addTab(tabProduct.newTab().setText("ESPRESSO"));
        tabProduct.addTab(tabProduct.newTab().setText("ICE COFFEE"));
        tabProduct.addTab(tabProduct.newTab().setText("JUICE"));
        tabProduct.addTab(tabProduct.newTab().setText("COCKTAIL"));
        tabProduct.addTab(tabProduct.newTab().setText("ZABADO"));
        //Add Fragment Here
        pagerAdapter.addFragment(new CoffeeFragment(),"");
        pagerAdapter.addFragment(new HotFragment(),"");
        pagerAdapter.addFragment(new EspressoFragment(),"");
        pagerAdapter.addFragment(new Ice_Coffeeragment(),"");
        pagerAdapter.addFragment(new JuiceFragment(),"");
        pagerAdapter.addFragment(new CocktailFragment(),"");
        pagerAdapter.addFragment(new ZabadoFragment(),"");
        viewPager.setAdapter(pagerAdapter);

        tabProduct.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabProduct.selectTab(tabProduct.getTabAt(position));
            }
        });
    }



/*This method sing out */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        if (id==R.id.itemLogout){
//            FirebaseAuth.getInstance();
//            mAuth.signOut();
//            startActivity(new Intent(getApplicationContext(), Create_account .class));
//        }
//        return true;
//    }
}