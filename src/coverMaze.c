void coverMaze()//遍历迷宫
{
    uchar next = 0;
    while(1){
        if(direction == 0)
		{
            if(y < 7 && maze[x][y + 1] == 0xff && IrF == 0)
				next = 0;
            else if(x < 7 && maze[x + 1][y] == 0xff && irR == 0)
			{
                direction = 1;
                next = 1;
            }
            else if(x > 0 && maze[x - 1][y] == 0xff && irL == 0)
			{
                direction = 3;
                next = 3;
            }
            else//回溯
			{
                goNext(2);//转向180 改变小车方向
				direction = 2;
				goBack();//回溯
            }
        }
        else if(direction == 1)
		{
            if(x < 7 && maze[x + 1][y] == 0xff && irF == 0)
			{
                next = 0;
            }
            else if(y > 0 && maze[x][y - 1] == 0xff && irR == 0)
			{
				direction = 2;
				next = 1;
			}
            else if(y < 7 && maze[x][y + 1] == 0xff && IrL == 0)
			{
                direction = 0;
                next = 3;
            }
            else {
                goNext(2);//转向180 改变小车方向
				direction = 3;
				goBack();//回溯
            }
        }
        else if(direction == 2){
            if(y > 0 && maze[x[y - 1] == 0xff && irF == 0)
			{
                next = 0;
            }
            else if(x > 0 && maze[x - 1][y] == 0xff && irR == 0)
			{
                direction = 3;
                next = 1;
            }
            else if(x < 7 && maze[x + 1][y] == 0xff && irL == 0)
			{
				direction = 1;
				next = 3;
			}
            else
			{
                goNext(2);//转向180 改变小车方向
				direction = 0;
				goBack();//回溯
            }
        }
        else if(direction == 3)
		{
            if(x > 0 && maze[x - 1][y] == 0xff && irF == 0)
			{
                next = 0;
            }
            else if(y < 7 && maze[x][y + 1] == 0xff && IrR == 0)
			{
                direction = 0;
                next = 1;
            }
            else if(x > 0 && maze[x - 1][y] == 0xff && irL == 0)
						{
                direction = 2;
                next = 3;
            }
            else 
			{
				goNext(2);//转向180 改变小车方向
				direction = 1;
				goBack();//回溯
			}
        }
        if(next == 0)//向前走 位置修正
				{
            if(direction == 0)	y--;
            if(direction == 1)	x++;
            if(direction == 2)	y++;
            if(direction == 3)	x--;
        }
		
        goNext(next);//执行下一步
		delay_ms(250);
		
		if(x == 0 && y == 0)//遍历完成条件
			break;
    }
}