public class Card
{
   protected String cardNumber;
   protected String expiryMonth;
   protected String expiryYear;
   protected String CVV;
   
   // Constructor /////////////////////////////////////////////////////////
   public Card (String cardNumber, String expiryMonth, String expiryYear, String CVV)
   {
      this.cardNumber = cardNumber;
      this.expiryMonth = expiryMonth;
      this.expiryYear = expiryYear;
      this.CVV = CVV;
   }
}