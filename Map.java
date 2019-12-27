/*
   CLASS NAME: Map
   AUTHOR:     Abdullah Shahid
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    -
*/

public class Map
{
   private int numRows;
   private int numCols;
   private char[][] map;
   private Position[] positions;
   private int numPositions;
   private int destinationX;
   private int destinationY;
   private int numBlocks;
   private final int BLOCK_DISTANCE = 2;
   private final char OBSTACLE = 'X';
   private final char DESTINATION = 'U';
   private final char OPEN = '.';
   private final char TRIED = '-';
   private final char GOOD_PATH = '+';
   
   public Map(int numRows, int numCols)
   {
      this.numRows = numRows;
      this.numCols = numCols;
      positions = new Position[numRows*numCols];   //The max positions we can have are the startXs times the startYumns.
      numPositions = 0;                            //Initially there are no stored positions so numPosition is 0
      map = new char[numRows][numCols];            //Initializes our map
   }
   
   public char[][] getMap()
   {
      return this.map;
   }
 
   public Position[] getPositions()
   {
      return positions;
   }
   
   public int getNumPositions()
   {
      return this.numPositions;
   }
   
 
   public void addPosition(int x, int y)
   {
      positions[numPositions] = new Position(x,y); 
      numPositions++;
   }
   
   
   public boolean isOccupied(int x, int y)
   {
      for(int i = 0; i<numPositions; i++)
      {
         if(positions[i].getX() == x && positions[i].getY() == y)
         {
            return true;
         }
      }
      
      return false;
   }
   
   
   public void printMap()
   {
      for(int i = 0; i<numRows; i++)
      {
      
         System.out.print((char) ('A'+i));
      
         for(int x = 0; x<numCols; x++)
         {
            if(isOccupied(i,x))
            {
               System.out.print(" X");
            }
            else
               System.out.print(" " + x);
         }
      
         System.out.println();
      }
   }
   
   public void createMap()
   {
   
      for(int x = 0; x<numRows; x++)
      {
      
         for(int y = 0; y<numCols; y++)
         {
            if(isOccupied(x,y))
            {
               this.map[x][y] = OBSTACLE;
            }
            else if(this.destinationX == x && this.destinationY == y)
            {
               this.map[x][y] = DESTINATION;
            }
            else
            {
               this.map[x][y] = OPEN;
            }
         }
         
      }
         System.out.println("DEBUG: printing map before finding path");
       for(int i = 0; i<this.map.length; i++)
      {
         for(int x = 0; x<this.map[i].length; x++)
         {
            System.out.print(this.map[i][x]);
         }
         System.out.println();
      }
   
   }
   
   public void addAllPositions(Restaurant[] restaurants, int numRestaurants, Driver[] drivers, int numDrivers)
   {
   
      for(int i = 0; i<numRestaurants; i++)
      {  
         addPosition(restaurants[i].getPositionX(), restaurants[i].getPositionY());
      }
   
      for(int i = 0; i<numDrivers; i++)
      {
         addPosition(drivers[i].getPositionX(), drivers[i].getPositionY());
      }
   
   }
   
   public double getDistance(int startX, int startY, int destinationX, int destinationY)
   {
      this.destinationX = destinationX;
      this.destinationY = destinationY;
      
      System.out.println("WHAAT");
      System.out.println(this.destinationX);
      System.out.println(this.destinationY);
      
      
      this.numBlocks = 0;
      
      createMap();
      
      getDistance(startX, startY);
      
      return this.numBlocks * BLOCK_DISTANCE;
   }
   
   public boolean getDistance(int startX, int startY)
   {
      boolean successful = false;
      if(this.map[startX][startY] == DESTINATION)
      {
         map[startX][startY] = GOOD_PATH;
         this.numBlocks++;
         successful = true;
      }
      else 
      {
         map[startX][startY] = TRIED;
         // try moving south
            if ( startX + 1 < this.numRows && (map[startX+1][startY] == OPEN || map[startX+1][startY] == DESTINATION) ) {
               successful = getDistance(startX+1, startY);
               System.out.println("Moved down");
            }
            if (!successful){
            	// try moving east
               if ( startY + 1 < this.numCols && (map[startX][startY+1] == OPEN || map[startX][startY+1] == DESTINATION)) {
                  successful = getDistance(startX, startY+1);
                  System.out.println("Moved right");
               }
            }
            if (!successful){
            	// try moving west
               if ( startX-1 >= 0 && (map[startX-1][startY] == OPEN || map[startX-1][startY] == DESTINATION)) {
                  successful = getDistance(startX-1, startY);
                  System.out.println("Moved left");
               }
            }
            if (!successful){
            	// try moving north
               if ( startY-1 >=0 && (map[startX][startY-1] == OPEN || map[startX][startY-1] == DESTINATION)) {
                  successful = getDistance(startX, startY-1);
                  System.out.println("Moved up");
               }
            }
            if (successful)
            {
             	// mark this as part of a good path
               map[startX][startY] = GOOD_PATH;
               this.numBlocks++;
            }
         } //end else
         return successful;
      } // end class
         
} // end class