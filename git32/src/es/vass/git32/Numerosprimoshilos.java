package es.vass.git32;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Numerosprimoshilos extends Thread 
{
    //Definicion de variables igu
    static JFrame f;
    static JButton bpro,bsal;
    static JTextField tfa,tfb;
    static TextArea tanumpri;
    static JLabel linfo,la,lb;   
   //Definicion de variables
    static int a,b,i,j,rango,partes;
  	static String si,sa,sb,spri="";
  	
    public void main()//metodo principal
    	 {
    	 //Construccion de objetos
    	 linfo= new JLabel ("Coloca el rango de numeros ");
    	 la= new JLabel ("Ingresa el numero menor");
    	 lb= new JLabel ("Ingresa el numero mayor");
    	 tfa= new JTextField(8);
    	 tfb= new JTextField(8);
    	 bpro= new JButton("Hallar");
    	 bpro.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ validacion(); }});
    	 bsal= new JButton("Salir");
    	 bsal.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ System.exit(0); }});
    	 tanumpri= new TextArea(5,30);
    	 //Construccion del contenedor y adicion de objetos
    	 f= new JFrame ("Programa para hallar numeros primos en un rango");
    	 f.add(linfo);
    	 f.add(la);
    	 f.add(tfa);
    	 f.add(lb);
    	 f.add(tfb);
    	 f.add(bpro);
    	 f.add(tanumpri);
    	 f.add(bsal);
    	 f.setLayout(new FlowLayout());	
    	 f.reshape(100,100,300,320);	
    	 f.show();
    	 
    }
    
   
    public void validacion()
    { try
    {
   
    	sa=tfa.getText();
    	sb=tfb.getText();
    	a=Integer.parseInt(sa);
    	b=Integer.parseInt(sb);
    	if(a<b)
    	{
    		rango=b-a;
    		partes=rango/3;
    		long inicio=System.currentTimeMillis();
    		hilo1 h1=new hilo1();
    		h1.start();
    		hilo2 h2=new hilo2();
    		h2.start();
    		hilo3 h3=new hilo3();
    		h3.start();
    		try{
				h1.stop();
				h2.sleep(12000);
				h3.suspend();
				h3.isAlive();
				h2.resume();
				h1.resume();
				h1.setPriority(1);
				h2.setPriority(2);
			}
			catch (InterruptedException e){		}
			long tiempo = System.currentTimeMillis()-inicio;
			System.out.println(tiempo/1000+" segundos ");
    	}
    	else
    	{
    	JOptionPane.showMessageDialog(null,("Error el rango no es correcto"));
    	}
     }
     catch(Exception e){ JOptionPane.showMessageDialog(null,("Error ingresa numeros"));    }	
    }
    
    
    public static void main(String[] args) 
    {
       Numerosprimoshilos z=new Numerosprimoshilos();
       z.main();
    }
public class hilo1 extends Thread
{
	 public void run()
    {
    if(a==1 || a==0)//verifica q el primer rango sea igualado a 2 para evitar errores
    {
    	a=2;
    }
    	
    for (i=a;i<=partes;i++) //Realiza el recorrido por los numeros del rango
    	{
    		j=2;
	    	while(i%j!=0)// Realiza la operacion para hallar el residuo de una division y este residuo es diferente a cero entonces continua
			{
				j=j+1;
				if(i==j)
				{
					si=Integer.toString(i);
					spri=spri+si+" , ";
				}
			}
    	}
    	
     	
	

    }
}
public class hilo2 extends Thread
{
	 public void run()
    {
	for (i=partes+1;i<=partes*2;i++) //Realiza el recorrido por los numeros del rango
    	{
    		j=2;
	    	while(i%j!=0)// Realiza la operacion para hallar el residuo de una division y este residuo es diferente a cero entonces continua
			{
				j=j+1;
				if(i==j)
				{
					si=Integer.toString(i);
					spri=spri+si+" , ";
				}
			}
    	}
    }
}
public class hilo3 extends Thread
{
	 public void run()
    {
	 for (i=partes*2+1;i<=b;i++) //Realiza el recorrido por los numeros del rango
    	{
    		j=2;
	    	while(i%j!=0)// Realiza la operacion para hallar el residuo de una division y este residuo es diferente a cero entonces continua
			{
				j=j+1;
				if(i==j)
				{
					si=Integer.toString(i);
					spri=spri+si+" , ";
				}
			}
    	}
    	tanumpri.setText(spri);
    	}
}



}
