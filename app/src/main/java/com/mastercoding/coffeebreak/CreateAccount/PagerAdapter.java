package com.mastercoding.coffeebreak.CreateAccount;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        if (position==1){
//            return new LoginFragment();
//        }
//        return new RegisterFragment();
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new RegisterFragment();
            default:
                return null;

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
