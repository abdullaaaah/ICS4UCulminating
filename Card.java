/*
   CLASS NAME: Card
   AUTHOR:     Oliver Huang
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores information of card in the wallet of a customer
*/

public class Card
{
   protected String username;
   protected String cardNumber;
   protected String expiryMonth;
   protected String expiryYear;
   protected String CVV;
   protected boolean approved;
   
   // Accessor //////////////////////////////////////////////////////
   /*
      PARAMETERS:    N/A
      RETURN VALUE:  boolean
      PURPOSE:       check if card in wallet in approved
   */
   public boolean getApproved ()
   {
      return approved;
   }
   
   // Constructor /////////////////////////////////////////////////////////
   /*
      PARAMETERS:    username, cardNumber, expiryMonth, expiryYear, CVV
      RETURN VALUE:  N/A
      PURPOSE:       Creat card object
   */
   public Card (String username, String cardNumber, String expiryMonth, String expiryYear, String CVV)
   {
      this.username = username;
      this.cardNumber = cardNumber;
      this.expiryMonth = expiryMonth;
      this.expiryYear = expiryYear;
      this.CVV = CVV;
   }
   /////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    cardNumber, expiryMonth, expiryYear, CVV
      RETURN VALUE:  boolean
      PURPOSE:       update card information in wallet
   */
   public void updateCard (String number, String month, String year, String CVV)
   {
      if (validateNum(number) && validateExpMonth(month) && validateExpYear(year) && validateCvv(CVV))
      {
         this.cardNumber = cardNumber;
         this.expiryMonth = expiryMonth;
         this.expiryYear = expiryYear;
         this.CVV = CVV;
         approved = true;
      }
      else
      {
         approved = false;
         System.out.println ("Error");
      }
   }
   ////////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    cardNumber
      RETURN VALUE:  boolean
      PURPOSE:       validate card number
   */
   public boolean validateNum (String num)
   {
      if (num.length() == 19)
      {
         for (int i = 0; i < num.length(); i++)
         {
            if (num.charAt(i) < '0' || num.charAt(i) > '9')
            {
               return false;
            }
         }
         return true;
      }
      return false;
   }
   //////////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    expiryMonth
      RETURN VALUE:  boolean
      PURPOSE:       validate expiryMonth
   */
   public boolean validateExpMonth (String month)
   {
      if (month.length() == 2)
      {
         return ((month.charAt(0) == '0')&&(month.charAt(1) >= '1' && month.charAt(1) <= '9')
               ||(month.charAt(0) == '1')&&(month.charAt(1) >= '0' && month.charAt(1) <= '2'));
      }
      return false;
   }
   //////////////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    expiryYear
      RETURN VALUE:  boolean
      PURPOSE:       validate expiryYear
   */
   public boolean validateExpYear (String year)
   {
      if (year.length() == 2)
      {
         return (year.charAt(0) >= '0' && year.charAt(0) <= '9')
              &&(year.charAt(1) >= '0' && year.charAt(1) <= '9');
      }
      return false;
   }
   //////////////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    CVV
      RETURN VALUE:  boolean
      PURPOSE:       validate CVV
   */
   public boolean validateCvv (String cvv)
   {
      if (cvv.length() == 3)
      {
         for (int i = 0; i < cvv.length(); i++)
         {
            if (cvv.charAt(i) < '0' || cvv.charAt(i) > '9')
            {
               return false;
            }
         }
         return true;
      }
      return false;
   }
}