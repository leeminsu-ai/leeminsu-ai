package api.file.single;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test03로또번호열기 {

	public static void main(String[] args)throws IOException {
		//로또번호생성
		List<Integer>numbers=new ArrayList<>();
		for(int i=1; i<45; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		List<Integer>lottoNumbers=numbers.subList(0, 6); //substring이랑 유사
		Set<Integer>sortNumbers=new TreeSet<>(lottoNumbers);
		
		
		
		
		File target=new File("files","lotto.kh");
		FileOutputStream stream=new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(stream);
		DataOutputStream data=new DataOutputStream(buffer);
		
		data.writeInt(sortNumbers.size());
		for(int number:sortNumbers) {
			data.writeInt(number);
		}
		
		
		
		data.close();
		
	}

}
