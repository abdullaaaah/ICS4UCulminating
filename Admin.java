public class Admin extends User
{
   // Constructor ///////////////////////////////
   /*
      PARAMETERS:    Actual name, username, password
      RETURN VALUE:  N/A
      PURPOSE:       Creat Amin object
   */
   public Admin (String name, String username, String password)
   {
      super (name, username, password);
   }
   
   // Functions //////////////////////////////////////////////////
   /*
      PARAMETERS:    Restaurants list, name, category, rating, positoinX, positionY
      RETURN VALUE:  N/A
      PURPOSE:       Add new restaurant to existing restaurant list
   */
   public void addRestaurant (Restaurant[] restaurants, int id, String name, String category, double rating, int numRating, int positionX, int positionY)
   {
      cdd.addRestaurant(new Restaurant(id, name, positionX, positionY, category, rating, numRating));
   }
   /////////////////////////////////////////////
   /*
      PARAMETERS:    Restaurant list, actual restaurant
      RETURN VALUE:  N/A
      PURPOSE:       Delete selected restaurant from existing list
   */
   public void deleteRestaurant (Restaurant[] restaurants, Restaurant res)
   {
      for (int i = 0; i < restaurants.length; i++)
      {
         if (restaurants[i].getId() == res.getId())
         {
            restaurants[i] = null;
         }
      }
      boolean found = false;
      for (int i = 1; i < restaurants.length; i++)
      {
         if (restaurants[i] == null)
         {
            found = true;
         }
         else if (found)
         {
            restaurants[i - 1] = restaurants[i];
         }
      }
   }
   ///////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    Driver list, actual name, phone number, car description, positionX, positionY
      RETURN VALUE:  N/A
      PURPOSE:       Add new Driver to existing list
   */
   public void addDriver (Driver[] drivers, int id, String name, String phoneNumber, String description, int positionX, int positionY)
   {
      drivers.add(new Driver(id, name, phoneNumber, description, positionX, positionY));
   }
   ///////////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    Driver list, actual driver
      RETURN VALUE:  N/A
      PURPOSE:       Delete selected driver from existing list
   */
   public void deleteDriver (Driver[] drivers, Driver dri)
   {
      for (int i = 0; i < drivers.length; i++)
      {
         if (drivers[i].getPhoneNumber() == dri.getPhoneNumber())
         {
            drivers[i] = null;
         }
      }
      boolean found = false;
      for (int i = 1; i < drivers.length; i++)
      {
         if (drivers[i] == null)
         {
            found = true;
         }
         else if (found)
         {
            drivers[i - 1] = drivers[i];
         }
      }
   }
   ///////////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    Driver list, actual name, phone number, car description, positionX, positionY
      RETURN VALUE:  N/A
      PURPOSE:       Add new Driver to existing list
   */
   public void addCoupon (Coupon[] coupons, String code, double discount)
   {
      coupons.add(new Coupon(code, discount));
   }
   ////////////////////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    Coupon list, actual coupon
      RETURN VALUE:  N/A
      PURPOSE:       Delete selected coupon from existing list
   */
   public void deleteCoupon (Coupon[] coupons, Coupon cou)
   {
      for (int i = 0; i < coupons.length; i++)
      {
         if (coupons[i].getCode() == cou.getCode())
         {
            coupons[i] = null;
         }
      }
      boolean found = false;
      for (int i = 1; i < coupons.length; i++)
      {
         if (coupons[i] == null)
         {
            found = true;
         }
         else if (found)
         {
            coupons[i - 1] = coupons[i];
         }
      }
   }
   //////////////////////////////////////////////////////////
   /*
      PARAMETERS:    Order list
      RETURN VALUE:  total revenue
      PURPOSE:       calculate total revenue earned
   */
   public double getTotalRevenue (Order[] orders)
   {
      double revenue;
      for (int i = 0; i < orders.length; i++)
      {
         revenue = revenue + orders[i].getAmountPaid() + orders[i].getTipPaid();
      }
      return revenue;
   }
   /////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    Coupon list, actual coupon
      RETURN VALUE:  N/A
      PURPOSE:       Delete selected coupon from existing list
   */
   public int getTotalOrders (Order[] orders)
   {
   
   }
}