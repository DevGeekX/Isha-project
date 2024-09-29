package com.velocity.square;

import java.util.Scanner;

public class SquareImpl implements Square {
	public void getSquare (int num) {		
		int Square=num*num; 								   		
		System.out.println("Square is >>  " + Square);
		}  
		
		@Override   												
		public void getSquareDetails() {								
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number >> ");  
		int x = sc.nextInt();   
		getSquare(x); 

}
}
