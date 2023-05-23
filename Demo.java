public class Demo {

    public static void main(String[] args) {

        //0 is Wall
        int[][] maze = {
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {1,1,1,1,1,0,1,1,1,0,0,0,0,0,0},
                {1,0,0,0,1,0,0,1,0,0,0,0,0,0,0},
                {1,0,0,0,1,0,0,0,1,0,0,0,0,0,0},
                {1,0,1,1,0,0,0,0,0,1,0,0,0,0,0},
                {1,0,0,1,0,0,0,0,0,0,1,0,0,0,0},
                {1,0,0,0,1,1,1,0,0,0,1,0,0,0,0},
                {1,0,0,0,0,0,0,1,1,0,0,1,1,1,1},
                {1,1,1,1,0,1,1,1,1,1,0,0,0,0,0},
                {1,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                        };

        MazePathDFS mazePathDFS =new MazePathDFS(maze, 3, 0);

        MazePathBFS mazePathBFS=new MazePathBFS(maze, 3,0);

        System.out.println("*Path From (3,0) To (9,4)");
        for (Integer[] x: mazePathDFS.path(9,4)){
            System.out.print("  >>"+x[0]+","+x[1]);
        }
        System.out.println();

        System.out.println("*Shortest Path From (3,0) To (9,4)");

        for (Integer[] x: mazePathBFS.path(9,4)){
            System.out.print("  >>"+x[0]+","+x[1]);
        }
        System.out.println();

    }

}
