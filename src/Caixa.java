import java.util.Arrays;
public class Caixa implements Comparable<Caixa> {
    int l, w, h;

    public Caixa(int l, int w, int h) {
        int[] dims = {l, w, h};
        Arrays.sort(dims);
        this.l = dims[0];
        this.w = dims[1];
        this.h = dims[2];
    }

    @Override
    public int compareTo(Caixa o) {
        if (this.l != o.l) return this.l - o.l;
        if (this.w != o.w) return this.w - o.w;
        return this.h - o.h;
    }

    public boolean podeConter(Caixa b) {
        return this.l < b.l && this.w < b.w && this.h < b.h;
    }
}
