
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    
    // twoOccurrences
    
    boolean twoOccurrences(String stringa, String stringb){
        
        int index = stringb.indexOf(stringa);
        if(index == -1) return false;
        
        stringb = stringb.substring(index + stringa.length());
        
        index = stringb.indexOf(stringa);
        if(index == -1) return false;
                
        return true;
     
    }
    
    

    
    // lastPart
    String lastPart(String stringa, String stringb){
        
        int index = stringb.indexOf(stringa);
        if(index == -1) return stringb;
        
        return stringb.substring(index + stringa.length());
     
    }
    
    // testing
    void testing(){
        String x = "mississippi";
        String y = "iss";
        
        if(twoOccurrences(y, x)) System.out.println("twoOccurences worked");
        
        System.out.println(lastPart(y,x));
        
    }
    
    
}
