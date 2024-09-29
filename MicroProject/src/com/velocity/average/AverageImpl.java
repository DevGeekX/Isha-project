package com.velocity.average;

import java.util.Scanner;

public class AverageImpl implements Average {

	@Override
	public void getAverage(int a, int b, int c, int d, int e) { 
		int sum=a+b+c+d+e; 								   			
		System.out.println("Total sum is>> " + sum);
		int Avg=sum/5;
		System.out.println("Average is>> " + Avg);
}  
		
	@Override
	public void getAvgDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first number >> ");  
		int x = sc.nextInt();  
		System.out.print("Enter the second numbe >> ");  
		int y = sc.nextInt(); 
		System.out.print("Enter the third number >>");  
		int z = sc.nextInt();  
		System.out.print("Enter the fourth numbe >> ");  
		int o = sc.nextInt(); 
		System.out.print("Enter the five number >> ");  
		int p = sc.nextInt();  
		getAverage(x,y,z,o,p); 	

}
}

