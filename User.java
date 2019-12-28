/*
   CLASS NAME: User
   AUTHOR:     Oliver Huang
   DATE:       12/26/2019
   SCHOOL:     AY Jackson Secondary School
   PURPOSE:    A class that stores each user's information
*/

public class User extends Person
{
   protected String username;
   protected String password;
   
   // Constructor //////////////////////////////////////////////////////////////////
   /*
      PARAMETERS:    N/A
      PURPOSE:       Creat User object
   */
   public User (String name, String username, String password)
   {
      super (name);
      this.username = username;
      this.password = password;
   }
   
   
   public String getUsername()
   {
      return this.username;
   }
   
   public String getPassword()
   {
      return this.password;
   }
   
   // Functions //////////////////////////////////////////////////////
   /*
      PARAMETERS:    username
      RETURN VALUE:  boolean
      PURPOSE:       Check if username meets requirments
   */
   public boolean isUsernameValid (String username)
   {
      return username.length() < 16;
   }
   /////////////////////////////////////////
   /*
      PARAMETERS:    password
      RETURN VALUE:  boolean
      PURPOSE:       Check if password meets requirments
   */
   public boolean isPasswordValid (String password)
   {
      return password.length() < 6;
   }
   //////////////////////////////////////////
   /*
      PARAMETERS:    username, password
      RETURN VALUE:  boolean
      PURPOSE:       Check if password-input matches password-in-file
   */
   public boolean checkAuth (String username, String password)
   {
      if (username == this.username)
      {
         String temp = "";
         for (int i = 0; i < password.length(); i++)
         {
            temp = temp + (password.charAt(i) + 5);
         }
         return temp == this.password;
      }
      return false;
   }
   ///////////////////////////////////////////////
   /*
      PARAMETERS:    username
      RETURN VALUE:  void
      PURPOSE:       Update username
   */
   public void changeUsername (String username)
   {
      if (isUsernameValid(username))
      {
         this.username = username;
      }
   }
   ///////////////////////////////////////////////
   /*
      PARAMETERS:    password
      RETURN VALUE:  void
      PURPOSE:       Update password
   */
   public void changePassword (String password)
   {
      if (isPasswordValid(password))
      {
         this.password = password;
      }
   }
   /////////////////////////////////////////
   /*
      PARAMETERS:    N/A
      RETURN VALUE:  String
      PURPOSE:       Output user info
   */
   public String toString ()
   {
      return name + "/n" + username;
   }
}