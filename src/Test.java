public class Test {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// DarkBox testen
		DarkBox dBox1 = new DarkBox('+', 5, 4);
		DarkBox dBox2 = new DarkBox('-', 1, 3);

		System.out.println(dBox1);
		dBox1.scale(2.0);
		System.out.println(dBox1);
		System.out.println(dBox2);

		// Box testen
		Box box1 = new Box(5, 3, '-', '#');
		System.out.println(box1);
		box1.scale(1.5);
		System.out.println(box1);

		// ClearBox testen
		ClearBox cBox1 = new ClearBox(3, 3);
		System.out.println(cBox1);
		System.out.println(cBox1.getRatio());
	}
}
