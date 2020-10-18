package arrays;

import java.util.ArrayList;

public class StepsInfiniteGrid_44 {

    public static void main(String[] args) {
//        A = [0, 1, 1]
//        B = [0, 1, 2]
        ArrayList<Integer> listA= new ArrayList();
        listA.add(0);
        listA.add(1);
        listA.add(1);
        ArrayList<Integer> listB= new ArrayList();
        listB.add(0);
        listB.add(1);
        listB.add(2);
        System.out.println(coverPoints(listA, listB));
    }
    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int min_dist = 0;
        for(int i = 0; i < A.size() - 1; i ++) {
            min_dist += Math.max(Math.abs(A.get(i+1) - A.get(i)),  Math.abs(B.get(i+1) - B.get(i)));
        }
        return min_dist;
    }
}
