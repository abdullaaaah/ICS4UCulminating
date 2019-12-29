import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
               login = true;
               startScreen = false; //This makes sure we wont go back to the Welcome to City Delivery Software Screen..
                  
               
               
            }
         }
         else
         {
            startScreen = true;
         }
         
         if(login)
         {
            if(cdd.isUserCustomer())
            {                  
                     //Customer panel code here
               System.out.println("Customer");
               System.out.println("1. Profile Settings");
               System.out.println("2. Wallet");
               System.out.println("3. Place Order");
               System.out.println("4. View Order History");
               System.out.println("5. Active Delivery");
               System.out.println("6. Log Out");
               
               int choice = sc.nextInt();
               
               if (choice == 1)
               {
                  // profile setting
               }
               else if (choice == 2)
               {
                  // Wallet
               }
               else if (choice == 3)
               {
                  // Place Order
               }
               else if (choice == 4)
               {
                  // View Order History
               }
               else if (choice == 5)
               {
                  // Active Delivery
               }
               else if (choice == 6)
               {
                  cdd.logout();
               }
            }
            else 
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
               
               int choice = sc.nextInt();
               
               if (choice == 1)
               {
                  // profile setting
               }
               else if (choice == 2)
               {
                  // manage restaurant
               }
               else if (choice == 3)
               {
                  // manage drivers
               }
               else if (choice == 4)
               {
                  // manage coupons
               }
               else if (choice == 5)
               {
                  // add / delete food
               }
               else if (choice == 6)
               {
                  // view finances
               }
               else if (choice == 7)
               {
                  cdd.logout();
               }
            }
         }  
         
      }
   
   }

}