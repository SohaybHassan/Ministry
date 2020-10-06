package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.view;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textview.MaterialTextView;
import com.sh.wm.ministry.R;
import com.sh.wm.ministry.custem.BottomSheetListView;
import com.sh.wm.ministry.custem.BottomSheetSearsh;
import com.sh.wm.ministry.custem.BottomSheetSearshList;
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentMoveTheFacilityBinding;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.Construct;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.PoastDataMoveFacility;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.viewmodel.MoveFacilityViewModel;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class MoveTheFacilityFragment extends Fragment {

    private FragmentMoveTheFacilityBinding binding;
    public static final String TAG = MoveTheFacilityFragment.class.getSimpleName();
    private ShMyDialog shMyDialog;
    private BottomSheetDialog dialog;
    private BottomSheetSearsh bottomSheetSearsh;
    private MoveFacilityViewModel moveFacilityViewModel;
    private ArrayList<String> AllRegion;
    private ArrayList<String> AllRegionID;
    private ArrayList<String> AllMunicipal;
    private ArrayList<String> AllMunicipalID;
    private Observer<ConstructByName> constructByNameObserver;
    private BottomSheetSearshList bottomSheetSearshList;
    private ImageView imNoData;
    private ProgressBar progressBar;
    private Observer<Construction> constructionObserver;
    private EditText ed_text;
    private Observer<PoastDataMoveFacility> poastDataMoveFacilityObserver;
    private BottomSheetSearshList.MyTestAdapter myTestAdapter;
    String Constraction_id, addressId, municipapiity_id, region_id, mobile;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        constructionObserver = new Observer<Construction>() {
            @Override
            public void onChanged(Construction construction) {
                if (construction != null) {

                    String name = construction.getCONSTRUCTIONOWNER().getOWNERNAME();
                    String nameConstruction = construction.getCONSTRUCTNAMEUSING();
                    String user_cn = construction.getCONSTRUCTIONOWNER().getCONSTRUCTID();
                    binding.cardViewSearshMoveFacility.tvOwnerName.setText("اسم المالك : " + name);
                    binding.cardViewSearshMoveFacility.tvBusinessName.setText("الاسم التجاري للمنشأة : " + nameConstruction);
                    binding.cardViewSearshMoveFacility.tvOwnerId.setText("رقم هوية المالك : " + user_cn);

                    binding.edNuFacility.setVisibility(View.GONE);
                    binding.edNuFacility.setText("ok");
                    binding.tvNuFacility.setVisibility(View.GONE);
                    binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                    binding.progressbar.setVisibility(View.GONE);
                    enapel(true);





                } else {
                    Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
                    binding.progressbar.setVisibility(View.GONE);
                    enapel(true);
                    binding.edNuFacility.setVisibility(View.VISIBLE);
                    binding.tvNuFacility.setVisibility(View.VISIBLE);
                    binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.GONE);
                }
            }
        };
        poastDataMoveFacilityObserver = new Observer<PoastDataMoveFacility>() {
            @Override
            public void onChanged(PoastDataMoveFacility poastDataMoveFacility) {

                if (poastDataMoveFacility != null) {
                    Toast.makeText(getContext(), poastDataMoveFacility.getMessageText(), Toast.LENGTH_SHORT).show();
                    binding.progressbar.setVisibility(View.GONE);
                    enapel(true);
                } else {
                    Toast.makeText(getContext(), "no data send", Toast.LENGTH_SHORT).show();
                    binding.progressbar.setVisibility(View.GONE);
                    enapel(true);
                }

            }
        };

        constructByNameObserver = new Observer<ConstructByName>() {
            @Override
            public void onChanged(ConstructByName constructByName) {

                if (constructByName != null) {
                    bottomSheetSearshList.setMyList(constructByName.getConstructs());
                    bottomSheetSearshList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    bottomSheetSearshList.setBottomSheetDialog(dialog);
                    myTestAdapter = new BottomSheetSearshList.MyTestAdapter(new BottomSheetSearshList.MyTestAdapter.MyClass() {
                        @Override
                        public void MyMethod(Construct constructByName) {
                            binding.cardViewSearshMoveFacility.tvOwnerName.setText("اسم المالك : " + constructByName.getCONSTRUCTIONOWNER().getOWNERNAME());
                            binding.cardViewSearshMoveFacility.tvBusinessName.setText("الاسم التجاري للمنشأة : " + constructByName.getCONSTRUCTNAMEUSING());
                            binding.cardViewSearshMoveFacility.tvOwnerId.setText("رقم هوية المالك : " + constructByName.getCONSTRUCTIONOWNER().getUSERSN());
                            addressId = constructByName.getCONSTRUCTADDRESS();
                            Constraction_id = constructByName.getCONSTRUCTID();
                            mobile = constructByName.getCONSTRUCTMOBILE();

                            ed_text.setText("");
                            imNoData.setVisibility(View.VISIBLE);
                        }
                    });
                    binding.edNuFacility.setVisibility(View.GONE);
                    binding.edNuFacility.setText("ok");
                    binding.tvNuFacility.setVisibility(View.GONE);
                    binding.cardViewSearshMoveFacility.cardViewSearshMoveFacilitySh.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);

                    bottomSheetSearshList.setAdapter(myTestAdapter);
                } else {
                    imNoData.setVisibility(View.VISIBLE);
                    Log.d(TAG, "onChanged: no data");
                    Toast.makeText(getActivity(), "no data", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        };
    }

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
        AllRegionID = new ArrayList<>();
        AllMunicipal = new ArrayList<>();
        AllMunicipalID = new ArrayList<>();

        //hi sohayb, now you can get the municipalities from database not api request directly.
        // so I edited the code as it suits data types
        moveFacilityViewModel.getAllMunicipalities().observe(getViewLifecycleOwner(), municipalities -> {
            if (municipalities != null) {
                for (Municipality municipality : municipalities) {
                    AllMunicipal.add(municipality.getMUNICIPALITYNAMEAR());
                    AllMunicipalID.add(municipality.getMUNICIPALITYID());
                }

            }
        });

        // I did the same thing here :)
        moveFacilityViewModel.getAllRegions().observe(getViewLifecycleOwner(), regions -> {
            if (regions != null) {
                for (Region region : regions) {
                    AllRegion.add(region.getREGIONNAMEAR());
                    AllRegionID.add(region.getREGIONID());
                }
            }

        });
        //null
        //  moveFacilityViewModel.getStreet().observe(getViewLifecycleOwner(), street -> Log.d(TAG, "onChanged: " + street.getStreets().get(1).getSTREETID()));

        binding.btnSaveMoveFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (binding.edNuFacility.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إدخال رقم منشأة", Toast.LENGTH_SHORT).show();
                } else if (binding.edGovernorate.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إختار المحافظة ", Toast.LENGTH_SHORT).show();
                } else if (binding.edMunicipal.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إختار البلدية ", Toast.LENGTH_SHORT).show();
                } else if (binding.edSistrict.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إدخل الحي الذي تعيش فية", Toast.LENGTH_SHORT).show();
                } else if (binding.edStreet.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "أرجو منك إدخال الشارع", Toast.LENGTH_SHORT).show();
                } else if (binding.edTitleDescription.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إدخال تفاصيل عن المكان", Toast.LENGTH_SHORT).show();
                } else if (binding.edMailboxNumber.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إدخال رقم صندوق البريد", Toast.LENGTH_SHORT).show();
                } else if (binding.edElectronicPage.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك وضع رابط لصحة المنشأة", Toast.LENGTH_SHORT).show();
                } else if (binding.edEmail.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك وضع إميل المنشأة", Toast.LENGTH_SHORT).show();
                } else if (binding.edBuldingNum.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "الرجو منك إدخال رقم المبنى", Toast.LENGTH_SHORT).show();
                } else if (binding.edFaxNum.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إدخال رقم الفاكس ", Toast.LENGTH_SHORT).show();
                } else if (binding.edLat.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك أدخال موقع على الخريطة خطوط الطوال", Toast.LENGTH_SHORT).show();
                } else if (binding.edLong.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك أدخال موقع على الخريطة خطوط العرض", Toast.LENGTH_SHORT).show();
                } else if (binding.edPhoneNumber.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إدخال رقم الجوال", Toast.LENGTH_SHORT).show();
                } else if (binding.edTelephone.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "ارجو منك إدخال رقم التلفوان", Toast.LENGTH_SHORT).show();
                } else if (true) {
                    shMyDialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                        @Override
                        public void sase(View view) {
                            binding.progressbar.setVisibility(View.VISIBLE);
                            enapel(false);
                            binding.progressbar.setVisibility(View.VISIBLE);
                            String desc = binding.edTitleDescription.getText().toString();
                            String box = binding.edMailboxNumber.getText().toString();
                            String url = binding.edElectronicPage.getText().toString();
                            String nu_buldeing = binding.edBuldingNum.getText().toString();
                            String fax = binding.edFaxNum.getText().toString();
                            String lat = binding.edLat.getText().toString();
                            String log = binding.edLong.getText().toString();
                            String telephone = binding.edTelephone.getText().toString();

                            moveFacilityViewModel.poastData(Constraction_id, addressId, municipapiity_id, region_id, "5", nu_buldeing, desc, lat, log, telephone, mobile, fax, box, url).observe(getViewLifecycleOwner(), poastDataMoveFacilityObserver);

                            shMyDialog.dismiss();
                        }

                        @Override
                        public void edite(View view) {
                            shMyDialog.dismiss();
                        }
                    }, getString(R.string.save_enterprise_place), getString(R.string.save), getString(R.string.edit));
                    shMyDialog.show(getParentFragmentManager(), "hi thir");
                }


            }
        });


        binding.edNuFacility.setOnClickListener(view15 -> {
            dialog.setContentView(R.layout.bottom_sheet_eaarch);
            ed_text = dialog.findViewById(R.id.search_view);
            bottomSheetSearshList = dialog.findViewById(R.id.recycler_view);
            bottomSheetSearshList = dialog.findViewById(R.id.recycler_view);
            imNoData = dialog.findViewById(R.id.image_no_data);
            progressBar = dialog.findViewById(R.id.progressbar);
            ed_text.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    Toast.makeText(getActivity(), "beforeTextChanged", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    Toast.makeText(getActivity(), "onTextChanged", Toast.LENGTH_SHORT).show();
                    if (i2 >= 3) {
                        progressBar.setVisibility(View.VISIBLE);
                        imNoData.setVisibility(View.GONE);
                        Toast.makeText(getActivity(), "=> " + i2, Toast.LENGTH_SHORT).show();
                        moveFacilityViewModel.getConstruct(ed_text.getText().toString()).observe(getViewLifecycleOwner(), constructByNameObserver);
                    } else{
                        BottomSheetSearshList.clerList();
                        progressBar.setVisibility(View.GONE);
                        imNoData.setVisibility(View.VISIBLE);

                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    Toast.makeText(getActivity(), "afterTextChanged", Toast.LENGTH_SHORT).show();
                    BottomSheetSearshList.clerList();
                }
            });
            dialog.show();

        });

