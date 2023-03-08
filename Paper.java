public   class Paper extends Item
{
    private int weight;
    private int pages;
    
    public Paper(String name,double price,String discription,int stock,int ID,int weigth,int pages)
    {
        super(name,price,discription,stock,concatId(3,ID));
        this.weight=weigth;
        this.pages=pages;
    }
    
    public String getDetails() {
    	return "\nvaros: "+weight+" selides: "+pages+"\n===========================\n";
    }
} 