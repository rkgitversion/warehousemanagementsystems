import java.util.Random;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int number = random.nextInt(100000);
		String randomStr = String.format("%05d", number);
		System.out.println(randomStr);
	}

}
