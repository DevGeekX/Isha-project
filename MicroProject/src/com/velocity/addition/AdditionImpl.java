package com.velocity.addition; 

import java.util.Scanner; 

public class AdditionImpl implements Addition{ 

	@Override 
	
	public void getAddition(int a, int b) {		
		int sum=a+b; 		
		System.out.println("Addition is >> " + sum); 
	
	}  
	
	@Override 
	
	public void getAddDetails() {					
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number >>");  
		int x = sc.nextInt();  
		System.out.print("Enter the second number >> ");  
		int y = sc.nextInt(); 
		getAddition(x,y); 
			}	
	
	}
