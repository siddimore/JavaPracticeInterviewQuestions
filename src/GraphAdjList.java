import java.util.*;

/**
 * Created by MoreFamily on 4/16/2016.
 */
public class GraphAdjList extends Graph{

    private Map<Integer, List<Integer>> adjListMap;

    public GraphAdjList(int numEdges){
        super(numEdges);
        adjListMap = new HashMap<>();
    }

    public void implementAddVertex(int v){
        if(!adjListMap.containsKey(v)) {
            List<Integer> neighbors = new ArrayList<>();
            //int v = getNumV();
            adjListMap.put(v, neighbors);
        }
    }


    public void implementAddEdge(int v, int w){
        adjListMap.get(v).add(w);
    }

    public List<Integer> getNeighbors(int v){
        return new ArrayList<Integer>(adjListMap.get(v));
    }

    public static void main(String...arg)
    {
        int source , destination;
        int number_of_edges,number_of_vertices;
        int count = 1;
        Scanner scan = new Scanner(System.in);
        try
        {
             /* Read the number of vertices and edges in graph */
            System.out.println("Enter the number of vertices and edges in graph");
            number_of_vertices = scan.nextInt();
            number_of_edges = scan.nextInt();
            GraphAdjList adjacencyList = new GraphAdjList(number_of_vertices);

             /* Reads the edges present in the graph */
            System.out.println("Enter the edges in graph Format : <source index> <destination index>");
            while (count <= number_of_edges)
            {
                source = scan.nextInt();
                adjacencyList.addVertex(source);
                destination = scan.nextInt();
                adjacencyList.addEdge(source, destination);
                count++;
            }

             /* Prints the adjacency List representing the graph.*/
            System.out.println ("the given Adjacency List for the graph \n");
            for (int i = 1 ; i <= number_of_vertices ; i++)
            {
                System.out.print(i+"->");
                List<Integer> edgeList = adjacencyList.getNeighbors(i);
                for (int j = 1 ; ; j++ )
                {
                    if (j != edgeList.size())
                    {
                        System.out.print(edgeList.get(j - 1 )+"->");
                    }else
                    {
                        System.out.print(edgeList.get(j - 1 ));
                        break;
                    }
                }
                System.out.println();
            }
        }
        catch(InputMismatchException inputMismatch)
        {
            System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
        }
        scan.close();
    }
}

