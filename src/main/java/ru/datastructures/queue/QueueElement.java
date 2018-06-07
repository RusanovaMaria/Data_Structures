package ru.datastructures.queue;

public class QueueElement {

     QueueElement next;
     Object value;

     public QueueElement(Object value) {
         this.value = value;
     }

     public QueueElement() {}
}
