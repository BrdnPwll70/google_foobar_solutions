public class Solution {
    public static int solution(int[] x, int[] y) {
        // Your code here
        java.util.List<Integer> list1 = java.util.Arrays.stream(x).boxed().collect(java.util.stream.Collectors.toList());
        java.util.List<Integer> list2 = java.util.Arrays.stream(y).boxed().collect(java.util.stream.Collectors.toList());
        java.util.Set<Integer> union = new java.util.HashSet<Integer>(list1);
        union.addAll(list2);
        java.util.Set<Integer> intersection = new java.util.HashSet<Integer>(list1);
        intersection.retainAll(list2);
        union.removeAll(intersection);
        return union.iterator().next();
    }
}
