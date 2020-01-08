/*
   CLASS NAME: Wallet
   AUTHOR:     Oliver Huang
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores information of the wallet of a customer
*/

public class Wallet
{
   protected String customer;
   protected Card creditCard;
   protected double balance;
   
   // Accessor & Mutator ///////////////////////////////////////////////
   public String getCustomer ()
   {
      return customer;
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
   public void setCustomer (String username)
   {
      customer = username;
   }
   
   public void setCard(Card card)
   {
      creditCard = card;
   }

   // Constructor ///////////////////////////////////
   /*
      PARAMETERS:    Actual name, username, password
      RETURN VALUE:  N/A
      PURPOSE:       Creat wallet object
   */
   public Wallet (String customer, double balance)
   {
      this.customer = customer;
      this.balance = balance;
      this.creditCard = null;
   }
   
   // Functions //////////////////////////////////////////////////
   /*
      PARAMETERS:    amount to add
      RETURN VALUE:  boolean
      PURPOSE:       add specific amount to balance
   */
   public void addBalance (double amount)
   {
      balance += amount;
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
      return creditCard != null;
   }
   //////////////////////////////////////////////////////
   /*
      PARAMETERS:    username, cardNumber, expiryMonth, expiryYear, CVV
      RETURN VALUE:  N/A
      PURPOSE:       add card to account
   */
   public void addCard (String username, String cardNumber, String month, String year, String CVV, CityDeliveryDatabase cdd)
   {
      boolean added = false;
      Card newCard = new Card(username, cardNumber, month, year, CVV);
     
      for(int i = 0; i<cdd.getNumCards() && !added; i++) // search and replace previous one if exists in the file.
      {
         if(cdd.getCards()[i].getUsername().equals(username))
         {
            cdd.getCards()[i] = newCard;
            added = true;
         }
      }
      
      if(!added)
      {
         cdd.getCards()[cdd.getNumCards()] = newCard;
         cdd.incrementNumCards();
      }
      
     cdd.saveCards();      

   }
   /////////////////////////////////////////////////////////
   public String toString ()
   {
      return balance + "\n" + hasCard();
   }
}