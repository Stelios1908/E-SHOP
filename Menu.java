import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Menu
 {
	private String fetch;
	private  EShop eshop;
	private  Owner owner;
	
	Scanner keyboard = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	

	
	public Menu(Owner owner,EShop eshop)
	{
		this.owner=owner;
		this.eshop=eshop;
	  System.out.println("Welcome to our Eshop,where you can buy top notch products" + "\nAre you an existing client?\t(Please enter your email)\n");
	}
	
	public static boolean emailIsValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	
	
	public int userVerification(Menu m) {
		 Scanner in2 = new Scanner(System.in);
		 this.fetch = in2.nextLine();
		 System.out.println("Entered email: "+"'"+fetch+"'"+"\t\tValidating.../");
		 boolean valid=emailIsValid(fetch);
		 if(valid) {
		if (m.getFetch().contentEquals(owner.getEmail())) return 1; 
		 else {
			if (eshop.findBuyerByEmail(getFetch())) return 2;
			else return 3;
		}	
		 }
		 else System.out.println("The email you entered was not valid(code error 4)\nPlease enter again: ");
		 return 4;   
	}
	
	public void mainMenu(int value, Menu m) throws QuantityExist, inputMismatchException  {
	
		switch (value) {
		case 1://owner 
			showOMenu(m);
			break;
		case 2://existing buyer
		showBMenu(m);
		break;
		case 3:// new buyer 
		registerNewBuyer(m);
		break;
		}

		
	}
	
	public void showOMenu(Menu m) 
	 {
	     boolean flag=true;
	     int exit=0;
	  while(flag)
	  {
	     
	     
	      System.out.println("Welcome to "+eshop.getName());
	      System.out.println("Welcome back owner "+owner.getName()
	      +"\nYour Personal info: "+owner.getName()+"\temail address:"+owner.getEmail()+"\n");
	   flag=true;
	   
	   while(flag) //megalo
	    {
	      flag=true;
	      System.out.println("MAIN MENU");
	      System.out.println("1)Browse Store\n2)Check Status\n3)"
	      +"Disconnect\n4)Exit from program\n");
	      System.out.println("Choose your preferable option:\n");
	      int choice;
	      try {
	      choice=keyboard.nextInt();
	      }
	      catch(InputMismatchException e) {
	    	  choice = inputMismatchException.getfinall();
	      }
	     if((choice<5)&&(choice>0))
	     {
	      switch(choice)
	      {
	               
	       case 1:
	   
	       while(flag)
	       {
	         eshop.showCategories();
	         System.out.println("\nPlease select category");
	         System.out.println("Press 5 to go back");
	         int selection;
	         try {
	          selection = keyboard.nextInt();
	         }
	         catch(InputMismatchException e) {
	        	 selection = inputMismatchException.getfinall();
	         }
	         if((selection>0)&&(selection<5))
	         {
	           boolean proceed=eshop.showProductsInCategory(selection);
	           if(proceed)
	           {
	             System.out.println("Choose the product you want based on"
	             +" the ID: \n");
	             int ID;
	             try {
	             ID=keyboard.nextInt();
	             }
	             catch(InputMismatchException e) {
	            	 ID=inputMismatchException.getfinall();
	             }
	             boolean prodIdFound;
				try {
					prodIdFound = eshop.showProduct(ID);
				} catch (ProdIdNotFoundException e1) {
					System.out.println(e1);
					keyboard.nextLine();
					break;
				}
	             if(prodIdFound)
	             {
	               System.out.println("Do you want to change something on "
	               +"this item?\n1)Yes\n2)No\n");
	               int c;
	               try {
	                c=keyboard.nextInt();
	               }
	               catch(InputMismatchException e) {
	            	   c=inputMismatchException.getfinall();
	               }
	               if(c==1)
	               {
	                 System.out.println("What do you want to do with it?\n1)"
	                 +"Change quantity\n2)Remove this item\npress any key to go back");
	                 int k;
	                 try {
	                  k=keyboard.nextInt();
	                 }
	                 catch(InputMismatchException e) {
	                	 k=inputMismatchException.getfinall();
	                 }
	                 if(k==1)
	                 {
	                   System.out.println("What is the stock of this product that you want your eshop to have?: ");
	                   try {
	                   c=keyboard.nextInt();
	                   }
	                   catch(InputMismatchException e) {
	                	   c=inputMismatchException.getfinall();
	                   }
	                   eshop.updateItemStock(ID,c);
	                 }
	                 else if(k==2)
	                 {
	                     System.out.println("Are you sure you want to delete the product with ID="+ID+"?\n1)Yes\n2)No\n");
	                     int j;
	                     try {
	                      j=keyboard.nextInt();
	                     }
	                     catch(InputMismatchException e) {
	                    	 j=inputMismatchException.getfinall();
	                     }
	                        if(j==1)
	                        {
	                              eshop.removeItem(ID);
	                              System.out.print("The item was successfully removed");
	                        }
	                        else System.out.println("The item was not removed");
	                 }
	                 else
	                 {
	                    System.out.println("returning...");
	                 }
	                }
	                else
	                {
	                   System.out.println("No change occured,please choose again:");
	                }
	               }
	             else {
	            	 keyboard.nextLine();	 
	             }
	            }
	            else
	            {
	                           
	            }
	          }
	          else if(selection==5)
	          {
	             flag=false;
	          }
	          else
	          {
	            System.out.println("Invalid input, please choose again");
	          }
	         }
	         flag=true;
	         break;  
	                   
	         case 2:
	         eshop.checkStatus();
	         flag=true;
	          while(flag)
	          {
	            System.out.println("Choose one of the buyers based on their email(Enter the email): ");
	            System.out.println("If the list is empty or in case you want to go back press 1");
	            Scanner bin=new Scanner(System.in);
	            String customer=bin.nextLine();
	           
	            if(eshop.findBuyerByEmail(customer))
	            {
	             eshop.getBuyerByEmail(customer).getShoppingCart().showCart(eshop.getBuyerByEmail(customer));
	             while(flag)
	             {
	              System.out.println("Do you want to delete this user?\n1)Yes\n2)No\n");
	              int uchoice;
	              try {
	               uchoice=keyboard.nextInt();
	              }
	              catch(InputMismatchException e) {
	            	  uchoice=inputMismatchException.getfinall();
	              }
	               if(uchoice==1)
	                 {
	            	 eshop.getBuyerByEmail(customer).getShoppingCart().clearCart();
	                 eshop.removeBuyer(eshop.getBuyerByEmail(customer));;            
	                  System.out.println("Deletion was succesful");
	                  flag=false;
	                  keyboard.nextLine();
	                 }
	                 else if(uchoice==2)
	                 {
	                  System.out.println("The buyer was not deletion");
	                  flag=false;
	                  keyboard.nextLine();
	                 }
	                 else
	                 {
	                  System.out.println("Invalid choice");
	                  keyboard.nextLine();
	                 }
	             }
	             flag=true;
	            }
	            else
	            {          
	               flag=false;
	               if(!customer.equals("1"))
	               {
	               System.out.println("Customer not found");
	                }
	               System.out.println("Returning to main menu...");
	            }
	           
	          }
	         flag= true;
	         break;  
	   
	         case 3:
	         flag=true;
	         int choice2=0;
	         while(flag)
	         {
	          System.out.println("Are you sure you want to log out?\n1)Yes\n2)No");
	          
	          try {
	        	  choice2=in.nextInt();
	          }
	          catch(InputMismatchException e) {
	        	  choice2=inputMismatchException.getfinall();
	          }
	            if(choice2==1)
	            {
	              flag=true;
	              System.out.println("Logging out....");
	              while(flag)
	              {
	                System.out.println("Do you want to log in as another user?\n1)Yes\n2)No");
	                try {
	                choice2=in.nextInt();
	                }
	                catch(InputMismatchException e) {
	                	choice2=inputMismatchException.getfinall();
	                }
	                if(choice2==1)
	                {
	                   System.out.println("\nPlease enter an email: ");
	                   exit=1;
	                   flag=false;
	                   in.nextLine();
	                }
	               else if(choice2==2)
	                {
	                    System.out.println("SYSTEM EXIT...");
	                    System.exit(0);
	                    in.nextLine();
	                }
	               else  {
	            	   System.out.println("Invalid choice,please choose again");
	            	   in.nextLine();
	               }
	                  
	              }
	            }
	            else if(choice2==2)
	            {
	                flag=false;
	                System.out.println("Returning....");
	                in.nextLine();
	            }
	            else
	            {
	                System.out.println("Invalid choice");  
	            }
	            if(exit==1)flag=false;
	         }
	         if(choice2==2)flag=true;
	         break;
	       
	        case 4:
	        System.out.println("SYSTEM EXIT...");
	        System.exit(0);
	        break;
	       }
	     }
	     else {
	    	 System.out.println("Invalid input.\nPlease choose again");
	    	 keyboard.nextLine();
	     }
	     
	    }
	   
	  }
	}
	
	
	public void showBMenu(Menu m) throws QuantityExist, inputMismatchException {
		boolean flag=true;
	     int exit=0;
	  while(flag)
	  {
	     
	     
	      System.out.println("Welcome to "+eshop.getName());
	      System.out.println("Welcome back user "+eshop.getBuyerByEmail(fetch).getName()
	      +"\nYour Personal info: \n============================================================"
	      +"\nName: "+eshop.getBuyerByEmail(fetch).getName()+"\tEmail address: "+eshop.getBuyerByEmail(fetch).getEmail()+
	      "\nBonus points: "+eshop.getBuyerByEmail(fetch).getBonus()+"\t\tBuyerCategory: "+eshop.getBuyerByEmail(fetch).getCategory()+
	      "\n============================================================");
	   flag=true;
	   
	   while(flag) //megalo
	    {
	      flag=true;
	      System.out.println("MAIN MENU");
	      System.out.println("1)Browse Store\n2)View Cart\n3)Checkout\n4)Disconnect\n5)Exit from program\n");
	      System.out.println("Choose your preferable option:\n");
	      int choice;
	    //  keyboard.nextLine();
	     try {
	       choice=keyboard.nextInt();
	     }
	     catch(InputMismatchException e){
	    	 choice=inputMismatchException.getfinall();
	     }
	    	
	    
	     if((choice<6)&&(choice>0))
	     {
	      switch(choice)
	      {
	               
	       case 1:
	       while(flag)
	       {
	         eshop.showCategories();
	         System.out.println("\nPlease select category");
	         System.out.println("Press 5 to go back");
	         keyboard.nextLine();
	         int selection;
	         try {
	          selection = keyboard.nextInt();
	         }
	         catch(InputMismatchException e){
	        	 selection=inputMismatchException.getfinall();
	         }
	         if((selection>0)&&(selection<5))
	         {
	           boolean proceed=eshop.showProductsInCategory(selection);
	           if(proceed)
	           {
	             System.out.println("Choose the product you want based on"
	             +" the ID: \n");
	             keyboard.nextLine();
	             int ID;
	             try {
	              ID=keyboard.nextInt();
	             }
	             catch(InputMismatchException e) {
	            	 ID=inputMismatchException.getfinall();
	             }
	             boolean prodIdFound;
				try {
					prodIdFound = eshop.showProduct(ID);
				} catch (ProdIdNotFoundException e1) {
					System.out.println(e1);
					keyboard.nextLine();
					break;
				}
	             if(prodIdFound)
	             {
	               System.out.println("Do you want to add this product in your cart?\n1)Yes\n2)No\n");
	               keyboard.nextLine();
	               int c;
	               try {
	                c=keyboard.nextInt();
	               }
	               catch(InputMismatchException e) {
	            	   c=inputMismatchException.getfinall();
	               }
	               if(c==1)
	               {
	            	 System.out.println("Please enter how many pieces you want: ");
	            	 keyboard.nextLine();
	            	 int amount;
	            	 try {
	            	  amount=keyboard.nextInt();
	            	 }
	            	 catch(InputMismatchException e) {
	            		 amount=inputMismatchException.getfinall();
	            	 }
	            	 eshop.getBuyerByEmail(fetch).placeOrder(ID,amount);
	                 System.out.println("Your shoppingCart was successfully updated");
	                }
	                else
	                {
	                   System.out.println("Back to product categories...");
	                }
	               }else System.out.println("Returning to product category...");
	            }
	            else
	            {
	                           
	            }
	          }
	          else if(selection==5)
	          {
	             flag=false;
	          }
	          else
	          {
	            System.out.println("Invalid input, please choose again");
	          }
	         }
	         flag=true;
	         break;  
	                   
	         case 2:
	         if(eshop.getBuyerByEmail(fetch).getShoppingCart().isShoppingCartEmpty()) {
	        	 eshop.getBuyerByEmail(fetch).getShoppingCart().showCart(eshop.getBuyerByEmail(fetch));
	         }
	         else {
	        	 System.out.println("\nYour Shopping Cart is Empty"); 
	        	 flag=false;
	         }
	      
	          while(flag)
	          {	        
	        	System.out.println("Please choose one of the following:\n");               //sub-menu for view-cart buyer
	            System.out.println("1)Choose one of the products based on their ID: ");
	            System.out.println("2)Clear your cart");
	            System.out.println("3)Checkout: ");
	            System.out.println("4)Press 4 to go back");
	     
	            int ch;
	            try {
	             ch=in.nextInt();
	            }
	            catch(InputMismatchException e) {
	            	ch=inputMismatchException.getfinall();
	            }
	            
	            
	            switch(ch) {
	            case 1:
	            	int hch=0;
	            	while(flag) {
	            	System.out.println("Please enter and ID: ");
	          //  	keyboard.nextLine();
	            	int prodId;
	            	try {
	            	 prodId=keyboard.nextInt();
	            	}
	            	catch(InputMismatchException e) {
	            		prodId=inputMismatchException.getfinall();
	            	}
	            	 if(eshop.getBuyerByEmail(fetch).getShoppingCart().prodExists(prodId)) {	
	            		 while(flag) {
	     	            System.out.println("\nYou have the following options for the selected product: \n"
	     	            + "1)Delete from ShoppingCart\t\t2)Modify its quantity\nPlease select(press 3 for going back): ");
	     	        //    in.hasNextLine();
	     	            try {
	     	             hch =in.nextInt();
	     	            }
	     	            catch(InputMismatchException e) {
	     	            	hch=inputMismatchException.getfinall();
	     	            }
	     	            if(hch==1) {
	     	            	eshop.getBuyerByEmail(fetch).getShoppingCart().removeItemOrdered(prodId);
	     	            	System.out.println("The item was successfully removed from your Cart!\n");
	     	            	flag=false;
	     	            }
	     	            else if(hch==2) {
	     	            	System.out.println("Please enter the amount you want to add or remove(give a negative number): ");
	     	            	
	     	            	int amount;
	     	            	try {
	     	            	 amount=in.nextInt();
	     	            	}
	     	            	catch(InputMismatchException e) {
	     	            		amount=inputMismatchException.getfinall();
	     	            	}
	     	            	try {
	     	            	eshop.getBuyerByEmail(fetch).getShoppingCart().changeItemOrderedQuantity(prodId, amount);
	     	            	}
	     	            	catch(QuantityExist e) {
	     	            		eshop.getBuyerByEmail(fetch).getShoppingCart().changeItemOrderedQuantity(prodId, e.getFQuantity());  		
	     	            	}
	     	            	flag=false;
	     	            }
	     	            else if(hch==3) {
	     	            	System.out.println("Returning...");
	     	            	flag=false;
	     	            }
	     	            else System.out.println("Invalid choice, please enter again");
	            		 }
	            	 }else System.out.println("The product ID you entered doesn't belond to any product of your Cart");
	            	}
	            	
	            	if(hch==3)flag=true;
	            break;
	            case 2:
	            while(flag) {
	            	System.out.println("Are you sure you want to clear your cart?\n1)Yes\n2)No");
	            
	            	try {
	            	ch=keyboard.nextInt();
	            	}
	            	catch(InputMismatchException e) {
	            		ch=inputMismatchException.getfinall();
	            	}
	            	if(ch==1) { 
	            		eshop.getBuyerByEmail(fetch).getShoppingCart().clearCart();
	            		System.out.println("Your Cart was succesfully cleared and is now empty.");
	            		keyboard.nextLine();
	            		flag=false;
	            	}
	            	else if (ch==2) {
	            		System.out.println("Your cart was not deleted"); flag=false;
	            	}
	            	else System.out.println("Invalid choice,please enter again.");
	            }	
	            break;
	            case 3:
	            	eshop.getBuyerByEmail(fetch).getShoppingCart().checkout(eshop.getBuyerByEmail(fetch));
	            	flag=false;
	            break;
	            case 4:
	            	System.out.println("Returning...");
	            	flag=false;
	            	break;
	            default:
	            	System.out.println("Invalid choice, please enter again."); 
	            break;
	            }
	            
	            if((ch==1) || (ch==2)) flag=false; //Ksanakatevazoyme thn shmaia ypo synthkh gia to case 2 mesa sto case 2 (to megalytero) etsi oste
	            									// na mhn exoyme thema me ta flags kai na kataferoyme na paei piso.             
	   
	          } 
	          
	          flag=true;
	         break;
	         
	         case 3:
	        	 if(eshop.getBuyerByEmail(fetch).getShoppingCart().isShoppingCartEmpty()) {
	        	 eshop.getBuyerByEmail(fetch).getShoppingCart().checkout(eshop.getBuyerByEmail(fetch));
	        	 System.out.println("Returning...");
	        	 }
	        	 else System.out.println("Your shopping Cart is empty so you cannot procceed to checkout");
	        	 keyboard.nextLine();
	        	 break;
	         case 4:
	         flag=true;
	         int choice2 = 0;
	         while(flag)
	         {
	          System.out.println("Are you sure you want to log out?\n1)Yes\n2)No");
	          try {
	          choice2=in.nextInt();
	          }
	          catch(InputMismatchException e) {
	        	  choice2=inputMismatchException.getfinall();
	          }
	            if(choice2==1)
	            {
	              flag=true;
	              System.out.println("Logging out....");
	              while(flag)
	              {
	                System.out.println("Do you want to log in as another user?\n1)Yes\n2)No");

	                choice2=in.nextInt();
	                if(choice2==1)
	                {
	                   System.out.println("\nPlease enter an email: ");
	                   exit=1;
	                   flag=false;
	                }
	               else if(choice2==2)
	                {
	                    System.out.println("SYSTEM EXIT...");
	                    System.exit(0);
	                }
	               else  System.out.println("Invalid choice,please choose again");
	                  
	              }
	            }
	            else if(choice2==2)
	            {
	                flag=false;
	                System.out.println("Returning....");
	            }
	            else
	            {
	                System.out.println("Invalid choice");  
	            }
	            if(exit==1)flag=false;
	         }
	         if (choice2==2) flag=true;
	         break;
	       
	        case 5:
	        System.out.println("SYSTEM EXIT...");
	        System.exit(0);
	        break;
	       }
	     }
	     else {
	    	 System.out.println("Invalid input.\nPlease choose again");
	    	 keyboard.nextLine();
	     }
	     
	    }
	   
	  }
		
	}
	
	
	public void registerNewBuyer(Menu m) {
		boolean flag=true;
		String newName;
		while(flag) {
		System.out.println("It seems like the email you entered wasn't found in our Buyer List\nDo you want to register to our Eshop?\n1)Yes\n2)No");
		int ch=keyboard.nextInt();
		if(ch==1) {
			do {
			System.out.println("\nPlease enter your name: ");
			Scanner in5=new Scanner(System.in); 
			newName=in5.nextLine();
			}while(newName.isBlank());
			
			eshop.addBuyer(new Buyer(newName,getFetch(),eshop));
			System.out.println("\n\t\t\t\t\tSuccess");
			System.out.println("\nPlease re-enter your email to join to our eshop");
			flag=false;
			}
		else if (ch==2) {
			System.out.println("\nSystem Exiting...."); 
			System.exit(0);
		}
		else System.out.println("Invalid choice, please enter again"); 
		}
	}
	
	
	
	//getter
	public String getFetch() {
		return fetch;
	}
}