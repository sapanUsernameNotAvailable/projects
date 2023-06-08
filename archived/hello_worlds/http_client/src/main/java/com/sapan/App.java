package com.sapan;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println(WebServiceCaller.getIt("http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139"));
    }
}
