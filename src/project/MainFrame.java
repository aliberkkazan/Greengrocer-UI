package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JScrollBar;
import javax.swing.JList;

//Fruit Class
class Fruit {
	private String name;
	private int price;

	Fruit(String n, int p) {
		name = n;
		price = p;
	}

	public String GetFruitName() {
		return this.name;
	}

	public int GetFruitPrice() {
		return this.price;
	}
}

// Vegetables Class
class Vegetables {
	private String name;
	private int price;

	Vegetables(String n, int p) {
		name = n;
		price = p;
	}

	public String GetVegetablesName() {
		return this.name;
	}

	public int GetVegetablesPrice() {
		return this.price;
	}
}

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Layered Pane
	private JLayeredPane layeredPane;

	private JPanel contentPane;

	private JPanel switchPanel;
	private JPanel addPanel;
	private JPanel loginPanel;
	private JTextField username;
	private JTextField surname;

	private JCheckBox fruitCheckbox;
	private JButton addFruitButton;
	private JTextField fruitText;
	private JLabel priceLabel;

	private String fruitName;
	private String vegetablesName;

	// List of fruits
	// Created linked list will be e.g:
	// "Orange"->"Orange"->"Orange"->"Orange"->"Orange"->"Orange"->"Orange"
	TreeLinkedList fruitList;

	// List of vegetables
	// Created linked list will be e.g:
	// "EggPland"->"EggPland"->"EggPland"->"EggPland"->"EggPland"->"EggPland"->"EggPland"
	TreeLinkedList vegetablesLinkedList;

	// List of fruit prices
	LinkedList<Fruit> fruitPrices; 

	// List of vegetables prices
	LinkedList<Vegetables> vegetablesPrices;

	// Total Price
	int totalPrice = 0;
	int totalVegetablesPrice = 0;

	private JLabel logoLabel;
	private JButton completeOrderButton;
	private JLabel lblNewLabel_1;
	private JList availableFruitsList;
	private JLabel lblNewLabel_2;

	private DefaultListModel availableFruitsListModel;
	private DefaultListModel availableVegetablesListModel;

	private JList list1;
	private JLabel lblNewLabel_3;

	private JCheckBox vegetablesCheckBox;
	private JPanel vegetablesPanel;
	private JList vegetablesList;
	private JTextField vegetablesField;
	private JButton addVegetablesButton;
	private JList availableVegetablesList;

	private JLabel vegetablesPriceLabel;

	private JButton completeVegetablesOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void SetFruitPrices() {
		fruitPrices.add(new Fruit("Orange", 10));
		fruitPrices.add(new Fruit("Watermelon", 20));
		fruitPrices.add(new Fruit("Apple", 5));
		fruitPrices.add(new Fruit("Banana", 15));
		fruitPrices.add(new Fruit("Cherry", 30));
		fruitPrices.add(new Fruit("Pear", 4));
		fruitPrices.add(new Fruit("Kiwi", 23));
		fruitPrices.add(new Fruit("Coconut", 17));
	}

	public Fruit FindFruit(String name) {
		for (int i = 0; i < fruitPrices.size(); i++) {
			if (fruitPrices.get(i).GetFruitName().toLowerCase().equals(name.toLowerCase())) {
				return fruitPrices.get(i);
			}
		}
		return null;
	}

	public void ListAvailableFruits() {
		for (int i = 0; i < fruitPrices.size(); i++) {
			availableFruitsListModel
					.addElement(fruitPrices.get(i).GetFruitName() + " " + fruitPrices.get(i).GetFruitPrice() + "USD");
			availableFruitsList.setModel(availableFruitsListModel);
		}
	}

	public void SetVegetablesPrices() {
		vegetablesPrices.add(new Vegetables("EggPland", 20));
		vegetablesPrices.add(new Vegetables("Turnip", 30));
		vegetablesPrices.add(new Vegetables("Lettuce", 40));
		vegetablesPrices.add(new Vegetables("Onion", 5));
		vegetablesPrices.add(new Vegetables("Broccoli", 7));
		vegetablesPrices.add(new Vegetables("Garlic", 50));
	}

	public Vegetables FindVegetables(String name) {
		for (int i = 0; i < vegetablesPrices.size(); i++) {
			if (vegetablesPrices.get(i).GetVegetablesName().toLowerCase().equals(name.toLowerCase())) {
				return vegetablesPrices.get(i);
			}
		}
		return null;
	}

	public void ListAvailableVegetables() {
		for (int i = 0; i < vegetablesPrices.size(); i++) {
			availableVegetablesListModel.addElement(vegetablesPrices.get(i).GetVegetablesName() + " "
					+ vegetablesPrices.get(i).GetVegetablesPrice() + "USD");
			availableVegetablesList.setModel(availableVegetablesListModel);
		}
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		// Initialize
		fruitList = new TreeLinkedList();
		fruitPrices = new LinkedList<Fruit>();

		vegetablesLinkedList = new TreeLinkedList();
		vegetablesPrices = new LinkedList<Vegetables>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 460);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 410, 399);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		loginPanel = new JPanel();
		layeredPane.setLayer(loginPanel, 1);
		layeredPane.add(loginPanel, "name_564904301880500");

		// List Model
		DefaultListModel listModel = new DefaultListModel();
		availableFruitsListModel = new DefaultListModel();

		// Vegetables List Model
		DefaultListModel vegetablesListModel = new DefaultListModel();
		availableVegetablesListModel = new DefaultListModel();

		// Set Fruit Prices
		availableFruitsList = new JList();
		SetFruitPrices();

		// Set Vegetables Prices
		availableVegetablesList = new JList();
		SetVegetablesPrices();

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(124, 357, 154, 31);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!username.getText().isEmpty() && !surname.getText().isEmpty()) {
					switchPanels(switchPanel);
				} else {
					JDialog d = new JDialog();
					JLabel l = new JLabel("Name and surname cannot be empty", SwingConstants.CENTER);
					d.getContentPane().add(l);
					d.setSize(300, 100);
					d.setLocationRelativeTo(null);
					d.setVisible(true);
				}
			}
		});
		loginPanel.setLayout(null);
		loginPanel.add(loginButton);

		username = new JTextField();
		username.setBounds(124, 229, 154, 20);
		loginPanel.add(username);
		username.setColumns(10);

		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(124, 292, 154, 20);
		loginPanel.add(surname);

		JLabel lblNewLabel = new JLabel("Surname:");
		lblNewLabel.setBounds(124, 267, 154, 14);
		loginPanel.add(lblNewLabel);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(124, 204, 154, 14);
		loginPanel.add(lblName);

		logoLabel = new JLabel("");
		logoLabel.setBounds(88, 11, 248, 165);
		loginPanel.add(logoLabel);

		ImageIcon logo = new ImageIcon("logo.png");
		logoLabel.setIcon(logo);
		setIconImage(logo.getImage());

		switchPanel = new JPanel();
		layeredPane.add(switchPanel, "name_564913266509200");
		switchPanel.setLayout(null);

		fruitCheckbox = new JCheckBox("Fruits");
		fruitCheckbox.setBounds(157, 89, 97, 23);
		switchPanel.add(fruitCheckbox);

		vegetablesCheckBox = new JCheckBox("Vegetables");
		vegetablesCheckBox.setBounds(157, 121, 97, 23);
		switchPanel.add(vegetablesCheckBox);

		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fruitCheckbox.isSelected()) {
					switchPanels(addPanel);
				}
				if (vegetablesCheckBox.isSelected()) {
					switchPanels(vegetablesPanel);
				}
			}
		});
		continueButton.setBounds(123, 198, 154, 31);
		switchPanel.add(continueButton);

		addPanel = new JPanel();
		layeredPane.add(addPanel, "name_564915524072400");
		addPanel.setLayout(null);

		addFruitButton = new JButton("Add");
		addFruitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fruitName = fruitText.getText();
				Fruit findFruit = FindFruit(fruitName);
				if (findFruit != null) {
					fruitList.push(fruitName);
					listModel.addElement(fruitName);
					list1.setModel(listModel);
					totalPrice += findFruit.GetFruitPrice();
					priceLabel.setText("Total Price: " + String.valueOf(totalPrice) + " USD");
				} else {
					JDialog d = new JDialog();
					JLabel l = new JLabel("Fruit is out of stock", SwingConstants.CENTER);
					d.getContentPane().add(l);
					d.setSize(300, 100);
					d.setLocationRelativeTo(null);
					d.setVisible(true);
				}
			}
		});
		addFruitButton.setBounds(159, 208, 132, 33);
		addPanel.add(addFruitButton);

		fruitText = new JTextField();
		fruitText.setBounds(159, 108, 132, 20);
		addPanel.add(fruitText);
		fruitText.setColumns(10);

		priceLabel = new JLabel("");
		priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLabel.setBounds(268, 362, 132, 14);
		addPanel.add(priceLabel);

		completeOrderButton = new JButton("Complete Order");
		completeOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fruitList.isEmpty()) {
					JDialog d = new JDialog();
					JLabel l = new JLabel("Empty basket! Please add some item.", SwingConstants.CENTER);
					d.getContentPane().add(l);
					d.setSize(300, 100);
					d.setLocationRelativeTo(null);
					d.setVisible(true);
				} else {
					JDialog d = new JDialog();
					JLabel l = new JLabel("Success! Total Price: " + totalPrice + " USD", SwingConstants.CENTER);
					d.getContentPane().add(l);
					d.setSize(300, 100);
					d.setLocationRelativeTo(null);
					d.setVisible(true);
					switchPanels(loginPanel);
					listModel.clear();
					fruitList = new TreeLinkedList();
					totalPrice = 0;
					priceLabel.setText("");
				}
			}
		});
		completeOrderButton.setBounds(159, 252, 132, 33);
		addPanel.add(completeOrderButton);

		lblNewLabel_1 = new JLabel("Available Fruits:");
		lblNewLabel_1.setBounds(10, 40, 90, 14);
		addPanel.add(lblNewLabel_1);

		availableFruitsList.setBounds(10, 65, 139, 245);
		addPanel.add(availableFruitsList);

		ListAvailableFruits();
		ListAvailableVegetables();

		availableFruitsList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					String selectedFruit = availableFruitsList.getSelectedValue().toString();
					selectedFruit = selectedFruit.split(" ")[0];
					fruitText.setText(selectedFruit);
				}
			}
		});

		availableVegetablesList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					String selectedVegetables = availableVegetablesList.getSelectedValue().toString();
					selectedVegetables = selectedVegetables.split(" ")[0];
					vegetablesField.setText(selectedVegetables);
				}
			}
		});

		lblNewLabel_2 = new JLabel("Fruit Name:");
		lblNewLabel_2.setBounds(159, 85, 90, 14);
		addPanel.add(lblNewLabel_2);

		list1 = new JList();
		list1.setBounds(313, 63, 87, 245);
		addPanel.add(list1);

		lblNewLabel_3 = new JLabel("You can add it by selecting fruit from the list.");
		lblNewLabel_3.setBounds(10, 11, 331, 14);
		addPanel.add(lblNewLabel_3);

		vegetablesPanel = new JPanel();
		layeredPane.add(vegetablesPanel, "name_686221600934400");
		vegetablesPanel.setLayout(null);

		vegetablesList = new JList();
		vegetablesList.setBounds(311, 60, 89, 265);
		vegetablesPanel.add(vegetablesList);

		vegetablesField = new JTextField();
		vegetablesField.setBounds(152, 95, 132, 20);
		vegetablesPanel.add(vegetablesField);
		vegetablesField.setColumns(10);

		addVegetablesButton = new JButton("Add");
		addVegetablesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vegetablesName = vegetablesField.getText();
				Vegetables findVegetables = FindVegetables(vegetablesName);
				if (findVegetables != null) {
					vegetablesLinkedList.push(vegetablesName);
					vegetablesListModel.addElement(vegetablesName);
					vegetablesList.setModel(vegetablesListModel);
					totalVegetablesPrice += findVegetables.GetVegetablesPrice();
					vegetablesPriceLabel.setText("Total Price: " + String.valueOf(totalVegetablesPrice) + " USD");
				} else {
					JDialog d = new JDialog();
					JLabel l = new JLabel("Fruit is out of stock", SwingConstants.CENTER);
					d.getContentPane().add(l);
					d.setSize(300, 100);
					d.setLocationRelativeTo(null);
					d.setVisible(true);
				}
			}
		});

		addVegetablesButton.setBounds(152, 206, 132, 33);
		vegetablesPanel.add(addVegetablesButton);

		availableVegetablesList.setBounds(10, 60, 132, 265);
		vegetablesPanel.add(availableVegetablesList);

		vegetablesPriceLabel = new JLabel("");
		vegetablesPriceLabel.setBounds(278, 352, 132, 14);
		vegetablesPanel.add(vegetablesPriceLabel);

		JLabel lblNewLabel_3_1 = new JLabel("You can add it by selecting vegetable from the list.");
		lblNewLabel_3_1.setBounds(10, 11, 331, 14);
		vegetablesPanel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_1_1 = new JLabel("Available Vegetables:");
		lblNewLabel_1_1.setBounds(10, 35, 132, 14);
		vegetablesPanel.add(lblNewLabel_1_1);

		completeVegetablesOrder = new JButton("Complete Order");
		completeVegetablesOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vegetablesLinkedList.isEmpty()) {
					JDialog d = new JDialog();
					JLabel l = new JLabel("Empty basket! Please add some item.", SwingConstants.CENTER);
					d.getContentPane().add(l);
					d.setSize(300, 100);
					d.setLocationRelativeTo(null);
					d.setVisible(true);
				} else {
					JDialog d = new JDialog();
					JLabel l = new JLabel("Success! Total Price: " + totalVegetablesPrice + " USD",
							SwingConstants.CENTER);
					d.getContentPane().add(l);
					d.setSize(300, 100);
					d.setLocationRelativeTo(null);
					d.setVisible(true);
					switchPanels(loginPanel);
					vegetablesListModel.clear();
					vegetablesLinkedList = new TreeLinkedList();
					totalVegetablesPrice = 0;
					vegetablesPriceLabel.setText("");
				}
			}
		});
		completeVegetablesOrder.setBounds(152, 250, 132, 33);
		vegetablesPanel.add(completeVegetablesOrder);

		vegetablesCheckBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (vegetablesCheckBox.isSelected() && fruitCheckbox.isSelected()) {
					fruitCheckbox.setSelected(false);
				}

			}
		});

		fruitCheckbox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (vegetablesCheckBox.isSelected() && fruitCheckbox.isSelected()) {
					vegetablesCheckBox.setSelected(false);
				}

			}
		});
	}

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
