package PracticeDataDrivenTesting;

public class generateRandomAlphanum {

	public static void main(String[] args) {
		String alpnum = "ABCDEFGHIJKLM123456789abcdefghijklmnopqt";
		int n = 20;
		//create string buffer size of alphnum
		StringBuilder sb = new StringBuilder(n);
		//generate random numbers based on string index
		for(int i=0;i<=n;i++) {
		int index = (int) (alpnum.length()*Math.random());
		//add characters based on index
		sb.append(alpnum.charAt(index));
		}
		System.out.println(sb);

}
}
