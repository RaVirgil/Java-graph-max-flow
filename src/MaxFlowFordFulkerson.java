import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;

public class MaxFlowFordFulkerson {
  public ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
  public ArrayList<Integer> parents=new ArrayList<>();
    public MaxFlowFordFulkerson(ArrayList<ArrayList<Integer>> graph){
        this.graph=graph;
    }

    boolean PathFromSourceToSinkExist(ArrayList<ArrayList<Integer>> graph, int source, int sink, ArrayList<Integer> parents) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for(int i=0; i<graph.size(); i++)
            visited.add(false);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.set(source,true);
        parents.set(source,-1);

        while (queue.size()!=0)
        {
            int current = queue.poll();
            for (int i=0; i<graph.size(); i++)
            {
                if (!visited.get(i) && graph.get(current).get(i) > 0)
                {
                    queue.add(i);
                    parents.set(i,current);
                    visited.set(i,true);
                }
            }
        }



        return (visited.get(sink));
    }
    int FordFulkerson(int source, int sink)
    {
        int i, j;



        ArrayList<Integer> parents=new ArrayList<>();
        for(i=0;i<graph.size();i++)
            parents.add(0);

        int maxFlow = 0;
        int pathFlow;
        while (PathFromSourceToSinkExist(graph, source, sink, parents))
        {

            pathFlow = Integer.MAX_VALUE;
            for (j=sink; j!=source; j=parents.get(j))
            {
                i = parents.get(j);
                pathFlow = Math.min(pathFlow, graph.get(i).get(j));

            }


            for (j=sink; j != source; j=parents.get(j))
            {
                i = parents.get(j);
                graph.get(i).set(j,graph.get(i).get(j)-pathFlow);
                graph.get(j).set(i,graph.get(j).get(i)+pathFlow);
            }


            maxFlow += pathFlow;
        }


        return maxFlow;
    }

}
