package com.itesm.financial.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.itesm.financial.Ride;

public class PrintReport extends Report {

    @Override
    public String createContent(List<Ride> rides){
        //Formato de documento: titulo y headers
        StringBuilder builder = new StringBuilder();
        builder.append(createTitle("Taxi Report"));
        builder.append(createTableHeaders());

        rides.forEach( ride -> {
            builder.append(addRide(ride));
        });

        return builder.toString();
    }

    @Override
    public void createFile(String content) throws IOException {
        FileWriter fileWriter = new FileWriter("financial-report.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    private String  createTitle(String title){
        return title + "\n" ;
    }

    private String createTableHeaders() {
        return 
                "TaxiID \t\t" +
                "Pickup time \t\t" +
                "Dropoff time \t\t\t" +
                "Passenger count   " +
                "Trip Distance   " +
                "Total amount" +
                "\n" ;
    }
    
    private String addRide(Ride ride) {
        return 
                ride.getTaxiId() + "\t" +
                ride.getPickUpTime() + "\t" +
                ride.getDropOffTime() + "\t" +
                ride.getPassengerCount() + "\t\t  " +
                ride.getTripDistance() + "\t\t  " +
                formatAmount(ride.getTollsAmount()) +  
                "\n";
    }

    private String formatAmount(double amount) {
        if(amount < 0) {
            return "(" + amount + ")";
        }

        return Double.toString(amount);
    }

}
