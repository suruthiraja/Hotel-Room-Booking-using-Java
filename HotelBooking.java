import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;// Date formate(DD-MM-YYYY)
import java.util.Date;//Refer current date

public class HotelBooking extends JFrame implements ActionListener {
    CardLayout cardLayout;
    JPanel cards;
    JTextField name, phoneNumber, email,Aadharno,cin,cout;
    JButton nextButton, clearButton, acRoomButton, nonAcRoomButton, checkoutButton;
    JLabel roomDetailsLabel,RentLabel, namedisp, phoneNumberdisp, emaildisp,Aadharnodisp,total,stayingdate;
    int rent;
    String namestore,Aadharnostore, phoneNumberstore,emailstore;
    ImageIcon greenIcon;

    public HotelBooking() {
        setTitle("Hotel Room Booking");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel registrationPanel = createRegistrationPanel();
        JPanel roomTypePanel = createRoomTypePanel();
        JPanel acRoomSelectionPanel = createRoomSelectionPanel(true); //argument
        JPanel nonAcRoomSelectionPanel = createRoomSelectionPanel(false);
        JPanel roomDetailsPanel = createRoomDetailsPanel();


        cards.add(registrationPanel, "Registration");
        cards.add(roomTypePanel, "RoomType");
        cards.add(acRoomSelectionPanel, "ACRoomSelection");
        cards.add(nonAcRoomSelectionPanel, "NonACRoomSelection");
        cards.add(roomDetailsPanel, "RoomDetails");


        greenIcon = new ImageIcon("D:\\Mini project\\checkmark.png");
        Image resizedImage = greenIcon.getImage();
        resizedImage = resizedImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Adjust the width and height as needed

        greenIcon = new ImageIcon(resizedImage);

        add(cards);
        setVisible(true);
    }

    JPanel createRegistrationPanel() { //Return Type
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel reg=new JLabel("ROOM BOOKING FORM");
        reg.setBounds(200,40,200,50);

        JLabel nameLabel = new JLabel("Name ");
        nameLabel.setBounds(200,100,100,30);;

        name= new JTextField();
        name.setBounds(380,100,400,30);

        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setBounds(200,150,150,30);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(380,150,400,30);

        JLabel emailLabel = new JLabel("Email ");
        emailLabel.setBounds(200,200,150,30);

        email = new JTextField();
        email.setBounds(380,200,400,30);

        JLabel AadharLabel = new JLabel("Aadhar No ");
        AadharLabel.setBounds(200,250,150,30);

        Aadharno = new JTextField();
        Aadharno.setBounds(380,250, 400, 30);

        JLabel cinl=new JLabel("Checkin Date(DD-MM-YYYY) ");
        cinl.setBounds(200,300,300,30);

        cin = new JTextField();
        cin.setBounds(380,300, 400, 30);

        JLabel coutl=new JLabel("Checkout Date(DD-MM-YYYY)  ");
        coutl.setBounds(200,350,300,30);

        cout = new JTextField();
        cout.setBounds(380,350, 400, 30);





        panel.add(reg);
        panel.add(nameLabel);
        panel.add(name);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumber);
        panel.add(emailLabel);
        panel.add(email);
        panel.add(AadharLabel);
        panel.add(Aadharno);
        panel.add(cinl);
        panel.add(cin);
        panel.add(coutl);
        panel.add(cout);


