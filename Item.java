/*
   CLASS NAME: Item
   AUTHOR:     Abdullah Shahid, Oliver Huang, Uthman Mohamed
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores the information of the item sold by a restaurant
*/

public class Item
{
   protected String name;
   protected double price;
   protected int restaurantID;
   
   public Item (String name, double price, int restaurantID)
   {
      this.name = name;
      this.price = price;
      this.restaurantID = restaurantID;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public double getPrice()
   {
      return this.price;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setPrice(double price)
   {
      this.price = price;
   }
   
   public int getRestaurantID()
   {
      return this.restaurantID;
   }
   
   public String toString()
   {
      return "Name: " + this.name + " Price: $" + price;
   }
}