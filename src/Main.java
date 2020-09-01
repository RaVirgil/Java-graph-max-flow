import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        Scanner f=new Scanner(new File("graph.txt"));
        int nrNod=f.nextInt();
        for(int i=0;i<nrNod;i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < nrNod; j++)
                graph.get(i).add(f.nextInt());

        }

        MaxFlowFordFulkerson algorithm=new MaxFlowFordFulkerson(graph);
        System.out.println("Max Flow is: "+algorithm.FordFulkerson(0,5));


    }





}
