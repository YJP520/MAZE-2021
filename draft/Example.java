//import java.util.Iterator;
//
//
//public class Example {
//
//    public static void main(String[] args) {
//
//        LabyrinthMap labyrinthMap = new LabyrinthMap(25);
//        int[][] maze = labyrinthMap.Draw();
//
//        byte[][] map = new byte[maze.length][maze.length];
//        for(int i = 0;i < maze.length;i ++){
//            for(int j = 0;j < maze.length;j ++){
//                if(maze[i][j] == 1)
//                    map[i][j] = 0;
//                else
//                    map[i][j] = 1;
//            }
//        }
//
//        Position start = new Position();        //开始点
//        Position finish = new Position(23, 23); //结束点
//
//        process(map, start, finish);   //寻找
//    }
//
//
//    /** 寻找路线 */
//    public static void process(byte[][] map, Position start, Position finish) {
//        Maze maze = new Maze(map, finish);
//
//        /* 判断 起始点 和 终点 是否合法 <不是墙，则有路可寻> */
//        if (!maze.valid(start) || !(maze.valid(finish))) {
//            System.out.println("failure");
//        } else {
//            /* 记录 开始点 */
//            maze.record(start);
//            /* 迭代 */
//            if (maze.done(start) || maze.tryToSolve(start)) {
//                System.out.println("success");
//            } else {
//                maze.undo(start);
//                System.out.println("failure");
//            }
//        }
//
//        /* 打印 */
//        for (byte[] b : map) {
//            for (byte t : b) {
//                if(t == 9)
//                    System.out.print("##");
//                else if(t == 0)
//                    System.out.print("██");
//                else
//                    System.out.print("  ");
//            }
//            System.out.println();
//        }
//    }
//}
//
///** 位置类 */
//class Position {
//
//    private int row;
//    private int column;
//
//    public Position() {//默认开始点
//        row = 1;
//        column = 1;
//    }
//
//    /** 确定点 */
//    public Position(int row, int column) {
//        this.row = row;
//        this.column = column;
//    }
//
//    public int getRow() {
//        return row;
//    }
//
//    public int getColumn() {
//        return column;
//    }
//}
//
///** 自定义迭代类 遍历上下左右相邻点 */
//class MazeIterator implements Iterator {
//
//    private int row;
//    private int column;
//    private int count = 0;
//
//    /*  */
//    public MazeIterator(Position position) {
//        this.row = position.getRow();
//        this.column = position.getColumn();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return count < 4;
//    }
//
//    @Override
//    public Object next() {
//        Position next = null;
//        // 遍历4个方向
//        switch (count++) {
//            case 0:
//                next = new Position(row - 1, column);//左
//                break;
//            case 1:
//                next = new Position(row, column - 1);//上
//                break;
//            case 2:
//                next = new Position(row + 1, column);//右
//                break;
//            case 3:
//                next = new Position(row, column + 1);//下
//        }
//        return next;
//    }
//
//    @Override
//    public void remove() {
//    }
//}
//
///** 寻找迷宫路径 */
//class Maze {
//
//    private static final byte WALL = 0;     // 墙
//    private static final byte CORRIDOR = 1; // 通道
//    private static final byte PATH = 9;     // 路径通过的位置
//    private static final byte TRIED = 2;    // 死胡同
//
//    public Position finish;
//
//    public byte[][] map;
//
//    public Maze(byte[][] map, Position finish) {
//        this.map = map;
//        this.finish = finish;
//    }
//
//    // 判断位置是否有效
//    public boolean valid(Position position) {
//        /*
//         * 1. [ 行 \ 列 ] 坐标满足 大于等于零 且 小于地图宽度
//         * 2. 这个点为 通道
//         */
//        if (position.getRow() >= 0 && position.getRow() < map.length &&
//            position.getColumn() >= 0 && position.getColumn() < map[0].length &&
//            map[position.getRow()][position.getColumn()] == CORRIDOR)
//        {
//            return true;
//        }
//        return false;
//    }
//
//    // 记录路径 通过的位置
//    public void record(Position position) {
//        map[position.getRow()][position.getColumn()] = PATH;
//    }
//
//    // 判断是否到达 目的地
//    public boolean done(Position position) {
//        return position.getRow() == finish.getRow() &&
//                position.getColumn() == finish.getColumn();
//        /*
//        * 直接判断是否为 结束点
//        */
//    }
//
//    /*如果走不通，就回退，并把此位置设置为 死胡同 */
//    public void undo(Position position) {
//        map[position.getRow()][position.getColumn()] = TRIED;//死胡同
//    }
//
//    // 自定义 迭代方法
//    public Iterator iterator(Position position) {
//        return new MazeIterator(position);
//    }
//
//    // 回溯策略的主要步骤
//    public boolean tryToSolve(Position position) {
//        boolean success = false;//初始
//
//        Iterator iterator = iterator(position);
//
//        /* 没有到达目的地，在这个位置的上下左右试探 */
//        while (!success && iterator.hasNext()) {
//            position = (Position) iterator.next();
//            // 如果该位置有效
//            if (valid(position)) {
//                record(position);// 记录该位置
//                /* 如果是目的地，结束 */
//                if (done(position)) {
//                    success = true;
//                } else {
//                    /* 如果是有效位置，但不是目的地，继续调用tryToSolve方法 */
//                    success = tryToSolve(position);
//                    /* 如果走不通 */
//                    if (!success) {
//                        undo(position);// 该位置为死胡同
//                    }
//                }
//            }
//        }
//        return success;
//    }
//}





