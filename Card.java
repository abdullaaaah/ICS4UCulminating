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
   /////////////////////////////////////////////
   public String getUsername ()
   {
      return username;
   }
   ////////////////////////////
   public String getCardNumber ()
   {
      return cardNumber;
   }
   ////////////////////////////////
   public String getExpiryMonth ()
   {
      return expiryMonth;
   }   
   ///////////////////////////////////
   public String getExpiryYear ()
   {
      return expiryYear;
   }
   /////////////////////////////////////
   public String getCVV ()
   {
      return CVV;
   }  
   
   ////////////////////////////////////
   // Mutators
   ////////////////////////////////////
   public void setUsername (String name)
   {
      username = name;
   }
   ////////////////////////////////////
   public void setCardNumber (String num) 
   {
      cardNumber = num;
   }
   ////////////////////////////////////
   public void setExpiryMonth (String month) 
   {
      expiryMonth = month;
   }
   ////////////////////////////////////
   public void setExpiryYear (String year) 
   {
      expiryYear = year;
   }
   ////////////////////////////////////
   public void setCVV (String number)
   {
      CVV = number;
   }
   // Constructor /////////////////////////////////////////////////////////
   /*
      PARAMETERS:    username, cardNumber, expiryMonth, expiryYear, CVV
      RETURN VALUE:  N/A
      PURPOSE:       Creat card object
   */
   public Card (String username, String number, String month, String year, String CVV)
   {
      this.username = username;
      /*if (validateNum(number) && validateExpMonth(month) && validateExpYear(year) && validateCvv(CVV))
      {*/
         this.cardNumber = number;
         this.expiryMonth = month;
         this.expiryYear = year;
         this.CVV = CVV;
         approved = true;
      //}
   }
   /////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    cardNumber, expiryMonth, expiryYear, CVV
      RETURN VALUE:  boolean
      PURPOSE:       update card information in wallet
   */
   public void updateCard (String number, String month, String year, String CVV)
   {
      if (validateNum(number) && validateExpMonth(month) && validateExpYear(year) && validateCVV(CVV))
      {
         this.cardNumber = number;
         this.expiryMonth = month;
         this.expiryYear = year;
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
   public static boolean validateNum (String num)
   {
      if (num.length() == 16)
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
   public boolean validateCVV (String cvv)
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
   /////////////////////////////////////////////////
   public String toString ()
   {
      return username + "\n" + cardNumber + "\n" + expiryMonth + "\n" + expiryYear + "\n" +  CVV;
   }
}