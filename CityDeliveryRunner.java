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
      int choice = 0, resID = 0, locationY = 0, quantity = 0, order = 0;
      double tip = 0;
      String currentName, currentUsername, currentPassword, newName, newUsername, newPassword, flush;
      String username = "", password = "", locationX = "";
      boolean login = false, exit = false, register = false, nameMatches, goodData = false, continueOrder, continueSelectRes, continueReview, continueActiveOrders, valid;
      Restaurant[] result = null;
      
      
      while (!exit) {
         System.out.println("\n\n======================================================");
         System.out.println("\t\t\tWelcome to City Delivery Software");
         System.out.println("======================================================");
         
         System.out.println("1. Log in");
         System.out.println("2. Register");
         System.out.print("Enter your choice (or -1 to end program): ");
         
         goodData = false;
         valid = false;
         while (!goodData || !valid)    // repeat when input for choice is not an integer and an invalid input
         {
            try         // error trap to make sure users choice is an integer
            {
               choice = sc.nextInt();
               goodData = true;
            } 
            catch (InputMismatchException ix) 
            {
               goodData = false;
               System.out.println("Error, invalid input");        // gives error message if choice is not an integer
               System.out.print("\nEnter your choice (or -1 to end program): ");
               flush = sc.next();
            }
            valid = (choice >= 1 && choice <= 2) || choice == -1; // valid input condition 
            
            if (goodData && !valid) // gives error message if choice is an integer but not valid
            {
               System.out.println("Error, invalid input");
               System.out.print("\nEnter your choice (or -1 to end program): ");
            }
         } // end while for valid input and good data
         
         switch (choice){                                         // options for user depending on their choice
            case 1:                                      // login
               boolean continueLogin;
               do {                                               // continues login if user doesn't login or enters -1
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
            case 2:
               do {
                  register = false;
                  System.out.println("\n\n===========================");
                  System.out.println("\t\t\tREGISTER\t\t");
                  System.out.println("===========================");
               
                  System.out.println("\nEnter -1 to return to home page");
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
               } while (!register );
               break;
            case -1:
               exit = true;
               login = false;
         }
         //The stuff that happens after user is inside the software ;)
                  
         if(login)
         {
            if(cdd.isUserCustomer())
            {              
               Customer curCustomer = (Customer)cdd.getUserLoggedIn();   
               boolean continuePanel = true;
               valid = false;
               
               do { // while (!continuePanel)
                  continuePanel = true;
                  System.out.println("\n\n================================");
                  System.out.println("\t\tMain Menu");
                  System.out.println("================================");
                  
                  System.out.println("\n1. Profile Settings");
                  System.out.println("2. Wallet");
                  System.out.println("3. Place Order");
                  System.out.println("4. View Order History");
                  System.out.println("5. Active Delivery");
                  System.out.println("6. Log Out");
                  System.out.print("Enter your choice: ");
               
                  goodData = false;
                  valid = false;
                  while (!goodData || !valid)      // repeat when input for choice is not an integer and an invalid input
                  {
                     try                           // error trap to make sure users choice is an integer
                     {
                        choice = sc.nextInt();
                        goodData = true;
                     } 
                     catch (InputMismatchException ix) 
                     {
                        goodData = false;
                        System.out.println("Error, invalid input");        // gives error message if choice is not an integer
                        System.out.print("\nEnter your choice: ");
                        flush = sc.next();
                     }
                     valid = choice >= 1 && choice <= 6; // valid input condition 
                  
                     if (goodData && !valid)       // gives error message if choice is good data but not valid
                     {
                        System.out.println("Error, invalid input");
                        System.out.print("\nEnter your choice: ");
                     }
                  } // end while for valid input and good data                  
                  
                  switch (choice) {
                     case 1:                                                                       // profile setting
                        boolean continueProfileSetting = true;
                        do { // while (!continueProfileSetting)
                           continueProfileSetting = true;
                           System.out.println("\n================================");
                           System.out.println("\t\tProfile Settings");
                           System.out.println("================================");
                           System.out.println("1. Change name");
                           System.out.println("2. Change username");
                           System.out.println("3. Change password");
                           System.out.print("Enter your choice (or -1 to go back): ");
                           
                           goodData = false;
                           valid = false;
                           while (!goodData || !valid)    // repeat when input for choice is not an integer and an invalid input
                           {
                              try         // error trap to make sure users choice is an integer
                              {
                                 choice = sc.nextInt();
                                 goodData = true;
                              } 
                              catch (InputMismatchException ix) 
                              {
                                 goodData = false;
                                 System.out.println("Error, invalid input");        // gives error message if choice is not an integer
                                 System.out.print("\nEnter your choice (or -1 to go back): ");
                                 flush = sc.next();
                              }
                              valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                           
                              if (goodData && !valid) // gives error message if choice is an integer but not valid
                              {
                                 System.out.println("Error, invalid input");
                                 System.out.print("\nEnter your choice (or -1 to go back): ");
                              }
                           } // end while for valid input and good data
                                                   
                           switch (choice) {
                              case 1:                                                                             // change name
                                 System.out.println("\nEnter -1 to go back");
                                 System.out.println("Enter current name:");
                                 currentName = sc.next();
                                 
                                 nameMatches = currentName.equals(cdd.getUserLoggedIn().getName());
                                 
                                 while (!nameMatches && !currentName.equals("-1")) { // keep getting name until it matches database
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
                                    cdd.getUserLoggedIn().setName(newName); // set new name
                                    System.out.println("Name changed! Enter anything to return to profile settings.");
                                    if (sc.next()!= null){} // any input entered will take user back to profile settings
                                    continueProfileSetting = false;
                                 }
                                 break;
                              case 2:                                                                       // change username
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
                              case 3:                                     // change password
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
                     case 2:                                                        // wallet
                        
                        boolean hasCard = curCustomer.getWallet().hasCard();
                     
                        if (hasCard) {       // if customer has card they have different options than a customer that doesnt have card
                        
                           boolean continueWallet = true; // to go back
                           do {  // while (!continueWallet)
                              valid = false;
                              continueWallet = true;
                              
                              System.out.println("\n\n================================");
                              System.out.println("          Wallet");
                              System.out.println("================================");
                              
                              System.out.println("\n\nCard Status: Added");
                              System.out.print("Account balance: $");
                              System.out.println(curCustomer.getWallet().getBalance());
                           
                              System.out.println("1. Edit Card");
                              System.out.println("2. Add Money");
                              System.out.print("Enter your choice (or -1 to go back): ");
                              int walletChoice = sc.nextInt();
                              
                              goodData = false;
                              valid = false;
                              while (!goodData || !valid)    // repeat when input for choice is not an integer and an invalid input
                              {
                                 try         // error trap to make sure users choice is an integer
                                 {
                                    choice = sc.nextInt();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");        // gives error message if choice is not an integer
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.next();
                                 }
                                 valid = (choice >= 1 && choice <= 2) || choice == -1; // valid input condition 
                                 
                                 if (goodData && !valid) // gives error message if choice is an integer but not valid
                                 {
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                              } // end while for valid input and good data
                                                        
                                                            
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
                                             continueWallet = false;
                                          }
                                       }
                                    }
                                    break;
                                 case 2:                                   // add money
                                    System.out.println("Enter amount (or -1 to go back): ");
                                    double money = sc.nextDouble();
                                    if (money != -1)
                                       curCustomer.getWallet().addBalance(money);
                                    System.out.println("Money added. Enter anything to return to main menu");
                                    if(sc.next() != null){}
                                    else
                                       continueWallet = false;
                                    break;
                                 case -1:
                                    continuePanel = false;
                              }
                           } while (!continueWallet);
                        }
                        else { // doesnt have card
                           System.out.println("\n\n================================");
                           System.out.println("\t\tWallet");
                           System.out.println("================================");
                           
                           System.out.println("\nAdd Card");
                           System.out.println("\nEnter -1 anytime to go back");
                           System.out.print("\nEnter Credit Card Number (16-digits): ");
                           String cardNum = sc.next();
                           
                           Card customerCard = curCustomer.getWallet().getCreditCard();
                           
                           while (!cardNum.equals("-1") && !customerCard.validateNum(cardNum)){ // validate card number
                              System.out.println("\nError, not 16-integer card number.");
                              System.out.print("Enter Credit Card Number (16-digits): ");
                              cardNum = sc.next();
                           }
                           
                           if (cardNum.equals("-1")){
                              continuePanel = false;
                           }
                           else {
                              System.out.print("Enter CVV (ex 123): ");
                              String CVV = sc.next();
                              
                              while (!CVV.equals("-1") && !customerCard.validateCVV(CVV)){ // validate CVV
                                 System.out.println("\nError, not 3-integer CVV number.");
                                 System.out.print("Enter CVV (ex 123): ");
                                 CVV = sc.next();
                              }
                           
                              if (CVV.equals("-1")){
                                 continuePanel = false;
                              }
                              else {
                                 System.out.print("Enter Expiry Month (ex 09): ");
                                 String expiryMonth = sc.next();
                                 
                                 while (!expiryMonth.equals("-1") && !customerCard.validateExpMonth(expiryMonth)){ // validate expiry month
                                    System.out.println("\nError, not valid expiry month.");
                                    System.out.print("Enter Expiry Month (ex 09): ");
                                    expiryMonth = sc.next();
                                 }
                              
                                 if (expiryMonth.equals("-1")){
                                    continuePanel = false;
                                 }
                                 else {
                                    System.out.print("Enter Expiry Year (ex 2025): ");
                                    String expiryYear = sc.next();
                                    
                                    while (!expiryYear.equals("-1") && !customerCard.validateExpYear(expiryYear)){ // validate expiry year
                                       System.out.println("\nError, not valid expiry year.");
                                       System.out.print("Enter Expiry Year (ex 2025): ");
                                       expiryYear = sc.next();
                                    }
                                 
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
                     case 3:                                                        // place order
                        
                        Map map = cdd.getMap();
                        System.out.println("\n");
                        
                        boolean continueLocation = true;
                        do {
                           continueLocation = true;
                           System.out.println("===============================================");
                           System.out.println("                 MAP");
                           System.out.println("================================================");
                           System.out.println("Note: locations marked with X are unavailable");
                           
                           map.printMap();      // print map for user
                           do { // while (!cdd.getMap().verifyPosition(locationX.charAt(0)-65, locationY))
                              System.out.println("\nPlease take a look at the map of the city and enter your location. Enter -1 anytime to go back");
                              System.out.print("Enter your row coordinate (e.g A, B, C): ");
                              locationX = sc.next();
                              
                              
                              while ((locationX.length() != 1 || (locationX.charAt(0) < 'A' || locationX.charAt(0) > 'J' && locationX.charAt(0) < 'a' || locationX.charAt(0) > 'z') ) && !locationX.equals("-1")) { // make sure locationX is between A-J
                               
                                 System.out.println("Error, invalid input");
                                 System.out.print("\nEnter your row coordinate (e.g A, B, C): ");
                                 locationX = sc.next();
                              }
                           
                              if (locationX.equals("-1"))
                                 continuePanel = false;
                              else {
                                 System.out.print("\nEnter your column coordinate (e.g 0, 1, 2, 3): ");
                                 do { // repeat to find 1-9 as input for locationY
                                    goodData = false;
                                    valid = false;
                                 
                                    while (!goodData) {  // repeat when input for locationY is not an integer
                                       try{
                                          locationY = sc.nextInt();
                                          goodData = true;
                                       } catch (InputMismatchException ix) {
                                          System.out.println("Error, invalid input");
                                          System.out.println("\nEnter your column coordinate (e.g 0, 1, 2, 3): ");
                                          flush = sc.next();
                                       }
                                    
                                       valid = (locationY < 0 || locationY > 9) && locationY != -1;
                                    
                                       if (goodData && valid) {
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your column coordinate (e.g 0, 1, 2, 3): ");
                                       }
                                    } // while(!goodData)
                                 } while (valid);
                              }
                           } while (!cdd.getMap().verifyPosition(locationX.charAt(0)-65, locationY) && continuePanel); 
                           
                           if (locationY == -1 || locationX.equals("-1")){   // will make program go back to customer panel
                              continuePanel = false;
                           }
                           else {                        // if location is valid 
                              curCustomer.addPosition(locationX.charAt(0)-64, locationY);
                              do {
                                 continueOrder = true;
                                 System.out.println("\n===============================================");
                                 System.out.println("                 ORDER MENU");
                                 System.out.println("================================================");                              
                                 System.out.println("1. Find Restaurant by Name");
                                 System.out.println("2. Find Restaurant by Item");
                                 System.out.println("3. Find Restaurant by Filtering");
                                 System.out.print("Enter your choice (or -1 to go back): ");
                              
                                 goodData = false;
                                 valid = false;
                                 while (!goodData || !valid)    // repeat when input for choice is not an integer and an invalid input
                                 {
                                    try         // error trap to make sure users choice is an integer
                                    {
                                       choice = sc.nextInt();
                                       goodData = true;
                                    } 
                                    catch (InputMismatchException ix) 
                                    {
                                       goodData = false;
                                       System.out.println("Error, invalid input");        // gives error message if choice is not an integer
                                       System.out.print("\nEnter your choice (or -1 to go back): ");
                                       flush = sc.next();
                                    }
                                    valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 
                                    if (goodData && !valid) // gives error message if choice is an integer but not valid
                                    {
                                       System.out.println("Error, invalid input");
                                       System.out.print("\nEnter your choice (or -1 to go back): ");
                                    }
                                 } // end while for valid input and good data              
                              
                                 
                              
                                 switch (choice) {
                                                            
                                    case 1:               // find restaurant by name
                                    
                                    
                                       System.out.print("\nEnter Restaurant Name (or -1 to go back): ");
<<<<<<< HEAD
                                       sc.nextLine();
                                       String resName = sc.nextLine();
=======
<<<<<<< HEAD
                                       sc.nextLine();
                                       String resName = sc.nextLine();
                                    
                                       while (!cdd.doesRestaurantExist(resName) && !resName.equals("-1")) {    // makes sure restaurant name entered exists
                                                                                                               // loops through if restaurant name does not exist
                                          System.out.println("Error, restaurant does not exist. Please try again.");
                                          System.out.print("\nEnter Restaurant Name (or -1 to go back): ");
                                          sc.nextLine();
                                          resName = sc.nextLine();
                                       } 
                                       
                                       if (resName.equals("-1"))                                               // goes back to Map screen if input is -1
                                       {
=======
                                       String resName = sc.next();
>>>>>>> 37b87b66f86832cd73b9acac65125a6bb4ac87fb
                                    
                                       while (!cdd.doesRestaurantExist(resName) && !resName.equals("-1")) {    // makes sure restaurant name entered exists
                                                                                                               // loops through if restaurant name does not exist
                                          System.out.println("Error, restaurant does not exist. Please try again.");
                                          System.out.print("\nEnter Restaurant Name (or -1 to go back): ");
                                          sc.nextLine();
                                          resName = sc.nextLine();
                                       } 
                                       
<<<<<<< HEAD
                                       if (resName.equals("-1"))                                               // goes back to Map screen if input is -1
                                       {
=======
                                       if (resName.equals("-1")) {
>>>>>>> 161f8cc795636c0d94b9a4daf19fcd87c9a5259e
>>>>>>> 37b87b66f86832cd73b9acac65125a6bb4ac87fb
                                          continueLocation = false;
                                       }
                                       else                                                                    // if input is not -1 and restaurant name exists, 
                                                                                                               // array of restaurant input is created
                                       {
                                          result = cdd.findRestaurantByName(resName);
                                       }     
                                       
                                       
                                       break;
                                    case 2:               // find restaurant by item  // DOES NOT WORK RIGHT NOW
                                       System.out.print("Enter the name of the Item (or -1 to go back): ");
                                       sc.nextLine();
                                       String itemName = sc.nextLine();
                                    
                                       while (!cdd.doesRestaurantExist(itemName) && !itemName.equals("-1")) { // >>> need to change it to a way to check if ITEM exists<<<<
                                          System.out.println("Error, item does not exist. Please try again.");
                                          System.out.print("\nEnter the name of the Item (or -1 to go back): ");
                                          sc.nextLine();
                                          itemName = sc.nextLine();
                                       } 
                                       
                                       if (itemName.equals("-1")) {
                                          continueLocation = false;
                                       }
                                       else 
                                       {
                                          result = cdd.findRestaurantByItem(itemName);
                                       }                                
                                       
                                       break;
                                    case 3:               // find restaurant by filtering
                                       System.out.println("\n\tFilters");
                                       System.out.println("1. Highest Rating");
                                       System.out.println("2. Price (low to high)");
                                       System.out.println("3. Delivery Time: ");
                                       System.out.println("4. Dietary Restriction");
                                       System.out.println("5. No Filter");
                                       System.out.print("Enter your choice (or -1 to go back): ");
                                    
                                       goodData = false;
                                       valid = false;
                                       while (!goodData || !valid)    // repeat when input for choice is not an integer and an invalid input
                                       {
                                          try         // error trap to make sure users choice is an integer
                                          {
                                             choice = sc.nextInt();
                                             goodData = true;
                                          } 
                                          catch (InputMismatchException ix) 
                                          {
                                             goodData = false;
                                             System.out.println("Error, invalid input");        // gives error message if choice is not an integer
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                             flush = sc.next();
                                          }
                                          valid = (choice >= 1 && choice <= 5) || choice == -1; // valid input condition 
                                       
                                          if (goodData && !valid) // gives error message if choice is an integer but not valid
                                          {
                                             System.out.println("Error, invalid input");
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                          }
                                       } // end while for valid input and good data
                                    
                                       switch (choice) {
                                          case 1: // highest rating
                                             result = cdd.sortRestaurantsByHighestRating();
                                             break;
                                          case 2: // price (low to high)
                                             result = cdd.sortRestaurantsByPrice();
                                             break;
                                          case 3: // Delivery time
                                             result = cdd.sortRestaurantByDistance(); // change name to RestaurantSSSSSS
                                             break;
                                          case 5: // no filter
                                             result = cdd.getRestaurants();
                                             break;
                                          case -1: 
                                             continueOrder = false;
                                       }
                                       break;
                                    case -1:
                                       continueLocation = false;                                    
                                       break;
                                 }
                              
<<<<<<< HEAD
                                 
                                 try {       // might need to remove try catch later 
=======
                                 
<<<<<<< HEAD
                                 try {       // might need to remove try catch later 
                                    System.out.println(cdd.listRestaurant(result, result.length)); // print all restaurants based on users choice     
                                 } catch (ArrayIndexOutOfBoundsException aex) {  // is aex ok? yes very good,
                                    System.out.println("Error, restaurant doesnt exist n testtest");
                                 }
                                 
=======
                                
                                 boolean noRestaurant = false;
                                 
                                 try { 
>>>>>>> 37b87b66f86832cd73b9acac65125a6bb4ac87fb
                                    System.out.println(cdd.listRestaurant(result, result.length)); // print all restaurants based on users choice     
                                 } catch (ArrayIndexOutOfBoundsException aex) {  // is aex ok? yes very good,
                                    System.out.println("Error, restaurant doesnt exist n testtest");
                                 }
                                 
>>>>>>> 161f8cc795636c0d94b9a4daf19fcd87c9a5259e
                                 
                                 do { 
                                    continueSelectRes = true;
                                    System.out.print("Enter your choice of food (or -1 to go back): "); 
                                 
                                    goodData = false;
                                    valid = false;
                                    while (!goodData || !valid)    // repeat when input for choice is not an integer and an invalid input
                                    {
                                       try         // error trap to make sure users choice is an integer
                                       {
                                          choice = sc.nextInt();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");        // gives error message if choice is not an integer
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.next();
                                       }
                                       valid = (choice >= 1 && choice <= result.length) || choice == -1; // valid input condition 
                                    
                                       if (goodData && !valid) // gives error message if choice is an integer but not valid
                                       {
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // end while for valid input and good data
                                 
                                    if (choice == -1) {
                                       continueOrder = false;
                                    }
                                    else {
                                       Restaurant restaurant = result[choice-1]; // store user restaurant choice
                                       cdd.setCart(new Cart(restaurant, ((Customer)cdd.getUserLoggedIn()) ));                                                      
<<<<<<< HEAD
                                       System.out.println(restaurant.listMenu()); // print menu for restaurant       
=======
<<<<<<< HEAD
                                       System.out.println(restaurant.listMenu()); // print menu for restaurant       
=======
                                       System.out.println(restaurant.listMenu()); // print menu for restaurant        //use a better variable name u faggot          
>>>>>>> 161f8cc795636c0d94b9a4daf19fcd87c9a5259e
>>>>>>> 37b87b66f86832cd73b9acac65125a6bb4ac87fb
                                    
                                       System.out.print("\nEnter the number for the item you want to add, or 0 if you are finished, or -1 to cancel order and go back: ");
                                    
                                       goodData = false;
                                       valid = false;
                                       while (!goodData || !valid) {  // repeat when input for choice is not good data and invalid input
                                          try{  // error trap to make sure choice is an integer
                                             choice = sc.nextInt();
                                             goodData = true;
                                          } catch (InputMismatchException ix) {
                                             goodData = false;
                                             System.out.println("Error, invalid input");  // gives error message if choice is not an integer
                                             System.out.println("\nEnter the number for the item you want to add, or 0 if you are finished, or -1 to cancel order and go back: ");
                                             flush = sc.next();
                                          }
                                          
                                          valid = (choice >= 1 || choice <= restaurant.getMenu().length) || choice == -1 || choice == 0;
                                          
                                          if (goodData && !valid) {
                                             System.out.println("Error, invalid input"); // gives error message if choice is an integer but invalid
                                             System.out.print("\nEnter the number for the item you want to add, or 0 if you are finished, or -1 to cancel order and go back: ");
                                          }
                                       } // end while for good data and valid input
                                    
                                       if (choice == -1 || cdd.getCart().getItems()[0] == null) {
                                          continueSelectRes = false;
                                       }
                                       else if (choice != 0) {
                                          cdd.getCart().addItem(restaurant.getMenu()[choice-1], 1);                         
                                       }
                                       else if (choice == 0) { 
                                          do { // while (!continueReview);
                                             continueReview = true;
                                             
                                             // PRINT ORDER HERE
                                             System.out.println("\nReceipt");
                                             System.out.println("\nDelivery Price: " + cdd.getCart().getDeliveryPrice(cdd.getMap()));
                                             System.out.println("Taxes Price: " + cdd.getCart().getTaxes(cdd.getMap()));
                                             System.out.println("Sub Price: " + cdd.getCart().getSubPrice(cdd.getMap()));
                                             System.out.println("Total Price: " + cdd.getCart().getTotalPrice(cdd.getMap()));
                                             
                                             cdd.getCart().createOrder(curCustomer.getUsername(), cdd.getCart().getTotalPrice(cdd.getMap()), cdd.getCart().getDriver().getId());
                                             
                                             
                                             System.out.println("====================================");
                                             System.out.println("\t\tReview");
                                             System.out.println("====================================");
                                             System.out.println("Your order ");
                                             System.out.println("1. Place Order");
                                             System.out.println("2. Edit Cart");
                                             System.out.println("3. Apply Coupon");
                                          
                                             goodData = false;
                                             valid = false;
                                             while (!goodData || !valid)    // repeat when input for choice is not an integer and an invalid input
                                             {
                                                try         // error trap to make sure users choice is an integer
                                                {
                                                   choice = sc.nextInt();
                                                   goodData = true;
                                                } 
                                                catch (InputMismatchException ix) 
                                                {
                                                   goodData = false;
                                                   System.out.println("Error, invalid input");        // gives error message if choice is not an integer
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   flush = sc.next();
                                                }
                                                valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                             
                                                if (goodData && !valid) // gives error message if choice is an integer but not valid
                                                {
                                                   System.out.println("Error, invalid input");
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                }
                                             } // end while for valid input and good data
                                          
                                             switch(choice) {
                                                case 1: // place order
                                                   System.out.println("\nThank you for your order.");
                                                                                       // PRINT CART HERE
                                                   System.out.print("Order Number: "); // PRINT ORDER NUMBER HERE
                                                   System.out.println("Driver name: " + cdd.getCart().getDriver().getName()); 
                                                   System.out.println("Driver phone number: " + cdd.getCart().getDriver().getPhoneNumber()); 
                                                   System.out.println("Driver car description: " + cdd.getCart().getDriver().getDescription());
                                                   System.out.println("You can find this order in the \"active orders\" tab");
                                                   System.out.println("Enter anything to return to main menu.");
                                                   if (sc.next() != null) {}
                                                   continuePanel = false;
                                                   break;
                                                case 2: // edit order
                                                
                                                   System.out.println("\n==============================");
                                                   System.out.println("\t\tEdit Order");
                                                   System.out.println("==============================");
                                                                                       // PRINT CART HERE
                                                   System.out.print("Enter the number for the items quantity you want to change (or -1 to go back): ");
                                                   
                                                   goodData = false;
                                                   valid = false;
                                                   while (!goodData || !valid)    // repeat when input for choice is not an integer
                                                   {
                                                      try
                                                      {
                                                         choice = sc.nextInt();
                                                         goodData = true;
                                                      } 
                                                      catch (InputMismatchException ix) 
                                                      {
                                                         goodData = false;
                                                         System.out.println("Error, invalid input");
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                         flush = sc.next();
                                                      }
                                                      valid = (choice >= 1 && choice <= 5/*amount of items here*/) || choice == -1; // valid input condition 
                                                      if (goodData && !valid)
                                                      {
                                                         System.out.println("Error, invalid input");
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      }
                                                   } // end while good data and valid input
                                                   
                                                   if (choice == -1) {
                                                      continueReview = false;
                                                   }
                                                   else {
                                                      System.out.print("Enter the new quantity (or 0 to delete): ");
                                                      goodData = false;
                                                      while (!goodData) {
                                                         try {
                                                            quantity = sc.nextInt();
                                                            goodData = true;
                                                         } catch (InputMismatchException ix) {
                                                            goodData = false;
                                                            System.out.println("Error, invalid input");
                                                            System.out.print("\nEnter your choice (or -1 to go back): ");
                                                         }
                                                      } // end while for error trap
                                                      cdd.getCart().changeQuantity(cdd.getCart().getItems()[choice-1], quantity);
                                                      continueReview = false;
                                                   }
                                                   
                                                   break;
                                                case 3: // apply coupon
                                                   boolean invalidCode = false;
                                                   while (!invalidCode){
                                                      invalidCode = true;
                                                      System.out.print("Enter coupon code (or -1 to go back): ");
                                                      String couponCode = sc.next();
                                                      if (couponCode.equals("-1"))
                                                         continueReview = false;
                                                      else if (cdd.doesCouponExist(couponCode)) { // if coupon code is valid
                                                         int couponIndex = cdd.findCouponIndex(couponCode);
                                                         System.out.println("You have a " + cdd.getCoupons()[couponIndex].getDiscountRate() + " discount from your coupon.");
                                                         cdd.getCart().addCoupon(cdd.getCoupons()[couponIndex]);
                                                         System.out.println("Enter anything to return to order review.");
                                                         if (sc.next() != null) {}
                                                         continueReview = false;
                                                      }
                                                      else { // if coupon code is not valid
                                                         System.out.println("Invalid code.\n");
                                                         invalidCode = false;
                                                      }
                                                   }
                                                   break;
                                                case -1: 
                                                   continueSelectRes = false;
                                             }
                                          } while (!continueReview);
                                       }
                                    }  
                                 } while (!continueSelectRes);
                              }  while (!continueOrder);
                           } // else location != -1
                           
                        } while (!continueLocation);
                        break;
                     case 4:                                                        // view order history
                        System.out.println("\nYour orders: ");
                        Order[] orderHistory = curCustomer.getAllOrders(curCustomer.getOrderHistory());
                        for (int i = 0; i < orderHistory.length; i++) {
                           System.out.println("- Order #" + orderHistory[i].getOrderNumber());
                           System.out.println("- Driver ID: " + orderHistory[i].getDriverID());
                           System.out.println("- Amount paid: " + orderHistory[i].getTipPaid());
                           System.out.println("Enter anything to go back to main menu.");
                           if (sc.next() != null) {}
                           continuePanel = false;
                        }
                        break;
                     case 5:                                                        // view active deliveries
                        do {
                           continueActiveOrders = true;
                           Order[] activeOrders = curCustomer.getActiveOrders();
                           System.out.println("\nYou have " + activeOrders.length + " active deliveries in progress.");
                           for (int i = 0; i < activeOrders.length; i++) {
                              System.out.println(i + ". Order #" + activeOrders[i].getOrderNumber());
                           }
                           System.out.println("\nSelect the order you would like to access (or -1 to go back): ");
                        
                           while (!goodData || !valid)    // repeat when input for choice is not an integer
                           {
                              try
                              {
                                 order = sc.nextInt();
                                 goodData = true; 
                              } 
                              catch (InputMismatchException ix) 
                              {
                                 goodData = false;
                                 System.out.println("Error, invalid input");
                                 System.out.print("\nSelect the order you would like to access (or -1 to go back): ");
                                 flush = sc.nextLine();
                              }
                              valid = (order >= 1 && order <= activeOrders.length) || order == -1; // valid input condition 
                           
                              if (goodData && !valid)
                              {
                                 System.out.println("Error, invalid input");
                                 System.out.print("\nSelect the order you would like to access (or -1 to go back): ");
                              }
                           } // while(!goodData)
                           Driver driver = cdd.getDrivers()[cdd.findDriverIndex(activeOrders[order].getDriverID())]; // driver for each order
                              
                           if (order == -1) {  // if choice is -1 go back to active orders page
                              continueActiveOrders = false;
                           }
                           else if (activeOrders[order].getIsComplete()) {               // if order is complete
                              System.out.println("\n" + driver.getName() + " has arrived with your order.");
                              System.out.println("You can contact your driver with the phone number " + driver.getPhoneNumber());
                              System.out.print("\nEnter tip for driver: ");
                                 
                              goodData = false;
                              valid = false;
                              while (!goodData || !valid) { // error trap
                                 try {
                                    tip = sc.nextDouble();
                                    goodData = true;
                                 } catch (InputMismatchException idx) {
                                    System.out.println("Error, invalid input. Please try again.");
                                    System.out.println("\nEnter tip for driver: ");
                                    goodData = false;
                                 }
                                 valid = (tip == -1);
                              } // end error trap
                              if (choice == -1) {
                                 continueActiveOrders = false;
                              }
                              else {
                                 activeOrders[order].addTip(tip);
                                 activeOrders[order].completeOrder();
                              }
                           }
                           else {                                                      // if order is incomplete
                              System.out.print("Total time: ");
                                    // PRINT TOTAL TIME HERE
                              System.out.print("Enter 0 to cancel order or anything else to go back: ");
                              if (sc.next().equals("0")) {
                                    // CANCEL ORDER HERE
                              }
                              else {
                                 continueActiveOrders = false;
                              }
                           }
                        } while (!continueActiveOrders);
                        break;
                     case 6:
                        exit = false;
                        break;
                  }
               } while (!continuePanel);
            }
            else 
            { // user is admin
               while (login)
               {
                  String name, cate;
                  double rating, dis, price;
                  int id;
                  boolean proceed = false;
                  goodData = false;
               
                  System.out.println("\n\t\tAdmin");              //
                  System.out.println("1. Profile Settings");      //
                  System.out.println("2. Manage Restaurants");    //
                  System.out.println("3. Manage Drivers");        //
                  System.out.println("4. Manage Coupons");        //  Admin Homepage 
                  System.out.println("5. Add / Delete Food");     //
                  System.out.println("6. View Finances");         //
                  System.out.println("7. Logout");                //
                  System.out.print("Enter your choice: ");
                                 
                  goodData = false;
                  valid = false;
                  proceed = false;
                  
                  while (!goodData || !valid)    // repeat when input for choice is not an integer
                  {
                     try   // error trap to make sure users choice is an integer
                     {
                        choice = sc.nextInt();
                        flush = sc.nextLine();
                        goodData = true;
                     } 
                     catch (InputMismatchException ix) 
                     {
                        goodData = false;
                        System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                        System.out.print("\nEnter your choice (or -1 to go back): ");
                        flush = sc.nextLine();
                     }
                     valid = (choice >= 1 && choice <= 7) || choice == -1; // valid input condition 
                     if (goodData && !valid)
                     {
                        System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                        System.out.print("\nEnter your choice (or -1 to go back): ");
                     }
                     proceed = choice != -1;
                  } // end while for valid input and good data
                  
                  if (proceed)
                  { 
                     switch (choice)
                     {
                        case 1:   // profile settings
                           while (proceed)
                           {
                              System.out.println("\n\n1. Change Name");
                              System.out.println("2. Change Username");
                              System.out.println("3. Change Password");
                              System.out.print("Enter your choice (or -1 to go back): ");
                           
                              goodData = false;
                              valid = false;
                           
                              while (!goodData || !valid)    // repeat when input for choice is not an integer
                              {
                                 try      // error trap to make sure users choice is an integer
                                 {
                                    choice = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = choice != -1;
                              } // end while for valid input and good data
                           
                              if (proceed)
                              {
                                 switch (choice)
                                 {
                                    case 1:   // change name
                                       System.out.print("Enter Current Name (or -1 to go back: ");
                                       name = sc.nextLine();
                                       while (!name.equals(cdd.getUserLoggedIn().getName()) && !name.equals("-1"))
                                       {
                                          System.out.print("Wrong Name, Please Try again (or -1 to go back): ");
                                          name = sc.nextLine();
                                       }
                                       
                                       if (!name.equals("-1"))
                                       {
                                          System.out.print("Enter New Name: ");
                                          name = sc.nextLine();
                                          if (!name.equals("-1"))
                                          {
                                             cdd.user().setName(name);
                                             proceed = false;
                                          }
                                       }
                                       break;
                                    case 2:   // change username
                                       System.out.print("Enter Current Username (or -1 to go back): ");
                                       name = sc.nextLine();
                                       while (!name.equals(cdd.getUserLoggedIn().getUsername()) && !name.equals("-1"))
                                       {
                                          System.out.print("Wrong Username, Please Try again (or -1 to go back): ");
                                          name = sc.nextLine();
                                       }
                                       
                                       if (!name.equals("-1"))
                                       {
                                          System.out.print("Enter New Username: ");
                                          name = sc.nextLine();
                                          if (!name.equals("-1"))
                                          {
                                             cdd.user().changeUsername(name);
                                             proceed = false;
                                          }
                                       }
                                       break;
                                    case 3:   // change password
                                       System.out.print("Enter Current Password (or -1 to go back): ");
                                       password = sc.nextLine();
                                       while (!password.equals(cdd.getUserLoggedIn().decryptPassword()) && !password.equals("-1"))
                                       {
                                          System.out.print("Wrong Password, Please Try again (or -1 to go back): ");
                                          password = sc.nextLine();
                                       }
                                       
                                       if (!password.equals("-1"))
                                       {
                                          System.out.print("Enter New Password: ");
                                          password = sc.nextLine();
                                          if (!password.equals("-1"))
                                          {
                                             cdd.user().changePassword(password);
                                             proceed = false;
                                          }
                                       }
                                       break;
                                    default:    // go back
                                 }
                              }
                           }
                           break;
                        case 2:   // manage restaurant
                           while (proceed)
                           {
                              System.out.println("\n1. Add Restaurant");
                              System.out.println("2. View / Modify Restaurant");
                              System.out.println("3. Delete Restaurant");
                              System.out.print("Enter your choice (or -1 to go back): ");
                           
                              goodData = false;
                              valid = false;
                           
                              while (!goodData || !valid)    // repeat when input for choice is not an integer
                              {
                                 try      // error trap to make sure users choice is an integer
                                 {
                                    choice = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = choice != -1;
                              } // end while for valid input and good data
                           
                              switch (choice)
                              {
                                 case 1:   // add restaurant
                                    System.out.print("\nEnter Restaurant Name: ");
                                    name = sc.nextLine();
                                    if (!name.equals("-1"))
                                    {
                                       System.out.print("Enter Restaurant Category: ");
                                       cate = sc.nextLine();
                                       if (!cate.equals("-1"))
                                       {
                                          System.out.print("Enter Restaurant Rating: ");
                                          rating = 0;
                                       
                                          goodData = false;
                                          valid = false;
                                       
                                          while (!goodData || !valid)    // repeat when input for choice is not an integer
                                          {
                                             try      // error trap to make sure users choice is an integer
                                             {
                                                rating = sc.nextDouble();
                                                flush = sc.nextLine();
                                                goodData = true;
                                             } 
                                             catch (InputMismatchException ix) 
                                             {
                                                goodData = false;
                                                System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                                flush = sc.nextLine();
                                             }
                                             valid = (rating >= 0 && rating <= 5) || rating == -1; // valid input condition 
                                             if (goodData && !valid)
                                             {
                                                System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                             }
                                          } // end while for valid input and good data
                                          
                                          if (rating != -1)
                                          {
                                             System.out.print("Enter Number of Ratings the Restaurant Has: ");
                                             int numRat = 0;
                                          
                                             goodData = false;
                                             valid = false;
                                          
                                             while (!goodData || !valid)    // repeat when input for choice is not an integer
                                             {
                                                try      // error trap to make sure users choice is an integer
                                                {
                                                   numRat = sc.nextInt();
                                                   flush = sc.nextLine();
                                                   goodData = true;
                                                } 
                                                catch (InputMismatchException ix) 
                                                {
                                                   goodData = false;
                                                   System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   flush = sc.nextLine();
                                                }
                                                valid = numRat >= 0 || numRat == -1; // valid input condition 
                                                if (goodData && !valid)
                                                {
                                                   System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                }
                                             } // end while for valid input and good data
                                                            
                                             if (numRat != -1)
                                             {
                                                System.out.print("Enter Restaurant PositionX: ");
                                                int positionX = 0;
                                             
                                                goodData = false;
                                                valid = false;
                                             
                                                while (!goodData || !valid)    // repeat when input for choice is not an integer
                                                {
                                                   try      // error trap to make sure users choice is an integer
                                                   {
                                                      positionX = sc.nextInt();
                                                      flush = sc.nextLine();
                                                      goodData = true;
                                                   } 
                                                   catch (InputMismatchException ix) 
                                                   {
                                                      goodData = false;
                                                      System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                      System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      flush = sc.nextLine();
                                                   }
                                                   valid = (positionX >= 0 && positionX <= 10) || positionX == -1; // valid input condition 
                                                   if (goodData && !valid)
                                                   {
                                                      System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                      System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   }
                                                } // end while for valid input and good data
                                             
                                                if (positionX != -1)
                                                {
                                                   System.out.print("Enter Restaurant PositionY: ");
                                                   int positionY = 0;
                                                
                                                   goodData = false;
                                                   valid = false;
                                                
                                                   while (!goodData || !valid)    // repeat when input for choice is not an integer
                                                   {
                                                      try      // error trap to make sure users choice is an integer
                                                      {
                                                         positionY = sc.nextInt();
                                                         flush = sc.nextLine();
                                                         goodData = true;
                                                      } 
                                                      catch (InputMismatchException ix) 
                                                      {
                                                         goodData = false;
                                                         System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                         flush = sc.nextLine();
                                                      }
                                                      valid = (positionY >= 0 && positionY <= 10) || positionY == -1; // valid input condition 
                                                      if (goodData && !valid)
                                                      {
                                                         System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      }
                                                   } // end while for valid input and good data
                                                
                                                   if (positionY != -1)
                                                   {
                                                      ((Admin)cdd.user()).addRestaurant(cdd, name, cate, rating, numRat, positionX, positionY);
                                                      proceed = false;
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                    break;
                              
                                 case 2:   // view/modify restaurant
                                    System.out.println("\n" + cdd.getRestaurantNames());
                                    System.out.print("Enter Restaurant ID: ");
                                 
                                    goodData = false;
                                    valid = false;
                                 
                                    while (!goodData || !valid)    // repeat when input for choice is not an integer
                                    {
                                       try      // error trap to make sure users choice is an integer
                                       {
                                          resID = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (resID >= 1 && resID <= cdd.getNumRestaurants()) || resID == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // end while for valid input and good data
                                 
                                    if (resID != -1)
                                    {
                                       System.out.print("\nEnter New Name: ");
                                       name = sc.nextLine();
                                       if (!name.equals("-1"))
                                       {
                                          System.out.print("Enter New Category: ");
                                          cate = sc.nextLine();
                                          if (!cate.equals("-1"))
                                          {
                                             System.out.print("Enter New Rating: ");
                                             rating = 0;
                                          
                                             goodData = false;
                                             valid = false;
                                          
                                             while (!goodData || !valid)    // repeat when input for choice is not an integer
                                             {
                                                try      // error trap to make sure users choice is an integer
                                                {
                                                   rating = sc.nextDouble();
                                                   flush = sc.nextLine();
                                                   goodData = true;
                                                } 
                                                catch (InputMismatchException ix) 
                                                {
                                                   goodData = false;
                                                   System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   flush = sc.nextLine();
                                                }
                                                valid = (rating >= 0 && rating <= 5) || rating == -1; // valid input condition 
                                                if (goodData && !valid)
                                                {
                                                   System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                }
                                             } // end while for valid input and good data
                                          
                                             if (rating != -1)
                                             {
                                                cdd.getRestaurants()[resID - 1].editRestaurant(name, cate, rating);
                                                proceed = false;
                                             }
                                          }
                                       }
                                    }
                                    break;
                              
                                 case 3:   // delete restaurant
                                    System.out.println("\n" + cdd.getRestaurantNames());
                                    System.out.print("Enter Restaurant Name: ");
                                    name = sc.nextLine();
                                    if (!name.equals("-1"))
                                    {
                                       ((Admin)cdd.user()).removeRestaurant(cdd, name);
                                       proceed = false;
                                    }
                                    break;
                              }
                           }
                           break;
                        
                        case 3:   // manage drivers
                           while (proceed)
                           {
                              System.out.println("\n1. Add Driver");
                              System.out.println("2. View / Modify Driver");
                              System.out.println("3. Delete Driver");
                              System.out.print("Enter your choice (or -1 to go back): ");
                           
                              goodData = false;
                              valid = false;
                           
                              while (!goodData || !valid)    // repeat when input for choice is not an integer
                              {
                                 try      // error trap to make sure users choice is an integer
                                 {
                                    choice = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = choice != -1;
                              } // end while for valid input and good data
                           
                              String phoneNum;
                              switch (choice)
                              {
                                 case 1:   // add driver
                                    System.out.print("Enter Driver ID: ");
                                    id = 0;
                                 
                                    goodData = false;
                                    valid = false;
                                 
                                    while (!goodData || !valid)    // repeat when input for choice is not an integer
                                    {
                                       try      // error trap to make sure users choice is an integer
                                       {
                                          id = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (id >= 1 && cdd.compareDriverID(id)) || id == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // end while for valid input and good data
                                 
                                    if (id != -1)
                                    {
                                       System.out.print("Enter Driver Name: ");
                                       name = sc.nextLine();
                                       if (!name.equals("-1"))
                                       {
                                          System.out.print("Enter Driver Phone Number: ");
                                          phoneNum = sc.nextLine();
                                          if (!phoneNum.equals("-1"))
                                          {
                                             System.out.print("Enter Driver Description: ");
                                             String des = sc.nextLine();
                                             if (!des.equals("-1"))
                                             {
                                                System.out.print("Enter Driver PositionX: ");
                                                int positionX = 0;
                                             
                                                goodData = false;
                                                valid = false;
                                             
                                                while (!goodData || !valid)    // repeat when input for choice is not an integer
                                                {
                                                   try      // error trap to make sure users choice is an integer
                                                   {
                                                      positionX = sc.nextInt();
                                                      flush = sc.nextLine();
                                                      goodData = true;
                                                   } 
                                                   catch (InputMismatchException ix) 
                                                   {
                                                      goodData = false;
                                                      System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                      System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      flush = sc.nextLine();
                                                   }
                                                   valid = (positionX >= 1 && positionX <= 10) || positionX == -1; // valid input condition 
                                                   if (goodData && !valid)
                                                   {
                                                      System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                      System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   }
                                                } // end while for valid input and good data
                                             
                                                if (positionX != -1)
                                                {
                                                   System.out.print("Enter Driver PositionY: ");
                                                   int positionY = 0;
                                                
                                                   goodData = false;
                                                   valid = false;
                                                
                                                   while (!goodData || !valid)    // repeat when input for choice is not an integer
                                                   {
                                                      try      // error trap to make sure users choice is an integer
                                                      {
                                                         positionY = sc.nextInt();
                                                         flush = sc.nextLine();
                                                         goodData = true;
                                                      } 
                                                      catch (InputMismatchException ix) 
                                                      {
                                                         goodData = false;
                                                         System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                         flush = sc.nextLine();
                                                      }
                                                      valid = (positionY >= 1 && positionY <= 10) || positionY == -1; // valid input condition 
                                                      if (goodData && !valid)
                                                      {
                                                         System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      }
                                                   } // end while for valid input and good data
                                                
                                                   if (positionY != -1)
                                                   {
                                                      ((Admin)cdd.user()).addDriver(cdd, id, name, phoneNum, des, positionX, positionY);
                                                      proceed = false;
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                    break;
                                 case 2:    // view driver
                                    System.out.println(cdd.getDriverNames());
                                    System.out.print("Enter Driver ID: ");
                                    id = 0;
                                 
                                    goodData = false;
                                    valid = false;
                                 
                                    while (!goodData || !valid)    // repeat when input for choice is not an integer
                                    {
                                       try      // error trap to make sure users choice is an integer
                                       {
                                          id = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (id >= 1 && id <= cdd.getNumDrivers()) || id == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // end while for valid input and good data
                                 
                                    if (id != -1)
                                    {
                                       System.out.print("Enter New Name: ");
                                       name = sc.nextLine();
                                       if (!name.equals("-1"))
                                       {
                                          System.out.print("Enter New Phone Number: ");
                                          phoneNum = sc.nextLine();
                                          if (!phoneNum.equals("-1"))
                                          {
                                             System.out.print("Enter New Car Description: ");
                                             String description = sc.nextLine();
                                             if (!description.equals("-1"))
                                             {
                                                cdd.getDrivers()[id - 1].editDriver(name, phoneNum, description);
                                                proceed = false;
                                             }
                                          }
                                       }
                                    }
                                    break;
                                 case 3:   // delete driver
                                    System.out.println(cdd.getDriverNames());
                                    System.out.print("Enter Driver ID: ");
                                    id = 0;
                                 
                                    goodData = false;
                                    valid = false;
                                 
                                    while (!goodData || !valid)    // repeat when input for choice is not an integer
                                    {
                                       try      // error trap to make sure users choice is an integer
                                       {
                                          id = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (id >= 1 && id <= cdd.getNumDrivers()) || id == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // end while for valid input and good data
                                 
                                    if (id != -1)
                                    {
                                       ((Admin)cdd.user()).removeDriver(cdd, id);
                                       proceed = false;
                                    }
                                    break;
                                 default:    // go back
                              }
                           }
                           break;
                        case 4:    // manage coupons
                           while (proceed)
                           {
                              System.out.println("\n1. Add Coupon");
                              System.out.println("2. View Coupon");
                              System.out.println("3. Delete Coupon");
                              System.out.print("Enter your choice (or -1 to go back): ");
                           
                              goodData = false;
                              valid = false;
                           
                              while (!goodData || !valid)    // repeat when input for choice is not an integer
                              {
                                 try      // error trap to make sure users choice is an integer
                                 {
                                    choice = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = choice != -1;
                              } // end while for valid input and good data
                           
                              switch (choice)
                              {
                                 case 1:   // add coupon
                                    System.out.print("Enter Coupon Code: ");
                                    String code = sc.nextLine();
                                    if (!code.equals("-1"))
                                    {
                                       System.out.print("Enter Coupon Discount: ");
                                       dis = 0;
                                    
                                       goodData = false;
                                       valid = false;
                                    
                                       while (!goodData || !valid)    // repeat when input for choice is not an integer
                                       {
                                          try      // error trap to make sure users choice is an integer
                                          {
                                             dis = sc.nextDouble();
                                             flush = sc.nextLine();
                                             goodData = true;
                                          } 
                                          catch (InputMismatchException ix) 
                                          {
                                             goodData = false;
                                             System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                             flush = sc.nextLine();
                                          }
                                          valid = (dis >= 0 && dis <= 1) || dis == -1; // valid input condition 
                                          if (goodData && !valid)
                                          {
                                             System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                          }
                                       } // end while for valid input and good data
                                    
                                       if (dis != -1)
                                       {
                                          ((Admin)cdd.user()).addCoupon(cdd, code, dis);
                                          proceed = false;
                                       }
                                    }
                                    break;
                                 case 2:   // view coupon
                                    System.out.println(cdd.getCouponCodes());
                                    System.out.print("Enter Coupon ID: ");
                                    id = 0;
                                 
                                    goodData = false;
                                    valid = false;
                                 
                                    while (!goodData || !valid)    // repeat when input for choice is not an integer
                                    {
                                       try      // error trap to make sure users choice is an integer
                                       {
                                          id = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (id >= 1 && id <= cdd.getNumCoupons()) || id == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // end while for valid input and good data
                                    
                                    if (id != -1)
                                    {
                                       System.out.print ("Enter New Code: ");
                                       code = sc.nextLine();
                                       if (!code.equals("-1"))
                                       {
                                          System.out.print("Enter New Discount Rate: ");
                                          dis = 0;
                                       
                                          goodData = false;
                                          valid = false;
                                       
                                          while (!goodData || !valid)    // repeat when input for choice is not an integer
                                          {
                                             try      // error trap to make sure users choice is an integer
                                             {
                                                dis = sc.nextDouble();
                                                flush = sc.nextLine();
                                                goodData = true;
                                             } 
                                             catch (InputMismatchException ix) 
                                             {
                                                goodData = false;
                                                System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                                flush = sc.nextLine();
                                             }
                                             valid = (dis >= 0 && dis <= 1) || dis == -1; // valid input condition 
                                             if (goodData && !valid)
                                             {
                                                System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                             }
                                          } // end while for valid input and good data
                                          
                                          if (dis != -1)
                                          {
                                             cdd.getCoupons()[id - 1].setCode(code);
                                             cdd.getCoupons()[id - 1].setDiscountRate(dis);
                                             proceed = false;
                                          }
                                       }
                                    }
                                    break;
                                 case 3:   // delete coupon
                                    System.out.print(cdd.getCouponCodes());
                                    System.out.print("Enter Coupon Code: ");
                                    code = sc.nextLine();
                                    if (!code.equals("-1"))
                                    {
                                       ((Admin)cdd.user()).removeCoupon(cdd, code);
                                       proceed = false;
                                    }
                                    break;
                                 default:    // go back
                              }
                           }
                           break;
                        case 5:   // add / delete food
                           while (proceed)
                           {
                              System.out.println("\n" + cdd.getRestaurantNames()); // print a list of restaurants
                              System.out.print("Enter the restaurant ID you want to add/delete food from (or -1 to go back): ");
                              
                              goodData = false;
                              valid = false;
                              
                              while (!goodData || !valid)    // repeat when input for choice is not an integer
                              {
                                 try      // error trap to make sure users choice is an integer
                                 {
                                    resID = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (resID >= 1 && resID <= cdd.getNumRestaurants()) || resID == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = resID != -1;
                              } // end while for valid input and good data
                              
                              while (resID != -1)
                              {
                                 System.out.println("\n1. Add New Food");
                                 System.out.println("2. View");
                                 System.out.println("3. Delete");
                                 System.out.print("Enter your choice (or -1 to go back): ");
                                 
                                 goodData = false;
                                 valid = false;
                                 
                                 while (!goodData || !valid)    // repeat when input for choice is not an integer
                                 {
                                    try      // error trap to make sure users choice is an integer
                                    {
                                       choice = sc.nextInt();
                                       flush = sc.nextLine();
                                       goodData = true;
                                    } 
                                    catch (InputMismatchException ix) 
                                    {
                                       goodData = false;
                                       System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                       System.out.print("\nEnter your choice (or -1 to go back): ");
                                       flush = sc.nextLine();
                                    }
                                    valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                    if (goodData && !valid)
                                    {
                                       System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                       System.out.print("\nEnter your choice (or -1 to go back): ");
                                    }
                                 } // end while for valid input and good data
                                 
                                 switch (choice)
                                 {
                                    case 1:   // add new food
                                       System.out.print("Enter Item Name: ");
                                       name = sc.nextLine();
                                       if (!name.equals("-1"))
                                       {
                                          System.out.print("Enter Item Price: ");
                                          price = 0;
                                       
                                          goodData = false;
                                          valid = false;
                                       
                                          while (!goodData || !valid)    // repeat when input for choice is not an integer
                                          {
                                             try      // error trap to make sure users choice is an integer
                                             {
                                                price = sc.nextDouble();
                                                flush = sc.nextLine();
                                                goodData = true;
                                             } 
                                             catch (InputMismatchException ix) 
                                             {
                                                goodData = false;
                                                System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                                flush = sc.nextLine();
                                             }
                                             valid = (price > 0) || price == -1; // valid input condition 
                                             if (goodData && !valid)
                                             {
                                                System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                             }
                                          } // end while for valid input and good data
                                       
                                          if (price != -1)
                                          {
                                             cdd.getRestaurants()[resID - 1].addItem(name, price);
                                             proceed = false;
                                          }
                                       }
                                       break;
                                    case 2:   // view menu  /////////////////////not complete///////////////////////////
                                       System.out.println(cdd.getRestaurants()[resID - 1].listMenu());
                                       System.out.print("Enter Item ID: ");
                                       int itemID = 0;
                                       while (!goodData || !valid)    // repeat when input for choice is not an integer
                                       {
                                          try      // error trap to make sure users choice is an integer
                                          {
                                             itemID = sc.nextInt();
                                             flush = sc.nextLine();
                                             goodData = true;
                                          } 
                                          catch (InputMismatchException ix) 
                                          {
                                             goodData = false;
                                             System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                             flush = sc.nextLine();
                                          }
                                          valid = (itemID >= 1 && itemID <= cdd.getRestaurants()[resID - 1].numItem) || itemID == -1; // valid input condition 
                                          if (goodData && !valid)
                                          {
                                             System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                          }
                                       } // end while for valid input and good data
                                          
                                       flush = sc.nextLine();
                                       if (itemID != -1)
                                       {
                                          System.out.print("Enter New Name: ");
                                          name = sc.nextLine();
                                          if (!name.equals("-1"))
                                          {
                                             System.out.print("Enter New Price: ");
                                             price = 0;
                                             while (!goodData || !valid)    // repeat when input for choice is not an integer
                                             {
                                                try      // error trap to make sure users choice is an integer
                                                {
                                                   price = sc.nextDouble();
                                                   flush = sc.nextLine();
                                                   goodData = true;
                                                } 
                                                catch (InputMismatchException ix) 
                                                {
                                                   goodData = false;
                                                   System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   flush = sc.nextLine();
                                                }
                                                valid = price >= 0 || price == -1; // valid input condition 
                                                if (goodData && !valid)
                                                {
                                                   System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                }
                                             } // end while for valid input and good data
                                          
                                             if (price != -1)
                                             {
                                                cdd.getRestaurants()[resID - 1].editItem(cdd.getRestaurants()[resID - 1].menu[itemID - 1], name, price);
                                                proceed = false;
                                             }
                                          }
                                       }
                                       break;
                                    case 3:   // delete food
                                       System.out.println(cdd.getRestaurants()[resID - 1].listMenu());
                                       System.out.print("Enter Item Name: ");
                                       name = sc.nextLine();
                                       if (!name.equals("-1"))
                                       {
                                          cdd.getRestaurants()[resID - 1].removeItem(name);
                                          proceed = false;
                                       }
                                       break;
                                    default:
                                       resID = -1;
                                       break;
                                 }
                              }
                              //}
                           }
                           break;
                        case 6:   // view finances
                           System.out.println("Total Revenue: " + ((Admin)cdd.user()).getTotalRevenue());
                           System.out.println("Driver Salary: " + ((Admin)cdd.user()).getDriverCost());
                           System.out.println("Total Profit:  " + ((Admin)cdd.user()).getProfit());
                           System.out.print("Enter your chocice (or -1 to go back): ");
                           
                           goodData = false;
                           valid = false;
                              
                           while (!goodData || !valid)    // repeat when input for choice is not an integer
                           {
                              try      // error trap to make sure users choice is an integer
                              {
                                 choice = sc.nextInt();
                                 flush = sc.nextLine();
                                 goodData = true;
                              } 
                              catch (InputMismatchException ix) 
                              {
                                 goodData = false;
                                 System.out.println("Error, invalid input");     // gives error message if choice is not an integer
                                 System.out.print("\nEnter your choice (or -1 to end program): ");
                                 flush = sc.nextLine();
                              }
                              valid = choice == -1; // valid input condition 
                              if (goodData && !valid)
                              {
                                 System.out.println("Error, invalid input");     // gives error message if choice is good data but not valid
                                 System.out.print("\nEnter your choice (or -1 to end program): ");
                              }
                           } // end while for valid input and good data
                           break;
                        case 7:   // logout
                           cdd.logout();
                           login = false;
                           break;
                        default:
                     }
                  }
               }
            }
         }  // if (login)
      } // end main while
   } // main method
} // class