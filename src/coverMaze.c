void coverMaze()//�����Թ�
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
            else//����
			{
                goNext(2);//ת��180 �ı�С������
				direction = 2;
				goBack();//����
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
                goNext(2);//ת��180 �ı�С������
				direction = 3;
				goBack();//����
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
                goNext(2);//ת��180 �ı�С������
				direction = 0;
				goBack();//����
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
				goNext(2);//ת��180 �ı�С������
				direction = 1;
				goBack();//����
			}
        }
        if(next == 0)//��ǰ�� λ������
				{
            if(direction == 0)	y--;
            if(direction == 1)	x++;
            if(direction == 2)	y++;
            if(direction == 3)	x--;
        }
		
        goNext(next);//ִ����һ��
		delay_ms(250);
		
		if(x == 0 && y == 0)//�����������
			break;
    }
}