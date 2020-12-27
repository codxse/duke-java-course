
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    String gene = "ATG ATG TAG CTT A ATG ACC TTT TTA A";
    
    int howMany(String a, String b) {
        int n = 0;
        int startIndex = 0;
        while (true) {
            int index = b.indexOf(a, startIndex);
            System.out.println("IDX " + index);
            // System.out.println("IDX2 " + startIndex);
            if (index == -1) {
                break;
            } else {
                n += 1;
                startIndex = index + a.length();
            }
        }
        return n;
    }
    
    void test() {
        System.out.println(howMany("ATG", gene));
    }
}
