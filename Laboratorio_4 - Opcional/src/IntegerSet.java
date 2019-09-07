public class IntegerSet {
    private boolean[] integerSet;

    //Default constructor
    public IntegerSet(){
        //Initialize empty set with all false (by default)
        this.integerSet = new boolean[100];
    }

    //METHODS
    //we "insert" an element by changing the value on index "elem" to True
    //For example: if set is [false,false,false] and we do insertElement(1):
    //             Then new set will be [false,true,false]
    public void insertElement(int elem){
        this.integerSet[elem] = true;
    }

    //we "delete" an element by changing the value on index "elem" to False
    public void deleteElement(int elem){
        this.integerSet[elem] = false;
    }

    //return set as a String (Overriding toString() because why not)
    @Override
    public String toString(){
        String setString = "";
        for (int i = 0; i < getSize(); i++) {
            //We only add it if value on that position is True
            if(contains(i))
                setString += "|" + i;
            else{
                if (i < 10){
                    setString += "| ";
                }
                else{
                    setString += "|  ";
                }
            }
        }
        return setString;
    }

    //Util
    //Size
    public int getSize(){
        return this.integerSet.length;
    }

    //get bool for a specific index
    public boolean contains(int elem){
        return this.integerSet[elem];
    }
}
