// 22)
// A
// AB
// A C
// A  D
// ABCDE

class pt22{
	public static void main(String[] args){
		/* for(int r = 1; r <= 5; r++){
			char z = 65;
			for(int c = 1; c <= r; c++){
				if(r >= 3 && r < 5){
					if(c == 1 || c == 5 || c == r){
						System.out.print(z);
						z++;
					}else{
						System.out.print(" ");
						z++;
					}
				}else{
					System.out.print(z);
					z++;
				}
			}
			System.out.println(); */
			
		for(char r = 65; r <= 69; r++){
			for(char c = 65; c <= r; c++){
				if(c == 65 || c == r || r == 69){
					System.out.print(c);
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}