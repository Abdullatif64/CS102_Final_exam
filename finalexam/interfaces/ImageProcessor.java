package exams.spring2017.solution.finalexam.interfaces;

import exams.spring2017.solution.finalexam.core.ImageAlbum;
import java.util.Set;

public interface ImageProcessor <I extends Image>{

    public void imwrite(I image, String fileName);
    public int numberOfWhitePixels(I image);
     public Image imread(String filename);
     //public Set<I>  getBlackAndWhiteImages(ImageAlbum<I> album);

     public boolean  isBackAndWhite(I image);
     //public void  imageInfo(ImageAlbum <Image> album);
     public boolean  ConvertToBackAndWhite(I image, int threshold);
     public void  displayImage(Image image);
}
