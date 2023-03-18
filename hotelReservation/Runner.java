package com.hotelReservation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.text.ParseException;
public class Runner {
    static Scanner scanner = new Scanner(System.in);
    static HotelManage hotelObj = new HotelManage();


    public static void main(String[] args) throws ParseException {

        System.out.println("Welcome to Hotel Reservation System");

        Runner application = new Runner();
        application.provideUserOption();
        findBestRatedHotel();
    }

    private static void findBestRatedHotel() {
    }

    public void provideUserOption() throws ParseException {
        while (true) {
            System.out.println("Choose Options " +
                    "\n1. Add Hotel" +
                    "\n2. Find Cheapest Hotel ");
            String userOption = scanner.next();
            switch (userOption) {
                case "1":
                    addHotel();
                    break;
                case "2":
                    hotelObj.findCheapestHotel(0);
                case "10":
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

    public void findCheapestHotel() throws ParseException {

        System.out.println("Enter check-In Date : (dd/mm/yyyy)");
        String checkInDate = scanner.next();
        System.out.println("Enter check-Out Date : (dd/mm/yyyy)");
        String checkOutDate = scanner.next();

        String Day1 = HotelManage.findDayOfWeek(checkInDate);
        String Day2 = HotelManage.findDayOfWeek(checkOutDate);

        int days = HotelManage.findDateDifference(checkInDate, checkOutDate);
        System.out.println("Number of days stying in hotel " + days);
        hotelObj.cheapestHotel = HotelManage.findCheapestHotel(days);
        HotelReservation cheapestHotel = null;
        float totalRate;
        totalRate = cheapestHotel.getRatings() * days;

        ArrayList<HotelReservation> bestRatedList = new ArrayList<>();
        for (HotelReservation hotel : HotelManage.hotelList) {
            if (hotel.getRatings() >= 4) {
                bestRatedList.add(hotel);
            }
        }

        ArrayList<HotelReservation> bestRated = new ArrayList<>();
            for (HotelReservation hotel : HotelManage.hotelList) {
                if (hotel.getRatings() >= 4) {
                    bestRatedList.add(hotel);
                }
            }
            System.out.println("You can choose any 1 of this Best rated hotels having cheapest cost: \n");
            bestRatedList.stream();
            bestRatedList.sort(Comparator.comparing(HotelReservation::getRates));
            bestRatedList.forEach((HotelReservation h) -> System.out.println("Hotel " + h.getHotelName() + ", with Rating = " + h.getRatings() + ", is available at $ = " + (h.getRates() * days)));
        }
    }




