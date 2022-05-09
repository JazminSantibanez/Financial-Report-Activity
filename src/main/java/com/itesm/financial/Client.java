package com.itesm.financial;
import java.util.List;

import com.itesm.financial.report.PrintReport;
import com.itesm.financial.report.WebReport;

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
        

        //Imprime el reporte en web
        WebReport webReport = new WebReport();
        String htmlReport = webReport.createContent(result);

        //Imprime el reporte en texto
        PrintReport textReport = new PrintReport();
        String txtReport = textReport.createContent(result); 

        // System.out.println(htmlReport);
        webReport.createFile(htmlReport);
        textReport.createFile(txtReport);
    }
}
