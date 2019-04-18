package application;

public class Enemy extends Character implements Movable{
	private int count;
	public Enemy(int hp, String name) {
		super(hp, name);
	}

	@Override
	public String introduce() {
		System.out.println(this.getName() + "が現れた！");
		System.out.println("HP:"+ this.getHp());
		return this.getName()+"が現れた！";
	}

	@Override
	public String attack(Character c) {
		System.out.println(this.getName()+"の攻撃！");
		c.damage(10);
		return this.getName()+"の攻撃！";
	}

	@Override
	public String move(Character c) {
		if(this.count == 0){
			introduce();
			return introduce();
		}else{
			attack(c);
			return attack(c);
		}

	}
}
