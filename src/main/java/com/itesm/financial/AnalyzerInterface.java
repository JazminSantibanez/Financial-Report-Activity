package com.itesm.financial;

import java.util.List;

/*
    Interface Segregation

    This interface allows to separate the methods of 
    analyze and readData in the class FinancialAnalyzer.
    readData isnt available for the class Client but analyze is available.
    
*/

public interface AnalyzerInterface {
    public List<Ride> analyze(String filename) throws Exception;
}