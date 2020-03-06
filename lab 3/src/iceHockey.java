import java.awt.*;
import java.util.Arrays;

public class iceHockey implements IPlayersFinder{
    private int count =0;
    private int team;
    private int x_min;
    private int x_max;
    private int y_min;
    private int y_max;
    private int center_x;
    private int center_y;
    private Point[] solxx;

    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold)
    {
        if (photo == null || photo.length == 0) {
            return null;
        }
        int i,j;
        int n=50;
        int z=0;
        Point[] sol = new Point[n];
        int rows = photo.length;
        int cols = photo[0].length();
        char [][] photoContents = new char[rows][cols];
        boolean[][] visit = new boolean[rows][cols];
        for (i=0;i<rows;i++){
            for (j=0;j<cols;j++){
                visit[i][j]=false;
            }
        }
        for ( i=0; i<rows; i++ ){
            for (j=0 ;j<cols ; j++){
                photoContents[i][j] = photo[i].charAt(j);
            }
        }
        for (i=0 ; i<rows ; i++){
            for (j=0 ; j<cols ; j++){
                if (photoContents[i][j]==team+'0'){
                    count=0;
                    x_max=j;
                    x_min=j;
                    y_max=i;
                    y_min=i;
                    recursion( visit,photoContents,i,j,team);
                    if (count*4>=threshold){
                        center_x=x_min+x_max+1;
                        center_y=y_max+y_min+1;
                        sol[z]=new Point(center_x,center_y);
                        z++;
                    }
                }
            }

        }
        Point[] solxx = new Point[z];
        for (i=0;i<z;i++){
            solxx[i]=sol[i];
        }

        int temp;
        int temp2;
        for (i=0;i<z;i++){
            for (j=i+1;j<z;j++){
                if (solxx[i].x>solxx[j].x){
                    temp=solxx[i].x;
                    temp2=solxx[i].y;
                    solxx[i].x=solxx[j].x;
                    solxx[i].y=solxx[j].y;
                    solxx[j].x=temp;
                    solxx[j].y=temp2;
                }
                else if ((solxx[i].x==solxx[j].x)&&solxx[i].y>solxx[j].y){
                    temp=solxx[i].x;
                    temp2=solxx[i].y;
                    solxx[i].x=solxx[j].x;
                    solxx[i].y=solxx[j].y;
                    solxx[j].x=temp;
                    solxx[j].y=temp2;
                }
            }
        }
        return solxx;
    }

    public void recursion (boolean[][]visit ,char[][]photoContents, int i , int j,int team){
        int rows = visit.length;
        int cols = visit[0].length;
        if (i<0 || j<0 || i>=rows || j>=cols){
            return ;
        }

        if (visit[i][j]==false){
        if (photoContents[i][j] == team + '0'){
                visit[i][j]=true;
                count++;
                if (y_min>i){
                    y_min=i;
                }
                if (y_max<i){
                    y_max=i;
                }
                if (x_min>j){
                    x_min=j;
                }
                if (x_max<j){
                    x_max=j;
                }
                recursion(visit,photoContents,i-1,j,team);
                recursion(visit,photoContents,i+1,j,team);
                recursion(visit,photoContents,i,j-1,team);
                recursion(visit,photoContents,i,j+1,team);
            }
        }
        this.count=count;
        if (this.x_min>x_min){
        this.x_min=x_min;
        }
        if (this.x_max<x_max) {
            this.x_max = x_max;
        }
        if (this.y_min>y_min) {
            this.y_min = y_min;
        }
        if (y_max<y_max) {
            this.y_max = y_max;
        }
    }


}
