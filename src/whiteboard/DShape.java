package whiteboard;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
public class DShape implements ModelListener {
	DShapeModel shapeModel;
	public DShape() {
		shapeModel = new DShapeModel(0, 0, 0, 0, Color.gray,0);
	}
	public void draw(Graphics g) {
		g.setColor(shapeModel.getColor());
		g.drawRect(shapeModel.getX(), shapeModel.getY(), shapeModel.getWidth(), shapeModel.getHeight());
	}
	public void setColor(Color color) {
		shapeModel.setColor(color);
	}
	public void setX(int x) {
		shapeModel.setX(x);
	}
	public void setY(int y) {
		shapeModel.setY(y);
	}
	public void setWidth(int width) {
		shapeModel.setWidth(width);
	}
	public void setHeight(int height) {
		shapeModel.setHeight(height);
	}
	public Color getColor() {
		return shapeModel.getColor();
	}
	public int getX() {
		return (int) shapeModel.getX();
	}
	public int getY() {
		return (int) shapeModel.getY();
	}
	public int getWidth() {
		return  (int) shapeModel.getWidth();
	}
	public int getHeight() {
		return  (int) shapeModel.getHeight();
	}
	public DShapeModel getDShapeModel() {
		return shapeModel;
	}
        public void setID(int id){
            shapeModel.setID(id);
        }
        public void setAll(int x, int y, int width, int height, Color c, int ID){
            setX(x);
            setY(y);
            setWidth(width);
            setHeight(height);
            setColor(c);
            setID(ID);
        }
	public ArrayList<Rectangle> getKnobs() {
		ArrayList<Rectangle> knobs = new ArrayList<Rectangle>();
		knobs.add(new Rectangle(getX()-9,getY()-9,20,20)); //Top Left
		knobs.add(new Rectangle(getX()-9,getY()+getHeight()-9,20,20)); //Bottom Left
		knobs.add(new Rectangle(getX()+getWidth()-9,getY()-9,20,20)); //Top Right
		knobs.add(new Rectangle(getX()+getWidth()-9,getY()+getHeight()-9,20,20)); //Bottom Right
		return knobs;
	}
        public ArrayList<Rectangle> getLineKnobs(){
            ArrayList<Rectangle> knobs = new ArrayList<Rectangle>();
            knobs.add(new Rectangle(getX()-9, getY()-9, 18, 18));
            knobs.add(new Rectangle(getWidth()-9, getHeight()-9, 18, 18));
            return knobs;
        }
        
	@Override
	public void ModelChanged(DShapeModel model) {
		this.shapeModel = model;
		
	}

    public int getID() {
        return shapeModel.getID();
    }
}
