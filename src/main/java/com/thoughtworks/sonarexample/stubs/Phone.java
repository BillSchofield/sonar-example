package com.thoughtworks.sonarexample.stubs;

import java.awt.image.PixelGrabber;

public class Phone {
    private static PixelGrabber activeCall;

    public static PixelGrabber getActiveCall() {
        return activeCall;
    }
}
