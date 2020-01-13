/*
   CLASS NAME: Map
   AUTHOR:     Abdullah Shahid
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    The purpose of this class is to store all the information about the map used in the software
               It tracks the position of restaurants, drivers and the customer and calculates distance between points
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
   private final int BLOCK_DISTANCE = 1;
   private final char OBSTACLE = 'X';
   private final char DESTINATION = 'U';
   private final char OPEN = '.';
   private final char TRIED = '-';
   private final char GOOD_PATH = '+';
   
   /////////////////////////////////   CONSTRUCTOR(s) /////////////////////////////////
   
   
   /*
      PARAMETERS:    the number of rows, the number of columns
      PURPOSE:       Initialize the map object
   */
   public Map(int numRows, int numCols)
   {
   
      this.numRows = numRows;
      this.numCols = numCols;
      Position[] positions = new Position[numRows*numCols];   //The max positions we can is the number of rows times the number of columns.
      numPositions = 0;                            //Initially there are no stored positions so numPosition is 0
      map = new char[numRows][numCols];            //Initializes our map
      positions2 = new Position[numRows*numCols];  //some bug prevents us from using the name positions
      
      
   }
   
      /////////////////////////////////  ACCESSORS  /////////////////////////////////
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the map 2d array.
      PURPOSE:       Acessor of the map field
   */
   public char[][] getMap()
   {
      return this.map;
   }
 
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns all of the positions that are stored in the map.
      PURPOSE:       Acessor of the positions field
   */
   public Position[] getPositions()
   {
      return positions2;
   }
    
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the restaurant's name
      PURPOSE:       Acessor of the name field
   */
   public int getNumPositions()
   {
      return this.numPositions;
   }
   
   /*
      PARAMETERS:    No params
      RETURN VALUE:  Returns the restaurant's name
      PURPOSE:       Acessor of the name field
   */ 
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
   
   public boolean verifyPosition(int x, int y) 
   {
      if (doesPositionExist(x, y))
      {
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
     
     //So first, we need to find the first driver's index in the positions array. 
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
     
      //Then we loop through the whole array and find other drivers and compare their positions with the restaurants.
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
      System.out.println("Row\t\tColumn");
      for(int i = 0; i<numRows; i++)
      {
         System.out.print((char) ('A'+i) + "\t\t");
      
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
         
            if(this.destinationX == x && this.destinationY == y)
            {
               this.map[x][y] = DESTINATION;
            }
            else if(isOccupied(x,y))
            {
               this.map[x][y] = OBSTACLE;
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
         System.out.println("One restaurant at " + restaurants[i].getPositionX()+restaurants[i].getPositionY());
         addPosition(restaurants[i].getPositionX(), restaurants[i].getPositionY(), restaurants[i]);
      }
   
      for(int i = 0; i<numDrivers; i++)
      {
         System.out.println("One Driver at " + drivers[i].getPositionX()+drivers[i].getPositionY());
         addPosition(drivers[i].getPositionX(), drivers[i].getPositionY(), drivers[i]);
      }
   
   }
   
   public double getDistance(int startX, int startY, int destinationX, int destinationY)
   {
   
      //Set the destination to get to
      this.destinationX = destinationX;
      this.destinationY = destinationY;
      
      //variable to track the number of blocks traveled.
      this.numBlocks = 0; 
      
      //Create the map..
      createMap();

      //Go to the recursive method to find the disatance
      getDistance(startX, startY);
      
      //
      System.out.println("DEBUG: printing map after finding path");
      for(int i = 0; i<this.map.length; i++)
      {
         for(int x = 0; x<this.map[i].length; x++)
         {
            System.out.print(this.map[i][x]);
         }
         System.out.println();
      } 
      
      return this.numBlocks * BLOCK_DISTANCE;
   }
   
   //Recursive method
   public boolean getDistance(int startX, int startY)
   {
      boolean successful = false;
      
      
      if(this.map[startX][startY] == DESTINATION)
      {
         System.out.println("Destination REACHED");
         map[startX][startY] = GOOD_PATH;
         successful = true;
      }
      else 
      {      
         if(this.destinationY > startY ) //if the destination is to the right of us.
         {
            map[startX][startY] = TRIED;
            //We have to prioririze moving right in this situation
            if(startY+1<this.numCols && (map[startX][startY+1] == OPEN || map[startX][startY+1]==DESTINATION))
            {
               successful = getDistance(startX, startY+1);
            }
         
            //*************************UP/ABOVE*************///
            
            if(destinationX>=startX) // If obstacle on the left, and destination below us, go down. 
            {
               if(!successful)
               {
                  //Move down
                  if ( startX + 1 < this.numRows && (map[startX+1][startY] == OPEN || map[startX+1][startY] == DESTINATION) ) {
                     successful = getDistance(startX+1, startY);
                  }
               }            
            }
            else //if obstacle on the left, and destination is above us. Go up.
            {
               if(!successful)
               {
                  //Move up
                  if ( startX-1 >=0 && (map[startX-1][startY] == OPEN || map[startX-1][startY] == DESTINATION)) {
                     successful = getDistance(startX-1, startY);
                  }
               }           
            
            }
             
            //*************************END UP/ABOVE*************///
         
            //If special conditions fails, go anywhere. 
            if(!successful)
            {
               //move left
               if ( startY-1 >=0 && (map[startX][startY-1] == OPEN || map[startX][startY-1] == DESTINATION)) {
                  successful = getDistance(startX, startY-1);
               }
            
            }    
            if(!successful)
            {
                  //Move down
               if ( startX + 1 < this.numRows && (map[startX+1][startY] == OPEN || map[startX+1][startY] == DESTINATION) ) {
                  successful = getDistance(startX+1, startY);
               }
            }
            if(!successful)
            {
                  //Move up
               if ( startX-1 >=0 && (map[startX-1][startY] == OPEN || map[startX-1][startY] == DESTINATION)) {
                  successful = getDistance(startX-1, startY);
               }
            }
            
             
            if (successful)
            {
               // mark this as part of a good path
               map[startX][startY] = GOOD_PATH;
               this.numBlocks++;
            }
            
         }
         else if( this.destinationY < startY ) //CASE 2: if destination is to the left
         {
            map[startX][startY] = TRIED;
            //We have to prioririze moving left in this situation
            if ( startY-1 >=0 && (map[startX][startY-1] == OPEN || map[startX][startY-1] == DESTINATION)) {
               successful = getDistance(startX, startY-1);
            }
         
            //*************************UP/ABOVE*************///
            if(destinationX>=startX) // if destination below us
            {
            
               if(!successful)
               {
                  //Move down
                  if ( startX + 1 < this.numRows && (map[startX+1][startY] == OPEN || map[startX+1][startY] == DESTINATION) ) {
                     successful = getDistance(startX+1, startY);
                  }
               }            
            
            }
            else //if its above us
            { 
               if(!successful)
               {
                  //Move up
                  if ( startX-1 >=0 && (map[startX-1][startY] == OPEN || map[startX-1][startY] == DESTINATION)) {
                     successful = getDistance(startX-1, startY);
                  }
               }
            }
            //************************* END UP/ABOVE*************///
            
            //If special cases fail, then we move anywhere possible. 
            if (!successful){
               	//move right
               if(startY+1<this.numCols && (map[startX][startY+1] == OPEN || map[startX][startY+1]==DESTINATION))
               {
                  successful = getDistance(startX, startY+1);
               }
            }
            if(!successful)
            {
                  //Move down
               if ( startX + 1 < this.numRows && (map[startX+1][startY] == OPEN || map[startX+1][startY] == DESTINATION) ) {
                  successful = getDistance(startX+1, startY);
               }
            }
            if(!successful)
            {
                  //Move up
               if ( startX-1 >=0 && (map[startX-1][startY] == OPEN || map[startX-1][startY] == DESTINATION)) {
                  successful = getDistance(startX-1, startY);
               }
            }

            if (successful)
            {
               // mark this as part of a good path
               map[startX][startY] = GOOD_PATH;
               this.numBlocks++;
            }
         
         }
         else if(startY==destinationY) //On the right column, need to move up or down.
         {
         
            //*************************UP/ABOVE*************///
            if(destinationX>=startX) // if destination below us
            {
               //Move down
               if ( startX + 1 < this.numRows && (map[startX+1][startY] == OPEN || map[startX+1][startY] == DESTINATION) ) {
                  successful = getDistance(startX+1, startY);
               }
               

            }
            else //if its above us
            {
            
               //Move up
               if ( startX-1 >=0 && (map[startX-1][startY] == OPEN || map[startX-1][startY] == DESTINATION)) {
                  successful = getDistance(startX-1, startY);
               }
            
            }
            //************************* END UP/ABOVE*************///
         
            //If special cases fail, move anywhere
            if (!successful){
               	//move right
               if(startY+1<this.numCols && (map[startX][startY+1] == OPEN || map[startX][startY+1]==DESTINATION) )
               {
                  successful = getDistance(startX, startY+1);
               }
            }
            if(!successful)
            {
               //move left
               if ( startY-1 >=0 && (map[startX][startY-1] == OPEN || map[startX][startY-1] == DESTINATION)) {
                  successful = getDistance(startX, startY-1);
               }
            }
   
             
            if (successful)
            {
               // mark this as part of a good path
               map[startX][startY] = GOOD_PATH;
               this.numBlocks++;
            }

         
         }
         else
         {  //If none of those above conditions are met, just go anywhere   
         
            map[startX][startY] = TRIED;
            if ( startY-1 >=0 && (map[startX][startY-1] == OPEN || map[startX][startY-1] == DESTINATION)) {
               successful = getDistance(startX, startY-1);
            }
            if(!successful)
            {
               //Move down
               if ( startX + 1 < this.numRows && (map[startX+1][startY] == OPEN || map[startX+1][startY] == DESTINATION) ) {
                  successful = getDistance(startX+1, startY);
               }
            }
            if(!successful)
            {
               //Move up
               if ( startX-1 >=0 && (map[startX-1][startY] == OPEN || map[startX-1][startY] == DESTINATION)) {
                  successful = getDistance(startX-1, startY);
               }
            }
            if (!successful){
               	//move right
               if(startY+1<this.numCols && (map[startX][startY+1] == OPEN || map[startX][startY+1]==DESTINATION))
               {
                  successful = getDistance(startX, startY+1);
               }
            }
            if (successful)
            {
               // mark this as part of a good path
               map[startX][startY] = GOOD_PATH;
               this.numBlocks++;
            }

         }
      
      } //end else
      return successful;
   } // end class
         
} // end map