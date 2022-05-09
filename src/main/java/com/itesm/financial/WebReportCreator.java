package com.itesm.financial;

import com.itesm.financial.report.Report;
import com.itesm.financial.report.WebReport;

public class WebReportCreator extends ReportCreator {

    @Override
    public Report createReport() {
        return new WebReport();
    }
    
}
