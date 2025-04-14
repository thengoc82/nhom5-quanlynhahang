package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.bienStatic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlgThayDoiTienBanDau extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField txtTienBanDau;
	public static JTextField txtTienLayRa;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			dlgThayDoiTienBanDau dialog = new dlgThayDoiTienBanDau(new JDialog());
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public dlgThayDoiTienBanDau(JDialog dlgThayCa) {
		super(dlgThayCa, true);
		setBounds(100, 100, 557, 298);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTienBanDau = new JLabel("Tiền ban đầu:");
			lblTienBanDau.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			lblTienBanDau.setBounds(10, 47, 143, 27);
			contentPanel.add(lblTienBanDau);
		}
		{
			txtTienBanDau = new JTextField();
			txtTienBanDau.setEditable(false);
			txtTienBanDau.setText(bienStatic.tienTaiQuay + "");
			txtTienBanDau.setBounds(163, 47, 287, 27);
			contentPanel.add(txtTienBanDau);
			txtTienBanDau.setColumns(10);
		}
		{
			JLabel lblTienLayRa = new JLabel("Tiền lấy ra:");
			lblTienLayRa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			lblTienLayRa.setBounds(10, 118, 143, 27);
			contentPanel.add(lblTienLayRa);
		}
		{
			txtTienLayRa = new JTextField();
			txtTienLayRa.setColumns(10);
			txtTienLayRa.setBounds(163, 118, 287, 27);
			contentPanel.add(txtTienLayRa);
		}
		{
			JButton btnXacNhan = new JButton("Xác nhận");
			btnXacNhan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(check()) {
						dlgXacNhanQL dlgXacNhan = new dlgXacNhanQL(dlgThayCa);
						dlgXacNhan.setLocationRelativeTo(dlgThayCa);
						dlgXacNhan.setVisible(true);
						dlgThayDoiTienBanDau.this.setVisible(false);
					}
				}
			});
			btnXacNhan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			btnXacNhan.setBounds(249, 191, 107, 29);
			contentPanel.add(btnXacNhan);
		}
		{
			JButton btnHuy = new JButton("Hủy");
			btnHuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dlgThayDoiTienBanDau.this.dispose();
				}
			});
			btnHuy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			btnHuy.setBounds(383, 191, 107, 29);
			contentPanel.add(btnHuy);
		}
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                txtTienLayRa.requestFocusInWindow();
	            }
	        });
	}
	public boolean check() {
		String layRa = txtTienLayRa.getText();
		try {
			double tienLayRa = Double.parseDouble(layRa);
			if(tienLayRa > bienStatic.tienTaiQuay) {
				JOptionPane.showMessageDialog(null, "Không đủ tiền!");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi: kiểu dữ liệu");
			return false;
		}
		return true;
		
	}

}
