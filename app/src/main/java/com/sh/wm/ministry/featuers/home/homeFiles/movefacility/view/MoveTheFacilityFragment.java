package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.view;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentMoveTheFacilityBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Municipality;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Region;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.viewmodel.MoveFacilityViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class MoveTheFacilityFragment extends Fragment {

    private FragmentMoveTheFacilityBinding binding;
    public static final String TAG = MoveTheFacilityFragment.class.getSimpleName();
    private ShMyDialog shMyDialog;
    private BottomSheetDialog dialog;
    BottomSheetSearsh bottomSheetSearsh;
    private MoveFacilityViewModel moveFacilityViewModel;
    private ArrayList<String> AllRegion;
    private ArrayList<String> AllMunicipal;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentMoveTheFacilityBinding.inflate(inflater, container, false);
        dialog = new BottomSheetDialog(getContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moveFacilityViewModel = new ViewModelProvider(this).get(MoveFacilityViewModel.class);

        AllRegion = new ArrayList<>();
        AllMunicipal = new ArrayList<>();

        moveFacilityViewModel.getmunicipality().observe(getViewLifecycleOwner(), municipality -> {
            if (municipality != null) {
                if (municipality.getMunicipalities() != null) {
                    List<Municipality> municipalities = municipality.getMunicipalities();
                    for (Municipality municipality1 : municipalities) {
                        AllMunicipal.add(municipality1.getMUNICIPALITYNAMEAR());
                    }

                }
            }
        });
        moveFacilityViewModel.getregion().observe(getViewLifecycleOwner(), region -> {
            if (region != null) {
                if (region.getRegions() != null) {
                    List<Region> regions = region.getRegions();
                    for (Region region1 : regions) {
                        AllRegion.add(region1.getREGIONNAMEAR());
                    }

                }

            }

        });
        //null
        //  moveFacilityViewModel.getStreet().observe(getViewLifecycleOwner(), street -> Log.d(TAG, "onChanged: " + street.getStreets().get(1).getSTREETID()));

        binding.btnSaveMoveFacility.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "save true", Toast.LENGTH_SHORT).show();
            shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                @Override
                public void sase(View view) {
                    Toast.makeText(getContext(), "save true", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void edite(View view) {
                    shMyDialog.dismiss();
                }
            }, getString(R.string.save_enterprise_place));
            shMyDialog.show(getParentFragmentManager(), "hi thir");


        });
        binding.edNuFacility.setOnClickListener(view16 -> {

            bottomSheetSearsh = new BottomSheetSearsh(getActivity(), dialog, new BottomSheetSearsh.bottomSheetSearsh() {
                @Override
                public void searshByNumber(String num_facility) {
                    binding.edNuFacility.setVisibility(View.GONE);
                    binding.tvNuFacility.setVisibility(View.GONE);
                    binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                    moveFacilityViewModel.getConstructionData(num_facility).observe(getViewLifecycleOwner(), new Observer<Construction>() {
                        @Override
                        public void onChanged(Construction construction) {
                            if (construction != null) {

                                String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                                String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                                String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();

                                binding.cardViewSearshMoveFacility.tvOwnerName.setText("اسم المالك : " + name);
                                binding.cardViewSearshMoveFacility.tvBusinessName.setText("الاسم التجاري للمنشأة : " + nameConstruction);
                                binding.cardViewSearshMoveFacility.tvOwnerId.setText("رقم هوية المالك : "+user_cn);

                            } else {
                                Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    dialog.dismiss();
                }

            });


            bottomSheetSearsh.openDialog();



        });
//"المحافظة"
        binding.edGovernorate.setOnClickListener(view15 -> {

            Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();
            BottomSheetDialog dialog = new BottomSheetDialog(getContext());
            dialog.setContentView(R.layout.bottom_sheet_view);

            BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);

            listView.setOnItemClickListener((adapterView, view12, i, l) -> {
                binding.edGovernorate.setText(AllRegion.get(i));
                dialog.dismiss();
            });
            MaterialTextView titleTv = dialog.findViewById(R.id.tv_spinner_title_bottom_sheet);
            titleTv.setText(R.string.governorate);
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, AllRegion);
            listView.setAdapter(itemsAdapter);
            dialog.show();
        });
//البلدية
        binding.edMunicipal.setOnClickListener(view13 -> {
            Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();

            BottomSheetDialog dialog = new BottomSheetDialog(getContext());
            dialog.setContentView(R.layout.bottom_sheet_view);

            BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);
            listView.setOnItemClickListener((adapterView, view131, i, l) -> {
                binding.edMunicipal.setText(AllMunicipal.get(i));
                dialog.dismiss();
            });
            MaterialTextView titleTv = dialog.findViewById(R.id.tv_spinner_title_bottom_sheet);
            titleTv.setText(R.string.municipal);
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, AllMunicipal);

            listView.setAdapter(itemsAdapter);
            dialog.show();

        });
        binding.cardViewSearshMoveFacility.imgEdit.setOnClickListener(view14 -> {
            binding.edNuFacility.setVisibility(View.VISIBLE);
            binding.tvNuFacility.setVisibility(View.VISIBLE);
            binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
            bottomSheetSearsh.openDialog();
        });

    }

/*
    private void openDialog() {

        View view = getLayoutInflater().inflate(R.layout.my_buttom_sheet, null);
        dialog.setContentView(view);

        EditText ed_searsh = view.findViewById(R.id.searsh_nu_facelity);
        ImageView img_searsh_sheet = view.findViewById(R.id.img_searsh_sheet);
        img_searsh_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.edNuFacility.setVisibility(View.GONE);
                binding.tvNuFacility.setVisibility(View.GONE);
                binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                moveFacilityViewModel.getConstructionData(ed_searsh.getText().toString()).observe(getViewLifecycleOwner(), new Observer<Construction>() {
                    @Override
                    public void onChanged(Construction construction) {
                        if (construction != null) {

                            String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                            String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                            String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();

                            binding.cardViewSearshMoveFacility.tvOwnerName.setText("اسم المالك : " + name);
                            binding.cardViewSearshMoveFacility.tvBusinessName.setText("" + nameConstruction);
                            binding.cardViewSearshMoveFacility.tvOwnerId.setText(user_cn);

                        } else {
                            Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                dialog.dismiss();
            }
        });

        dialog.show();

    }
*/

}