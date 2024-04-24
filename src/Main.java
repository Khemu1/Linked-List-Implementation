class Numbers {

  int num; // Data stored in the node
  Numbers next; // Reference to the next node

  Numbers(int num) {
    this.num = num;
    this.next = null; // Initialize the next pointer to null
  }
}

class LinkedList {

  Numbers head; // this will point at the first node in the list

  LinkedList() {
    this.head = null; // initializing the list as empty
  }

  /**
   *
   * @param num
   * @param position is the position that the node will be insterted at
   * @return
   */
  boolean insert(int num, int position) {
    Numbers newNode = new Numbers(num);
    // if the user want to insert before the head
    if (position == 0) {
      newNode.next = head; // making the new node point at the head that will be the second node
      head = newNode; // making the new node the head
      return true;
    } else {
      Numbers current = head; // this node that will be using to trevrse the list to insert the  new node
      // so we will moving from the head
      for (int i = 0; i < position - 1; i++) {
        current = current.next; // making the node points at the next node
        /*
         * lets say we want to insert at pos 3 the temp node is made at the head node
         * it will equal the pointer of the first node which points at the second node
         * then it will it will equal the pointer of the second node that points at the third node
         * since we want to insert at position 3 we stop here and start the insertion process
         */
      }
      /*
       * making the pointer of the new node equals the pointer of the second node
       * that used to point at the 'previously' number 3 node which is now number 4
       * lastly making the pointer of the second node points at the new node
       */
      newNode.next = current.next;
      current.next = newNode;
      return true;
    }
  }

  boolean insert(int num) {
    Numbers newNode = new Numbers(num);
    Numbers current = head;
    if (head == null) {
      head = newNode;
      return true;
    }
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
    return true;
  }

  boolean delete(int key) {
    Numbers current = head;
    Numbers previous = null;

    // loking for the value for deletion

    while (current != null && current.num != key) {
      // move to the next node
      previous = current; // making previous node equals the current node
      current = current.next; // making current equals the value of the next node
    }
    // the key wasn't found
    if (current == null) {
      return false;
    }
    // if the key is found but it's the first node
    if (previous == null) {
      head = current.next; // making the head equals the next node
      return true;
    }
    // if the key wan't found in the first node
    else {
      /*
       * the key has been found so now  we make prevoius node points at the node
       * that after the current node which is going to be deleted
       */
      previous.next = current.next;
      current = null; // de-allocation
      return true;
    }
  }

  public void printList() {
    Numbers currNode = head;
    System.out.print("LinkedList: ");

    // Traverse through the LinkedList
    while (currNode != null) {
      // Print the data at current node
      System.out.print(currNode.num + " ");

      // Go to next node
      currNode = currNode.next;
    }
    System.out.println();
  }
}

class test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);

    list.printList();
    list.insert(0, 3);
    list.printList();
    list.delete(1);
    list.printList();
  }
}
