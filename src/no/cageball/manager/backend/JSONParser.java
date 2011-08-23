package no.cageball.manager.backend;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class JSONParser {

    public static ArrayList<String> getCageBallEvents(Context context) {
        ArrayList<String> eventObjects = new ArrayList<String>();

        String filePath = "cageballevents.json";
        File file = new File(filePath);
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        JSONTokener jsonTokener;

        try {
            jsonTokener = new JSONTokener(convertStreamToString(context.getResources().getAssets().open(filePath)));
            try {
                JSONObject cageballeventsjson = new JSONObject(jsonTokener);


                JSONArray cageballeventsarray = cageballeventsjson.getJSONArray("cageballevents");

                int i = 0;

                while (i < cageballeventsarray.length()) {
                    JSONObject jsonStop = cageballeventsarray.getJSONObject(i);
                    eventObjects.add("Tid: " + jsonStop.getString("date") + " Sted: " + jsonStop.getString("place"));
                    i++;
                }



            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        context = null;

        return eventObjects;
    }

    public static ArrayList<String> getMyCageBallEvents(Context context) {
        ArrayList<String> eventObjects = new ArrayList<String>();

        String filePath = "myevents.json";
        File file = new File(filePath);
        FileInputStream fileInputStream;
        DataInputStream dataInputStream;
        JSONTokener jsonTokener;

        try {
            jsonTokener = new JSONTokener(convertStreamToString(context.getResources().getAssets().open(filePath)));
            try {
                JSONObject cageballeventsjson = new JSONObject(jsonTokener);


                JSONArray cageballeventsarray = cageballeventsjson.getJSONArray("cageballevents");

                int i = 0;

                while (i < cageballeventsarray.length()) {
                    JSONObject jsonStop = cageballeventsarray.getJSONObject(i);
                    eventObjects.add("Tid: " + jsonStop.getString("date") + " Sted: " + jsonStop.getString("place"));
                    i++;
                }



            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        context = null;

        return eventObjects;
    }

    public boolean createNewCageBallEvent(Date date) {
        return true;
    }


    private static String convertStreamToString(InputStream is) {
        /*
           * To convert the InputStream to String we use the BufferedReader.readLine()
           * method. We iterate until the BufferedReader return null which means
           * there's no more data to read. Each line will appended to a StringBuilder
           * and returned as String.
           */

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


}


