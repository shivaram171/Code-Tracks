class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles; // initially drink all full bottles
        int emptyBottles = numBottles; // all become empty after drinking

        while (emptyBottles >= numExchange) {
            int newFull = emptyBottles / numExchange; // bottles we can get by exchange
            totalDrunk += newFull; // drink them
            emptyBottles = emptyBottles % numExchange + newFull; // remaining empties + newly drunk
        }

        return totalDrunk;
    }
}
