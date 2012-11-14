// Aequivalenz:
//
// FreeBox ist aequivalent zu Repeated<P>, da alle Methodensignaturen sowie Vor-/Nachbedingungen und Invarianten gleich sind.
//
// Untertyp von ... Beziehungen:
//
// ClearBox ist Untertyp von Box, da die Invarianten (Rand ist immer '*', Inhalt ist immer ' ') strenger sind. Die geerbten Methoden haben die selbe Funktionalitaet und sind daher aequivalent.
//
// P (P extends Pict) ist Untertyp von Scaled<P>, da
// - die Methodensignaturen gleich sind
// - die Vorbedingungen (factor zwischen 0.1 und 10) gleich sind.
// - die Nachbedingung der Methode toString (das Ausgabeformat) staerker sind (es wird nur ein 1x1 Grid ausgegeben). Das Skalierverhalten ist vom Typparameter (P) abhaengig und damit aequivalent.
// - die Invarianten von Scaled<P> in P eben falls gelten (das Grid ist rechteckig da 1x1, enthaelt ausschliesslich druckbare Zeichen).
// Diese Beziehung laesst sich in Java nicht darstellen, da Scaled auf die Methoden von P zugreift, was in einer endlos-Rekursion enden wuerde.
// Fuer ClearBox - Scaled<Box> sowie Repeated<Char> - Scaled<FreeBox> (und umgekehrt) gelten die genannten Regeln ebenfalls (aufgrund der Untertypbeziehungen)!
//
// Keine Untertypbeziehung:
//
// Box, ClearBox mit DarkBox: DarkBox ist veraenderbar und Darkbox kann keinen Rand darstellen (anderes Ausgabeformat).
//
// Box, ClearBox, Scaled<Q> mit FreeBox, Repeated<P>: Die Skalierung erfolgt unterschiedlich (daher unterschiedliche Nachbedingungen).
//
// Box, ClearBox mit Scaled<P> (P ohne Box, ClearBox): Bei einem 1x1 Grid gibt es keine Untertypbeziehung, da mit P keine Untertypbeziehung besteht. Sonst sind die Skalierungseigenschaften unterschiedlich.
//
// DarkBox mit FreeBox: Die Freebox darf nur mittels scale Methode geaendert werden. In DarkBox koennen auch so Aenderungen gemacht werden.
//
// DarkBox mit Repeated<P>, Scaled<P>: Der Inhalt von Repeated/Scaled (das Array) darf nicht veraendert werden. In DarkBox sind Aenderungen jedoch zugelassen. Repeated/Scaled kann weiters unterschiedliche Zeichen darstellen im Gegensatz zu DarkBox (unterschiedliche Ausgabeformate).
//
// FreeBox, Repeated<P> mit Scaled<P> (P ohne FreeBox, Repeated<Char>): Bei einem 1x1 Grid gibt es keine Untertypbeziehung, da mit P keine Untertypbeziehung besteht. Sonst sind die Skalierungseigenschaften unterschiedlich.

public class Test {
	public static void main(String[] args) {

		// DarkBox testen
		DarkBox dBox1 = new DarkBox(5, 4, '+');
		DarkBox dBox2 = new DarkBox(1, 3, '-');

		System.out.println("--- DarkBox ---");
		System.out.println(dBox1);
		System.out.println("--- Skalierung 2 (DarkBox) ---");
		dBox1.scale(2.0);
		System.out.println(dBox1);
		System.out.println("--- DarkBox ---");
		System.out.println(dBox2);

		// Ersetzungsprinzip
		Pict pictdBox3 = new DarkBox(3, 3, '*');
		System.out.println("--- Pict (DarkBox) - Ersetzungsprinzip ---");
		System.out.println(pictdBox3);

		System.out.println("+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+");
		System.out.println();

		// Box testen
		Box box1 = new Box(5, 3, '-', '#');
		Box box2 = new Box(1, 4, '@', '?');
		System.out.println("--- Box ---");
		System.out.println(box1);
		System.out.println("--- Skalierung 1.5 ---");
		box1.scale(1.5);
		System.out.println(box1);
		System.out.println("--- Box ---");
		System.out.println(box2);

		// Ersetzungsprinzip
		Pict pictBox = new Box(6, 3, 'G', 'I');
		System.out.println("--- Pict (Box) - Ersetzungsprinzip ---");
		System.out.println(pictBox);

		System.out.println("+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+");
		System.out.println();

		// ClearBox testen
		ClearBox cBox1 = new ClearBox(3, 4);
		System.out.println("--- ClearBox ---");
		System.out.println(cBox1);
		System.out.println("--- Verhaeltnis von ClearBox ---");
		System.out.println(cBox1.getRatio());

		Box boxcBox2 = new ClearBox(3, 3);
		System.out.println("--- Box (ClearBox) - Ersetzungsprinzip ---");
		System.out.println(boxcBox2);

		System.out.println("+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+");
		System.out.println();

		// FreeBox testen
		Character[][] mg = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };
		FreeBox fb = new FreeBox(mg);
		System.out.println("--- FreeBox ---");
		System.out.println(fb);
		System.out.println("--- FreeBox skaliert auf 0.5 ---");
		fb.scale(0.5);
		System.out.println(fb);
		System.out.println("--- FreeBox skaliert auf 2.0 ---");
		fb.scale(2);
		System.out.println(fb);

		System.out.println("+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+");
		System.out.println();

		// TU :P
		Character[][] mg2 = { { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', 'W', 'W', 'W', '.', 'W', '.', 'W', '.' },
				{ '.', '.', 'W', '.', '.', 'W', '.', 'W', '.' },
				{ '.', '.', 'W', '.', '.', 'W', 'W', 'W', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		fb = new FreeBox(mg2);
		System.out.println("--- FreeBox ---");
		System.out.println(fb);
		fb.scale(0.5);
		System.out.println("--- FreeBox skaliert auf 0.5 ---");
		System.out.println(fb);
		System.out.println("--- FreeBox skaliert auf 2.0 ---");
		fb.scale(2);
		System.out.println(fb);

		System.out.println("+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+");
		System.out.println();

		// Repeated, Scale
		Pict p00 = new Box(5, 3, '-', '#');
		Pict p01 = new ClearBox(5, 4);
		Pict p02 = new Box(3, 2, '-', '#');
		Pict p10 = new Box(3, 5, '\\', '/');
		Pict p11 = new DarkBox(2, 3, 'O');
		Pict p12 = new ClearBox(4, 4);

		Pict[][] picts = { { p00, p01, p02 }, { p10, p11, p12 } };

		Grid<Pict> grid = new Repeated<Pict>(picts);
		System.out.println("--- Grid bestehend aus verschiedenen Boxen ---");
		System.out.println(grid);
		grid.scale(0.5);
		System.out.println("--- Grid skaliert auf 0.5 ---");
		System.out.println(grid);
		System.out.println("--- Grid skaliert auf 2.75 ---");
		grid.scale(2.75);
		System.out.println(grid);

		System.out.println("+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+~+");
		System.out.println();

		grid = new Scaled<Pict>(picts);
		System.out.println("--- Grid aus Scaled erzeugt ---");
		System.out.println(grid);
		grid.scale(0.5);
		System.out.println("--- Skalierung auf 0.5 ---");
		System.out.println(grid);
		grid.scale(2.75);
		System.out.println("--- Skalierung auf 2.75 ---");
		System.out.println(grid);
	}
}
