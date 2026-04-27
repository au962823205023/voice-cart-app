package com.voicecart.app;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Product {
    String name;
    String img;

    Product(String n, String i) {
        name = n;
        img = i;
    }
}

public class App {

    static JPanel contentPanel;

    static ArrayList<Product> cart = new ArrayList<>();
    static ArrayList<Product> fav = new ArrayList<>();

    static Product[] products = {
            new Product("Milk", "milk.jpg"),
            new Product("Rice", "rice.jpg"),
            new Product("Bread", "bread.jpg"),
            new Product("Juice", "juice.jpg"),
            new Product("Egg", "egg.jpg")
    };

    public static void main(String[] args) {
        showWelcome();
    }

    static void showWelcome() {

        JFrame frame = new JFrame("Voice Cart App");

        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Voice Cart App", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel desc = new JLabel(
                "<html><center>"
                        + "Buy groceries easily<br>"
                        + "Use voice commands<br>"
                        + "Fast delivery service"
                        + "</center></html>",
                JLabel.CENTER);

        JButton login = new JButton("Login");
        JButton signup = new JButton("Signup");

        JPanel btnPanel = new JPanel();
        btnPanel.add(login);
        btnPanel.add(signup);

        login.addActionListener(e -> {
            frame.dispose();
            showLogin();
        });

        signup.addActionListener(e -> {
            frame.dispose();
            showSignup();
        });

        panel.add(title, BorderLayout.NORTH);
        panel.add(desc, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void showLogin() {

        JFrame frame = new JFrame("Login");

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JTextField age = new JTextField();
        JTextField gender = new JTextField();
        JTextField address = new JTextField();

        JButton submit = new JButton("Submit");

        submit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Login Successful");
            frame.dispose();
            showMainApp();
        });

        panel.add(new JLabel("Name:"));
        panel.add(name);

        panel.add(new JLabel("Email:"));
        panel.add(email);

        panel.add(new JLabel("Age:"));
        panel.add(age);

        panel.add(new JLabel("Gender:"));
        panel.add(gender);

        panel.add(new JLabel("Address:"));
        panel.add(address);

        panel.add(new JLabel(""));
        panel.add(submit);

        frame.add(panel);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void showSignup() {

        JFrame frame = new JFrame("Signup");

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JTextField name = new JTextField();
        JTextField age = new JTextField();
        JTextField email = new JTextField();
        JTextField address = new JTextField();
        JTextField gender = new JTextField();

        JButton submit = new JButton("Submit");

        submit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Signup Successful");
            frame.dispose();
            showMainApp();
        });

        panel.add(new JLabel("Name:"));
        panel.add(name);

        panel.add(new JLabel("Age:"));
        panel.add(age);

        panel.add(new JLabel("Email:"));
        panel.add(email);

        panel.add(new JLabel("Address:"));
        panel.add(address);

        panel.add(new JLabel("Gender:"));
        panel.add(gender);

        panel.add(new JLabel(""));
        panel.add(submit);

        frame.add(panel);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void showMainApp() {

        JFrame frame = new JFrame("Voice Cart App");

        JPanel main = new JPanel(new BorderLayout());

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(30, 30, 80));

        JButton menu = new JButton("☰");
        menu.setForeground(Color.WHITE);
        menu.setBackground(new Color(30, 30, 80));
        menu.setBorderPainted(false);

        JLabel title = new JLabel("Voice Cart App", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        header.add(menu, BorderLayout.WEST);
        header.add(title, BorderLayout.CENTER);

        JPanel side = new JPanel(new GridLayout(5, 1));
        side.setBackground(new Color(70, 70, 120));
        side.setPreferredSize(new Dimension(130, 0));
        side.setVisible(false);

        JButton home = new JButton("Home");
        JButton cartBtn = new JButton("Cart");
        JButton favBtn = new JButton("Favorites");
        JButton voiceBtn = new JButton("Voice");
        JButton contact = new JButton("Contact");

        side.add(home);
        side.add(cartBtn);
        side.add(favBtn);
        side.add(voiceBtn);
        side.add(contact);

        menu.addActionListener(e -> {
            side.setVisible(!side.isVisible());
            frame.revalidate();
        });

        contentPanel = new JPanel(new BorderLayout());

        home.addActionListener(e -> showHome());
        cartBtn.addActionListener(e -> showCart());
        favBtn.addActionListener(e -> showFav());
        voiceBtn.addActionListener(e -> showVoice());
        contact.addActionListener(e -> showContact());

        showHome();

        main.add(header, BorderLayout.NORTH);
        main.add(side, BorderLayout.WEST);
        main.add(contentPanel, BorderLayout.CENTER);

        frame.add(main);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static ImageIcon loadImage(String path) {

        java.net.URL url = App.class.getResource("/images/" + path);

        if (url == null) {
            return new ImageIcon();
        }

        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);

        return new ImageIcon(img);
    }

    static void showHome() {

        contentPanel.removeAll();

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        for (Product p : products) {

            JPanel product = new JPanel(new BorderLayout());

            JLabel img = new JLabel(loadImage(p.img));
            JLabel name = new JLabel(p.name, JLabel.CENTER);

            JButton cartBtn = new JButton("Add Cart");
            JButton favBtn = new JButton("Favorite");

            cartBtn.addActionListener(e -> {
                cart.add(p);
                JOptionPane.showMessageDialog(null, "Added to Cart");
            });

            favBtn.addActionListener(e -> {
                fav.add(p);
                JOptionPane.showMessageDialog(null, "Added to Favorite");
            });

            JPanel btnPanel = new JPanel(new GridLayout(2, 1));
            btnPanel.add(cartBtn);
            btnPanel.add(favBtn);

            product.add(img, BorderLayout.NORTH);
            product.add(name, BorderLayout.CENTER);
            product.add(btnPanel, BorderLayout.SOUTH);

            panel.add(product);
        }

        contentPanel.add(new JScrollPane(panel));

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    static void showCart() {

        contentPanel.removeAll();

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

        for (Product p : cart) {

            JPanel item = new JPanel(new BorderLayout());

            item.add(new JLabel(loadImage(p.img)), BorderLayout.WEST);
            item.add(new JLabel(p.name), BorderLayout.CENTER);

            panel.add(item);
        }

        contentPanel.add(new JScrollPane(panel));

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    static void showFav() {

        contentPanel.removeAll();

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

        for (Product p : fav) {

            JPanel item = new JPanel(new BorderLayout());

            item.add(new JLabel(loadImage(p.img)), BorderLayout.WEST);
            item.add(new JLabel(p.name), BorderLayout.CENTER);

            panel.add(item);
        }

        contentPanel.add(new JScrollPane(panel));

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    static void showVoice() {

        contentPanel.removeAll();

        JButton btn = new JButton("Start Voice Command");

        btn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Voice Command Started\nSay: Add Milk");
        });

        contentPanel.add(btn, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    static void showContact() {

        contentPanel.removeAll();

        JLabel text = new JLabel(
                "<html><center>"
                        + "Contact Us<br>"
                        + "Support: 9876543210<br>"
                        + "Email: support@voicecart.com"
                        + "</center></html>",
                JLabel.CENTER);

        contentPanel.add(text, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();
    }
}