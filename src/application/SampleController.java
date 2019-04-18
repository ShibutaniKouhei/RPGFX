package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class SampleController {
	@FXML private Button hogeButton;
	@FXML private Label hogeLabel;
	@FXML private Label textLabel;

	@FXML
	public void onClicked(){

	}

	Timeline timer;
	Movable[] players;
	Movable[] enemies;
	int turn = 0;
	public SampleController(){
		players = new Movable[4];
		//剣士をインスタンス化して情報を代入
		players[0] = new Knight(20,"剣士",10);
		//泥棒をインスタン化して情報を代入
		players[1] = new Thief(15,"泥棒");
		//魔法使いをインスタンス化して情報を代入
		players[2] = new Wizard(15,"魔法使い",50);
		//どらえもんをインスタンス化して代入
		players[3] = new Doraemon("どらえもん",0);

		//敵をインスタンス化して情報を代入
		enemies = new Movable[2];
		enemies[0] = new Enemy(30,"敵A");
		enemies[1] = new Enemy(20,"敵B");

		timer = new Timeline(new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				String message = "";
				textLabel.setText("");
				//playerの自己紹介
				if(players.length <= turn){
					timer.stop();
				}else{
					if(players[turn] instanceof Doraemon){
						message = ((Doraemon) players[turn]).introduce();
						System.out.println("SampleController"+message);
						textLabel.setText(textLabel.getText()+message);
					}else{
						message = ((Character) players[turn]).introduce();
						System.out.println("SampleController:"+message);
						textLabel.setText(textLabel.getText()+message);
					}
				}
					turn++;
				//enemyの自己紹介
//				for(int i = 0; i < enemies.length; i++){
//					message = ((Character) enemies[i]).introduce();
//					System.out.println("SampleController:"+message);
//					textLabel.setText(textLabel.getText()+message);
//				}
//				//敵がプレイヤー攻撃するための乱数
//				Random rnd = new Random();
//				//while(true){
//					//GameOver判定
//					if(((Character) players[0]).isDead() && ((Character) players[1]).isDead() && ((Character) players[2]).isDead()){
//						System.out.println("GameOver");
//						message = "";
//						textLabel.setText("");
//						message = "GameOver";
//						textLabel.setText(textLabel.getText()+message);
//						timer.stop();
//					//Clear判定
//					}else if(((Character) enemies[0]).isDead() && ((Character) enemies[1]).isDead()){
//						System.out.println("Clear!");
//						message = "";
//						textLabel.setText("");
//						message = "Clear!";
//						textLabel.setText(textLabel.getText()+message);
//						timer.stop();
//					}else{
//						//player攻撃ターン
//						for(int i = 0; i < players.length; i++){
//							//敵の数だけ乱数生成
//							int enemyNum = rnd.nextInt(enemies.length);
//
//							//死んでいるplyerとどらえもんは攻撃できない
//							if(players[i] instanceof Doraemon){
//								//ドラえもんを動かすためだけのインスタンス
//								Character doraemonMove = new Enemy(0,"NoName");
//								message = "";
//								textLabel.setText("");
//								message = players[i].move(doraemonMove);
//								textLabel.setText(textLabel.getText()+message);
//								System.out.println("-----------------------------------------");
//							}else if(((Character) players[i]).isDead()){
//								continue;
//							}else{
//								//playerが死んでいるenemyを攻撃できないように条件分岐
//								if(((Character) enemies[enemyNum]).isDead()){
//									System.out.println(((Character) players[i]).getName()+"は"+ ((Character) enemies[enemyNum]).getName()+"を攻撃しようとしたが既に死んでいる。");
//									message = "";
//									textLabel.setText("");
//									message = ((Character) players[i]).getName()+"は"+ ((Character) enemies[enemyNum]).getName()+"を攻撃しようとしたが既に死んでいる。";
//									textLabel.setText(textLabel.getText()+message);
//									continue;
//								}else{
//									message = "";
//									textLabel.setText("");
//									message = players[i].move((Character)enemies[enemyNum]);
//									textLabel.setText(textLabel.getText()+message);
//									System.out.println(((Character) enemies[enemyNum]).getName()+"の残り体力"+((Character) enemies[enemyNum]).getHp());
//									message = "";
//									textLabel.setText("");
//									message = ((Character) enemies[enemyNum]).getName()+"の残り体力"+((Character) enemies[enemyNum]).getHp();
//									textLabel.setText(textLabel.getText()+message);
//									System.out.println("-----------------------------------------");
//								}
//							}
//						}
//						//enemy攻撃ターン
//						for(int i = 0; i < enemies.length; i++){
//							//プレイヤーの数だけ乱数生成
//							int playerNum = rnd.nextInt(players.length);
//
//							//enemyが死んでいるplayerとどらえもんを攻撃できないように条件分岐
//							if(players[playerNum] instanceof Doraemon){
//								System.out.println(((Character) enemies[i]).getName()+"はどらえもんを攻撃できない");
//								message = "";
//								textLabel.setText("");
//								message = ((Character) enemies[i]).getName()+"はどらえもんを攻撃できない";
//								textLabel.setText(textLabel.getText()+message);
//								System.out.println("-----------------------------------------");
//								continue;
//								//死んでいるenemyは攻撃できない
//							}else if(((Character) enemies[i]).isDead()){
//								System.out.println(((Character) enemies[i]).getName()+"は"+((Character) players[playerNum]).getName()+"を攻撃しようとしたが既に死んでいる。");
//								message = "";
//								textLabel.setText("");
//								message = ((Character) enemies[i]).getName()+"は"+((Character) players[playerNum]).getName()+"を攻撃しようとしたが既に死んでいる。";
//								textLabel.setText(textLabel.getText()+message);
//								System.out.println("-----------------------------------------");
//								continue;
//							}else{
//								//enemyが死んでいるplayerを攻撃できないように条件分岐
//								if(((Character) players[playerNum]).isDead()){
//									System.out.println(((Character) enemies[i]).getName()+"は"+((Character) players[playerNum]).getName()+"を攻撃しようとしたが既に死んでいる。");
//									message = "";
//									textLabel.setText("");
//									message = ((Character) enemies[i]).getName()+"は"+((Character) players[playerNum]).getName()+"を攻撃しようとしたが既に死んでいる。";
//									textLabel.setText(textLabel.getText()+message);
//									continue;
//								}else{
//									message = "";
//									textLabel.setText("");
//									message = enemies[i].move((Character)players[playerNum]);
//									textLabel.setText(textLabel.getText()+message);
//									System.out.println(((Character) players[playerNum]).getName() + "の残り体力" + ((Character) players[playerNum]).getHp());
//									message = "";
//									textLabel.setText("");
//									message = ((Character) players[playerNum]).getName() + "の残り体力" + ((Character) players[playerNum]).getHp();
//									textLabel.setText(textLabel.getText()+message);
//									System.out.println("-----------------------------------------");
//								}
//							}
//						}
					//}
				}
			//}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
}
