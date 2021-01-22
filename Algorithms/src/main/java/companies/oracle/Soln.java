package companies.oracle;

public class Soln {

    /*

Example: Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.


code:
	0) Validation
	1)Intia
		int val = 2;
		int indexOfNode2BeRemoved = (LL.Size - val) + 1; ==> (4)

	2) Loop and remove the element reference
		counter = 0;
		while(LL.next()){
			if(counter == indexOfNode2BeRemoved)
				removeNode();
				break;
			else{

			}

		}

	3) removeNode
	4) Print LL

     */

    public static void main(String[] args) {
        Soln soln = new Soln();
        int nodeFromLast = 2;
    }


    Node deleteNodeFromGivenIndex(Node headNodeParam, int nodeFromLast){
        Node headNode = headNodeParam;
        int sizeOfNodeList = 0;
        while(headNode.hasNext()){
            sizeOfNodeList++;
        }
        int indexOfNode2BeRemoved = (sizeOfNodeList - nodeFromLast) + 1;
        int counter =0;
        while (headNode.hasNext()){
            Node temp = headNode.next;


            if(counter == (indexOfNode2BeRemoved -1)){
                Node temp2 = temp.next;
                temp.setNextVal(temp2.next);
                temp.setVal(temp.val);

                temp2 = null;

                break; //return;
            }else{

            }
            counter++;
        }

        return headNode;
    }

    class Node{
        private int val;
        private Node next;
        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
        Node(int val){
            this.val = val;
            this.next = null;
        }

        boolean hasNext(){
            if(this.next != null){
                return true;
            }else {
                return false;
            }
        }

        Node nextVal(){
            return this.next;
        }

        int getVal(){
            return this.val;
        }

        void setNextVal(Node nextVal){
             this.next = nextVal;
        }

        void setVal(int val){
            this.val = val;
        }

    }
}
