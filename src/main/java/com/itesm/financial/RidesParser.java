package com.itesm.financial;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RidesParser {

  static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

  public static Ride parseFromList(List<String> line) {

    Ride newRide = null;

    //Se utiliza el patron de builder para crear el objeto Ride
    RideBuilder builder = RideBuilder.getBuilder();
    try {
      long taxiId = Long.parseLong(line.get(0));
      Date pickUpTime = new SimpleDateFormat(DATE_FORMAT).parse(line.get(1));
      Date dropOffTime = new SimpleDateFormat(DATE_FORMAT).parse(line.get(2));
      int passengerCount = Integer.parseInt(line.get(3));
      double tripDistance = Double.parseDouble(line.get(4));
      double totalAmount = Double.parseDouble(line.get(5));
      
      //Method chaining
      newRide = builder
                .withTaxiId(taxiId)
                .withPickUpTime(pickUpTime)
                .withDropOffTime(dropOffTime)
                .withPassengerCount(passengerCount)
                .withTripDistance(tripDistance)
                .withTollsAmount(totalAmount)
                .build();


      /* Antigua implementacion del constructor de ride
      newRide =
          new Ride(
              taxiId,
              pickUpTime,
              dropOffTime,
              passengerCount,
              tripDistance,
              totalAmount);
      */
    } catch (Exception e) { }

    return newRide;
  }

}
