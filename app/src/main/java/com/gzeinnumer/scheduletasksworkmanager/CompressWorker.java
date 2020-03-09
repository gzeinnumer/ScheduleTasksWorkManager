package com.gzeinnumer.scheduletasksworkmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class CompressWorker extends Worker {

    public CompressWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {
        // Do the work here--in this case, upload the images.

        Log.d("MYZEIN", "doWork: di cas ya?");

        // Indicate whether the task finished successfully with the Result
        return Result.success();
    }
}
