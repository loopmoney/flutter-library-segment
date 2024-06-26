package com.example.flutter_segment;

import android.os.Bundle;

import java.util.HashMap;

public class FlutterSegmentOptions {
    private final String writeKey;
    private final Boolean trackApplicationLifecycleEvents;
    private final Boolean trackAttributionInformation;
    private final Boolean amplitudeIntegrationEnabled;
    private final Boolean appsFlyerIntegrationEnabled;
    private final Boolean debug;

    public FlutterSegmentOptions(String writeKey, Boolean trackApplicationLifecycleEvents, Boolean trackAttributionInformation, Boolean amplitudeIntegrationEnabled, Boolean appsFlyerIntegrationEnabled, Boolean debug) {
        this.writeKey = writeKey;
        this.trackApplicationLifecycleEvents = trackApplicationLifecycleEvents;
        this.trackAttributionInformation = trackAttributionInformation;
        this.amplitudeIntegrationEnabled = amplitudeIntegrationEnabled;
        this.appsFlyerIntegrationEnabled = appsFlyerIntegrationEnabled;
        this.debug = debug;
    }

    public String getWriteKey() {
        return writeKey;
    }

    public Boolean getTrackApplicationLifecycleEvents() {
        return trackApplicationLifecycleEvents;
    }

    public Boolean getTrackAttributionInformation() {
        return trackAttributionInformation;
    }

    public Boolean isAmplitudeIntegrationEnabled() {
        return amplitudeIntegrationEnabled;
    }

    public Boolean isAppsFlyerIntegrationEnabled() {
        return appsFlyerIntegrationEnabled;
    }

    public Boolean getDebug() {
        return debug;
    }

    static FlutterSegmentOptions create(Bundle bundle) {
        String writeKey = bundle.getString("com.claimsforce.segment.WRITE_KEY");
        Boolean trackApplicationLifecycleEvents = bundle.getBoolean("com.claimsforce.segment.TRACK_APPLICATION_LIFECYCLE_EVENTS");
        Boolean trackAttributionInformation = bundle.getBoolean("com.claimsforce.segment.TRACK_ATTRIBUTION_INFORMATION");
        Boolean isAmplitudeIntegrationEnabled = bundle.getBoolean("com.claimsforce.segment.ENABLE_AMPLITUDE_INTEGRATION", false);
        Boolean isAppsFlyerIntegrationEnabled = bundle.getBoolean("com.claimsforce.segment.ENABLE_APPSFLYER_INTEGRATION", false);
        Boolean debug = bundle.getBoolean("com.claimsforce.segment.DEBUG", false);
        return new FlutterSegmentOptions(writeKey, trackApplicationLifecycleEvents, trackAttributionInformation, isAmplitudeIntegrationEnabled, isAppsFlyerIntegrationEnabled, debug);
    }

    static FlutterSegmentOptions create(HashMap<String, Object> options) {
        String writeKey = (String) options.get("writeKey");
        Boolean trackApplicationLifecycleEvents = (Boolean) options.get("trackApplicationLifecycleEvents");
        Boolean trackAttributionInformation = (Boolean) options.get("trackAttributionInformation");
        Boolean isAmplitudeIntegrationEnabled = orFalse((Boolean) options.get("amplitudeIntegrationEnabled"));
        Boolean isAppsFlyerIntegrationEnabled = orFalse((Boolean) options.get("appsFlyerIntegrationEnabled"));
        Boolean debug = orFalse((Boolean) options.get("debug"));
        return new FlutterSegmentOptions(writeKey, trackApplicationLifecycleEvents, trackAttributionInformation, isAmplitudeIntegrationEnabled, isAppsFlyerIntegrationEnabled, debug);
    }

    private static Boolean orFalse(Boolean value) {
        return value == null ? false : value;
    }
}