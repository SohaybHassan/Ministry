package com.sh.wm.ministry.featuers.userfile.career.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.sh.wm.ministry.databinding.FragmentCareersBinding;
import com.sh.wm.ministry.featuers.userfile.career.adapter.UserCareersAdapter;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareer;
import com.sh.wm.ministry.featuers.userfile.career.viewmodel.CareersViewModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CareersFragment extends Fragment {

    private FragmentCareersBinding binding;

    public static CareersFragment newInstance() {
        return new CareersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCareersBinding.inflate(inflater, container, false);
        binding.tvNoCareerCareers.setVisibility(View.INVISIBLE);
        binding.rvCareersCareers.setVisibility(View.INVISIBLE);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CareersViewModel mViewModel = new ViewModelProvider(this).get(CareersViewModel.class);
        mViewModel.getUserCareers(SharedPreferneceHelper.getUserId(getContext())).observe(getViewLifecycleOwner(), userCareerModel -> {
            System.out.println("observer text wejdan");
            if (userCareerModel != null) {
                if (userCareerModel.getUserCareer() != null) {
                    List<UserCareer> userCareers = userCareerModel.getUserCareer();
                    UserCareersAdapter adapter = new UserCareersAdapter(getContext(), userCareers);
                    binding.rvCareersCareers.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    binding.rvCareersCareers.setAdapter(adapter);
                    binding.rvCareersCareers.setVisibility(View.VISIBLE);
                    binding.tvNoCareerCareers.setVisibility(View.INVISIBLE);
                } else {
                    binding.rvCareersCareers.setVisibility(View.INVISIBLE);
                    binding.tvNoCareerCareers.setVisibility(View.VISIBLE);
                }
            }
        });

//        List<String> myR = new LinkedList<>();
//        myR.add("22-MAY-20");
//        myR.add("21-MAY-20");
//        myR.add("22-MAY-21");
//        myR.add("22-DEC-20");
//        myR.add("22-MAY-20");
//        myR.add("11-MAY-19");
//        System.out.println(MaxDate(myR));
    }


    public long MaxDate(List<String> dates) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        Date maxDate = null;
        try {
            maxDate = sdf.parse(dates.get(0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(i);
            Date strDate = null;
            try {
                strDate = sdf.parse(dates.get(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (strDate.getTime() > maxDate.getTime()) {
                System.out.println("wejdan date" + strDate.getTime() + "   " + maxDate.getTime());
                maxDate = strDate;
            }else {
                System.out.println("wejdan date" + strDate.getTime() + "   " + maxDate.getTime());
            }
        }
        return maxDate.getTime();
    }

    //        System.currentTimeMillis() "22-MAY-20"

}

