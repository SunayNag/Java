public class MultithreadedMergeSort {

    public static void main(String[] args) {
        int size =10000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size); // Random numbers between 0 and 999
        }
        
        int[] arr2 =array.clone();



        System.out.println("Original Array:");
        long start;
        long end;

        MergeSortTask task = new MergeSortTask(array, 0, array.length - 1);
        start = System.currentTimeMillis();
        task.start(); // Start the sorting thread

        try {
            task.join(); // Wait for sorting to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        end = System.currentTimeMillis();

        System.out.println(end-start);
        
        Thread th = new Thread(() ->{
            mergeSort(arr2,0,array.length-1);
        });

        start = System.currentTimeMillis();
        th.start();
         try {
            th.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        end =System.currentTimeMillis();
        System.out.println(end-start);
    }

    // Custom thread class for sorting a portion of the array
    static class MergeSortTask extends Thread {
        private int[] arr;
        private int left;
        private int right;

        
        public MergeSortTask(int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
            // long threadId = Thread.currentThread().getId();
            // System.out.println("Thread ID: " + threadId);

        }
        

        @Override
        public void run() {
            if (left < right) {
                int mid = left + (right - left) / 2;

                // Create two threads to sort each half
                MergeSortTask leftTask = new MergeSortTask(arr, left, mid);
                MergeSortTask rightTask = new MergeSortTask(arr, mid + 1, right);

                leftTask.start();
                rightTask.start();

                try {
                    leftTask.join();
                    rightTask.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Merge sorted halves
                merge(arr, left, mid, right);
            }
        }

        private void merge(int[] arr, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            int[] L = new int[n1];
            int[] R = new int[n2];

            System.arraycopy(arr, left, L, 0, n1);
            System.arraycopy(arr, mid + 1, R, 0, n2);

            int i = 0, j = 0, k = left;

            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k++] = L[i++];
                } else {
                    arr[k++] = R[j++];
                }
            }

            while (i < n1) arr[k++] = L[i++];
            while (j < n2) arr[k++] = R[j++];
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort both halves recursively
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temp arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[mid + 1 + j];

        // Merge the temp arrays

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }

        // Copy remaining elements if any
        while (i < n1)
            arr[k++] = leftArr[i++];

        while (j < n2)
            arr[k++] = rightArr[j++];
    }
    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
