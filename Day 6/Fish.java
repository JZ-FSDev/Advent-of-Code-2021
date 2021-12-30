public class Fish {
    private long count;

    public Fish(){
        count = 0;
    }

    public void increasePopulation(long p){
        count += p;
    }

    public long getPopulation(){
        return count;
    }

    public void setPopulation(long p){
        count = p;
    }
}
