package com.itesm.financial;

import com.itesm.financial.report.Report;

/*
    Abstract "creator"
    Implementation of Factory Method pattern.
*/
public abstract class ReportCreator {

    public Report getReport(){
        Report rpt = createReport();
        return rpt;
    }

    public abstract Report createReport();
    
}
