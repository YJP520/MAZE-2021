/**
 * @Date 2021/06/14
 * @Author Y.J.P
 * @Declaration
 *      1.Java面向对象程序设计综合实践——迷宫；
 *      2.迷宫底层算法思想；
 *      3.实现迷宫寻路方法的封装。
 */

import java.util.ArrayList;
import java.util.Iterator;

/** 寻找路线 */
public class Find {

    /** Default Constructor */
    public Find(){}

    /* 字符串坐标信息 */
    private StringBuilder str1 = new StringBuilder();
    public StringBuilder getStr1() {
        return str1;
    }

    /* 记录单步信息 */
    private ArrayList<Position> list = new ArrayList<>();
    public ArrayList<Position> getList() {
        return list;
    }

    /* 路径步数 */
    private int steps;
    public int getSteps() {
        return steps;
    }

    /** 寻找路线 单路寻找 */
    public int[][] process(int[][] map, Position start, Position finish) {
        Maze maze = new Maze(map, finish);

        /* 判断 起始点 和 终点 是否合法 <不是墙，则有路可寻> */
        if (!maze.valid(start) || !(maze.valid(finish))) {
            System.out.println("failure1");
        } else {
            /* 记录 开始点 */
            maze.remark(start);
            /* 迭代 */
            if (maze.destination(start) || maze.tryToSolve(start)) {
                /* 要么开始点是终点，要么就迭代找到终点 */
                System.out.println("success");
            } else {
                maze.undo(start);
                System.out.println("failure2");
            }
        }
        list = maze.getList();
        str1.append(maze.getStr1());
        steps = maze.getSteps();
        return maze.map;//返回修改后的路
    }

}


/** 寻找迷宫路径 */
class Maze {

    private static final byte WALL = 1;     // 墙
    private static final byte CORRIDOR = 0; // 通道
    private static final byte PATH = 9;     // 路径通过的位置
    private static final byte TRIED = 2;    // 死胡同

    /* 字符串坐标信息 */
    private StringBuilder str1 = new StringBuilder();
    public StringBuilder getStr1() {
        return str1;
    }

    /* 记录单步信息 */
    private ArrayList<Position> list = new ArrayList<>();
    public ArrayList<Position> getList() {
        return list;
    }

    /* 路径步数 */
    private int steps = 0;
    public int getSteps() {
        return steps;
    }

    public Position finish;

    public int[][] map;

    public Maze(int[][] map, Position finish) {
        this.map = map;
        this.finish = finish;
    }

    // 判断位置是否有效
    public boolean valid(Position position) {
        /*
         * 1. [ 行 \ 列 ] 坐标满足 大于等于零 且 小于地图宽度
         * 2. 这个点为 通道
         */
        if (position.getRow() >= 0 && position.getRow() < map.length &&
                position.getColumn() >= 0 && position.getColumn() < map[0].length &&
                map[position.getRow()][position.getColumn()] == CORRIDOR)
        {
            return true;
        }
        return false;
    }

    /* 标记路径 通过的位置 */
    public void remark(Position position) {
        map[position.getRow()][position.getColumn()] = PATH;
        steps ++;
    }

    /*如果走不通，就回退，并把此位置设置为 死胡同 */
    public void undo(Position position) {
        map[position.getRow()][position.getColumn()] = TRIED;//死胡同
        steps --;
    }


    // 判断是否到达 目的地
    public boolean destination(Position position) {
        return position.getRow() == finish.getRow() &&
               position.getColumn() == finish.getColumn();
        /*
         * 直接判断是否为 结束点
         */
    }

    /* 自定义 迭代方法 */
    public Iterator iterator(Position position) {
        return new MazeIterator(position);
    }

    /* 回溯策略的主要步骤 递归 */
    public boolean tryToSolve(Position position) {
        boolean success = false;//初始

        Iterator iterator = iterator(position);

        /* 没有到达目的地，在这个位置的上下左右试探 */
        while (!success && iterator.hasNext()) {
            position = (Position) iterator.next();  //获得下一个位置
            if (valid(position)) {                  // 如果该位置有效
                remark(position);                   // 记录该位置

                list.add(position);
                str1.append(position.toString() + "\n");

                if (destination(position)) {        // 如果是目的地，结束
                    success = true;
                } else {// 如果是有效位置，但不是目的地，继续调用tryToSolve方法
                    success = tryToSolve(position);
                    if (!success) {// 如果走不通 该位置为死胡同
                        undo(position);
                    }
                }
            }
        }
        return success;
    }

}

/** 自定义迭代类 遍历上下左右相邻点 */
class MazeIterator implements Iterator {

    private int row;
    private int column;
    private int count = 0;

    /* Constructor */
    public MazeIterator(Position position) {
        this.row = position.getRow();
        this.column = position.getColumn();
    }

    @Override
    public boolean hasNext() {
        return count < 4;
    }

    @Override
    public Object next() {
        Position next = null;
        // 遍历4个方向
        switch (count++) {
            case 0:
                next = new Position(row - 1, column);//左
                break;
            case 1:
                next = new Position(row, column - 1);//上
                break;
            case 2:
                next = new Position(row + 1, column);//右
                break;
            case 3:
                next = new Position(row, column + 1);//下
        }
        return next;
    }

    @Override
    public void remove() {
    }
}




