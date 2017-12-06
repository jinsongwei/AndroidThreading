package com.williamjin.threading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";
    TextView tvWorkInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvWorkInfo = findViewById(R.id.tv_work_info);
    }

    public void handleButton(View view) {
        List<Worker> workers;
        switch (view.getId()) {
            case R.id.btn_parallel_async_task:
                workers = new ArrayList<>();
                Worker worker1 = new Worker(4, "a");
                Worker worker2 = new Worker(3, "b");
                Worker worker3 = new Worker(2, "c");
                workers.add(worker1);
                workers.add(worker2);
                workers.add(worker3);

                for (Worker worker : workers) {
                    WorkerAsyncTask workerAsyncTask = new WorkerAsyncTask(null);
                    workerAsyncTask.execute(worker);
                }
                break;
            case R.id.btn_executer_manager:
                int total = 10;
                workers = new ArrayList<>();
                for (int i = 0; i < total; i++) {
                    workers.add(new Worker(i % 5, String.valueOf((char) ('a' + i))));
                }

                ExecutorService executor = Executors.newFixedThreadPool(3);
                for (int i = 0; i < total; i++) {
                    Runnable worker = new WorkerThread(new Worker(i % 5, String.valueOf((char) ('a' + i))));
                    executor.execute(worker);
                }
                executor.shutdown();
                while (!executor.isTerminated()) ;
                Log.d(TAG, "handleButton: " + " all finished");
                break;

            case R.id.btn_run_on_ui_thread:
                total = 10;
                for (int i = 0; i < total; i++) {
                    runThread(new Worker(i % 5, String.valueOf((char) ('a' + i))));
                }

                break;
            default:
                break;
        }
    }

    private void runThread(final Worker worker) {
        new Thread(){
            public void run(){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        worker.digGolden();
                        tvWorkInfo.setText(worker.getWorkerNum() + " work " + worker.getSeconds() + " time units");
                    }
                });
            }
        }.start();
    }
}
