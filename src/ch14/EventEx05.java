package ch14;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx05 extends JFrame {

	private JLabel la; // new �� �����ڿ��� ����
	int nowY = 0;

	public EventEx05() {
		la = new JLabel("Hello");
		setTitle("MouseEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		c.setLayout(null); // absolute ���̾ƿ�
		la.setSize(50, 20); // ���� ������
		la.setLocation(30, 30); // ���� ��ġ
		c.add(la);
		setSize(250, 250);
		setVisible(true); // paint()

	}
	
	class MyPanel extends JPanel {
		public MyPanel() {
			setFocusable(true);
		}
	}

	class MyMouseListener extends MouseAdapter {

		// ���콺�� Ŭ���ϰ� ������ ��
		@Override
		public void mousePressed(MouseEvent e) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int x = e.getX(); // x ��ǥ
					int y = e.getY(); // y ��ǥ
					nowY = la.getY();

					if (la.getY() < y) {
						while (la.getY() != y) {
							System.out.println("y : " + la.getY());
							la.setLocation(x, nowY + 1); // �� ��ġ ����

							nowY = la.getY();
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}

					} else if (la.getY() > y) {
						while (la.getY() != y) {
							System.out.println("y : " + la.getY());
							la.setLocation(x, nowY - 1); // �� ��ġ ����
							nowY = la.getY();
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}
				}
			}).start();

//			if(la.getY() <= y) {
//				for (int i = la.getY(); i <= y; i++) {
//					la.setLocation(x, i); // �� ��ġ ����
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			} else {
//				for (int i = la.getY(); i >= y; i--) {
//					la.setLocation(x, i); // �� ��ġ ����
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
		}
	}

	public static void main(String[] args) {

		new EventEx05();

	}

}
