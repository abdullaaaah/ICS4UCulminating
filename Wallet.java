/*
   CLASS NAME: Wallet
   AUTHOR:     Oliver Huang
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores information of the wallet of a customer
*/

public class Wallet
{
   protected String username;
   protected Card creditCard;
   protected double balance;
   
   // Accessor & Mutator ///////////////////////////////////////////////
   public String getUsername ()
   {
      return username;
   }
   ////////////////////////////
   public Card getCreditCard ()
   {
      return creditCard;
   }
   ////////////////////////////////
   public double getBalance ()
   {
      return balance;
   }
   ///////////////////////
   public void setUsername (String s)
   {
      username = s;
   }

   // Constructor ///////////////////////////////////
   /*
      PARAMETERS:    Actual name, username, password
      RETURN VALUE:  N/A
      PURPOSE:       Creat wallet object
   */
   public Wallet (String username, Card creditCard, double balance)
   {
      this.username = username;
      this.creditCard = creditCard;
      this.balance = balance;
   }
   
   // Functions //////////////////////////////////////////////////
   /*
      PARAMETERS:    amount to add
      RETURN VALUE:  boolean
      PURPOSE:       add specific amount to balance
   */
   public boolean addBalance (double amount)
   {
      if (hasCard())
      {
         balance = balance + amount;
         return true;
      }
      return false;
   }
   ////////////////////////////////////////////////////
   /*
      PARAMETERS:    amount to be subtracted
      RETURN VALUE:  boolean
      PURPOSE:       deduct money from balance
   */
   public boolean subtractBalance (double amount)
   {
      if (balance < amount)
      {
         return false;
      }
      else
      {
         balance = balance - amount;
         return true;
      }
   }
   //////////////////////////////////////////////////////
   /*
      PARAMETERS:    N/A
      RETURN VALUE:  boolean
      PURPOSE:       check if customer has useable card in wallet
   */
   public boolean hasCard ()
   {
      return (creditCard != null && creditCard.getApproved());
   }
   //////////////////////////////////////////////////////
   /*
      PARAMETERS:    username, cardNumber, expiryMonth, expiryYear, CVV
      RETURN VALUE:  N/A
      PURPOSE:       add card to account
   */
   public void addCard (String username, String cardNumber, String month, String year, String CVV)
   {
      creditCard = new Card (username, cardNumber, month, year, CVV);
   }
   /////////////////////////////////////////////////////////
   public String toString ()
   {
      return balance + "\n" + hasCard();
   }
}