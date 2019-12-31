import java.io.*;
import java.util.*;

public class CityDeliveryRunner
{

   public static void clearScreen()
   {
      System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
   }

   public static void main(String[] args)
   {
      CityDeliveryDatabase cdd = new CityDeliveryDatabase();
      Scanner sc = new Scanner(System.in);
      int initChoice;
      String username = "", password = "";
      boolean login = false, dontGoBack = true, startScreen = true, register = false;
      
      while(startScreen)
      {
         System.out.println("======================================================");
         System.out.println("\t\t\tWelcome to City Delivery Software");
         System.out.println("======================================================");
         
         System.out.println("Select your choice");
         System.out.println("1. Log in");
         System.out.println("2. Create a account");
         
         initChoice = sc.nextInt();
      
         if(initChoice == 1)
         {
            while(!login && dontGoBack)   //DontGoBack variable allows the screen to go back when user enters -1, if anyone has a better way to do it feel free.
            {
               System.out.println("===========================");
               System.out.println("\t\t\tLOG IN\t\t");
               System.out.println("===========================");
               
               System.out.print("Enter your username: ");
               username = sc.next();
               if(username.equals("-1"))
                  dontGoBack = false;
               
               if(dontGoBack)
               {
                  System.out.print("Enter your password: ");
                  password = sc.next();
                  
                  if(!password.equals("-1"))
                  {
                     login = cdd.login(username, password);
                  }
                  else
                  {   
                     dontGoBack = false;
                  }
               }
               
               startScreen = false; //Not sure if this is the right place..
               
            }
                     
         
         }
         else if(initChoice == 2)
         {
            dontGoBack = true; //check
            while(!register && dontGoBack)
            {
               System.out.println("===========================");
               System.out.println("\t\t\tREGISTER\t\t");
               System.out.println("===========================");
               
               System.out.print("Enter your name: ");
               String name = sc.next();
               if(name.equals("-1"))
                  dontGoBack = false;
               
               if(dontGoBack)
               {
                  System.out.print("Enter your desired username: "); //maybe inform user at this point if username is taken later.
                  username = sc.next();
                  if(username.equals("-1"))
                     dontGoBack = false;
               }
               
               
               if(dontGoBack)
               {   
                  System.out.print("Enter your desired password: ");
                  password = sc.next();
                  if(password.equals("-1"))
                     dontGoBack = false;
               }
               
               register = cdd.register(name, username, password);
               login = cdd.login(username, password);
               startScreen = false; //This makes sure we wont go back to the Welcome to City Delivery Software Screen..
                  
               
               
            }
         }
         else
         {
            startScreen = true;
         }
                  
         //The stuff that happens after user is inside the software ;)
                  
         if(login)
         {
            if(false)//cdd.isUserCustomer())
            {                  
                     //Customer panel code here
               System.out.println("Customer");
               System.out.println("1. Profile Settings");
               System.out.println("2. Wallet");
               System.out.println("3. Place Order");
               System.out.println("4. View Order History");
               System.out.println("5. Active Delivery");
               System.out.println("6. Log Out");
               
               String choice = sc.next();
               
               if (choice == "1")
               {
                  // profile setting
               }
               else if (choice == "2")
               {
                  // Wallet
               }
               else if (choice == "3")
               {
                  // Place Order
               }
               else if (choice == "4")
               {
                  // View Order History
               }
               else if (choice == "5")
               {
                  // Active Delivery
               }
               else if (choice == "6")
               {
                  cdd.logout();
               }
            }
            else 
            {
               while (true)
               {
                     //Admin panel code here
                  System.out.println("Admin");
                  System.out.println("1. Profile Settings");
                  System.out.println("2. Manafe Restaurants");
                  System.out.println("3. Manage Drivers");
                  System.out.println("4. Manage Coupons");
                  System.out.println("5. Add / Delete Food");
                  System.out.println("6. View Finances");
                  System.out.println("7. Logout");
               
                  String choice = sc.next();
               
                  if (choice.equals("1"))
                  {
                  // profile setting
                     System.out.println("1. Change Name");
                     System.out.println("2. Change Username");
                     System.out.println("3. Change Password");
                     System.out.println("Press anything else to go back");
                  
                     choice = sc.next();
                     if (choice.equals("1"))
                     {
                        System.out.print("Enter New Name: ");
                        cdd.userLoggedIn.setName(sc.next());
                     }
                     else if (choice.equals("2"))
                     {
                        System.out.print("Enter New Username: ");
                        cdd.userLoggedIn.changeUsername(sc.next());
                     }
                     else if (choice.equals("3"))
                     {
                        System.out.print("Enter New Password: ");
                        cdd.userLoggedIn.changePassword(sc.next());
                     }
                  }
                  else if (choice.equals("2"))
                  {
                  // manage restaurant
                     System.out.println("1. Add Restaurant");
                     System.out.println("2. View / Modify Restaurant");
                     System.out.println("3. Delete Restaurant");
                     System.out.println("Press anything else to go back");
                  
                     choice = sc.next();
                     if (choice.equals("1"))
                     {
                        System.out.print("Enter Restaurant Name: ");
                        String name = sc.next();
                        System.out.print("Enter Restaurant Category: ");
                        String cate = sc.next();
                        System.out.print("Enter Restaurant Rating: ");
                        double rate = sc.nextDouble();
                        System.out.print("Please Enter a Number: ");
                        System.out.print("Enter Number of Ratings Restaurant Got: ");
                        int numRate = Integer.parseInt(sc.next());
                        System.out.print("Enter Restaurant PositionX: ");
                        int positionX = Integer.parseInt(sc.next());
                        System.out.print("Enter Restaurant PositionY: ");
                        int positionY = Integer.parseInt(sc.next());
                        ((Admin)cdd.userLoggedIn).addRestaurant(cdd, name, cate, rate, numRate, positionX, positionY);
                     }
                     else if (choice.equals("2"))
                     {
                     // view / modify restaurant
                     }
                     else if (choice.equals("3"))
                     {
                        System.out.print("Enter Restaurant Name: ");
                        ((Admin)cdd.userLoggedIn).removeRestaurant(cdd, sc.nextLine());
                     }
                  }
                  else if (choice.equals("3"))
                  {
                  // manage drivers
                     System.out.println("1. Add Driver");
                     System.out.println("2. View / Modify Driver");
                     System.out.println("3. Delete Driver");
                     System.out.println("Press anything else to go back");
                  
                     choice = sc.next();
                     if (choice.equals("1"))
                     {
                        System.out.print("Enter Driver ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Driver Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Driver Phone Number: ");
                        String phoneNum = sc.nextLine();
                        System.out.print("Enter Driver Description: ");
                        String des = sc.nextLine();
                        System.out.print("Enter Driver PositionX: ");
                        int positionX = sc.nextInt();
                        System.out.print("Enter Driver PositionY: ");
                        int positionY = sc.nextInt();
                        ((Admin)cdd.userLoggedIn).addDriver(cdd, id, name, phoneNum, des, positionX, positionY);
                     }
                     else if (choice.equals("2"))
                     {
                     // view driver
                     }
                     else if (choice.equals("3"))
                     {
                        System.out.print("Enter Driver ID: ");
                        ((Admin)cdd.userLoggedIn).removeDriver(cdd, sc.nextInt());
                     }
                  }
                  else if (choice.equals("4"))
                  {
                  // manage coupons
                     System.out.println("1. Add Coupon");
                     System.out.println("2. View Coupon");
                     System.out.println("3. Delete Coupon");
                     System.out.println("Press anything else to go back");
                  
                     choice = sc.next();
                     if (choice.equals("1"))
                     {
                        System.out.print("Enter Coupon Code: ");
                        String code = sc.nextLine();
                        System.out.print("Enter Coupon Discount: ");
                        double dis = sc.nextDouble();
                        ((Admin)cdd.userLoggedIn).addCoupon(cdd, code, dis);
                     }
                     else if (choice.equals("2"))
                     {
                        System.out.println(cdd.coupons);
                        System.out.print("Press anything to continue");
                        sc.next();
                     }
                     else if (choice.equals("3"))
                     {
                        System.out.print("Enter Coupon Code: ");
                        ((Admin)cdd.userLoggedIn).removeCoupon(cdd, sc.next());
                     }
                  }
                  else if (choice.equals("5"))
                  {
                  // add / delete food
                     System.out.println(cdd.getRestaurants());
                     System.out.print("Press anything to go back");
                     String resID = sc.next();
                     System.out.println("1. Add New Food");
                     System.out.println("2. View");
                     System.out.println("3. Delete");
                     
                     choice = sc.next();
                     if (choice.equals("1"))
                     {
                        System.out.print("Enter Item Name: ");
                        String name = sc.next();
                        System.out.print("Enter Item Price: ");
                        double price = sc.nextDouble();
                        cdd.restaurants[Integer.parseInt(resID)].addItem(name, price);
                     }
                     else if (choice.equals("2"))
                     {
                        System.out.println(cdd.restaurants[Integer.parseInt(resID)].getMenu());
                        System.out.print("Enter Item ID: ");
                        String itemID = sc.next();
                        System.out.print("Enter New Name: ");
                        String name = sc.next();
                        System.out.print("Enter New Price: ");
                        double price = sc.nextDouble();
                        cdd.restaurants[Integer.parseInt(resID)].editItem(cdd.restaurants[Integer.parseInt(resID)].menu[Integer.parseInt(itemID)], name, price);
                     }
                     else if (choice.equals("3"))
                     {
                        System.out.println(cdd.restaurants[Integer.parseInt(resID)].getMenu());
                        System.out.print("Enter Item Name: ");
                        String name = sc.next();
                        cdd.restaurants[Integer.parseInt(resID)].removeItem(name);
                     }
                  }
                  else if (choice.equals("6"))
                  {
                  // view finances
                  }
                  else if (choice.equals("7"))
                  {
                     cdd.logout();
                  }
               }
            }
         }  
      }
   }
}