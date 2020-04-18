package com.dynamic;

public class LoginAuthentication {
	
		String[][] userList = {{"abeam","Abeam01"},{"Gaito","ga2020"}};
	
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
