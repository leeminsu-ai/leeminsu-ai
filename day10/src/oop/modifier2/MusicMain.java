package oop.modifier2;

import java.lang.ProcessHandle.Info;

public class MusicMain {

	public static void main(String[] args) {
		Music a=new Music(1,"Golden","HUNTRIX","Kpop Demon Hunters",83758,128331);
		Music b=new Music(2,"Soda pop","사자보이즈","Kpop Demon Hunters",52675,53899);
		Music c= new Music(3,"뛰어(JUMP)","BLACKPINK","뛰어(JUMP)",35699,83829);
		Music d=new Music(4,"Famous","ALLDAY PROJECT","FAMOUS",74665,18288);
		
		a.info();
		b.info();
		c.info();
		d.info();
		
		
	}

}
