 
public abstract class Item
{
    private String name;
    private double price;
    private String description;
    private  int stock;
    private int ID;
    
    public Item(String name,double price,String description,int stock,int ID)
    {
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
        this.ID=ID;
    }
    
    public String getBasicInfo()
    {
    return "name: "+name+"\ntimi: "+price+"\nperigrafi: "+description+"\ntemaxia se apothema: "+stock+"\nID :"+ID+"\n============================";
    }
    public abstract  String getDetails();
    
    public String toString()
    {
        return "=========================\nplirofories proiontos :\n" +getBasicInfo() +getDetails();
    }
    
    public static int concatId(int a, int b)
    {
       if ( b == 0 )
          a *= 10;
       else
       {
          int tempB = b;
          while ( tempB > 0 )
          {
             tempB /= 10;
             a *= 10;
          }
       }
       return a + b;
    }
 
    
    
    //getter
    
    public  int getStock() {
    	return stock;
    }
     
    public int getID() {
    	return ID;
    }
    
    public String getName() {
    	return name;
    }
    public double getPrice() {
    	return price;
    }
    
   //setter
    
    public  void setStock(int stock) {
    	this.stock=stock;
    }
    
    
} 
 