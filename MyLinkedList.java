//***********************************************************************************************************
//Zun Lin
//CMSC-256
//MyLinkedList
//Project 3:
/*This program is inherit of the AbstractLinkedList class which and element into a linked list and
the program also contains different method that be be use to help modified the linked list.
*/
//************************************************************************************************************
public class MyLinkedList<E> extends AbstractLinkedList{
private Node newNode;
private int index, lastIndex;
    /*
    **********************************************************************************************************************
    Removes the given element from this list, if it is present in the list.
    Returns true if the element was in the list and was removed.
    **********************************************************************************************************************
    */
    @Override
    public boolean remove(Object element) {
        if(element == null){                                               //handle element if its null.
            throw new IllegalArgumentException("can't not be null");
        }
        else if(contains(element)){                                     //call contains methods and if true remove it.
            (newNode.getPrevious()).setNext(newNode.getNext());        //remove the node.
            (newNode.getNext()).setPrevious(newNode.getPrevious());
            mySize--;                                                //change the size.
            return true;                                            //return true.
        }
        return false;                                             //return false if the element is not in the linked list.
    }
    /*
    **********************************************************************************************************************
   Removes the given FIRST element from this list, if it is present in the list.
   Returns true if the element was in the list and was removed.
   **********************************************************************************************************************
   */
    @Override
    public boolean contains(Object element) {
        if(indexOf(element) != -1){            //call the indexOf method and if not equals -1 then the linked list contains element
            return true;                      // and return true
        }
        return false;                       // else return false
    }

    /*
    **********************************************************************************************************************
     Returns the element of this list at the given index.
     Throws IndexOutOfBoundsException if index is out of range.
     **********************************************************************************************************************
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index > size()){                           //handle case if the index is outside the linked list size.
            throw new IndexOutOfBoundsException("Invalid index");
        }
        else{                                                    // if the index is within the linked list.
            newNode = myFront;
            while (index > 0 ){                                // do a while loop if index is over 0.
                newNode = newNode.getNext();                  // goto the next node
                index--;                                     // mines index by 1.
            }
        }
        return newNode.getElement();
    }
    /*
    **********************************************************************************************************************
     Returns the FIRST index where the given element occurs in this list,
     or -1 if the element is not in this list.
     **********************************************************************************************************************
     */
    @Override
    public int indexOf(Object element) {                         //find the index of element head to tail
        index = 0;
        lastIndex = size()+1;
        newNode = myFront;
        if(element == null){                                 // if element is null
            while(index != lastIndex){                      //do a while loop to reach all the node in the liked list
                if(newNode.getElement() == null){          // if find a node is null
                    return index;                         // return the index
                }
                index++;                                // increment index
                newNode=newNode.getNext();             //get the next node
            }
        }
        else{                                                  // if element is not null
            while(index != lastIndex){                        //do a while loop to reach all the node in the liked list
                if(element.equals(newNode.getElement())){    //if find a node is equal to the element.
                    return index;                           // return the index
                }
                index++;                                  //increment the index
                newNode = newNode.getNext();             //get the next node.
            }
        }
        return -1;
    }
    /*
    **********************************************************************************************************************
      Returns the LAST index where the given element occurs in this list,
      or -1 if the element is not in this list.
    **********************************************************************************************************************
      */
    @Override
    public int lastIndexOf(Object element) {                  //find the index of element tail to head.
        index = 0;
        lastIndex = size()+1;
        newNode = myBack;
        if(element == null){                              // if element is null
            while(lastIndex != index){                   //do a while loop to reach all the node in the liked list
                if(newNode.getElement() == null){       // if find a node is null
                    return lastIndex;                  //return the index
                }
                lastIndex--;                         //decrement the index.
                newNode = newNode.getPrevious();    //get the previous node.
            }
        }
        else{                                                   //if element is not null
            while(lastIndex != index){                         //do a while loop to reach all the node in the liked list
                if(element.equals(newNode.getElement())){     //if find a node is equal to the element.
                    return lastIndex;                        //return the index
                }
                lastIndex--;                               //decrement the index.
                newNode = newNode.getPrevious();          //get the previous node.
            }
        }
        return -1;                                     //return -1 if element is not in the linked list.
    }
    /*
**********************************************************************************************************************
       Helper method: returns the node at the given index.
       -1 returns dummy header, and size() returns the dummy tail.
**********************************************************************************************************************
      */
    @Override
    protected Node getNodeAt(int index) throws IndexOutOfBoundsException {
        if (index < -1 || index > size()){                                   //handle case for index not in the linked list size.
            throw new IndexOutOfBoundsException("Invalid index");           //throw exception if index is outside the linked list.
        }
        else if(index == -1){                                             //if index is equal to -1.
            newNode = myFront;                                           //return dummy head
        }
        else if(index == size()){                                      //if index is equal to the linked list size.
            newNode = myBack;                                         //return dummy tail
        }
        else if(index <= size()/2){                                      //get the index if its in the first half of the linked list.
            newNode = myFront;                                          //set newNode to head node.
            while(index >= 0){                                         //do a while loop if index is not zero.
                newNode = newNode.getNext();                          //get the next node.
                index--;                                             //decrement the index.
            }
        }
        else{                                                     //if the index is in the second half of the linked list.
            newNode = myBack;                                    //set newNode to tail node.
            while(index <= size()){                             //do a while loop if index is not size of the linked list.
                newNode = newNode.getPrevious();               //get th previous node.
                index++;                                      //increment the index.
            }
        }
        return newNode;                                    //return the node.
    }
    /*
    **********************************************************************************************************************
        Returns an array containing all of the elements in this list
        in the correct order.
    **********************************************************************************************************************
        */
    @Override
    public Object[] toArray() {
        Node [] array = new Node[size()];             //create a new array
        newNode = myFront.getNext();                 //newNode is equal to the first element
        for(int i = 0; i< size(); i++){             //do a for loop to get all the nodes.
            array[i] = newNode;                    //set array to the element in nodes
            newNode = newNode.getNext();          //get the next node
        }
        return array;                           //return the array.
    }
    /*
    **********************************************************************************************************************
         Returns a String representation of this list.
    **********************************************************************************************************************
       */
    @Override
    public String toString() {
        String output = "[ ";                               //create a string called output
        newNode = myFront.getNext();                       //newNode is equal to the first element
        while(newNode.getNext() != null){                 // do a while loop to get all the elements
            output = output+newNode.getElement()+ ", ";  //add the element to the output string.
            newNode = newNode.getNext();                // get the next node.
        }
        return output += "]";                         //return the result.
    }
}
