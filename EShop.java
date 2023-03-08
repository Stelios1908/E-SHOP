import static java.lang.Math.pow;

import java.util.ArrayList;
public  class EShop
{
    
    private String name;
    private Owner owner;
    private ArrayList<Item> itemsList=new ArrayList<Item>();
    private ArrayList<Buyer> buyerList=new ArrayList<Buyer>();
    //private HashMap<Integer,Buyer> buyerList=new HashMap<Integer,Buyer>();
    
    public EShop(String name,Owner owner)
    {
       this.name=name;
       this.owner=owner;
       
    }
    public boolean checkStock(int ID,int quantity) //elegxei to stock (dikh mas methodos)
    {
        boolean itemExist=false;//flag euresis item
        boolean stockExist=false;//flag eparki posotitas
        int x=0;
        for(Item i:itemsList)
        {
            if(i.getID()==ID)
            {
            itemExist =true;
            if(i.getStock()>=quantity)
           stockExist=true;
            else
            x=i.getStock();
            }
            
        }
        if(!(itemExist))
        System.out.println("dem yparxei to proion");
        else if(!( stockExist))
        System.out.println("exoume diathesima "+x+" temaxia,den kaliptoyn thn paragelia");
        
        return  stockExist;
    }
    
    public void addItem(Item item)
    { 
        boolean itemFound=false;
        for(Item i:itemsList)
        {
          if(item.getID()==i.getID()) {
          System.out.println("to antikeimeno yparxei sthn lista");
          itemFound=true;
          }
        }
          if(!(itemFound))   itemsList.add(item);
    }
    
    public Item getItemById(int ID)
    {
       Item a=null;

       for(Item i:itemsList)
        {
        if(ID==i.getID())
           {
               a=i;
               break;
          }
       } 
       
       if(a==null) {
    	   System.out.println("To proion den vrethike");
    	   return a;
       }
       else  return a;
    }
    public void removeItem(int ID)
    {
        boolean itemExists=false;
        for(Item i:itemsList)
        {
            if(ID==i.getID())
            {
            itemsList.remove(i);
            itemExists=true;
            break;
            }
        }
        if(!(itemExists))
        System.out.println("to proion den vrethike");
    }
    public void addBuyer(Buyer buyer)
    {
        boolean BuyerExists=false;
        for(Buyer i:buyerList)
        {
           if(i.getEmail()==buyer.getEmail())
           {
           System.out.println("o user  me email :"+buyer.getEmail() +"einai egegramenos");
           BuyerExists=true;
           break;
           }
        } 
        if(!(BuyerExists)) 
        buyerList.add(buyer);
        
    }
        
    public void removeBuyer(Buyer buyer)
    {
        boolean buyerExists=false;
        for(Buyer i:buyerList)
        { 
              if(i.getEmail()==buyer.getEmail())
               {
                 buyerList.remove(buyer);
                 System.out.println("Deleting...");
                 buyerExists=true;
                 break;
               }
        }
        if(!(buyerExists))
        System.out.println("o user den yparxei sthn lista pelatwn gia na aferethei");
    }
    public void updateItemStock(int ID,int a)
    {
        boolean itemFound=false;
        for(Item i:itemsList)
        {
            if(i.getID()==ID) {
            i.setStock(a);
            itemFound=true;
            System.out.println("The item with ID: "+ID+" was successfully updated to "+i.getStock()+" pieces\n");
            }
        }
        if(!(itemFound))
        System.out.println("to proion den yparxei stin lista");
    }
    public void showCategories()
    {
        System.out.println("Katigories proiontwn:");
       	System.out.println("1:Pen("+itemQuantity(1)+")\n2:Pencil("+itemQuantity(2)+")\n3:Paper("+itemQuantity(3)+")\n4:Notebook("+itemQuantity(4 )+")\n"); 
    }
    public boolean showProduct(int ID) throws ProdIdNotFoundException
    {
        boolean productFound=false;
        for(Item i:itemsList)
        {
            if(i.getID()==ID)
            {
            	String details=i.toString();
            	System.out.println(details);
                productFound=true;
                break;
                
            }
        }
        if(!(productFound)) {
        System.out.println("The product with the following ID:"+ID +" wasn't found\n");
        throw new ProdIdNotFoundException();  
        }
        else return productFound;
    }
    
