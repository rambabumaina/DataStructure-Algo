package javaProblems.designPettern.ChainOfResponsbility;

public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain chain; //c2

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        int remainder=0;

        if (cur.getAmount() >= 50) {
            int num = cur.getAmount() / 50;
            remainder = cur.getAmount() % 50;
            cur.setAmount(remainder);
            System.out.println("Dispensing " + num + " 50$ note");
        }
        if(remainder!=0){
            this.chain.dispense(cur);
        }
    }
}
