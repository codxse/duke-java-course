
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    boolean twoOccurrences(String stringa, String stringb) {
        int occurrence = Part3.countcountCharOccurrence(stringa, stringb);
        return occurrence > 1;
    }
    
    private static int _countCharOccurrence(String find, String sources, int count) {
        int indexOfCharOccurrence = sources.indexOf(find);
        if (indexOfCharOccurrence == -1) {
            return count;
        } else {
            String nextSources = sources.substring(indexOfCharOccurrence + find.length());
            return Part3._countCharOccurrence(find, nextSources, count + 1);
        }
    }
    
    static int countcountCharOccurrence(String find, String sources) {
        return Part3._countCharOccurrence(find, sources, 0);
    }
    
    void testing() {
        boolean res1 = twoOccurrences("by", "A story by Abby Long"); // true
        System.out.println(res1);
        boolean res2 = twoOccurrences("a", "banana"); // true
        System.out.println(res2);
        boolean res3 = twoOccurrences("atg", "ctgtahtgta"); // false
        System.out.println(res3);
        String lp1 = lastPart("zoo", "forest"); // zoo
        System.out.println(lp1);
        String lp2 = lastPart("an", "banana"); // ana
        System.out.println(lp2);
        String lp3 = lastPart("TAA", "AAATGCCCTAACTAGATTAAGAAACC");
        System.out.println(lp3);
    }
    
    String lastPart(String stringa, String stringb) {
        int indexOfLastPart = stringb.indexOf(stringa);
        if (indexOfLastPart == -1) {
            return stringa;
        }
        return stringb.substring(indexOfLastPart + stringa.length());
    }
}
