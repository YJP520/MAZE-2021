import java.util.ArrayList;
import java.util.LinkedList;

/* ************** 队列 广度优先遍历 **************************************************************** */

/** 寻找路线 */
public class WideOpti {

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
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    boolean isSolved = false;

    /* 执行 */
    public void run() {
        setData(-1,-1);

        LinkedList<Position> queue = new LinkedList<>();
        Position entrance = new Position(data.getEntranceX(), data.getEntranceY());
        queue.addLast(entrance);
        data.isVisited[entrance.getRow()][entrance.getColumn()] = true;

        while (queue.size() != 0) {
            Position curpos = queue.pop();
            setData(curpos.getRow(),curpos.getColumn());
            list.add(curpos);
            list_s.add(curpos.toString());

            if (curpos.getRow() == data.getExitX()
                    && curpos.getColumn() == data.getExitY()) {
                isSolved = true;
                findPath(curpos);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curpos.getRow() + direction[i][0];
                int newY = curpos.getColumn() + direction[i][1];

                if (data.inArea(newX, newY)
                        && !data.isVisited[newX][newY]
                        && data.getMaze(newX, newY) == mazeData.ROAD) {
                    queue.addLast((new Position(newX, newY,curpos)));
                    data.isVisited[newX][newY] = true;
                }
            }
//            if (!isSolved)
//                System.out.println("迷宫无解！");
        }

        /* 地图标记 */   /* 生成最终路径 */
        for(int i = 0;i < data.getN();i ++){
            for(int j = 0;j < data.getM();j ++){
                if(data.result[i][j]){
                    data.getMaze()[i][j] = 9;
                    steps ++;
                }else if(data.maze[i][j] == mazeData.ROAD && data.path[i][j] == 2){
                    data.maze[i][j] = 2;
                }
            }
        }
    }

    /* 找路径 */
    private void findPath(Position des){
        Position cur = des;
        while(cur != null){
            data.result[cur.getRow()][cur.getColumn()] = true;
            cur = cur.getPrev();
        }
    }

    /* 标记 */
    private void setData(int x, int y) {
        if (data.inArea(x, y)) {
            data.path[x][y] = 2;
        }
    }

    mazeData data;  //公共对象

    /* 构造方法 */
    public WideOpti(int[][] map,int x1,int y1,int x2,int y2){
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
        data.setResult();
    }

    /* 寻路 */
    public int[][] onlyWay(){
        run();
        return data.maze;
    }

}

