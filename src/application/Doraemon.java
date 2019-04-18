package application;

public class Doraemon implements Movable{

	private String name;
	private int hp;
	private int count = 0;
	public Doraemon(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String introduce() {
		System.out.println("僕どらえもん！");
		return "僕どらえもん";
	}


	public String move(Character c){
		if(this.count == 0){
			return introduce();
		}
		this.count++;
		System.out.println("どらえもんは帰っていった。");
		return "どらえもんは帰っていった。";

	}

}
