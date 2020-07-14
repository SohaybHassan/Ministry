package com.sh.wm.ministry.featuers.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.databinding.FragmentHomeBinding;
import com.sh.wm.ministry.featuers.home.viewModel.HomeViewModel;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private OnHomeFragmentInteractionListener mListener;
    private OnFragmentInteractionListener mlistener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //display views depend on user role
//        String role = getArguments().getString("role");
//        if (role.equals("1") || role == null) {
//            binding.cvVisitsServices.setVisibility(View.INVISIBLE);
//        }
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> {

        });

        //bind main card title
        binding.cvWorkerComplaint.tvTitleHomeCard.setText(getString(R.string.worker_complaint));
        binding.cvRequestCalculateLaborRights.tvTitleHomeCard.setText(getString(R.string.request_calculate_labor_rights));
        binding.cvRequsetRegisterCertification.tvTitleHomeCard.setText(getString(R.string.requset_register_certification));
        binding.cvVisitsServices.tvTitleHomeCard.setText(getString(R.string.visits_services));

        //bind main card icon
        binding.cvWorkerComplaint.ivHomeCard.setImageResource(R.drawable.ic_workers_complaint);
        binding.cvRequestCalculateLaborRights.ivHomeCard.setImageResource(R.drawable.ic_calculate_financial_rights);
        binding.cvRequsetRegisterCertification.ivHomeCard.setImageResource(R.drawable.ic_policy);
        binding.cvVisitsServices.ivHomeCard.setImageResource(R.drawable.ic_visiting_services);

        //bind slide card view tint
        binding.cvReportNewWorkPlace.viewAccent.setBackgroundColor(getResources().getColor(R.color.mercury));
        binding.cvLegalAction.viewAccent.setBackgroundColor(getResources().getColor(R.color.mercury));
        binding.cvCreateSeizureReport.viewAccent.setBackgroundColor(getResources().getColor(R.color.mercury));

        //bind facility services card
        binding.btnMoveFacility.tvTitleSlideCardHome.setText(getString(R.string.move_facility));
        binding.cvReportNewWorkPlace.tvTitleSlideCardHome.setText(getString(R.string.report_at_new_work_place));
        binding.cvReportLeftWorkInPlace.tvTitleSlideCardHome.setText(getString(R.string.report_left_work_place));

        //bind facility legal procedures
        binding.cvAlertTemplate.tvTitleSlideCardHome.setText(getString(R.string.alert_template));
        binding.cvCloseFacility.tvTitleSlideCardHome.setText(getString(R.string.close_facility));
        binding.cvLegalAction.tvTitleSlideCardHome.setText(getString(R.string.legal_action));
        binding.cvCreateSeizureReport.tvTitleSlideCardHome.setText(getString(R.string.create_seizure_report));


        binding.cvWorkerComplaint.cvWorkerComplaint.setOnClickListener(view1 -> {
            mListener.onHomeFragmentInteraction(1);
        });

        //
        binding.btnMoveFacility.moveFacilityHomeFragmrnt.setOnClickListener(view12 -> mlistener.onHomeSlideNav(1));
        binding.cvReportNewWorkPlace.moveFacilityHomeFragmrnt.setOnClickListener(view13 -> mlistener.onHomeSlideNav(2));
        binding.cvReportLeftWorkInPlace.moveFacilityHomeFragmrnt.setOnClickListener(view14 -> mlistener.onHomeSlideNav(3));
        //
        binding.cvAlertTemplate.moveFacilityHomeFragmrnt.setOnClickListener(view15 -> mlistener.onHomeSlideNav(4));
        binding.cvLegalAction.moveFacilityHomeFragmrnt.setOnClickListener(view16 -> mlistener.onHomeSlideNav(5));
        binding.cvCloseFacility.moveFacilityHomeFragmrnt.setOnClickListener(view17 -> mlistener.onHomeSlideNav(6));
        binding.cvCreateSeizureReport.moveFacilityHomeFragmrnt.setOnClickListener(view18 -> mlistener.onHomeSlideNav(7));
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeFragmentInteractionListener) {
            mListener = (OnHomeFragmentInteractionListener) context;
            mlistener = (OnFragmentInteractionListener) context;

        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public interface OnHomeFragmentInteractionListener {
        void onHomeFragmentInteraction(int cardPos);
    }
}