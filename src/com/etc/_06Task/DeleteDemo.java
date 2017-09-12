package com.etc._06Task;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteDemo {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDemo window = new DeleteDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public DeleteDemo() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 60, 240, 153);
		frame.getContentPane().add(scrollPane);

		table = new JTable();

		UsersDao dao = new UsersDao();
		Object[][] data = dao.showAll();

		table.setModel(new DefaultTableModel(data, new String[] { "编号", "姓名",
				"生日", "兴趣" }));
		scrollPane.setViewportView(table);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem menuItem = new JMenuItem("删除");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "确定删除", "提示",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					Object object = table.getValueAt(table.getSelectedRow(), 0);
					System.out.println(object);
					UsersDao dao1 = new UsersDao();
					try {
						if (dao1.deleteUser((Integer) object)) {
							JOptionPane.showMessageDialog(null, "删除成功");

							UsersDao dao = new UsersDao();
							Object[][] data = dao.showAll();

							table.setModel(new DefaultTableModel(data,
									new String[] { "编号", "姓名", "生日", "兴趣" }));

						} else {

							JOptionPane.showConfirmDialog(null, "删除失败");
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (n == 1) {
					

				}

			}
		});
		popupMenu.add(menuItem);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
