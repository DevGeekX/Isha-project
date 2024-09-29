package com.velocity.cube;

import java.util.Scanner;

public class CubeImpl  implements Cube{   
		
				@Override    										 
				public void getCube (int num) {		
				int cube=num*num*num; 								   		
				System.out.println("Cube is >> " + cube);
				}  
				
				@Override   												
				public void getCubeDetails() {								
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter any number >> ");  
				int x = sc.nextInt();   
				getCube(x); 	


				}
}



