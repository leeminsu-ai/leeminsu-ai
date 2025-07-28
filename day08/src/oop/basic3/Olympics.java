package oop.basic3;

public class Olympics {

	public static void main(String[] args) {
		Olympics_information[] man= {
				new Olympics_information("진종오","사격","하계",4,2,0),
				new Olympics_information("김수녕","양궁","하계",4,1,0),
				new Olympics_information("전이경", "쇼트트랙", "동계", 4, 0, 1)
				};
		for(Olympics_information c: man)
		{
			System.out.print("이름:"+c.name+" ");
			System.out.print("스포츠:"+c.sport+" ");
			System.out.print("구분:"+c.division+" ");
			System.out.print("금메달:"+c.gold+" ");
			System.out.print("은메달:"+c.silver+" ");
			System.out.println("동메달:"+c.bronze+" ");
			
		}
	}

}
