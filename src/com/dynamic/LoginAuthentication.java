package com.dynamic;

public class LoginAuthentication {
	
		String[][] userList = {{"abeam","abeam01"},{"admin","admin"}};
	
	public boolean getAuthentication(String aname, String aPassword) {
			
		for(int i = 0; i < userList.length;	i++ ) {
						
			if(userList[i][0].equals(aname)  && userList[i][1].equals(aPassword)  ) {
				userList[i][0].contentEquals(aname);
				return true;
			}
		}
		return false;		
	}	
}
