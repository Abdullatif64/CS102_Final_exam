package exams.spring2017.solution.finalexam.core;

import exams.spring2017.solution.finalexam.interfaces.Color;
import exams.spring2017.solution.finalexam.interfaces.GrayColor;
import exams.spring2017.solution.finalexam.interfaces.Pixel;



public class GrayPixelImpl implements Pixel{
    
    private GrayColor color;
    
    public GrayPixelImpl(Color color){
        super();
        setColor(color);
    }
    
    
    public Color getColor() {
        return new GrayColorImpl(color);
    }

    public void setColor(Color color) {
        if (color instanceof GrayColor)
            this.color = (GrayColor)color;
    }
    
    public String toString(){
        return "";
    }

    

    @Override
    public int compareTo(Pixel pixel) {
        return this.getColor().compareTo(pixel.getColor());
    }
    
    
}
