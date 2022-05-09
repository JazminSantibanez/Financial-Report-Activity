package com.itesm.financial;

import java.util.Date;

public class RideBuilder {


    private long taxiId;
    private Date pickUpTime;
    private Date dropOffTime;
    private int passengerCount;
    private double tripDistance;
    private double tollsAmount;
    Ride ride;

    /* Aplicando el patron builder para el constructor de Ride
      public Ride(
      long taxiId,
      Date pickUpTime,
      Date dropOffTime,
      int passengerCount,
      double tripDistance,
      double tollsAmount) {
            this.taxiId = taxiId;
            this.pickUpTime = pickUpTime;
            this.dropOffTime = dropOffTime;
            this.passengerCount = passengerCount;
            this.tripDistance = tripDistance;
            this.tollsAmount = tollsAmount;
        }

    */
    
    //class methods
    public static RideBuilder getBuilder(){
        return new RideBuilder();
    }

    // Instance methods
    public RideBuilder withTaxiId(long taxiId){
        this.taxiId = taxiId;
        return this;
    }

    public RideBuilder withPickUpTime(Date pickUpTime){
        this.pickUpTime = pickUpTime;
        return this;
    }

    public RideBuilder withDropOffTime(Date dropOffTime){
        this.dropOffTime = dropOffTime;
        return this;
    }

    public RideBuilder withPassengerCount(int passengerCount){
        this.passengerCount = passengerCount;
        return this;
    }

    public RideBuilder withTripDistance(double tripDistance){
        this.tripDistance = tripDistance;
        return this;
    }

    public RideBuilder withTollsAmount(double tollsAmount){
        this.tollsAmount = tollsAmount;
        return this;
    }

    public Ride build(){
        return new Ride(this.taxiId,
        this.pickUpTime, 
        this.dropOffTime, 
        this.passengerCount, 
        this.tripDistance, 
        this.tollsAmount );
    }
    
}
