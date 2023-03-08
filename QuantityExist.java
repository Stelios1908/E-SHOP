import java.util.Scanner;

import java.util.Scanner;

@SuppressWarnings("serial")
public class QuantityExist extends Exception {
    private ShoppingCart shcart;
    private int quantity=0;
    private int fquantity;
    
	QuantityExist(int ID,ShoppingCart shcart){
		super("Insufficient Quantity");
		this.shcart=shcart;
    	fquantity=correctQuantity(ID);    	
    }
    
    public int correctQuantity(int ID) {
    do {	
    	Scanner in= new Scanner(System.in);
    	System.out.println("Please enter again: ");
    	 quantity=in.nextInt();
    }while((quantity+shcart.getQuantityById(ID))<0);
    return quantity;
}
    
    public int getFQuantity() {
    	return fquantity;
    }
}
	