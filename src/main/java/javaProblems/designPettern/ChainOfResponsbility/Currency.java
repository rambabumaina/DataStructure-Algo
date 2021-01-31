package javaProblems.designPettern.ChainOfResponsbility;

public class Currency {

    private int amount;

    public Currency(int amt) {
        this.amount = amt;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

