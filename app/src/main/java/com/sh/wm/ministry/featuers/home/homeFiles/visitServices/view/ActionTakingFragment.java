package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentActionTakingBinding;


public class ActionTakingFragment extends Fragment {
private FragmentActionTakingBinding binding ;
    private ShMyDialog dialog;


    public ActionTakingFragment() {
        // Required empty public constructor
    }//end constructor


    public static ActionTakingFragment newInstance(String param1, String param2) {
        ActionTakingFragment fragment = new ActionTakingFragment();

        return fragment;
    }//end newInstance(..)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }//end onCreate()

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentActionTakingBinding.inflate(inflater,container,false);
        binding.btnSaveActionTaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void save(View view) {
                        Toast.makeText(getContext(), "save", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                    @Override
                    public void edit(View view) {
                        Toast.makeText(getContext(), "edit", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }, getString(R.string.action_taking_confirmation),getString(R.string.save),getString(R.string.edit));
                dialog.show(getParentFragmentManager(), "ActionTaking Fragment");
            }//end onClick()
        });
        return binding.getRoot();
    }//end onCreate()
}//end class