/*
 * @Date: 2021/06/12
 * @Author: Y.J.P
 * @Declaration:
 * The Modules class is used to offer various modules for options.
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Modules extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //演示模块！！！
    }
}


/*************************************************************/
/**	                   自定义 Button                         */
/**	    Since: 1.0     Description: Colorful                 */
/*************************************************************/

/** 黄绿色渐变 */
class Button_YG extends Button {
    public Button_YG(String s){
        super(s);
        /* 字体 大小 */
        super.setFont(Font.font("SimHei", 50));
        /* 颜色渐变 */
        super.setStyle("-fx-text-fill:BLACK;" +
            "-fx-background-color: linear-gradient(to right,#00fffc,#fff600)");
    }
}

/** 红蓝色渐变 */
class Button_RD extends Button{
    public Button_RD(String s){
        super(s);
        /* 字体 大小 */
        super.setFont(Font.font("SimHei",50));
        /* 颜色渐变 */
        super.setStyle("-fx-text-fill:BLACK;" +
            "-fx-background-color: linear-gradient(to right,#7B68EE,#FF1493)");
    }
}

/** 浅蓝色渐变 普通按钮 */
class Button_FB extends Button{
    public Button_FB(String s){
        super(s);
        /* 字体 大小 */
        super.setFont(Font.font("SimHei",50));
        /* 颜色渐变 */
        super.setStyle("-fx-text-fill:BLACK;" +
           "-fx-background-color: linear-gradient(to right,#00BFFF,#00FFFF)");
    }
}

/** 红黄色渐变 */
class Button_RY extends Button{
    public Button_RY(String s){
        super(s);
        /* 字体 大小 */
        super.setFont(Font.font("SimHei",50));
        /* 颜色渐变 */
        super.setStyle("-fx-text-fill:BLACK;" +
            "-fx-background-color: linear-gradient(to right,#FF1493,#FF7F50)");
    }
}

/** 浅蓝色渐变 */
class Button_DB extends Button{
    public Button_DB(String s){
        super(s);
        /* 字体 大小 */
        super.setFont(Font.font("SimHei",50));
        /* 颜色渐变 */
        super.setStyle("-fx-text-fill:BLACK;" +
           "-fx-background-color: linear-gradient(to right,#1E90FF,#00BFFF)");
    }
}

/** 蓝紫色渐变 */
class Button_PB extends Button{
    public Button_PB(String s){
        super(s);
        /* 字体 大小 */
        super.setFont(Font.font("SimHei",50));
        /* 颜色渐变 */
        super.setStyle("-fx-text-fill:BLACK;" +
            "-fx-background-color: linear-gradient(to right,#8A2BE2,#1E90FF)");
    }
}


/** 金黄色渐变 */
class Button_GY extends Button{
    public Button_GY(String s){
        super(s);
        /* 字体 大小 */
        super.setFont(Font.font("SimHei",50));
        /* 颜色渐变 */
        super.setStyle("-fx-text-fill:BLACK;" +
            "-fx-background-color: linear-gradient(to right,#FFD700,#FF7F50)");
    }
}

/** 蓝紫色渐变 */
class Button_SET extends Button{
    public Button_SET(String s){
        super(s);

        Polygon polygon = new Polygon();
        ObservableList<Double> list = polygon.getPoints();
        double centerX = 300,centerY = 300;
        double radius = 40;
        for(int i = 0;i < 6;i ++){
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
        }

        super.shapeProperty().set(polygon);
        /* 字体 大小 */
        super.setFont(Font.font("SimHei",50));
        /* 颜色渐变 */
        super.setStyle("-fx-text-fill:BLACK;" +
            "-fx-background-color: linear-gradient(to right,#8A2BE2,#1E90FF)");
    }
}


/*************************************************************/
/**	                   自定义 TextField                       */
/**	    Since: 1.0     Description: Colorful                 */
/*************************************************************/

/** 浅紫蓝色文本框 */
class TextField_FPB extends TextField {

    public  TextField_FPB() {
        /* 字体 */
        super.setFont(Font.font("KaiTi", 60));
        /* 渐变色 */
        super.setStyle("-fx-text-fill:HOTPINK;" +
            "-fx-background-color: linear-gradient(to right,#6A5ACD,#4169E1)");
    }
}

/** 浅紫蓝色文本框  小文本输入框 */
class TextField_IP extends TextField {

    public  TextField_IP() {
        /* 字体 */
        super.setFont(Font.font("KaiTi",30));
        /* 渐变色 */
        super.setStyle("-fx-text-fill:MEDIUMBLUE;" +
            "-fx-background-color: linear-gradient(to right,#90EE90,#7CFC00)");
    }
}

