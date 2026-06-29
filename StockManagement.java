import java.util.*;   

public class StockManagement {   

	public static Product[] products;   
	public static int count = 0;   

	public static void main(String[] args) {   

 		Scanner input = new Scanner(System.in);   
 		UserInfo user = new UserInfo();   

 		System.out.println("======== Welcome to Stock Management System (SMS) ========");   
 		System.out.println("Date: " + new Date()+ "\n");   
 		System.out.println("Group Members 1: Franklin Wong Sheng Hao");   
 		System.out.println("Group Members 2: Lee Chia Hui");  
 		System.out.println("Group Members 3: Low Yee Heng");   
 		System.out.println("Group Members 4: Tan Jie Yee");   

 		do{ 
 			System.out.print("Enter full name: "); 
 			String name = input.nextLine(); 
 			
 			user.setFullName(name); 
 		}while (user.getFullName() == null); 

 		user.generateUserID();   

 		boolean sta = false;  
 		int add = -1, num = 0;   

 		int max = getMaxProducts(input);   

 		products = new Product[max];   

 		if (max > 0) 
 			sta = true;   
 		else   
 			sta = false;   

 		while(sta) {   

 			System.out.println("Do you want to add products?");   
 			System.out.println("0 = No\n1 = Yes");   
 			System.out.print("Enter choice: ");   

 			if (input.hasNextInt()) {   
 				add = input.nextInt();     
 				
 				if(add == 0 || add == 1 ) {   
 					break;  
 				}   
 				else {   
 					System.out.println("Invalid input! Please enter 0 or 1.");  
 				}  
 			}   
 			else {   
 				System.out.println("Invalid input! Please enter a number.");  
 				
 				input.next();   
 			}   
 		}   

 		if (add == 0) {   
 			exitSystem(user);   
 			System.exit(0);  
 		}   

 		while(sta) {   

 			System.out.println("Enter number of products to add: ");  

 			if(input.hasNextInt()) {   
 				num = input.nextInt();   

 				if(num >= 0 && num<= max-count) {   
 					break;  
 				}   
 				else {   
 					System.out.println("Invalid! Can only add up to " + (max-count));   
 				}   
 			}  
 			else {   
 				System.out.println("Invalid input! Please enter a number.");  		input.next();   
 			}   
 		}   

 		for(int i = 0;i < num;i++) {   
 			addProduct(products,input);   
 		}   

 		int choice;   
 		
 		do {   
 			choice = displayMenu(input);   
 			executeMenu(choice, products, input);   
 		} while (choice != 0);   

 		exitSystem(user);   
 		input.close();   
	}  

	// method   
	public static int getMaxProducts(Scanner input) {   

		int max;  

		while (true){   
			System.out.print("Enter max products (>=0): ");   

			if(input.hasNextInt()) { 
				max = input.nextInt(); 

				if(max >=0 ) { 
					return max; 
				} 
				else { 
					System.out.println("Invalid! Must be 0 or greater."); 
				} 
			} 
			else { 
				System.out.println("Invalid input! Please enter a number."); 
				input.next();  
			} 
		} 
	}   

	public static int displayMenu(Scanner input) {   

		int choice;  

		while(true) {   
			System.out.println("\n1. View products");   
			System.out.println("2. Add stock");   
			System.out.println("3. Deduct stock");   
			System.out.println("4. Discontinue product");   
			System.out.println("0. Exit");   

			System.out.print("Please enter a menu option: ");   

			if(input.hasNextInt()) {   
				choice = input.nextInt();   
				if(choice >= 0 && choice <=4) {   
					break;   
				}   
				else {   
					System.out.println("Invalid input! Please enter a number between 0 and 4.");   
				}  
			}  
			else{   
				System.out.println("Invalid input! Please enter a number.");   
				input.next();   
			}   
		}      
		System.out.println();  
		return choice;   
	}   

	public static void executeMenu(int choice, Product[] products, Scanner input) {   
		switch (choice) {   
		case 1: viewProducts(products,input); break;   
		case 2: addStock(products, input); break;   
		case 3: deductStock(products, input); break;   
		case 4: discontinueProduct(products, input); break;   
		}  
	}   

	public static int selectProduct(Product[] products, Scanner input) {   

		if(count==0) {   
			input.nextLine();   
			System.out.println("No products available!");   
			return -1;   
		}   

		int index = -1;   

		for (int i = 0; i < count; i++) {   
			System.out.println(i + ": " + products[i].getName());   
		}   

		do {   
			System.out.print("Select product index: ");   

			if(input.hasNextInt()) {   
				index = input.nextInt(); 

				if (index < 0 || index >= count ) 
					System.out.println("Invalid index!");  
				else  
					break; 
			} 
			else 
			{System.out.println("Invalid input! Please enter a number."); 
			input.next(); 
			}   
		}while(index < 0 || index >= count);   

		return index;   
	}   

