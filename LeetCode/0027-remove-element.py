from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        k = 0  # Pointer for the number of elements not equal to val
        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]  # Move the non-val element to the front
                k += 1  # Increment the count of valid elements
        return k
