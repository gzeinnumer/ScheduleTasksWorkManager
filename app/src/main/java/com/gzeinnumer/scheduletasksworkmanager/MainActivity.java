package com.gzeinnumer.scheduletasksworkmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ssat activity beralan, lasung access ini
//        OneTimeWorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UploadWorker.class)
//                .addTag("uploadWorkRequest").build();
//        WorkManager.getInstance(getApplicationContext()).enqueue(uploadWorkRequest);

        //jalankan jika hp di cass maka ini akan dijalankan
//        Constraints constraints = new Constraints.Builder()
//                .setRequiresDeviceIdle(true)
//                .setRequiresCharging(true)
//                .build();
//        OneTimeWorkRequest compressionWork =
//                new OneTimeWorkRequest.Builder(CompressWorker.class)
//                        .setConstraints(constraints)
//                        .addTag("compressionWork")
//                        .build();
//        WorkManager.getInstance(getApplicationContext()).enqueue(compressionWork);

        //jalankan jika setiap 15 menit
        OneTimeWorkRequest onTime = new OneTimeWorkRequest.Builder(TimeWorker.class)
                .setInitialDelay(15, TimeUnit.MINUTES)
                .addTag("onTime")
                .build();

        WorkManager.getInstance(getApplicationContext()).enqueue(onTime);

    }
}
