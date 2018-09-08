package com.example.alvin.weatherlaunchpad;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RetrieveWeather {

    public String actualTemp;

    private static String weatherText = "http://api.openweathermap.org/data/2.5/weather?q=Houston,us&APPID=4138afa2839bc7e0c5eeeb34f42eeeb7";

    public String getWeatherText(){
        HttpURLConnection con; //maybe set as null
        InputStream stream; //maybe set as null

        try {
            con = (HttpURLConnection) (new URL(weatherText).openConnection());
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            StringBuffer buffer = new StringBuffer();
            stream = con.getInputStream();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(stream));

            String line = null;
            while((line = bufferedreader.readLine()) != null ){
                buffer.append(line + "\r\n");
            }
            stream.close();
            con.disconnect();
            //System.out.println(buffer.toString());
            return buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getTemp() {
        RetrieveWeather retrieve = new RetrieveWeather();
        String temperature = "";
        String text = retrieve.getWeatherText();
        temperature = text.substring(text.indexOf("temp")+6,text.indexOf("temp")+9);
        int temp = Integer.parseInt(temperature);
        temp = temp - 273;
        actualTemp = Integer.toString(temp);
        //System.out.println(actualTemp);
        return actualTemp;
    }
    public static void main(String[]args){
        RetrieveWeather rw = new RetrieveWeather();
        String printerout = rw.getTemp();
        System.out.println(printerout);
    }
}

