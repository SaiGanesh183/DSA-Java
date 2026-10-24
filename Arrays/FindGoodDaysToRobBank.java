import java.util.ArrayList;
import java.util.List;

class FindGoodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (security[i] > security[i - 1])) {
                count = 0;
            }
            arr1[i] = count;
            count++;
        }
        
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && (security[i] > security[i + 1])) {
                count = 0;
            }
            arr2[i] = count;
            count++;
        }
        
        for (int i = time; i < n - time; i++) {
            if (arr1[i] >= time && arr2[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }
}