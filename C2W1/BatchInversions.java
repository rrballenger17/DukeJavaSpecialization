
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class BatchInversions {
    //I started with the image I wanted (inImage)
    public ImageResource makeInverse(ImageResource inImage) {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's red + inPixel's blue + inPixel's green
            //divide that sum by 3 (call it average)
           // int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            //set pixel's red to average
            pixel.setRed(255 - inPixel.getRed() );
            //set pixel's green to average
            pixel.setGreen(255 - inPixel.getGreen());
            //set pixel's blue to average
            pixel.setBlue(255 - inPixel.getBlue());
        }
        //outImage is your answer
        return outImage;
    }

    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            
            ImageResource inv = makeInverse(inImage);

            inv.setFileName("inverse-" + inImage.getFileName());
            
            
            inv.save();
            
            
            inv.draw();
        }
    }

    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeInverse(ir);
        gray.draw();
    }
}
