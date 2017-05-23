import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Blackjack {

	private JFrame frame;
	private JTextField textFieldBet;
	private JTextField textFieldMoney;
	private JTextField textFieldAnnouncer;
	private int bet, cardNumber, playerSum, dealerSum;
	String playerFirstCard, playerSecCard, playerThirdCard, playerFourthCard, playerFifthCard, playerSixthCard, 
			dealerFirstCard, dealerSecCard, dealerThirdCard, dealerFourthCard, dealerFifthCard, dealerSixthCard;
	private boolean sumOver, dealerOver;
	Dealer dealer = new Dealer();
	private JTextField textFieldDealerSec;
	private JTextField textFieldDealerFirst;
	private JTextField textFieldPlayerSec;
	private JTextField textFieldPlayerThird;
	private JTextField textFieldPlayerFourth;
	private JTextField textFieldPlayerFifth;
	private JTextField textFieldPlayerSixth;
	private JTextField textFieldDealerThird;
	private JTextField textFieldDealerFourth;
	private JTextField textFieldDealerFifth;
	private JTextField textFieldDealerSixth;
	private JTextField textFieldPlayerSum;
	private JTextField textFieldDealerSum;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Blackjack window = new Blackjack();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Blackjack() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 345, 242);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextField textFieldPlayerFirst = new JTextField();
		textFieldPlayerFirst.setEditable(false);
		textFieldPlayerFirst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlayerFirst.setBounds(198, 184, 20, 20);
		frame.getContentPane().add(textFieldPlayerFirst);
		textFieldPlayerFirst.setColumns(10);
		
		JLabel lblYourCards = new JLabel("Your hand");
		lblYourCards.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblYourCards.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourCards.setBounds(113, 169, 75, 14);
		frame.getContentPane().add(lblYourCards);
		
		JLabel lblBetAmount = new JLabel("Bet:");
		lblBetAmount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBetAmount.setBounds(8, 52, 62, 14);
		frame.getContentPane().add(lblBetAmount);
		
		textFieldBet = new JTextField();
		textFieldBet.setEditable(false);
		textFieldBet.setBounds(6, 66, 75, 20);
		frame.getContentPane().add(textFieldBet);
		textFieldBet.setColumns(10);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoney.setBounds(8, 12, 46, 14);
		frame.getContentPane().add(lblMoney);
		
		textFieldMoney = new JTextField();
		textFieldMoney.setToolTipText("Amount of your money.");
		textFieldMoney.setText("0\u20AC");
		textFieldMoney.setEditable(false);
		textFieldMoney.setBounds(6, 27, 75, 20);
		frame.getContentPane().add(textFieldMoney);
		textFieldMoney.setColumns(10);
		
		textFieldDealerSec = new JTextField();
		textFieldDealerSec.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDealerSec.setEditable(false);
		textFieldDealerSec.setColumns(10);
		textFieldDealerSec.setBounds(221, 66, 20, 20);
		frame.getContentPane().add(textFieldDealerSec);
		
		textFieldDealerFirst = new JTextField();
		textFieldDealerFirst.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDealerFirst.setEditable(false);
		textFieldDealerFirst.setColumns(10);
		textFieldDealerFirst.setBounds(198, 66, 20, 20);
		frame.getContentPane().add(textFieldDealerFirst);
		
		textFieldPlayerSec = new JTextField();
		textFieldPlayerSec.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlayerSec.setEditable(false);
		textFieldPlayerSec.setColumns(10);
		textFieldPlayerSec.setBounds(221, 184, 20, 20);
		frame.getContentPane().add(textFieldPlayerSec);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHelp.setBounds(261, 8, 71, 23);
		frame.getContentPane().add(btnHelp);
		
		JLabel lblDealerCards = new JLabel("Dealer hand");
		lblDealerCards.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDealerCards.setHorizontalAlignment(SwingConstants.CENTER);
		lblDealerCards.setBounds(113, 52, 75, 14);
		frame.getContentPane().add(lblDealerCards);
		
		textFieldAnnouncer = new JTextField();
		textFieldAnnouncer.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldAnnouncer.setEditable(false);
		textFieldAnnouncer.setColumns(10);
		textFieldAnnouncer.setBounds(113, 124, 219, 20);
		frame.getContentPane().add(textFieldAnnouncer);
		
		final JButton btnDouble = new JButton("Double");
		btnDouble.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDouble.setEnabled(false);
		btnDouble.setBounds(6, 183, 75, 23);
		frame.getContentPane().add(btnDouble);
		
		final JButton btnStand = new JButton("Stand");
		btnStand.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnStand.setEnabled(false);
		btnStand.setBounds(6, 152, 75, 23);
		frame.getContentPane().add(btnStand);
		
		
		final JButton btnDeal = new JButton("Deal");
		btnDeal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeal.setEnabled(false);
		btnDeal.setBounds(6, 123, 75, 23);
		frame.getContentPane().add(btnDeal);
		
		JLabel lblAnnouncer = new JLabel("Announcer");
		lblAnnouncer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAnnouncer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnouncer.setBounds(113, 108, 75, 14);
		frame.getContentPane().add(lblAnnouncer);
		
		final JButton btnBet = new JButton("Bet");
		btnBet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBet.setEnabled(false);
		btnBet.setBounds(6, 94, 75, 23);
		frame.getContentPane().add(btnBet);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewGame.setBounds(162, 8, 89, 23);
		frame.getContentPane().add(btnNewGame);
		
		textFieldPlayerThird = new JTextField();
		textFieldPlayerThird.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlayerThird.setEditable(false);
		textFieldPlayerThird.setColumns(10);
		textFieldPlayerThird.setBounds(243, 184, 20, 20);
		frame.getContentPane().add(textFieldPlayerThird);
		
		textFieldPlayerFourth = new JTextField();
		textFieldPlayerFourth.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlayerFourth.setEditable(false);
		textFieldPlayerFourth.setColumns(10);
		textFieldPlayerFourth.setBounds(266, 184, 20, 20);
		frame.getContentPane().add(textFieldPlayerFourth);
		
		textFieldPlayerFifth = new JTextField();
		textFieldPlayerFifth.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlayerFifth.setEditable(false);
		textFieldPlayerFifth.setColumns(10);
		textFieldPlayerFifth.setBounds(289, 184, 20, 20);
		frame.getContentPane().add(textFieldPlayerFifth);
		
		textFieldPlayerSixth = new JTextField();
		textFieldPlayerSixth.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlayerSixth.setEditable(false);
		textFieldPlayerSixth.setColumns(10);
		textFieldPlayerSixth.setBounds(312, 184, 20, 20);
		frame.getContentPane().add(textFieldPlayerSixth);
		
		textFieldDealerThird = new JTextField();
		textFieldDealerThird.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDealerThird.setEditable(false);
		textFieldDealerThird.setColumns(10);
		textFieldDealerThird.setBounds(243, 66, 20, 20);
		frame.getContentPane().add(textFieldDealerThird);
		
		textFieldDealerFourth = new JTextField();
		textFieldDealerFourth.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDealerFourth.setEditable(false);
		textFieldDealerFourth.setColumns(10);
		textFieldDealerFourth.setBounds(266, 66, 20, 20);
		frame.getContentPane().add(textFieldDealerFourth);
		
		textFieldDealerFifth = new JTextField();
		textFieldDealerFifth.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDealerFifth.setEditable(false);
		textFieldDealerFifth.setColumns(10);
		textFieldDealerFifth.setBounds(289, 66, 20, 20);
		frame.getContentPane().add(textFieldDealerFifth);
		
		textFieldDealerSixth = new JTextField();
		textFieldDealerSixth.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDealerSixth.setEditable(false);
		textFieldDealerSixth.setColumns(10);
		textFieldDealerSixth.setBounds(312, 66, 20, 20);
		frame.getContentPane().add(textFieldDealerSixth);
		
		textFieldPlayerSum = new JTextField();
		textFieldPlayerSum.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPlayerSum.setEditable(false);
		textFieldPlayerSum.setColumns(10);
		textFieldPlayerSum.setBounds(113, 184, 75, 20);
		frame.getContentPane().add(textFieldPlayerSum);
		
		textFieldDealerSum = new JTextField();
		textFieldDealerSum.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDealerSum.setEditable(false);
		textFieldDealerSum.setColumns(10);
		textFieldDealerSum.setBounds(113, 66, 75, 20);
		frame.getContentPane().add(textFieldDealerSum);
		
		textFieldPlayerFirst.setVisible(false);
		textFieldPlayerSec.setVisible(false);
		textFieldPlayerThird.setVisible(false);
		textFieldPlayerFourth.setVisible(false);
		textFieldPlayerFifth.setVisible(false);
		textFieldPlayerSixth.setVisible(false);
		textFieldDealerFirst.setVisible(false);
		textFieldDealerSec.setVisible(false);
		textFieldDealerThird.setVisible(false);
		textFieldDealerFourth.setVisible(false);
		textFieldDealerFifth.setVisible(false);
		textFieldDealerSixth.setVisible(false);
		
		
		// New game listener
		btnNewGame.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				
					// Resets everything
				dealer.resetMoney();
				textFieldMoney.setText((Integer.toString(dealer.getMoney())) + "€");
				textFieldBet.setText(null);
				textFieldAnnouncer.setText(Announcer.newGame());
				
				btnBet.setEnabled(true);
				btnDeal.setEnabled(false);
				btnStand.setEnabled(false);
				btnDouble.setEnabled(false);
				
				textFieldBet.setEnabled(true);
				textFieldBet.setEditable(true);
				textFieldPlayerFirst.setVisible(false);
				textFieldPlayerFirst.setText(null);
				textFieldPlayerSec.setVisible(false);
				textFieldPlayerSec.setText(null);
				textFieldPlayerThird.setVisible(false);
				textFieldPlayerThird.setText(null);
				textFieldPlayerThird.setVisible(false);
				textFieldPlayerFourth.setText(null);
				textFieldPlayerFourth.setVisible(false);
				textFieldPlayerFifth.setText(null);
				textFieldPlayerFifth.setVisible(false);
				textFieldPlayerSixth.setText(null);
				textFieldPlayerSixth.setVisible(false);
				textFieldPlayerSum.setText(null);
				sumOver = false;
				playerSum = 0;
				
				textFieldDealerFirst.setVisible(false);
				textFieldDealerFirst.setText(null);
				textFieldDealerSec.setVisible(false);
				textFieldDealerSec.setText(null);
				textFieldDealerThird.setVisible(false);
				textFieldDealerThird.setText(null);
				textFieldDealerThird.setVisible(false);
				textFieldDealerFourth.setText(null);
				textFieldDealerFourth.setVisible(false);
				textFieldDealerFifth.setText(null);
				textFieldDealerFifth.setVisible(false);
				textFieldDealerSixth.setText(null);
				textFieldDealerSixth.setVisible(false);
				textFieldDealerSum.setText(null);
				dealerOver = false;
				dealerSum = 0;
			}
		});
		
		// Deal listener
		btnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textFieldPlayerFirst.getText().equals("")){
					
						// Deal first cards
					playerFirstCard = dealer.deal();
					playerSecCard = dealer.deal();
					cardNumber = 3;
					playerSum += dealer.checkValue(playerFirstCard);
					playerSum += dealer.checkValue(playerSecCard);
					dealerFirstCard = dealer.deal();
					textFieldPlayerSum.setText(Integer.toString(playerSum));
					
					
						// Show cards
					textFieldDealerFirst.setText(dealerFirstCard);
					textFieldDealerFirst.setVisible(true);
					textFieldPlayerFirst.setText((playerFirstCard));
					textFieldPlayerFirst.setVisible(true);
					textFieldPlayerSec.setText((playerSecCard));
					textFieldPlayerSec.setVisible(true);
					btnStand.setEnabled(true);
					btnDouble.setEnabled(true);
					textFieldAnnouncer.setText(Announcer.dealFirstCards());
					
				} else if (sumOver == false){
					
						// Deal more cards
					switch(cardNumber){
					case 3:	
						cardNumber++;
						playerThirdCard = dealer.deal();
						playerSum += dealer.checkValue(playerThirdCard);
						btnDouble.setEnabled(false);
						textFieldAnnouncer.setText(Announcer.dealMoreCards());
						textFieldPlayerThird.setText(playerThirdCard);
						textFieldPlayerThird.setVisible(true);
						textFieldPlayerSum.setText(Integer.toString(playerSum));
						sumOver = dealer.ifOver(playerSum);
						break;
					case 4:
						cardNumber++;
						playerFourthCard = dealer.deal();
						playerSum += dealer.checkValue(playerFourthCard);
						textFieldPlayerFourth.setText(playerFourthCard);
						textFieldPlayerFourth.setVisible(true);
						textFieldPlayerSum.setText(Integer.toString(playerSum));
						sumOver = dealer.ifOver(playerSum);
						break;
					case 5:
						cardNumber++;
						playerFifthCard = dealer.deal();
						playerSum += dealer.checkValue(playerFifthCard);
						textFieldPlayerFifth.setText(playerFifthCard);
						textFieldPlayerFifth.setVisible(true);
						textFieldPlayerSum.setText(Integer.toString(playerSum));
						sumOver = dealer.ifOver(playerSum);
						break;
					case 6:
						cardNumber++;
						playerSixthCard = dealer.deal();
						playerSum += dealer.checkValue(playerSixthCard);
						textFieldPlayerSixth.setText(playerSixthCard);
						textFieldPlayerSixth.setVisible(true);
						textFieldPlayerSum.setText(Integer.toString(playerSum));
						sumOver = dealer.ifOver(playerSum);
						break;
					default:
						break;
					}
				}
				
				if(sumOver){
					// Reset
					btnStand.setEnabled(false);
					btnDeal.setEnabled(false);
					btnBet.setEnabled(true);
					btnDouble.setEnabled(false);
					textFieldBet.setEnabled(true);
					textFieldBet.setText(null);
					
					
					// Show dealer second
					dealerSecCard = dealer.deal();
					dealerSum = dealer.checkValue(dealerFirstCard) + dealer.checkValue(dealerSecCard);				
					textFieldAnnouncer.setText(Announcer.playerOver());
					textFieldDealerSec.setText(dealerSecCard);
					textFieldDealerSec.setVisible(true);
					
				}
			}
			});
		
		// Bet listener
		btnBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					bet = Integer.parseInt(textFieldBet.getText());
					
					// Check valid bet
					if(bet < dealer.getMoney()){
						dealer.updateBet(bet);
						textFieldMoney.setText(Integer.toString(dealer.getMoney()) + "€");
						textFieldBet.setText((textFieldBet.getText()) + "€");
						btnDeal.setEnabled(true);
						btnBet.setEnabled(false);
						textFieldBet.setEnabled(false);
						textFieldAnnouncer.setText(Announcer.betAmount(bet));
						
						// Reset player
						textFieldPlayerFirst.setVisible(false);
						textFieldPlayerFirst.setText(null);
						textFieldPlayerSec.setVisible(false);
						textFieldPlayerSec.setText(null);
						textFieldPlayerThird.setVisible(false);
						textFieldPlayerThird.setText(null);
						textFieldPlayerThird.setVisible(false);
						textFieldPlayerFourth.setText(null);
						textFieldPlayerFourth.setVisible(false);
						textFieldPlayerFifth.setText(null);
						textFieldPlayerFifth.setVisible(false);
						textFieldPlayerSixth.setText(null);
						textFieldPlayerSixth.setVisible(false);
						textFieldPlayerSum.setText(null);
						sumOver = false;
						playerSum = 0;
						
						// Reset dealer
						textFieldDealerFirst.setVisible(false);
						textFieldDealerFirst.setText(null);
						textFieldDealerSec.setVisible(false);
						textFieldDealerSec.setText(null);
						textFieldDealerThird.setVisible(false);
						textFieldDealerThird.setText(null);
						textFieldDealerThird.setVisible(false);
						textFieldDealerFourth.setText(null);
						textFieldDealerFourth.setVisible(false);
						textFieldDealerFifth.setText(null);
						textFieldDealerFifth.setVisible(false);
						textFieldDealerSixth.setText(null);
						textFieldDealerSixth.setVisible(false);
						textFieldDealerSum.setText(null);
						dealerOver = false;
						dealerSum = 0;
					} else {
						JOptionPane.showMessageDialog(frame, "Please enter valid bet.", "Bet error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch(Exception e){
					JOptionPane.showMessageDialog(frame, "Please enter valid bet.", "Bet error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// Stand listener
		btnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Deal to dealer
				dealerSum = 0;
				dealerSecCard = dealer.deal();
				dealerSum = dealer.checkValue(dealerFirstCard) + dealer.checkValue(dealerSecCard);				
				textFieldAnnouncer.setText(Announcer.playerStand());
				textFieldDealerSec.setVisible(true);
				textFieldDealerSec.setText(dealerSecCard);
				
				dealerOver = dealer.ifOverDealer(dealerSum);
				cardNumber = 3;
				
				
				// If dealer needs more cards
				if(dealerOver == false){
					
					do{
						
						switch(cardNumber){
						case 3:
							cardNumber++;
							dealerThirdCard = dealer.deal();
							dealerSum += dealer.checkValue(dealerThirdCard);
							textFieldDealerThird.setText(dealerThirdCard);
							textFieldDealerThird.setVisible(true);
							dealerOver = dealer.ifOverDealer(dealerSum);
							break;
						case 4:
							cardNumber++;
							dealerFourthCard = dealer.deal();
							dealerSum += dealer.checkValue(dealerFourthCard);
							textFieldDealerFourth.setText(dealerFourthCard);
							textFieldDealerFourth.setVisible(true);
							dealerOver = dealer.ifOverDealer(dealerSum);
							break;
						case 5:
							cardNumber++;
							dealerFifthCard = dealer.deal();
							dealerSum += dealer.checkValue(dealerFifthCard);
							textFieldDealerFifth.setText(dealerFifthCard);
							textFieldDealerFifth.setVisible(true);
							dealerOver = dealer.ifOverDealer(dealerSum);
							break;
						case 6:
							cardNumber++;
							dealerSixthCard = dealer.deal();
							dealerSum += dealer.checkValue(dealerSixthCard);
							textFieldDealerSixth.setText(dealerSixthCard);
							textFieldDealerSixth.setVisible(true);
							dealerOver = dealer.ifOverDealer(dealerSum);
							break;
						default:
							dealerOver = true;
							break;
						}
						
					}while(dealerOver == false);
				}
				
				// End round				
				textFieldDealerSum.setText(Integer.toString(dealerSum));
				btnStand.setEnabled(false);
				btnDeal.setEnabled(false);
				btnBet.setEnabled(true);
				btnDouble.setEnabled(false);
				textFieldBet.setEnabled(true);
				textFieldBet.setText(null);
				
				// Check win
				textFieldAnnouncer.setText(dealer.checkWin(bet, playerSum, dealerSum));
				textFieldMoney.setText((Integer.toString(dealer.getMoney())) + "€");
				
			}
		});
		
		// Double listener
		btnDouble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dealer.updateBet(bet);
				bet *= 2;
				textFieldMoney.setText((Integer.toString(dealer.getMoney()) + "€"));
				textFieldBet.setText((Integer.toString(bet) + "€"));
				playerThirdCard = dealer.deal();
				playerSum += dealer.checkValue(playerThirdCard);
				btnDouble.setEnabled(false);
				textFieldAnnouncer.setText(Announcer.dealMoreCards());
				textFieldPlayerThird.setText(playerThirdCard);
				textFieldPlayerThird.setVisible(true);
				textFieldPlayerSum.setText(Integer.toString(playerSum));

				btnDeal.setEnabled(false);
				btnStand.setEnabled(true);
				btnDouble.setEnabled(false);
				
				dealer.ifOver(playerSum);
				
				if(sumOver){
					// Reset
					btnStand.setEnabled(false);
					btnDeal.setEnabled(false);
					btnBet.setEnabled(true);
					btnDouble.setEnabled(false);
					textFieldBet.setEnabled(true);
					textFieldBet.setText(null);
					
					
					// Show dealer second
					dealerSecCard = dealer.deal();
					dealerSum = dealer.checkValue(dealerFirstCard) + dealer.checkValue(dealerSecCard);				
					textFieldAnnouncer.setText(Announcer.playerOver());
					textFieldDealerSec.setText(dealerSecCard);
					textFieldDealerSec.setVisible(true);
					
				}
			}
		});
		
		// Help listener
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Goal of the game is to get sum of 21.\n"
						+ "Dealer will stand on 17.\n"
						+ "A = 11\nFace cards = 10\n",
						"Rules", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
}