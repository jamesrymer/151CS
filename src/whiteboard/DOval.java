/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiteboard;
import java.awt.Color;
import java.awt.Graphics;
public class DOval extends DShape{
	public DOval(){
		super();
	}
	public void draw(Graphics g) {
        g.setColor(shapeModel.getColor());
        boolean heightNeg = false;
        boolean widthNeg = false;
        
        
        int tempWidth = 0;
        int tempHeight = 0;
        if(getWidth()<0){
            setWidth(Math.abs(getWidth()));
            tempWidth = getWidth();
            widthNeg = true;
        }
        if(getHeight()<0){
            setHeight(Math.abs(getHeight()));
            tempHeight = getHeight();
            heightNeg = true;
        }
        g.fillOval(shapeModel.getX(),shapeModel.getY(),shapeModel.getWidth(),shapeModel.getHeight());
        if(heightNeg)
            setHeight(getHeight()*(-1));
        if(widthNeg)
            setHeight(getWidth()*(-1));
        
        }

    void setAll(int x, int y, int width, Color color, int id) {
        setX(x);
        setY(y);
        setWidth(width);
        setColor(color);
        setID(id);
    }
}
