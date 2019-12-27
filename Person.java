public abstract class Person
{
   protected String name;
   
   // Constructor ////////////////////////////////////////////
   public Person (String name)
   {
      this.name = name;
   }
   
   // Functions ////////////////////////////////////////////////
   public void setName(String name)
   {
      this.name = name;
   }
   ///////////////////////////////////////////
   public String getName()
   {
      return name;
   }
   ////////////////////////////////////////
   public abstract String toString();

}