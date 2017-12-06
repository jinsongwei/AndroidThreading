package com.williamjin.threading;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by william on 12/6/17.
 */

public class Worker {
    private int seconds;
    private String workerNum;

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(String workerNum) {
        this.workerNum = workerNum;
    }

    public Worker(int seconds, String workerNum) {
        if (seconds > 10 || seconds <= 0) {
            this.seconds = seconds;
        } else {
            this.seconds = seconds;
        }
        this.workerNum = workerNum;
    }

    public void digGolden() {
        Log.d(TAG, "digGolden: start to work Numerber: " + workerNum);
        int count = 0;
        while (count < seconds) {
            try {
                Thread.sleep(1000 * seconds);
                Log.d(TAG, "digGolden: working on " + workerNum);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.e(TAG, "digGolden: found one. worker " + workerNum + " finished");
    }

    public void digGoldenSeconds() {
        Log.d(TAG, "digGolden: start to work Numerber: " + workerNum);
        int count = 0;
        while (count < seconds) {
            try {
                Thread.sleep(1000 * seconds);
                Log.d(TAG, "digGolden: working on " + workerNum);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.e(TAG, "digGolden: found one. worker " + workerNum + " finished");
    }
}