	public static void viewProducts(Product[] products, Scanner input) {   

		if(count==0) {   
			input.nextLine();   
			System.out.println("No products available!");   
			return;   
		}   

		for (int i = 0; i < count; i++) {   
			System.out.println(products[i]);  
			System.out.println(); 
		}   

		System.out.println("\nPress Enter to continue...");   
		input.nextLine();   
		input.nextLine();   
	} 

	public static void addStock(Product[] products, Scanner input) {   

		int index = selectProduct(products, input);   

		if(index==-1)   
			return;   

		int qty = -1;   

		do {   
			System.out.print("Enter quantity to add: ");   
			
			if (input.hasNextInt()) { 
				qty = input.nextInt(); 

				if (qty >= 0) { 
					break; 
				} else { 
					System.out.println("Invalid input! Quantity must be 0 and above."); 
				} 
				
			} else { 
				System.out.println("Invalid input! Please enter a number."); 
				input.next(); 
			} 
		}while(qty < 0);   

		products[index].addQuantity(qty);  

		System.out.println("\nPress Enter to continue...");   
		input.nextLine();   
		input.nextLine();   
	}   

	public static void deductStock(Product[] products, Scanner input) {   

		int index = selectProduct(products, input);   

		if(index==-1)   
			return;   

		int qty;   

		while (true) {   
			System.out.print("Enter quantity to deduct: ");  

			if (input.hasNextInt()) { 
				qty = input.nextInt();   
				input.nextLine(); 

				int current = products[index].getQuantity();     

				if (qty >= 0 && qty <= current) {   
					break;    
				}   
				else {   
					System.out.println("Invalid! Must be between 0 and " + current);   
				}   
			}   
			else {   
				System.out.println("Invalid input! Please enter a number.");   
				input.next();   
			}   
		}   

		products[index].minusQuantity(qty);   

		System.out.println("\nPress Enter to continue...");   
		input.nextLine();   
	}   

	public static void discontinueProduct(Product[] products, Scanner input) {   

		int index = selectProduct(products, input);   

		if(index==-1)   
			return;   

		products[index].setStatus(false);   
	}   

	public static void addProduct(Product[] products, Scanner input) {   

		int type;   

		do {   
			System.out.println("\n1. Refrigerator");   
			System.out.println("2. TV");   
			System.out.print("Choose type: ");   

			if(input.hasNextInt()) { 
				type = input.nextInt();    
				input.nextLine(); 

				if (type < 1 || type > 2) {    
                  System.out.println("Only number 1 or 2 allowed!");    
				}  
			}
			else { 
				System.out.println("Invalid input! Please enter a number."); 
				input.next();  
				type = -1; 
			} 
		} while (type < 1 || type > 2);  

		if (type == 1) {   
			addRefrigerator(products, input);   
		}   
		else {   
			addTV(products, input);   
		}   
	}   

