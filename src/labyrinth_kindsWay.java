/*
 * @Date: 2021/06/09
 * @Author: Y.J.P
 * @Declaration:
 * 		1.操作界面；
 * 		2.内容显示。
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class labyrinth_kindsWay extends Application {

    private int[][] map2 = null;//地图
    private int wideOfMaze = 21;//迷宫阶数
    private int X1 = 1,Y1 = 1,X2 = 19,Y2 = 19;//迷宫 起始点 和 终点
    private ArrayList<Position> list1 = new ArrayList<>();//存点
    private ArrayList<String> list_1 = new ArrayList<>();

    private int steps = 0;
    private int count = 0;

    private int[][] map4 = null;//单步 临时地图
    private StringBuilder str4 = new StringBuilder();   //记录信息

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        /* 按钮 */
        Button button1 = new Button_YG("入栈");
        Button button2 = new Button_FB("返回");
        Button button3 = new Button_RY("生成");
        Button button4 = new Button_DB("递归");
        Button button5 = new Button_FB("清空");
        Button button6 = new Button_PB("单步");
        Button button7 = new Button_GY("最优");

        /* 封面 */
        ImageView p2 = new ImageView("Image/hello5.bmp");//BMP图片文件很丝滑(清晰)
        p2.fitWidthProperty().bind(pane.widthProperty());
        p2.fitHeightProperty().bind(pane.heightProperty());
        pane.getChildren().add(p2);

        /* 标题 */
        Text text2 = new Text_GY("Find An Optimal Path");
        text2.setX(300);
        text2.setY(100);
        pane.getChildren().add(text2);

        /* 文本显示域 */
        Label label_PO = new Label_IP("坐标信息:");
        label_PO.setLayoutX(1100);
        label_PO.setLayoutY(310);
        TextArea textArea1 = new TextArea_FB();
        textArea1.setLayoutX(1100);
        textArea1.setLayoutY(365);
        textArea1.setPrefColumnCount(5);
        textArea1.setPrefRowCount(15);
        pane.getChildren().addAll(label_PO,textArea1);

        /*输出栏 1 */
        TextField textField1 = new TextField_FPB();
        textField1.setEditable(false);
        textField1.setPrefSize(600,60);
        textField1.setLayoutX(675);
        textField1.setLayoutY(180);
        pane.getChildren().add(textField1);

        /* 坐标输入标签 */
        Label label_1X = new Label_IP("X1:");
        label_1X.setLayoutX(900);
        label_1X.setLayoutY(310);
        Label label_1Y = new Label_IP("Y1:");
        label_1Y.setLayoutX(900);
        label_1Y.setLayoutY(365);
        pane.getChildren().addAll(label_1X,label_1Y);

        Label label_2X = new Label_IP("X2:");
        label_2X.setLayoutX(900);
        label_2X.setLayoutY(425);
        Label label_2Y = new Label_IP("Y2:");
        label_2Y.setLayoutX(900);
        label_2Y.setLayoutY(485);
        pane.getChildren().addAll(label_2X,label_2Y);

        /*输入栏 2.1  输入起始坐标 */
        TextField textField2_1X = new TextField_IP();
        textField2_1X.setEditable(true);
        textField2_1X.setPrefSize(100,50);
        textField2_1X.setLayoutX(975);
        textField2_1X.setLayoutY(300);
        TextField textField2_1Y = new TextField_IP();
        textField2_1Y.setEditable(true);
        textField2_1Y.setPrefSize(100,50);
        textField2_1Y.setLayoutX(975);
        textField2_1Y.setLayoutY(360);
        pane.getChildren().addAll(textField2_1X,textField2_1Y);

        /*输入栏 2.2 输入终点坐标 */
        TextField textField2_2X = new TextField_IP();
        textField2_2X.setEditable(true);
        textField2_2X.setPrefSize(100,50);
        textField2_2X.setLayoutX(975);
        textField2_2X.setLayoutY(420);
        TextField textField2_2Y = new TextField_IP();
        textField2_2Y.setEditable(true);
        textField2_2Y.setPrefSize(100,50);
        textField2_2Y.setLayoutX(975);
        textField2_2Y.setLayoutY(480);
        pane.getChildren().addAll(textField2_2X,textField2_2Y);

        /* 设置阶数 */
        Label label_Wd = new Label_IP("阶数:");
        label_Wd.setLayoutX(900);
        label_Wd.setLayoutY(545);
        TextField textField2_Wd = new TextField_IP();
        textField2_Wd.setEditable(true);
        textField2_Wd.setPrefSize(100,50);
        textField2_Wd.setLayoutX(975);
        textField2_Wd.setLayoutY(540);
        pane.getChildren().addAll(label_Wd,textField2_Wd);

        /* 显示步数 */
        Label label_EX = new Label_IP("步数");
        label_EX.setLayoutX(900);
        label_EX.setLayoutY(625);
        TextField textField2_EX = new TextField_OP();
        textField2_EX.setEditable(true);
        textField2_EX.setPrefSize(100,50);
        textField2_EX.setLayoutX(975);
        textField2_EX.setLayoutY(620);
        textField2_EX.setEditable(false);
        pane.getChildren().addAll(label_EX,textField2_EX);

        /* 返回按钮 */
        button2.setLayoutX(25);
        button2.setLayoutY(15);
        button2.setScaleX(1.0);
        button2.setScaleY(1.0);
        button2.setOnAction(event -> {
            // textField1.setText("主人还在酝酿……● _ ●");
            labyrinth_interface a1 = new labyrinth_interface();
            try {
                a1.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        pane.getChildren().add(button2);

        /* 生成按钮 */
        button3.setLayoutX(700);
        button3.setLayoutY(300);
        button3.setScaleX(1.0);
        button3.setScaleY(1.0);
        pane.getChildren().add(button3);
        button3.setOnAction(event -> {

            try {
                wideOfMaze = Integer.parseInt(textField2_Wd.getText());
                textField1.setText("指定阶数迷宫生成");
            }catch (Exception ex){
                textField1.setText("默认阶数迷宫生成");
            }

            LabyrinthMap_s labyrinthMap_s = new LabyrinthMap_s(wideOfMaze);
            map2 = labyrinthMap_s.getMap(); //获取多路迷宫

            Pane pane2 = new ShowPane(map2);
            pane2.setLayoutX(10);
            pane2.setLayoutY(200);
            pane.getChildren().add(pane2);

            /* 按钮 */
            button1.setDisable(false); //开始 亮
            button4.setDisable(false); //单步 亮
            button5.setDisable(false); //清空 亮
            button6.setDisable(true); //单步 灰
            button7.setDisable(false); //广优 亮
        });

        /* 栈 */
        button1.setLayoutX(700);
        button1.setLayoutY(400);
        button1.setScaleX(1.0);
        button1.setScaleY(1.0);
        pane.getChildren().add(button1);
        button1.setOnAction(event -> {
            try {
                X1 = Integer.parseInt(textField2_1X.getText());
                Y1 = Integer.parseInt(textField2_1Y.getText());
                X2 = Integer.parseInt(textField2_2X.getText());
                Y2 = Integer.parseInt(textField2_2Y.getText());
                textField1.setText("指定起始终止点寻路");
            }catch (Exception ex){
                textField1.setText("默认起始终止点寻路");
            }

            if(map2 != null ){
                //手动克隆……
                int[][] map3 = new int[map2.length][map2.length];
                for (int i = 0;i < map2.length;i ++){
                    System.arraycopy(map2[i], 0, map3[i], 0, map2.length);
                }

                /* 初始化 */  //手动克隆 单步记录
                map4 = new int[map2.length][map2.length];
                for (int i = 0; i < map2.length; i++) {
                    System.arraycopy(map2[i], 0, map4[i], 0, map2.length);
                }
                list1.clear();//单步点坐标 清空
                list_1.clear();//单步坐标信息 清空
                count = 0;

                Stack_Way stackWay = new Stack_Way(map3, X1, Y1, X2, Y2);
                map3 = stackWay.onlyWay();//静态调用
                list1 = stackWay.getList();

                steps = stackWay.getSteps();
                textField2_EX.setText(steps + "");

                StringBuilder str1 = new StringBuilder();/* 显示文本信息 */
                list_1 = stackWay.getList_s();
                for (String s : list_1) {
                    StringBuilder str2 = new StringBuilder();
                    str2.append(s).append("\n").append(str1);
                    str1 = str2;
                }
                textArea1.setText(str1.toString());

                Pane pane3 = new ShowPane(map3);
                pane3.setLayoutX(10);
                pane3.setLayoutY(200);
                pane.getChildren().add(pane3);
            }else{
                textField1.setText("地图未生成！╯△╰");
            }

            button1.setDisable(true);//生成 灰
            button6.setDisable(false);//单步 亮
        });

        /* 递归 */
        button4.setLayoutX(700);
        button4.setLayoutY(500);
        button4.setScaleX(1.0);
        button4.setScaleY(1.0);
        pane.getChildren().add(button4);
        button4.setOnAction(event -> {
            textField1.setText("人家害羞…●﹏●");

            try {
                X1 = Integer.parseInt(textField2_1X.getText());
                Y1 = Integer.parseInt(textField2_1Y.getText());
                X2 = Integer.parseInt(textField2_2X.getText());
                Y2 = Integer.parseInt(textField2_2Y.getText());
                textField1.setText("指定起始终止点寻路");
            }catch (Exception ex){
                textField1.setText("默认起始终止点寻路");
            }

            //手动克隆……
            int[][] map3 = new int[map2.length][map2.length];
            for (int i = 0;i < map2.length;i ++){
                System.arraycopy(map2[i], 0, map3[i], 0, map2.length);
            }

            /* 初始化 */ //手动克隆 单步记录
            map4 = new int[map2.length][map2.length];
            for (int i = 0; i < map2.length; i++) {
                System.arraycopy(map2[i], 0, map4[i], 0, map2.length);
            }
            list1.clear();//单步点坐标 清空
            list_1.clear();//单步坐标信息 清空
            count = 0;

            SpotWay spotWay = new SpotWay(map3,X1,Y1,X2,Y2);
            map3 = spotWay.onlyWay();
            list1 = spotWay.getList();

            steps = spotWay.getSteps();
            textField2_EX.setText(steps + "");

            StringBuilder str1 = new StringBuilder();/* 显示文本信息 */
            list_1 = spotWay.getList_s();
            for (String s : list_1) {
                StringBuilder str2 = new StringBuilder();
                str2.append(s).append("\n").append(str1);
                str1 = str2;
            }
            textArea1.setText(str1.toString());

            Pane pane3 = new ShowPane(map3);
            pane3.setLayoutX(10);
            pane3.setLayoutY(200);
            pane.getChildren().add(pane3);

            button6.setDisable(false); //单步 亮
            button4.setDisable(true);  //递归 灰
        });

        /* 广优 */
        button7.setLayoutX(700);
        button7.setLayoutY(600);
        button7.setScaleX(1.0);
        button7.setScaleY(1.0);
        pane.getChildren().add(button7);
        button7.setOnAction(event -> {

            try {
                X1 = Integer.parseInt(textField2_1X.getText());
                Y1 = Integer.parseInt(textField2_1Y.getText());
                X2 = Integer.parseInt(textField2_2X.getText());
                Y2 = Integer.parseInt(textField2_2Y.getText());
                textField1.setText("指定起始终止点寻路");
            }catch (Exception ex){
                textField1.setText("默认起始终止点寻路");
            }

            if(map2 != null ){
                //手动克隆……
                int[][] map3 = new int[map2.length][map2.length];
                for (int i = 0;i < map2.length;i ++){
                    System.arraycopy(map2[i], 0, map3[i], 0, map2.length);
                }

                /* 初始化 */ //手动克隆 单步记录
                map4 = new int[map2.length][map2.length];
                for (int i = 0; i < map2.length; i++) {
                    System.arraycopy(map2[i], 0, map4[i], 0, map2.length);
                }
                list1.clear();//单步点坐标 清空
                list_1.clear();//单步坐标信息 清空
                count = 0;

                WideOpti wideOpti = new WideOpti(map3,X1,Y1,X2,Y2);
                map3 = wideOpti.onlyWay();//静态调用
                list1 = wideOpti.getList();

                steps = wideOpti.getSteps();
                textField2_EX.setText(steps + "");

                StringBuilder str1 = new StringBuilder();/* 显示文本信息 */
                list_1 = wideOpti.getList_s();
                for (String s : list_1) {
                    StringBuilder str2 = new StringBuilder();
                    str2.append(s).append("\n").append(str1);
                    str1 = str2;
                }
                textArea1.setText(str1.toString());

                Pane pane3 = new ShowPane(map3);
                pane3.setLayoutX(10);
                pane3.setLayoutY(200);
                pane.getChildren().add(pane3);
            }else{
                textField1.setText("地图未生成！╯△╰");
            }

            button7.setDisable(true);//生成 灰
            button6.setDisable(false); //测试 亮
        });

        /* 单步 */
        button6.setLayoutX(900);
        button6.setLayoutY(700);
        button6.setScaleX(1.0);
        button6.setScaleY(1.0);
        pane.getChildren().add(button6);
        button6.setOnAction(event -> {
            try {

                map4[list1.get(count).getRow()][list1.get(count).getColumn()] = 8;
                StringBuilder str3 = new StringBuilder();
                str3.append(list_1.get(count));
                str3.append("\n").append(str4);
                str4 = str3;
                textArea1.setText(str4.toString());

                Pane pane4 = new ShowPane(map4);
                pane4.setLayoutX(10);
                pane4.setLayoutY(200);
                pane.getChildren().add(pane4);

                count++;
                if (count == list1.size())
                    button6.setDisable(true);// 单步 灰
                textField1.setText("count :" + count);

            }catch(Exception ex){
                //button6.setDisable(true);// 单步 灰
            }
        });

        /* 清空 */
        button5.setLayoutX(700);
        button5.setLayoutY(700);
        button5.setScaleX(1.0);
        button5.setScaleY(1.0);
        pane.getChildren().add(button5);
        button5.setOnAction(event -> {
            if(map2 != null ){

                list1.clear();//单步点坐标 清空
                list_1.clear();//单步坐标信息 清空
                count = 0;  //归零
                str4 = new StringBuilder();
                map4 = new int[map2.length][map2.length];
                for (int i = 0; i < map2.length; i++) {
                    System.arraycopy(map2[i], 0, map4[i], 0, map2.length);
                }//手动克隆 单步记录

                textArea1.clear();
                textField2_EX.clear();

                Pane pane3 = new ShowPane(map2);
                pane3.setLayoutX(10);
                pane3.setLayoutY(200);
                pane.getChildren().add(pane3);
                textField1.setText("已打扫干净！！！");
            }else{
                textField1.setText("地图未生成！╯△╰");
            }

            button1.setDisable(false); //生成 亮
            button4.setDisable(false); //递归 亮
            button6.setDisable(true); //单步 亮
            button7.setDisable(false); //广优 亮
        });

        /* 初始默认 */
        button1.setDisable(true); //开始 灰
        button4.setDisable(true); //单步 灰
        button5.setDisable(true); //清空 灰
        button6.setDisable(true); //测试 灰
        button7.setDisable(true); //广优 灰

        Scene scene = new Scene(pane);
        scene.setFill(Color.LIGHTSKYBLUE);

        primaryStage.setScene(scene);
        primaryStage.setWidth(1300);
        primaryStage.setHeight(900);
        primaryStage.setTitle("迷宫探索");
        //primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}


