package com.williamjin.threading;

/**
 * Created by william on 12/6/17.
 */

public class WorkerThread implements Runnable{

    private Worker worker;

    public WorkerThread(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        worker.digGolden();
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
