package com.itesm.financial;

import java.util.List;

/*
    Interface Segregation

    This interface allows to separate the methods of 
    analyze and readData in the class FinancialAnalyzer.
    
*/

public interface AnalyzerInterface {
    public List<Ride> analyze(String filename) throws Exception;
}