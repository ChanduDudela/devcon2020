package ctci.mediumproblems;

import java.util.Arrays;

public class P10_LivingPeople {
    static class Person {
        int birthYear;
        int deathYear;

        public Person(int birthYear, int deathYear) {
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }
    }

    int maxAliveYear(Person[] persons, int minYear, int maxYear) {
        int[] birthYears = getSortedYears(persons, true);
        int[] deathYears = getSortedYears(persons, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int maxAliveYearCount = 0;
        int maxAliveYear = minYear;
        int tempAliveCount = 0;

        while (birthIndex < birthYears.length) {
            if (birthYears[birthIndex] <= deathYears[deathIndex]) {
                tempAliveCount ++;

                if(tempAliveCount > maxAliveYearCount) {
                    maxAliveYearCount = tempAliveCount;
                    maxAliveYear = birthYears[birthIndex];
                }
                birthIndex++;
            } else {
                tempAliveCount --;
                deathIndex ++;
            }
        }

        return maxAliveYear;
    }

    int[] getSortedYears(Person[] persons, boolean isBirthYear) {
        int[] years = isBirthYear ?
            Arrays.stream(persons).mapToInt(p -> p.birthYear).toArray()
            : Arrays.stream(persons).mapToInt(p -> p.deathYear).toArray();
        Arrays.sort(years);
        return years;
    }
}
