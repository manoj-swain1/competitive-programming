package practice.linked_list;

public class PrizeDistribution {

    public static void main(String[] args) {
        CustomSinglyLinkedList men = new CustomSinglyLinkedList("ross", 8);
        men.next = (new CustomSinglyLinkedList("chandler", 5));
        men.next.next = (new CustomSinglyLinkedList("joey", 4));
        CustomSinglyLinkedList women = new CustomSinglyLinkedList("monica", 7);
        women.next = (new CustomSinglyLinkedList("rachel", 6));
        women.next.next = (new CustomSinglyLinkedList("chan", 5));

        CustomSinglyLinkedList n = merge(men, women);
        while (n != null) {
            System.out.println(n.name + ":" + n.score);
            n = n.next;
        }
    }

    private static CustomSinglyLinkedList merge(CustomSinglyLinkedList men, CustomSinglyLinkedList women) {

        if (men == null)
            return women;
        if (women == null)
            return men;

        if (men.score > women.score) {
            men.next = merge(men.next, women);
            return men;
        } else if (men.score < women.score) {
            women.next = merge(men, women.next);
            return women;
        } else {
            if (men.name.compareTo(women.name) <= 0) {
                men.next = merge(men.next, women);
                return men;
            } else {
                women.next = merge(men, women.next);
                return women;
            }
        }
    }

}
