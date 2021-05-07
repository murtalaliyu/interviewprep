package test;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException; 

public class Watch {
	private int HH;
	private int MM;
	private int SS;
	
	public Watch() {
		HH = 00;
		MM = 00;
		SS = 00;
	}
	
	public Watch(int hh, int mm, int ss) {
		if (hh >= 0 && hh < 24 && mm >= 0 && mm < 60 && ss >= 0 && ss < 60) {
			HH = hh;
			MM = mm;
			SS = ss;
		}
	}
	
	public void RunEngine() throws InterruptedException, IOException {
		//FileWriter writer = new FileWriter("times.txt");
		
		int i = 0;
		while (i < 4) {
			new Watch();
			while(HH < 24) {
				while (MM < 60) {
					while (SS < 60) {
						displayWatch(HH,MM,SS);
						TimeUnit.SECONDS.sleep(1);
						//writer.write(returnCurrentTime() + "\n");
						SS++;
					}
					MM++;
				}
				HH++;
			}
			i++;
		}
		//writer.close();
		//System.out.println("file complete");
	}
	
	public String getUnitString(int unit) {
		return unit < 10 ? ("0"+unit) : String.valueOf(unit);
	}
	
	public String returnCurrentTime() {
		return getUnitString(HH) + ":" + getUnitString(MM) + ":" + getUnitString(SS);
	}
	
	public void displayWatch(int hh, int mm, int ss) {
		System.out.println(getUnitString(hh) + ":" + getUnitString(mm) + ":" + getUnitString(ss));
	}
}
