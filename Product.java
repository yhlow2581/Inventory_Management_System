public abstract class Product {  

	private String name;  
	private double price;  
	private int quantity;  
	private String itemNumber;  
	private boolean status = true;  

 

	public Product() {  
		super(); 
	}  

	public Product (String itemNumber, String name,  int quantity, double price){  
		this.itemNumber = itemNumber;  
		this.name = name;  
		this.quantity = quantity;  
		this.price = price;  
	}  

	public String getName() {  
		return name;  
	}  

	public void setName(String name) {  
		this.name = name;  
	}  

	public double getPrice() {  
		return price;  
	}  

	public void setPrice(double price) {  
		this.price = price;  
	}  

	public int getQuantity() {  
		return quantity; 
	}  

	public void setQuantity(int quantity) {  
		this.quantity = quantity;  
	}  

	public String getItemNumber() {  
		return itemNumber;  
	}  

	public void setItemNumber(String itemNumber) {  
		this.itemNumber = itemNumber;  
	}  

	public boolean isStatus() {  
		return status;  
	}  

	public void setStatus(boolean status) {  
		this.status = status; 
	}  

	public double getInventoryValue() {  
		return getPrice() * getQuantity(); 
	}  

	public void addQuantity(int number) {  
		if (isStatus() == true) 
			setQuantity(quantity += number); 
	}  

	public void minusQuantity(int number) { 
		if (getQuantity() >= number)  
			setQuantity(quantity -= number);  
	}  

	@Override  
	public String toString(){ return  "Item number:          " + getItemNumber() + '\n' +   

			"Product name:         " + getName() + '\n' +   
			"Quantity available:   " + getQuantity() + '\n' +   
			"Price(RM):            " + getPrice()+ '\n' +   
			"Inventory value (RM): " + getInventoryValue() + '\n' +   
			"Product status:       " + isStatus();  
	} 

} 