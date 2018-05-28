class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet();
        helper(rooms, set, 0);
        return set.size() == rooms.size();
    }
    public void helper(List<List<Integer>> rooms, HashSet<Integer> set, int pos) {
        set.add(pos);
        for (int i : rooms.get(pos)) {
            if (!set.contains(i)) {
                helper(rooms, set, i);
            }
        }
    }
}