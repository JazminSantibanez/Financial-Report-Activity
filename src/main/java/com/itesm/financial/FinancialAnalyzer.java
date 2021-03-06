package com.itesm.financial;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FinancialAnalyzer implements AnalyzerInterface{

    public List<Ride> analyze(String filename) throws Exception{
        List<Ride> result = new ArrayList<>();

        BufferedReader reader = readData(filename);

        for (String rawLine; (rawLine = reader.readLine()) != null;) {
            List<String> line = CSVUtils.parseLine(rawLine);
            Ride newRide = RidesParser.parseFromList(line);
            if(newRide != null) {
                result.add(newRide);
            }
        }

        return result;
    }

    private BufferedReader readData(String filename){
        InputStream inputStream = Client.class.getClassLoader().getResourceAsStream(filename);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        return reader;
    }
    
}
