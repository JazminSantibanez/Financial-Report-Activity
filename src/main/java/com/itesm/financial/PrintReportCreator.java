package com.itesm.financial;

import com.itesm.financial.report.PrintReport;
import com.itesm.financial.report.Report;

public class PrintReportCreator extends ReportCreator {

    @Override
    public Report createReport() {
        return new PrintReport();
    }
    
}
