package com.hotelReservation;

import java.util.Scanner;
import java.text.ParseException;
public class Runner{
    static Scanner scanner = new Scanner(System.in);
    HotelManage hotelObj = new HotelManage();


    public static void main (String[] args) throws ParseException {

        System.out.println("Welcome to Hotel Reservation System");

        Runner application = new Runner();
        application.provideUserOption();
        AddRatings();
    }

    public void provideUserOption() throws ParseException {
        while(true) {
            System.out.println("Choose Options " +
                    "\n1. Add Hotel" +
                    "\n2. Find Cheapest Hotel " );
            String userOption = scanner.next();
            switch (userOption) {
                case "1" :
                    addHotel();
                    break;
                case "2":
                    findCheapestHotel();
                case "10" :
                    System.exit(0);
            }
        }
    }

    public void addHotel() {
        HotelReservation hotel = new HotelReservation();
        System.out.println("Enter Hotel Name");
        String name = scanner.next();
        System.out.println("Enter weekday rate ");
        float rate = scanner.nextFloat();
        System.out.println("Enter weekend rate");
        float weekendRate = scanner.nextFloat();
        hotel.setHotelName(hotel.getHotelName());
        hotel.setRates(hotel.getRates());
        hotel.setWeekendRate(hotel.getWeekendRate());
        hotelObj.hotelList.add(hotel);
        System.out.println(hotelObj.hotelList);
    }
    public static void AddRatings(){
        System.out.println("Enter the ratings");
        int ratings = scanner.nextInt();
        if(ratings==3){
            System.out.println("Lakewood");
        } else if (ratings==4) {
            System.out.println("Bridgewood");
        } else if (ratings==5) {
            System.out.println("Ridgewood");
        }
    }

    public void findCheapestHotel() throws ParseException {
        System.out.println("Enter check-In Date : (dd/mm/yyyy)");
        String checkInDate = scanner.next();
        System.out.println("Enter check-Out Date : (dd/mm/yyyy)");
        String checkOutDate = scanner.next();

        String Day1 = HotelManage.findDayOfWeek(checkInDate);
        String Day2 = HotelManage.findDayOfWeek(checkOutDate);

        int days = HotelManage.findDateDifference(checkInDate, checkOutDate);
        System.out.println("Number of days stying in hotel " + days);

        HotelReservation cheapestHotel = HotelManage.findCheapestHotel(days);
        float totalRate = cheapestHotel.getRates() * days;

        HotelReservation cheapestHote2 = HotelManage.findCheapestHotel(days);
        float totalWeekendRate = cheapestHotel.getWeekendRate() * 2;

        if (Day1.equalsIgnoreCase("Saturday") | Day1.equalsIgnoreCase("Sunday") | Day2.equalsIgnoreCase("Saturday") | Day2.equalsIgnoreCase("Sunday")) {
            System.out.println("Best hotel availble on weekend  " + cheapestHotel.getHotelName() + " having rate $" + totalWeekendRate);
        } else {
            System.out.println("Cheapest hotel is " + cheapestHotel.getHotelName() + " having rate $" + totalRate);
        }
    }
}

