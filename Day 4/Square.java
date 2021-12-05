public class Square {
    private boolean dabbed;
    private int value;

    public Square(int value){
        this.value = value;
        dabbed = false;
    }

    public void dabbed(){
        dabbed = true;
    }

    public boolean isDabbed(){
        return dabbed;
    }

    public int getValue(){
        return value;
    }
}
