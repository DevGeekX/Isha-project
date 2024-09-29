package com.velocity.substraction; 
import java.util.Scanner;

		
public class SubstractionImpl  implements Subtraction{ 
	       			
	
	@Override    									
	public void getSubtraction (int a, int b) {		
		int sub=a-b; 							 	
		System.out.println("Subtraction is>> " + sub);
	}  

	@Override   												
	public void getSubDetails() {								
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number>> ");  
		int x = sc.nextInt();  
		System.out.print("Enter the second number>> ");  
		int y = sc.nextInt(); 
		getSubtraction(x,y); 										
			}	 

	
	}


