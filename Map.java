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
      positions = new Position[numRows*numCols];   //The max positions we can have are the rows times the columns.
      numPositions = 0;                            //Initially there are no stored positions so numPosition is 0
      map = new char[numRows][numCols];            //Initializes our map
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
      
         System.out.print(('A'+i)); // This doesnt work
      
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
   
   
   
}