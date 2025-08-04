package api.file.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test로또번호열기 {

	public static void main(String[] args) throws IOException {
		File target = new File("files", "lotto.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream Buffer = new BufferedInputStream(stream);
		DataInputStream data=new DataInputStream(Buffer);
		
		int a;
		for(int i=0; i<6; i++) {
			a=data.readInt();
			System.out.println((i+1)+"번쨰 숫자는"+a+"입니다");
		}
	}

	
}
