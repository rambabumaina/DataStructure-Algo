package amazon.graph.alienDictinary;

//https://practice.geeksforgeeks.org/problems/alien-dictionary/1
public class AlienDictionary {


    public static void main(String[] args) {
//        String[] dict = {"baa","abcd","abca","cab","cad"};
        String [] dict = {"caa","aaa","aab"};
        AlienDictionary t = new AlienDictionary();

        String order = t.findOrder(dict, dict.length, 3);
        System.out.println(order);
    }


    public String findOrder(String [] dict, int N, int K)
    {
        Graph g= buildGraph(dict,N,K);

        for (Vertex v : g.getAllVertex().values()){
            String order =findOrderUtils(v, new boolean[K], ""+v.getId(), K);
            if (order != null && order.length() == K){
                return order;
            }
        }

        return null;
    }

    private String findOrderUtils(Vertex v, boolean [] visited, String order, int K){
        if(order.length() == K){
            return order;
        }
        if(!visited[v.getId()-97]){
            visited[v.getId()-97] = true;
            for (Vertex adjVtex : v.getAdjVertices()){
                String orderUtil = findOrderUtils(adjVtex,visited, order+adjVtex.getId(), K);

                if(orderUtil !=null && orderUtil.length() == K){
                    return orderUtil;
                }
                visited[v.getId()-97] = false;
            }

        }
        return order;
    }


    public Graph buildGraph(String [] dict, int N, int K){
        Graph graph = new Graph();
        for (int i = 0 ; i< dict.length-1 ; i++ ){

            int j = 0;
            while (j < dict[i].length() && j< dict[i+1].length()){
                if(dict[i].charAt(j) != dict[i+1].charAt(j)){
                    graph.addEdge(dict[i].charAt(j), dict[i+1].charAt(j));
                    break;
                }
                j++;
            }
        }
        return graph;
    }
}
