/// 60) WAP to print Square, Cube and Square Root of all numbers from 1 to N

import java.util.Scanner;
class Q60SqureRoot{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any natural number: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++){
			System.out.println(i +" Squre is: " +(i*i));
			System.out.println(i +" Cube is: " +(i*i*i));
			for(int j = 1; j <= i; j++){
				if(j*j == i){
					System.out.println("Squre root is: "+j);
					System.out.println();
				}if(j*j != i){
					System.out.println("root" +i);
					System.out.println();
					break;
				}
				
			}
		}
	}
}