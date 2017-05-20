package exams.spring2017.solution.finalexam.core;


import exams.spring2017.solution.finalexam.interfaces.Image;
import exams.spring2017.solution.finalexam.interfaces.GrayImage;
import exams.spring2017.solution.finalexam.interfaces.ImageFactory;
import exams.spring2017.solution.finalexam.interfaces.ImageProcessor;
import exams.spring2017.solution.finalexam.interfaces.RGBImage;
import java.util.ArrayList;
import java.util.List;

public class ImageTest {
    
    public static void main(String [] args){
        
        List<Image> images = new ArrayList<Image>();
        
        ImageAlbum <Image> album = ImageAlbum.getInstance();
        
        ImageProcessor <GrayImage> ipgray = new ImageProcessorImpl<GrayImage>();
        ImageProcessor <RGBImage> iprgb = new ImageProcessorImpl<RGBImage>();
        
        album.add(ipgray.imread("image01.pgm"));
        album.add(ipgray.imread("image02.pgm"));
        album.add(ipgray.imread("image05.pgm"));
        
        
        System.out.println(album);
        
        GrayImage gim01 = (GrayImage)album.getImagesMap().get("image01.pgm");
        GrayImage gim02 = (GrayImage)album.getImagesMap().get("image02.pgm");
        GrayImage gim03 = (GrayImage)album.getImagesMap().get("image05.pgm");
        
        System.out.println(ipgray.numberOfWhitePixels(gim02));
        
        ipgray.displayImage(gim02);
        ipgray.ConvertToBackAndWhite(gim02, 150);
        
        System.out.println("");
        ipgray.displayImage(gim02);
        //ipgray.imwrite(gim02, "test.pgm");
        
        System.out.println(ipgray.isBackAndWhite(gim01));
        System.out.println(ipgray.isBackAndWhite(gim02));
        //System.out.println(ipgray.isBackAndWhite(gim03));
        
        
      

    }
    
}



//images.add(imf.getImage("gray", 10, 5, "image02.pgm"));
        
        /*
            
            
            images.add(imf.getImage("rgb", 10, 10, "image03.pgm"));
            images.add(imf.getImage("rgb", 60, 40, "image04.pgm"));
            images.add(imf.getImage("gray",54, 87, "image05.pgm"));
            images.add(imf.getImage("gray",30, 98, "image06.pgm"));
        */
        
        
        
        
        /*for (Image im : images){
            im.randomize();
            if (im instanceof GrayImage)
                ipgray.imwrite(((GrayImage)im), im.getName());
            if (im instanceof RGBImage)
                iprgb.imwrite(((RGBImage)im), im.getName());
        }*/