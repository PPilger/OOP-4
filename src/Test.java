public class Test {
	public static void main(String[] args) {

		// DarkBox testen
		DarkBox dBox1 = new DarkBox(5, 4, '+');
		DarkBox dBox2 = new DarkBox(1, 3, '-');

		System.out.println("--- DarkBox (Box1) ---");
		System.out.println(dBox1);
		System.out.println("--- Skalierung 2 (Box1) ---");
		dBox1.scale(2.0);
		System.out.println(dBox1);
		System.out.println("--- DarkBox (Box2) ---");
		System.out.println(dBox2);

		//Ersetzungsprinzip - Erfolgreich
		Pict dBox3 = new DarkBox(3,3,'*');
		System.out.println("--- DarkBox (Box3) - Ersetzungsprinzip ---");
		System.out.println(dBox3);
		
		
		// Box testen
		Box box1 = new Box(5, 3, '-', '#');
		Box box2 = new Box(1, 4, '@', '?');
		System.out.println("--- Box (Box1) ---");
		System.out.println(box1);
		System.out.println("--- Skalierung 1.5 (Box1) ---");
		box1.scale(1.5);
		System.out.println(box1);
		System.out.println("--- Box (Box2) ---");
		System.out.println(box2);

		// ClearBox testen
		ClearBox cBox1 = new ClearBox(3, 3);
		System.out.println(cBox1);
		System.out.println(cBox1.getRatio());
		
		//FreeBox testen
		Character[][] mg = {{'a','b','c'},{'d','e','f'}};
		FreeBox fb = new FreeBox(mg);
		System.out.println(fb);
		fb.scale(0.5);
		System.out.println(fb);
		fb.scale(2);
		System.out.println(fb);
		fb.scale(3);
		System.out.println(fb);
		fb.scale(2.75);
		System.out.println(fb);
		
		//TU :P
		Character[][] mg2 ={{'.','.','.','.','.','.','.','.','.'},
							{'.','W','W','W','.','W','.','W','.'},
							{'.','.','W','.','.','W','.','W','.'},
							{'.','.','W','.','.','W','W','W','.'},
							{'.','.','.','.','.','.','.','.','.'}};
		fb = new FreeBox(mg2);
		System.out.println(fb);
		fb.scale(0.5);
		System.out.println(fb);
		fb.scale(2);
		System.out.println(fb);
		fb.scale(3);
		System.out.println(fb);
		fb.scale(2.75);
		System.out.println(fb);
	}
}
