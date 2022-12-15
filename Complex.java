public class Complex {
    //The real part of the complex number
    private double real;
    //The imaginary part of the complex number
    private double imagine;

    //Constructor for Complex class.
    public Complex(double reall, double imaginee){
        real = reall;
        imagine = imaginee;
    }

    //Add two complex numbers.
    public Complex add(Complex val){
        double _real = real + val.getReal();
        double _imagine = imagine + val.getImagine();
        return new Complex(_real, _imagine);
    }
    public Complex sub(Complex val){
        double _real = real - val.getReal();
        double _imagine = imagine - val.getImagine();
        return new Complex(_real, _imagine);
    }

    //Multiply two complex numbers.
    public Complex mult(Complex val){
        double _real = (real * val.getReal())-imagine * val.getImagine();
        double _imagine = imagine*val.getImagine() + getImagine()+real;

        Complex _Complex = new Complex(_real, _imagine);
        return _Complex;
    }

    //Calculate the exponential of a complex number.
    public Complex exp() {
        return new Complex(Math.exp(real) * Math.cos(imagine), Math.exp(real) * Math.sin(imagine));
    }

    //Calculate the nth root of unity for a given complex number.
    public Complex rootOfUnity(int n, int k){
        double _real = Math.cos((Math.PI*2*k)/n);
        double _imagine = Math.sin((Math.PI*2*k)/n);
        return new Complex(_real,_imagine);
    }

    //Calculate all nth roots of unity for a given complex number.
    public Complex[] rootOfUnity(int n){
        Complex[] retual = new Complex[n];
        for(int i=0;i<n; ++i){
            retual[i] = rootOfUnity(i,n);
        }
        return retual;
    }

    //Get the real part of the complex number.
    public double getReal(){return real;}
    //Get the imaginary part of the complex number.
    public double getImagine(){return imagine;}

}