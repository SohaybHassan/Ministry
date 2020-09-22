package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view.visitStart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ToastMsg;
import com.sh.wm.ministry.databinding.FragmentSafeBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter.SafeCardAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.SaftyQuestion;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.viewModel.SafetyViewModel;

import java.util.ArrayList;
import java.util.List;

public class SafeFragment extends Fragment {
private static final String TAG = SafeFragment.class.getName();
private FragmentSafeBinding binding ;
private  static int LAW_ID = 1;
private Observer<List<SaftyQuestion>> observer ;
private SafetyViewModel viewModel ;
private List<SaftyQuestion> cards;
private SafeCardAdapter adapter ;
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
         adapter = new SafeCardAdapter();
         viewModel= new ViewModelProvider(this).get(SafetyViewModel.class);
      observer = new Observer<List<SaftyQuestion>>() {
          @Override
          public void onChanged(List<SaftyQuestion> saftyQuestions) {
              if(saftyQuestions!=null){
                  cards=new ArrayList<>();
                  Log.d(TAG, "onChanged: NOT_NULL");
                  for(SaftyQuestion card : saftyQuestions){
                      cards.add(card);
                      Log.d(TAG, "onChanged: Card_ADDED");
                  }

                  adapter.setCardList(cards);
                  adapter.notifyDataSetChanged();
              }
              Log.d(TAG, "onChanged: NULL");
          }
      };

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getQuestions();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSafeBinding.inflate(inflater,container,false);
        binding.safeRecycler.setAdapter(adapter);
        binding.sfNext.setColorFilter(getResources().getColor(R.color.white));
        binding.sfNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getQuestions();
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
}

private void getQuestions(){
    if(LAW_ID<15){
        viewModel.getQuestionsByLawId(LAW_ID).observe(getViewLifecycleOwner(), observer);
        LAW_ID++ ;
    }else if(LAW_ID==15){
        viewModel.getQuestionsByLawId(LAW_ID).observe(getViewLifecycleOwner(), observer);
        binding.sfNext.setEnabled(false);
        LAW_ID=1;
    }


}
}