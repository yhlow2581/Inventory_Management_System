public class UserInfo{

	private String fullName;
	private String userID;
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {  
		if(fullName==null || fullName.trim().isEmpty() || !isValidName(fullName)) {  
			System.out.println("Invalid name! Only letter and space allowed.");
			return;
		}  

		if(isValidName(fullName)) {  
			this.fullName = fullName;  
		}  
	}  
	
	public String getUserID() {
		return userID;
	}
	
	public boolean hasSpace(String name) {
		for(int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ' ')
				return true;
		}
		return false;
	}
	
	public void generateUserID() {
		if (!hasSpace(getFullName())) {
			userID = "guest";
			return;
		}
		
		String fWord = "";
		String sName = "";
		String current = "";
		
		for(int j = 0; j < getFullName().length(); j++) {
			char c = getFullName().charAt(j);
			
			if (c == ' ') {
				
				if(current.length() >0) {
					sName = current;
					current = "";
				}
				
				continue; //will not do the after code
			}
			
			if(fWord.length() == 0)
				fWord += c;
			
			current += c;
		}
		
		if (current.length() > 0)
			sName = current;
		
		userID = fWord + sName;
	}
	
	public boolean isValidName (String name) {
		for(int k = 0; k < name.length(); k++) {
			char c = name.charAt(k);
			
			if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ')) {
				return false;
			}
		}
		return true;
	}
}
