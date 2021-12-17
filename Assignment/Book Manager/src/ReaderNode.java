/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 11/08/2021    1.0            Vanhv   
 */

/**
 *
 * @author vanhv
 */
public class ReaderNode {

    ReaderNode next;
    Reader info;

    public ReaderNode() {
    }

    public ReaderNode(Reader info, ReaderNode next) {
        this.next = next;
        this.info = info;
    }

    public ReaderNode(Reader b) {
        this(b, null);
    }
}
