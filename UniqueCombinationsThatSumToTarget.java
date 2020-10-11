import java.util.List;
import java.util.ArrayList;

public class UniqueCombinationsThatSumToTarget {
    public List<List<Integer>> find(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();
        return find(candidates, target, candidates.length - 1);
    }

    List<List<Integer>> find(int[] candidates, int target, int currentIndex) {
        if (currentIndex == 0) {
            List<Integer> list = new ArrayList<>();
            if (target != 0 && target % candidates[currentIndex] == 0) {
                int times = target / candidates[currentIndex];
                for (int i = 0; i < times; i++)
                    list.add(candidates[currentIndex]);
            }
            List<List<Integer>> listOfLists =  new ArrayList<>();
            listOfLists.add(list);
            return listOfLists;
        }
        List<List<Integer>> listOfLists = new ArrayList<>();
        int quotient = target / candidates[currentIndex];
        int remainder = target % candidates[currentIndex];
        for (int i = 0; i <= quotient; i++) {
            List<List<Integer>> listOfSublists = find(candidates, target - i * candidates[currentIndex], currentIndex - 1);
            if (listOfSublists != null && !listOfSublists.isEmpty()) {
                for (List<Integer> list : listOfSublists) {
                    List<Integer> newList = new ArrayList<>(list);
                    for (int j = 0; j < i; j++)
                        newList.add(candidates[currentIndex]);
                    listOfLists.add(newList);
                }
            }
        }
        return listOfLists;
    }

    public static void main(String[] args) {
        UniqueCombinationsThatSumToTarget uctstt = new UniqueCombinationsThatSumToTarget();
        int[] candidates = new int [] {2, 3, 6, 7};
        int target = 7;
        //int[] candidates = new int [] {2, 3, 5};
        //int target = 8;
        System.out.println(uctstt.find(candidates, target));        
    }
}
