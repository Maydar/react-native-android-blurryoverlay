package com.kwaak.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import android.app.Activity;
import android.util.Log;

public class BlurryOverlayManager extends SimpleViewManager<BlurryOverlayView> {

    private ReactApplicationContext appContext;

    public BlurryOverlayManager(ReactApplicationContext reactContext) {
        this.appContext = reactContext;
    }

    public static final String REACT_CLASS = "RCTBlurryOverlay";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public BlurryOverlayView createViewInstance(ThemedReactContext context) {
        Log.i("BlurryOverlayView", "createViewInstance");
        BlurryOverlayView c = new BlurryOverlayView(context, appContext.getCurrentActivity());

        return c;
    }

    @ReactProp(name = "radius", defaultInt = 0)
    public void setRadius(BlurryOverlayView view, int radius) {
        view.setRadiusAndUpdate(radius);
    }

    @ReactProp(name = "sampling", defaultInt = 0)
    public void setSampling(BlurryOverlayView view, int sampling) {
        view.setSamplingAndUpdate(sampling);
    }

    @ReactProp(name = "color")
    public void setColor(BlurryOverlayView view, String color) {
        view.setColorAndUpdate(color);
    }
}

