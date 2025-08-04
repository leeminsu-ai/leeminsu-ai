package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test파일복사프로그램만들기2 {

	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("읽을 파일 경로 입력:");
		String readFile=sc.nextLine();
		System.out.println("저장할 파일 경로 입력:");
		String saveFile=sc.nextLine();
		
		File in=new File(readFile);
		File copy=new File(saveFile);
		
		FileInputStream stream=new FileInputStream(in);
		FileOutputStream stream1=new FileOutputStream(copy);
		
		long total=in.length();
		long count=0L;
		System.out.println("파일의 크기는 총"+in.length()+"bytes 입니다");
		while(true) {
			int a;
			a=stream.read();
			if(a==-1)break;
			stream1.write(a);
			
			System.out.println("총"+total+"개 중"+count+"개 이동완료");
		}
		System.out.println("저장이 완료되었습니다");
		
	}

}
