/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiteboard;
import java.awt.Color;
import java.awt.geom.Line2D;
public class DLineModel extends DShapeModel{
        private Line2D line;
	public DLineModel(int x, int y, int width, int height, Color color, int id) {
		super(x, y, width, height, color, id);
		setLine(new Line2D.Double(x,y,width,height));
	}

    public void setLine(Line2D aDouble) {
        this.line = aDouble;
    }
    public Line2D getLine(){
        return line;
    }
    public void setX(int x){
        super.setX(x);
        line.setLine(x, getY(), getWidth(), getHeight());
    }
    public void setY(int y){
        super.setY(y);
        line.setLine(getX(), y, getWidth(), getHeight());
    }
     public void setWidth(int wid){
        super.setWidth(wid);
        line.setLine(getX(), getY(), wid, getHeight());
    }
    public void setHeight(int height){
        super.setHeight(height);
        line.setLine(getX(), getY(), getWidth(), height);
    }
    
    
    
    
    
}
