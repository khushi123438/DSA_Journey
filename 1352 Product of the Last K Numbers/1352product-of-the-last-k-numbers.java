class ProductOfNumbers {

    private ArrayList<Integer> nums;

    public ProductOfNumbers() {
        nums = new ArrayList<>();
    }

    public void add(int num) {
        nums.add(num);
    }

    public int getProduct(int k) {
        int product = 1;

        // multiply last k numbers
        for (int i = nums.size() - 1; i >= nums.size() - k; i--) {
            product *= nums.get(i);
        }

        return product;
    }
}