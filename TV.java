public class TV extends Product { 

	private String screenType; 

	private String resolution; 

	private double displaySize; 

	public TV(String itemNumber, String name,  int quantity, double price, String screenType, String resolution, double displaySize) { 

		super(itemNumber, name, quantity, price); 

		this.screenType = screenType; 
		this.resolution = resolution; 
		this.displaySize = displaySize; 
	} 

	public String getScreenType() { 
		return screenType; 
	} 

	public void setScreenType(String screenType) { 
		this.screenType = screenType; 
	} 

	public String getResolution() { 
		return resolution; 
	} 

	public void setResolution(String resolution) { 
		this.resolution = resolution; 
	} 

	public double getDisplaySize() { 
		return displaySize; 
	} 

	public void setDisplaySize(double displaySize) { 
		this.displaySize = displaySize; 
	} 


	@Override 
	public String toString(){ 
		return  "Item number          :" + getItemNumber() + '\n' +  

				"Product name         :" + getName() + '\n' +  

				"Screen Type          :" + getScreenType() + '\n' + 

				"Resolution           :" + getResolution() + '\n' +  

				"Display Size         :" + getDisplaySize() + '\n' +  

				"Quantity available   :" + getQuantity() + '\n' +  

				"Price(RM)            :" + getPrice()+ '\n' +  

				"Inventory value (RM) :" + getInventoryValue() + '\n' +  

				"Product status       :" + isStatus(); 

	} 
} 
