package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.visitStart.FaciltyUpdate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentInformerBinding;


public class Informer_Fragment extends Fragment {
private FragmentInformerBinding binding ;

    public Informer_Fragment() {
        // Required empty public constructor
    }


    public static Informer_Fragment newInstance(String param1, String param2) {
        Informer_Fragment fragment = new Informer_Fragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         binding = FragmentInformerBinding.inflate(inflater , container , false);
         binding.infoResultGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 if(radioGroup.getCheckedRadioButtonId()== R.id.info_completed){
                    binding.notCompletingResoan.setEnabled(false);
                 }else{
                     binding.notCompletingResoan.setEnabled(true);

                 }
             }
         });
        return binding.getRoot();
    }


}