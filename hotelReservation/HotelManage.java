package com.hotelReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HotelManage {
    private static Comparator<? super HotelReservation> minComparator;
    Scanner scanner = new Scanner(System.in);
    static List<HotelReservation> hotelList = new ArrayList<>();

    public static int findDateDifference(String startDate, String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(startDate);
        Date secondDate = sdf.parse(endDate);
        long differenceInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        int days = (int) TimeUnit.DAYS.convert(differenceInMillies, TimeUnit.MILLISECONDS);
        return days;
    }

    Comparator<HotelReservation> minCompare = new Comparator<HotelReservation>() {
        @Override
        public int compare(HotelReservation h1, HotelReservation h2) {
            return h1.compareTo(h2);
        }
    };
    public static HotelReservation findCheapestHotel(int numDays) {
        int lowestRate;
        Optional<HotelReservation> Hotel = hotelList.stream()
                .min(minComparator);
        return Hotel.get();
    }

}

