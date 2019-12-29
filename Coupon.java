public class Coupon
{
   protected String code;
   protected double discountRate;
   
   public Coupon (String code, double discountRate)
   {
      this.code = code;
      this.discountRate = discountRate;
   }
   
   public String getCode()
   {
      return this.code;
   }
   
   public double getDiscountRate()
   {
      return this.discountRate;
   }
   
}