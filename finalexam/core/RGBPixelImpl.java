package exams.spring2017.solution.finalexam.core;

import exams.spring2017.solution.finalexam.interfaces.Color;
import exams.spring2017.solution.finalexam.interfaces.Pixel;
import exams.spring2017.solution.finalexam.interfaces.RGBColor;


public class RGBPixelImpl implements Pixel{
    
    public RGBColor rgb;


    public RGBPixelImpl(RGBColor rgb) {
        this.rgb =new RGBColorImpl(rgb.getRed(), rgb.getGreen(),rgb.getBlue());

        
    }
    public RGBPixelImpl(RGBPixelImpl cp) {
        this.setColor(cp.getColor());
    }
    
       
    public String toString(){
        return String.format("(%s)",rgb);
    }

    @Override
    public Color getColor() {
        return rgb;
    }

    @Override
    public void setColor(Color color) {
       if (color instanceof RGBColor)
        rgb = (RGBColor)color;
    }

    @Override
    public int compareTo(Pixel pixel) {
        return this.getColor().compareTo(pixel.getColor());
    }
    
}
