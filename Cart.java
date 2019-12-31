public class Cart
{
   protected Item[] items;
   protected Driver driver;
   protected Restaurant restaurant;
   protected Coupon coupon;
   protected final int LIMIT = 100;
   protected int numItems;
   
   public Cart(Restaurant restaurant)
   {
      items = new Item[LIMIT];
      numItems = 0;
      this.restaurant = restaurant;
      
   }
   
   public void addItem(Item item, int quantity)
   {
      // add some validation later 
      for(int i = 0; i<quantity; i++)
      {
         this.items[numItems] = item;
      }
   }
   
   public void changeQuantity(Item item, int quantity)
   {
      int currentQuantity = 0, difference;
      //Find surplus or deficit
      for(int i = 0; i<numItems; i++)
      {
         if(items[i].getName().equals( item.getName() )) //use compare to later 
         {
            currentQuantity++;
         }
      }
       ////////////          CASES    ///////////////////////////
      //given quantity: 5, current quantity 5.. 5-5=0 no change
      //given quantity 5, current quantity 10, 5-10 = -5.. remove 5
      //given quantity 5, current quantity 4, 5-4 = 1.. add 1
      difference = quantity - currentQuantity; 
      
      if(difference!=0)
      {
         if(difference>0)
         {
            for(int i = 0; i<difference; i++)
            {
               addItem(item, difference);
            }
         }
         else
         {
            for(int i = 0; i<difference; i++)
            {
               boolean deleted = false;
               int index = -1;
               for(int x = 0; x<numItems && !deleted; x++)
               {
                  if(items[x].getName().equals(item.getName()))
                  {
                     deleted = true;
                     index = x;
                     items[x] = null;
                  }
               }
               
               //Shift everything down by 1
               for(int y = index; y<numItems-1; y++)
               {
                  items[y] = items[y+1];
                  items[y+1] = null;
               }    
            }
            
         }
      
      }
   
   }
   
}