public class TestTest
{
   public static void main (String [] args)
   {
      Card ca = new Card ("Oliver", "2000300040005000", "12", "20", "887");
      Wallet w = new Wallet ("Oliver", ca, 50);
      Customer c = new Customer ("Oliver", "LOL", "123456");
      
      c.setWallet(w);
      c.addBalance (23);
      System.out.println (c.wallet);
      c.addPosition (3, 5);
      System.out.print (c.positionX + " " + c.positionY);
   }
}