package com.velocity.modulus;

import java.util.Scanner;

public class ModuluImpl implements Modulus {  					
			@Override    										 
			public void getModulus (int a, int b) {		 
			int mod=a%b; 								   			
			System.out.println("Modulus is >>  " + mod);
			}  
			
			@Override   												
			public void getModDetails() {								
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the first number >> ");  
			int x = sc.nextInt();  
			System.out.print("Enter the second number >>: ");  
			int y = sc.nextInt(); 
			getModulus(x,y); 	
			}
}
