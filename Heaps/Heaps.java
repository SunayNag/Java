import java.util.*;
public class Heaps {
    static class MaxHeap{
        List<Integer> hp = new ArrayList<>();

        boolean isEmpty(){
            return hp.size()==0;
        }

        void swap(int a, int b){
            int temp = hp.get(a);
            hp.set(a, hp.get(b));
            hp.set(b, temp);
        } 

        void add(int data){
            hp.add(data);
            int child = hp.size()-1;
            int par = (child-1)/2;

            while (hp.get(child)<hp.get(par)) {
                int temp = hp.get(par);
                hp.set(par, hp.get(child));
                hp.set(child, temp);
                child=par;
                par=(child-1)/2;
            }
        }

        int peek(){
            return hp.get(0);
        }

        int remove(){
            int temp = hp.get(0);
            hp.set(0, hp.get(hp.size()-1));
            hp.set(hp.size()-1, temp);

            hp.remove(hp.size()-1);

            heapify(0);
            return temp;
        }

        void heapify(int root){
            int left = 2*root+1;
            int right = 2*root+2;
            
            int minIdx = root;
            if(left<hp.size() && hp.get(minIdx)>hp.get(left)){
                minIdx=left;
            }
            if(right<hp.size() && hp.get(minIdx)>hp.get(right)){
                minIdx=right;
            }
            if(minIdx!=root){
                swap(root, minIdx);
                heapify(minIdx);
            }
        }
    }
    
    static class MinHeap{
        List<Integer> hp = new ArrayList<>();

        boolean isEmpty(){
            return hp.size()==0;
        }

        void swap(int a, int b){
            int temp = hp.get(a);
            hp.set(a, hp.get(b));
            hp.set(b, temp);
        } 

        void add(int data){
            hp.add(data);
            int child = hp.size()-1;
            int par = (child-1)/2;

            while (hp.get(child)>hp.get(par)) {
                int temp = hp.get(par);
                hp.set(par, hp.get(child));
                hp.set(child, temp);
                child=par;
                par=(child-1)/2;
            }
        }

        int peek(){
            return hp.get(0);
        }

        int remove(){
            int temp = hp.get(0);
            hp.set(0, hp.get(hp.size()-1));
            hp.set(hp.size()-1, temp);

            hp.remove(hp.size()-1);

            heapify(0);
            return temp;
        }

        void heapify(int root){
            int left = 2*root+1;
            int right = 2*root+2;
            
            int minIdx = root;
            if(left<hp.size() && hp.get(minIdx)<hp.get(left)){
                minIdx=left;
            }
            if(right<hp.size() && hp.get(minIdx)<hp.get(right)){
                minIdx=right;
            }
            if(minIdx!=root){
                swap(root, minIdx);
                heapify(minIdx);
            }
        }
    }
    
    public static void main(String[] args) {
        MinHeap hp = new MinHeap();
        hp.add(6);
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        
        while(!hp.isEmpty()) {
            System.out.println(hp.remove());
        }
    }
}
