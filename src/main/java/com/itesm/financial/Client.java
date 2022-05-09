package com.itesm.financial;
import java.util.List;

import com.itesm.financial.report.Report;

public class Client {
    private static final String CSV_FILENAME = "taxi-data.csv";

    /*
        Dependency Inversion 

        Removed: public static FinancialAnalyzer analyzer = new FinancialAnalyzer();
        to avoid dependency of client over FinancialAnalyzer.
        Created the inference AnalyzerInterface and removed dependency with a 
        constructor in Client.
    */
    //
    public static AnalyzerInterface analyzer;

    public Client(AnalyzerInterface analyzer) {
        Client.analyzer = analyzer;
    }
    public static void main(String[] args) throws Exception {
        
        System.out.println("Financial Report Generation");

        /*  
            Lee archivo de datos y lo convierte a objeto Ride
            
            Single Responsability
            Se aplico Single Responsability para que la clase usuario no sea
            la que lee la informacion.
        */
        AnalyzerInterface analyzer = new FinancialAnalyzer(); //Polimorfismo
        List<Ride> result = analyzer.analyze(CSV_FILENAME);
        
        /*
            Creation of reports using Factory Method
        */
        WebReportCreator webReport = new WebReportCreator();
        Report report1 = webReport.createReport();
        String htmlReport = report1.createContent(result);

        PrintReportCreator textReport = new PrintReportCreator();
        Report report2 = textReport.createReport();
        String txtReport = report2.createContent(result);

        // System.out.println(htmlReport);
        report1.createFile(htmlReport);
        report2.createFile(txtReport);
    }
}
