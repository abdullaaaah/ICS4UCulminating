public class Wallet
{
   protected Card creditCard;
   protected double balance;
   
   // Constructor ////////////////////////////////
   public Wallet (Card creditCard, double balance)
   {
      this.creditCard = creditCard;
      this.balance = balance;
   }
}