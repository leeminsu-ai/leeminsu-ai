package api.file.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01멀티바이트출력 {

	public static void main(String[] args)throws IOException {
		//준비물: 분해도구, 임시저장소(버퍼),출력통로,파일 인스턴스
		File target=new File("files","multi.txt");
		FileOutputStream stream =new FileOutputStream(target);//출력통로
		BufferedOutputStream buffer=new BufferedOutputStream(stream);//임시저장소
		DataOutputStream data=new DataOutputStream(buffer);//분해도구
		
		//프로그램->data->buffer->stream->target->multi.txt
		//data가 가진명령을 이용해서 출력
		data.writeInt(100); //data를 이용해서 100을 int(4byte)형태로 분해하여 출력
		data.writeLong(100);//data를 이용해서 100을 long형태로 분해하여 출력
		data.writeFloat(100);
		data.writeDouble(100);
		data.writeChar(100); 
		
		//버퍼가 생기고 나서부터는 버퍼에 남아있는 데이터를 효율 상관없이 내보내야함.
		data.flush(); //내보내기만
		data.close(); //내보내고 연결종료
		
		
		
	}

}
