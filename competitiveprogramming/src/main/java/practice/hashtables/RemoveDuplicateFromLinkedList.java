package practice.hashtables;

import practice.linked_list.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromLinkedList {

    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        if (list.getSize() == 0) {
            return;
        }
        Set<Object> set = new HashSet<>();

        SinglyLinkedList.Node curr = list.getHeadNode();
        set.add(curr.data);
        curr = curr.nextNode;
        SinglyLinkedList.Node prev=curr;
        while (curr != null ) {
            if(set.contains(curr.data)){
                prev.nextNode=curr.nextNode;
            }else{
                prev=curr;
            }
            set.add(curr.data);
            curr=curr.nextNode;
        }
    }
}