	public static void addRefrigerator(Product[] products, Scanner input) {   

		input.nextLine();   

		String name; 
		while (true) { 
			System.out.print("Name: "); 
			name = input.nextLine(); 

			if (!name.trim().isEmpty()) { 
				break; 
			}  
			else { 
				System.out.println("Invalid input! Name cannot be empty."); 
			} 
		} 

		String door; 
		while (true) { 
			System.out.print("Door design: "); 
			door = input.nextLine(); 

			if (!door.trim().isEmpty()) { 
				break; 
			}  
			else { 
				System.out.println("Invalid input! Door design cannot be empty."); 
			} 
		} 

		String color; 
		while (true) { 
			System.out.print("Color: "); 
			color = input.nextLine(); 

			if (!color.trim().isEmpty()) { 
				break; 
			}  
			else { 
				System.out.println("Invalid input! Color cannot be empty."); 
			} 
		} 

		double capacity;  
		while (true) {  
			System.out.print("Capacity: "); 
			if (input.hasNextDouble()) {
				capacity = input.nextDouble();

				if (capacity > 0) {
					break;
				}
				else {
					System.out.println("Invalid input! Must be positive.");
				}
			}
			else {  
				System.out.println("Invalid input! Please enter a positive number.");  
				input.next();  
			} 
		}  

		int qty;      
		while (true) {  
		System.out.print("Quantity: ");  

		    if (input.hasNextInt()) {
		        qty = input.nextInt();

		        if (qty > 0) {
		            break;
		        } else {
		            System.out.println("Invalid input! Must be positive.");
		        }

		    } else {
		        System.out.println("Invalid input! Please enter a number.");
		        input.next();
		    }
		}

		double price;  
		while (true) {  
			System.out.print("Price: "); 
			if (input.hasNextDouble()) {
				price = input.nextDouble();

				if (price > 0) {
					break;
				}
				else {
					System.out.println("Invalid input! Must be positive.");
				}
			}
			else {  
				System.out.println("Invalid input! Please enter a positive number.");  
				input.next();  
			} 
		}   

		input.nextLine(); 

		String item; 
		boolean exists; 

		do { 
			System.out.print("Item number: "); 
			item = input.nextLine(); 
			exists = false; 

			if (item.trim().isEmpty()) { 
				System.out.println("Invalid input! Item number cannot be empty."); 
			}  
			else { 
				for (int i = 0; i < count; i++) { 
					if (products[i].getItemNumber().equals(item)) { 
						exists = true; 
						break; 
					} 
				} 
				if (exists) { 
					System.out.println("Item number already exists! Please enter a unique item number."); 
				} 
			} 
		} while (item.trim().isEmpty() || exists); 

		Product p = new Refrigerator(item, name, qty, price, door, color, capacity);   
		products[count++] = p;   
	}   

 

	public static void addTV(Product[] products, Scanner input) {   

		input.nextLine();   

		String name; 
		while (true) { 
			System.out.print("Name: ");
			name = input.nextLine(); 

			if (!name.trim().isEmpty()) { 
				break; 
			}  
			else { 
				System.out.println("Invalid input! Name cannot be empty."); 
			} 
		} 

		String screen; 
		while (true) { 
			System.out.print("Screen type: "); 
			screen = input.nextLine(); 

			if (!screen.trim().isEmpty()) { 
				break; 
			}  
			else { 
				System.out.println("Invalid input! Screen type cannot be empty."); 
			} 
		} 

		String res; 
		while (true) { 
			System.out.print("Resolution: "); 
			res = input.nextLine(); 

			if (!res.trim().isEmpty()) { 
				break; 
			} 
			else { 
				System.out.println("Invalid input! Resolution cannot be empty."); 
			} 
		} 

		double size;  
		while (true) {  
			System.out.print("Size: "); 
			if (input.hasNextDouble()) {
				size = input.nextDouble();

				if (size > 0) {
					break;
				}
				else {
					System.out.println("Invalid input! Must be positive.");
				}
			}
			else {  
				System.out.println("Invalid input! Please enter a positive number.");  
				input.next();  
			} 
		}  

		int qty;      
		while (true) {  
		System.out.print("Quantity: ");  

		    if (input.hasNextInt()) {
		        qty = input.nextInt();

		        if (qty > 0) {
		            break;
		        } else {
		            System.out.println("Invalid input! Must be positive.");
		        }

		    } else {
		        System.out.println("Invalid input! Please enter a number.");
		        input.next();
		    }
		}
		
		double price;  
		while (true) {  
			System.out.print("Price: "); 
			if (input.hasNextDouble()) {
				price = input.nextDouble();

				if (price > 0) {
					break;
				}
				else {
					System.out.println("Invalid input! Must be positive.");
				}
			}
			else {  
        		System.out.println("Invalid input! Please enter a positive number.");  
        		input.next();  
        	} 
		}
		
		input.nextLine(); 

		String item; 
		boolean exists; 

		do { 
			System.out.print("Item number: "); 
			item = input.nextLine(); 

			exists = false; 

			if (item.trim().isEmpty()) { 
				System.out.println("Invalid input! Item number cannot be empty."); 
			}  
			else { 
				for (int i = 0; i < count; i++) { 
					if (products[i].getItemNumber().equals(item)) { 
						exists = true; 
						break; 
					} 
				} 

				if (exists) { 
					System.out.println("Item number already exists! Please enter a unique item number."); 
				} 
			} 
		} while (item.trim().isEmpty() || exists); 

		Product p = new TV(item, name, qty, price, screen, res, size);   
		products[count++] = p;   
	}   

	public static void exitSystem(UserInfo user) {   
		System.out.println("\nUser ID: " + user.getUserID());   
		System.out.println("User Name: " + user.getFullName());   
		System.out.println("Thank you for using SMS!");   
	}   
} 