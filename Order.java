public class Order
{
   protected String orderNumber;
   protected Cart cart;
   protected Driver driver;
   protected boolean isConfirmed;
   
   // Constructor ////////////////////////////////
   public Order (Cart cart)
   {
      this.cart = cart;
   }
}