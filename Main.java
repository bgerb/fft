



public class Main {


    // compute the FFT of x[], assuming its length n is a power of 2
    public static Complex[] fft(Complex[] x) {
        int n = x.length;

        // base case
        if (n == 1) return new Complex[]{x[0]};

        if (n % 2 != 0) {
          return null;
        }

        // compute FFT of even terms
        Complex[] even = new Complex[n / 2];
        for (int k = 0; k < n / 2; k++) {
            even[k] = x[2 * k]; // adds none imaginary
        }
        Complex[] evenFFT = fft(even);

        // compute FFT of odd terms
        Complex[] odd = new Complex[n/2];
        for (int k = 0; k < n / 2; k++) {
            odd[k] = x[2 * k + 1]; //adds imaganry
        }
        Complex[] oddFFT = fft(odd);

        // combine
        Complex[] y = new Complex[n];
        for (int k = 0; k < n / 2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k] = evenFFT[k].add(wk.mult(oddFFT[k]));
            y[k + n / 2] = evenFFT[k].sub(wk.mult(oddFFT[k]));
        }
        return y;
    }
    public static void main(String[] args) {
        // Create an array of complex numbers representing the input sequence
        Complex[] input = {new Complex(1, 0), new Complex(2, 0), new Complex(3, 0), new Complex(4, 0)};
        Complex[] test = fft(input);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i].getReal());
            System.out.println(test[i].getImagine());

        }
    }
}