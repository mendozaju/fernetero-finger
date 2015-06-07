package api.domain;

import java.util.Date;

public class ValueGetterResolver {

	public static long value = 0;

	public static long getValue(){		
		
		 Date now = new Date();
		 long diff = now.getTime() - ConfigResolver.getLastTimeAsked().getTime();
		 long diffMinutes = diff / (60 * 1000) % 60;
		 if(diffMinutes >= ConfigResolver.getDelta()){
			 value= value + (diffMinutes / ConfigResolver.getDelta());
			 ConfigResolver.setLasTimeAsked(now);
		 }		
		 return value;		
	}
}
