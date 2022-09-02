//import java.util.Random;
//import java.util.Stack;
//
///**
// * @Date 2021/06/09
// * @Author Y.J.P
// * @Declaration
// *      1.Java面向对象程序设计综合实践——迷宫；
// *      2.迷宫底层算法思想；
// *      3.实现迷宫地图的递归生成；
// *      4.实现迷宫寻路方法的封装。
// */
//public class labyrinth_derive {
//
//    /**  */
//    public static void main(String[] args){
//        System.out.println("生成迷宫！");
//
//        LabyrinthMap labyrinthMap = new LabyrinthMap(21);
//        int[][] maze = labyrinthMap.Draw();
//
//        for(int i = 0;i < maze.length;i ++){
//            for(int j = 0;j < maze.length;j ++){
//                if(maze[i][j] == LabyrinthMap.WALL){
//                    System.out.print("██");
//                }else{
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }
//
//        int[] begin = {1,1};
//        int[] end = {maze.length - 2, maze.length - 1};
//        findWay(maze,begin,end);
//    }
//
//    public static void findWay(int[][] map,int[] begin,int[] end){
//        final int UP = -1;
//        final int DOWN = 1;
//        final int LEFT = -1;
//        final int RIGHT = 1;
//
//        final int LENGTH = map.length;
//
//        Stack<int[]> stack = new Stack<>();
//        int[] position = suround(map, begin);//四周判断
//        begin = connect(begin,position);
//        stack.add(begin);
//
//        int i = begin[0],j = begin[1];
//        map[i][j] = 2;
//        int flag = 0;
//        while(true){
//            if(i + 1 < LENGTH && j + 1 < LENGTH) {//不越出条件
//                if (map[i + 1][j] == 0) {//简单判断
//                    flag = 2;
//                    i += DOWN;
//                    map[i][j] = 4;
//                }else if (map[i][j + 1] == 0) {//简单判断
//                    flag = 1;
//                    j += RIGHT;
//                    map[i][j] = 2;
////                }else if (map[i][j - 1] == 0) {//简单判断
////                    flag = 3;
////                    j += LEFT;
////                    map[i][j] = 6;
////                }else if (map[i - 1][j] == 0) {//简单判断
////                    flag = 4;
////                    i += UP;
//////                    int[] position_temp = suround(map, begin);//四周判断
//////                    int[] begin_temp = connect(begin, position_temp);
//////                    stack.add(begin_temp);
////                    map[i][j] = 8;
//                }
//            }
//
//            if(map[i][j + 1] == 1 && map[i + 1][j] == 1)//&&map[i][j - 1] == 1
//                break;
//            if(i > 17 && j > 17)
//                break;
//        }
//
//        System.out.println("坐标 : (" + stack.peek()[0] + "," + stack.peek()[1] + ")");
////        for(int l = 0;l < stack.peek().length;l ++){
////            System.out.print(stack.peek()[l] + " ");
////        }
////        System.out.println();
//
//        for(int k = 0;k < LENGTH;k ++){
//            for(int v = 0;v < LENGTH;v ++){
//                if(map[k][v] == LabyrinthMap.WALL){
//                    System.out.print("██");
//                }else if(map[k][v] == LabyrinthMap.ROUTE){
//                    System.out.print("  ");
//                }else if(map[k][v] == 2){
//                    System.out.print("->");
//                }else if(map[k][v] == 4){
//                System.out.print("↓ ");//↑↓→←
//                }else if(map[k][v] == 6){
//                    System.out.print("<-");//↑↓→←
//                }else if(map[k][v] == 8){
//                System.out.print("↑ ");//↑↓→←
//                }
//            }
//            System.out.println();
//        }
//
//    }
//
//    public static int[] suround(int[][] map,int[] b){
//        int[] position = new int[4];
//        if (map[b[0] - 1][b[1]] == 1)//上
//            position[0] = 1;
//        else
//            position[0] = 0;
//        if (map[b[0] + 1][b[1]] == 1)//下
//            position[1] = 1;
//        else
//            position[1] = 0;
//        if (map[b[1] - 1][b[1]] == 1)//左
//            position[2] = 1;
//        else
//            position[2] = 0;
//        if (map[b[1] + 1][b[1]] == 1)//右
//            position[3] = 1;
//        else
//            position[3] = 0;
//
//        return position;
//    }
//
//    public static int[] connect(int[] A,int[] B){
//        int length = A.length + B.length;
//        int[] AB = new int[length];
//        for(int i = 0;i < length;i ++){
//            if(i <  A.length)
//                AB[i] = A[i];
//            else
//                AB[i] = B[i - A.length];
//        }
//        return AB;
//    }
//
//    public static boolean isRoad(int[] position){
//        for(int i = 1;i < position.length;i ++){
//            if(position[i] == 0)
//                return true;
//        }
//        return false;
//    }
//}
//
///**
// * @Declaration
// * #参照资料所做，迷宫简约而不简单
// * @Explanation
// * #递归的方法画一个迷宫 返回二维数组
// */
//class LabyrinthMap{
//    /* 宽 */
//    private int width = 21;
//
//    /* 标记 */
//    final static int ROUTE = 0;
//    final static int WALL = 1;
//
//    /** constructor */
//    public LabyrinthMap(){
//    }
//
//    /** constructor */
//    public LabyrinthMap(int width){
//        this.width = width;
//    }
//
//    /** 设置阶数 */
//    public int getWidth() {
//        return this.width;
//    }
//
//    /** 设置阶数 */
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    /** 分割 */
//     private void CreateMaze(int[][] maze, int x1, int y1, int x2, int y2){
//         Random random = new Random();
//
//        /* 判断是否继续分割 */
//         if(x2 - x1 < 2 || y2 - y1 < 2){
//            return;
//         }
//
//        /* 随机取点 */
//         int number1 = 0;
//         while(true){
//             number1 = random.nextInt(100) % (x2 - x1 - 1);
//             if(number1 % 2 == 0)
//                 break;
//         }
//         int x = x1 + 1 + number1;
//
//         int number2 = 0;
//         while(true){
//             number2 = random.nextInt(100) % (y2 - y1 - 1);
//             if(number2 % 2 == 0)
//                 break;
//         }
//         int y = y1 + 1 + number2;
//
//        /* 横竖画墙 */
//         for(int i = x1;i <= x2;i ++)
//             maze[i][y] = WALL;
//         for(int i = y1;i <= y2;i ++)
//             maze[x][i] = WALL;
//
//        /**
//         *  @Means 递归分割，继续划分区域。
//         *  @Thought 在已经分割的区域内继续判断是否可以继续分割，直到不能分割为止；
//         */
//         CreateMaze(maze,x1,y1,x - 1,y - 1);
//         CreateMaze(maze,x + 1,y + 1,x2,y2);
//         CreateMaze(maze,x + 1,y1,x2,y - 1);
//         CreateMaze(maze,x1,y + 1,x - 1,y2);
//
//        /* 随机选取其中的三面墙 */
//         int[] r = new int [4];
//         r[random.nextInt(100) % 4] = 1;//反向
//
//        /* 在墙上随机取点开孔 */
//         for(int i = 0;i < 4;i ++){
//             if(r[i] == 0){
//                 int rx = x;
//                 int ry = y;
//                 switch(i){
//                     case 0:
//                        do{ rx = x1 + random.nextInt(100) % (x - x1);
//                        }while(maze[rx-1][ry]+maze[rx+1][ry]+
//                                maze[rx][ry-1]+maze[rx][ry+1] > 2*WALL);
//                        break;
//                    case 1:
//                        do{ ry = y + 1 + random.nextInt(100) % (y2 - y);
//                        }while(maze[rx-1][ry]+maze[rx+1][ry]+
//                                maze[rx][ry-1]+maze[rx][ry+1] > 2*WALL);
//                        break;
//                    case 2:
//                        do{ rx = x + 1 + random.nextInt(100) % (x2 - x);
//                        }while(maze[rx-1][ry]+maze[rx+1][ry]+
//                                maze[rx][ry-1]+maze[rx][ry+1] > 2*WALL);
//                        break;
//                    case 3:
//                        do{ ry = y1 + random.nextInt(100) % (y - y1);
//                        }while(maze[rx-1][ry]+maze[rx+1][ry]+
//                                maze[rx][ry-1]+maze[rx][ry+1] > 2*WALL);
//                        break;
//                    default:
//                        break;
//                }
//                maze[rx][ry] = ROUTE;
//             }
//         }
//     }
//
//    /** 绘制 */
//     public int[][] Draw(){
//
//        /* 迷宫地图 */
//        int[][] maze = new int[width][width];
//
//        /* 初始化数组 生成外墙 */
//        for(int i = 0;i < width;i ++){
//            maze[0][i] =  WALL;
//            maze[i][0] = WALL;
//            maze[width-1][i] = WALL;
//            maze[i][width - 1] = WALL;
//        }
//        /* 开始挖图 */
//        CreateMaze(maze,1,1,width - 2,width - 2);
//
//        /* 入口 和 出口 */
//        //maze[1][0] = ROUTE;
//        //maze[width - 2][width - 1] = ROUTE;
//
//        return maze;
//    }
//}
//
//
//
