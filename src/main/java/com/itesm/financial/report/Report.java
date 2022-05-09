package com.itesm.financial.report;

import java.util.List;
import com.itesm.financial.Ride;

public abstract class Report {
    
    public abstract String createContent(List<Ride> rides);
}
