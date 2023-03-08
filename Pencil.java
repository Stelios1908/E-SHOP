public  class Pencil extends Item
{
    private double tipSize;
    private String type;
    
    public Pencil(String name,double price,String description,int stock,int ID,double tipSize,String type)
    {
      super(name,price,description,stock,concatId(2,ID));
      this.tipSize=tipSize;
      this.type=type;
    }
    
    public String getDetails()
    {
        return "\nmegethos mitis se mm :"+tipSize +"typos :"+type+"\n===================";
    }
} 