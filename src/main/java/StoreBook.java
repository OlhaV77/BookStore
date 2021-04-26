public class StoreBook {
    private Books[] storage = new Books[0];
    private int countOfBooks;


    public void add(Books books) {

        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                count++;
            }
        }
        if (count < 1) {
            Books[] collection = new Books[storage.length + 1];

            for (int i = 0; i < storage.length; i++) {
                collection[i] = storage[i];
            }
            collection[collection.length - 1]= books;


            storage = collection;
            countOfBooks++;

        }
    }



    public Books[] getInfo() {
        return storage;
    }

    public void removeBook(int index) {

    }

}