public class Client {
    public static void printlcm(int number1, int number2) {
        
        // Create LCM client with proper strategy for multiplication
        LCM lcmobj = new LCM(new MultiplicationWithRecursion());
    
		System.out.println("LCM of " + number1 + " " + number2 + " is " + lcmobj.lcm(number1, number2));
	}
	
    public static void main(String[] args) {
		printlcm(3, 4);
		printlcm(30, 45);
		printlcm(4, 12);
    }
}
