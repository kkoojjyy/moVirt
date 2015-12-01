package org.ovirt.mobile.movirt.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;
import org.ovirt.mobile.movirt.MoVirtApp;

/**
 * Created by suomiy on 11/13/15.
 */
@EBean(scope = EBean.Scope.Singleton)
public class SharedPreferencesHelper {
    @App
    MoVirtApp app;

    private SharedPreferences sharedPreferences;

    public static final String KEY_PERIODIC_SYNC = "periodic_sync";
    public static final String KEY_PERIODIC_SYNC_INTERVAL = "periodic_sync_interval";
    public static final String KEY_MAX_EVENTS = "max_events_stored";
    public static final String KEY_MAX_VMS = "max_vms_polled";
    public static final String DEFAULT_PERIODIC_SYNC_INTERVAL = "60";
    public static final String DEFAULT_MAX_EVENTS = "500";
    public static final String DEFAULT_MAX_VMS = "500";

    private static final String KEY_CONNECTION_NOTIFICATION = "connection_notification";
    private static final boolean DEFAULT_CONNECTION_NOTIFICATION = true;
    private static final String KEY_POLL_EVENTS = "poll_events";
    private static final boolean DEFAULT_POLL_EVENTS = true;


    @AfterInject
    void initialize() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(app);
    }

    public int getSyncIntervalInMinutes() {
        return Integer.parseInt(sharedPreferences
                .getString(KEY_PERIODIC_SYNC_INTERVAL, DEFAULT_PERIODIC_SYNC_INTERVAL));
    }

    public int getMaxEvents() {
        return Integer.parseInt(sharedPreferences.getString(KEY_MAX_EVENTS, DEFAULT_MAX_EVENTS));
    }

    public int getMaxVms() {
        return Integer.parseInt(sharedPreferences.getString(KEY_MAX_VMS, DEFAULT_MAX_VMS));
    }

    public boolean isPollEventsEnabled() {
        return sharedPreferences.getBoolean(KEY_POLL_EVENTS, DEFAULT_POLL_EVENTS);
    }

    public boolean isConnectionNotificationEnabled() {
        return sharedPreferences
                .getBoolean(KEY_CONNECTION_NOTIFICATION, DEFAULT_CONNECTION_NOTIFICATION);
    }
}