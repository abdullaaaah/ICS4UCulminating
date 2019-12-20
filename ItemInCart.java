public class ItemInCart
{
   protected int id;
   protected Item item;
   protected int quantity;
   
   // Constructor ///////////////////////////
   public ItemInCart (int id, Item item, int quantity)
   {
      this.id = id;
      this.item = item;
      this.quantity = quantity;
   }
}