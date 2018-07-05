package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import bots.BotAndy;

public class Display extends JComponent {

	private static final long serialVersionUID = 7880302203922105415L;

	private Map map;
	
	private int height;
	private int width;
	private int windowHeight;
	private int windowWidth;
	private int i, x, y, xstart, ystart;
	private int yHeight;
	private int xWidth;

	private ArrayList <Integer> widthList;
	private ArrayList <Integer> heightList;
	
	private int extraWidth;
	private int extraHeight;
	
	public Display(Map map) {
		this.map = map;
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    repaint();
                    try {Thread.sleep(10);} catch (Exception ex) {}
                }
            }
        });
        animationThread.start();
	}
	
	public void paintComponent(Graphics gg) {
		super.paintComponent(gg);
		
		Color DARKGREY = new Color(64, 64, 64);
		
		height = map.getHeight();
		width = map.getWidth();
		windowHeight = this.getHeight();
		windowWidth = this.getWidth();
		yHeight = windowHeight/height;
		xWidth = windowWidth/width;

		widthList = new ArrayList <Integer> ();
		heightList = new ArrayList <Integer> ();
		
		extraWidth = windowWidth - (xWidth * width);
		extraHeight = windowHeight - (yHeight * height);
		
		if(extraWidth < 0)
			extraWidth = width - 1;
		
		if(extraHeight < 0)
			extraHeight = height - 1;
		
		widthList.add(0);
		heightList.add(0);
		
		int num1 = 0;
		
		for(i = 0; i <= width; i++) {
			if(extraWidth > 0)
				num1 = num1 + 1;
			widthList.add(num1);
			
			if(extraWidth > 0)
				extraWidth--;
		}
		
		num1 = 0;
		
		for(i = 0; i < height; i++) {
			if(extraHeight > 0)
				num1 = num1 + 1;
			heightList.add(num1);
			
			if(extraHeight > 0)
				extraHeight--;
		}
		
		
        for(y = 0; y < height; y++) {
        	for(x = 0; x < width; x++) {
        		
        		if(map.getBlocks()[x][y] instanceof Wall)
        			gg.setColor(Color.BLACK);
        		else if(map.getBlocks()[x][y] instanceof Character)
        			gg.setColor(map.getBlocks()[x][y].getColor());
        		else if(map.getBlocks()[x][y] instanceof BotAndy)
        			gg.setColor(map.getBlocks()[x][y].getColor());
        		else if(map.getBlocks()[x][y] instanceof Treasure)
        			gg.setColor(map.getBlocks()[x][y].getColor());
        		else
        			gg.setColor(Color.WHITE);
        		
        		gg.fillRect( (x * xWidth) + widthList.get(x), (y * yHeight) + heightList.get(y), xWidth + widthList.get(x + 1), yHeight + heightList.get(y + 1));
        	}
        }
        
        //This is where the vertical lines are printed.
        gg.setColor(DARKGREY);
        for(i = 0; i <= width; i++) {
            xstart = (i * xWidth) + widthList.get(i);
            gg.drawLine(xstart, 0, xstart, windowHeight);	//x1, y1, x2, y2
        }
        
        //This is where the horizontal lines are printed.
        gg.setColor(DARKGREY);
        for(i = 0; i <= height; i++) {
            ystart = (i * yHeight) + heightList.get(i);
            gg.drawLine(0, ystart, windowWidth, ystart);		
        }

	}
	
	public void setMap(Map map) {
		this.map = map;
	}
    
    public int[] getCoordinates(int x, int y) {
    	int[] coordinates = new int[2];
    	coordinates[0] = x / xWidth;
    	coordinates[1] = y / yHeight;
    	return coordinates;
    }

}
