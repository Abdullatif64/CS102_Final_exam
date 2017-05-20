
package exams.spring2017.solution.finalexam.core;

import exams.spring2017.solution.finalexam.interfaces.Color;
import exams.spring2017.solution.finalexam.interfaces.RGBColor;


public class RGBColorImpl implements RGBColor{
 
    public int Red;
    public int Green;
    public int Blue;

    public RGBColorImpl(int R, int G, int B) {
        this.Red = R;
        this.Green = G;
        this.Blue = B;
    }
    
    public int getRed() {
        return Red;
    }

    public void setRed(int R) {
        this.Red = R;
    }

    public int getGreen() {
        return Green;
    }

    public void setGreen(int G) {
        this.Green = G;
    }

    public int getBlue() {
        return Blue;
    }

    public void setBlue(int B) {
        this.Blue = B;
    }
    
    public String toString(){
        return String.format("(%d,%d,%d)",Red,Green,Blue);
    }

    @Override
    public int compareTo(Color color) {
        if (color instanceof RGBColor){
            RGBColor rgb = (RGBColor)color;
            return (this.getBlue()+this.getGreen()+this.getRed())-(rgb.getBlue()+rgb.getGreen()+rgb.getRed());
        }
        return -9999;
    }
}
