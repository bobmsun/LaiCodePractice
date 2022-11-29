package algorithmbeginnerclass.primitivetypesandbasicoperations;

public class AreRoughlyEqual {

    public boolean areEqual(double x, double y) {
        boolean b = (x - y < 0.0001) && (y - x < 0.0001);
        return b;
    }
}
