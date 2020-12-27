
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    String findSimpleGene(String dna) {
        int indexOfATG = dna.indexOf("ATG");
        if (indexOfATG == -1) return "";
        int indexOfTAA = dna.indexOf("TAA");
        if (indexOfTAA == -1) return "";
        String substring = dna.substring(indexOfATG, indexOfTAA + 3);
        return (substring.length() % 3 == 0) ? substring : "";
    }
    
    void testSimpleGene() {
        String dna1 = "XATG123123a12313sjjjTAA";
        System.out.println("DNA1: " + findSimpleGene(dna1));
        String dna2 = "dadadadadasddsadTAAsdad";
        System.out.println("DNA2: " + findSimpleGene(dna2));
        String dna3 = "dadaATGadasdsad223131";
        System.out.println("DNA3: " + findSimpleGene(dna3));
        String dna4 = "";
        System.out.println("DNA4: " + findSimpleGene(dna4));
        String dna5 = "SATGDSAGTAXYZAJKTAAERR";
        System.out.println("DNA5: " + findSimpleGene(dna5));
    }
}