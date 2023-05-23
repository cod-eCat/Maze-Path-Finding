package com.lpa.graph;

import java.util.Stack;

    /*
    Author-@LwinPhyoAung
    Maze Path Find Using Depth First Search*
     */

public class MazePathBFS {

    private int[][] maze;
    private boolean[][] marked;
    private int[][][] edge;
    private final int ROW;
    private final int COL;
    private final int startR;
    private final int startC;

    public MazePathBFS(int[][] maze, int startR, int startC){
        this.ROW=maze.length;
        this.COL=maze[0].length;
        this.startR=startR;
        this.startC=startC;
        this.maze=maze;
        marked=new boolean[ROW][COL];
        this.edge=new int[ROW][COL][2];
        bfs(maze, startR, startC);
    }

    private void bfs(int[][] maze, int r, int c){
        if (!isIndexValid(r, c)) return;
        marked[r][c]=true;
        Queue<Integer[]> queue=new Queue<>();
        queue.enqueue(new Integer[]{r, c});
        while (!queue.isEmpty()){
            Integer[] rc=queue.dequeue();
            int rr=rc[0];
            int cc=rc[1];
            int[] rs=new int[]{rr,rr,rr-1,rr+1, rr-1,rr-1,rr+1,rr+1};
            int[] cs=new int[]{cc-1,cc+1,cc,cc, cc-1,cc+1,cc-1,cc+1};
            for (int i=0; i<8; i++){
                if (isIndexValid(rs[i], cs[i]) && !marked[rs[i]][cs[i]]){
                    marked[rs[i]][cs[i]]=true;
                    edge[rs[i]][cs[i]][0]=rr;
                    edge[rs[i]][cs[i]][1]=cc;
                    queue.enqueue(new Integer[]{rs[i], cs[i]});
                }
            }
        }
    }

    public boolean hasPath(int r, int c){
        return marked[r][c];
    }

    public Iterable<Integer[]> path(int r, int c){
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
