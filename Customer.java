public class Customer extends User
{
   protected Order[] orderHistory;
   protected Wallet wallet;
   protected Cart cart;
   
   // Constructor ////////////////////////////////
   public Customer (int id, String name, String username, String password)
   {
      super (id, name, username, password);
   }
   
   // Functions /////////////////////////////////
   public void addCard (String cardNumber, String expiryMonth, String expiryYear, String CVV)
   {
      Card c = new Card (cardNumber, expiryMonth, expiryYear, CVV);
      wallet = new Wallet (c, 50);
   }
   ///////////////////////////
   public void order (cart)
   {
      
   }
}