package exams.spring2017.solution.finalexam.core;

import exams.spring2017.solution.finalexam.core.*;
import exams.spring2017.solution.finalexam.interfaces.Color;
import exams.spring2017.solution.finalexam.interfaces.GrayColor;

public class GrayColorImpl implements GrayColor{
    
    private int color;
    
    public GrayColorImpl(int color){
        super();
        setColor(color);
    }
    
    public GrayColorImpl(GrayColor gp){
        this(gp.getColor());
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    public String toString(){
        return String.format("%d",color);
    }

    @Override
    public int compareTo(Color color) {
        if (color instanceof GrayColor){
            GrayColor gray = (GrayColor)color;
            return (this.getColor()-gray.getColor());
        }
        return -9999;        
    }
}
