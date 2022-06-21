package com.reactnativemarkethelper;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import me.simple.markethelper.MarketHelper;

@ReactModule(name = MarketHelperModule.NAME)
public class MarketHelperModule extends ReactContextBaseJavaModule {
    public static final String NAME = "MarketHelper";

    ReactApplicationContext reactContext;

    public MarketHelperModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void open() {
       MarketHelper.INSTANCE.open(reactContext, reactContext.getPackageName());
    }
}
