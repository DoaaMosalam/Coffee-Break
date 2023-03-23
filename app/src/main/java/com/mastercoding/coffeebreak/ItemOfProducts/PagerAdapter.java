package com.mastercoding.coffeebreak.ItemOfProducts;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStateAdapter  {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> listTitle = new ArrayList<>();

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }



    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        listTitle.add(title);
    }
    @Override
    public int getItemCount() {
        return listTitle.size();
    }
    //    @Nullable
//    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }


}
