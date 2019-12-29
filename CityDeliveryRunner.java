import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CityDeliveryRunner
{

   public static void main(String[] args)
   {
      CityDeliveryDatabase cdd = new CityDeliveryDatabase();
      Scanner sc = new Scanner(System.in);
      int initChoice;
      String username = "", password = "";
      boolean login = false, dontGoBack = true, exitProgram = false;
      
      while(!exitProgram)
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
            while(!login && dontGoBack)
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
                  if(password.equals("-1"))
                  dontGoBack = false;
                  
                  login = cdd.login(username, password);
               }
               
            }
         
         }
         else if(initChoice == 2)
         {
            
         }
         else
         {
            System.out.println("Incorrect option");
         }
         
      }
   
   }

}