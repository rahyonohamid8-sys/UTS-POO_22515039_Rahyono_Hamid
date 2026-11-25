public class StackRiwayat {
    private String[] data;
    private int top;
    private int kapasitas;

    public StackRiwayat(int kapasitas) {
        this.kapasitas = kapasitas;
        this.data = new String[kapasitas];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == kapasitas - 1;
    }

    public boolean push(String aktivitas) {
        if (isFull()) {
            return false;
        }
        data[++top] = aktivitas;
        return true;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        return data[top--];
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return data[top];
    }

    public int size() {
        return top + 1;
    }

    public void tampilkan() {
        if (isEmpty()) {
            System.out.println("Riwayat kosong");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println((i + 1) + ". " + data[i]);
        }
    }
}
