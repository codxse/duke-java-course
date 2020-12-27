import java.util.ArrayList; 

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    int findStopCodon(String dna, int startIndex, String stopCodon) {
       // This method returns the index of the
       // first occurrence of stopCodon that appears
       // past startIndex and is a multiple of 3 away from startIndex.
       // If there is no such stopCodon,
       // this method returns the length of the dna strand.
       int stopIndex = dna.indexOf(stopCodon, startIndex);
       int _start = dna.indexOf("ATG", startIndex);
       
       while (stopIndex > 0) {
           int diff = stopIndex - _start;
           if (diff % 3 == 0) {
               return stopIndex;
           }
           stopIndex = dna.indexOf(stopCodon, stopIndex + 1);
       }
       return -1; 
    }
    
    void testFindStopCodon() {
        // 0 - 18 // TAA
        String dna1 = "ATGTAGCTTAAACCTTTTTAA";
        int stopIndex1 = findStopCodon(dna1, 0, "TAA");
        System.out.println("stopIndex1 " + stopIndex1);
        
        // 3 - 18 // TAG
        String dna2 = "AAAATGTTAGCCATAGTGTAGGAAAGTTTGACTAAGCT";
        int stopIndex2 = findStopCodon(dna2, 0, "TAG");
        System.out.println("stopIndex2 " + stopIndex2);
        
        // 2 - 8 // TGA 
        String dna3 = "GCATGGTGTGAAGGAGTCGACACAC";
        int stopIndex3 = findStopCodon(dna3, 0, "TGA");
        System.out.println("stopIndex3 " + stopIndex3);
        
        // none LENGTH 4
        String dna4 = "JUNK";
        int stopIndex4 = findStopCodon(dna4, 0, "TGA");
        System.out.println("stopIndex4 " + stopIndex4);
            
        // none LENGTH 0
        String dna5 = "";
        int stopIndex5 = findStopCodon(dna5, 0, "TAA");
        System.out.println("stopIndex5 " + stopIndex5);
        
        // none LENGTH 14
        String dna6 = "SSSATGSSTAASSA";
        int stopIndex6 = findStopCodon(dna6, 0, "TAA");
        System.out.println("stopIndex6 " + stopIndex6);
        
        System.out.println("================================\n");
    }
    
    String findGene(String dna, int where) {
        // Find the index of the first occurrence of the start codon “ATG”.
        // If there is no “ATG”, return the empty string.
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) return "";
        
        // Find the index of the first occurrence of the stop codon “TAA”
        // after the first occurrence of “ATG” that is a multiple of three
        // away from the “ATG”. Hint: call findStopCodon.
        int TAAIndex = findStopCodon(dna, startIndex, "TAA");
        
        // Find the index of the first occurrence of the stop codon “TAG”
        // after the first occurrence of “ATG”
        // that is a multiple of three away from the “ATG”.
        int TAGIndex = findStopCodon(dna, startIndex, "TAG");
        
        // Find the index of the first occurrence of the stop codon “TGA”
        // after the first occurrence of “ATG” that is a multiple of three
        // away from the “ATG”. 
        int TGAIndex = findStopCodon(dna, startIndex, "TGA");

        // Return the gene formed from the “ATG”
        // and the closest stop codon that is a multiple of three away.
        // If there is no valid stop codon and therefore no gene,
        // return the empty string.
        
        int minIndex = 0;
        if (TAAIndex == -1 ||
            (TGAIndex != -1 && TGAIndex < TAAIndex)) {
                minIndex = TGAIndex;
        } else {
            minIndex = TAAIndex;
        }
        if (minIndex == -1 ||
            (TAGIndex != -1 && TAGIndex < minIndex)) {
                minIndex = TAGIndex;
        }
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    
    void testFindGene() {
        String dna1 = "ATGTAGCTTAAACCTTTTTAA";
        System.out.println(dna1);
        String dna2 = "AAAATGTTAGCCATAGTGTAGGAAAGTTTGACTAAGCT";
        System.out.println(dna2);
        String dna3 = "GCATGGTGTGAAGGAGTCGACACAC";
        System.out.println(dna3);
        String dna6 = "SSSATGSSTAASSA";
        System.out.println(dna6);
        
        System.out.println("================================\n");
    }
    
    void printAllGenes() {
        String dna1 = "ATGTAGCTTAAACCTTTTTAA";
        String dna2 = "AAAATGTTAGCCATAGTGTAGGAAAGTTTGACTAAGCT";
        String dna3 = "GCATGGTGTGAAGGAGTCGACACAC";
        String dna6 = "SSSATGSSTAASSA";
        String mutan = dna1 + dna6 + dna2 + dna3;
        
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(mutan, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            startIndex = mutan.indexOf(currentGene, startIndex) +
                         currentGene.length();
        }
    }
}
