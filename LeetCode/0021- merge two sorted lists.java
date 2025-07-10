/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if(list1.val <list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;


        }
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
}















// explanation

// 📞 Call 1: mergeTwoLists(1→2→4, 1→3→4)
// Compare: 1 (list1) and 1 (list2)

// list1.val < list2.val is false

// So, pick from list2

// Make list2.next = mergeTwoLists(list1, list2.next)

// 👉 Now recurse into:
// mergeTwoLists(1→2→4, 3→4)

// 📞 Call 2: mergeTwoLists(1→2→4, 3→4)
// Compare: 1 (list1) < 3 (list2) → true

// Pick from list1

// Make list1.next = mergeTwoLists(list1.next, list2)

// 👉 Recurse into:
// mergeTwoLists(2→4, 3→4)

// 📞 Call 3: mergeTwoLists(2→4, 3→4)
// Compare: 2 < 3 → true

// Pick from list1

// Make list1.next = mergeTwoLists(4, 3→4)

// 👉 Recurse into:
// mergeTwoLists(4, 3→4)

// 📞 Call 4: mergeTwoLists(4, 3→4)
// Compare: 4 < 3 → false

// Pick from list2

// Make list2.next = mergeTwoLists(4, 4)

// 👉 Recurse into:
// mergeTwoLists(4, 4)

// 📞 Call 5: mergeTwoLists(4, 4)
// Compare: 4 == 4 → false (equal goes to else)

// Pick from list2

// Make list2.next = mergeTwoLists(4, null)

// 👉 Recurse into:
// mergeTwoLists(4, null)

// 📞 Call 6: mergeTwoLists(4, null)
// list2 == null → return list1 (4)

// 🧱 Now let's build the result backward (from return values):
// Call 6 returns: [4]

// Call 5 returns: list2(4) → [4]

// Call 4 returns: list2(3) → [4 → 4]

// Call 3 returns: list1(2) → [3 → 4 → 4]

// Call 2 returns: list1(1) → [2 → 3 → 4 → 4]

// Call 1 returns: list2(1) → [1 → 2 → 3 → 4 → 4]

// ✅ Final Merged Linked List:
// css
// Copy
// Edit
// [1] → [1] → [2] → [3] → [4] → [4]
