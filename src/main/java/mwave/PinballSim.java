package mwave;

/**
 * Created by q on 1/27/14.
 */
public class PinballSim {

    private Pinball p;
    private String string;


    public String getString() {
        return string;
    }
   public PinballSim() {

        p = new Pinball();

        p.initCounts();
        p.simulate(10);
        string = p.statsAndIteration(10);

        p.initCounts();
        p.simulate(100);
        string += p.statsAndIteration(100);

        p.initCounts();
        p.simulate(1000);
        string += p.statsAndIteration(1000);

        p.initCounts();
        p.simulate(10000);
        string += p.statsAndIteration(10000);

    }
}
