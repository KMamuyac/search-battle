package bots;

import java.util.ArrayList;

import game.Block;
import game.Character;
import game.Treasure;

public class BotAndy extends Character {

  private ArrayList<Point> treasures;
  private int[][] values;
  
  public BotAndy(Block[][] blocks, int x, int y) {
    super(blocks, x, y);
    treasures = new ArrayList<Point>();
  }
  
  @Override
  public void think() {
    if(treasures.isEmpty()) {
      basicAlgorithm();
      if(treasures.isEmpty()) {
//        System.out.println("DONE");
      }
    }
    else {
      int targetX = treasures.get(0).getX();
      int targetY = treasures.get(0).getY();
      if(isBotHere(targetX, targetY)) {
        treasures.remove(0);
      }
      else {
        goTo(targetX, targetY);
      }
    }
  }
  
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
    
    for(int y = 0; y < height; y++) {
      for(int x = 0; x < width; x++) {
        if(this.blocks[y][x] instanceof Treasure) {
          temp.add(new Point(y, x));
        }
      }
    } 
  }
  
  private int calculateBasicDistance(Point a, Point b) {
    int widthDiff = Math.abs(a.getX() - b.getY());
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
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
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
    return point == a || point == b;
  }
  
}
