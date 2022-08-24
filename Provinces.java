//There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, 
//then city a is connected indirectly with city c.
//A province is a group of directly or indirectly connected cities and no other cities outside of the group.

//You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//Return the total number of provinces.
  
class Provinces {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        int res = 0;
        
        
        int V = isConnected.length;
        
        
        for(int k=0; k<V; k++)
        {
            adjLs.add(new ArrayList<Integer>());
        }
        
        
        for(int i=0; i<V; i++)
        {
            for(int j=0; j<V; j++)
            {
                if(isConnected[i][j]==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }     
        }
        
        int[] visited = new int[V];
    
        
        
        for(int i=0; i<V; i++)
        {
            if(visited[i]==0){
                res++;
                dfs(visited, adjLs,i);
            }
        }
        
        
        
        
        return res;
    }
    
    
    
    private static void dfs(int visited[], ArrayList<ArrayList<Integer>> adjLs, int node)
    {
        visited[node] = 1;
        
        
                
        for(Integer  neighbour: adjLs.get(node))
            {
                if(visited[neighbour]==0){
                    dfs(visited, adjLs, neighbour);
                }    
                
                
                
            }
        }
        
        
        
        
    
}
