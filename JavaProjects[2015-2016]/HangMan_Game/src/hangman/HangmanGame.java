package hangman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HangmanGame extends JFrame implements ActionListener {
	public wordsDatabase dic;
	private JButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
	private final int WIDTH = 600,HEIGHT = 600;
	private String wordGuessed,storeWord;
	private JLabel lblWord;
	private int wordLength,livesCounter = 0;
	public HangmanGame() {
		dic = new wordsDatabase();
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);
		
		lblWord = new JLabel();
		lblWord.setText("_");
		dashCreator();
		
		instantiateButtons();
		add(a); add(b); add(c); 
		add(d); add(e); add(f);
		add(g); add(h); add(i);
		add(j); add(k); add(l);
		add(m); add(n); add(o);
		add(p); add(q); add(r);
		add(s); add(t); add(u);
		add(v); add(w); add(x);
		add(y); add(z);
		add(lblWord);
		setVisible(true);
	
	}
	public void dashCreator(){
		storeWord = wordGuesser().toLowerCase();
		wordLength = storeWord.length();
		livesCounter = 0;
		for(int i = 1; i<wordLength;i++){
			lblWord.setText(lblWord.getText() + "  " + "_");
		}
		lblWord.setBounds((WIDTH/lblWord.getText().length())+190, 300, 600, 40);
	}
	
	
	public void instantiateButtons(){
		a = new JButton("a");
		a.setBounds(15, 400, 50,50);
		a.setActionCommand("a");
		a.addActionListener(this);
		
		b = new JButton("b");
		b.setBounds(65, 400, 50,50);
		b.setActionCommand("b");
		b.addActionListener(this);
		
		c = new JButton("c");
		c.setBounds(115, 400, 50,50);
		c.setActionCommand("c");
		c.addActionListener(this);
		
		d = new JButton("d");
		d.setBounds(165, 400, 50,50);
		d.setActionCommand("d");
		d.addActionListener(this);
		
		e = new JButton("e");
		e.setBounds(215, 400, 50,50);
		e.setActionCommand("e");
		e.addActionListener(this);
		
		f = new JButton("f");
		f.setBounds(265, 400, 50,50);
		f.setActionCommand("f");
		f.addActionListener(this);
		
		g = new JButton("g");
		g.setBounds(315, 400, 50,50);
		g.setActionCommand("g");
		g.addActionListener(this);
		
		h = new JButton("h");
		h.setBounds(365, 400, 50,50);
		h.setActionCommand("h");
		h.addActionListener(this);
		
		i = new JButton("i");
		i.setBounds(415, 400, 50,50);
		i.setActionCommand("i");
		i.addActionListener(this);
		
		j = new JButton("j");
		j.setBounds(465, 400, 50,50);
		j.setActionCommand("j");
		j.addActionListener(this);
		
		k = new JButton("k");
		k.setBounds(515, 400, 50,50);
		k.setActionCommand("k");
		k.addActionListener(this);
		
		l = new JButton("l");
		l.setBounds(15, 450, 50,50);
		l.setActionCommand("l");
		l.addActionListener(this);
		
		m = new JButton("m");
		m.setBounds(65, 450, 50,50);
		m.setActionCommand("m");
		m.addActionListener(this);
		
		n = new JButton("n");
		n.setBounds(115, 450, 50,50);
		n.setActionCommand("n");
		n.addActionListener(this);
		
		o = new JButton("o");
		o.setBounds(165, 450, 50,50);
		o.setActionCommand("o");
		o.addActionListener(this);
		
		p = new JButton("p");
		p.setBounds(215, 450, 50,50);
		p.setActionCommand("p");
		p.addActionListener(this);
		
		q = new JButton("q");
		q.setBounds(265, 450, 50,50);
		q.setActionCommand("q");
		q.addActionListener(this);
		
		r = new JButton("r");
		r.setBounds(315, 450, 50,50);
		r.setActionCommand("r");
		r.addActionListener(this);
		
		s = new JButton("s");
		s.setBounds(365, 450, 50,50);
		s.setActionCommand("s");
		s.addActionListener(this);
		
		t = new JButton("t");
		t.setBounds(415, 450, 50,50);
		t.setActionCommand("t");
		t.addActionListener(this);
		
		u = new JButton("u");
		u.setBounds(465, 450, 50,50);
		u.setActionCommand("u");
		u.addActionListener(this);
		
		v = new JButton("v");
		v.setBounds(515, 450, 50,50);
		v.setActionCommand("v");
		v.addActionListener(this);
		
		w = new JButton("w");
		w.setBounds(200, 500, 50,50);
		w.setActionCommand("w");
		w.addActionListener(this);
		
		x = new JButton("x");
		x.setBounds(250, 500, 50,50);
		x.setActionCommand("x");
		x.addActionListener(this);
		
		y = new JButton("y");
		y.setBounds(300, 500, 50, 50);
		y.setActionCommand("y");
		y.addActionListener(this);
		
		z = new JButton("z");
		z.setBounds(350, 500, 50, 50);
		z.setActionCommand("z");
		z.addActionListener(this);
	}
	
	public String wordGuesser(){
		int num = (int)	(Math.random() * 6);
		wordGuessed = dic.getWord(num);
		return wordGuessed;
	}
	
	
	public static void main(String[] args) {
		HangmanGame hg = new HangmanGame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		String ac = e.getActionCommand();
		if (ac.equals("a")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'a'){
					a.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("b")){
			
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'b'){
					b.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("c")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'c'){
					c.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
			
		}else if (ac.equals("d")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'd'){
					d.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("e")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'e'){
					this.e.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("f")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'f'){
					f.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("g")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'g'){
					g.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("h")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'h'){
					h.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("i")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'i'){
					i.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("j")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'j'){
					j.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("k")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'k'){
					k.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("l")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'l'){
					l.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("m")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'm'){
					m.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("n")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'n'){
					n.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("o")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'o'){
					o.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("p")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'p'){
					p.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("q")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'q'){
					q.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("r")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'r'){
					r.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("s")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 's'){
					s.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("t")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 't'){
					t.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("u")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'u'){
					u.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("v")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'v'){
					v.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("w")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'w'){
					w.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("x")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'x'){
					this.x.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("y")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'y'){
					y.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}else if (ac.equals("z")){
			for(int x = 0; x<storeWord.length()-1;x++){
				if(storeWord.charAt(x) == 'z'){
					z.setEnabled(false);
				}else {
					livesCounter++;
				}
			}
		}
	}

}
