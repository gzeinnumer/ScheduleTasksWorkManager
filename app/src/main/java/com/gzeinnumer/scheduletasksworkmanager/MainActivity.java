package com.gzeinnumer.scheduletasksworkmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ssat activity beralan, lasung access ini
        OneTimeWorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UploadWorker.class)
                .addTag("uploadWorkRequest").build();
        WorkManager.getInstance(getApplicationContext()).enqueue(uploadWorkRequest);

        //jalankan jika hp di cass maka ini akan dijalankan
        Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build();
        OneTimeWorkRequest compressionWork =
                new OneTimeWorkRequest.Builder(CompressWorker.class)
                        .setConstraints(constraints)
                        .addTag("compressionWork")
                        .build();
        WorkManager.getInstance(getApplicationContext()).enqueue(compressionWork);

        //jalankan jika setiap 15 menit
        Log.d("MYZEIN", "jalan kok");
        PeriodicWorkRequest workRequest = new PeriodicWorkRequest.Builder(TimeWorker.class, 15, TimeUnit.MINUTES).build();
        WorkManager.getInstance(getApplicationContext()).enqueue(workRequest);

    }
}
