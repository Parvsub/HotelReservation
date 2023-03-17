package com.hotelReservation;
public class HotelReservation {
    private String hotelName;
    private int rates;

    public HotelReservation(String hotelName, int rates) {
        this.hotelName = hotelName;
        this.rates = rates;
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


