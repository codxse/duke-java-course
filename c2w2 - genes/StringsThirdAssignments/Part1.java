import java.util.ArrayList; 
import edu.duke.*;

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
        System.out.println(countGenes(mutan));
    }
    
    void printAllGenes2(String dna) {
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) +
                         currentGene.length();
        }
        System.out.println(countGenes(dna));
    }
    
    
    int countGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            count++;
            startIndex = dna.indexOf(currentGene, startIndex) +
                         currentGene.length();
        }
        return count;
    }
    
    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           System.out.println("index " + index);
           String found = input.substring(index+1, index+3);
           System.out.println(found);
           index = input.indexOf("abc",index+4);
           System.out.println("index after updating " + index);
       }
    }
    
    public void test() {
        //no code yet
        // findAbc("abcd");
        // abc dkf jsk sio ehg jfh sdj fhk sdf huw abc abc ajf ieo wj
        findAbc("abcabcabcabca");
        System.out.println("====================\n");
    }

    StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while (true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
        }
        return geneList;
    }
    
    float cgRatio (String dna){
        int firstOccurC = dna.indexOf("C");
        int firstOccurG = dna.indexOf("G");
        int countC = 0;
        int countG = 0;
        if (firstOccurC > -1) {
            countC = countC+1;
            while (dna.indexOf("C", firstOccurC) != -1 && firstOccurC !=-1){
                countC = countC + 1;
                firstOccurC = dna.indexOf("C", firstOccurC + 1);
            }
            countC = countC - 1;
        }
        else {
            countC = 0;
        }
        if (firstOccurG > -1) {
            countG = countG+1;
            while (dna.indexOf("G", firstOccurG) != -1 && firstOccurG !=-1){
                countG = countG + 1;
                firstOccurG = dna.indexOf("G", firstOccurG + 1);
            }
            countG = countG - 1;
        }
        else {
            countG = 0;
        }
        //System.out.println(countC +" y "+ countG);
        float Finalresult = (float)countC / countG;
        return Finalresult;
    }
    
    void processGenes(StorageResource sr){
        int count = 0;
        int counting = 0;
        int gene = 0;
        int longer60 = 0;
        int cgRatioMore035 = 0;
        
        for (String g : sr.data()) {
            gene++;
            if (g.length() > 60) {
                longer60++;
            }
            if (cgRatio(g) > 0.35) {
                cgRatioMore035++;
            }
        }
        System.out.println("GENE " + gene);
        System.out.println("LONGER60 " + longer60);
        System.out.println(">0.35 " + cgRatioMore035);
        
        System.out.println("Printing genes with +9 charas:");
        for (String gene9 : sr.data()){
            if (gene9.length() > 9){
                System.out.println(gene9);
            }
        }
        for (String plus9 : sr.data()){
          if (plus9.length() > 9){
              count = count +1;
            }
        }
        System.out.println("Printing number of strings above: " + count);
        for (String cgRat : sr.data()){
           cgRatio(cgRat);
           if (cgRatio(cgRat) > 0.35)
           System.out.println("Gene with C-G ratio higher than 0.35 = " + cgRat + " and the ratio is: "+ cgRatio(cgRat));
        }
        for (String longest : sr.data()){
            if (longest.length() > counting){
                counting = longest.length();
            }
        }
        System.out.println("Length of the longest gene= " + counting);
        
    }
    
    void testSR() {
        FileResource fr = new FileResource("brca1line.fa");
        URLResource ur = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        String Newdna = fr.asString();
        String dna2 = ur.asString();
        StorageResource sr = new StorageResource();
        StorageResource sr2 = new StorageResource();
        sr.add(Newdna);
        sr2.add(dna2);
        // processGenes(sr);
        System.out.println("========");
        processGenes(sr2);
        System.out.println("Genes: " + getAllGenes(Newdna).size());
        int genes = 0;
        for(String s : sr.data()){
            System.out.println("this is my list of genes: " + s);
            genes += countGenes(s);
        }
        System.out.println("N Genes: " + genes);
        
    }
}
