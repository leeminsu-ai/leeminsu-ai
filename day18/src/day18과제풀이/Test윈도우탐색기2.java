package day18과제풀이;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Test윈도우탐색기2 {
	//현재 위치를 저장할수 있도록 변수설정
	//끝말잇기 제시어랑 비슷
	
	
	public static void main(String[] args) {
		
		
		
		//변수 생성
		File current=new File("c:/");
		for(File f:current.listFiles()) {
			System.out.println(f.getName());
			System.out.print("\t");
			System.out.println(f.isFile()? "[파일]":"[디렉터리]");
		}

		Scanner sc=new Scanner(System.in);
	String commad=sc.next();
		
		File target=new File(commad);
		if(!target.exists()) {
			System.out.println("존재하지 않는 경로입니다");
			
		}
		else if(target.isFile()) {
			System.out.println("<파일정보>");
			System.out.println("경로:"+target.getAbsolutePath());
			System.out.println("이름:"+target.getName());
			System.out.println("크기:"+target.length()+"bytes");
			Date d=new Date(target.lastModified());
			SimpleDateFormat f=new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
			System.out.println("최종 수정 시각:"+f.format(d));
			
		}
		else {
			System.out.println("<디렉터리 정보>");
			System.out.println("경로:"+target.getAbsolutePath());
			File[]files=target.listFiles();
			System.out.println("파일 개수:"+files.length);
			for(File f:files) {
				System.out.println(f.getName());
				System.out.print("\t");
				System.out.println(f.isFile()?"[파일]":"디렉터리");
			}
		}
		
	}

}
