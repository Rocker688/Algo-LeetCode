public class GasStations {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int j = -1;
        for (int i = 0, sum = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                j = i;
                sum = 0;
            }
        }

        return total >= 0? j + 1: -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        GasStations gs = new GasStations();
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}
