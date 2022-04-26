public class Complex {
public int real;
public int img;

public void setReal(int R)  {real = R;} ///setters
public void setImg(int I)  {img = I;}
public int getReal()  {return real;}  ///getters
public int getImg()  {return img;}
    ///construcor
    Complex(int R,int I)
    {real =R;img =I;}

    Complex(int n)
    {real =img =n;}

    Complex()
    {real=img=0;}
//    ///distructor
//    ~comp()
//     {cout<<"\nparameter destructor"<<endl;}
//    ///
   public void setComp(int R, int I)
      {
        real = R;img = I;
      }

  public void setComp(int N)
     {real = img = N;}

  public void setComp(int N, char M)
      { real = img = N;}

 public Complex add(Complex C)
    {
    Complex Reslt = new Complex();
    Reslt.real= real +C.real;
    Reslt.setImg(img + C.img);
    return Reslt;
    }
  public Complex sub(Complex c)
    {
    Complex Res = new Complex();
    Res.setReal(getReal()-c.getReal());
    Res.setImg(getImg()-c.getImg());
    return Res;
    }
 public static void main(String[] args)
{
Complex c1 = new Complex(5,4);
Complex c2 = new Complex(3,7);
Complex c = new Complex ();
c = c1.add(c2);

//Complex c4 =new Complex();
//c = c1.sub(c2);
  System.out.println("the coplex num is "+ c.real + "+" +c.img +"i");
}
}
