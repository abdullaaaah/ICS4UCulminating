public class Item
{
   protected int id;
   protected String name;
   protected double price;
   protected String restaurant;
   
   // Constructor //////////////////////////////////////
   public Item (int id, String name, double price, String restaurant)
   {
      this.id = id;
      this.name = name;
      this.price = price;
      this.restaurant = restaurant;
   }
}