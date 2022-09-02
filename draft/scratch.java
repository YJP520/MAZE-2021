//class Scratch {
//    public static void main(String[] args) {
//
//    }
//}
//
////        /* 反向转换 兼容寻路 */
////        for(int i = 0;i < map.length;i ++){
////            for(int j = 0;j < map.length;j ++){
////                map[i][j] = (map[i][j] == 0 ? 1 : 0 );
////            }
////        }
//
////
////class tryIt {
////    private static final int direction[][] = {
////            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
////    };
////
////    /* 寻路 */
////    private static boolean go(int x, int y, mazeData data) {
////        if (!data.inArea(x, y)) {
////            System.out.println("点不在数组内");
////        }
////
////        data.isVisited[x][y] = true;
////        setData(x, y, data);
////
////        if (x == data.getExitX() && y == data.getExitY()) {
////            return true;
////        }
////
////        for (int i = 0; i < 4; i++) {
////            int newX = x + direction[i][0];
////            int newY = y + direction[i][1];
////            if (data.inArea(newX, newY) &&
////                    data.getMaze(newX, newY) == mazeData.ROAD &&
////                    !data.isVisited[newX][newY])
////                if (go(newX, newY, data))
////                    return true;
////        }
////
////        return false;
////    }
////
////    /* 遍历 */
////    private static void go_over(int x, int y, mazeData data) {
////        if (!data.inArea(x, y)) {
////            System.out.println("点不在数组内");
////        }
////
////        data.isVisited[x][y] = true;
////        setData(x, y, data);
////
////        if (x == data.getExitX() && y == data.getExitY()) {
////            return;
////        }
////
////        for (int i = 0; i < 4; i++) {
////            int newX = x + direction[i][0];
////            int newY = y + direction[i][1];
////            if (data.inArea(newX, newY) &&
////                    data.getMaze(newX, newY) == mazeData.ROAD &&
////                    !data.isVisited[newX][newY])
////                go_over(newX, newY, data);
////        }
////
////        return;
////    }
////
////    public static void run(mazeData data) {
////        go(data.getEntranceX(), data.getEntranceY(), data);//入口
////    }
////
////    public static void setData(int x, int y, mazeData data) {
////        if (data.inArea(x, y))
////            data.path[x][y] = true;
////        data.print();
////    }
////
////    public static void main_try() {
////        mazeData data = new mazeData();
////        LabyrinthMap labyrinthMap = new LabyrinthMap();
////        data.setMaze(labyrinthMap.Draw());
////        run(data);
////        data.print();
////    }
////
////}
//
//
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
//
//    @Override
//    public String toString(){
//        return "[ " + row + " , " + column + " ]";
//    }
//}