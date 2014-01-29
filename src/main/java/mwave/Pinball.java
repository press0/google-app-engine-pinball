package mwave;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by q on 1/18/14.
 */
public class Pinball {
    private final Random random = new Random();

    private final DecimalFormat decimalFormat = new DecimalFormat( "##.00%" );
    private double random1, random2;
    private double slotA, slotB, slotC;
    private int countSlotA, countSlotB, countSlotC;

    private double getNextRandom() {
        return random.nextDouble();
    }

    public String statsAndIteration(int i) {
        return new StringBuilder()
            .append("\n")
            .append("iterations:" + i + "\n")
            .append(stats(i))
            .toString();
    }

    public String stats(int i) {
        return new StringBuilder()
            .append("slots% :" + getSlotPercent() + "\n")
            .append("counts%:" + getCountPercent(i) + "\n")
            .append("counts :" + getCount() + "\n")
            .toString();
    }

    public Pinball() {
        initRandom();
        initSlot();
    }

    private void initRandom() {
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(getNextRandom());
        doubleList.add(getNextRandom());
        Collections.sort(doubleList);
        random1 = doubleList.get(0);
        random2 = doubleList.get(1);
    }

    private void initSlot() {
        slotA = random1;
        slotB = random2 - random1;
        slotC = 1 - random2;
    }

    private void shoot() {
        double d = getNextRandom();
        if (d < random1)
            countSlotA++;
        else if (d < random2)
            countSlotB++;
        else
            countSlotC++;
    }

    public void initCounts() {
        countSlotA = countSlotB = countSlotC = 0;
    }

    public void simulate(int i) {
        for (int j=i; j>0; j--)
            shoot();
    }

    public List<Double> getRandom() {
        List<Double> arrayList = new ArrayList<>();
        arrayList.add(random1);
        arrayList.add(random2);
        return arrayList;
    }

    public List<Double> getSlot() {
        List<Double> arrayList = new ArrayList<>();
        arrayList.add(slotA);
        arrayList.add(slotB);
        arrayList.add(slotC);
        return arrayList;
    }

    public List<String> getSlotPercent() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add(decimalFormat.format(slotA));
        arrayList.add(decimalFormat.format(slotB));
        arrayList.add(decimalFormat.format(slotC));
        return arrayList;
    }

    public List<Integer> getCount() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(countSlotA);
        arrayList.add(countSlotB);
        arrayList.add(countSlotC);
        return arrayList;
    }
    public List<String> getCountPercent(int i) {
        List<String> arrayList = new ArrayList();
        arrayList.add(decimalFormat.format(countSlotA/(double)i));
        arrayList.add(decimalFormat.format(countSlotB/(double)i));
        arrayList.add(decimalFormat.format(countSlotC/(double)i));
        return arrayList;
    }

}
