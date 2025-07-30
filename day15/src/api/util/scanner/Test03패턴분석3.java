package api.util.scanner;
import java.util.Scanner;
public class Test03패턴분석3 {

	public static void main(String[] args) {
		String rainbow="빨강+주황=노랑/초록-파랑-남색=보라";
		Scanner sc=new Scanner(rainbow);
		rainbow=rainbow.replaceAll("[가-힣]+","@@");
		System.out.println("rainbow="+rainbow);
	
		}
	}


