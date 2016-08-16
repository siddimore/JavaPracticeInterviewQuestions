import java.util.List;
import java.util.Map;

/**
 * Created by MoreFamily on 4/16/2016.
 */
public abstract class Graph {

    private int numV;
    private int numE;
    Map<Integer, String> vertexLabels;

    public Graph(int b){
        numV = b;
        numE = 0;
        vertexLabels = null;
    }

    public int getNumV(){
        return numV;
    }

    public int getNumE(){
        return numE;
    }

    public abstract void implementAddVertex(int v);

    public int addVertex(int vertex){
        implementAddVertex(vertex);
        numV++;
        return (numV -1);
    }

    public abstract void implementAddEdge(int a, int b);

    public void addEdge(int v, int w){
        numE++;
        if(v < numV && w < numV){
            implementAddEdge(v, w);
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public abstract List<Integer> getNeighbors(int v);
    //public abstract List<Integer> getInNeighbors(int v);

}
