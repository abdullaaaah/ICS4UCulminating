public class Cart
{
   protected Item[] items;
   protected Driver driver;
   protected Restaurant restaurant;
   protected Coupon coupon;
   protected Customer customer;
   protected final int LIMIT = 100;
   protected int numItems;
   protected final double SPEED_LIMIT = 60;
   protected final double DELIVERY_RATE = 1.2;
   protected final double DELIVERY_FEE = 5;
   
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
   
   public Driver findDriver(Map map)
   {
      return map.findDriver(restaurant.getPositionX(), restaurant.getPositionY());
   }
   
   public double getTotalDistance(Map map, Customer customer) //distance driver has to travel from restaurant to customer
   {
      return map.getDistance(restaurant.getPositionX(), restaurant.getPositionY(), customer.getPositionX(), customer.getPositionY());
   }
   
   public double getSubPrice(Map map, Customer customer)
   {
      return getTotalDistance(map, customer)/SPEED_LIMIT;
   }
   
   public double getDeliveryPrice(Map map, Customer customer)
   {
      return (getTotalDistance(map, customer)*DELIVERY_RATE)+DELIVERY_FEE;
   }
   
   public double getTaxes(Map map, Customer customer)
   {
      return (getSubPrice(map, customer)+getDeliveryPrice(map, customer)) * 0.13;
   }
   
   public double getTotalPrice(Map map, Customer customer)
   {
      if(coupon==null)
      return getSubPrice(map, customer)+getTaxes(map, customer)+getDeliveryPrice(map, customer);
      else
      return (getSubPrice(map, customer)+getTaxes(map, customer)+getDeliveryPrice(map, customer) ) * coupon.getDiscountRate();

      
   }
   
   public void addCoupon(Coupon coupon)
   {
      this.coupon = coupon;
   }
   
   public void createOrder(String username, double amountPaid, int driverID)
   {
      if(customer.getWallet().getBalance() >= amountPaid)
      {
         customer.addOrder(new Order(username, amountPaid, driverID)); // add to main orders array too later
      }
      else
      {
         System.out.println("Error: Insufficient funds to create order");
      }
   }
   
   
}