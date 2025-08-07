package api.file.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.Date;

public class Test02객체입력 {

	public static void main(String[] args)throws IOException,ClassNotFoundException {
		//입력은 출력의 반대 (순서를 기억해야돼요)
		
		File target=new File("files","object.txt");
		FileInputStream stream=new FileInputStream(target);
		BufferedInputStream buffer=new BufferedInputStream(stream);
		ObjectInputStream object=new ObjectInputStream(buffer);
		
		//프로그램<-object<-buffer<-stream<-target<-object
		Date d=(Date)object.readObject();
		//다운캐스팅은 그냥 다시 본연으로 돌아가는작업이라 편하다
		LocalDateTime current=(LocalDateTime)object.readObject();
		
		
		
	}

}
