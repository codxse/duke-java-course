import edu.duke.*;
import java.io.File;
import java.util.regex.*;  

/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {

    String getResources() {
        URLResource fr = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        return fr.asString();
    }
    
    void getYoutube() {
        String resources = getResources();
        String rgx = "(https?://www.(youtube|YouTube|).com.*?)\"";
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(resources);
        
        while (matcher.find()) {
            System.out.println(matcher.group(1)); 
        }
    }
}