/*  */
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//
//import java.util.Random;
//
//public class Test_Xiaxia extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    int height = 7;
//    int width = 7;
//
//    public void start(Stage primaryStage) throws Exception {
//
//        Pane pane = new Pane();
//
//        Label welcom = new Label("欢迎进入迷宫游戏!");
//        welcom.setFont(Font.font(STYLESHEET_CASPIAN, 20));
//        pane.getChildren().add(welcom);
//
//        Button start = new Button_YG("开始游戏");
//        start.setLayoutX(300);
//        start.setLayoutY(700);
//        pane.getChildren().add(start);
//
//        //开始 lambda表达式简化事件处理 P525页 单纯打印迷宫
//        start.setOnAction(event -> {
//            recursivedivision maze = new recursivedivision(height, width);
//            MyPane myPane = new MyPane(maze.createmaze());
//
//            pane.getChildren().add(myPane);;
//        });
//
//        Scene scene = new Scene(pane, 800, 800);
//        primaryStage.setTitle("迷宫游戏");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//}
//
//
////自定义地图面板
//class MyPane extends Pane {
//
//    public MyPane(int[][] map) {
//
//        /* 自定义地图总宽度 */
//        double width = 630;
//        double heigth = 630;
//
//        int length = map.length;
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                /* 在已知宽度下装入 N * M 个方块 */
//                Rectangle rectangle = new Rectangle(i * width / length,
//                                                    j * heigth / length, width / length, heigth / length);
//
//                rectangle.setStroke(Color.LIGHTBLUE);
//
//                if (map[j][i] == 0) {
//                    //墙
//                    rectangle.setFill(Color.DODGERBLUE);
////                    rectangle.setArcHeight(heigth / length * 0.5);
////                    rectangle.setArcWidth(width / length * 0.5);
//                } else if (map[j][i] == 1){
//                    //路
//                    rectangle.setFill(Color.LIGHTBLUE);
//                }else if (map[j][i] == 9){
//                    //路径
//                    rectangle.setFill(Color.DEEPPINK);
//                }else if (map[j][i] == 2){
//                    //死胡同
//                    rectangle.setFill(Color.GREY);
//                }else if (map[j][i] == 8){
//                    //单步
//                    rectangle.setFill(Color.YELLOWGREEN);
//                }
//
//                super.getChildren().add(rectangle);
//            }
//        }
//    }
//}
//
//
///** 迷宫地图  */
//class recursivedivision {
//    private static int[][] maze;
//    private final int wall = 0;
//    private final int way = 1;
//    private int width;
//    private int height;
//
//    recursivedivision(int height, int width) {
//        this.height = height;
//        this.width = width;
//    }// height代表x轴width代表y轴
//
//    public int[][] createmaze() {
//        maze = new int[height][width];
//        for (int x = 0; x < height; x++) {
//            for (int y = 0; y < width; y++) {
//                if (x == 0 || y == 0 || x == height - 1 || y == width - 1)
//                    maze[x][y] = wall;
//                else
//                    maze[x][y] = way;
//            } // 20-25 将迷宫初始化，把迷宫外侧添加一圈墙。其余均为路
//        }
//        maze[1][1] = way;
//        maze[height - 2][width - 2] = way;
//        division(1, 1, height - 2, width - 2);// 27-30 设置迷宫的起点和终点。
//        return maze;// 生成迷宫
//    }
//
//    private void division(int startx, int starty, int endx, int endy) {
//        if (endx - startx < 2 || endy - starty < 2)
//            return;
//        Random random = new Random();
//        int x = startx + random.nextInt(((endx - startx) / 2)) * 2 + 1;// 横着画线
//        int y = starty + random.nextInt(((endy - starty) / 2)) * 2 + 1;// 竖着画线
//        for (int i = startx; i < endx; i++) {
//            maze[i][y] = wall;
//        } // 竖着画线为墙
//        for (int i = starty; i < endy; i++) {
//            maze[x][i] = wall;
//        } // 横着画线为墙
//        // 36-43 对偶数行和列进行画墙壁
//
//        switch (random.nextInt(4)) {
//            case 0:
//                opendoor(x, starty, x, y - 1);// 1
//                opendoor(startx, y, x - 1, y);// 2
//                opendoor(x, y + 1, x, endy);// 3
//                break;
//            case 1:
//                opendoor(startx, y, x - 1, y);
//                opendoor(x, y + 1, x, endy);
//                opendoor(x + 1, y, endx, y);// 4
//                break;
//            case 2:
//                opendoor(x, y + 1, x, endy);
//                opendoor(x + 1, y, endx, y);
//                opendoor(x, starty, x, y - 1);
//                break;
//            case 3:
//                opendoor(x + 1, y, endx, y);
//                opendoor(x, starty, x, y - 1);
//                opendoor(startx, y, x - 1, y);
//
//        }// 顺时针画墙
//        division(startx, starty, x - 1, y - 1);// 左上
//        division(startx, y + 1, x - 1, endy);// 右上
//        division(x + 1, y + 1, endx, endy);// 右下
//        division(x + 1, starty, endx, y - 1);// 左下
////递归分割，继续划分区域
//    }
//
//    private void opendoor(int startx, int starty, int endx, int endy) {
//        Random random = new Random();
//        int x, y;
//        if (starty == endy) {
//            x = startx + random.nextInt((endx - startx) / 2 + 1) * 2;
//            maze[x][starty] = way;
//        }
//        if (startx == endx) {
//            y = starty + random.nextInt((endy - starty) / 2 + 1) * 2;
//            maze[startx][y] = way;
//        }
//    }// 对墙壁进行开洞选择奇数行列
//
//    public static void printmaze(int maze[][]) {
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[0].length; j++) {
//                if (maze[i][j] == 0)
//                    System.out.printf("0");
//                else
//                    System.out.printf("1");
//
//            }
//            System.out.printf("\n");
//        }
//    }
//}

