package day18과제풀이;

import java.io.File;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

public class WindowExplorer {

private File current = null;
	
	private final int FILENAME_LENGTH = 40;

	//setter, getter
	public void setCurrent(File current) {
		//if(current != null && current.isDirectory() == false) return;
		//this.current = current;
		
		if(current == null || current.isDirectory()) {
			this.current = current;
		}
	}
	public File getCurrent() {
		return current;
	}
	
	//생성자
	public WindowExplorer() {}
	public WindowExplorer(File current) {
		this.setCurrent(current);
	}
	
	//현재 위치 목록 출력
	public void show() {
		if(current == null) {
			File[] drives = File.listRoots();
			System.out.println("<현재 위치 - />");
			for(File drive : drives) {
				System.out.println(drive.getAbsolutePath());
			}
		}
		else {
			System.out.println("<현재 위치 - "+current.getAbsolutePath()+">");
			for(File f : current.listFiles()) {
				//(+추가) 파일이름 길이에 따른 띄어쓰기 계산 (파일이름을 40칸으로 고정하여 표시)
				int diff = FILENAME_LENGTH - f.getName().length();
				System.out.print(f.getName());
				if(diff > 0)
					System.out.print(" ".repeat(diff));
				System.out.println(f.isFile() ? "[파일]" : "[디렉터리]");
			}
		}
	}
	
	//이동 메소드들
	public void moveToParent() {
		current = current.getParentFile();
	}
	public void moveToRoot() {
		current = null;
	}
	public void move(String command) {
		File target = new File(current, command);
		//파일, 디렉터리, 존재하지 않는 경우 처리
		print(target);
		setCurrent(target);//자동으로 디렉터리가 아니면 차단
	}
	
	public void print(File target) {
		if(!target.exists()) {//존재하지 않는 경우
			System.out.println("존재하지 않는 경로입니다");
		}
		else if(target.isFile()) {//파일이면
			System.out.println("<파일 정보>");
			System.out.println("경로 : " + target.getAbsolutePath());
			System.out.println("이름 : " + target.getName());
			System.out.println("크기 : " + target.length() + " bytes");
			Date d = new Date(target.lastModified());
			Format f = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
			System.out.println("최종 수정 시각 : " + f.format(d));
		}
	}
}
