package com.tjmothy.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class XBLModel
{
    private final String URL = "http://www.xboxleaders.com/api/profile/";
    private final String EXT = ".json";
    private String gamerTag = "";

    public XBLModel(String gamerTagIn)
    {
        this.gamerTag = gamerTagIn;
    }

    public String getJSON()
    {
        StringBuilder builderJSON = new StringBuilder();
        StringBuilder builderText = new StringBuilder();
        JSONObject data;
        try
        {
            URL url = new URL(URL + gamerTag + EXT);
            System.out.println("URL: " + url);
            URLConnection connection = url.openConnection();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null)
            {
                builderJSON.append(line);
            }
            JSONObject mainJSON = new JSONObject(builderJSON.toString());
            //Check if there's an error
            try
            {
                data = mainJSON.getJSONObject("Data");    
            }
            catch(JSONException je)
            {
                JSONObject error = mainJSON.getJSONObject("error");
                System.out.println("XBLModel.data " + je);
                return error.getInt("code") + ": " + error.getString("message");
            }
            
            builderText.append("\n Tier: " + data.get("Tier"));
            builderText.append("\n Gamertag: " + data.get("Gamertag"));
            builderText.append("\n GamerScore: " + data.get("GamerScore"));
            builderText.append("\n Reputation: " + data.get("Reputation"));
            builderText.append("\n Name: " + data.get("Name"));
            builderText.append("\n Motto: " + data.get("Motto"));
            builderText.append("\n Location: " + data.get("Location"));
            builderText.append("\n Bio: " + data.get("Bio"));            
        }
        catch (Exception e)
        {
            System.out.println("XBLModel.getJSON() " + e);
        }

        return builderText.toString();
    }
}
