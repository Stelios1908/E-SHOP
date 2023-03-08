import java.util.NoSuchElementException;
import java.util.Scanner;   

public class inputMismatchException extends Exception  {
		private static int finall;
	
	
		
		public static  int intReturn() {
			String fi;
			Scanner f=new Scanner(System.in);
			do {
				System.out.println("Please enter again: ");
				fi=f.nextLine();
			}while(!isInteger(fi));
			return Integer.parseInt(fi);
		}
		
		
		public static boolean isInteger(String s) {
		    Scanner sc = new Scanner(s.trim());
		    if(sc.hasNextInt()) return true;
		    else return false;
		}
		
		public static int getfinall() {
			finall=intReturn();
			return finall;
		}
}