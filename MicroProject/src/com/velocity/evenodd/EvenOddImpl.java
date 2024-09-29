package com.velocity.evenodd;

import java.util.Scanner;

public class EvenOddImpl implements EvenOdd {
			@Override    										 
			public void getEvenOdd (int num) {		
				for(int i=1;i<=num;i++) {
					if(num%2==0) {
						System.out.println("It’s even number");
						break;
					}
					
					else {
						System.out.println("It’s odd number");
						break;
					}
				}
			}
			
			@Override   												
			public void getEvenOddDetails() {								
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the  number >> ");  
			int x = sc.nextInt();   
			getEvenOdd(x); 	
			
			}
}
	
