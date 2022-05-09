package com.itesm.financial.report;

import java.io.IOException;
import java.util.List;
import com.itesm.financial.Ride;

public abstract class Report {
    
    public abstract String createContent(List<Ride> rides);
    public abstract void createFile(String content) throws IOException;
}