        nextButton = new JButton("Next");
        nextButton.setBounds(400,400,150,30);
        nextButton.addActionListener(this);
        panel.add(nextButton);
        clearButton = new JButton("Clear");
        clearButton.setBounds(570,400,150,30);
        clearButton.addActionListener(this);
        panel.add(clearButton);
        return panel;
    }

    JPanel createRoomTypePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        acRoomButton = new JButton("AC Room");
        acRoomButton.setBounds(150,150,200,100);
        nonAcRoomButton = new JButton("Non-AC Room");
        nonAcRoomButton.setBounds(400,150,200,100);

        panel.add(acRoomButton);
        panel.add(nonAcRoomButton);

        acRoomButton.addActionListener(this);
        nonAcRoomButton.addActionListener(this);

        return panel;
    }

    JPanel createRoomSelectionPanel(boolean isAcRoom) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5));
        int n;
        if(isAcRoom) {
            n = 101;
        } else {
            n = 201;
        }
        for (int i = 0; i < 20; i++) {
            JButton roomButton = new JButton("Room No " + (n + i));
            roomButton.addActionListener(this);
            panel.add(roomButton);
        }

        return panel;
    }


    JPanel createRoomDetailsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        roomDetailsLabel = new JLabel();
        roomDetailsLabel.setBounds(100,50,300,40);
        namedisp=new JLabel("NAmw");
        namedisp.setBounds(100,100,300,40);
        phoneNumberdisp=new JLabel("Phone");
        phoneNumberdisp.setBounds(100,150,300,40);
        Aadharnodisp=new JLabel("Aadhar");
        Aadharnodisp.setBounds(100,200,300,40);
        emaildisp=new JLabel("Email");
        emaildisp.setBounds(100,250,300,40);
        RentLabel =new JLabel("Per Day Rent : "+rent);
        RentLabel.setBounds(400,100,300,40);
        total=new JLabel();
        total.setBounds(400,200,300,40);
        stayingdate=new JLabel("");
        stayingdate.setBounds(400,150,300,40);
        JButton backButton = new JButton("Back to Room Selection");
        backButton.setBounds(100,400,200,100);
        checkoutButton = new JButton("Confirm Booking");
        checkoutButton.setBounds(400,400,200,100);

        panel.add(roomDetailsLabel);
        panel.add(RentLabel);
        panel.add(backButton);
        panel.add(checkoutButton);
        panel.add(namedisp);
        panel.add(phoneNumberdisp);
        panel.add(Aadharnodisp);
        panel.add(emaildisp);
        panel.add(total);
        panel.add(stayingdate);

        backButton.addActionListener(this);
        checkoutButton.addActionListener(this);

        return panel;
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            namestore=name.getText();
            phoneNumberstore=phoneNumber.getText();
            emailstore=email.getText();
            Aadharnostore=Aadharno.getText();
            if(phoneNumberstore.length()==10)
            {
                namedisp.setText("Name : "+namestore);
                phoneNumberdisp.setText("Phone Number : "+phoneNumberstore);
                emaildisp.setText("Email : "+emailstore);
                Aadharnodisp.setText("Aadhar Number : "+Aadharnostore);
                cardLayout.show(cards, "RoomType");
            }else {
                JOptionPane.showMessageDialog(this, "Phone Number is not Valid..!!!","Warning",JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == acRoomButton) {
            cardLayout.show(cards, "ACRoomSelection");
            rent=2000;
        } else if (e.getSource() == nonAcRoomButton) {
            cardLayout.show(cards, "NonACRoomSelection");
            rent=1500;
        } else if (e.getActionCommand().startsWith("Room No")) {
            roomDetailsLabel.setText("Selected Room: " + e.getActionCommand());
            RentLabel.setText("Rent Per Day : "+rent);
            cardLayout.show(cards, "RoomDetails");

            String startDateStr = cin.getText();
            String endDateStr = cout.getText();

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);

            try {
                Date startDate = dateFormat.parse(startDateStr);
                Date endDate = dateFormat.parse(endDateStr);

                long differenceMillis = endDate.getTime() - startDate.getTime();
                long differenceDays = differenceMillis / (1000 * 60 * 60 * 24); // Convert milliseconds to days


                long temp = differenceDays;
                long t = temp * rent;
                total.setText("Total Price : " + t);
                stayingdate.setText("No Of Days Room Booked : "+differenceDays);
            }
            catch (ParseException ex) {
                total.setText("Invalid date format. Please use DD-MM-YYYY.");
            }
        } else if (e.getActionCommand().equals("Back to Room Selection")) {
            cardLayout.show(cards, "RoomType");
        } else if (e.getActionCommand().equals("Confirm Booking")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Room has been Successfully Booked",
                    "Room Booked",
                    JOptionPane.INFORMATION_MESSAGE,
                    greenIcon
            );
            cardLayout.show(cards, "Registration");
        } else if (e.getActionCommand().equals("Back to Room Details")) {
            cardLayout.show(cards, "RoomDetails");
        } else if (e.getActionCommand().equals("Confirm Checkout")) {
            JOptionPane.showMessageDialog(this, "Checkout Confirmed!");
            cardLayout.show(cards, "Registration");
        }
        else if(e.getSource()==clearButton)
        {
            name.setText("");
            phoneNumber.setText("");
            email.setText("");
            Aadharno.setText("");
            cin.setText("");
            cout.setText("");
        }
    }

    public static void main(String[] args) {

        HotelBooking system = new HotelBooking();
    }
}