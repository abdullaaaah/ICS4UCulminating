public class User extends Person
{
   protected String username;
   protected String password;
   
   // Constructor //////////////////////////////////////////////////////////////////
   public User (int id, String name, String username, String password)
   {
      super (id, name);
      this.username = username;
      this.password = password;
   }
}