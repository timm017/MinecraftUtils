package com.tjmothy.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
        StringBuilder builder = new StringBuilder();
        try
        {
            URL url = new URL(URL + gamerTag + EXT);
            URLConnection connection = url.openConnection();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null)
            {
                builder.append(line);
            }
        }
        catch (Exception e)
        {
            System.out.println("XBLModel.getJSON() " + e);
        }

        return builder.toString();
    }
}
