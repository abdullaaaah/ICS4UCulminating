public class Restaurant
{
   protected int id;
   protected String name;
   protected Location location;
   protected Item[] menu;
   protected String category;
   protected double rating;
   
   // Constructor ///////////////////////////////////
   public Restaurant (int id, String name, Location location, Item[] menu, String category, double rating)
   {
      this.id = id;
      this.name = name;
      this.location = location;
      this.menu = menu;
      this.category = category;
      this.rating = rating;
   }
}