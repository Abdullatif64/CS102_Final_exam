package exams.spring2017.solution.finalexam.core;

import exams.spring2017.solution.finalexam.interfaces.Image;
import exams.spring2017.solution.finalexam.interfaces.ImageFactory;

public class ImageFactoryImpl implements ImageFactory{
    
    private ImageFactoryImpl(){};
    
    private static ImageFactory instance = null;
    
    public static ImageFactory getInstance(){
        if (instance == null)
            instance = new ImageFactoryImpl();
        return instance;
    }
    
    
    public Image getImage(String color, int w, int h, String n){
        
        if (color.equalsIgnoreCase("gray")){
            return new GrayImageImpl(w,h,n);
        }else if (color.equalsIgnoreCase("rgb")){
            return new RGBImageImpl(w,h,n);
        }
        return null;
    }
    
}
