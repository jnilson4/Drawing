package drawing.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import drawing.controller.DrawingController;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	private JButton rectangleButton, circleButton, ellipsesButton, trianglesButton, polygonsButton, saveButton, resetButton;
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		rectangleButton = new JButton("Draw Rectangles");
		circleButton = new JButton("Draw Circles");
		ellipsesButton = new JButton("Draw Ellipses");
		trianglesButton = new JButton("Draw Triangles");
		polygonsButton = new JButton("Draw Polygons");
		saveButton = new JButton("Save Drawing");
		resetButton = new JButton("Reset");
		shapePanel = new ShapePanel(baseController);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(800, 600));
		
		this.add(shapePanel);
		this.add(rectangleButton);
		this.add(circleButton);
		this.add(trianglesButton);
		this.add(polygonsButton);
		this.add(ellipsesButton);
		this.add(saveButton);
		this.add(resetButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 175, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rectangleButton, 40, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rectangleButton, 15, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, circleButton, 20, SpringLayout.SOUTH, rectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, circleButton, 0, SpringLayout.WEST, rectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, trianglesButton, 20, SpringLayout.SOUTH, circleButton);
		baseLayout.putConstraint(SpringLayout.WEST, trianglesButton, 0, SpringLayout.WEST, circleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, ellipsesButton, 20, SpringLayout.SOUTH, polygonsButton);
		baseLayout.putConstraint(SpringLayout.WEST, ellipsesButton, 0, SpringLayout.WEST, polygonsButton);
		baseLayout.putConstraint(SpringLayout.NORTH, polygonsButton, 20, SpringLayout.SOUTH, trianglesButton);
		baseLayout.putConstraint(SpringLayout.WEST, polygonsButton, 0, SpringLayout.WEST, trianglesButton);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, ellipsesButton);
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, 20, SpringLayout.SOUTH, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 0, SpringLayout.WEST, saveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 220, SpringLayout.SOUTH, ellipsesButton);
	}
	
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
		});
		
		trianglesButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangles();
			}
		});
		
		circleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircles();
			}
		});
		
		polygonsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygons();
			}
		});
		
		ellipsesButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipses();
			}
		});
	
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.reset();
			}
		});
	
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.savePanel();
			}
		});
	}
}
