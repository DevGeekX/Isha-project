package com.velocity.factors;

import java.util.Scanner;

public class FactorsImpl implements Factors {
	@Override
	public void getFactors (int num) {		
		for(int i=1;i<=num;i++) {
				if (num % i ==0){
					System.out.println("Factors are >>"+i);
				}
			}
			
		}
	@Override   												
	public void getFactorsDetails() {								
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the  number >> ");  
	int x = sc.nextInt();   
	getFactors(x); 	
}
}	
