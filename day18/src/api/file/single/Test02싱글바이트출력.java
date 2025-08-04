package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02싱글바이트출력 {

	public static void main(String[] args)throws IOException {
		//준비물:파일,입력통로인스턴스
		File target=new File("files","single.txt");
		FileInputStream stream=new FileInputStream(target);
		 
		//stream의 read메소드를 이용해서 데이터를 읽는다
		int a=stream.read();
		System.out.println("a="+a);
		
		
		
	}

}
