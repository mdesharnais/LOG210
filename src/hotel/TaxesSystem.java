package hotel;

public class TaxesSystem {

	// --------------------------------------------------
	// Constructor(s)

	// --------------------------------------------------
	// Accessor(s)

	// --------------------------------------------------
	// Mutators(s)

	// --------------------------------------------------
	// Method(s)
	
	public static double calculateTPS(double value) {
		return TPS * value;
	}
	
	public static double calculateTVQ(double value) {
		return TVQ * value;
	}

	// --------------------------------------------------
	// Attribute(s)
	
	private static double TPS = 0.07;
	private static double TVQ = 0.06;
}
