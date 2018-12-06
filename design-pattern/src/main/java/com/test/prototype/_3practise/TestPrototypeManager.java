package com.test.prototype._3practise;

public class TestPrototypeManager {

    public static void main(String[] args) {
        PrototypeManager prototypeManager = PrototypeManager.getInstance();
        OfficialDocument doc1, doc2;
        doc1 = prototypeManager.getOfficialDocument("far");
        doc1.display();

        doc2 = prototypeManager.getOfficialDocument("far");
        doc2.display();

        System.out.println(doc1 == doc2);
    }
}
