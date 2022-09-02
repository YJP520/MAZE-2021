import java.util.ArrayList;

/**
 * 递归 深度优先遍历
 */

/* 唯一路径 */
class SpotWay{

    /* 字符串坐标信息 */
    private ArrayList<String> list_s = new ArrayList<>();
    public ArrayList<String> getList_s() {
        return list_s;
    }

    /* 记录单步信息 */
    private ArrayList<Position> list = new ArrayList<>();
    public ArrayList<Position> getList() {
        return list;
    }

    /* 找到路线步数 */
    private int steps = 0;
    public int getSteps() {
        return steps;
    }

    /* 遍历四周 */
    private static final int direction[][] = {
            {-1,0},{0,1},{1,0},{0,-1}
    };

    /* 执行 */
    public void run(){
        go(data.getEntranceX(),data.getEntranceY());//入口
        /* 地图标记 */
        for(int i = 0;i < data.getN();i ++){
            for(int j = 0;j < data.getM();j ++){
                if(data.maze[i][j] == mazeData.ROAD && data.path[i][j] == 9) {
                    data.maze[i][j] = 9;
                    steps ++;
                }else if(data.maze[i][j] == mazeData.ROAD && data.path[i][j] == 2){
                    data.maze[i][j] = 2;
                }
            }
        }
    }

    /* 标记 */
    private void setData(int x, int y){
        if(data.inArea(x,y)) {
            data.path[x][y] = 9;
        }
        //data.print(); //单步策略
    }

    /* 递归 寻路 */
    private boolean go(int x, int y){
        if(!data.inArea(x,y)){
            return false;
        }

        data.isVisited[x][y] = true;
        setData(x,y);
        list.add(new Position(x,y));
        list_s.add((new Position(x,y)).toString());

        if(x == data.getExitX() && y == data.getExitY()){
            return true; /* 找到终点 */
        }

        for(int i = 0;i < 4;i ++){
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if(data.inArea(newX,newY) &&
                    data.getMaze(newX,newY) == mazeData.ROAD &&
                    !data.isVisited[newX][newY]) {
                if (go(newX, newY)) {
                    return true;
                }
            }
        }
        /* 遍历到死胡同 */
        data.path[x][y] = 2;//去掉就是遍历的路程
        return false;
    }

    mazeData data;  //公共对象

    /* 构造方法 */
    public SpotWay(int[][] map,int x1,int y1,int x2,int y2){
        data = new mazeData();
        data.setMaze(map);
        data.setEntranceX(x1);
        data.setEntranceY(y1);
        data.setExitX(x2);
        data.setExitY(y2);
        data.setN(map.length);
        data.setM(map.length);
        data.setIsVisited();
        data.setPath();
    }

    /* 寻路 */
    public int[][] onlyWay(){
        run();
        return data.maze;
    }

}


class mazeData{

    public static final int WALL = 1;
    public static final int ROAD = 0;

    /* 迷宫 */
    public int[][] maze;
    public int[][] getMaze() {
        return maze;
    }
    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    private int N = 21,M = 21;
    public void setN(int n) {
        N = n;
    }
    public void setM(int m) {
        M = m;
    }
    public int getN() {
        return N;
    }
    public int getM() {
        return M;
    }

    /* 构造方法 */
    public mazeData(){}
    public mazeData(int N,int M){
        this.N = N;
        this.M = M;
    }

    /* 入口 出口 */
    private int entranceX = 1,entranceY = 1;
    private int exitX = N - 2,exitY = M - 2;
    public void setEntranceX(int entranceX) {
        this.entranceX = entranceX;
    }
    public void setEntranceY(int entranceY) {
        this.entranceY = entranceY;
    }
    public void setExitX(int exitX) {
        this.exitX = exitX;
    }
    public void setExitY(int exitY) {
        this.exitY = exitY;
    }

    public int getEntranceX() {
        return entranceX;
    }
    public int getEntranceY() {
        return entranceY;
    }
    public int getExitX() {
        return exitX;
    }
    public int getExitY() {
        return exitY;
    }

    /* 是否访问过 */
    public boolean[][] isVisited;
    public void setIsVisited() {
        this.isVisited =  new boolean[N][M];
    }

    /* 路径 */
    public int[][] path;
    public void setPath() {
        this.path = new int[N][M];
    }
    public int[][] getPath() {
        return path;
    }

    /* 栈 返回寻路 标记 */
    boolean[][] result;
    public void setResult() {
        this.result = new boolean[N][M];
    }
    public boolean[][] getResult() {
        return result;
    }

    /* 返回指定点的标记 */
    public int getMaze(int x,int y){
        if(inArea(x,y)){
            return maze[x][y];
        }else{
            System.out.println("点不在数组里");
        }
        return -1;
    }

    /* 是否在区域内 */
    public boolean inArea(int x, int y){
        if(x >= 0 && y > 0 && x <= N && y < M){
            return true;
        }else{
            return false;
        }
    }

}


/** 位置类 */
class Position {

    private int row;
    private int column;
    private Position prev;//前一个节点
    public Position getPrev() {
        return prev;
    }

    public Position() {//默认开始点
        row = 1;
        column = 1;
    }

    /** 确定点 */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /** 确定点 */
    public Position(int row, int column,Position prev) {
        this.row = row;
        this.column = column;
        this.prev = prev;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString(){
        return "[ " + row + " , " + column + " ]";
    }
}
