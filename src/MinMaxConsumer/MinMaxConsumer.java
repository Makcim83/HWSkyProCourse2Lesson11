package MinMaxConsumer;

public class MinMaxConsumer {
    private int minConsumer;
    private int maxConsumer;

    public int getMinConsumer() {
        return minConsumer;
    }

    public void setMinConsumer(int minConsumer) {
        this.minConsumer = minConsumer;
    }

    public int getMaxConsumer() {
        return maxConsumer;
    }

    public void setMaxConsumer(int maxConsumer) {
        this.maxConsumer = maxConsumer;
    }

    @Override
    public String toString() {
        return "MinMaxConsumer{" +
                "minConsumer=" + minConsumer +
                ", maxConsumer=" + maxConsumer +
                '}';
    }
}
