package drawing.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import drawing.controller.DrawingController;

public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private DrawingPanel appPanel;
	private ShapePanel shapePanel;
	
	public DrawingFrame(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		this.appPanel = new DrawingPanel(baseController);
		this.shapePanel = new ShapePanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("DRAWING");
		this.setSize(new Dimension(600, 600));
		this.setVisible(true);
	}
}
