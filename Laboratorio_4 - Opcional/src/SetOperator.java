public class SetOperator {

    //Essentially a logical "OR"
    public static IntegerSet union(IntegerSet S1, IntegerSet S2){
        IntegerSet newSet = new IntegerSet();
        for (int i = 0; i < S1.getSize(); i++) {
            if(S1.contains(i) || S2.contains(i)){
                //if true, set the element to true on the new set.
                //S1: [true,false,false] S2: [true,false,true] --> newSet: [true,false,true]
                newSet.insertElement(i);
            }
        }
        return newSet;
    }

    //Essentially a logical "AND"
    public static IntegerSet intersection(IntegerSet S1, IntegerSet S2){
        IntegerSet newSet = new IntegerSet();
        for (int i = 0; i < S1.getSize(); i++) {
            if(S1.contains(i) && S2.contains(i)){
                //if true, set the element to true on the new set.
                //S1: [true,false,false] S2: [true,false,true] --> newSet: [true,false,false]
                newSet.insertElement(i);
            }
        }
        return newSet;
    }

}
