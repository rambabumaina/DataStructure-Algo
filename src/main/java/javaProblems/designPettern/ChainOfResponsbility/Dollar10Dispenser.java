package javaProblems.designPettern.ChainOfResponsbility;

public class Dollar10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        int remainder=0;

        if (cur.getAmount() >= 10) {
            int num = cur.getAmount() / 10;
            remainder = cur.getAmount() % 10;
            cur.setAmount(remainder);
            System.out.println("Dispensing " + num + " 10$ note");
        }
        if(remainder!=0){
            this.chain.dispense(cur);
        }
    }
}

