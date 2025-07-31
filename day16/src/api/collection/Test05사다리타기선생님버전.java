package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test05사다리타기선생님버전 {

	public static void main(String[] args) {
		int people=3;
		List<String>names=new ArrayList<>();
		List<String>items=new ArrayList<>();
		
		names.add("피카츄");
		names.add("라이츄");
		names.add("파이리");
		
		items.add("점심사기");
		items.add("술사기");
		items.add("얻어먹기");
		
		Collections.shuffle(items);
		for(int i=0; i<3; i++) {
			System.out.println(names.get(i)+"->"+items.get(i));
		}
	}

}
