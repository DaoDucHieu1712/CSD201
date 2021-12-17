/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 10/08/2021    1.0            Vanhv   
 */


/**
 *
 * @author vanhv
 */
public class Lending {

    private String bCode;
    private String rCode;
    private int state;

    public Lending() {
    }

    public Lending(String bCode, String rCode, int state) {
        this.bCode = bCode;
        this.rCode = rCode;
        this.state = state;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Lending{" + "bCode=" + bCode + ", rCode=" + rCode + ", state=" + state + '}';
    }
    
}
