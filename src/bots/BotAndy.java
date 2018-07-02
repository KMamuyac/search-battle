package bots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import game.Block;
import game.Character;
import game.Treasure;

public class BotAndy extends Character {

  private ArrayList<Point> treasures;
  private Boolean thinking = false;
  
  public BotAndy(Block[][] blocks, int x, int y) {
    super(blocks, x, y);
    treasures = new ArrayList<Point>();
  }
  
  @Override
  public void think() {
	  if(!thinking) {
		thinking = true;
	    if(treasures.isEmpty()) {
	    	// search for all Treasures and put them into a list
//		    	basicAlgorithm();
	    	kruskalsAlgorithm();
	    }
	    else {
	      int targetX = treasures.get(0).getX();
	      int targetY = treasures.get(0).getY();
	      if(isBotHere(targetY, targetX)) {
	    	// if Bot has reached the target, remove the target from the list
	        treasures.remove(0);
	      }
	      else {
	    	// let the Bot move to the target
	        goTo(targetY, targetX);
	      }
	    }
	    thinking = false;
	  }
  }
  
  /**
   * This is just a test algorithm to go from point A to point B.
   * This should be replaced by a better algo.
   * @param x
   * @param y
   */
  private void goTo(int x, int y) {
//    System.out.println(x + ", " + y);
    if(this.x < x) {
      move = RIGHT;
    }
    else if(this.x > x) {
      move = LEFT;
    }
    else if(this.y < y) {
      move = DOWN;
    }
    else if(this.y > y) {
      move = UP;
    }
  }
  
  private void basicAlgorithm() {
    int height = blocks.length;
    int width = blocks[0].length;
    
    for(int y = 0; y < height; y++) {
      for(int x = 0; x < width; x++) {
        if(this.blocks[y][x] instanceof Treasure) {
          treasures.add(new Point(y, x));
        }
      }
    }
  }
  
  private void kruskalsAlgorithm() {
    int height = blocks.length;
    int width = blocks[0].length;
    ArrayList<Point> temp = new ArrayList<Point>();
    ArrayList<Edge> edges = new ArrayList<Edge>();
    
    for(int y = 0; y < height; y++) {
      for(int x = 0; x < width; x++) {
        if(this.blocks[y][x] instanceof Treasure) {
          temp.add(new Point(y, x));
        }
      }
    }
    
    temp.add(new Point(this.getY(), this.getX()));
    
    for(Point a : temp) {
    	for(Point b : temp) {
    		if(a != b) {
    			edges.add(new Edge(a, b, calculateBasicDistance(a, b)));
    		}
    	}
    }
    
    // sort ASC
    Collections.sort(edges, new Comparator<Edge>() {
        @Override
        public int compare(Edge lhs, Edge rhs) {
            return lhs.distance() < rhs.distance() ? -1 : (lhs.distance() > rhs.distance()) ? 1 : 0;
        }
    });
    
//    System.out.println();
//    for(Edge a : edges) {
//    	System.out.println("(" + a.getA().getX() + "," + a.getA().getY() + ")" + "(" + a.getB().getX() + "," + a.getB().getY() + ")" + a.distance());
//    }
//    System.out.println();
    
    ArrayList<Point> path = new ArrayList<Point>();
    ArrayList<Edge> remove = new ArrayList<Edge>();
    
    for(Edge a : edges) {
    	if(isNotInCycle(path, a)) {
        	path.add(a.getA());
        	path.add(a.getB());
    	}
    	else {
    		remove.add(a);
    	}
    }
    
    edges.removeAll(remove);
    remove.clear();
    
//    System.out.println();
//    for(Point point : path) {
//    	System.out.println(point.getX() + "," + point.getY());
//    }
//    System.out.println();

	System.out.println();
    for(Edge a : edges) {
    	a.getA().print();
    	a.getB().print();
    	System.out.println();
    }
	System.out.println();
    
	ArrayList<Point> anotherPath = new ArrayList<Point>();
	Point bot = new Point(this.getY(), this.getX());
	
	// find edge connected to Bot
	for(Edge edge : edges) {
		if(edge.hasPoint(bot)) {
			anotherPath.add(bot);
			anotherPath.add(edge.getOtherPoint(bot));
			remove.add(edge);
			break;
		}
	}
	
	edges.removeAll(remove);
	remove.clear();
	
	for(Edge edge : edges) {
		if(edge.hasPoint(anotherPath.get(anotherPath.size() - 1))) {
			
		}
	}
	
    treasures.addAll(path);
    
  }
  
  private Boolean isNotInCycle(ArrayList<Point> path, Edge edge) {
	  Boolean a = true;
	  Boolean b = true;
	  
	  for(Point point : path) {
		  if(point.getX() == edge.getA().getX() && point.getY() == edge.getA().getY()) {
			  a = false;
			  break;
//			  System.out.println(point.getX() + "," + point.getY() + " = " + edge.getA().getX() + "," + edge.getA().getY());
		  }
		  if(point.getX() == edge.getB().getX() && point.getY() == edge.getB().getY()) {
			  b = false;
			  break;
//			  System.out.println(point.getX() + "," + point.getY() + " = " + edge.getB().getX() + "," + edge.getB().getY());
		  }
	  }
	  
	  return a && b;
  }
  
  private int calculateBasicDistance(Point a, Point b) {
    int widthDiff = Math.abs(a.getX() - b.getX());
    int heightDiff = Math.abs(a.getY() - b.getY()); 
    return widthDiff + heightDiff;
  }
  
  private Boolean isBotHere(int x, int y) {
    return this.x == x && this.y == y;
  }

}

class Point {
  
  private int x;
  private int y;
  
  public Point(int y, int x) {
    this.x = x;
    this.y = y;
  }
  
  public void print() {
	  System.out.println("(" + this.y + "," + this.x + ")");
  }
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
}

class Edge {
  
  private Point a;
  private Point b;
  private int distance;
  
  public Edge(Point a, Point b, int distance) {
    this.a = a;
    this.b = b;
    this.distance = distance;
  }
  
  public int distance() {
    return distance;
  }
  
  public Boolean hasPoint(Point point) {
    return (point.getX() == this.a.getX() && point.getY() == this.a.getY()) || 
    		(point.getX() == this.b.getX() && point.getY() == this.b.getY());
  }
  
  public Point getA() {
	  return a;
  }
  
  public Point getB() {
	  return b;
  }
  
  public Point getOtherPoint(Point point) {
	  if(point.getX() == this.a.getX() && point.getY() == this.b.getY()) {
		  return b;
	  }
	  else {
		  return a;
	  }
  }
  
}
