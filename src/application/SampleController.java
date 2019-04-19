package application;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class SampleController {
	@FXML
	private Button hogeButton;
	@FXML
	private Label hogeLabel;
	@FXML
	private Label textLabel;

	@FXML
	public void onClicked() {

	}

	Timeline timer;
	Movable[] players;
	Movable[] enemies;
	Random rnd = new Random();
	// playerとenemyの自己紹介をカウント
	int playersTurn = 0;
	int enemiesTurn = 0;
	// playerとenemyの攻撃をカウント
	int pAttackTurn = 0;
	int eAttackTurn = 0;

	public SampleController() {
		players = new Movable[4];
		// 剣士をインスタンス化して情報を代入
		players[0] = new Knight(20, "剣士", 10);
		// 泥棒をインスタン化して情報を代入
		players[1] = new Thief(15, "泥棒");
		// 魔法使いをインスタンス化して情報を代入
		players[2] = new Wizard(15, "魔法使い", 50);
		// どらえもんをインスタンス化して代入
		players[3] = new Doraemon("どらえもん", 0);

		// 敵をインスタンス化して情報を代入
		enemies = new Movable[2];
		enemies[0] = new Enemy(60, "敵A");
		enemies[1] = new Enemy(60, "敵B");

		timer = new Timeline(new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String message = "";
				textLabel.setText("");
				// playerの自己紹介
				if (players.length > playersTurn) {
					if (players[playersTurn] instanceof Doraemon) {
						message = ((Doraemon) players[playersTurn]).introduce();
						System.out.println("SampleController" + message);
						textLabel.setText(textLabel.getText() + message);
					} else {
						message = ((Character) players[playersTurn]).introduce();
						System.out.println("SampleController:" + message);
						textLabel.setText(textLabel.getText() + message);
					}
					playersTurn++;
				} else {
					if (enemies.length > enemiesTurn) {
						message = ((Character) enemies[enemiesTurn]).introduce();
						System.out.println("SampleController:" + message);
						textLabel.setText(textLabel.getText() + message);
						enemiesTurn++;
					} else {
						if (((Character) players[0]).isDead() && ((Character) players[1]).isDead()
								&& ((Character) players[2]).isDead()) {
							System.out.println("GameOver");
							message = "GameOver";
							textLabel.setText(textLabel.getText() + message);
							timer.stop();
							// Clear判定
						} else if (((Character) enemies[0]).isDead() && ((Character) enemies[1]).isDead()) {
							System.out.println("Clear!");
							message = "Clear!";
							textLabel.setText(textLabel.getText() + message);
							timer.stop();
						} else {
							// 敵の数だけ乱数生成
							int enemyNum = rnd.nextInt(enemies.length);

							if (players.length > pAttackTurn) {
								// 死んでいるplyerとどらえもんは攻撃できない
								if (players[pAttackTurn] instanceof Doraemon) {
									// ドラえもんを動かすためだけのインスタンス
									Character doraemonMove = new Enemy(0, "NoName");
									message = players[pAttackTurn].move(doraemonMove);
									textLabel.setText(textLabel.getText() + message);
									System.out.println("-----------------------------------------");
									pAttackTurn++;
								} else if (((Character) players[pAttackTurn]).isDead()) {
									message = "死んでいるプレイヤーは攻撃できない。";
									textLabel.setText(textLabel.getText() + message);
									pAttackTurn++;
								} else {
									// playerが死んでいるenemyを攻撃できないように条件分岐
									if (((Character) enemies[enemyNum]).isDead()) {
										System.out.println(((Character) players[pAttackTurn]).getName() + "は"
												+ ((Character) enemies[enemyNum]).getName() + "を攻撃しようとしたが既に死んでいる。");

										message = ((Character) players[pAttackTurn]).getName() + "は"
												+ ((Character) enemies[enemyNum]).getName() + "を攻撃しようとしたが既に死んでいる。";
										textLabel.setText(textLabel.getText() + message);
										pAttackTurn++;
									} else {
										message = players[pAttackTurn].move((Character) enemies[enemyNum]);
										textLabel.setText(textLabel.getText() + message);

										System.out.println(((Character) enemies[enemyNum]).getName() + "の残り体力"
												+ ((Character) enemies[enemyNum]).getHp());

										message = ((Character) enemies[enemyNum]).getName() + "の残り体力"
												+ ((Character) enemies[enemyNum]).getHp();
										textLabel.setText(textLabel.getText() + message);
										System.out.println("-----------------------------------------");
										pAttackTurn++;
									}
								}

							}else{
								//プレイヤーの数だけ乱数生成
								int playerNum = rnd.nextInt(players.length);
								if(enemies.length > eAttackTurn){
									//enemyが死んでいるplayerとどらえもんを攻撃できないように条件分岐
									if(players[playerNum] instanceof Doraemon){
										System.out.println(((Character) enemies[eAttackTurn]).getName()+"はどらえもんを攻撃できない");

										message = ((Character) enemies[eAttackTurn]).getName()+"はどらえもんを攻撃できない";
										textLabel.setText(textLabel.getText()+message);

										System.out.println("-----------------------------------------");
										//死んでいるenemyは攻撃できない
									}else if(((Character) enemies[eAttackTurn]).isDead()){
										System.out.println(((Character) enemies[eAttackTurn]).getName()+"は"
												+((Character) players[playerNum]).getName()+"を攻撃しようとしたが既に死んでいる。");

										message = ((Character) enemies[eAttackTurn]).getName()+"は"+((Character)
												players[playerNum]).getName()+"を攻撃しようとしたが既に死んでいる。";
										textLabel.setText(textLabel.getText()+message);

										System.out.println("-----------------------------------------");
									}else{
										//enemyが死んでいるplayerを攻撃できないように条件分岐
										if(((Character) players[playerNum]).isDead()){
											System.out.println(((Character)
													enemies[eAttackTurn]).getName()+"は"+((Character)
															players[playerNum]).getName()+"を攻撃しようとしたが既に死んでいる。");

											message = ((Character) enemies[eAttackTurn]).getName()+"は"+((Character)
													players[playerNum]).getName()+"を攻撃しようとしたが既に死んでいる。";
											textLabel.setText(textLabel.getText()+message);
										}else{
											message = enemies[eAttackTurn].move((Character)players[playerNum]);
											textLabel.setText(textLabel.getText()+message);
											System.out.println(((Character) players[playerNum]).getName()
													+ "の残り体力" + ((Character) players[playerNum]).getHp());

											message = ((Character) players[playerNum]).getName() +
													"の残り体力" + ((Character) players[playerNum]).getHp();
											textLabel.setText(textLabel.getText()+message);

											System.out.println("-----------------------------------------");
										}
									}
									eAttackTurn++;
								}else{
									pAttackTurn = 0;
									eAttackTurn = 0;
								}
							}
						}
					}
				}
			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
}
