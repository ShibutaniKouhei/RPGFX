package application;

abstract class Character{
	private int hp;	//HP
	private String name;	//名前

	//コンストラクタ
	public Character(int hp, String name) {
		this.hp = hp;
		this.name = name;
	}



	public Character() {

	}

	//自己紹介メソッド
	public abstract String introduce();
	//攻撃用の抽象メソッド
	public abstract String attack(Character c);

	//キャラクターがダメージを負うメソッド
	public String damage(int power){
		System.out.println(this.name+"は、"+power+"ポイントのダメージを受けた！");
		this.hp -= power;
		return this.name+"は、"+power+"ポイントのダメージを受けた！";
	}

	public boolean isDead(){
		if(this.hp <= 0){
			return true;
		}else{
			return false;
		}
	}

	//getter
	public int getHp() {
		return hp;
	}

	public String getName() {
		return name;
	}
}
