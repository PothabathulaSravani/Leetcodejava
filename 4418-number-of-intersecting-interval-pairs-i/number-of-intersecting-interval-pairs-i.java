class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int count=0;
        int n=intervals.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int maxStart =Math.max(intervals[i][0],intervals[j][0]);
                int minEnd =Math.min(intervals[i][1],intervals[j][1]);
                if (maxStart<=minEnd){
                    count++;
                }
            }
        }
          return count;
    }
}