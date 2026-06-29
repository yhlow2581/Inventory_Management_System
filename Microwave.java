public class Microwave extends Product {

    private String type;
    private int power; 
    private double capacity;

    public Microwave(String itemNumber, String name,
                     int quantity, double price,
                     String type, int power, double capacity) {

        super(itemNumber, name, quantity, price);
        this.type = type;
        this.power = power;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power > 0) {
            this.power = power;
        } else {
            System.out.println("Invalid power!");
            this.power = 0;
        }
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            System.out.println("Invalid capacity!");
            this.capacity = 0;
        }
    }

    @Override
    public String toString() {
        return "Item number          :" + getItemNumber() + '\n' +
               "Product name         :" + getName() + '\n' +
               "Microwave type       :" + getType() + '\n' +
               "Power (Watt)         :" + getPower() + '\n' +
               "Capacity             :" + getCapacity() + '\n' +
               "Quantity available   :" + getQuantity() + '\n' +
               "Price (RM)           :" + getPrice() + '\n' +
               "Inventory value (RM) :" + getInventoryValue() + '\n' +
               "Product status       :" + isStatus();
    }
}