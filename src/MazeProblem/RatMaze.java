package MazeProblem;

import java.util.Stack;

public class RatMaze {
    private static int N = 5;

    public static void solveMaze(int[][] maze){
        if(!solveMazeUtil(maze)){
            System.out.println("No Possible Solution exists");
        }
    }

    private static boolean isSafe(int[][] maze, int x, int y){
        if(x > 0 && x < N && y > 0 && y < N && maze[x][y] == 0)
            return true;
        else
            return false;
    }

    public static boolean solveMazeUtil(int[][] maze){
        Stack<Coordinates> solution = new Stack<>();
        Coordinates[] moves = Coordinates.getMoves();
        int[][] mark = new int[N][N];
        Coordinates temp = new Coordinates(0,0);
        solution.push(temp);

        while(!solution.empty()){
            temp = solution.pop();
            int d = 0;
            while(d<8){
                Coordinates nextMove = moves[d];
                int g = temp.x + nextMove.x ; int h = temp.y + nextMove.y;

                //if the next box is final box.
                if(g == N-1 && h == N-1){
                    //Rat is in the final box
                    solution.push(temp);
                    Coordinates newTemp = new Coordinates(g,h);
                    solution.push(newTemp);
                    printSolution(solution);
                    return true;
                } else if(isSafe(maze,g,h) && mark[g][h]==0){
                    mark[g][h] = 1;
                    solution.push(temp);
                    Coordinates newTemp = new Coordinates(g,h);
                    solution.push(newTemp);
                    d = 8;
                } else{
                    d++;
                }
            }
        }

        return false;
    }

    private static void printSolution(Stack<Coordinates> solution){
        Stack<Coordinates> sol = new Stack<>();
        while(!solution.isEmpty()) {
            sol.push(solution.pop());
        }

        while(!sol.empty()){
            System.out.println(sol.pop());
        }
    }

    public static void main(String[] args){
        RatMaze rat = new RatMaze();

        int maze[][] = { {0,1,0,0,0},
                         {1,0,0,0,1},
                         {0,1,1,0,0},
                         {1,1,0,1,1},
                         {1,1,0,0,0} };

        rat.solveMaze(maze);
    }
}
