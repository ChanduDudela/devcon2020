package ctci.hardproblems;

public class TheMasseuse {
    int maxMinutes (int[] appointmentMinutes) {
        int[] memo = new int[appointmentMinutes.length];

        return maxMinutes(appointmentMinutes, 0, memo);
    }

    int maxMinutes (int[] appointmentMinutes, int index, int[] memo) {
        if (index > appointmentMinutes.length) {
            return 0;
        }

        if (memo[index] > 0) {
            return memo[index];
        }

        int withCurrAppointment = appointmentMinutes[index] + maxMinutes(appointmentMinutes, index+2, memo);
        int withOutCurrAppointment = maxMinutes(appointmentMinutes, index+1, memo);

        memo[index] = Math.max(withCurrAppointment, withOutCurrAppointment);
        return memo[index];
    }
}
