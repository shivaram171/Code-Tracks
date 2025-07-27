class Solution:
    def maxArea(self, height: List[int]) -> int:
        left=0
        right = len(height) - 1
        maxwater = 0

        while left < right:
            width = right - left
            water = min(height[left], height[right]) * width
            maxwater = max(maxwater, water)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return maxwater

    
