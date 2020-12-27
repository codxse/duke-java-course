
/**
 * Write a description of Assigement2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Assigement2 {

    CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;
        for (CSVRecord record : parser) {
            largestSoFar = getLargestOfTwo(record, largestSoFar);
        }
        
        return largestSoFar;
    }
    
    void testHottestInFile() {
        FileResource fr = new FileResource();
        CSVRecord largestTemperatrureRow = hottestHourInFile(fr.getCSVParser());
        System.out.println("Hottest temp was " + largestTemperatrureRow.get("TemperatureF") 
            + " at " + largestTemperatrureRow.get("DateUTC"));
    }
    
    CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for (CSVRecord record : parser) {
            coldestSoFar = getColdestOfTwo(record, coldestSoFar);
        }
        return coldestSoFar;
    }
    
    void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temp was " + coldest.get("TemperatureF") 
            + " at " + coldest.get("DateUTC"));
    }
    
    CSVRecord hottestInManyDays() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord largestSoFar = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord current = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(current, largestSoFar);
        }
        
        return largestSoFar;
    }
    
    void testHottestInManyDays() {
        CSVRecord largestTemperatrureRow = hottestInManyDays();
        System.out.println("Hottest temp in many days was " + largestTemperatrureRow.get("TemperatureF") 
            + " at " + largestTemperatrureRow.get("DateUTC"));
    }
    
    CSVRecord getLargestOfTwo(CSVRecord one, CSVRecord two) {
            if (two == null) {
                return one;
            } else {
                double oneTemperature = Double.parseDouble(one.get("TemperatureF"));
                double twoTemperature = Double.parseDouble(two.get("TemperatureF"));
                
                if (oneTemperature > twoTemperature) {
                    return one;
                }
                return two;
            }
    }
    
    CSVRecord getColdestOfTwo(CSVRecord one, CSVRecord two) {
        if (two == null) {
            return one;
        } else {
            double oneTemp = Double.parseDouble(one.get("TemperatureF"));
            double twoTemp = Double.parseDouble(two.get("TemperatureF"));
            
            if (oneTemp < -999) {
                return two;
            }
            
            if (twoTemp < -999) {
                return one;
            }
            
            if (oneTemp < twoTemp) {
                return one;
            }
            return two;
        }
    }
    
    String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        File _f = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            
            if (_f == null) {
                _f = f;
                coldestSoFar = coldestHourInFile(fr.getCSVParser());
            } else {
                CSVRecord current = coldestHourInFile(fr.getCSVParser());
                double currentColdest = Double.parseDouble(current.get("TemperatureF"));
                double coldestSoFarD = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                
                if (currentColdest < coldestSoFarD) {
                    _f = f;
                    coldestSoFar = current;
                }
            }
        }
        
        return _f.getName();
    }
    
    void testFileWithColdestTemperature() {
        String coldestFile = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coldestFile);
        
        FileResource fr = new FileResource(coldestFile);
        CSVRecord coldestRecord = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature on that day was " + coldestRecord.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        for (CSVRecord record : fr.getCSVParser()) {
            String date = record.get("DateUTC");
            String temp = record.get("TemperatureF");
            System.out.println(date + " " + temp);
        }
        
    }
    
    CSVRecord getLowestHumadityOfTwo(CSVRecord one, CSVRecord two) {
        CSVRecord temp = null;
                
        String humidity = one.get("Humidity");
        Double humidityD = null;
        if (humidity != "N/A") {
            humidityD = Double.parseDouble(humidity);
        }
        String current = two.get("Humidity");
        Double currentD = null;
        if (current != "N/A") {
            currentD = Double.parseDouble(current);
        }
        
        if (humidityD != null && currentD != null) {
            if (humidityD < currentD) {
                temp = one;
            } 
        }
        
        return temp;
    }
    
    CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord temp = null;
        for (CSVRecord record : parser) {
            if (temp == null) {
                temp = record;
            } else {
                String humidity = record.get("Humidity");
                Double humidityD = null;
                if (humidity != "N/A") {
                    humidityD = Double.parseDouble(humidity);
                }
                String current = temp.get("Humidity");
                Double currentD = null;
                if (current != "N/A") {
                    currentD = Double.parseDouble(current);
                }
                
                if (humidityD != null && currentD != null) {
                    if (humidityD < currentD) {
                        temp = record;
                    } 
                }
            }
        }
        return temp;
    }
    
    void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at "
            + csv.get("DateUTC"));
    }
    
    CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            if (lowestSoFar == null) {
                lowestSoFar = current;
            } else {
                lowestSoFar = getLowestHumadityOfTwo(current, lowestSoFar);
            }
        }
        
        return lowestSoFar;
    }
    
    
    void testLowestHumadityInManyFiles() {
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at "
            + csv.get("DateUTC"));
    }
    
    double averageTemperatureInFile(CSVParser parser) {
        int totalRows = 0;
        double sumTemperature = 0.0;
        for (CSVRecord record : parser) {
            String temp = record.get("TemperatureF");
            Double tempD = Double.parseDouble(temp);
            sumTemperature += tempD;
            totalRows++;
        }
        
        if (totalRows != 0) {
            return sumTemperature / totalRows;
        } else {
            return  0.0;
        }
    }
    
    void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + avg);
    }
    
    double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        int totalRows = 0;
        double sumTemperature = 0.0;
        for (CSVRecord record : parser) {
            String temp = record.get("TemperatureF");
            String humadity = record.get("Humidity");
            Double tempD = null;
            Double humadityD = null;
            // System.out.println("Humadity: " + humadity + ", " + "Temp " + temp);
            if (humadity != "N/A") {
                tempD = Double.parseDouble(temp);
                humadityD = Double.parseDouble(humadity);
                if (humadityD >= value) {
                    sumTemperature += tempD;
                    totalRows++;
                }
            } else {
                tempD = 0.0;
            }
        }
        
        if (totalRows != 0) {
            return sumTemperature / totalRows;
        } else {
            return 0.0;
        }
    }
    
    void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureWithHighHumidityInFile(parser, 80);
        if (avg > 0.0) {
            System.out.println("Average Temp when high Humidity is " + avg);
        } else {
            System.out.println("No temperatures with that humidity");
        }
    }
}
