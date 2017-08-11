

import edu.duke.FileResource;

import org.apache.commons.csv.*;

/**
 * Write a description of CsvProgram here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class CsvProgram {

    
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        
        for(CSVRecord record : parser ){
        
            String exports = record.get("Exports");
            
            //System.out.println(exports);
            
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                
                System.out.println(record.get("Country"));
                
            }
        
        } 
        
    }
    
    
    public void countryInfo(CSVParser parser, String country){
    
        for(CSVRecord record : parser ){
        
            if(record.get("Country").equals(country)){
            
                System.out.print(record.get("Country"));
                System.out.print(": " + record.get("Exports"));
                System.out.println(": " + record.get("Value (dollars)"));
            
            }
        
        }
    
    }
    
    public void tester(){
        
        FileResource fr = new FileResource("exports_small.csv");
        CSVParser parser = fr.getCSVParser();
        
        countryInfo(parser, "Germany");
        
        parser = fr.getCSVParser();
        
        listExportersTwoProducts(parser, "gold", "diamonds");
    }
    
    
}
