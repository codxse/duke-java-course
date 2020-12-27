
/**
 * Write a description of Assigement1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Assigement1 {
    public String countryInfo(CSVParser parser, String searchQuery) {
        String strReturn = "NOT FOUND";
        for (CSVRecord record : parser) {           
            String country = record.get("Country");
            if (country.contains(searchQuery)) {
                String export = record.get("Exports");
                String dollars = record.get("Value (dollars)");
                strReturn = country + ": " + export + ": " + dollars;
                break;
            }
        }
        return strReturn;
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //System.out.println(countryInfo(parser, "Germany"));
        System.out.println(countryInfo(parser, "Nauru"));
    }
    
    public void listExportersTwoProducts
    (CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem1) && export.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    void testListExportersTwoProducts() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "gold", "diamonds");
        //listExportersTwoProducts(parser, "fish", "nuts");
        listExportersTwoProducts(parser, "cotton", "flowers");
    }
    
    int numberOfExporters(CSVParser parser, String exportItem) {
        int nCountryHasExportItem = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                nCountryHasExportItem++;
            }
        }
        return nCountryHasExportItem++;
    }
    
    void testNumberOfExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //int exporters = numberOfExporters(parser, "gold");
        //System.out.println("Number countries that export gold: " + exporters);
        int exporters2 = numberOfExporters(parser, "cocoa");
        System.out.println("Number countries that export sugar: " + exporters2);
    }
    
    void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + " " + value);
            }
        }
    }
    
    void testBigExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //bigExporters(parser, "$999,999,999");
        //System.out.println("\n");
        bigExporters(parser, "$999,999,999,999");
    }
}
