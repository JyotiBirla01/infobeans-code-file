// 1 
// 01 
// 101 
// 0101 
// 10101

class pt13{
	public static void main(String[] args){
		for(int r = 1; r <= 5; r++){
			for(int c = 1; c <= r; c++){
				if(r%2 != 0){
					if(c%2 != 0){
						System.out.print("1");
					}else{
						System.out.print("0");
					}
				}else{
					if(c%2 == 0){
						System.out.print("1");
					}else{
						System.out.print("0");
					}
				}
			}
			System.out.println();
		}
	}
}