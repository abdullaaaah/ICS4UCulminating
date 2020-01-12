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
      int choice = 0, resID = 0;
      String currentName, currentUsername, currentPassword, newName, newUsername, newPassword, flush;
      String username = "", password = "";
      boolean login = false, exit = false, register = false, nameMatches, goodData = false, valid;
      
      while (!exit) {
         System.out.println("\n\n======================================================");
         System.out.println("\t\t\tWelcome to City Delivery Software");
         System.out.println("======================================================");
         
         System.out.println("1. Log in");
         System.out.println("2. Register");
         System.out.print("Enter your choice (or -1 to end program): ");
         
         do { // repeat to find either 1 or 2 as input for choice
         
            goodData = false;
            valid = false;
            
            while (!goodData) {  // repeat when input for choice is not an integer
               try{
                  choice = sc.nextInt();
                  goodData = true;
               } catch (InputMismatchException ix) {
                  System.out.println("Error, invalid input");
                  System.out.print("\nEnter your choice (or -1 to end program): ");
                  flush = sc.next();
               }
               
               valid = (choice < 1 || choice > 2) && choice != -1;
               
               if (goodData && valid) {
                  System.out.println("Error, invalid input");
                  System.out.print("\nEnter your choice (or -1 to end program): ");
               }
            } // while(!goodData)
         } while (valid);
         
         switch (choice){
            case 1:
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
            case 2:
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
               
                  do { // repeat to find either 1 or 2 as input for choice
                     goodData = false;
                     valid = false;
                     
                     while (!goodData) {  // repeat when input for choice is not an integer
                        try{
                           choice = sc.nextInt();
                           goodData = true;
                        } catch (InputMismatchException ix) {
                           System.out.println("Error, invalid input");
                           System.out.print("\nEnter your choice: ");
                           flush = sc.next();
                        }
                        
                        valid = choice < 1 || choice > 6;
                        
                        if (goodData && valid) {
                           System.out.println("Error, invalid input");
                           System.out.print("\nEnter your choice: ");
                        }
                     } // while(!goodData) end
                  } while (valid); // do while end
                  
                  
                  switch (choice) {
                     case 1:                                                                       // profile setting
                        boolean continueProfileSetting = true;
                        do { // while (!continueProfileSetting)
                           continueProfileSetting = true;
                           System.out.println("\n\n     Profile Settings");
                           System.out.println("1. Change name");
                           System.out.println("2. Change username");
                           System.out.println("3. Change password");
                           System.out.print("Enter your choice (or -1 to go back): ");
                           
                           do { // repeat to find either 1 or 2 as input for choice
                              goodData = false;
                              valid = false;
                              
                              while (!goodData) {  // repeat when input for choice is not an integer
                                 try{
                                    choice = sc.nextInt();
                                    goodData = true;
                                 } catch (InputMismatchException ix) {
                                    System.out.println("Error, invalid input");
                                    System.out.println("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.next();
                                 }
                                 
                                 valid = (choice < 1 || choice > 6) && choice != -1;
                                 
                                 if (goodData && valid) {
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                              } // while(!goodData)
                           } while (valid);
                        
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
                              
                              do { // repeat to find either 1 or 2 as input for choice
                                 goodData = false;
                                 valid = false;
                              
                                 while (!goodData) {  // repeat when input for choice is not an integer
                                    try{
                                       walletChoice = sc.nextInt();
                                       goodData = true;
                                    } catch (InputMismatchException ix) {
                                       System.out.println("Error, invalid input");
                                       System.out.println("\nEnter your choice (or -1 to go back): ");
                                       flush = sc.next();
                                    }
                                 
                                    valid = (walletChoice < 1 || walletChoice > 2) && walletChoice != -1;
                                 
                                    if (goodData && valid) {
                                       System.out.println("Error, invalid input");
                                       System.out.print("\nEnter your choice (or -1 to go back): ");
                                    }
                                 } // while(!goodData)
                              } while (valid);
                              
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
                                 default:
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
                           
                           System.out.print("Please take a look at the map of our city and enter your location your row coordinate (e.g A, B, C): ");
                           String locationX = sc.next();
                           System.out.print("Now please enter your column coordinate (e.g 0, 1, 2, 3): ");
                           int locationY = sc.nextInt();
                           
                           //while ((location.charAt(0) > 'E' || location.charAt(0) < 'A') && (location.charAt(1) < '0' || location.charAt(1) > '4') && !location.equals("-1")){ // loop while input is not A-E and 0-4 and not -1
                           while( !cdd.getMap().doesPositionExist(locationX.charAt(0)-64, locationY) && !(locationX.equals("-1")) && !(locationY==-1)) //Loop while the position is invalid and the location isn't -1  
                           {
                              System.out.print("Error, invalid location combination. Try again, row: ");
                              locationX = sc.next();
                              System.out.print("Column: ");
                              locationY = sc.nextInt();
                           }
                           
                           if (locationX.equals("-1") || locationY==-1){   // will make program go back to customer panel
                              continuePanel = false;
                           }
                           else {                        // if location is valid 
                              curCustomer.addPosition(locationX.charAt(0)-64, locationY);
                              System.out.println("===============================================");
                              System.out.println("                 ORDER MENU");
                              System.out.println("================================================");                              
                              System.out.println("1. Find Restaurant by Name");
                              System.out.println("2. Find Restaurant by Item");
                              System.out.println("3. Find Restaurant by Filtering");
                              
                              
                              System.out.print("Enter your choice (or -1 to go back): ");
                              int choiceOrder = sc.nextInt();
                              
                              while (choiceOrder != -1 && (choiceOrder < 1 || choiceOrder > 3)){ // loop while their choice is not 1-3 and not -1
                                 System.out.println("\nError, invalid input.");
                                 System.out.print("Enter your choice (or -1 to go back): ");
                                 choiceOrder = sc.nextInt();
                              }
                              
                              boolean selectRestaurant = false;
                              int restaurantID = -1;
                              //there should be a loop or something that lets u select the restaurant, and only once the restaurant is selected
                              //the program should proceed and at that point, it should print the entire menu.
                              
                              
                              switch (choiceOrder) {
                                                            
                                 case 1:               // find restaurant by name
                                 
                                 
                                    System.out.print("Enter Restaurant Name (or -1 to go back): ");
                                    String resName = sc.next();
                                    while (!cdd.doesRestaurantExist(resName) && !resName.equals("-1")){  // loop while restaurant name doesnt exist and input isnt -1
                                       System.out.println("Error, restaurant does not exist");
                                       System.out.print("Enter Restaurant Name (or -1 to go back): ");
                                       resName = sc.next();
                                    }
                                    
                                    if (resName.equals("-1"))     // if input is -1 program goes back to location input
                                       continueLocation = false;
                                    else 
                                    {                        // if restaurant name is valid
                                    
                                       restaurantID = cdd.findRestaurantIndexByName(resName);
                                       
                                    }
                                    break;
                                 case 2:               // find restaurant by item
                                    System.out.print("Enter the name of the Item (or -1 to go back): ");
                                    String itemName = sc.next();
                                    // Loop through cdd.getAllRestaurants()
                                    // then do cdd.getAllRestaurants()[i].hasItem( itemName ) which returns a boolean
                                    
                                    break;
                                 case 3:               // find restaurant by filtering
                                    break;
                                 case -1:
                                    continueLocation = false;                                    
                                    break;
                              }
                           }
                        } while (!continueLocation);
                        break;
                     case 4:                                                        // view order history
                        break;
                     case 5:                                                        // view active deliveries
                        break;
                     case 6:
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
                     try
                     {
                        choice = sc.nextInt();
                        flush = sc.nextLine();
                        goodData = true;
                     } 
                     catch (InputMismatchException ix) 
                     {
                        goodData = false;
                        System.out.println("Error, invalid input");
                        System.out.print("\nEnter your choice (or -1 to go back): ");
                        flush = sc.nextLine();
                     }
                     valid = (choice >= 1 && choice <= 7) || choice == -1; // valid input condition 
                     if (goodData && !valid)
                     {
                        System.out.println("Error, invalid input");
                        System.out.print("\nEnter your choice (or -1 to go back): ");
                     }
                     proceed = choice != -1;
                  } // while(!goodData)
                  
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
                                 try
                                 {
                                    choice = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = choice != -1;
                              } // while(!goodData)
                           
                              if (proceed)
                              {
                                 switch (choice)
                                 {
                                    case 1:   // change name
                                       System.out.print("Enter New Name: ");
                                       name = sc.nextLine();
                                       if (!name.equals("-1"))
                                       {
                                          cdd.user().setName(name);
                                          proceed = false;
                                       }
                                       break;
                                    case 2:   // change username
                                       System.out.print("Enter New Username: ");
                                       name = sc.nextLine();
                                       if (!name.equals("-1"))
                                       {
                                          cdd.user().changeUsername(name);
                                          proceed = false;
                                       }
                                       break;
                                    case 3:   // change password
                                       System.out.print("Enter New Password: ");
                                       password = sc.nextLine();
                                       if (!password.equals("-1"))
                                       {
                                          cdd.user().changePassword(password);
                                          proceed = false;
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
                                 try
                                 {
                                    choice = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = choice != -1;
                              } // while(!goodData)
                           
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
                                             try
                                             {
                                                rating = sc.nextDouble();
                                                flush = sc.nextLine();
                                                goodData = true;
                                             } 
                                             catch (InputMismatchException ix) 
                                             {
                                                goodData = false;
                                                System.out.println("Error, invalid input");
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                                flush = sc.nextLine();
                                             }
                                             valid = (rating >= 0 && rating <= 5) || rating == -1; // valid input condition 
                                             if (goodData && !valid)
                                             {
                                                System.out.println("Error, invalid input");
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                             }
                                          } // while(!goodData)
                                          
                                          if (rating != -1)
                                          {
                                             System.out.print("Enter Number of Ratings the Restaurant Has: ");
                                             int numRat = 0;
                                          
                                             goodData = false;
                                             valid = false;
                                          
                                             while (!goodData || !valid)    // repeat when input for choice is not an integer
                                             {
                                                try
                                                {
                                                   numRat = sc.nextInt();
                                                   flush = sc.nextLine();
                                                   goodData = true;
                                                } 
                                                catch (InputMismatchException ix) 
                                                {
                                                   goodData = false;
                                                   System.out.println("Error, invalid input");
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   flush = sc.nextLine();
                                                }
                                                valid = numRat >= 0 || numRat == -1; // valid input condition 
                                                if (goodData && !valid)
                                                {
                                                   System.out.println("Error, invalid input");
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                }
                                             } // while(!goodData)
                                                            
                                             if (numRat != -1)
                                             {
                                                System.out.print("Enter Restaurant PositionX: ");
                                                int positionX = 0;
                                             
                                                goodData = false;
                                                valid = false;
                                             
                                                while (!goodData || !valid)    // repeat when input for choice is not an integer
                                                {
                                                   try
                                                   {
                                                      positionX = sc.nextInt();
                                                      flush = sc.nextLine();
                                                      goodData = true;
                                                   } 
                                                   catch (InputMismatchException ix) 
                                                   {
                                                      goodData = false;
                                                      System.out.println("Error, invalid input");
                                                      System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      flush = sc.nextLine();
                                                   }
                                                   valid = (positionX >= 0 && positionX <= 10) || positionX == -1; // valid input condition 
                                                   if (goodData && !valid)
                                                   {
                                                      System.out.println("Error, invalid input");
                                                      System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   }
                                                } // while(!goodData)
                                             
                                                if (positionX != -1)
                                                {
                                                   System.out.print("Enter Restaurant PositionY: ");
                                                   int positionY = 0;
                                                
                                                   goodData = false;
                                                   valid = false;
                                                
                                                   while (!goodData || !valid)    // repeat when input for choice is not an integer
                                                   {
                                                      try
                                                      {
                                                         positionY = sc.nextInt();
                                                         flush = sc.nextLine();
                                                         goodData = true;
                                                      } 
                                                      catch (InputMismatchException ix) 
                                                      {
                                                         goodData = false;
                                                         System.out.println("Error, invalid input");
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                         flush = sc.nextLine();
                                                      }
                                                      valid = (positionY >= 0 && positionY <= 10) || positionY == -1; // valid input condition 
                                                      if (goodData && !valid)
                                                      {
                                                         System.out.println("Error, invalid input");
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      }
                                                   } // while(!goodData)
                                                
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
                                       try
                                       {
                                          resID = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (resID >= 1 && resID <= cdd.getNumRestaurants()) || resID == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // while(!goodData);
                                 
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
                                                try
                                                {
                                                   rating = sc.nextDouble();
                                                   flush = sc.nextLine();
                                                   goodData = true;
                                                } 
                                                catch (InputMismatchException ix) 
                                                {
                                                   goodData = false;
                                                   System.out.println("Error, invalid input");
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   flush = sc.nextLine();
                                                }
                                                valid = (rating >= 0 && rating <= 5) || rating == -1; // valid input condition 
                                                if (goodData && !valid)
                                                {
                                                   System.out.println("Error, invalid input");
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                }
                                             } // while(!goodData);
                                          
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
                                 try
                                 {
                                    choice = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = choice != -1;
                              } // while(!goodData)
                           
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
                                       try
                                       {
                                          id = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = id >= 1 || id == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // while(!goodData)
                                 
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
                                                   try
                                                   {
                                                      positionX = sc.nextInt();
                                                      flush = sc.nextLine();
                                                      goodData = true;
                                                   } 
                                                   catch (InputMismatchException ix) 
                                                   {
                                                      goodData = false;
                                                      System.out.println("Error, invalid input");
                                                      System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      flush = sc.nextLine();
                                                   }
                                                   valid = (positionX >= 1 && positionX <= 10) || positionX == -1; // valid input condition 
                                                   if (goodData && !valid)
                                                   {
                                                      System.out.println("Error, invalid input");
                                                      System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   }
                                                } // while(!goodData)
                                             
                                                if (positionX != -1)
                                                {
                                                   System.out.print("Enter Driver PositionY: ");
                                                   int positionY = 0;
                                                
                                                   goodData = false;
                                                   valid = false;
                                                
                                                   while (!goodData || !valid)    // repeat when input for choice is not an integer
                                                   {
                                                      try
                                                      {
                                                         positionY = sc.nextInt();
                                                         flush = sc.nextLine();
                                                         goodData = true;
                                                      } 
                                                      catch (InputMismatchException ix) 
                                                      {
                                                         goodData = false;
                                                         System.out.println("Error, invalid input");
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                         flush = sc.nextLine();
                                                      }
                                                      valid = (positionY >= 1 && positionY <= 10) || positionY == -1; // valid input condition 
                                                      if (goodData && !valid)
                                                      {
                                                         System.out.println("Error, invalid input");
                                                         System.out.print("\nEnter your choice (or -1 to go back): ");
                                                      }
                                                   } // while(!goodData)
                                                
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
                                       try
                                       {
                                          id = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (id >= 1 && id <= cdd.getNumDrivers()) || id == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // while(!goodData)
                                 
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
                                       try
                                       {
                                          id = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (id >= 1 && id <= cdd.getNumDrivers()) || id == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // while(!goodData)
                                 
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
                                 try
                                 {
                                    choice = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = choice != -1;
                              } // while(!goodData)
                           
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
                                          try
                                          {
                                             dis = sc.nextDouble();
                                             flush = sc.nextLine();
                                             goodData = true;
                                          } 
                                          catch (InputMismatchException ix) 
                                          {
                                             goodData = false;
                                             System.out.println("Error, invalid input");
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                             flush = sc.nextLine();
                                          }
                                          valid = (dis >= 0 && dis <= 1) || dis == -1; // valid input condition 
                                          if (goodData && !valid)
                                          {
                                             System.out.println("Error, invalid input");
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                          }
                                       } // while(!goodData)
                                    
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
                                       try
                                       {
                                          id = sc.nextInt();
                                          flush = sc.nextLine();
                                          goodData = true;
                                       } 
                                       catch (InputMismatchException ix) 
                                       {
                                          goodData = false;
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                          flush = sc.nextLine();
                                       }
                                       valid = (id >= 1 && id <= cdd.getNumCoupons()) || id == -1; // valid input condition 
                                       if (goodData && !valid)
                                       {
                                          System.out.println("Error, invalid input");
                                          System.out.print("\nEnter your choice (or -1 to go back): ");
                                       }
                                    } // while(!goodData)
                                    
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
                                             try
                                             {
                                                dis = sc.nextDouble();
                                                flush = sc.nextLine();
                                                goodData = true;
                                             } 
                                             catch (InputMismatchException ix) 
                                             {
                                                goodData = false;
                                                System.out.println("Error, invalid input");
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                                flush = sc.nextLine();
                                             }
                                             valid = (dis >= 0 && dis <= 1) || dis == -1; // valid input condition 
                                             if (goodData && !valid)
                                             {
                                                System.out.println("Error, invalid input");
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                             }
                                          } // while(!goodData)
                                          
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
                                 try
                                 {
                                    resID = sc.nextInt();
                                    flush = sc.nextLine();
                                    goodData = true;
                                 } 
                                 catch (InputMismatchException ix) 
                                 {
                                    goodData = false;
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                    flush = sc.nextLine();
                                 }
                                 valid = (resID >= 1 && resID <= cdd.getNumRestaurants()) || resID == -1; // valid input condition 
                                 if (goodData && !valid)
                                 {
                                    System.out.println("Error, invalid input");
                                    System.out.print("\nEnter your choice (or -1 to go back): ");
                                 }
                                 proceed = resID != -1;
                              } // while(!goodData)
                              
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
                                    try
                                    {
                                       choice = sc.nextInt();
                                       flush = sc.nextLine();
                                       goodData = true;
                                    } 
                                    catch (InputMismatchException ix) 
                                    {
                                       goodData = false;
                                       System.out.println("Error, invalid input");
                                       System.out.print("\nEnter your choice (or -1 to go back): ");
                                       flush = sc.nextLine();
                                    }
                                    valid = (choice >= 1 && choice <= 3) || choice == -1; // valid input condition 
                                    if (goodData && !valid)
                                    {
                                       System.out.println("Error, invalid input");
                                       System.out.print("\nEnter your choice (or -1 to go back): ");
                                    }
                                 } // while(!goodData)
                                 
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
                                             try
                                             {
                                                price = sc.nextDouble();
                                                flush = sc.nextLine();
                                                goodData = true;
                                             } 
                                             catch (InputMismatchException ix) 
                                             {
                                                goodData = false;
                                                System.out.println("Error, invalid input");
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                                flush = sc.nextLine();
                                             }
                                             valid = (price > 0) || price == -1; // valid input condition 
                                             if (goodData && !valid)
                                             {
                                                System.out.println("Error, invalid input");
                                                System.out.print("\nEnter your choice (or -1 to go back): ");
                                             }
                                          } // while(!goodData)
                                       
                                          if (price != -1)
                                          {
                                             cdd.getRestaurants()[resID - 1].addItem(name, price);
                                             proceed = false;
                                          }
                                       }
                                       break;
                                    case 2:   // view menu  /////////////////////not complete///////////////////////////
                                       System.out.println(cdd.getRestaurants()[resID - 1].printMenu());
                                       System.out.print("Enter Item ID: ");
                                       int itemID = 0;
                                       while (!goodData || !valid)    // repeat when input for choice is not an integer
                                       {
                                          try
                                          {
                                             itemID = sc.nextInt();
                                             flush = sc.nextLine();
                                             goodData = true;
                                          } 
                                          catch (InputMismatchException ix) 
                                          {
                                             goodData = false;
                                             System.out.println("Error, invalid input");
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                             flush = sc.nextLine();
                                          }
                                          valid = (itemID >= 1 && itemID <= cdd.getRestaurants()[resID - 1].numItem) || itemID == -1; // valid input condition 
                                          if (goodData && !valid)
                                          {
                                             System.out.println("Error, invalid input");
                                             System.out.print("\nEnter your choice (or -1 to go back): ");
                                          }
                                       } // while(!goodData)
                                          
                                       flush = sc.nextLine();
                                       System.out.println (itemID);
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
                                                try
                                                {
                                                   price = sc.nextDouble();
                                                   flush = sc.nextLine();
                                                   goodData = true;
                                                } 
                                                catch (InputMismatchException ix) 
                                                {
                                                   goodData = false;
                                                   System.out.println("Error, invalid input");
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                   flush = sc.nextLine();
                                                }
                                                valid = price >= 0 || price == -1; // valid input condition 
                                                if (goodData && !valid)
                                                {
                                                   System.out.println("Error, invalid input");
                                                   System.out.print("\nEnter your choice (or -1 to go back): ");
                                                }
                                             } // while(!goodData)
                                          
                                             if (price != -1)
                                             {
                                                cdd.getRestaurants()[resID - 1].editItem(cdd.getRestaurants()[resID - 1].menu[itemID - 1], name, price);
                                                proceed = false;
                                             }
                                          }
                                       }
                                       break;
                                    case 3:   // delete food
                                       System.out.println(cdd.getRestaurants()[resID - 1].printMenu());
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
                              try
                              {
                                 choice = sc.nextInt();
                                 flush = sc.nextLine();
                                 goodData = true;
                              } 
                              catch (InputMismatchException ix) 
                              {
                                 goodData = false;
                                 System.out.println("Error, invalid input");
                                 System.out.print("\nEnter your choice (or -1 to end program): ");
                                 flush = sc.nextLine();
                              }
                              valid = choice == -1; // valid input condition 
                              if (goodData && !valid)
                              {
                                 System.out.println("Error, invalid input");
                                 System.out.print("\nEnter your choice (or -1 to end program): ");
                              }
                           } // while(!goodData)
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