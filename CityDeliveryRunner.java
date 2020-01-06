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
      
      do
      {
         System.out.println("======================================================");
         System.out.println("\t\t\tWelcome to City Delivery Software");
         System.out.println("======================================================");
         
         System.out.println("1. Log in");
         System.out.println("2. Register");
         System.out.print("Enter your choice: ");
         
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
                     startScreen = false;
                  }
               }
               
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
            if(cdd.isUserCustomer())
            {              
               Customer curCustomer = (Customer)cdd.getUserLoggedIn();   
               boolean continuePanel = true;
               do {
                  System.out.println("\n        Customer");
                  System.out.println("1. Profile Settings");
                  System.out.println("2. Wallet");
                  System.out.println("3. Place Order");
                  System.out.println("4. View Order History");
                  System.out.println("5. Active Delivery");
                  System.out.println("6. Log Out");
                  System.out.print("Enter your choice (or anything else to go back): ");
                  int choicePanel = sc.nextInt();
               
                  switch (choicePanel) {
                     case 1:                                                                       // profile setting
                        boolean continueProfileSetting = true;
                        do {
                           System.out.println("\n     Profile Settings");
                           System.out.println("1. Change name");
                           System.out.println("2. Change username");
                           System.out.println("3. Change password");
                           System.out.print("Enter your choice (or anything else to go back): ");
                           int choiceProfile = sc.nextInt();
                           
                           switch (choiceProfile) {
                              case 1:
                                 System.out.println("Enter -1 to go back");
                                 System.out.println("Enter current name:");
                                 String currentName = sc.next();
                              
                                 boolean exit = false; // for currentName
                                 while (!exit) {
                                    if (currentName.equals(cdd.getUserLoggedIn().getName())){
                                       System.out.println("Enter new name: ");
                                       String newName = sc.next();
                                       cdd.getUserLoggedIn().setName(newName);
                                       continueProfileSetting = false;
                                    }
                                    else if (currentName.equals("-1")) {
                                       continueProfileSetting = false;
                                    }
                                    else {   // need to make this loop
                                       System.out.println("Error, try again");
                                       System.out.println("Enter current name: ");
                                       currentName = sc.next();
                                    }
                                 }
                                 break;
                              case 2:
                                 System.out.println("Enter current username:");
                                 String currentUsername = sc.next();
                              
                                 exit = false; // for currentName
                              
                                 while (!exit && continuePanel)
                                    if (currentUsername.equals(cdd.getUserLoggedIn().getUsername())){
                                       System.out.println("Enter new username: ");
                                       String newUsername = sc.next();
                                       cdd.getUserLoggedIn().setUsername(newUsername);
                                       exit = true;
                                    }
                                    else if (currentUsername.equals("-1")) {
                                       continuePanel = false;
                                    }
                                    else {
                                       System.out.println("Error, try again");
                                       System.out.println("Enter current username: ");
                                       currentUsername = sc.next();
                                    }
                                 break;
                              case 3:
                                 System.out.println("Enter current password:");
                                 String currentPassword = sc.next();
                              
                                 exit = false; // for currentPass
                              
                                 while (!exit && continuePanel)
                                    if (currentPassword.equals(cdd.getUserLoggedIn().getPassword())){
                                       System.out.println("Enter new password: ");
                                       String newPassword = sc.next();
                                       cdd.getUserLoggedIn().setPassword(newPassword);
                                       exit = true;
                                    }
                                    else if (currentPassword.equals("-1")) {
                                       continuePanel = false;
                                    }
                                    else {
                                       System.out.println("Error, try again");
                                       System.out.println("Enter current password: ");
                                       currentPassword = sc.next();
                                    }
                                 break;
                              default:
                                 continuePanel = false;
                           }
                        } while(!continueProfileSetting);
                     case 2:                                                        // wallet
                        
                        boolean hasCard = curCustomer.getWallet().hasCard();
                        
                        if (hasCard) {
                           boolean continueWallet = true;
                           do {
                              System.out.print("Card Status: Added");
                              System.out.print("Account balance: ");
                              System.out.println(curCustomer.getWallet().getBalance());
                           
                              System.out.println("1. Edit Card");
                              System.out.println("2. Add Money");
                              System.out.println("Enter your choice (or anything else to go back): ");
                              int walletChoice = sc.nextInt();
                              
                              switch (walletChoice) {
                                 case 1:                                   // edit card
                                    System.out.println("Enter your modifications (or 0 to skip and -1 to go back)");
                                    System.out.print("Credit Card Number: ");
                                    String creditCardNum = sc.next();
                                    if (creditCardNum.equals("-1")) {
                                       continueWallet = false;
                                    }
                                    else {
                                       if (!creditCardNum.equals("0"))
                                          curCustomer.getWallet().getCreditCard().setCardNumber(creditCardNum);
                                       System.out.print("CVV (ex 123): ");
                                       String CVV = sc.next();
                                       if (CVV.equals("-1")) {
                                          continueWallet = false;
                                       }
                                       else {
                                          if (!CVV.equals("0")) 
                                             curCustomer.getWallet().getCreditCard().setCVV(CVV);
                                          System.out.print("Expiry Month (ex 09): ");
                                          String expiryMonth = sc.next();
                                          if (expiryMonth.equals("-1")) 
                                             continueWallet = false;
                                          else {
                                             if (!expiryMonth.equals("0"))
                                                curCustomer.getWallet().getCreditCard().setExpiryMonth(expiryMonth);
                                             System.out.print("Expiry Year (ex 2025): ");
                                             String expiryYear = sc.next();
                                             if (expiryYear.equals("-1")) {
                                                continueWallet = false;
                                             }
                                             else if (!expiryYear.equals("0"))
                                                curCustomer.getWallet().getCreditCard().setExpiryYear(expiryYear);
                                          }
                                       }
                                    }
                                 case 2:                                   // add money
                                    System.out.println("Enter amount (or -1 to go back): ");
                                    double money = sc.nextDouble();
                                    if (money != -1)
                                       curCustomer.getWallet().addBalance(money);
                                    else
                                       continueWallet = false;
                                 default:
                                    continuePanel = false;
                              }
                           } while (!continueWallet);
                        }
                        else { // doesnt have card
                           System.out.println("Add Card");
                           System.out.println("\nEnter -1 anytime to go back");
                           System.out.print("Enter Credit Card Number:" );
                           String cardNum = sc.next();
                           if (cardNum.equals("-1")){
                              continuePanel = false;
                           }
                           else {
                              System.out.print("Enter CVV (ex 123): ");
                              String CVV = sc.next();
                              if (CVV.equals("-1")){
                                 continuePanel = false;
                              }
                              else {
                                 System.out.print("Enter Expiry Month (ex 09): ");
                                 String expiryMonth = sc.next();
                                 if (expiryMonth.equals("-1")){
                                    continuePanel = false;
                                 }
                                 else {
                                    System.out.print("Enter Expiry Year (ex 2025): ");
                                    String expiryYear = sc.next();
                                    if (expiryYear.equals("-1")){
                                       continuePanel = false;
                                    }
                                    else {
                                       curCustomer.getWallet().addCard(cdd.getUserLoggedIn().getUsername(), cardNum, CVV, expiryMonth, expiryYear);
                                    }
                                 }
                              }
                           }
                           
                        }
                        break;
                     case 3:                                                        // place order
                        break;
                     case 4:                                                        // view order history
                        break;
                     case 5:                                                        // view active deliveries
                        break;
                     case 6:
                        cdd.logout();
                        // startScreen = false;
                        break;
                     default:
                        cdd.logout();
                        startScreen = false;
                  }
               } while (!continuePanel);
            }
            else 
            {
               while (login)
               {
                  //Admin panel code here
                  System.out.println("Admin");
                  System.out.println("1. Profile Settings");
                  System.out.println("2. Manage Restaurants");
                  System.out.println("3. Manage Drivers");
                  System.out.println("4. Manage Coupons");
                  System.out.println("5. Add / Delete Food");
                  System.out.println("6. View Finances");
                  System.out.println("7. Logout");
                  
                  String choice = sc.next();
                  while (choice.charAt(0) < '1' || choice.charAt(0) > '9')
                  {
                     System.out.println("\nIvalid Input, Please Choose a Number: ");
                     choice = sc.next();
                  }
                  
                  switch (choice)
                  {
                     case "1":
                        // profile setting
                        System.out.println("1. Change Name");
                        System.out.println("2. Change Username");
                        System.out.println("3. Change Password");
                        System.out.println("Press anything else to go back");
                     
                        choice = sc.next();
                        if (choice.equals("1"))
                        {
                           System.out.print("Enter New Name: ");
                           cdd.user().setName(sc.next());
                        }
                        else if (choice.equals("2"))
                        {
                           System.out.print("Enter New Username: ");
                           cdd.user().changeUsername(sc.next());
                        }
                        else if (choice.equals("3"))
                        {
                           System.out.print("Enter New Password: ");
                           cdd.user().changePassword(sc.next());
                        }
                        break;
                     case "2":
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
                           ((Admin)cdd.user()).addRestaurant(cdd, name, cate, rate, numRate, positionX, positionY);
                        }
                        else if (choice.equals("2"))
                        {
                        // view / modify restaurant
                           System.out.println(cdd.getRestaurants());
                           System.out.print("Enter Restaurant ID: ");
                           String resID = sc.next();
                           System.out.print("Enter New Name: ");
                           String name = sc.next();
                           System.out.print("Enter New Category: ");
                           String cate = sc.nextLine();
                           System.out.print("Enter New Rating: ");
                           double rating = sc.nextDouble();
                           cdd.getRestaurants()[Integer.parseInt(resID)].editRestaurant(name, cate, rating);
                        }
                        else if (choice.equals("3"))
                        {
                           System.out.print("Enter Restaurant Name: ");
                           ((Admin)cdd.user()).removeRestaurant(cdd, sc.nextLine());
                        }
                        break;
                     case "3":
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
                           ((Admin)cdd.user()).addDriver(cdd, id, name, phoneNum, des, positionX, positionY);
                        }
                        else if (choice.equals("2"))
                        {
                        // view driver
                           System.out.println(cdd.getDrivers());
                           System.out.print("Enter Driver ID: ");
                           String drivID = sc.next();
                           System.out.print("Enter New Name: ");
                           String name = sc.next();
                           System.out.print("Enter New Phone Number: ");
                           String phoneNum = sc.nextLine();
                           System.out.print("Enter New Car Description: ");
                           String description = sc.nextLine();
                           cdd.getDrivers()[Integer.parseInt(drivID)].editDriver(name, phoneNum, description);
                        
                        
                        }
                        else if (choice.equals("3"))
                        {
                           System.out.print("Enter Driver ID: ");
                           ((Admin)cdd.user()).removeDriver(cdd, sc.nextInt());
                        }
                        break;
                     case "4":
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
                           ((Admin)cdd.user()).addCoupon(cdd, code, dis);
                        }
                        else if (choice.equals("2"))
                        {
                           System.out.println(cdd.getCoupons());
                           System.out.print("Press anything to continue");
                           sc.next();
                        }
                        else if (choice.equals("3"))
                        {
                           System.out.print("Enter Coupon Code: ");
                           ((Admin)cdd.user()).removeCoupon(cdd, sc.next());
                        }
                        break;
                     case "5":
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
                           cdd.getRestaurants()[Integer.parseInt(resID)].addItem(name, price);
                        }
                        else if (choice.equals("2"))
                        {
                           System.out.println(cdd.getRestaurants()[Integer.parseInt(resID)].getMenu());
                           System.out.print("Enter Item ID: ");
                           String itemID = sc.next();
                           System.out.print("Enter New Name: ");
                           String name = sc.next();
                           System.out.print("Enter New Price: ");
                           double price = sc.nextDouble();
                           cdd.getRestaurants()[Integer.parseInt(resID)].editItem(cdd.getRestaurants()[Integer.parseInt(resID)].menu[Integer.parseInt(itemID)], name, price);
                        }
                        else if (choice.equals("3"))
                        {
                           System.out.println(cdd.getRestaurants()[Integer.parseInt(resID)].getMenu());
                           System.out.print("Enter Item Name: ");
                           String name = sc.next();
                           cdd.getRestaurants()[Integer.parseInt(resID)].removeItem(name);
                        }
                        break;
                     case "6":
                     // view finances
                        System.out.println("Total Revenue: " + ((Admin)cdd.user()).getTotalRevenue());
                        System.out.println("Driver Salary: " + ((Admin)cdd.user()).getDriverCost());
                        System.out.println("Total Profit:  " + ((Admin)cdd.user()).getProfit());
                        break;
                     case "7":
                        cdd.logout();
                        login = false;
                        break;
                     default:
                  }
               }
            }
         }  
      } while(!startScreen);
   }
}