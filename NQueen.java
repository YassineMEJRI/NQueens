import java.util.ArrayList;
import java.util.List;

public class NQueen {
    static List<List<Integer> > solution = new ArrayList<>();
    static boolean[] cols,leftDiagonal,rightDiagonal;
    static List<List<Integer>> nQueen(int n) {
        cols = new boolean[n];
        leftDiagonal = new boolean[2*n];
        rightDiagonal = new boolean[2*n];
        solution = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++)temp.add(0);
        solveNQueen(solution,n,0,temp);

        return solution;
    }
    private static void solveNQueen(List<List<Integer>> result, int n, int row, List<Integer> comb){
        if(row==n){
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int col = 0;col<n;col++){
            if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
                continue;
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
            comb.set(col,row+1);
            solveNQueen(result,n,row+1,comb);
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;
        }
    }

}
