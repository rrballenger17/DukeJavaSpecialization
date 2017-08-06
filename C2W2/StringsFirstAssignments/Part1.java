
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    
    
    
    public String findSimpleGene(String dna){
        
        
        Integer start = dna.indexOf("ATG");
        
        Integer end = dna.indexOf("TAA");
        
        
        if(start == -1 || end == -1 ){
            return "";
        }
        
        if((end - start) % 3 == 0){
            return dna.substring(start, end + 3);
        }
        
        return "";
        
    }
    
    
    void printSelfAndGene(String strand){
        
        System.out.println(strand);
        System.out.println(findSimpleGene(strand)); 
        
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
