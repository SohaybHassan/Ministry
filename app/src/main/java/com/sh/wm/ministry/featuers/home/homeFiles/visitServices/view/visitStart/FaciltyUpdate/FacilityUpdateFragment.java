package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.visitStart.FaciltyUpdate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentFacilityUpdateBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter.TabLayoutAdapter;

public class FacilityUpdateFragment extends Fragment {
private FragmentFacilityUpdateBinding binding ;
private TabLayoutAdapter tabLayoutAdapter ;
    public FacilityUpdateFragment() {
        // Required empty public constructor
    }


    public static FacilityUpdateFragment newInstance(String param1, String param2) {
        FacilityUpdateFragment fragment = new FacilityUpdateFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }//onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFacilityUpdateBinding.inflate(inflater , container , false);
        tabLayoutAdapter=new TabLayoutAdapter(getParentFragmentManager());
        //adding fragments to tabLayout
       tabLayoutAdapter.addFragment(new BasicInfoFragment(),getString(R.string.basic_info));
        tabLayoutAdapter.addFragment(new LegalFragment(),getString(R.string.legal));
        tabLayoutAdapter.addFragment(new LicensesInfoFragment(),getString(R.string.license_info));
        tabLayoutAdapter.addFragment(new Informer_Fragment(),getString(R.string.blank_info));

//        tabLayoutAdapter.addFragment( ,"Add");
        binding.viewPager.setAdapter(tabLayoutAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        return binding.getRoot();
    }//onCreateView
}//end class