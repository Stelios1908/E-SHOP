public  class Pen extends Item
{
 private String color; 
 private double tipSize;
 
 public Pen(String name,double price,String description,int stock,int ID ,String color,double tipSize)
 {
	 super(name,price,description,stock,concatId(1,ID));
     this.color=color;
     this.tipSize=tipSize;
 }
 
 public String getDetails()
 {
        return "\nxroma :"+color +" megethos mitis se mm :"+tipSize+"\n===========================\n";
 }
}

 
 