public class ConTest{
	public static void main(String args[]){
		String test = "a + b * c + ( d * e + f ) * g";
		System.out.println(Converter.infixToPostfix(test));
	}
}