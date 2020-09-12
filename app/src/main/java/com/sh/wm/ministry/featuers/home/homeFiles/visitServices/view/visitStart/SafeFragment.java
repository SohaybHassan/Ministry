package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.visitStart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentSafeBinding;

public class SafeFragment extends Fragment {

private FragmentSafeBinding binding ;

    public SafeFragment() {
        // Required empty public constructor
    }


    public static SafeFragment newInstance(String param1, String param2) {
        SafeFragment fragment = new SafeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSafeBinding.inflate(inflater,container,false);
        binding.sfNext.setColorFilter(getResources().getColor(R.color.white));
        // Inflate the layout for this fragment
        return binding.getRoot();
}
}