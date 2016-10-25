import java.util.*;

public class TimeComparator implements Comparator<TimeCom> {
	
	public int compare(TimeCom time1, TimeCom time2){
		if (time1.getHour()==time2.getHour()){
			if (time1.getMinute()==time2.getMinute()){
					return time1.getSecond() - time2.getSecond();
			}
			return time1.getMinute()-time2.getMinute();
		}
		return time1.getHour()-time2.getHour();
	}
}
