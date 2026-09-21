class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int down=triangle.get(i+1).get(j);
                int diagonal = triangle.get(i + 1).get(j + 1);
                int currentSum = triangle.get(i).get(j) + Math.min(down, diagonal);
                triangle.get(i).set(j, currentSum);

            }
        }
        return triangle.get(0).get(0);
    }
}