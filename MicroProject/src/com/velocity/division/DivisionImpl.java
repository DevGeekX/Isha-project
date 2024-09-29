package com.velocity.division;

import java.util.Scanner;

public class DivisionImpl  implements Division{   
	   			

			@Override    										 
			public void getDivision (int a, int b) {		
			int div=a/b; 								   		
			System.out.println("Division is >> " + div);
			}  

			@Override   												
			public void getDivDetails() {							
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the first number >> ");  
			int x = sc.nextInt();  
			System.out.print("Enter the second number >>");  
			int y = sc.nextInt(); 
			getDivision(x,y); 									

}
}
