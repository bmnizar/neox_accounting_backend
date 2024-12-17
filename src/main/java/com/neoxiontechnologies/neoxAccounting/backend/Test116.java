package com.neoxiontechnologies.neoxAccounting.backend;
class Chicks {
	synchronized void yack(long id) {
		for (int x = 1; x < 3; x++) {
			System.out.print(id + " ");
			Thread.yield();
		}
	}
}

public class Test116 implements Runnable {
	Chicks c;

	public static void main(String[] args) {
		new Test116().go();
	}

	void go() {
		c = new Chicks();
		new Thread(this).start(); // Démarrer le premier thread avec cette instance de Test116
		new Thread(this).start(); // Démarrer le deuxième thread avec la même instance de Test116
	}

	public void run() {
		c.yack(Thread.currentThread().getId());
	}
}
