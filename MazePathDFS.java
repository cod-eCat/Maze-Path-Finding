package com.lpa.graph;

import java.util.Stack;

    /*
    Author-@LwinPhyoAung
    Maze Path Find Using Depth First Search*
     */

public class MazePathDFS {

    private int[][] maze;
    private boolean[][] marked;
    private int[][][] edge;
    private final int ROW;
    private final int COL;
    private final int startR;
    private final int startC;

    public MazePathDFS(int[][] maze, int startR, int startC){
        this.maze=maze;
        ROW=maze.length;
        COL=maze[0].length;
        this.marked=new boolean[ROW][COL];
        this.edge=new int[ROW][COL][2];
        this.startR=startR;
        this.startC=startC;
        dfs(maze, startR, startC);
    }

    private void dfs(int[][] m, int r, int c){
        if (!isIndexValid(r, c)) return;
        marked[r][c]=true;
        int[] rs=new int[]{r,r,r-1,r+1, r-1,r-1,r+1,r+1};
        int[] cs=new int[]{c-1,c+1,c,c, c-1,c+1,c-1,c+1};
        for (int i=0; i<8; i++){
            if (isIndexValid(rs[i], cs[i])&&!marked[rs[i]][cs[i]]){
                edge[rs[i]][cs[i]][0]=r;
                edge[rs[i]][cs[i]][1]=c;
                dfs(m, rs[i], cs[i]);
            }
        }
    }

    public boolean hasPath(int r, int c){
        return marked[r][c];
    }

    public Iterable<Integer[]> path(int r, int c){
        if (!hasPath(r, c)) return null;
        Stack<Integer[]> path=new Stack<>();
        path(path, r, c);
        path.push(new Integer[]{startR, startC});
        return path;
    }

    private void path(Stack<Integer[]> path, int r, int c){
        if (r!=startR || c!=startC){
            path.push(new Integer[]{r, c});
            path(path, edge[r][c][0], edge[r][c][1]);
        }
    }

    public int[][][] getEdge(){
        //for testing
        return edge;
    }

    private boolean isIndexValid(int r, int c){
        if (r<0||c<0||r>=ROW||c>=COL||maze[r][c]!=1){
            return false;
        }
        return true;
    }

}
