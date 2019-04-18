package application;

public class Knight extends Character implements Movable{
	private int power;	//力
	private int count;

	//コンストラクタ
	public Knight(int hp, String name, int power) {
		super(hp, name);
		this.power = power;
	}

	//自己紹介のオーバーライド
	@Override
	public String introduce(){
//		System.out.println("私は"+ this.getName());
//		System.out.println("HP:"+ this.getHp());
		return "私は"+ this.getName();
	}

	//攻撃のオーバーライド
	@Override
	public String attack(Character c) {
		System.out.println(this.getName()+"の攻撃！");
		c.damage(5);
		this.powerAttack(c);
		return this.getName()+"の攻撃！";

	}

	//追加攻撃のメソッド
	public String powerAttack(Character c){
		System.out.println(this.getName()+"の追加攻撃。");
		System.out.println(this.getName()+"は力強く攻撃した！");
		c.damage(this.power);
		return this.getName()+"の追加攻撃。";
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
