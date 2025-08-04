package api.file.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test05성적정보저장 {

	public static void main(String[] args) throws IOException{
		File target=new File("scores.db");
		FileOutputStream stream= new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(stream);
		DataOutputStream data=new DataOutputStream(buffer);
		int a;
		Scanner sc=new Scanner(System.in);
		
		
		
		List<Integer>scorePeople=new ArrayList<Integer>();
		System.out.println("시험성적을 입력해주세요(음수누르면 끝인걸로간주)");
		while(true) {
			a=sc.nextInt();
			 if (a < 0) break; 
			scorePeople.add(a);
			
	           
		}
		Set<Integer>sortScore=new TreeSet<Integer>(Collections.reverseOrder());
		sortScore.addAll(scorePeople);
		
		
		data.writeInt(sortScore.size());
		
		for(int number:sortScore) {
			data.writeInt(number);
		}
		
		
		data.close();
		
	}

}
