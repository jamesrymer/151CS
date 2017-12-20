/*
 * CS 151 WHITEBOARD PROJECT
 * 
 * 
 */
package whiteboard;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WhiteBoard extends JFrame {
	Canvas canvas;
        final WhiteBoard frame = this;
	public static void main(String[] args) {
		WhiteBoard frame = new WhiteBoard();
		frame.setVisible(true);
	}
	public WhiteBoard() {
                super("WhiteBoard Application");
		canvas = new Canvas();
                this.setLayout(new GridLayout(1,2,10,3));
		this.setBounds(500, 500, 1000, 400);
		this.add(canvas).setLocation(500,80);
		JButton rect = new JButton("Rect");
		rect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				DRectModel rectModel = new DRectModel(30,30,50,50,Color.GRAY,0); //default size and color of rect 
				DRect dr = new DRect();
				dr.shapeModel = rectModel;
                                dr.shapeModel.setX(rand.nextInt(375)); //place in random location on canvas
                                dr.shapeModel.setY(rand.nextInt(375));
				canvas.addShape(dr);
			}
		});
		JButton oval = new JButton("Oval");
		oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				DOvalModel ovalModel = new DOvalModel(10,10,60,20,Color.GRAY,canvas.getCollection().size()+1);//default size and color of oval
				DOval dov = new DOval();
                                dov.setAll(ovalModel.getX(), ovalModel.getY(), ovalModel.getWidth(), ovalModel.getColor(), ovalModel.getID());
				canvas.addShape(dov);
                                dov.shapeModel = ovalModel;
                                dov.shapeModel.setX(rand.nextInt(390)); //place in random location on canvas
                                dov.shapeModel.setY(rand.nextInt(390));
				
			}
		});
		JButton line = new JButton("Line");
		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				DLineModel lineModel = new DLineModel(10,0,200,200,Color.GRAY,canvas.getCollection().size()+1);//default size and color of line
				DLine dl = new DLine();
                                dl.setAll(lineModel.getX(), lineModel.getY(), lineModel.getWidth(), lineModel.getHeight(), lineModel.getColor(), lineModel.getID());
				canvas.addShape(dl); // add to canvas
                                dl.shapeModel = lineModel;
                                dl.shapeModel.setX(rand.nextInt(390)); //place in random location on canvas
                                dl.shapeModel.setY(rand.nextInt(390));
				
			}
		});
                
                //text box for adding text 
                JComboBox textBox = new JComboBox();
                String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
                for(String fts: fonts)
                    textBox.addItem(fts);
                JTextField textField = new JTextField("WOW!");
                textField.setColumns(10); //provides a greater length for textfield
		JButton text = new JButton("Add Text"); 
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()){
                                    DTextModel textModel;
                                    textModel = new DTextModel(25,25,75,50, Color.LIGHT_GRAY,canvas.getCollection().size()+1);
                                    String text = "test";
                                    DText txt = new DText();
                                    txt.setAll(textModel.getX(), textModel.getY(), textModel.getWidth(),textModel.getHeight(), textModel.getColor(), textModel.getID());
                                    txt.setInput(textField.getText());
                                    txt.setColor(Color.LIGHT_GRAY);
                                    canvas.addShape(txt);
                                }
			}
		});
		JButton delete = new JButton("Delete Item");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.delete();
			}
		});
		JButton moveToFront = new JButton("Move To Front");
		moveToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.MoveToFront();
			}
		});
		JButton moveToBack = new JButton("Move To Back");
		moveToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.MoveToBack();
			}
		});
                
		//buttons for save/load and networking...
		JButton save = new JButton("Save");
		JButton open = new JButton("Open");
		JButton serverStart = new JButton("Server Start");
		JButton clientStart = new JButton("Client  Start");
                
                JButton setColorButton = new JButton("Color");
                Box colorBox = new Box(BoxLayout.X_AXIS);
                colorBox.add(setColorButton);

		setColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
                               if(canvas.getSelected() != null){
                                   canvas.changeColor(JColorChooser.showDialog(null, "Pick a color", getForeground()));
                               }
			/*	Color initialColor = Color.GRAY; 
				final JColorChooser chooser = new JColorChooser(initialColor);
				JColorChooser.createDialog(
					canvas, "Pick a color", true, chooser, 
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (canvas.getSelected() != null)
								canvas.getSelected().getDShapeModel().setColor(chooser.getColor());
						}
					}, 
                                        null).setVisible(true);
                        }               
		});
*/
                        }
                });
                
                
                
                
		JPanel mainPanel = new JPanel();
                mainPanel.add(rect);
                mainPanel.add(line);
                mainPanel.add(oval);
                mainPanel.add(colorBox);
               // content.add(setColorButton);
                mainPanel.add(textField);
                mainPanel.add(text);
                mainPanel.add(textBox);
                mainPanel.add(delete);
		mainPanel.add(moveToFront);
		mainPanel.add(moveToBack);
		//stuff for save and open
		mainPanel.add(save);
		mainPanel.add(open);
		//networking stuff
		mainPanel.add(serverStart);
		mainPanel.add(clientStart);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.save();
			}
		});
		
		mainPanel.add(open);
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.open();
			}
		});
		serverStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.serverStart();
			}
		});
		clientStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                canvas.clientStart();
                            } catch (IOException ex) {
                                Logger.getLogger(WhiteBoard.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(WhiteBoard.class.getName()).log(Level.SEVERE, null, ex);
                            }

			}
		});
		this.add(mainPanel);
                this.setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(false);
	};
}