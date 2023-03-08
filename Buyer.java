
public class Buyer extends User{
	private int bonus;
	private String buyerCategory;
	private ShoppingCart shCart;

	
	
	public Buyer(String name,String email,EShop eshop) {
		super(name,email);
		this.bonus=0;
		this.buyerCategory="bronze";
		this.shCart=new ShoppingCart(eshop);
	}
	
	public void awardBonus( double extra) {
		bonus+=extra;
		setBuyerCategory(bonus);		
	}
	
	public void setBuyerCategory(int bonus) {
		if((bonus>100) && (bonus<=200)) {
			buyerCategory="silver";
		//	this.silverFlag=true;
		}
		else if (bonus>200) {
			buyerCategory="gold";
		//	goldFlag=true;			
		}
	}
	
	public void placeOrder(int ID, int quantity)  {
		try {
			
			shCart.addItemOrdered(ID, quantity);
			
	    } catch (NotAvailableInStock e) {
			System.out.println(e);
		
		}
	}
	
	
	public ShoppingCart getShoppingCart() {
		return shCart;
	}
	
	
	
	//getter
	public int getBonus() {
		return bonus;
	}

	public String getCategory() {
		return buyerCategory;
	}
	
	
}