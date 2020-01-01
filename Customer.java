/*
   CLASS NAME: Customer
   AUTHOR:     Oliver Huang
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores information of a customer..!
*/


public class Customer extends User
{
   protected Order[] orderHistory;
   protected Wallet wallet;
   //protected Cart cart;
   protected int positionX;
   protected int positionY;
   
   // Accessor /////////////////////////////////////haha
   public Order[] getOrderHistory ()
   {
      return orderHistory;
   }
   ///////////////////////////////////
   public Wallet getWallet ()
   {
      return wallet; 
   }
   ///////////////////////////////////
   public int getPositionX  ()
   {
      return positionX;
   }
   ///////////////////////////////////
   public int getPositionY ()
   {
      return positionY;
   }
   
   // Constructor ////////////////////////////////
   /*
      PARAMETERS:    Actual name, username, password
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
         if (orders[i].username == this.username)
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
   
   //////////////////////////////////////////////////
   /*
      PARAMETERS:    Wallet[]
      RETURN VALUE:  void
      PURPOSE:       Find customer's wallet and set it.
   */
   public void setWallet(Wallet[] wallets, int num) // this will be used when opening the wallet screen
   {
      boolean walletFound = false;
      for(int i = 0; i<num && !walletFound; i++)
      {
         if(wallets[i].getCustomer() == this.username)
         this.wallet = wallets[i];
         walletFound = true;
      }
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
         if(orderHistory[i].isCompelete)
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
      boolean finish = false;
      for (int i = 0; i < orderHistory.length && finish; i++)
      {
         if (orderHistory[i] == null)
         {
            orderHistory[i] = order;
            finish = true;
         }
      }
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