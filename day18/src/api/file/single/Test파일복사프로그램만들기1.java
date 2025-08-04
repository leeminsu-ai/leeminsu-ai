package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test파일복사프로그램만들기1 {

	public static void main(String[] args)throws IOException {
		File target=new File("D:","dummy");
		FileInputStream stream=new FileInputStream(target);
		
		System.out.println("경로 입력:"+target.getAbsolutePath());
		System.out.println("파일의 크기는 총 "+target.length()+ " bytes 입니다");
		int a;
		while(true) {
			a=stream.read();
			System.out.println("코드="+a);
			
			
			
			
		}
	}

}
