package com.hotelReservation;
public class HotelReservation implements Comparable<HotelReservation> {
    private String hotelName;
    private int rates;
    private float weekendRate;

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    private int ratings;

    public HotelReservation(String hotelName, int rates, float weekendRate, int ratings) {
        this.hotelName = hotelName;
        this.rates = rates;
        this.weekendRate = weekendRate;
        this.ratings = ratings;
    }

    public float getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(float weekendRate) {
        this.weekendRate = weekendRate;
    }


    public HotelReservation() {

    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRates() {
        return rates;
    }


    public void setRates(int rates) {
        this.rates = rates;
    }

    public int compareTo(HotelReservation h) {
        return (this.rates - h.rates);
    }


    @Override
    public String toString() {
        return "HotelReservation{" +
                "hotelName='" + hotelName + '\'' +
                ", rates=" + rates +
                '}';
    }
}


