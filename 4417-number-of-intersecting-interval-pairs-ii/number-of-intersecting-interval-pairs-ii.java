import java.util.*; 
class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
                //return integer.Compare(a[0],b[0]);
            }
            return a[1]-b[1];
            //return integer.Compare(a[1],b[1]);

        });
        long count =0;
        int n=intervals.length;
        for (int i=0;i<n;i++){
            int currEnd=intervals[i][1];
            int start=i+1;
            int end =n-1;
            int ans =i;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(intervals[mid][0]<=currEnd){
                    ans=mid;
                    start=mid+1;

                }else{
                    end=mid-1;
                }
            }
            count+=(long)(ans-i);
        }
        return count;
    }
}