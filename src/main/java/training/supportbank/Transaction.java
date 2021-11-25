package training.supportbank;

public class Transaction {
    String date;
    String from;
    String to;
    String narrative;
    float amount;

    Transaction(String date, String from, String to, String narrative, float amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", narrative='" + narrative + '\'' +
                ", amount=" + amount +
                '}';
    }
}


