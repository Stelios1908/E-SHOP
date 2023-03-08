//import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws QuantityExist, inputMismatchException
    {
    	  Owner owner=new Owner("STELIOS","siderisstil@gmail.com");
          EShop eshop=new EShop("FRE-eshop",owner);
        
          eshop.addBuyer(new Buyer("petros","emetaxakis@gmail.com",eshop));//,shc2)
          eshop.addBuyer(new Buyer("jim","dimetaxakis@gmail.com",eshop));//,shc)
          
          
          eshop.addItem(new Pen("bic",2.00,"anexitilos",10,3847564,"blue",3.3));
          eshop.addItem(new Pen("pilot",2.50,"asimenios",11,4837465,"blue",3.2));
          eshop.addItem(new Pen("bic",2.00,"epixrisos",12,4857364,"black",3.3));
          
          eshop.addItem(new Pencil("bic",0.60,"lepto",10,8345344,3.2,"H"));
          eshop.addItem(new Pencil("stic",0.56,"xontro",11,57648374,3.2,"HS"));
          eshop.addItem(new Pencil("flip",0.50,"malako",12,4758754,3.2,"S"));
          
          eshop.addItem(new Paper("blue",0.30,"lepto",10,48736887,40,30));
          eshop.addItem(new Paper("cit",0.40,"malako",11,83344,40,40));
          eshop.addItem(new Paper("bol",0.60,"lepto",12,383733,40,50));
          
          eshop.addItem(new Notebook("iblue",2.60,"mayro",10,383722,4));
          eshop.addItem(new Notebook("fenix",2.60,"kokkino",11,4437263,5));
          eshop.addItem(new Notebook("moitoi",1.20,"kitrino",12,3844263,2));
         
          
          eshop.getBuyerByEmail("emetaxakis@gmail.com").placeOrder(13847564,3);
          eshop.getBuyerByEmail("emetaxakis@gmail.com").placeOrder(14837465,1);
          eshop.getBuyerByEmail("emetaxakis@gmail.com").placeOrder(14857364,4);
          eshop.getBuyerByEmail("emetaxakis@gmail.com").placeOrder(28345344,2);
          eshop.getBuyerByEmail("emetaxakis@gmail.com").placeOrder(24758754,1);
          eshop.getBuyerByEmail("emetaxakis@gmail.com").placeOrder(4383722,2);
          
          eshop.getBuyerByEmail("dimetaxakis@gmail.com").placeOrder(13847564,5);
          eshop.getBuyerByEmail("dimetaxakis@gmail.com").placeOrder(14837465,1);
          eshop.getBuyerByEmail("dimetaxakis@gmail.com").placeOrder(14857364,2);
          eshop.getBuyerByEmail("dimetaxakis@gmail.com").placeOrder(4383722,2);
          eshop.getBuyerByEmail("dimetaxakis@gmail.com").placeOrder(24758754,2);
          eshop.getBuyerByEmail("dimetaxakis@gmail.com").placeOrder(4383722,2);
          
          
          
        
        Menu m=new Menu(owner,eshop);
 
     while(true)    
    	 {
    	 m.mainMenu(m.userVerification(m),m);
    	 }
       
    }
}