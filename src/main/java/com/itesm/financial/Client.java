package com.itesm.financial;
import java.util.List;

public class Client {
    private static final String CSV_FILENAME = "taxi-data.csv";
    public static FinancialAnalyzer analyzer = new FinancialAnalyzer();

    public static void main(String[] args) throws Exception {
        System.out.println("Financial Report Generation");

        /*  
            Lee archivo de datos y lo convierte a objeto Ride
            
            Se aplico Single Responsability para que la clase usuario no sea
            la que lee la informacion.
        */
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
