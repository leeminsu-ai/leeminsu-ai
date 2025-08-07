package 과제풀이;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03회원가입프로그램 {

	public static void main(String[] args) throws IOException{
		Map<String,String>information=new HashMap<String,String>();
		File target=new File("files/member.txt");
		FileOutputStream stream=new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(stream);
		ObjectOutputStream data=new ObjectOutputStream(buffer);
		
		Scanner sc=new Scanner(System.in);
		String id;
		String password;
		
		while(true) {
			id=sc.nextLine();
			password=sc.nextLine();
			information.put(id, password);
			data.write(null);
			data.write(null);
		}
		
		
		
	}

}
