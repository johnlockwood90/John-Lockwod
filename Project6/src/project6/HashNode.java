/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project6;

/**
 *
 * @author Student-HSLH133
 */
public class HashNode {
    int key;
    String value;
    HashNode next;
    HashNode prev;
    
    public HashNode(int key , String value, HashNode next, HashNode prev){
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
