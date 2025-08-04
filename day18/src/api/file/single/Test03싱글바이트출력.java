package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test03싱글바이트출력 {
	public static void main(String[] args) throws IOException {
		//준비물 : 파일, 입력통로 인스턴스
		File target = new File("files", "single.txt");
		FileInputStream stream = new FileInputStream(target);
		//[프로그램] ← [stream] ← [target] ← [single.txt]
		
		//stream의 read 메소드를 이용해서 데이터를 읽는다
		byte buffer[]=new byte[10];
		while(true) {//비추천
			int size=stream.read(buffer);
			if(size==-1)break;
			System.out.println(Arrays.toString(buffer));
			
		}
		
		stream.close();
		
	}

}