//"المحافظة"
        binding.edGovernorate.setOnClickListener(view15 -> {

            Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();
            BottomSheetDialog dialog = new BottomSheetDialog(getContext());
            dialog.setContentView(R.layout.bottom_sheet_view);

            BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);

            listView.setOnItemClickListener((adapterView, view12, i, l) -> {
                binding.edGovernorate.setText(AllRegion.get(i));
                region_id = AllRegionID.get(i);
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
                municipapiity_id = AllMunicipalID.get(i);

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
            enapel(true);
            binding.edNuFacility.setText("");
            dialog.show();

        });

    }


    public void enapel(boolean states) {
        binding.edNuFacility.setEnabled(states);
        binding.edBuldingNum.setEnabled(states);
        binding.edElectronicPage.setEnabled(states);
        binding.edEmail.setEnabled(states);
        binding.edFaxNum.setEnabled(states);
        binding.edGovernorate.setEnabled(states);
        binding.edLat.setEnabled(states);
        binding.edLong.setEnabled(states);
        binding.edMailboxNumber.setEnabled(states);
        binding.edPhoneNumber.setEnabled(states);
        binding.edSistrict.setEnabled(states);
        binding.edStreet.setEnabled(states);
        binding.edTelephone.setEnabled(states);
        binding.edTitleDescription.setEnabled(states);
        binding.edMunicipal.setEnabled(states);


    }

}