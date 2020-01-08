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
                              int choiceOrder = sc.nextInt();
                              
                              while (choiceOrder != -1 && (choiceOrder < 1 || choiceOrder > 3)){ // loop while their choice is not 1-3 and not -1
                                 System.out.println("\nError, invalid input.");
                                 System.out.print("Enter your choice (or -1 to go back): ");
                                 choiceOrder = sc.nextInt();
                              }
                              
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
                                    else {                        // if restaurant name is valid
                                       System.out.println(cdd.getRestaurants()[cdd.findRestaurantIndexByName(resName)].getMenu()); // gets restaurant menu
                                       System.out.println("\nEnter the number for the item you would like to add,");
                                       System.out.print("or 0 if you are finished, or -1 to cancel order and go back: ");
                                       int choiceItem = sc.nextInt();   // item # that customer chooses
                                       
                                       
                                       
                                       
                                       
                                       
                                    }
                                    break;
                                 case 2:               // find restaurant by item
                                    System.out.print("Enter the name of the Item (or -1 to go back): ");
                                    String itemName = sc.next();
                                    
                                    break;
                                 case 3:               // find restaurant by filtering
                                    break;
                                 case -1:
                                    continueLocation = false;                                    
                                    break;
                              }
                           }
                        } while (!continueLocation);