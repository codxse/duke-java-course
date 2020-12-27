
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String dna2 = dna.toLowerCase();
        String start = startCodon.toLowerCase();
        String stop = stopCodon.toLowerCase();
        
        int indexOfATG = dna2.indexOf(start);
        if (indexOfATG == -1) return "";
        int indexOfTAA = dna2.indexOf(stop);
        if (indexOfTAA == -1) return "";
        String substring = dna2.substring(indexOfATG, indexOfTAA + 3);
        return (substring.length() % 3 == 0) ? substring : "";
    }
    
    void testSimpleGene() {
        String dna1 = "XATG123123a12313sjjjTAA";
        System.out.println("DNA1: " + findSimpleGene(dna1, "ATG", "TAA"));
        String dna2 = "dadadadadasddsadTAAsdad";
        System.out.println("DNA2: " + findSimpleGene(dna2, "ATG", "TAA"));
        String dna3 = "dadaATGadasdsad223131";
        System.out.println("DNA3: " + findSimpleGene(dna3, "ATG", "TAA"));
        String dna4 = "";
        System.out.println("DNA4: " + findSimpleGene(dna4, "ATG", "TAA"));
        String dna5 = "SATGDSAGTAXYZAJKTAAERR";
        System.out.println("DNA5: " + findSimpleGene(dna5, "ATG", "TAA"));
    }
}
