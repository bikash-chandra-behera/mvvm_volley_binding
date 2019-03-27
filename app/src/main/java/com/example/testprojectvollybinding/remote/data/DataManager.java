package com.example.testprojectvollybinding.remote.data;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.testprojectvollybinding.MainActivity;
import com.example.testprojectvollybinding.remote.APICALL;
import com.example.testprojectvollybinding.remote.VolleySingleton;

import org.json.JSONObject;

public class DataManager {
    private Context context;

    public DataManager(Context context1) {
        this.context = context1;
    }
    public void setVolleyRequest(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(JsonObjectRequest.Method.GET,APICALL.BASEURL, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                    showData(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("er1",error.toString());
            }
        }
        );
        VolleySingleton.getInstance(context).addRequestQueue(jsonObjectRequest);
    }
    void showData(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
