package com.williamjin.threading;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * Created by william on 12/6/17.
 */

public class WorkerAsyncTask extends AsyncTask<Worker, Integer, String> {
    TextView textView;
    public WorkerAsyncTask(TextView textView){
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Worker... workers) {
        Log.d(TAG, "doInBackground: " + Thread.currentThread());
        Worker worker = workers[0];
        worker.digGolden();
        return "Task complete for " + worker.getWorkerNum();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());
    }
}
