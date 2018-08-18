package StackAndQueue.DogCatQueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        dogQ = new LinkedList<PetEnterQueue>();
        catQ = new LinkedList<PetEnterQueue>();
        count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (dogQ.isEmpty()) {
            return catQ.poll().getPet();
        } else if (catQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else {
            throw new RuntimeException("err, queue is Empty");
        }
    }

    public Pet pollDog() {
        if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else {
            throw new RuntimeException("err, no dog");
        }
    }

    public Pet pollCat() {
        if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("err, no cat");
        }
    }

    public boolean isEmpty() {

        return this.dogQ.isEmpty() && this.catQ.isEmpty();
/*        if (dogQ.isEmpty() && catQ.isEmpty()){
            return true;
        }else{
            return false;
        }*/
    }

    public boolean isDogEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQ.isEmpty();
    }
}
