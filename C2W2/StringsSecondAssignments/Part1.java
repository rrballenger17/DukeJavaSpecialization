
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    

    
    
    int findStopCodon(String dna, int startIndex, String stopCodon){
        
        int index = startIndex + 3;
        
        while(true){
            
            index = dna.indexOf(stopCodon, index);
            
            if(index == -1) break;
            
            if( (index - startIndex)%3 == 0 ){
                
                return index;
                
            }
            
            index++;
            
        }
        
        return dna.length();
        
    }
    
    
    String findGene(String dna){
        
        int start = dna.indexOf("ATG");
        
        if(start == -1) return "";
        
        
        int endTAA = findStopCodon(dna, start, "TAA");
        
        int endTAG = findStopCodon(dna, start, "TAG");
        
        int endTGA = findStopCodon(dna, start, "TGA");
        
        
        int min = endTAA;
        
        min = Math.min(min, endTAG);
        
        min = Math.min(min, endTGA);
        
        if(min == dna.length()) return "";
        
        
        return dna.substring(start, min + 3);
        
    }
    
    
    void printAllWithStop(int start, String dna, String end){
        

        
        int index = start;
        
        while(true){
            index = findStopCodon(dna, index, end);
            
            if(index == dna.length()) break;
            
            
            System.out.println(dna.substring(start, index+3));
            index++;
        }
        
        
        
        
    }
    
    void printAllGenes(String dna){
        
        int start = dna.indexOf("ATG");
        
        if(start == -1) return;
        
        
        printAllWithStop(start, dna, "TAA");
        printAllWithStop(start, dna, "TAG");
        printAllWithStop(start, dna, "TGA");

        
    }
    
    
    void testFindGene(){
        
        String gOne = "ATGBBBTAA";
        System.out.println(gOne);
        System.out.println(findGene(gOne));
        
        
        String gTwo = "ZZATGBBBCCCATAAUUTGATAGTAA";
        System.out.println("ATGBBBCCCATAAUUTGA");
        System.out.println(findGene(gTwo));

    }
    
    
    
    void testFindStopCodon(){
        
        String gOne = "ATGBBBTAA";
        
        System.out.println("6: " + findStopCodon(gOne,0, "TAA")); 
        
        
        String gTwo = "ATGBBTAAPTAA";
        
        System.out.println("9: " + findStopCodon(gTwo,0, "TAA")); 

    }
    
    
    
    void testPrintAllGenes(){
        
        String gOne = "ATGBBBTAACCCTAGOOOTGA";
        
        printAllGenes(gOne);

    }

}
