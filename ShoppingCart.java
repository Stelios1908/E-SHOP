
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
public class ShoppingCart 
{
    //boolean stockExists=false;
    //boolean itemExists=false;
    private ArrayList<ItemOrdered> orderList = new ArrayList<ItemOrdered>();
    private EShop eshop;

    
    public ShoppingCart(EShop eshop)
    {
        this.eshop=eshop;
    }
    
    public void addItemOrdered(int ID,int quantity) throws NotAvailableInStock 
          {
                 boolean flag=false; 
                 boolean shoppingCartExist=false;
                 flag=eshop.checkStock(ID,quantity);
                           
                  if(flag) 
                  {
                      for(ItemOrdered i: orderList)
                      {                  
                          if(i.getID()==ID)
                          {
                          i.setQuantity(quantity);
                          eshop.getItemById(ID).setStock(eshop.getItemById(ID).getStock()-quantity);
                          shoppingCartExist=true;
                          }
                      }
                      if(!(shoppingCartExist))
                      {
                      eshop.getItemById(ID).setStock(eshop.getItemById(ID).getStock()-quantity);
                      orderList.add(new ItemOrdered(eshop.getItemById(ID), quantity));
                      }
                   }
                   else throw new NotAvailableInStock();
         }

    public void removeItemOrdered(int ID)
    {
     eshop.updateItemStock(ID,(eshop.getItemById(ID).getStock() + getQuantityById(ID)));
     orderList.remove(getItemOrderedById(ID));
    }
    
    public void removeItemOrdered(ItemOrdered I,Iterator<ItemOrdered> it)
    { //polymorfismos gia na mhn fame exception
        eshop.updateItemStock(I.getID(),(I.getStock() + I.getQuantity()));
        it.remove();
    }

    
    public int getQuantityById(int ID) {
        int returning=0;
        for (ItemOrdered i: orderList) {
            if(i.getID()==ID) {
                returning=i.getQuantity();
            }
        }
        return returning;
    }
    
    
    
    public void changeItemOrderedQuantity(int ID, int value) throws QuantityExist{
        for(ItemOrdered i: orderList) {
            if(i.getID()==ID) {
                if(i.getStock()>=value)
                    {
                    if((value+i.getQuantity())>=0) {
                        i.setQuantity(value);
                        eshop.updateItemStock(ID,(eshop.getItemById(ID).getStock()-value)); 
                    }else throw new QuantityExist(ID,this);                         
                    }
                else System.out.println("Den yparxei h pososthta sto stock");
            }
        }
        if(getItemOrderedById(ID).getQuantity()==0) orderList.remove(getItemOrderedById(ID));
    }
    
    
    
    
    public void showCart(Buyer buyer) {
        int sum=0;
        int count=0;
        for(ItemOrdered i: orderList) {
            ++count;
            System.out.println(count+")Onoma: "+i.getName()+"\t\tPosotita: "+i.getQuantity()+"\t\tTimh: "+i.getPrice()+"\t\tProductID: "+i.getID()+"\n");
            System.out.println("============================================================================================");
            sum+=i.getQuantity();
        }
        System.out.println("Synolo temaxion: "+sum+" me synoliki timi: "+calculateNet()+"€");
        System.out.println("Metaforika: "+ calculateCourierCost(buyer));
    }
    
    
    public void clearCart() {
        
        Iterator<ItemOrdered> it=orderList.iterator();
        ItemOrdered a=null;
        while(it.hasNext()) {
            a=(ItemOrdered) it.next();
            removeItemOrdered(a,it);
        }

    }
    
    public void checkout(Buyer buyer) {
        Scanner inch=new Scanner(System.in);
        boolean flag=true;
        showCart(buyer);
        while(flag) {
        System.out.println("Procceed to checkout? \n1)Yes\n2)No");
        int n;
        try {
         n=inch.nextInt();
        }
        catch(InputMismatchException e) {
            n=inputMismatchException.getfinall();
        }
        if(n==1) {
            buyer.awardBonus(0.1*calculateNet());
            orderList.clear();
            System.out.println("Your order has been successfully confirmed!");
            flag=false;
            }
        else if(n==2) {
            System.out.println("Your order was not confirmed"); flag=false;
        }
        else System.out.println("Invalid choice,please enter again.");
        }
    }
    
    public double calculateNet() {
        double sum = 0;
        for(ItemOrdered i: orderList) {
            sum+=(i.getPrice()*i.getQuantity());
        }
        return sum;
    }
    
    public double calculateCourierCost(Buyer buyer) {
        switch(buyer.getCategory()) {
        case "bronze":
            if((0.02*calculateNet()<=3)) return 3;
            else return 0.02*calculateNet();
        case "silver":
            return 0.02*calculateNet()*0.5;
        case "gold": 
            return 0;
        default: return 2/100*calculateNet();
        }
    }
    
    
    public boolean isShoppingCartEmpty() { //tsekaroume an to kalathi tou xrhsth einai adeio
        if(orderList.size()==0) return false;
        else return true;
    }
    
    public boolean prodExists(int ID) {
    boolean prodFound=false;    
        for(ItemOrdered i: orderList) {
            if(ID==i.getID()) {
                prodFound=true;
                break;
            }
        }
        return prodFound;
    }
    
    
     public ItemOrdered getItemOrderedById(int ID)
        {
           ItemOrdered a=null;

           for(ItemOrdered i:orderList)
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
    
    
}