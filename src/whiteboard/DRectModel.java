/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiteboard;
import java.awt.Color;
import java.awt.Rectangle;
public class DRectModel extends DShapeModel{
        private Rectangle rect;
	public DRectModel(int x, int y, int width, int height, Color color, int ID) {
		super(x, y, width, height, color, ID);
                setRect(new Rectangle(x,y,width,height));
	}

    private void setRect(Rectangle rectangle) {
      this.rect = rectangle;
    }
    public void setX(int x){
        super.setX(x);
        rect.setRect(x,getY(), getWidth(), getHeight());
    }
    public void setY(int y){
        super.setY(y);
        rect.setRect(getX(),y, getWidth(), getHeight());
    }
    public void setWidth(int wid){
        super.setWidth(wid);
        rect.setRect(getX(), getY(), wid, getHeight());
    }
    public void setHeight(int height){
        super.setHeight(height);
        rect.setRect(getX(), getY(), getWidth(), height);
    }
    
    
}
