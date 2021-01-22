package companies.Decorpot;

import java.util.ArrayList;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        Question3 question2 = new Question3();
        List<Integer> scheduleStart = new ArrayList<>();
        List<Integer> scheduleEnd = new ArrayList<>();
        scheduleStart.add(1);
        scheduleStart.add(1);
        scheduleStart.add(2);
        scheduleStart.add(3);
        scheduleEnd.add(2);
        scheduleEnd.add(3);
        scheduleEnd.add(3);
        scheduleEnd.add(4);

        System.out.println(question2.maxPresentations(scheduleStart, scheduleEnd));

        scheduleStart = new ArrayList<>();
        scheduleStart.add(105);
        scheduleStart.add(155);
        scheduleStart.add(95);
        scheduleStart.add(57);
        scheduleStart.add(20);
        scheduleStart.add(344);
        scheduleStart.add(189);
        scheduleStart.add(496);
        scheduleStart.add(520);
        scheduleStart.add(704);

        scheduleEnd = new ArrayList<>();
        scheduleEnd.add(923);
        scheduleEnd.add(922);
        scheduleEnd.add(304);
        scheduleEnd.add(201);
        scheduleEnd.add(220);
        scheduleEnd.add(464);
        scheduleEnd.add(347);
        scheduleEnd.add(892);
        scheduleEnd.add(820);
        scheduleEnd.add(883);

        System.out.println(question2.maxPresentations(scheduleStart, scheduleEnd));
//        System.out.println(question2.solution());
        System.out.println();
    }

    public static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
        int maxAttend = 1;
        for(int p=0; p < scheduleStart.size(); p++) {
            int comb = 1;
            for (int i = p; i < scheduleStart.size(); i++) {
                Integer endTime = scheduleEnd.get(i);
                boolean isComb = false;
                for (int k = i + 1; k < scheduleStart.size(); k++) {
                    if (endTime <= scheduleStart.get(k)) {
                        i = k;
                        ++comb;
                        isComb = true;
                        break;
                    }
                }

                if (isComb) {
                    --i;
                }

                if (comb > maxAttend) {
                    maxAttend = comb;
                }
            }
        }
        return maxAttend;
    }


}

