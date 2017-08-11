
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

        
    public String findSimpleGene(String strand, String startCodon, String stopCodon){
        
        
        String dna = strand.toLowerCase();
        
        Integer start = dna.indexOf(startCodon.toLowerCase());
        
        Integer end = dna.indexOf(stopCodon.toLowerCase());
        
        
        if(start == -1 || end == -1 ){
            return "";
        }
        
        if((end - start) % stopCodon.length() == 0){
            return strand.substring(start, end + 3);
        }
        
        return "";
        
    }
    
    
    void printSelfAndGene(String strand){
        
        System.out.println(strand);
        System.out.println(findSimpleGene(strand, "ATG", "TAA")); 
        
    }
    
    
    void testSimpleGene(){
        // no "ATG"
        String a = "ADSFGGTAA";
        printSelfAndGene(a);
        
        // no "TAA"
        String b = "ATGSDGFS";
        printSelfAndGene(b);
        
        // no ATG or TAA
        String c = "SDLKFJKLSDFJ";
        printSelfAndGene(c);
        
        // DNA with substring multiple of 3
        String d = "EWYATGWERUIOTGHTAA";
        printSelfAndGene(d);
        
        // DNA with substring not multiple of 3
        String e = "EWYATGWETAA";
        printSelfAndGene(e);
        
    }
    
    // no ATG, return empty string
    
    // find TAA, if not return empty string
    
    
    // if length is multiple of 3, return gene string
    
    
    
    

}
