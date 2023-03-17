package com.hotelReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    Scanner scanner = new Scanner(System.in);
    public  static void addHotelInformation() {
        ArrayList<HotelReservation> List = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hotel name");
        String HotelName = scanner.next();
        System.out.println("Enter Hotel rates");
        int HotelRates = scanner.nextInt();
        System.out.println("Enter the WeekendRate");
        float Weekendrates = scanner.nextFloat();

        HotelReservation hotelReservation = new HotelReservation(HotelName, HotelRates,Weekendrates);
        List.add(hotelReservation);
        System.out.println(List);
    }

    public static void main(String[] args) {
        addHotelInformation();
    }
}