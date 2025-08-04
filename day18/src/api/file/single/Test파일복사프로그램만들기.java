package api.file.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test파일복사프로그램만들기 {

	public static void main(String[] args)throws IOException {
		File target=new File("D:","dummy.txt");
		FileOutputStream stream=new FileOutputStream(target);
		
		stream.write(65);
		stream.write(66);
		stream.write(32);
		stream.write(104);
		stream.write(101);
		stream.write(108);
		stream.write(108);
		stream.write(111);
		stream.write(64);
		stream.write(10);

	}

}
