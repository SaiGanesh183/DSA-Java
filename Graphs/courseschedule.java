class Solution {
    public boolean helper(int curr,  ArrayList<Integer>[] adj, boolean[] vis, boolean pathvis[]) {
        vis[curr]=true;
        pathvis[curr]=true;
        for(int i=0;i<adj[curr].size();i++) {
            int elem=adj[curr].get(i);
            if( pathvis[elem]==true) {
            return true;
            }
            if(!vis[elem]) {
                boolean res=helper(elem, adj, vis, pathvis);
                if(res) {
                    return true;
                }
            }
        }
        pathvis[curr]=false;
return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean vis[]= new boolean[numCourses];
        boolean pathvis[]= new boolean[numCourses];
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) {
            adj[i]= new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++) {
            int elem1=prerequisites[i][0];
            int elem2=prerequisites[i][1];
            adj[elem1].add(elem2);
        }
        for(int i=0;i<numCourses;i++) {
            if(!vis[i]) {
     boolean res = helper(i,adj,vis, pathvis);
     if(res) {
        return !res;
     }
            }
        }
     return true;
}
}