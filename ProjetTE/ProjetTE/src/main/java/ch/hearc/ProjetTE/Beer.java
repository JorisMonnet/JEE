package ch.hearc.ProjetTE;

public class Beer {
	public enum ColorType {
		BLONDE, BRUNE, AMBREE, BLANCHE, UNKNOWN
	}

	public enum FermentationType {
		BASSE, HAUTE, SPONTANEE, EN_BOUTEILLE, MIXTE, UNKNOWN
	}

	public enum StyleType {
		GARDE, ABBAYE, LAGER, PALE_ALE, INDIA_PALE_ALE, STOUT, BLANCHE, SAISON, SOUR, FUT, UNKNOWN
	}

	private int stock;
	private String name;
	private String brand;
	private double price;
	private double size;
	private ColorType color;
	private FermentationType fermentation;
	private StyleType style;

	Beer(int stock, String name, String brand, double price, double size, ColorType color,
			FermentationType fermentation, StyleType style) {
		this.stock = stock;
		this.brand = brand;
		this.price = price;
		this.size = size;
		this.color = color;
		this.fermentation = fermentation;
		this.style = style;
	}

	public String[] getAttributesArray() {
		return new String[] { Integer.toString(stock), name, brand, Double.toString(price), Double.toString(size),
				color.toString(), style.toString(), fermentation.toString() };
	}

	public String toString() {
		return name + " from " + brand + " X " + Integer.toString(stock);
	}
}