    public boolean showProductsInCategory(int choice) {
    	boolean productFound=false;
    	switch(choice) {
    	case 1:    		 
     		for(Item i: itemsList) {
    			if((i.getID()/ ((int)(pow(10,(int)(Math.log10(i.getID()))))))==1) { //edo pairnoyme to proto pshfio tou id diairontas me dynameis tou 10 sthn n-1 opoy n akeraia pshfia tou ID
    				 System.out.println("Name: "+i.getName()+"\tID: "+i.getID()+"\nStock: "+i.getStock());
    				 productFound=true;
    			}
     		}
     		if (!productFound) System.out.println("No such product was found on the list");
     		return productFound;
     	
    	case 2:
    		for(Item i: itemsList) {
    			if((i.getID()/((int)(pow(10,(int)Math.log10(i.getID())))))==2) {
    				 System.out.println("Name: "+i.getName()+"\tID: "+i.getID()+"\nStock: "+i.getStock());
    				 productFound=true;
    			}
    		}
    		if (!productFound) System.out.println("No such product was found on the list");
    		return productFound;
   
    	case 3:
    		for(Item i: itemsList) {
    			if((i.getID()/((int)(pow(10,(int)Math.log10(i.getID())))))==3) {
    				 System.out.println("Name: "+i.getName()+"\tID: "+i.getID()+"\nStock: "+i.getStock());
    				 productFound=true;
    			}
    		}
    		if (!productFound) System.out.println("No such product was found on the list");
    		return productFound;
    	
    	case 4:
    		for(Item i: itemsList) {
    			if((i.getID()/((int)(pow(10,(int)Math.log10(i.getID())))))==4) {
    				 System.out.println("Name: "+i.getName()+"\tID: "+i.getID()+"\nStock: "+i.getStock());
    				 productFound=true;
    			}
    		}
    		if (!productFound) System.out.println("No such product was found on the list");
    		return productFound;
    	
    	default:
    		System.out.println("The input we received doesn't correspond to a product in the list\n");	
    		return productFound;
    	
    	}
    }
    
    public int itemQuantity(int Id) { //metraei sthn itemsList to kathe antikeimeno
    	int quantity = 0;
    	for(Item i: itemsList) {
    	if((i.getID()/((int)(pow(10,(int)(Math.log10(i.getID()))))))==Id)
    	quantity+=i.getStock();    	
    	}
    	return quantity;
    }
    
    
    public void checkStatus()
    {
    	int cnt=1;
        System.out.println("Lista pelatvn ana katigoria ponton");
        for(Buyer  i:buyerList)
        {
          System.out.println("=============================================================================================\n"
        +cnt+")onoma :"+i.getName()+"\t\tpontoi :"+i.getBonus()
            +"\tkatigoria :"+i.getCategory()+"\temail: "+i.getEmail()+
            "\n=============================================================================================\n");
          cnt++;
        }
        if(buyerList.size()==0)
        System.out.println("THE LIST IS EMPTY");
    }
    
    public boolean findBuyerByEmail(String email) {
    	boolean buyerExists=false;
    	
    	for(Buyer i: buyerList) {
    		if(i.getEmail().contentEquals(email)) {
    		     buyerExists=true;
    		}
    	}
    	return(buyerExists);
    }
  
    //getters
    public String getName() {
    	return name;
    }
    
    public Buyer getBuyerByEmail(String email) {
    	boolean buyerFound=false;
    	Buyer b=null;
    	for(Buyer i: buyerList) {
    		if(i.getEmail().contentEquals(email)) {
    			buyerFound=true;
    			b=i;
    			break;
    		}
    	
    	}
    	if(!buyerFound) {
    		System.out.println("There is no buyer in the list with the email given.");
    		return null;
    	}
    	else return b;
    }
    
} 