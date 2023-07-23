package com.braiant.testNG.listeners.itestlistener;

import org.testng.IExecutionListener;

public class ItestExecutionListerner implements IExecutionListener {
    public void onExecutionStart(){
        long startTime = System.currentTimeMillis();
        System.out.println("All Suite have started at: " + startTime);
    }

    public void onExecutionFinish(){
        long endTime = System.currentTimeMillis();
        System.out.println("All Suite have ended at: " + endTime);

    }
}
