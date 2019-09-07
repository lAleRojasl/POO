public class Main {
    public static void main(String[] args) {
        IntegerSet S1 = new IntegerSet();
        IntegerSet S2 = new IntegerSet();
        for (int i = 0; i < 100; i++) {
            //True on every 3 positions
            if(i % 3 == 0){
                S1.insertElement(i);
            }
            //True on every 4 positions
            if(i % 4 == 0){
                S2.insertElement(i);
            }
        }

        System.out.println("S1 (positions where True) -> " + S1.toString());
        System.out.println("S2 (positions where True) -> " + S2.toString());

        //Lets do a Union of S1 and S2
        IntegerSet S3 = SetOperator.intersection(S1, S2);
        System.out.println("\n\nDoing a INTERSECTION of S1 and S2 and save it to S3...");
        System.out.println("\tS1 -> " + S1.toString());
        System.out.println("\tS2 -> " + S2.toString());
        System.out.println("\tS3 -> " + S3.toString());

        //Lets strip some values from S1
        System.out.println("\n\nLets strip all EVEN numbers from S1...");
        System.out.println("\tS1 -> " + S1.toString());
        for (int i = 0; i < 100; i++) {
            //False on every 2 positions
            if(i % 2 == 0){
                S1.deleteElement(i);
            }
        }
        System.out.println("\tS1 -> " + S1.toString());

        //Lets do an Intersection of modified S1 and S3
        IntegerSet S4 = SetOperator.union(S1, S3);
        System.out.println("\n\nDoing an UNION of modified S1 and S3 and save it to S4...");
        System.out.println("\tS1 -> " + S1.toString());
        System.out.println("\tS3 -> " + S3.toString());
        System.out.println("\tS4 -> " + S4.toString());

    }
}
