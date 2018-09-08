package com.example.alvin.weatherlaunchpad;

import java.util.Scanner;

public class tester {

    public static void main(String[]args){
        String tester = "{\"coord\":{\"lon\":-95.37,\"lat\":29.76},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":302.83,\"pressure\":1013,\"humidity\":70,\"temp_min\":302.15,\"temp_max\":303.75},\"visibility\":14484,\"wind\":{\"speed\":2.77,\"deg\":204.003},\"clouds\":{\"all\":1},\"dt\":1536366900,\"sys\":{\"type\":1,\"id\":2646,\"message\":0.0076,\"country\":\"US\",\"sunrise\":1536408148,\"sunset\":1536453314},\"id\":4699066,\"name\":\"Houston\",\"cod\":200}";
        Scanner scanner = new Scanner(tester);
        System.out.println(tester.indexOf("temp"));
        String temp = tester.substring(tester.indexOf("temp")+6,tester.indexOf("temp")+12);
        System.out.println(temp);
    }
}
