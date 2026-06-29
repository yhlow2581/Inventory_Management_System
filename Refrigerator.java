public class Refrigerator extends Product {  

	private String doorDesign;  
	private String color;  
	private double capacity;  

	public Refrigerator(String itemNumber, String name,  int quantity, double price, String doorDesign, String color, double capacity) {  
		super(itemNumber, name, quantity, price);  

		this.doorDesign = doorDesign; 
		this.color = color;  
		this.capacity = capacity;  
	}  

	public String getDoorDesign() {  
		return doorDesign; 
	}  

	public void setDoorDesign(String doorDesign) {  
		this.doorDesign = doorDesign;  
	}  

	public String getColor() {  
		return color; 
	}  

	public void setColor(String color) {  
		this.color = color;  
	}  

	public double getCapacity() {  
		return capacity;  
	}  

	public void setCapacity(double capacity) {  

		if (capacity > 0) { 
			this.capacity = capacity; 
		}  
		
		else { 

			System.out.println("Invalid capacity!"); 
			
			this.capacity = 0; 
		}	 
	}  

	@Override  

	public String toString(){  
		return  "Item number          :" + getItemNumber() + '\n' +   

				"Product name         :" + getName() + '\n' +   

				"Door design          :" + getDoorDesign() + '\n' +  

				"Color                :" + getColor() + '\n' +  

				"Capacity (in Litres) :" + getCapacity() + '\n' +   

				"Quantity available   :" + getQuantity() + '\n' +   

				"Price(RM)            :" + getPrice()+ '\n' +   

				"Inventory value (RM) :" + getInventoryValue() + '\n' +   

				"Product status       :" + isStatus(); 
	}  
} 