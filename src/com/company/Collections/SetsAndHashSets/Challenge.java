package company.Collections.SetsAndHashSets;

public class Challenge {
    /**
     * When overriding the equals() method in the CelestialBody class, we
     * were careful to make sure that it would not return true if a CelestialBody
     * was compared to a subclass of itself.
     *
     * We did that to demonstrate that method, but it was actually
     * unnecessary in the HeavenlyBody class.
     *
     * The mini challenge is just a question: why was it unnecessary?
     *
     * Hint: If you are stuck, check out Lecture 97
     *
     **/

    /**
     * Answer: It was unnecessary to override the equals method class
     * in order to check, if CelestialBody was compared to a subclass
     * of itself because the class is declared final (can't be subclassed)
     *
     * REAL Answer:
     *      *
     *      * The HeavenlyBody class is declared final, so cannot be subclassed.
     *      * The Java String class is also final, which is why it can safely
     *      * use the instanceof method without having to worry about
     *      * comparisons with a subclass.
     *
     */
}
