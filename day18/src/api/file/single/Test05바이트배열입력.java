package api.file.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test05바이트배열입력 {

	public static void main(String[] args)throws IOException {
		//바이트배열 입력
		File target=new File("files","single2.txt");
		FileInputStream stream=new FileInputStream(target);
		
		//48byte를 얼마씩 나눠서 읽어야 잘읽었다라고할까?
		//일단 10바이트씩 읽어보자
		byte[]buffer=new byte[10];
		
		//stream의 read메소드중에서 배열에 통쨰로 입력받는 것을 사용
		int size=stream.read(buffer);
		System.out.println(Arrays.toString(buffer));
		stream.read(buffer);
		size=stream.read(buffer);
		System.out.println("size="+size);
		System.out.println(Arrays.toString(buffer));
		stream.read(buffer);
		size=stream.read(buffer);
		System.out.println("size="+size);
		System.out.println(Arrays.toString(buffer));
		stream.read(buffer);
		size=stream.read(buffer);
		System.out.println("size="+size);
		System.out.println(Arrays.toString(buffer));
		stream.read(buffer);
		size=stream.read(buffer);
		System.out.println("size="+size);
		System.out.println(Arrays.toString(buffer));
		stream.read(buffer);
		size=stream.read(buffer);
		System.out.println("size="+size);
		System.out.println(Arrays.toString(buffer));
	}

}
