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
      String choiceHome, currentName, currentUsername, currentPassword, newName, newUsername, newPassword;
      String username = "", password = "";
      boolean login = false, exit = false, register = false, nameMatches;
      
      while (!exit) {
         System.out.println("\n\n======================================================");
         System.out.println("\t\t\tWelcome to City Delivery Software");
         System.out.println("======================================================");
         
         System.out.println("1. Log in");
         System.out.println("2. Register");
         System.out.print("Enter your choice: ");
         choiceHome = sc.next();
         
         while ((choiceHome.charAt(0) < '1' || choiceHome.charAt(0) > '2') && !choiceHome.equals("-1")){
            System.out.println("\nError, enter valid input");
            System.out.print("Enter your choice: ");
            choiceHome = sc.next();
         }
         
         
         switch (choiceHome){
            case "1":
               boolean continueLogin;
               do {
                  continueLogin = true;
                  System.out.println("\n\n===========================");
                  System.out.println("\t\t\tLOG IN\t\t");
                  System.out.println("===========================");
               
                  System.out.println("\nEnter -1 to return to home page");
                  System.out.print("Enter your username: ");
                  username = sc.next();
                  if(!username.equals("-1")) {
                     System.out.print("Enter your password: ");
                     password = sc.next();
                  
                     if(!password.equals("-1")) {
                        login = cdd.login(username, password);
                        if (!login)
                           continueLogin = false;
                     }
                  }
               } while (!continueLogin);
               break;
            case "2":
               System.out.println("Enter -1 to return to home page");
               System.out.println("\n\n===========================");
               System.out.println("\t\t\tREGISTER\t\t");
               System.out.println("===========================");
               
               System.out.print("Enter your name: ");
               String name = sc.next();
               if(!name.equals("-1")) {
                  System.out.print("Enter your desired username: "); //maybe inform user at this point if username is taken later.
                  username = sc.next();
                  if(!username.equals("-1")) {
                     System.out.print("Enter your desired password: ");
                     password = sc.next();
                     if(!password.equals("-1")) {
                        register = cdd.register(name, username, password);
                        login = cdd.login(username, password);
                     }
                  }
               } 
               break;
            case "-1":
               exit = true;
         }
         //The stuff that happens after user is inside the software ;)
                  
         if(login)
         {
            if(cdd.isUserCustomer())
            {              
               Customer curCustomer = (Customer)cdd.getUserLoggedIn();   
               boolean continuePanel = true;
               do { // while (!continuePanel)
                  continuePanel = true;
                  System.out.println("\n\t\tCustomer");
                  System.out.println("1. Profile Settings");
                  System.out.println("2. Wallet");
                  System.out.println("3. Place Order");
                  System.out.println("4. View Order History");
                  System.out.println("5. Active Delivery");
                  System.out.println("6. Log Out");
                  System.out.print("Enter your choice: ");
                  String choicePanel = sc.next();
               
                  switch (choicePanel) {
                     case "1":                                                                       // profile setting
                        boolean continueProfileSetting = true;
                        do { // while (!continueProfileSetting)
                           continueProfileSetting = true;
                           System.out.println("\n     Profile Settings");
                           System.out.println("1. Change name");
                           System.out.println("2. Change username");
                           System.out.println("3. Change password");
                           System.out.print("Enter your choice (or anything else to go back): ");
                           String choiceProfile = sc.next();
                           
                           switch (choiceProfile) {
                              case "1":                                   // change name
                                 System.out.println("\nEnter -1 to go back");
                                 System.out.println("Enter current name:");
                                 currentName = sc.next();
                                 
                                 nameMatches = currentName.equals(cdd.getUserLoggedIn().getName());
                                 
                                 while (!nameMatches && !currentName.equals("-1")) {
                                    System.out.println("\nError, name doesn't match");
                                    System.out.print("Enter current name: ");
                                    currentName = sc.next();
                                    nameMatches = currentName.equals(cdd.getUserLoggedIn().getName());
                                 }
                                 if (currentName.equals("-1"))
                                    continueProfileSetting = false;
                                 else {
                                    System.out.print("Enter new name: ");
                                    newName = sc.next();
                                    cdd.getUserLoggedIn().setName(newName);
                                    System.out.println("Name changed! Enter anything to return to profile settings.");
                                    if (sc.next()!= null){}
                                    continueProfileSetting = false;
                                 }
                                 break;
                              case "2":                                      // change username
                                 System.out.println("\nEnter -1 to go back");
                                 System.out.println("Enter current username:");
                                 currentUsername = sc.next();
                                 
                                 nameMatches = currentUsername.equals(cdd.getUserLoggedIn().getUsername());
                                 
                                 while (!nameMatches && !currentUsername.equals("-1")) {
                                    System.out.println("\nError, username doesn't match");
                                    System.out.print("Enter current username: ");
                                    currentUsername = sc.next();
                                    nameMatches = currentUsername.equals(cdd.getUserLoggedIn().getUsername());
                                 }
                                 if (currentUsername.equals("-1"))
                                    continueProfileSetting = false;
                                 else {
                                    System.out.print("Enter new username: ");
                                    newUsername = sc.next();
                                    cdd.getUserLoggedIn().setUsername(newUsername);
                                    System.out.println("Username changed! Enter anything to return to profile settings.");
                                    if (sc.next()!= null){}
                                    continueProfileSetting = false;
                                 }
                                 break;
                              case "3":                                     // change password
                                 System.out.println("\nEnter -1 to go back");
                                 System.out.println("Enter current password:");
                                 currentPassword = sc.next();
                                 
                                 nameMatches = currentPassword.equals(cdd.getUserLoggedIn().decryptPassword());
                                 
                                 while (!nameMatches && !currentPassword.equals("-1")) {
                                    System.out.println("\nError, password doesn't match");
                                    System.out.print("Enter current password: ");
                                    currentPassword = sc.next();
                                    nameMatches = currentPassword.equals(cdd.getUserLoggedIn().getPassword());
                                 }
                                 if (currentPassword.equals("-1"))
                                    continueProfileSetting = false;
                                 else {
                                    System.out.print("Enter new password: ");
                                    newPassword = sc.next();
                                    cdd.getUserLoggedIn().setPassword(newPassword);
                                    System.out.println("Password changed! Enter anything to return to profile settings.");
                                    if (sc.next()!= null){}
                                    continueProfileSetting = false;
                                 }
                                 break;
                              default:
                                 continuePanel = false;
                           }
                        } while(!continueProfileSetting);
                        break;
                     case "2":                                                        // wallet
                        
                        boolean hasCard = curCustomer.getWallet().hasCard();
                        if (hasCard) {
                           boolean continueWallet = true; // to go back
                           do {  // while (!continueWallet)
                              continueWallet = true;
                              System.out.println("\n\nCard Status: Added");
                              System.out.print("Account balance: $");
                           // boolean continueWallet = true;
                           // do {
                              System.out.print("Card Status: Added");
                              System.out.print("Account balance: ");
                              System.out.println(curCustomer.getWallet().getBalance());
                           
                              System.out.println("1. Edit Card");
                              System.out.println("2. Add Money");
                              System.out.println("Enter your choice (or anything else to go back): ");
                              String walletChoice = sc.next();
                              
                              switch (walletChoice) {
                                 case "1":                                   // edit card
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
                                             continueWallet = false;
                                          }
                                       }
                                    }
                                 case "2":                                   // add money
                                    System.out.println("Enter amount (or -1 to go back): ");
                                    double money = sc.nextDouble();
                                    if (money != -1)
                                       curCustomer.getWallet().addBalance(money);
                                    System.out.println("Money added. Press enter to return to main menu");
                                    if(sc.next()!=null){}
                                    else
                                       continueWallet = false;
                                    break;
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
                                       curCustomer.getWallet().addCard(cdd.getUserLoggedIn().getUsername(), cardNum, CVV, expiryMonth, expiryYear, cdd);
                                       System.out.println("Card added! Enter anything to return to main menu");
                                       if (sc.next()!= null) {}
                                       continuePanel = false;
                                    }
                                 }
                              }
                           }
                           
                        }
                        break;
                     case "3":                                                        // place order
                        
                        Map map = cdd.getMap();
                        System.out.println("\n");
                        map.printMap();      // print map for user
                        
                        boolean continueLocation = true;
                        do {
                           continueLocation = true;
                           System.out.print("Enter your area code (ex A2), or -1 to go back: ");
                           String location = sc.next();
                           while ((location.charAt(0) > 'E' || location.charAt(0) < 'A') && (location.charAt(1) < '0' || location.charAt(1) > '4') && !location.equals("-1")){ // loop while input is not A-E and 0-4 and not -1
                              System.out.println("Error, invalid area code.");
                              System.out.print("Enter your area code (ex A2), or -1 to go back: ");
                              location = sc.next();
                           }
                           
                           if (location.equals("-1")){   // will make program go back to customer panel
                              continuePanel = false;
                           }
                           else {                        // if location is valid 
                              curCustomer.addPosition(location.charAt(0), location.charAt(1));
                              System.out.println("\n\n\t\tOrder");
                              System.out.println("1. Find Restaurant by Name");
                              System.out.println("2. Find Restaurant by Item");
                              System.out.println("3. Find Restaurant by Filtering");
                              System.out.print("Enter your choice (or -1 to go back): ");
                              String choiceOrder = sc.next();
                              
                              while (!choiceOrder.equals("-1") && (choiceOrder.charAt(0) < '1' || choiceOrder.charAt(0) > '3')){ // loop while their choice is not 1-3 and not -1
                                 System.out.println("\nError, invalid input.");
                                 System.out.print("Enter your choice (or -1 to go back): ");
                                 choiceOrder = sc.next();
                              }
                              
                              switch (choiceOrder) {
                                 case "1":               // find restaurant by name
                                    System.out.print("Enter Restaurant Name (or -1 to go back): ");
                                    String resName = sc.next();
                                    while (!cdd.doesRestaurantExist(resName) && !resName.equals("-1")){  // loop while restaurant name doesnt exist and input isnt -1
                                       System.out.println("Error, restaurant does not exist");
                                       System.out.print("Enter Restaurant Name (or -1 to go back): ");
                                       resName = sc.next();
                                    }
                                    
                                    if (resName.equals("-1"))     // if input is -1 program goes back to location input
                                       continueLocation = false;
                                    else {                        // if restaurant name is valid
                                       System.out.println(cdd.getRestaurants()[cdd.findRestaurantIndexByName(resName)].getMenu()); // gets restaurant menu
                                       System.out.println("\nEnter the number for the item you would like to add,");
                                       System.out.print("or 0 if you are finished, or -1 to cancel order and go back: ");
                                       int choiceItem = sc.nextInt();   // item # that customer chooses
                                       
                                       
                                       
                                       
                                       
                                       
                                    }
                                    break;
                                 case "2":               // find restaurant by item
                                    System.out.print("Enter the name of the Item (or -1 to go back): ");
                                    String itemName = sc.next();
                                    
                                    break;
                                 case "3":               // find restaurant by filtering
                                    break;
                                 case "-1":
                                    continueLocation = false;                                    
                                    break;
                              }
                           }
                        } while (!continueLocation);
                        break;
                     case "4":                                                        // view order history
                        break;
                     case "5":                                                        // view active deliveries
                        break;
                     case "6":
                        exit = false;
                        break;
                     default:
                        exit = false;
                  }
               } while (!continuePanel);
            }
            else 
            { // user is admin
               while (login)
               {
                  String name, cate;
                  //Admin panel code here

                  System.out.println("Admin");                    //
                  System.out.println("1. Profile Settings");      //
                  System.out.println("2. Manage Restaurants");    //
                  System.out.println("3. Manage Drivers");        //
                  System.out.println("4. Manage Coupons");        //  Admin Homepage 
                  System.out.println("5. Add / Delete Food");     //
                  System.out.println("6. View Finances");         //
                  System.out.println("7. Logout");                //
                           
                  String choice = sc.next();
                  while (choice.length() != 1 || choice.charAt(0) < '1' || choice.charAt(0) > '7') // check if choice entered is between 1 and 7
                  {
                     System.out.println("\nIvalid Input, Please Choose a Number: ");
                     choice = sc.next();
                  }
                           
                  switch (choice)
                  {
                     case "1":   // profile settings
                        System.out.println("1. Change Name");
                        System.out.println("2. Change Username");
                        System.out.println("3. Change Password");
                        System.out.println("Press anything else to go back");
                              
                        choice = sc.next();
                        while (choice.length() != 1 || choice.charAt(0) < '1' || choice.charAt(0) > '3') // check if choice entered is between 1 and 3
                        {
                           System.out.println("\nIvalid Input, Please Choose a Number: ");
                           choice = sc.next();
                        }
                     
                        switch (choice)
                        {
                           case "1":   // change name
                              System.out.print("Enter New Name: ");
                              cdd.user().setName(sc.next());
                              break;
                           case "2":   // change username
                              System.out.print("Enter New Username: ");
                              cdd.user().changeUsername(sc.next());
                              break;
                           case "3":   // change password
                              System.out.print("Enter New Password: ");
                              cdd.user().changePassword(sc.next());
                              break;
                           default:    // go back
                        }
                        break;
                     case "2":   // manage restaurant
                        System.out.println("1. Add Restaurant");
                        System.out.println("2. View / Modify Restaurant");
                        System.out.println("3. Delete Restaurant");
                        System.out.println("Press anything else to go back");
                              
                        choice = sc.next();
                        while (choice.length() != 1 || choice.charAt(0) < '1' || choice.charAt(0) > '3') // check if choice entered is between 1 and 3
                        {
                           System.out.println("\nIvalid Input, Please Choose a Number: ");
                           choice = sc.next();
                        }
                     
                        switch (choice)
                        {
                           case "1":   // add restaurant
                              System.out.print("Enter Restaurant Name: ");
                              name = sc.next();
                              System.out.print("Enter Restaurant Category: ");
                              cate = sc.next();
                              System.out.print("Enter Restaurant Rating: ");
                              double rate = sc.nextDouble();
                              System.out.print("Enter Number of Ratings Restaurant Got: ");
                              int numRate = Integer.parseInt(sc.next());
                              System.out.print("Enter Restaurant PositionX: ");
                              int positionX = Integer.parseInt(sc.next());
                              System.out.print("Enter Restaurant PositionY: ");
                              int positionY = Integer.parseInt(sc.next());
                              ((Admin)cdd.user()).addRestaurant(cdd, name, cate, rate, numRate, positionX, positionY);
                              break;
                           case "2":   // view/modify restaurant
                              System.out.println(cdd.getRestaurants());
                              System.out.print("Enter Restaurant ID: ");
                              String resID = sc.next();
                              System.out.print("Enter New Name: ");
                              name = sc.next();
                              System.out.print("Enter New Category: ");
                              cate = sc.nextLine();
                              System.out.print("Enter New Rating: ");
                              double rating = sc.nextDouble();
                              cdd.getRestaurants()[Integer.parseInt(resID)].editRestaurant(name, cate, rating);
                              break;
                           case "3":   // delete restaurant
                              System.out.print("Enter Restaurant Name: ");
                              ((Admin)cdd.user()).removeRestaurant(cdd, sc.nextLine());
                              break;
                        }
                        break;
                     case "3":   // manage drivers
                        System.out.println("1. Add Driver");
                        System.out.println("2. View / Modify Driver");
                        System.out.println("3. Delete Driver");
                        System.out.println("Press anything else to go back");
                              
                        choice = sc.next();
                        while (choice.length() != 1 || choice.charAt(0) < '1' || choice.charAt(0) > '3') // check if choice entered is between 1 and 3
                        {
                           System.out.println("\nIvalid Input, Please Choose a Number: ");
                           choice = sc.next();
                        }
                        
                        String phoneNum;
                        switch (choice)
                        {
                           case "1":   // add driver
                              System.out.print("Enter Driver ID: ");
                              int id = sc.nextInt();
                              System.out.print("Enter Driver Name: ");
                              name = sc.nextLine();
                              System.out.print("Enter Driver Phone Number: ");
                              phoneNum = sc.nextLine();
                              System.out.print("Enter Driver Description: ");
                              String des = sc.nextLine();
                              System.out.print("Enter Driver PositionX: ");
                              int positionX = sc.nextInt();
                              System.out.print("Enter Driver PositionY: ");
                              int positionY = sc.nextInt();
                              ((Admin)cdd.user()).addDriver(cdd, id, name, phoneNum, des, positionX, positionY);
                              break;
                           case "2":    // view driver
                              System.out.println(cdd.getDrivers());
                              System.out.print("Enter Driver ID: ");
                              String drivID = sc.next();
                              System.out.print("Enter New Name: ");
                              name = sc.next();
                              System.out.print("Enter New Phone Number: ");
                              phoneNum = sc.nextLine();
                              System.out.print("Enter New Car Description: ");
                              String description = sc.nextLine();
                              cdd.getDrivers()[Integer.parseInt(drivID)].editDriver(name, phoneNum, description);
                              break;
                           case "3":   // delete driver
                              System.out.print("Enter Driver ID: ");
                              ((Admin)cdd.user()).removeDriver(cdd, sc.nextInt());
                              break;
                           default:    // go back
                        }
                        break;
                     case "4":    // manage coupons
                        System.out.println("1. Add Coupon");
                        System.out.println("2. View Coupon");
                        System.out.println("3. Delete Coupon");
                        System.out.println("Press anything else to go back");
                              
                        choice = sc.next();
                        while (choice.length() != 1 || choice.charAt(0) < '1' || choice.charAt(0) > '3') // check if choice entered is between 1 and 3
                        {
                           System.out.println("\nIvalid Input, Please Choose a Number: ");
                           choice = sc.next();
                        }
                        
                        switch (choice)
                        {
                           case "1":   // add coupon
                              System.out.print("Enter Coupon Code: ");
                              String code = sc.nextLine();
                              System.out.print("Enter Coupon Discount: ");
                              double dis = sc.nextDouble();
                              ((Admin)cdd.user()).addCoupon(cdd, code, dis);
                              break;
                           case "2":   // view coupon
                              System.out.println(cdd.getCoupons());
                              System.out.print("Press anything to continue");
                              sc.next();
                              break;
                           case "3":   // delete coupon
                              System.out.print("Enter Coupon Code: ");
                              ((Admin)cdd.user()).removeCoupon(cdd, sc.next());
                              break;
                           default:    // go back
                        }
                        break;
                     case "5":   // add / delete food
                        System.out.println(cdd.getRestaurants()); // print a list of restaurants
                        System.out.print("Press anything to go back");
                        String resID = sc.next();
                        
                        System.out.println("1. Add New Food");
                        System.out.println("2. View");
                        System.out.println("3. Delete");
                        System.out.print("Press anything to go back");
                              
                        choice = sc.next();
                        while (choice.length() != 1 || choice.charAt(0) < '1' || choice.charAt(0) > '3') // check if choice entered is between 1 and 3
                        {
                           System.out.println("\nIvalid Input, Please Choose a Number: ");
                           choice = sc.next();
                        }
                        
                        switch (choice)
                        {
                           case "1":   // add new food
                              System.out.print("Enter Item Name: ");
                              name = sc.next();
                              System.out.print("Enter Item Price: ");
                              double price = sc.nextDouble();
                              cdd.getRestaurants()[Integer.parseInt(resID)].addItem(name, price);
                              break;
                           case "2":   // view menu
                              System.out.println(cdd.getRestaurants()[Integer.parseInt(resID)].getMenu());
                              System.out.print("Enter Item ID: ");
                              String itemID = sc.next();
                              System.out.print("Enter New Name: ");
                              name = sc.next();
                              System.out.print("Enter New Price: ");
                              price = sc.nextDouble();
                              cdd.getRestaurants()[Integer.parseInt(resID)].editItem(cdd.getRestaurants()[Integer.parseInt(resID)].menu[Integer.parseInt(itemID)], name, price);
                              break;
                           case "3":   // delete food
                              System.out.println(cdd.getRestaurants()[Integer.parseInt(resID)].getMenu());
                              System.out.print("Enter Item Name: ");
                              name = sc.next();
                              cdd.getRestaurants()[Integer.parseInt(resID)].removeItem(name);
                              break;
                           default:
                              break;
                        }
                        break;
                     case "6":   // view finances
                        System.out.println("Total Revenue: " + ((Admin)cdd.user()).getTotalRevenue());
                        System.out.println("Driver Salary: " + ((Admin)cdd.user()).getDriverCost());
                        System.out.println("Total Profit:  " + ((Admin)cdd.user()).getProfit());
                        break;
                     case "7":   // logout
                        cdd.logout();
                        login = false;
                        break;
                     default:
                  }
               }
            }
         }  // if (login)
      } // end main while
   } // main method
} // class