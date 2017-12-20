/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiteboard;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
public class DOvalModel extends DShapeModel {
        private Ellipse2D ellipse;
	public DOvalModel(int x, int y, int width, int height, Color color, int ID) {
		super(x, y, width, height, color, ID);
	}
        public Ellipse2D getOval(){
            return ellipse;
        }
        
        public void setX(int x){
            super.setX(x);
            ellipse.setFrame(x, getY(), getWidth(), getHeight());
        }
    public void setY(int y){
        super.setY(y);
        ellipse.setFrame(getX(), y, getWidth(), getHeight());
        }
     public void setWidth(int wid){
        super.setWidth(wid);
        ellipse.setFrame(getX(), getY(), wid, getHeight());
        }
    public void setHeight(int height){
        super.setHeight(height);
        ellipse.setFrame(getX(), getY(), getWidth(), height);
        }
}
