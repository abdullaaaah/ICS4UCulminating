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
   private Position[] positions2;
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
      Position[] positions = new Position[numRows*numCols];   //The max positions we can have are the startXs times the startYumns.
      numPositions = 0;                            //Initially there are no stored positions so numPosition is 0
      map = new char[numRows][numCols];            //Initializes our map
      positions2 = new Position[numRows*numCols];
      
      
   }
   
   public char[][] getMap()
   {
      return this.map;
   }
 
   public Position[] getPositions()
   {
      return positions2;
   }
   
   public int getNumPositions()
   {
      return this.numPositions;
   }
   
 
   public void addPosition(int x, int y, Restaurant r)
   {
      
      //This fkn positions array is not storing the item for some reason

      this.positions2[numPositions] = new Position(x,y, r); 
            
      numPositions++;
   }
   
   public void addPosition(int x, int y, Driver d)
   {
      positions2[numPositions] = new Position(x,y, d); 
      numPositions++;
   }
   
   
   public boolean isOccupied(int x, int y)
   {
   
      for(int i = 0; i<numPositions; i++)
      {
         if(positions2[i].getX() == x && positions2[i].getY() == y)
         {
            return true;
         }
      }
      
      return false;
   }
   
   public boolean verifyPosition(int x, int y) {
      if (doesPositionExist(x, y)){
         return !isOccupied(x, y);
      }
      return false;
   }
   
   public Driver findDriver(int restaurantX, int restaurantY)
   {
      //When looking for the closest driver, we do not account for the route taken because the customer does not pay for this distance.
     // Just the absolute proximity is considered when searching for the best driver
     
     Driver closest = null;
     double distance = 0;
     boolean firstFound = false;
     int firstIndex = 0;
     double temp;
     
     for(int i = 0; i<numPositions && !firstFound; i++)
     {     
         if(positions2[i].getType().equals("driver"))
         {
            firstIndex = i;
            distance = getDistance(positions2[i].getX(), positions2[i].getY(), restaurantX, restaurantY);
            closest = positions2[i].getDriver();
            firstFound = true;
         } 
     }
     
     for(int i = firstIndex+1; i<numPositions; i++)
     {
         if(positions2[i].getType().equals("driver"))
         {
            temp = getDistance(positions2[i].getX(), positions2[i].getY(), restaurantX, restaurantY);
            if(temp < distance)
            {
               distance = temp;
               closest = positions2[i].getDriver();
            }
         }
     }
     
     return closest;
     
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
   
   public boolean doesPositionExist(int x, int y)
   {
      return !(x < 0 || y < 0 || x>numRows || y>numCols);
   }
   
   public void addAllPositions(Restaurant[] restaurants, int numRestaurants, Driver[] drivers, int numDrivers)
   {
   
      for(int i = 0; i<numRestaurants; i++)
      {  
         addPosition(restaurants[i].getPositionX(), restaurants[i].getPositionY(), restaurants[i]);
      }
   
      for(int i = 0; i<numDrivers; i++)
      {
         addPosition(drivers[i].getPositionX(), drivers[i].getPositionY(), drivers[i]);
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