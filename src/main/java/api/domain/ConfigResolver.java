package api.domain;

import java.util.Date;

public class ConfigResolver {
	
	private static Date askedDate = new Date();
	private static int numberOfMituesToIncrise = 1;
	
	public static void setLasTimeAsked(Date date){
		askedDate = date;		
	}
	
	public static Date getLastTimeAsked(){
		return askedDate;
	}
	
	public static void configureDelta(int delta){
		numberOfMituesToIncrise = delta;
	}
	
	public static int getDelta(){
		return numberOfMituesToIncrise;
	}

}
