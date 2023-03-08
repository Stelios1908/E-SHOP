
public class ItemOrdered
{
    private Item item;
    private int quantity;
  public ItemOrdered(Item item,int quantity)
  {
        this.item=item;
        this.quantity=quantity;
  }
    
  public int getQuantity() {return quantity;}
  public   int getStock()
  {
      return item.getStock(); //pithano lathos to item.
  } 
  public int getID()
  {
      return item.getID();
  }
  public String getName()
  {
     return item.getName();
  }
  public double getPrice() 
  {
     return item.getPrice();
  }
    public void setQuantity(int q) {quantity+=q;}
    public void setStock(int stock) {item.setStock(stock);}
} 

    
 