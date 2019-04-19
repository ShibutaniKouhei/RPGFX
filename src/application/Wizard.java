package application;


public class Wizard extends Character implements Movable{
	private int mp;	//MP
	//コンストラクタ
	public Wizard(int hp, String name, int mp) {
		super(hp, name);
		this.mp = mp;
	}

	//自己紹介のオーバーライド
	@Override
	public String introduce() {
//		System.out.println("私は"+ this.getName()+"です。");
//		System.out.println("HP:"+ this.getHp() + "MP:" + this.mp);
		return "私は"+ this.getName()+"です。";
	}

	//攻撃のオーバーライド
	@Override
	public String attack(Character c) {
		System.out.println(this.getName()+"の攻撃！");
		return this.getName()+"の攻撃！\n"+ c.damage(5) + flame(c)+"\n";
	}

	//追加攻撃の魔法
	public String flame(Character c){
		System.out.println(this.getName() + "は炎を撃った！");
		if(this.mp >= 5){
			this.mp -= 5;
			return this.getName()+"は炎を撃った!\n"+c.damage(15);
		}else{
			System.out.println("MPが足りません！");
			return "MPが足りません！";
		}
	}

	@Override
	public String move(Character c) {
			return attack(c);
	}
}
