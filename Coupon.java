public class Coupon
{
   protected String code;
   protected double discountRate;
   
   // Constructor /////////////////////////////////////////////
   public Coupon (String code, double discountRate)
   {
      this.code = code;
      this.discountRate = discountRate;
   }
}