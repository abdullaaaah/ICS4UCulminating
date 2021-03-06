/*
   CLASS NAME: Order
   AUTHOR:     Oliver Huang
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores information of a order
*/
import java.util.UUID;

public class Order
{
   protected String username;
   protected String orderNumber;
   protected int driverID;
   protected double amountPaid;
   protected double tipPaid;
   protected int numOrders;
   protected boolean isCompelete = false;
   
   // Accessor /////////////////////////////////////////////////////
   public String getUsername ()
   {
      return username;
   }
   ////////////////////////////////////
   public String getOrderNumber ()
   {
      return orderNumber;
   }
   ///////////////////////////////////
   public int getDriverID ()
   {
      return driverID;
   }
   ///////////////////////////////////
   public double getAmountPaid ()
   {
      return amountPaid;
   }
   //////////////////////////////////////
   public double getTipPaid ()
   {
      return tipPaid;
   }
   /////////////////////////////////////
   public int getNumOrders ()
   {
      return numOrders;
   }
   /////////////////////////////////////
   public boolean getIsComplete()
   {
      return isCompelete;
   }
   
   /////////////////////////////////////
   public boolean getIsComplete()
   {
      return isCompelete;
   }
   
   
   // Constructor /////////////////////////////////////////////////////////
   /*
      PARAMETERS:    username, driverID, amountPaid, numOrders
      RETURN VALUE:  N/A
      PURPOSE:       Creat order object
   */
   public Order (String username, double amountPaid, int driverID)
   {
      this.username = username;
      this.amountPaid = amountPaid;
      //this.numOrders = numOrders;
      this.driverID = driverID;
      this.orderNumber = UUID.randomUUID().toString();
   }
   
   // Functions //////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    N/A
      RETURN VALUE:  N/A
      PURPOSE:       mark order as compeleted
   */
   public void completeOrder ()
   {
      isCompelete = true;
   }
   //////////////////////////////////////////////////////////
   public void addTip (double amount)
   {
      tipPaid = amount;
   }
   //////////////////////////////////////////////////////////
   public String toString ()
   {
      return orderNumber + "/n" + username + "/n" + amountPaid + "/n" + isCompelete;
   }
}