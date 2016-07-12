package com.chaqianma.borrow;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by zhangxd on 2016/7/6.
 * 获取Metadata 里面 channel
 */
public class Channel extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("getChannel".equals(action)) {
            callbackContext.success(getChannel());
        } else {
            return false;
        }
        return true;
        //return super.execute(action, args, callbackContext);
    }

    private String getChannel() {
        String TAG = "Example Meta-Data";
        String channel = "";
        try {
            ApplicationInfo ai = cordova.getActivity().getPackageManager().getApplicationInfo(cordova.getActivity().getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            channel = bundle.getString("InstallChannel");
            System.out.println("InstallChannel : " + channel);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Not Found Channel: " + e.getMessage());
        } catch (NullPointerException e) {
            Log.e(TAG, "NullPointer: " + e.getMessage());
        } finally {
            return channel;
        }
    }
}
