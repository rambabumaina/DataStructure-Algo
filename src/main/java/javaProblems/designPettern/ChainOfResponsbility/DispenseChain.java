package javaProblems.designPettern.ChainOfResponsbility;

public interface DispenseChain {

        void setNextChain(DispenseChain nextChain);

        void dispense(Currency cur);
    }
