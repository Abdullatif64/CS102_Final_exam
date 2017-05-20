package exams.spring2017.solution.finalexam.core;

import exams.spring2017.solution.finalexam.interfaces.GrayImage;
import exams.spring2017.solution.finalexam.interfaces.Image;
import exams.spring2017.solution.finalexam.interfaces.ImageFactory;
import exams.spring2017.solution.finalexam.interfaces.ImageProcessor;
import exams.spring2017.solution.finalexam.interfaces.RGBImage;
import java.util.ArrayList;
import java.util.List;


public class ImageCreator {
    public static void main(String [] args){
        
        List<Image> images = new ArrayList<Image>();
        
        ImageFactory imf = ImageFactoryImpl.getInstance();
        
        ImageProcessor <GrayImage> ipgray = new ImageProcessorImpl<GrayImage>();
        ImageProcessor <RGBImage> iprgb = new ImageProcessorImpl<RGBImage>();
        
        images.add(imf.getImage("gray", 100, 200, "image01.pgm"));
        images.add(imf.getImage("gray", 10, 5, "image02.pgm"));
        images.add(imf.getImage("rgb", 10, 10, "image03.pgm"));
        images.add(imf.getImage("rgb", 60, 40, "image04.pgm"));
        images.add(imf.getImage("gray",54, 87, "image05.pgm"));
        images.add(imf.getImage("gray",30, 98, "image06.pgm"));


        for (Image im : images){
            im.randomize();
            if (im instanceof GrayImage)
                ipgray.imwrite(((GrayImage)im), im.getName());
            if (im instanceof RGBImage)
                iprgb.imwrite(((RGBImage)im), im.getName());
        }
        
        
    }

}
