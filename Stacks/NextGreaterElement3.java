class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int in=-1;
        for(int i=arr.length-2;i>=0;i--) {
            if(arr[i]<arr[i+1]) {
               in=i;
               break;
            }
        }
        if(in!=-1) {
        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i]>arr[in]) {
                char temp=arr[i];
                arr[i]=arr[in];
                arr[in]=temp;
                break;
            }
        }
        Arrays.sort(arr,in+1,arr.length);
            long num=0;
            for(int i=0;i<arr.length;i++) {
                num=num*10+(arr[i]-'0');
            }
             if(num>Integer.MAX_VALUE) {
            return -1;
        }
            return (int)num;
        
        }
        else {
            return -1;
        }

    }
}