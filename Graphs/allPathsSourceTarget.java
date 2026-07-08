import java.util.*;
class Solution {
    public void DFS(int curr, int dest, int[][] graph, List<Integer> list, List<List<Integer>> mainlist) {
list.add(curr);
if(curr==dest) {
    mainlist.add(new ArrayList<>(list));
    list.remove(list.size()-1);
    return;
}
for(int i=0;i<graph[curr].length;i++) {
    int neig=graph[curr][i];
  
        DFS(neig, dest, graph, list, mainlist);
    
}
list.remove(list.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
List<Integer> list= new ArrayList<>();
List<List<Integer>> mainlist= new ArrayList<>();
DFS(0,graph.length-1,graph,list, mainlist);
return mainlist;
        
    }
}