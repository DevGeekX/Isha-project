package com.velocity.multiplication;
import java.util.Scanner;


public class MultiplicationImpl  implements Multiplication{ 
   			

		@Override    										 
		public void getMultiplication (int a, int b) {		
		int mul =a*b; 								   			
		System.out.println("Multiplication is >> " + mul);
		}  

		@Override   												
		public void getMulDetails() {								
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number >> ");  
		int x = sc.nextInt();  
		System.out.print("Enter the second number >> ");  
		int y = sc.nextInt(); 
		getMultiplication(x,y); 									
	}	 


}
