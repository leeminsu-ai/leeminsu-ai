package api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test05성적정보출력 {

	public static void main(String[] args)throws IOException {
		File target=new File("scores.db");
		FileInputStream stream=new FileInputStream(target);
		BufferedInputStream buffer=new BufferedInputStream(stream);
		DataInputStream data=new DataInputStream(buffer);
		
		int count=data.readInt();
		for(int i=1; i<=count; i++) {
			System.out.println(i+"위는"+data.readInt()+"입니다");
		}
		 data.close();
	}
 
}
