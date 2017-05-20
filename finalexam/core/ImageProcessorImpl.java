package exams.spring2017.solution.finalexam.core;

import exams.spring2017.solution.finalexam.interfaces.Color;
import exams.spring2017.solution.finalexam.interfaces.GrayColor;
import exams.spring2017.solution.finalexam.interfaces.RGBImage;
import exams.spring2017.solution.finalexam.interfaces.GrayImage;
import exams.spring2017.solution.finalexam.interfaces.Image;
import exams.spring2017.solution.finalexam.interfaces.ImageProcessor;
import exams.spring2017.solution.finalexam.interfaces.RGBColor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ImageProcessorImpl <I extends Image & Comparable<Image>> 
                                implements ImageProcessor<I>{

    
    
    public ImageProcessorImpl(){};
    
    /******* ADD CODE HERE ****/
    
    
    
    
    
    
    /***************************/
    
    public boolean  ConvertToBackAndWhite(I image, int threshold){
        if (image instanceof GrayImage){
            for (int i=0;i<image.getHeight();i++){
                for (int j=0;j<image.getWidth();j++){
                    int color = ((GrayColor)(image.getImg()[i][j].getColor())).getColor();
                    if ((color!=255) && (color!=0)){
                        //System.out.println(c);
                        if (color>threshold){
                               //System.out.println("set white");
                        //((GrayColor)(image.getImg()[i][j].getColor())).setColor((byte)255);
                        image.getImg()[i][j]=new GrayPixelImpl(new GrayColorImpl(255));
                        //System.out.println(image.getImg()[i][j].getColor());
                        }
                        else {
                            //System.out.println("set black");
                        //((GrayColor)(image.getImg()[i][j].getColor())).setColor((byte)0);
                        image.getImg()[i][j]=new GrayPixelImpl(new GrayColorImpl(0));
                        //System.out.println(image.getImg()[i][j].getColor());
                        }
                    }
                }
            }
            
            
        }else if (image instanceof RGBImage){
            return false;
        }
        return true;
    }
    
    @Override
    public void imwrite(I image, String filename) {
        if (image instanceof GrayImage){
            try {
            FileWriter fw = new FileWriter(new File(filename));
            fw.write("P2\n");
            fw.write("#Converted from MAP format\n");
            fw.write(String.format("%d %d\n", image.getWidth(), image.getHeight()));
            
            for (int i=0;i<image.getHeight();i++){
               for (int j=0;j<image.getWidth();j++){
                   Color c = image.getImg()[i][j].getColor();
                   GrayColor gc = (GrayColor)c;
                   fw.write(gc.getColor()+" ");
               }
               fw.write("\n");
            }
            fw.close();
            } catch (IOException ex) {
                System.out.println("Image IO Exception");
            }     
        } else if (image instanceof RGBImage){
            try {
            FileWriter fw = new FileWriter(new File(filename));
            fw.write("Color Image\n");
            fw.write(String.format("%d %d\n", image.getWidth(), image.getHeight()));
            
            for (int i=0;i<image.getHeight();i++){
               for (int j=0;j<image.getWidth();j++){

                   //System.out.println(image.getImg()[i][j].getColor());
                   int red = ((RGBColor)(image.getImg()[i][j].getColor())).getRed();
                   int green = ((RGBColor)(image.getImg()[i][j].getColor())).getGreen();
                   int blue = ((RGBColor)(image.getImg()[i][j].getColor())).getBlue();
                   fw.write(red+" "+green+" "+blue+"\n");
               }
               fw.write("\n");
            }
            fw.close();
            } catch (IOException ex) {
                System.out.println("Image IO Exception");
            }     
        }
        
    }

    @Override
    public int numberOfWhitePixels(I image) {
        int count =0;
        int c=-1;
        if (image instanceof GrayImage){
            for (int i=0;i<image.getHeight();i++){
               for (int j=0;j<image.getWidth();j++){
                   //System.out.println(image.getImg()[i][j].getColor());
                   //Color c = image.getImg()[i][j].getColor();
                   //GrayColor gc = (GrayColor)c;
                   int color =((GrayColor)(image.getImg()[i][j].getColor())).getColor();
                   if (color<0) 
                       c = -color +128;
                   else c  =color;
                   //System.out.println(c);
                   if (c==255){
                       count++;
                   }
               }
            }
        }else if (image instanceof RGBImage){
            for (int i=0;i<image.getHeight();i++){
               for (int j=0;j<image.getWidth();j++){
                   int red =((RGBColor)(image.getImg()[i][j].getColor())).getRed();
                   int green =((RGBColor)(image.getImg()[i][j].getColor())).getGreen();
                   int blue =((RGBColor)(image.getImg()[i][j].getColor())).getBlue();
                   //System.out.println(red);
                   if ((red==255) &&(green ==255) &&(blue==255)){
                       count++;
                   }
               }
            }
        }
        return count;
    }
    
    public Image imread(String filename){
        
        try {
            Scanner reader = new Scanner(new File(filename));
            String type = reader.nextLine();
            reader.nextLine();
            String size = reader.nextLine();
            int width = Integer.parseInt(size.split(" ")[0]);
            int height = Integer.parseInt(size.split(" ")[1]);
            //reader.nextLine();
            String name = filename;
            int i=0;
            Image image = new GrayImageImpl(width, height, name);
            //System.out.println("H: " + image.getImg().length);
            //System.out.println("W: " +image.getImg()[0].length);
            System.out.println(image);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String [] colors = line.split(" ");
                for (int j=0;j<colors.length;j++){
                    //System.out.println(image.getImg()[i][j]);
                    image.getImg()[i][j]=new GrayPixelImpl(new GrayColorImpl(Integer.parseInt(colors[j])));
                //System.out.printf("%d %d %s \n", i, j, image.getImg()[i][j].getColor());
                }
                i++;
                //System.out.println("H: " + image.getImg().length);
                //System.out.println("W: " +image.getImg()[0].length);
            }
            return image;
            
        } catch (FileNotFoundException ex) {
            System.out.println("Image file not found");
            return null;
        }        
    }
    
}
