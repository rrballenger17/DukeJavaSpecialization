
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.URLResource;

public class Part4 {

    
    void findLinks(){
        URLResource res = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        
        for(String word: res.words()){
            
            if(word.toLowerCase().indexOf("youtube.com") != -1 ){
                
                String wordLower = word.toLowerCase();
                
                String sub = wordLower.substring(0, wordLower.indexOf("youtube.com"));
                
                int one = sub.lastIndexOf("\"");
                
                int two = wordLower.toLowerCase().indexOf("\"", wordLower.indexOf("youtube.com") + 1);
                
                System.out.println(word.substring(one + 1, two));
                
                
            }
            
            
        }
        
        
        
    }
    
}
