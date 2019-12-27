public class Customer extends User
{
   protected Order[] orderHistory;
   protected Wallet wallet;
   protected Cart cart;
   protected int positionX;
   protected int positionY;
   
   // Constructor ////////////////////////////////
   /*
      PARAMETERS:    N/A
      RETURN VALUE:  N/A
      PURPOSE:       Creat Customer object
   */
   public Customer (String name, String username, String password)
   {
      super (name, username, password);
   }
   
   // Functions /////////////////////////////////
   /*
      PARAMETERS:    Orders in database
      RETURN VALUE:  Orders belongs to customer
      PURPOSE:       Find all orders belongs to this customer
   */
   public Order[] getAllOrders (Order[] orders)
   {
      orderHistory = new Order[50];
      int count = 0;
      
      for (int i = 0; i < orders.length; i++)
      {
         if (orders.getCustomer() == this.username)
         {
            orderHistory[count] = orders[i];
            count++;
         }
      }
      return orderHistory;
   }
   //////////////////////////////////////////////////
   /*
      PARAMETERS:    Wallet
      RETURN VALUE:  void
      PURPOSE:       Add wallet to customer
   */
   public void setWallet (Wallet wallet)
   {
      this.wallet = wallet;
   }
   ///////////////////////////////////////////////////
   /*
      PARAMETERS:    amount want to add
      RETURN VALUE:  void
      PURPOSE:       Add balance to customer's account
   */
   public void addBalance (double amount)
   {
      if (wallet.hasCard())
      {
         wallet.balance = wallet.balance + amount;
      }
   }
   ////////////////////////////////////////////////////
   /*
      PARAMETERS:    positionX, positionY
      RETURN VALUE:  void
      PURPOSE:       Let customer set their location
   */
   public void addPosition (int positionX, int positionY)
   {
      this.positionX = positionX;
      this.positionY = positionY;
   }
   /////////////////////////////////////////////////////
   /*
      PARAMETERS:    N/A
      RETURN VALUE:  Orders in delivery
      PURPOSE:       Show customer's procceding orders
   */
   public Order[] getActiveOrders()
   {
      Order[] activeOrders = new Order[orderHistory.length];
      int count = 0;
      for (int i = 0; i < orderHistory.length; i++)
      {
         if(!orderHistory[i].isComplete())
         {
            activeOrders[count] = orderHistory[i];
            count++;
         }
      }
      return activeOrders;
   }
   ////////////////////////////////////////////////
   /*
      PARAMETERS:    order
      RETURN VALUE:  void
      PURPOSE:       Add new order to customer's order history
   */
   public void addOrder (Order order)
   {
      orderHistory.add(order);
   }
   //////////////////////////////////////////////////////
   /*
      PARAMETERS:    password
      RETURN VALUE:  boolean
      PURPOSE:       Check if password meets requirments
   */
   public String toString ()
   {
      return name + "/n" + username + "/n" + wallet.balance + "/n" + "Customer";
   }
}