/** 浅紫蓝色文本框  小文本输入框 */
class TextField_OP extends TextField {

    public  TextField_OP() {
        /* 字体 */
        super.setFont(Font.font("KaiTi",30));
        /* 渐变色 */
        super.setStyle("-fx-text-fill:GOLD;" +
             "-fx-background-color: linear-gradient(to right,#9400D3,#8A2BE2)");
    }
}


/*************************************************************/
/**	                   自定义 Text                           */
/**	    Since: 1.0     Description: Colorful                 */
/*************************************************************/

/* 渐变色 */
class Text_RB extends Text {
    public Text_RB(String s) {
        super(s);
        super.setFont(Font.font("Microsoft YaHei",90));
        //text1.setFill(Color.rgb(230,10,110));//（red，green,blue）想怎么调整就怎么调
        /* 渐变色 */
        super.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT,
              new Stop(0.2f, Color.BLUE), new Stop(0.6f, Color.DEEPPINK)));
        super.setStyle("-fx-font-weight: bold");//字体加粗
    }
}

/* 渐变色 */
class Text_GY extends Text {
    public Text_GY(String s) {
        super(s);
        super.setFont(Font.font("Microsoft YaHei",90));
        //text1.setFill(Color.rgb(230,10,110));//（red，green,blue）想怎么调整就怎么调
        /* 渐变色 */
        super.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT,
             new Stop(0.2f, Color.CYAN), new Stop(0.6f, Color.GREENYELLOW)));
        super.setStyle("-fx-font-weight: bold");//字体加粗
    }
}


/* 渐变色 */
class Text_LA extends Text {
    public Text_LA(String s) {
        super(s);
        super.setFont(Font.font("Microsoft YaHei",90));
        //text1.setFill(Color.rgb(230,10,110));//（red，green,blue）想怎么调整就怎么调
        /* 渐变色 */
        super.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT,
              new Stop(0.2f, Color.LIME), new Stop(0.6f, Color.AQUA)));
        super.setStyle("-fx-font-weight: bold");//字体加粗
    }
}


/*************************************************************/
/**	                   自定义 label                           */
/**	    Since: 1.0     Description: Colorful                 */
/*************************************************************/

/* 输入框 标签 */
class Label_IP extends Label {
    public Label_IP(String s){
        super(s);
        super.setFont(Font.font("Microsoft YaHei",30));
        super.setStyle("-fx-text-fill:LIGHTCYAN");
    }
}

/*************************************************************/
/**	                   自定义 TextArea                        */
/**	    Since: 1.0     Description: Colorful                 */
/*************************************************************/

/* 普通 textArea */
class TextArea_CO extends TextArea{
    public TextArea_CO(){
        super.setEditable(true);
        super.setWrapText(true);
        super.setFont(Font.font("Times", 20));
        super.setStyle("-fx-control-inner-background:LIGHTSKYBLUE;");
        super.setWrapText(true);
    }
}

/* 普通 炫彩 */
class TextArea_FB extends TextArea{
    public TextArea_FB(){
        super.setEditable(true);
        super.setWrapText(true);
        super.setFont(Font.font("Times", 20));
        super.setStyle("-fx-control-inner-background:PALEGREEN");
        super.setWrapText(true);
    }
}


/*************************************************************/
/**	                   自定义 Pane                           */
/**	    Since: 1.0     Description: Colorful                 */
/*************************************************************/

//测试面板
class ShowPane extends Pane{

    public ShowPane(int[][] map) {
        double width = 630;
        double heigth = 630;

        int length = map.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Rectangle rectangle = new Rectangle(i * width / length,
                   j * heigth / length, width / length, heigth / length);

                rectangle.setStroke(Color.LIGHTBLUE);

                if (map[j][i] == 1) {
                    //墙
                    rectangle.setFill(Color.DODGERBLUE);
                    rectangle.setArcHeight(heigth / length * 0.5);
                    rectangle.setArcWidth(width / length * 0.5);
                } else if (map[j][i] == 0){
                    //路
                    rectangle.setFill(Color.LIGHTBLUE);
                }else if (map[j][i] == 9){
                    //路径
                    rectangle.setFill(Color.DEEPPINK);
                }else if (map[j][i] == 2){
                    //死胡同
                    rectangle.setFill(Color.GREY);
                }else if (map[j][i] == 8){
                    //单步
                    rectangle.setFill(Color.YELLOWGREEN);
                }

                super.getChildren().add(rectangle);
            }
        }
    }
}
