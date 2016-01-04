



import javax.sound.sampled.*;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.math.*;
import java.net.URL;
import java.util.Random;
public class fb extends Frame implements Runnable
{
	
	AudioInputStream audioIn;
	Frame f1;
	Thread t;
Image bg,mons,plat,bird1,bird2,gr,go;
Image []wood=new Image[21];
Image []pole3=new Image[21];
Clip clip;
int cnt,i,t1,x,j,b,c,l,y,score;
int birdy,birdy1,birdr,birdr1,polex,polex1,poley,poled;
int []ul=new int[21];int []dl=new int[21];
int gap;
int safed;

public fb()
{
	t1=0;
	b=0;
x=0;
j=0;
birdr=400;
	cnt=l=y=0;
	birdy=birdy1=400;
	score=0;
	gap=200;
	safed=200;
	i=0;
	c=0;
	poley=poled=0;
	polex=polex1=1000;
	t=new Thread(this);
	t.start();
	new Frame("flappy");
	setBounds(0, 0,1500, 800);
	
	//URL url = getClass().getResource("alert.gif");
	  bg = Toolkit.getDefaultToolkit().getImage("flapbg.png");
	  gr = Toolkit.getDefaultToolkit().getImage("gr.png");
	  go = Toolkit.getDefaultToolkit().getImage("go.png");

	 bird1 = Toolkit.getDefaultToolkit().getImage("bird1.png");
	 bird2= Toolkit.getDefaultToolkit().getImage("bird2.png");
	  plat = Toolkit.getDefaultToolkit().getImage("plat.png");
for(int i=0;i<21;i++)
{
	  wood[i] = Toolkit.getDefaultToolkit().getImage("wood.png");
	  pole3[i]=Toolkit.getDefaultToolkit().getImage("pole3.png");
	  ul[i]=0;
	  dl[i]=0;
}	
KeyListener t=new KeyListener() {
	
	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		int keyCode = ke.getKeyCode();
	    switch( keyCode ) {
	    
	    case KeyEvent.VK_UP:
	    	j=1;
	    	  birdy1=birdy;
	    	  birdr1=birdr;
	    	break;
	    }
		
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		int keyCode = ke.getKeyCode();
	    switch( keyCode ) { 
	    
	    case KeyEvent.VK_UP:
	    	j=1;
	    	  birdy1=birdy;
	    	  birdr1=birdr;
	    	  break;
	    }
	}
};

addKeyListener(t);


 setBackground(Color.BLUE);
 setVisible(true);
 addWindowListener(new WindowAdapter(){
 public void windowClosing(WindowEvent we){
	  System.exit(0);
 dispose();
 
 }
 });





}
public void playSound() throws LineUnavailableException {
	
	
	try {
		audioIn = AudioSystem.getAudioInputStream(fb.class.getResource("flap.wav"));
		 clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.start();
	
		while(clip.getMicrosecondLength() != clip.getMicrosecondPosition())
		{
		}
		clip.setMicrosecondPosition(0);
		
		
		 
	
	} catch (UnsupportedAudioFileException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void paint(Graphics g)

{
	

	  i++;
	 
	  if(i==1)
	  {
		  g.drawImage(bg,0,0,1500,800,this);
		  g.drawImage(plat,0,700,1500,100,this);

		 // g.drawImage(wood,1000,0,50,ul,this);


	  }
	  x=x+10;
	  if(x>=1500)
		  
	  {
		  x=0;
		 // yc=((int)Math.random()*350);
	  }
	  g.drawImage(plat,0,700,1500,100,this);
	 // g.drawImage(wood,1000,0,50,ul,this);

	  g.drawImage(bg,00-x,0,1500,800,this);
	  t1=1500-x;
	  if(t1<0)
	  {
		  t1=1500;
	  }
	  g.drawImage(bg,t1,0,1500,800,this);
	  g.drawImage(plat,t1,700,1500,100,this);
	 // g.drawImage(pole3,1000,dl,50,700,this);
	  if(c==0)
	  {
		  
		  g.drawImage(gr,600,400,180,100,this);
		  
		  
	  }
	  if(c==3)
	  {
		  g.drawImage(go,600,400,280,160,this);
		  
	  }


if(c==1)
{y=y+10;
	{polex=1500-3*y;
	
for(int y=0;y<5;y++)
{
	  g.drawImage(wood[y],polex+y*430,0,50,ul[y],this);

	  g.drawImage(pole3[y],polex+y*430,dl[y],50,700,this);
	  if((polex+y*430>=370 && polex+y*430<=430)  &&( birdy<ul[y] || birdy>dl[y]) )
	  {
		  
		  System.out.println("yshit");
		  score=score-5;
			try {
				clip.stop();
				audioIn = AudioSystem.getAudioInputStream(fb.class.getResource("lost.wav"));
				  g.drawImage(go,600,400,280,160,this);
				  c=3;

				
				try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					clip.open(audioIn);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clip.start();
			
				while(clip.getMicrosecondLength() != clip.getMicrosecondPosition())
				{
				}
				clip.setMicrosecondPosition(0);
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  try {
			t.sleep(4000);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  		  
	
	  }
	  else 
	  {
		  score=score+5;
		  System.out.println("score!!!"+score);

		  
	  }
}	
	 /* g.drawImage(wood[2],polex+350,0,50,ul[2],this);

	  g.drawImage(pole3[2],polex+350,dl[2],50,700,this);
	  
	  g.drawImage(wood[3],polex+700,0,50,ul[3],this);

	  g.drawImage(pole3[3],polex+700,dl[3],50,700,this);
	  
	  g.drawImage(wood[4],polex+1050,0,50,ul[4],this);

	  g.drawImage(pole3[4],polex+1050,dl[4],50,700,this);
	  
	  g.drawImage(wood[5],polex+1400,0,50,ul[5],this);

	  g.drawImage(pole3[5],polex+1400,dl[5],50,700,this);*/
//System.out.println("yo");
if(y>=1500)
{y=0;}


	}

}
	 // g.drawImage(bird,400,birdy,70,70,this);
	  if(i%2==1)
	  {g.drawImage(bird1, birdr, birdy,50,50, this);}
  else if(i%2==0)
  {
	  g.drawImage(bird2, birdr, birdy,50,50, this);
  }
		
	if(j==1)
	{
		
		birdy=birdy-22;
		if(birdy1-birdy>=80)
		{
			
			j=3;
			
			
		}
		
		
		
	}
	if(j==2)
	{
		birdr=birdr+10;
		if(birdr-birdr1>=16)
		{
			
			
			j=3;
		}

		
		
		
	}
	if(j==3)
	{
		birdy=birdy+22;
	
		
		
		
	}
}

@Override
public void run() {

	// TODO Auto-generated method stub
	while(true)
	{
		
		
		
	
if(b==125)
{
	for(l=0;l<5;l++)
	{
int minValue=00;
  int maxValue=birdy;
 ul[l] = (int)(minValue + ((new Random()).nextDouble() * (maxValue - minValue)));
 dl[l]=ul[l]+150;
  System.out.println("ul"+ul[l]+"dl"+dl[l]);
	}
c=1;
b=0;

}
		repaint();
		 

		try {
		t.sleep(100);
		b++;
			cnt++;
			
		 //t.wait();
	
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}



public static void main(String args[])
{
	fb f=new fb();
	 
	  while(true)
	  {
		  
		  try {
			f.playSound();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  

}

}
