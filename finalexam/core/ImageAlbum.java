package exams.spring2017.solution.finalexam.core;

import exams.spring2017.solution.finalexam.interfaces.GrayColor;
import exams.spring2017.solution.finalexam.interfaces.GrayImage;
import exams.spring2017.solution.finalexam.interfaces.Image;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ImageAlbum<I extends Image>  {
  private  Map<String,Image> imageMap;
   
   
    private ImageAlbum() {
      imageMap=  new TreeMap<String,Image>();
    }
    
    
   private static  ImageAlbum instance =null;
    
   public static ImageAlbum getInstance(){
        if (instance==null)
            instance = new ImageAlbum();
            return instance;
    }
   
    public void add(I image){
    imageMap.put(image.getName(), image);
    
    }
    public void remove(I image){
    imageMap.remove(image.getName());
    
    }
    public int size(){
    return imageMap.size();
     }

    @Override
    public String toString() {
        Set<String> a= imageMap.keySet();
        Iterator<String> it=a.iterator();
        while (it.hasNext()){
            String tem=it.next();
            return tem;}
        
        return null;
    }

    public Map<String, Image> getImageMap() {
        return imageMap;
    }

    public void setImageMap(Map<String, Image> imageMap) {
        this.imageMap = imageMap;
    }
    
     public void imageInfo(ImageAlbum<Image> album){
          Set<String> a= album.getImageMap().keySet();
        Iterator<String> it=a.iterator();
        while (it.hasNext()){
        String tem=it.next();
            System.out.printf("%s (%d, %d)",
                    tem,album.getImageMap().get(tem).getHeight(),album.getImageMap().get(tem).getWidth());
         }
      }
     public void displayImage(Image image){
         int value;
           if (image instanceof GrayImage){
               System.out.printf("name:%s ,size: (%d,%d) ",image.getName(),image.getHeight(),image.getWidth());
               for (int i = 0; i <image.getHeight() ; i++) {
                   for (int j = 0; j <image.getWidth(); j++) {
                      value= ((GrayColor)image.getImg()[i][j].getColor()).getColor() ;
                       System.out.printf("%d    ",value);
                   }
                   
               }

        }
    }

    public boolean isBlackAndWhite(I image) {
        boolean c;
        if (image instanceof GrayImage) {
            GrayImage imag = (GrayImage) image;

            for (int i = 0; i < imag.getHeight(); i++) {
                for (int j = 0; j < imag.getWidth(); j++) {
                    if (((GrayColor) imag.getImg()[i][j].getColor()).getColor() == 255
                            || ((GrayColor) imag.getImg()[i][j].getColor()).getColor() == 0) {
                        return true;
                     }
                    else
                       return false;
                      
                    
                }
            }
           
        }
    return false;
    
    }
    public Set<I> getBlackAndWhite(ImageAlbum<Image> album){
        boolean x;
        Set<I>  bwi= new TreeSet<I>();
         Set<String> a= album.getImageMap().keySet();
        Iterator<String> it=a.iterator();
        while (it.hasNext()){
             String tem=it.next();
            x= album.isBlackAndWhite(album.getImageMap().get(tem));
            if(x)
                bwi.add(album.getImageMap().get(tem));
        }
        return bwi;
     }
    
    
    public boolean MatchPattern(GrayImage subimage, GrayImage image , double similarity_index) {
        int tempi, tempj,f=0,k=0;
        int correct = 0;
        boolean s=false;
        int subCount=0;
        int subSize = subimage.getHeight()*subimage.getWidth();
        for (int i = 0; i <= image.getHeight() - subimage.getHeight(); i++) {
            for (int j = 0; j <= image.getWidth() - subimage.getWidth(); j++) {
                if ((int) ((GrayColor) subimage.getImg()[0][0].getColor()).getColor() == (int) ((GrayColor) image.getImg()[i][j].getColor()).getColor()) {
                    tempi = i;
                    for (f = 0; f < subimage.getHeight(); f++) {
                        tempj = j;
                        for (k = 0; k < subimage.getWidth(); k++) {
                          if ((int) ((GrayColor) subimage.getImg()[f][k].getColor()).getColor() == (int) ((GrayColor) image.getImg()[tempi][tempj].getColor()).getColor()){
                              correct++;
                              
                          }
                           tempj++;
                        }
                       tempi++;
                    }
                    f=0;
                    k=0;
                }
                if (correct/subSize <= similarity_index){
                    s=true;
                }
               correct=0;
            }
        }
        return s;
    }
    
    

           
   
    
}
