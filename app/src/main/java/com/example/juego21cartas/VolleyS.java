package com.example.juego21cartas;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {
    private static VolleyS myVolley = null;
    private RequestQueue requestQueue;

    private VolleyS (Context context){
        requestQueue=Volley.newRequestQueue(context);
    }
    public static VolleyS getInstance(Context context){
        if(myVolley==null)
            myVolley=new VolleyS(context);
        return myVolley;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
