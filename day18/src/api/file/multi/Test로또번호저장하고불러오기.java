package api.file.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test로또번호저장하고불러오기 {
	public static void main(String args[])throws IOException {
		File target=new File("files","lotto.kh");
		FileOutputStream stream=new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(stream);
		DataOutputStream data=new DataOutputStream(buffer);
		ArrayList<Integer> save=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		System.out.println("횟수를 몇번 받을건지 입력해주세요");
		int count=sc.nextInt();
		int count_zero=0;
		int a;
		while(true) {
			a=random.nextInt(45)+1;
			if(save.contains(a)) {
				continue;
			}
			save.add(a);
			data.writeInt(a);
			count_zero++;
			if(count_zero==count) {
				break;
			}
		}
		data.close();
		}
	}

