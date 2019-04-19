package application;

public class Enemy extends Character implements Movable{
	public Enemy(int hp, String name) {
		super(hp, name);
	}

	@Override
	public String introduce() {
//		System.out.println(this.getName() + "が現れた！");
//		System.out.println("HP:"+ this.getHp());
		return this.getName()+"が現れた！";
	}

	@Override
	public String attack(Character c) {
//		System.out.println(this.getName()+"の攻撃！");
//		c.damage(5);
		return this.getName()+"の攻撃！"+ c.damage(5)+"\n";
	}

	@Override
	public String move(Character c) {
			return attack(c);
	}
}
