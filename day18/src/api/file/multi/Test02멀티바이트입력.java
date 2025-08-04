package api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02멀티바이트입력 {

	public static void main(String[] args) throws IOException{
		
		//앞 예제에서 저장한 파일을 불러와서 입력.
		File target=new File("files","multi.txt");
		FileInputStream stream=new FileInputStream(target);
		BufferedInputStream buffer=new BufferedInputStream(stream);
		DataInputStream data=new DataInputStream(buffer);
		
		//프로그램<-data<-buffer<-stream<-target<-multi.txt
		int a=data.readInt();
		long b=data.readLong();
		float c=data.readFloat();
		double d=data.readDouble();
		char e=data.readChar();
		
		data.close();
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
		System.out.println("e="+e);
		System.out.println("e="+e);
	}

}
