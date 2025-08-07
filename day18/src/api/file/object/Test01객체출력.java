package api.file.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Date;


public class Test01객체출력 {

	public static void main(String[] args)throws IOException { 
		//객체출력
		//가장 과정이 복잡한 출력(데이터가 복잡하기 떄문에)
		//데이터를 평평하게 펼치는 "직렬화(serialize)" 작업 후 분할하여 전송
		// java.Serializable이라는 인터페이스를 상속받아야만 출력가능
		File target=new File("files","object.txt");
		FileOutputStream stream=new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(stream);
		ObjectOutputStream object=new ObjectOutputStream(buffer);
		
		//프로그램->object->buffer->stream->target->objcet.txt
		Date d=new Date();
		
		object.writeObject(d);
		
		LocalDateTime current=LocalDateTime.now();
		object.writeObject(current);
		
		object.close();
		
		
		
		
		
		
	}

}
