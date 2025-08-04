package api.file.single;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04바이트배열출력 {

	public static void main(String[] args)throws IOException {
		//목표:여러 개의 바이트를 한번에 출력
		File target=new File("files","single2.txt");
		FileOutputStream stream=new FileOutputStream(target);
		
		//stream에 존재하는 메소드중에서 byte[]을 보내는 메소드 사용
		// 반복문으로 보내는것과 성능이 차이남
		byte[] data=new byte[] {
				'H','e','l','l','o',' ','J','a','v','a','!','\n'
		};
		stream.write(data);
		stream.write(data);
		stream.write(data,6,4);
		stream.write(data,6,4);
		stream.close();
	}

}
