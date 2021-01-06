package ch.hearc.ProjetTE;

public class Beer {

	private int index;
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

	Beer(AddBeerForm addBeerForm, int index) {
		this.setValues(addBeerForm);
		this.index = index;
	}

	public void setValues(AddBeerForm updateBeerForm) {
		this.stock = updateBeerForm.getStock();
		this.name = updateBeerForm.getName();
		this.brand = updateBeerForm.getBrand();
		this.price = updateBeerForm.getPrice();
		this.size = updateBeerForm.getSize();
		this.color = updateBeerForm.getColor();
		this.fermentation = updateBeerForm.getFermentation();
		this.style = updateBeerForm.getStyle();
	}

	//Getters & setters
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public ColorType getColor() {
		return color;
	}

	public void setColor(ColorType color) {
		this.color = color;
	}

	public FermentationType getFermentation() {
		return fermentation;
	}

	public void setFermentation(FermentationType fermentation) {
		this.fermentation = fermentation;
	}

	public StyleType getStyle() {
		return style;
	}

	public void setStyle(StyleType style) {
		this.style = style;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}