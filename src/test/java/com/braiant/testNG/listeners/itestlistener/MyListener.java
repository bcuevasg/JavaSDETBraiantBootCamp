package com.braiant.testNG.listeners.itestlistener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("TestStarted -> " + result.getName());
        System.out.println("Test " +result.getStartMillis());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test passed was -> " + result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failed -> " + result.getName());
    }

}
