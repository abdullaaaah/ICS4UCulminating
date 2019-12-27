public class User extends Person
{
   protected String username;
   protected String password;
   
   // Constructor //////////////////////////////////////////////////////////////////
   public User (String name, String username, String password)
   {
      super (name);
      this.username = username;
      this.password = password;
   }
   
   // Functions //////////////////////////////////////////////////////
   public boolean isUsernameValid (String username)
   {
      return username.length() < 16;
   }
   /////////////////////////////////////////
   public boolean isPasswordValid (String password)
   {
      return password.length() < 6;
   }
   //////////////////////////////////////////
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
   public void changeUsername (String username)
   {
      if (isUsernameValid(username))
      {
         this.username = username;
      }
   }
   ///////////////////////////////////////////////
   public void changePassword (String password)
   {
      if (isPasswordValid(password))
      {
         this.password = password;
      }
   }
   /////////////////////////////////////////
   public String toString ()
   {
      return name + username;
   }
}