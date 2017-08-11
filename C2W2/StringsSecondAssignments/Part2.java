
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    
    int howMany(String stringa, String stringb){
        
        int index = 0;
        int count = 0;
        
        while(true){
            
            index = stringb.indexOf(stringa, index);
            
            if(index == -1)break;
            
            count ++;
            
            index += stringa.length();
            
        }
        
        
        return count;
    }
    
    
    void testHowMany(){
        
        System.out.println("3: " + howMany("GAA", "ATGAACGAATTGAATC"));
        
        System.out.println("2: " + howMany("AA", "ATAAAA") );
    }

}











