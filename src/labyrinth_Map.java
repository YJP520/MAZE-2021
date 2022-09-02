/*
 * @Date 2021/06/19
 * @Author Y.J.P
 * @Declaration
 *      1.Java面向对象程序设计综合实践——迷宫；
 *      2.迷宫底层算法思想；
 *      3.实现迷宫地图的递归生成；
 */

import java.util.Random;


/**
 * @Declaration
 * #参照资料所做，迷宫简约而不简单
 * @Explanation
 * #递归的方法画一个迷宫 返回二维数组
 */
class LabyrinthMap{
    /* 宽 */
    private int width = 21;

    /* 标记 */
    final static int ROUTE = 0;
    final static int WALL = 1;

    /** constructor */
    public LabyrinthMap(){
    }

    /** constructor */
    public LabyrinthMap(int width){
        this.width = width;
    }

    /** 设置阶数 */
    public int getWidth() {
        return this.width;
    }

    /** 设置阶数 */
    public void setWidth(int width) {
        this.width = width;
    }

    /** 分割 */
     private void CreateMaze(int[][] maze, int x1, int y1, int x2, int y2){
         Random random = new Random();

        /* 判断是否继续分割 */
         if(x2 - x1 < 2 || y2 - y1 < 2){
            return;
         }

        /* 随机取点 */
         int number1 = 0;
         while(true){
             number1 = random.nextInt(100) % (x2 - x1 - 1);
             if(number1 % 2 == 0)
                 break;
         }
         int x = x1 + 1 + number1;

         int number2 = 0;
         while(true){
             number2 = random.nextInt(100) % (y2 - y1 - 1);
             if(number2 % 2 == 0)
                 break;
         }
         int y = y1 + 1 + number2;

        /* 横竖画墙 */
         for(int i = x1;i <= x2;i ++)
             maze[i][y] = WALL;
         for(int i = y1;i <= y2;i ++)
             maze[x][i] = WALL;

        /**
         *  @Means 递归分割，继续划分区域。
         *  @Thought 在已经分割的区域内继续判断是否可以继续分割，直到不能分割为止；
         */
         CreateMaze(maze,x1,y1,x - 1,y - 1);
         CreateMaze(maze,x + 1,y + 1,x2,y2);
         CreateMaze(maze,x + 1,y1,x2,y - 1);
         CreateMaze(maze,x1,y + 1,x - 1,y2);

        /* 随机选取其中的三面墙 */
         int[] r = new int [4];
         r[random.nextInt(100) % 4] = 1;//反向

        /* 在墙上随机取点开孔 */
         for(int i = 0;i < 4;i ++){
             if(r[i] == 0){
                 int rx = x;
                 int ry = y;
                 switch(i){
                     case 0:
                        do{ rx = x1 + random.nextInt(100) % (x - x1);
                        }while(maze[rx-1][ry]+maze[rx+1][ry]+
                                maze[rx][ry-1]+maze[rx][ry+1] > 2*WALL);
                        break;
                    case 1:
                        do{ ry = y + 1 + random.nextInt(100) % (y2 - y);
                        }while(maze[rx-1][ry]+maze[rx+1][ry]+
                                maze[rx][ry-1]+maze[rx][ry+1] > 2*WALL);
                        break;
                    case 2:
                        do{ rx = x + 1 + random.nextInt(100) % (x2 - x);
                        }while(maze[rx-1][ry]+maze[rx+1][ry]+
                                maze[rx][ry-1]+maze[rx][ry+1] > 2*WALL);
                        break;
                    case 3:
                        do{ ry = y1 + random.nextInt(100) % (y - y1);
                        }while(maze[rx-1][ry]+maze[rx+1][ry]+
                                maze[rx][ry-1]+maze[rx][ry+1] > 2*WALL);
                        break;
                    default:
                        break;
                }
                maze[rx][ry] = ROUTE;
             }
         }
     }

    /** 绘制 */
     public int[][] Draw(){

        /* 迷宫地图 */
        int[][] maze = new int[width][width];

        /* 初始化数组 生成外墙 */
        for(int i = 0;i < width;i ++){
            maze[0][i] =  WALL;
            maze[i][0] = WALL;
            maze[width-1][i] = WALL;
            maze[i][width - 1] = WALL;
        }
        /* 开始挖图 */
        CreateMaze(maze,1,1,width - 2,width - 2);

        /* 入口 和 出口 */
        //maze[1][0] = ROUTE;
        //maze[width - 2][width - 1] = ROUTE;

        return maze;
    }
}

class LabyrinthMap_s{
    private int[][] map;

    public LabyrinthMap_s(int Width){
        LabyrinthMap labyrinthMap = new LabyrinthMap(Width);
        map = labyrinthMap.Draw();
    }

    public int[][] getMap() {//int count
        int flag = 0;//计数
        Random random = new Random();

        /* 继续修改 */
        for(int k = 0;k < map.length / 2;k ++) {
            for (int i = 2; i < map.length - 1; i += 2) {
                int num = random.nextInt(map.length - 2);
                while (num % 2 != 0 || num == 0) {
                    num = random.nextInt(map.length - 2);
                }
                if (map[i][num] == 1) {
                    map[i][num] = 0;
                    if ((flag++) >= map.length / 2)
                        break;
                }
            }
            if ((flag++) >= map.length / 2)
                break;
        }
        return map;
    }
}



