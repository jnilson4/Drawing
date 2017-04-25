package drawing.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
		this.setSize(new Dimension(800, 600));
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
