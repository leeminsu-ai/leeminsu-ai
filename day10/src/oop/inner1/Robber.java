package oop.inner1;

public class Robber {
	private String name;
	private Gun gun;
	
	public Robber(String name,Gun gun)
	{
		this.name=name;
		this.gun=new Gun();
		
	}
	private class Gun {

	}
}
