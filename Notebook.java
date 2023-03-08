public  class Notebook extends Item
{
    private int section;
   public  Notebook(String name,double price,String description,
   int stock,int ID,int section)
   {
       super(name,price,description,stock,concatId(4,ID));
       this.section=section;
   }
    
   public String getDetails()
   {
       return "\narithmos thematwn :"+section+"\n======================\n";
    }
}