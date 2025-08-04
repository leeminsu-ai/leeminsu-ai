package api.file.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01싱글바이트출력 {

	public static void main(String[] args)throws IOException {
		//준비물: 파일 ,통로 제어용 인스턴스
		File target=new File("files","single.txt");
		FileOutputStream stream=new FileOutputStream(target);
		
//[프로그램]->[Stream]->[target]->[single.txt]
//stream을 통해 데이터를  출력하게된다
		stream.write('A'); //stream을 통해 A를 출력해라!
		stream.write(107);
		stream.write(108);
}
}