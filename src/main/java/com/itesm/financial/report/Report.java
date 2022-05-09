package com.itesm.financial.report;

import java.io.IOException;
import java.util.List;
import com.itesm.financial.Ride;

public abstract class Report {

    /* Open Close 
        When abstracting the report class, it is easier to implement a new type of report that manages a different print type.
    */
    
    public abstract String createContent(List<Ride> rides);
    public abstract void createFile(String content) throws IOException;
}
