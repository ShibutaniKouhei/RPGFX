package application;

public class Thief extends Character implements Movable{

	private int count;
	//コンストラクタ
	public Thief(int hp, String name) {
		super(hp, name);
	}

	//自己紹介のオーバーライド
	@Override
	public String introduce() {
		System.out.println("私は"+ this.getName()+"だ！");
		System.out.println("HP:"+ this.getHp());
		return "私は"+ this.getName()+"だ！";
	}

	//攻撃のオーバーライド
	@Override
	public String attack(Character c) {
		System.out.println(this.getName()+"の攻撃！");
		c.damage(5);
		steal(c);
		return this.getName()+"の攻撃！";
	}

	//攻撃の際に相手から追加で盗む
	public String steal(Character c){
		System.out.println(this.getName()+"は、"+c.getName()+"からアイテムを盗んだ");
		return this.getName()+"は、"+c.getName()+"からアイテムを盗んだ";
	}

	@Override
	public String move(Character c) {
		if(this.count == 0){
			introduce();
			this.count++;
			return introduce();
		}else{
			attack(c);
			return attack(c);
		}

	}
}
