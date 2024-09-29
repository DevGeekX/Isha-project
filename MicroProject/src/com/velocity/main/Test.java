package com.velocity.main;

import java.util.Scanner;

import com.velocity.addition.AdditionImpl;
import com.velocity.average.AverageImpl;
import com.velocity.cube.CubeImpl;
import com.velocity.division.DivisionImpl;
import com.velocity.evenodd.EvenOddImpl;
import com.velocity.factors.FactorsImpl;
import com.velocity.modulus.ModuluImpl;
import com.velocity.modulus.Modulus;
import com.velocity.multiplication.MultiplicationImpl;
import com.velocity.square.SquareImpl;
import com.velocity.substraction.SubstractionImpl;

public class Test {
		public static void main(String[] args) {
				System.out.println("Welcome to console based application");
				System.out.println("1.Addition of two number\n"+ 
						"2.Subtraction of two number\n" + 
						"3.Multiplication of two number\n" + 
						"4.Division of two number\n" + 
						"5.Modulus of two number\n" + 
						"6.Square of number\n" + 
						"7.Cube of number\n" + 
						"8.Average of numbers\n" + 
						"9.Factors of numbers\n" + 
						"10.Find out even or odd number");
				Scanner scanner= new Scanner(System.in);
				System.out.println("Enter your choice>>");
				int no=scanner.nextInt();
				switch (no) {
				case 1:
					AdditionImpl add= new AdditionImpl();
					add.getAddDetails();
					break;
				case 2:
					SubstractionImpl sub= new SubstractionImpl();
					sub.getSubDetails();
					break;
				case 3:
					MultiplicationImpl mul = new MultiplicationImpl();
					mul.getMulDetails();
					break;
				case 4:
					DivisionImpl div = new DivisionImpl();
					div.getDivDetails();
					break;
				case 5:
					ModuluImpl mod = new ModuluImpl();
					mod.getModDetails();
					break;
				case 6: 
					SquareImpl sq= new SquareImpl();
					sq.getSquareDetails();
					break;
				case 7:
					CubeImpl cube = new CubeImpl();
					cube.getCubeDetails();
					break;
				case 8:
					AverageImpl avg = new AverageImpl();
					avg.getAvgDetails();
					break;
				case 9:
					FactorsImpl fact= new FactorsImpl();
					fact.getFactorsDetails();
					break;
				case 10:
					EvenOddImpl even= new EvenOddImpl();
					even.getEvenOddDetails();
					break;
				default:
					System.out.println("Enter valid Number");
					break;
				}
				
			}
		
}
