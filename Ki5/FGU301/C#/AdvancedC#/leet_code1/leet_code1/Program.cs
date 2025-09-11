namespace leet_code1
{
    internal class Program
    {
        static void Main()
        {
            int[] nums1 = { 1, 2, 4 };
            Console.WriteLine(MaxCircularAbsoluteDifference(nums1)); // Output: 3

            int[] nums2 = { -5, -10, -5 };
            Console.WriteLine(MaxCircularAbsoluteDifference(nums2)); // Output: 5
        }

        static int MaxCircularAbsoluteDifference(int[] nums)
        {
            int maxDistance = 0;
            int lengNums = nums.Length;

            for (int i = 0; i < lengNums; i++)
            {
                int nextIndex = (i+1)% lengNums;

                int diff = Math.Abs(nums[i] - nums[nextIndex]);
                if (diff > maxDistance)
                {
                    maxDistance = diff;
                }
            }
            return maxDistance;
        }
    }
    
}
