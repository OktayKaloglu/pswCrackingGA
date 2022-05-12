public class LinkedList {
     protected class Node{
        public Node next=null;
        public String chromosome;
        public int fitness;
        public Node(String chromosome,int fitness) {
            this.chromosome=chromosome;
            this.fitness=fitness;

        }
    }

    private Node head=null;

    public void add(String chromosome,int fitness) {//this method ensures that list always sorted as decreasing order
        Node nod = new Node(chromosome,fitness);
        if(head==null){
            this.head=nod;
        }else{
            Node temp=head;
            if (head.fitness<nod.fitness){//if new data is bigger than head we need to make it head
                nod.next=head;
                this.head=nod;
            }else{
                while (temp.next!=null){//it is in between or at the end of the list
                    if(temp.next.fitness<=nod.fitness){
                     break;//we found where to add
                    }else{
                        temp=temp.next;
                    }
                }
                if(temp.next==null){//we need to add it to the end of the list
                    temp.next=nod;
                }else{// we need to add it to 2 nodes

                    nod.next=temp.next;
                    temp.next=nod;
                }

            }

        }
    }
    public String[] popElits(){//it pops elits returns the chromosomes
        return new String[]{head.chromosome,head.next.chromosome};
    }

}
