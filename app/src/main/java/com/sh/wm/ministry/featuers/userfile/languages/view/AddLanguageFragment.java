package com.sh.wm.ministry.featuers.userfile.languages.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
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
import com.sh.wm.ministry.custem.ShMyDialog;
import com.sh.wm.ministry.databinding.FragmentAddLanguageBinding;
import com.sh.wm.ministry.featuers.userfile.languages.model.Language;
import com.sh.wm.ministry.featuers.userfile.languages.viewmodel.LanguagesViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddLanguageFragment extends Fragment {

    private LanguagesViewModel mViewModel;
    private FragmentAddLanguageBinding binding;
    private List<String> lang, level;
    private ShMyDialog dialog;

    public static AddLanguageFragment newInstance() {
        return new AddLanguageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddLanguageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lang = new ArrayList<>();
        level = new ArrayList<>();

        getBundleData();
        getLanguages();
        editLanguage();
        editSkills();
        btnListener();

    }

    public void getBundleData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            binding.tvLanguage.setText(bundle.getString("language"));
            binding.tvSpeakingSkill.setText(bundle.getString("speaking_skill"));
            binding.tvWritingSkill.setText(bundle.getString("writing_skill"));
            binding.tvReadingSkill.setText(bundle.getString("reading_skill"));
        }
    }

    public void getLanguages() {
        mViewModel = new ViewModelProvider(this).get(LanguagesViewModel.class);
        mViewModel.getAllLanguages().observe(getViewLifecycleOwner(), new Observer<List<Language>>() {
            @Override
            public void onChanged(List<Language> languages) {
                if (languages != null) {
                    for (Language language : languages) {
                        lang.add(language.getLANGUAGEARNAME());
                    }
                } else {
                    Toast.makeText(getContext(), "no response", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void editLanguage() {
        binding.tvLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtmSheet(R.string.language, lang, binding.tvLanguage);
            }
        });
    }

    public void editSkills() {
        String[] strings = getResources().getStringArray(R.array.btm_sheet_language_level);
        level.addAll(Arrays.asList(strings));

        binding.tvSpeakingSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtmSheet(R.string.level, level, binding.tvSpeakingSkill);
            }
        });

        binding.tvWritingSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtmSheet(R.string.level, level,  binding.tvWritingSkill);
            }
        });

        binding.tvReadingSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtmSheet(R.string.level, level, binding.tvReadingSkill);
            }
        });
    }

    public void showBtmSheet(int title, List<String> list, TextView tv_change) {

        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(R.layout.bottom_sheet_view);
        BottomSheetListView listView = dialog.findViewById(R.id.listViewBtmSheet);
        MaterialTextView titleTv = dialog.findViewById(R.id.tv_spinner_title_bottom_sheet);
        titleTv.setText(title);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(itemsAdapter);
        dialog.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv_change.setText(adapterView.getItemAtPosition(i).toString());
                dialog.cancel();
            }
        });
    }


    public void btnListener() {

        binding.btnSaveAddLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ShMyDialog(new ShMyDialog.Dilogclicked() {
                    @Override
                    public void sase(View view) {
                        if (binding.tvLanguage.getText().toString().isEmpty() || binding.tvReadingSkill.getText().toString().isEmpty()|| binding.tvSpeakingSkill.getText().toString().isEmpty() ||  binding.tvWritingSkill.getText().toString().isEmpty()) {
                            Toast.makeText(getContext(), "empty fields", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "you saved the language", Toast.LENGTH_SHORT).show();
                        }

                        dialog.dismiss();
                    }

                    @Override
                    public void edite(View view) {
                        Toast.makeText(getContext(), "you may edit the language", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }, getString(R.string.save_language),getString(R.string.save),getString(R.string.edit));
                dialog.show(getParentFragmentManager(), "dialog tag");
            }
        });


    }

}