package javaProblems.designPettern.ChainOfResponsbility;

public class Dollar20Dispenser implements DispenseChain{

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        int remainder=0;

        if (cur.getAmount() >= 20) {
            int num = cur.getAmount() / 20;
            remainder = cur.getAmount() % 20;
            cur.setAmount(remainder);
            System.out.println("Dispensing " + num + " 20$ note");
        }
        if(remainder!=0){
            this.chain.dispense(cur);
        }
    }

}

