package com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.featuers.home.homeFiles.adjustmentReport.repository.AdjustmentReportRepository;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;

public class AdjustmentReportViewModel extends AndroidViewModel {
    AdjustmentReportRepository adjustmentReportRepository;

    public AdjustmentReportViewModel(@NonNull Application application) {
        super(application);
        adjustmentReportRepository = AdjustmentReportRepository.getInstance(application);

    }

    public LiveData<Construction> getConstructionData(String num_construction) {
        return adjustmentReportRepository.getConstructiondata(num_construction);
    }

}
