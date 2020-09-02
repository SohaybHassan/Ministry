package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.wm.ministry.databinding.FragmentAllVisitsBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter.PaginationScrollListener;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.adapter.VisitsAdapter;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Visit;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.viewModel.VisitViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;



public class AllVisitsFragment extends Fragment {
 private FragmentAllVisitsBinding binding ;
 private VisitsAdapter adapter ;
 private VisitViewModel viewModel ;
 private List<Visit> visits;
 private Observer<List<Visit>> observer ;
 public static final String TAG = AllVisitsFragment.class.getCanonicalName();

     //TODO: add onClickListener for visit buttons
    //TODO: enabling buttons based on Status

    public AllVisitsFragment() {
        // Required empty public constructor
    }//end constructor


    @NotNull
    public static AllVisitsFragment newInstance(String param1, String param2) {
        AllVisitsFragment fragment = new AllVisitsFragment();
        return fragment;
    }//end newInstance

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         adapter= new VisitsAdapter();

         observer=new Observer<List<Visit>>() {
             @Override
             public void onChanged(List<Visit> visits) {
                 if(visits!=null){
                 for(Visit card: visits){
                     adapter.addCard(card);
                     Log.d(TAG, "onChNGED: added");

                 }//end for
                     adapter.notifyDataSetChanged();
                     Log.d(TAG, "onChNGED: added " + adapter.getItemCount());
                 }//end if
                 toggleEmptyCards();
             }
         };

    }//end onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAllVisitsBinding.inflate(inflater,container ,false);
        viewModel= new ViewModelProvider(this).get(VisitViewModel.class);
         viewModel.getAllVisits(null).observe(getViewLifecycleOwner(),observer);
      //  viewModel.getPage("799",0,10).observe(getViewLifecycleOwner(),observer);

        return binding.getRoot();
    }//end onCreateView


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.visitRecyclerView.setAdapter(adapter);
        // There is sth wrong at determine the 1st and last index to make subList off
        //TODO : ADD PROGRESSBAR TO SHOW LOADING
//        binding.visitRecyclerView.addOnScrollListener(
//                new PaginationScrollListener((LinearLayoutManager)binding.visitRecyclerView.getLayoutManager()) {
//            @Override
//            public void loadMoreItems() {
//                setLoading(true);
//                incCurrentPage();
//                viewModel.getPage("799",getFirstItem(),getLastItem()).observe(getViewLifecycleOwner(),observer);
//                setLoading(false);
//            }//end loadMoreItems
//        });

    }//end onViewCreated

    private void toggleEmptyCards(){
        if(adapter.getItemCount()==0){
            binding.noVisits.setVisibility(View.VISIBLE);
            binding.visitRecyclerView.setVisibility(View.GONE);

        }//end if
        else{
            binding.visitRecyclerView.setVisibility(View.VISIBLE);
            binding.noVisits.setVisibility(View.GONE);

        }//end else
    }// end toggleEmptyCards


}//end Class