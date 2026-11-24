class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int longest = 0;

        for (int left = 0; left < n; left++) {
            long product = 1;
            long lcm = 1;
            int gcd = 0;

            for (int right = left; right < n; right++) {
                int value = nums[right];

                product *= value;
                gcd = gcd(gcd, value);
                lcm = lcm(lcm, value);

                if (product == lcm * gcd) {
                    longest = Math.max(longest, right - left + 1);
                }
            }
        }

        return longest;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd((int) a, (int) b)) * b;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna