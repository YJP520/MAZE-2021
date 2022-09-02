/*
 * @Date: 2021/06/09 - 2021/06/19
 * @Author: Y.J.P
 * @Declaration:
 * 		1.UI界面；
 * 		2.内容显示。
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class labyrinth_interface extends Application{

	String about = "";//关于

	public static void main(String[]args){
		try{
		 	launch(args);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage){
		Pane pane = new Pane();

		/* 开始图形界面 */

		/* 按钮 */
		Button button1 = new Button_YG("单路");
		Button button2 = new Button_RD("多路");
		Button button3 = new Button_SET("关于");

		/* 封面 */
		ImageView p1 = new ImageView("Image/hello2.bmp");//BMP图片文件很丝滑(清晰)
		p1.fitWidthProperty().bind(pane.widthProperty());
		p1.fitHeightProperty().bind(pane.heightProperty());
		pane.getChildren().add(p1);

		/* 标题 */
		Text text1 = new Text_RB("LABYRINTH EXPLORE");//College English Test 4&6
		//text1.setFill(Color.rgb(230,10,110));//（red，green,blue）想怎么调整就怎么调
		text1.setX(150);
		text1.setY(200);
		pane.getChildren().add(text1);

		/* 标题 欢迎词 */
		Text text2 = new Text_LA("欢迎来到迷宫探索");
		text2.setX(270);
		text2.setY(340);
		pane.getChildren().add(text2);

		/*输出栏 1 */
		TextField textField1 = new TextField_FPB();
		textField1.setEditable(false);
		textField1.setPrefSize(750,60);
		textField1.setLayoutX(250);
		textField1.setLayoutY(400);
		pane.getChildren().add(textField1);

		/* 单路 */
		button1.setLayoutX(300);
		button1.setLayoutY(600);
		button1.setScaleX(1.5);
		button1.setScaleY(1.5);
		pane.getChildren().add(button1);
		button1.setOnAction(event -> {
			Application a2 = new labyrinth_cooperate();
			textField1.setText("加载中...");
//			button1.setDisable(true);
//			primaryStage.show();
//			try {
//				Thread.sleep(1000);
//			} catch (Exception ex) { }
			try {
				//primaryStage.close();
				a2.start(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		//祝你考试成功！\=> _ <=/

		/* 多路按钮 */
		button2.setLayoutX(800);
		button2.setLayoutY(600);
		button2.setScaleX(1.5);
		button2.setScaleY(1.5);
		pane.getChildren().add(button2);
		button2.setOnAction(event -> {
			Application a3 = new labyrinth_kindsWay();
//			textField1.setText("加载中...");
//			button2.setDisable(true);
//			primaryStage.show();
//			try {
//				Thread.sleep(1000);
//			} catch (Exception ex) { }
			try {
//				primaryStage.close();
				a3.start(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		/* 关于按钮 */
		button3.setLayoutX(550);
		button3.setLayoutY(600);
		button3.setScaleX(1.0);
		button3.setScaleY(1.0);
		pane.getChildren().add(button3);
		button3.setOnAction(event -> {
			textField1.setText("迷宫探索");

			/* 读入文件内容 */
			File file = new File("src/Texts/about.txt");
			System.out.println(file.exists());
			Scanner input = null;
			try {
				input = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while(input.hasNext()) {
				about += input.nextLine() + "\n";
			}
			input.close();

			/* 设置文本区域 */
			Pane pane2 = new Pane();
			TextArea textArea1 = new TextArea();
			textArea1.setLayoutX(0);
			textArea1.setLayoutY(0);
			textArea1.setPrefColumnCount(50);
			textArea1.setPrefRowCount(20);
			textArea1.setEditable(false);
			textArea1.setFont(Font.font("KaiTi",30));
			textArea1.setStyle("-fx-control-inner-background:PALEGREEN");
			textArea1.setText(about);

			/* 新的stage显示信息 */
			pane2.getChildren().add(textArea1);
			Scene scene2 = new Scene(pane2);
			Stage stage = new Stage();
			stage.setScene(scene2);
			stage.setWidth(840);
			stage.setHeight(780);
			stage.setTitle("关于");
			stage.show();
			about = "";//清空
		});

		/* 舞台 */
		Scene scene = new Scene(pane);
		scene.setFill(Color.LIGHTSKYBLUE);
		primaryStage.setScene(scene);
		primaryStage.setWidth(1300);
		primaryStage.setHeight(900);
		primaryStage.setTitle("迷宫探索");
		primaryStage.show();

	}
}












