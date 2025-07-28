package oop.modifier2;

public class Music {
	private int rank;
	private String title;
	private String singer;
	private String album;
	private int like;
	private int listen;
	
	int getListen() {
		return listen;
	}
	void setListen(int listen) {
		if(listen>=0) {
		this.listen = listen;
		}
		else return;
	}
	int getRank() {
		return rank;
	}
	void setRank(int rank) {
		if(rank>0) {
		this.rank = rank;
		}
		else return;
	}
	String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	String getSinger() {
		return singer;
	}
	void setSinger(String singer) {
		this.singer = singer;
	}
	String getAlbum() {
		return album;
	}
	void setAlbum(String album) {
		this.album = album;
	}
	int getLike() {
		return like;
	}
	void setLike(int like) {
		if(like>=0) {
		this.like = like;
		}
		else return;
	}
	int rankPoint(int like,int listen)
	{
		return getLike()*123+getListen();
	}
	public Music(int rank,String title,String singer,String album,int like,int listen)
	{
		setRank(rank);
		setTitle(title);
		setSinger(singer);
		setAlbum(album);
		setLike(like);
		setListen(listen);
	}
	void info()
	{
		System.out.print("순위:"+this.rank+" ");
		System.out.print("타이틀:"+this.title+" ");
		System.out.print("가수:"+this.singer+" ");
		System.out.print("앨범: "+this.album+" ");
		System.out.print("좋아요:"+this.like+" ");
		System.out.print("재생수:"+this.listen+" ");
		System.out.println("랭크포인트->"+rankPoint(this.like,this.listen));
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
}
