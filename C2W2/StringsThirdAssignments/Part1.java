
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.StorageResource;

import edu.duke.FileResource;

import java.util.*;

public class Part1 {

    
    void testRealDna(){

        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString().toUpperCase();    
        
        
        
        processGenes(getAllGenes(dna), 60);
        
    }
    
    
    void testProcessGenes(){
        StorageResource sr = new StorageResource();
        
        sr.add("1234567890");
        sr.add("1234567890123");
        sr.add("1234567");   
        sr.add("CGCGXXXXXX");
        
        processGenes(sr, 9);
    
    }
    
    
    void processGenes(StorageResource sr, int inputLen){
        
        //print all the Strings in sr that are longer than 9 characters
        System.out.println("OVER "+inputLen+" CHARS:");
        int gNine = 0;
        for(String s: sr.data()){
            if(s.length() > inputLen){
            
                //System.out.println(s);
                gNine++;
            
            }
        }
        

        //print the number of Strings in sr that are longer than 9 characters
        System.out.println("\nTOTAL OVER "+inputLen+" CHARS: " + gNine);
        
        //print the Strings in sr whose C-G-ratio is higher than 0.35
        System.out.println("\nC-G-ratio OVER 0.35:");
        int rCount = 0;
        int maxLen = 0;
        for(String s: sr.data()){
            
            if(s.length()> maxLen){
                maxLen = s.length();
            }
            
            double ratio = cgRatio(s);
            if(ratio > .35){
                //System.out.println(s);
                rCount++;
            }
            
        }
        
        //print the number of strings in sr whose C-G-ratio is higher than 0.35
        System.out.println("\nC-G-ratio OVER 0.35 COUNT: " + rCount);
        
        //print the length of the longest gene in sr
        System.out.println("\nMAX LENGTH: " + maxLen);
    }
    
    
    
    void testCgRatio(){
        
        System.out.println(".44444: " + cgRatio("ATGCCATAG"));
        
        
    }
    
    
    void testCountCTG(){
        
        System.out.println("4 " + countCTG("ATGCTGCTGCTGBBBCTGTAA"));
        
    }
    
    
    int countCTG(String dna){
        
        String line = dna;
        
        int count = 0;
        count += line.length() - line.replaceAll("CTG", "").length();
        
        return count/3;
    }
    
    
    double cgRatio(String dna){
        
        String line = dna;
        
        int count =0;
        count += line.length() - line.replace("C", "").length();
        count += line.length() - line.replace("G", "").length();
        
        return (0.0 + count)/dna.length();
        
        
    }
    
    
    
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
    
    
    List<String> getAllWithStop(int start, String dna, String end){
        

        
        List<String> list = new ArrayList<String>();
        
        int index = start;
        
        while(true){
            index = findStopCodon(dna, index, end);
            
            if(index == dna.length()) break;
            
            
            list.add(dna.substring(start, index+3));
            index++;
        }
        
        
        return list;
        
    }
    
    StorageResource getAllGenes(String dna){
        
        
        
        int start = dna.indexOf("ATG");
        if(start == -1){
            return new StorageResource();
        }
        
        StorageResource sr = new StorageResource();
        
        if(start == -1) return sr;
        

        
        for(String x: getAllWithStop(start, dna, "TAA")){
            sr.add(x);
        }
        for(String x: getAllWithStop(start, dna, "TAG")){
            sr.add(x);
            
        }
        
        for(String x: getAllWithStop(start, dna, "TGA")){
            sr.add(x);
        }
        
        
        StorageResource next = getAllGenes(dna.substring(start + 1));
        for(String x: next.data()){
            sr.add(x);
        }
        
        
        return sr;

        
    }
    
    
    void testGetAllGenes(){
        
        StorageResource sr = getAllGenes("ffatgceetaatgatag".toUpperCase());
        
        
        for(String x: sr.data() ){
            
            System.out.println(x);
            
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
