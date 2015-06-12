package com.thoughtworks.sonarexample;

import com.thoughtworks.sonarexample.stubs.Options;
import com.thoughtworks.sonarexample.stubs.Phone;
import com.thoughtworks.sonarexample.stubs.PhoneCall;

import java.awt.image.PixelGrabber;
import java.util.Timer;
import java.util.TimerTask;

public class CallMonitor {

    private Timer callTime;

    public CallMonitor(Timer callTime) {
        this.callTime = callTime;
    }

    public Timer getCallTime() {
        return callTime;
    }

    public void setCallTime(Timer callTime) {
        this.callTime = callTime;
    }

    public void monitor(int callId){

        if(Options.isActive().booleanValue()){
            callTime = new Timer();
            TimerTask callTimeTask = new TimerTask(){
                private Timer callTime;
                private long callTimeSeconds;

                public void run(){
                    callTimeSeconds++;
                    if((callTimeSeconds == Options.getSoftLimit().intValue()) && (Phone.getActiveCall().getStatus() == PhoneCall.STATUS_CONNECTED)){
                        injectDTMFTone(Phone.getActiveCall());
                    }else if((callTimeSeconds >= Options.getHardLimit().intValue()) && (Phone.getActiveCall().getStatus() == PhoneCall.STATUS_CONNECTED)){
                        injectEndCall();
                    }
                }

                private void injectDTMFTone(PixelGrabber activeCall) {
                }

                private void injectEndCall() {
                }
            };
            callTime.schedule(callTimeTask, 0, 1000);
        }else{
            System.out.println("Service not active");
        }
    }

}
