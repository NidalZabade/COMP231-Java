package application;

import java.io.*;
import java.text.*;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Main extends Application {
	Stage window;
	Scene s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17,s18;
	String Plan = null;
	int limit = 2;

	static MediaRentalManeger m = new MediaRentalManeger();

	@Override
	public void start(Stage primaryStage) throws Exception {

		File customer = new File("/Users/hp/Desktop/Project/Customer.txt");
		File media = new File("/Users/hp/Desktop/Project/media.txt");
		Scanner sc = new Scanner(customer);
		PrintWriter first = new PrintWriter(customer);
		first.print("Customers' Information:-");
		first.close();
		PrintWriter second = new PrintWriter(media);
		second.print("Media Information:-");
		second.close();

		if (sc.nextLine().equals("Customers' Information:-")) {
			while (sc.hasNextLine()) {
				String[] c = sc.nextLine().split(" ");
				m.addCustomer(Long.parseLong(c[1]), c[3], c[5], c[7], c[9]);
			}
			Scanner sm = new Scanner(media);
			if (sm.nextLine().equals("Media Information:-")) {
				while (sm.hasNextLine()) {
					String[] Media = sm.nextLine().split(" ");
					if (Media[0].equals("Movie:-")) {
						m.addMovie(Media[2], Media[4], Integer.parseInt(Media[7]), Media[9]);
					} else if (Media[0].equals("Album:-")) {
						m.addAlbum(Media[2], Media[4], Integer.parseInt(Media[7]), Media[9], Media[11]);
					} else if (Media[0].equals("Game:-")) {
						m.addGame(Media[2], Media[4], Integer.parseInt(Media[7]), Double.parseDouble(Media[9]));
					}

				}
			}

			window = primaryStage;
			BorderPane root = new BorderPane();
			Image icon1 = new Image("customer.png");
			ImageView imv1 = new ImageView(icon1);
			imv1.setFitHeight(70);
			imv1.setFitWidth(100);
			Image icon2 = new Image("media.png");
			ImageView imv2 = new ImageView(icon2);
			imv2.setFitHeight(70);
			imv2.setFitWidth(100);
			Image icon3 = new Image("rent.png");
			ImageView imv3 = new ImageView(icon3);
			imv3.setFitHeight(70);
			imv3.setFitWidth(100);
			Button bt1 = new Button("Customer", imv1);
			Button bt2 = new Button("Media", imv2);
			Button bt3 = new Button("Rent", imv3);
			bt1.setPrefSize(180, 90);
			bt2.setPrefSize(180, 90);
			bt3.setPrefSize(180, 90);

			bt1.setOnAction(e -> {
				window.setScene(s2);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt2.setOnAction(e -> {
				window.setScene(s6);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt3.setOnAction(e -> {
				window.setScene(s14);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			VBox v = new VBox(60);
			v.setAlignment(Pos.CENTER);
			v.setPadding(new Insets(100, 100, 100, 100));
			v.getChildren().addAll(bt1, bt2, bt3);
			StackPane s = new StackPane();
			s.setAlignment(Pos.CENTER);
			Label lb = new Label("Media Rental System");
			lb.setFont(Font.font(50));
			lb.setLayoutX(300);
			lb.setLayoutY(200);
			lb.setLayoutX(1000);
			lb.setLayoutY(700);
			Image im1 = new Image("test.jpeg");
			ImageView imv = new ImageView(im1);
			imv.setImage(im1);
			imv.setLayoutX(100);
			imv.setLayoutY(100);
			imv.setFitWidth(600);
			imv.setPreserveRatio(true);
			HBox h = new HBox();
			h.setAlignment(Pos.BOTTOM_CENTER);
			s.getChildren().add(imv);
			h.setLayoutX(500);
			h.getChildren().add(lb);
			s.getChildren().add(h);
			root.setLeft(v);
			root.setCenter(s);
			s1 = new Scene(root);

			// Customer
			BorderPane root1 = new BorderPane();
			Button bt4 = new Button("Add Customer");
			Button bt5 = new Button("Delete Customer");
			Button bt6 = new Button("Update Info about Customer");
			Button bt7 = new Button("Search a Customer by Id");
			Button btPrintCustomer = new Button("Print All Customers Info");
			Button bt8 = new Button("Return to main page");
			bt4.setPrefSize(180, 90);
			bt5.setPrefSize(180, 90);
			bt6.setPrefSize(180, 90);
			bt7.setPrefSize(180, 90);
			bt8.setPrefSize(180, 90);
			btPrintCustomer.setPrefSize(180, 90);
			bt4.setOnAction(e -> {
				window.setScene(s3);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt5.setOnAction(e -> {
				window.setScene(s4);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt6.setOnAction(e -> {
				window.setScene(s8);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt7.setOnAction(e -> {
				window.setScene(s5);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt8.setOnAction(e -> {
				window.setScene(s1);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			btPrintCustomer.setOnAction(e -> {
				window.setScene(s18);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			VBox v1 = new VBox(60);
			v1.setAlignment(Pos.CENTER);
			v1.setPadding(new Insets(100, 100, 100, 100));
			v1.getChildren().addAll(bt4, bt5, bt6, bt7, btPrintCustomer, bt8);
			root1.setCenter(v1);
			s2 = new Scene(root1);

			// Add Customer
			BorderPane root2 = new BorderPane();
			Label lb1 = new Label("Customer ID:");
			TextField tx1 = new TextField();
			Label lb2 = new Label("Customer Name:");
			TextField tx2 = new TextField();
			tx2.setDisable(true);
			Label lb3 = new Label("Customer Address:");
			TextField tx3 = new TextField();
			tx3.setDisable(true);
			Label lb4 = new Label("Customer Mobile:");
			TextField tx4 = new TextField();
			tx4.setDisable(true);
			Label lbPlan = new Label("Customer Plan:");
			Label lblimit = new Label("Set limit:");
			TextField txlimit = new TextField();
			lb1.setPrefSize(140, 70);
			lb2.setPrefSize(140, 70);
			lb3.setPrefSize(140, 70);
			lb4.setPrefSize(140, 70);
			lbPlan.setPrefSize(140, 70);
			lblimit.setPrefSize(140, 70);
			HBox hb1 = new HBox(10);
			HBox hb2 = new HBox(10);
			HBox hb3 = new HBox(10);
			HBox hb4 = new HBox(10);
			HBox hbPlan = new HBox(10);
			HBox hblimit = new HBox(10);
			hb1.setAlignment(Pos.CENTER);
			hb2.setAlignment(Pos.CENTER);
			hb3.setAlignment(Pos.CENTER);
			hb4.setAlignment(Pos.CENTER);
			hbPlan.setAlignment(Pos.CENTER);
			hblimit.setAlignment(Pos.CENTER);
			hb1.setPadding(new Insets(10, 10, 10, 10));
			hb2.setPadding(new Insets(10, 10, 10, 10));
			hb3.setPadding(new Insets(10, 10, 10, 10));
			hb4.setPadding(new Insets(10, 10, 10, 10));
			hbPlan.setPadding(new Insets(10, 10, 10, 10));
			hblimit.setPadding(new Insets(10, 10, 10, 10));
			RadioButton rbPlan1 = new RadioButton("LIMITED");
			RadioButton rbPlan2 = new RadioButton("UNLIMITED");
			ToggleGroup tgPlan = new ToggleGroup();
			rbPlan1.setToggleGroup(tgPlan);
			rbPlan2.setToggleGroup(tgPlan);
			
			rbPlan1.setDisable(true);
			rbPlan2.setDisable(true);
			Button btsubmit1 = new Button("submit");
			btsubmit1.setPrefSize(90, 10);
			btsubmit1.setDisable(true);
			hb1.getChildren().addAll(lb1, tx1);
			hb2.getChildren().addAll(lb2, tx2);
			hb3.getChildren().addAll(lb3, tx3);
			hb4.getChildren().addAll(lb4, tx4);
			hbPlan.getChildren().addAll(lbPlan, rbPlan1, rbPlan2, btsubmit1);
			hblimit.getChildren().addAll(lblimit, txlimit);

			VBox vb2 = new VBox(20);
			vb2.setAlignment(Pos.CENTER);
			vb2.setPadding(new Insets(10, 10, 10, 10));
			vb2.getChildren().addAll(hb1, hb2, hb3, hb4, hbPlan);

			Image icon4 = new Image("add.png");
			ImageView imv4 = new ImageView(icon4);
			imv4.setFitHeight(70);
			imv4.setFitWidth(100);
			Image icon5 = new Image("back.png");
			ImageView imv5 = new ImageView(icon5);
			imv5.setFitHeight(70);
			imv5.setFitWidth(100);

			tx1.setOnKeyTyped(e->tx2.setDisable(false));
			tx2.setOnKeyTyped(e->tx3.setDisable(false));
			tx3.setOnKeyTyped(e->tx4.setDisable(false));
			tx4.setOnKeyTyped(e->{
				rbPlan1.setDisable(false);
				rbPlan2.setDisable(false);
				btsubmit1.setDisable(false);
			});
			
			
			Button bt9 = new Button("Add", imv4);
			Button bt10 = new Button("Back", imv5);

			bt9.setPrefSize(180, 90);
			bt10.setPrefSize(180, 90);

			bt9.setOnAction(e -> {
				try {
					long Id = Long.parseLong(tx1.getText());
					String Name = "";
					String Address = "";
					String Mobile = "";
					
					 if (m.checkCustomer(Id)) {
						Alert.AlertBox("Worning", "There is a Cutomer has the same ID");
					} else {
						Name=tx2.getText();
						Address=tx3.getText();
						Mobile=tx4.getText();
						
						if(Name.equals("")||Address.equals("")||Mobile.equals("")||Plan.equals("")) {
							throw new Exception();
						}
						else {
						m.addCustomer(Id, Name, Address, Mobile, Plan);
						Alert.AlertBox("Alert", "Addition Complete");
						tx1.clear();
						tx2.clear();
						tx3.clear();
						tx4.clear();
						tgPlan.selectToggle(null);
						txlimit.clear();
						}
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter all the information");
				}

			});
			btsubmit1.setOnAction(e -> {
				if (rbPlan1.isSelected()) {
					vb2.getChildren().add(hblimit);
					Plan = "LIMITED";
					if (txlimit.getText().equals(null)) {
						m.setLimitedPlanLimit(limit);
					} else {
						txlimit.setText("2");
						limit = Integer.parseInt(txlimit.getText());
						m.setLimitedPlanLimit(limit);
					}

				} else if (rbPlan2.isSelected()) {
					Plan = "UNLIMITED";
					vb2.getChildren().remove(hblimit);

				}
			});

			bt10.setOnAction(e -> {
				window.setScene(s2);
				tx1.clear();
				tx2.clear();
				tx3.clear();
				tx4.clear();
				tgPlan.selectToggle(null);
				txlimit.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hb5 = new HBox(200);
			hb5.setAlignment(Pos.CENTER);
			hb5.setPadding(new Insets(10, 10, 10, 10));
			hb5.getChildren().addAll(bt9, bt10);
			root2.setCenter(vb2);
			root2.setBottom(hb5);
			s3 = new Scene(root2);

			// Delete Customer
			BorderPane root3 = new BorderPane();
			Label lbId = new Label("Customer ID:");
			TextField txId = new TextField();
			lbId.setPrefSize(140, 70);
			HBox hb6 = new HBox(10);
			hb6.setAlignment(Pos.CENTER);
			hb6.setPadding(new Insets(10, 10, 10, 10));
			hb6.getChildren().addAll(lbId, txId);
			VBox vb3 = new VBox(20);
			vb3.setAlignment(Pos.CENTER);
			vb3.setPadding(new Insets(10, 10, 10, 10));
			vb3.getChildren().addAll(hb6);
			vb3.setLayoutX(40);
			vb3.setLayoutY(40);

			Image icon6 = new Image("delete.png");
			ImageView imv6 = new ImageView(icon6);
			imv6.setFitHeight(70);
			imv6.setFitWidth(100);

			Button bt11 = new Button("Delete", imv6);
			Button bt12 = new Button("Back", imv5);
			bt11.setPrefSize(180, 90);
			bt12.setPrefSize(180, 90);
			bt11.setOnAction(e -> {
				try {
					long Id = Long.parseLong(txId.getText());
					if (!(m.checkCustomer(Id))) {
						Alert.AlertBox("Worning", "There is no such a customer");
					} else {
						m.deleteCustomer(Id);
						Alert.AlertBox("Alert", "Deletion Complete");
						txId.clear();
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter the ID");

				}
			});
			bt12.setOnAction(e -> {
				window.setScene(s2);
				txId.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hb7 = new HBox(200);
			hb7.setAlignment(Pos.CENTER);
			hb7.setPadding(new Insets(10, 10, 10, 10));
			hb7.getChildren().addAll(bt11, bt12);
			root3.setCenter(vb3);
			root3.setBottom(hb7);
			s4 = new Scene(root3);

			// Update info about Customer
			BorderPane rootupdate = new BorderPane();
			Label lbupdate1 = new Label("Customer ID:");
			TextField txupdate1 = new TextField();
			Label lbupdate2 = new Label("Customer Name:");
			TextField txupdate2 = new TextField();
			Label lbupdate3 = new Label("Customer Address:");
			TextField txupdate3 = new TextField();
			Label lbupdate4 = new Label("Customer Mobile:");
			TextField txupdate4 = new TextField();
			Label lbUpdatePlan = new Label("Customer Plan:");
			lbupdate1.setPrefSize(140, 70);
			lbupdate2.setPrefSize(140, 70);
			lbupdate3.setPrefSize(140, 70);
			lbupdate4.setPrefSize(140, 70);
			lbUpdatePlan.setPrefSize(140, 70);
			HBox hbUpdate1 = new HBox(10);
			HBox hbUpdate2 = new HBox(10);
			HBox hbUpdate3 = new HBox(10);
			HBox hbUpdate4 = new HBox(10);
			HBox hbUpdatePlan = new HBox(10);
			hbUpdate1.setAlignment(Pos.CENTER);
			hbUpdate2.setAlignment(Pos.CENTER);
			hbUpdate3.setAlignment(Pos.CENTER);
			hbUpdate4.setAlignment(Pos.CENTER);
			hbUpdatePlan.setAlignment(Pos.CENTER);
			hbUpdate1.setPadding(new Insets(10, 10, 10, 10));
			hbUpdate2.setPadding(new Insets(10, 10, 10, 10));
			hbUpdate3.setPadding(new Insets(10, 10, 10, 10));
			hbUpdate4.setPadding(new Insets(10, 10, 10, 10));
			hbUpdatePlan.setPadding(new Insets(10, 10, 10, 10));
			RadioButton rbUpdatePlan1 = new RadioButton("LIMITED");
			RadioButton rbUpdatePlan2 = new RadioButton("UNLIMITED");
			ToggleGroup tgPUpdatelan = new ToggleGroup();
			rbUpdatePlan1.setToggleGroup(tgPUpdatelan);
			rbUpdatePlan2.setToggleGroup(tgPUpdatelan);
			Button btUpdatesubmit1 = new Button("submit");
			btUpdatesubmit1.setPrefSize(90, 10);
			hbUpdate1.getChildren().addAll(lbupdate1, txupdate1);
			hbUpdate2.getChildren().addAll(lbupdate2, txupdate2);
			hbUpdate3.getChildren().addAll(lbupdate3, txupdate3);
			hbUpdate4.getChildren().addAll(lbupdate4, txupdate4);
			hbUpdatePlan.getChildren().addAll(lbUpdatePlan, rbUpdatePlan1, rbUpdatePlan2, btUpdatesubmit1);

			Image icon7 = new Image("update.png");
			ImageView imv7 = new ImageView(icon7);
			imv7.setFitHeight(70);
			imv7.setFitWidth(100);
			Image icon8 = new Image("search.png");
			ImageView imv8 = new ImageView(icon8);
			imv8.setFitHeight(70);
			imv8.setFitWidth(100);

			VBox vbUpdate2 = new VBox(20);
			vbUpdate2.setAlignment(Pos.CENTER);
			vbUpdate2.setPadding(new Insets(10, 10, 10, 10));
			vbUpdate2.getChildren().addAll(hbUpdate1);
			Button btUpdate9 = new Button("Update", imv7);
			Button btUpdate10 = new Button("Find", imv8);
			Button btUpdate11 = new Button("Back", imv5);
			btUpdate9.setPrefSize(180, 90);
			btUpdate10.setPrefSize(180, 90);
			btUpdate11.setPrefSize(180, 90);

			btUpdate9.setOnAction(e -> {
				try {
					long Id = Long.parseLong(txupdate1.getText());
					String Name = txupdate2.getText();
					String Address = txupdate3.getText();
					String Mobile = txupdate4.getText();
					if(Name.equals("")||Address.equals("")||Mobile.equals("")||Plan.equals("")) {
						throw new Exception();
					}

					m.addCustomer(Id, Name, Address, Mobile, Plan);
					Alert.AlertBox("Alert", "Update Completed");
					txupdate1.clear();
					txupdate2.clear();
					txupdate3.clear();
					txupdate4.clear();

				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter all the information");
				}

			});
			btUpdatesubmit1.setOnAction(e -> {
				if (rbUpdatePlan1.isSelected()) {
					Plan = "LIMITED";

				} else if (rbUpdatePlan2.isSelected()) {
					Plan = "UNLIMITED";
				}
			});
			HBox hbUpdate = new HBox(20);
			hbUpdate.setAlignment(Pos.CENTER);
			hbUpdate.setPadding(new Insets(10, 10, 10, 10));
			hbUpdate.getChildren().addAll(btUpdate9, btUpdate10, btUpdate11);
			rootupdate.setCenter(vbUpdate2);
			rootupdate.setBottom(hbUpdate);

			btUpdate10.setOnAction(e -> {
				try {
					long Id = Long.parseLong(txupdate1.getText());
					if (!(m.checkCustomer(Id))) {
						Alert.AlertBox("Worning", "There is no such customer");
					} else {
						String[] Split = new String[10];
						Split = m.getCustomerInfo(Id).split(" ");
						vbUpdate2.getChildren().addAll(hbUpdate2, hbUpdate3, hbUpdate4, hbUpdatePlan);
						String Plan2 = new String();
						txupdate1.clear();
						txupdate1.setText(Split[1]);
						txupdate2.setText(Split[3]);
						txupdate3.setText(Split[5]);
						txupdate4.setText(Split[7]);
						if (Split[9].equals("LIMITED")) {
							tgPUpdatelan.selectToggle(rbUpdatePlan1);
							Plan2 = "LIMITED";
						} else if (Split[9].equals("UNLIMITED")) {
							tgPUpdatelan.selectToggle(rbUpdatePlan2);
							Plan2 = "UNLIMITED";
						}
						m.deleteCustomer(Id);
						m.addCustomer(Long.parseLong(txupdate1.getText()), txupdate2.getText(), txupdate3.getText(),
								txupdate4.getText(), Plan2);
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter the ID");
				}
			});

			btUpdate11.setOnAction(e -> {
				window.setScene(s2);
				txupdate1.clear();
				txupdate2.clear();
				txupdate3.clear();
				txupdate4.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hbUpdate5 = new HBox(200);
			hbUpdate5.setAlignment(Pos.CENTER);
			hbUpdate5.setPadding(new Insets(10, 10, 10, 10));
			hbUpdate5.getChildren().addAll(btUpdate9, btUpdate10, btUpdate11);
			rootupdate.setCenter(vbUpdate2);
			rootupdate.setBottom(hbUpdate5);
			s8 = new Scene(rootupdate); 

			// Search Customer
			BorderPane rootSearchCustomer = new BorderPane();
			Label lbSearchCustomer1 = new Label("Customer ID:");
			TextField txSearchCustomer1 = new TextField();
			Label lbSearchCustomer2 = new Label("Customer Name:");
			TextField txSearchCustomer2 = new TextField();
			txSearchCustomer2.setDisable(true);
			Label lbSearchCustomer3 = new Label("Customer Address:");
			TextField txSearchCustomer3 = new TextField();
			txSearchCustomer3.setDisable(true);
			Label lbSearchCustomer4 = new Label("Customer Mobile:");
			TextField txSearchCustomer4 = new TextField();
			txSearchCustomer4.setDisable(true);
			Label lbSearchPlan = new Label("Customer Plan:");
			lbSearchCustomer1.setPrefSize(140, 70);
			lbSearchCustomer2.setPrefSize(140, 70);
			lbSearchCustomer3.setPrefSize(140, 70);
			lbSearchCustomer4.setPrefSize(140, 70);
			lbSearchPlan.setPrefSize(140, 70);
			HBox hbSearchCustomer1 = new HBox(10);
			HBox hbSearchCustomer2 = new HBox(10);
			HBox hbSearchCustomer3 = new HBox(10);
			HBox hbSearchCustomer4 = new HBox(10);
			HBox hbSearchPlan = new HBox(10);
			hbSearchCustomer1.setAlignment(Pos.CENTER);
			hbSearchCustomer2.setAlignment(Pos.CENTER);
			hbSearchCustomer3.setAlignment(Pos.CENTER);
			hbSearchCustomer4.setAlignment(Pos.CENTER);
			hbSearchPlan.setAlignment(Pos.CENTER);
			hbSearchCustomer1.setPadding(new Insets(10, 10, 10, 10));
			hbSearchCustomer2.setPadding(new Insets(10, 10, 10, 10));
			hbSearchCustomer3.setPadding(new Insets(10, 10, 10, 10));
			hbSearchCustomer4.setPadding(new Insets(10, 10, 10, 10));
			hbSearchPlan.setPadding(new Insets(10, 10, 10, 10));
			RadioButton rbSearchPlan1 = new RadioButton("LIMITED");
			RadioButton rbSearchPlan2 = new RadioButton("UNLIMITED");
			rbSearchPlan1.setDisable(true);
			rbSearchPlan2.setDisable(true);
			ToggleGroup tgSearchPlan = new ToggleGroup();
			rbSearchPlan1.setToggleGroup(tgSearchPlan);
			rbSearchPlan2.setToggleGroup(tgSearchPlan);
			hbSearchCustomer1.getChildren().addAll(lbSearchCustomer1, txSearchCustomer1);
			hbSearchCustomer2.getChildren().addAll(lbSearchCustomer2, txSearchCustomer2);
			hbSearchCustomer3.getChildren().addAll(lbSearchCustomer3, txSearchCustomer3);
			hbSearchCustomer4.getChildren().addAll(lbSearchCustomer4, txSearchCustomer4);
			hbSearchPlan.getChildren().addAll(lbSearchPlan, rbSearchPlan1, rbSearchPlan2);


			VBox vbSearchCustomer2 = new VBox(20);
			vbSearchCustomer2.setAlignment(Pos.CENTER);
			vbSearchCustomer2.setPadding(new Insets(10, 10, 10, 10));
			vbSearchCustomer2.getChildren().addAll(hbSearchCustomer1);
			
			Button btSearch10 = new Button("Find", imv8);
			Button btSearch11 = new Button("Back", imv5);
			btSearch10.setPrefSize(180, 90);
			btSearch11.setPrefSize(180, 90);

			
			HBox hbSearchCustomer = new HBox(20);
			hbSearchCustomer.setAlignment(Pos.CENTER);
			hbSearchCustomer.setPadding(new Insets(10, 10, 10, 10));
			hbSearchCustomer.getChildren().addAll(btSearch10, btSearch11);
			rootSearchCustomer.setCenter(vbSearchCustomer2);
			rootSearchCustomer.setBottom(hbSearchCustomer);

			btSearch10.setOnAction(e -> {
				try {
					long Id = Long.parseLong(txSearchCustomer1.getText());
					if (!(m.checkCustomer(Id))) {
						Alert.AlertBox("Worning", "There is no such customer");
					} else {
						txSearchCustomer1.setDisable(true);
						String[] Split = new String[10];
						Split = m.getCustomerInfo(Id).split(" ");
						vbSearchCustomer2.getChildren().addAll(hbSearchCustomer2, hbSearchCustomer3, hbSearchCustomer4, hbSearchPlan);
						txSearchCustomer1.clear();
						txSearchCustomer1.setText(Split[1]);
						txSearchCustomer2.setText(Split[3]);
						txSearchCustomer3.setText(Split[5]);
						txSearchCustomer4.setText(Split[7]);
						if (Split[9].equals("LIMITED")) {
							tgSearchPlan.selectToggle(rbSearchPlan1);
						} else if (Split[9].equals("UNLIMITED")) {
							tgSearchPlan.selectToggle(rbSearchPlan2);
						}
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter the ID");
				}
			});

			btSearch11.setOnAction(e -> {
				window.setScene(s2);
				txSearchCustomer1.clear();
				txSearchCustomer2.clear();
				txSearchCustomer3.clear();
				txSearchCustomer4.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hbSearchCustomer5 = new HBox(200);
			hbSearchCustomer5.setAlignment(Pos.CENTER);
			hbSearchCustomer5.setPadding(new Insets(10, 10, 10, 10));
			hbSearchCustomer5.getChildren().addAll(btSearch10, btSearch11);
			rootSearchCustomer.setCenter(vbSearchCustomer2);
			rootSearchCustomer.setBottom(hbSearchCustomer5);
			s5 = new Scene(rootSearchCustomer);
			
			
			Image icon9 = new Image("print.png");
			ImageView imv9 = new ImageView(icon9);
			imv9.setFitHeight(70);
			imv9.setFitWidth(100);
			
			
			//Print All Customers
			
			BorderPane rootPrintCustomer = new BorderPane();
			TextArea taPrintAllCustomer = new TextArea();
			taPrintAllCustomer.setPrefSize(500, 500);
			VBox vbPrintAllCustomer = new VBox(20);
			vbPrintAllCustomer.setAlignment(Pos.CENTER);
			vbPrintAllCustomer.setPadding(new Insets(10, 10, 10, 10));
			vbPrintAllCustomer.getChildren().addAll(taPrintAllCustomer);
			vbPrintAllCustomer.setLayoutX(40);
			vbPrintAllCustomer.setLayoutY(40);
			Button btPrintAllCustomer = new Button("Print", imv9);
			Button btBackAllCustomer = new Button("Back", imv5);
			btPrintAllCustomer.setPrefSize(180, 90);
			btBackAllCustomer.setPrefSize(180, 90);
			btPrintAllCustomer.setOnAction(e -> {
				taPrintAllCustomer.setText(m.getAllCustomersInfo());
			});
			btBackAllCustomer.setOnAction(e -> {
				window.setScene(s2);
				taPrintAllCustomer.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hbPrintAllCustomer = new HBox(200);
			hbPrintAllCustomer.setAlignment(Pos.CENTER);
			hbPrintAllCustomer.setPadding(new Insets(10, 10, 10, 10));
			hbPrintAllCustomer.getChildren().addAll(btPrintAllCustomer, btBackAllCustomer);
			rootPrintCustomer.setCenter(vbPrintAllCustomer);
			rootPrintCustomer.setBottom(hbPrintAllCustomer);
			s18 = new Scene(rootPrintCustomer);

			// Media
			BorderPane root6 = new BorderPane();
			Button bt15 = new Button("Add Media");
			Button bt16 = new Button("Delete Media");
			Button bt17 = new Button("Update Info about Media");
			Button bt18 = new Button("Search a Media by Code");
			Button btPrintAll = new Button("Print All Media Info");
			Button bt19 = new Button("Return to main page");
			bt15.setPrefSize(180, 90);
			bt16.setPrefSize(180, 90);
			bt17.setPrefSize(180, 90);
			bt18.setPrefSize(180, 90);
			bt19.setPrefSize(180, 90);
			btPrintAll.setPrefSize(180, 90);
			bt15.setOnAction(e -> {
				window.setScene(s7);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt16.setOnAction(e -> {
				window.setScene(s11);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt17.setOnAction(e -> {
				window.setScene(s9);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt18.setOnAction(e -> {
				window.setScene(s12);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			btPrintAll.setOnAction(e->{
				window.setScene(s10);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			bt19.setOnAction(e -> {
				window.setScene(s1);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			VBox vb5 = new VBox(60);
			vb5.setAlignment(Pos.CENTER);
			vb5.setPadding(new Insets(100, 100, 100, 100));
			vb5.getChildren().addAll(bt15, bt16, bt17, bt18,btPrintAll, bt19);
			root6.setCenter(vb5);
			s6 = new Scene(root6);

			// Add Media
			BorderPane root7 = new BorderPane();
			Label lb7 = new Label("Media Code:");
			TextField tx7 = new TextField();
			Label lb8 = new Label("Media Title:");
			TextField tx8 = new TextField();
			tx8.setDisable(true);
			Label lb9 = new Label("Number Of Copies:");
			TextField tx9 = new TextField();
			tx9.setDisable(true);
			lb7.setPrefSize(140, 70);
			lb8.setPrefSize(140, 70);
			lb9.setPrefSize(140, 70);
			ComboBox<String> cb1 = new ComboBox<>();
			cb1.getItems().addAll("Movie", "Album", "Game");
			cb1.setPromptText("Media Type");
			cb1.setPrefSize(140, 10);
			cb1.setDisable(true);
			HBox hb10 = new HBox(10);
			hb10.setAlignment(Pos.CENTER);
			hb10.setPadding(new Insets(10, 10, 10, 10));
			hb10.getChildren().addAll(lb7, tx7);
			HBox hb11 = new HBox(10);
			hb11.setAlignment(Pos.CENTER);
			hb11.setPadding(new Insets(10, 10, 10, 10));
			hb11.getChildren().addAll(lb8, tx8);
			HBox hb12 = new HBox(10);
			hb12.setAlignment(Pos.CENTER);
			hb12.setPadding(new Insets(10, 10, 10, 10));
			hb12.getChildren().addAll(lb9, tx9);
			HBox hbsubmit = new HBox(105);
			hbsubmit.setAlignment(Pos.CENTER);
			hbsubmit.setPadding(new Insets(10, 10, 10, 10));
			hbsubmit.getChildren().addAll(cb1);

			// Movie
			Label lb13 = new Label("Rating:");
			RadioButton rb1 = new RadioButton("HR");
			RadioButton rb2 = new RadioButton("MR");
			RadioButton rb3 = new RadioButton("LR");
			lb13.setPrefSize(140, 70);
			ToggleGroup tg1 = new ToggleGroup();
			rb1.setToggleGroup(tg1);
			rb2.setToggleGroup(tg1);
			rb3.setToggleGroup(tg1);
			HBox hbMovie = new HBox(10);
			hbMovie.setAlignment(Pos.CENTER);
			hbMovie.setPadding(new Insets(10, 10, 10, 10));
			hbMovie.getChildren().addAll(lb13, rb1, rb2, rb3);

			// Album
			Label lb14 = new Label("Artist");
			TextField tx14 = new TextField();
			tx14.setDisable(true);
			Label lb15 = new Label("Songs");
			TextField tx15 = new TextField();
			tx15.setDisable(true);
			lb14.setPrefSize(140, 70);
			lb15.setPrefSize(140, 70);
			HBox hb17 = new HBox(10);
			HBox hb18 = new HBox(10);
			hb17.setAlignment(Pos.CENTER);
			hb18.setAlignment(Pos.CENTER);
			hb17.setPadding(new Insets(10, 10, 10, 10));
			hb18.setPadding(new Insets(10, 10, 10, 10));
			hb17.getChildren().addAll(lb14, tx14);
			hb18.getChildren().addAll(lb15, tx15);
			VBox vbAlbum = new VBox(20);
			vbAlbum.setAlignment(Pos.CENTER);
			vbAlbum.setPadding(new Insets(10, 10, 10, 10));
			vbAlbum.getChildren().addAll(hb17, hb18);

			// Game
			Label lb16 = new Label("Weight:");
			TextField tx16 = new TextField();
			lb16.setPrefSize(140, 70);
			HBox hbGame = new HBox(10);
			hbGame.setAlignment(Pos.CENTER);
			hbGame.setPadding(new Insets(10, 10, 10, 10));
			hbGame.getChildren().addAll(lb16, tx16);

			VBox vb6 = new VBox(10);
			vb6.setAlignment(Pos.CENTER);
			vb6.setPadding(new Insets(10, 10, 10, 10));
			vb6.getChildren().addAll(hb10, hb11, hb12, hbsubmit);
			Button bt20 = new Button("Add", imv4);
			Button bt21 = new Button("Back", imv5);
			bt20.setPrefSize(180, 90);
			bt21.setPrefSize(180, 90);
			HBox hb19 = new HBox(200);
			hb19.setAlignment(Pos.CENTER);
			hb19.setPadding(new Insets(10, 10, 10, 10));
			hb19.getChildren().addAll(bt20, bt21);
			root7.setCenter(vb6);
			root7.setBottom(hb19);
			s7 = new Scene(root7);
			
			
			tx7.setOnKeyTyped(e->tx8.setDisable(false));
			tx8.setOnKeyTyped(e->tx9.setDisable(false));
			tx9.setOnKeyReleased(e->cb1.setDisable(false));
			tx9.setOnKeyTyped(e->tx14.setDisable(false));
			tx14.setOnKeyTyped(e->tx15.setDisable(false));	
			
			cb1.setOnAction(e -> {
				if (cb1.getValue().equals("Movie")) {
					vb6.getChildren().add(hbMovie);
					vb6.getChildren().remove(vbAlbum);
					vb6.getChildren().remove(hbGame);
				} else if (cb1.getValue().equals("Album")) {
					vb6.getChildren().remove(hbMovie);
					vb6.getChildren().add(vbAlbum);
					vb6.getChildren().remove(hbGame);
				} else if (cb1.getValue().equals("Game")) {
					vb6.getChildren().remove(hbMovie);
					vb6.getChildren().remove(vbAlbum);
					vb6.getChildren().add(hbGame);
				}
			});
			
			
			
			bt20.setOnAction(e -> {
				try {
					String Code = tx7.getText();
					if (m.checkMedia(Code)) {
						Alert.AlertBox("Alert", "There is a Media has the same Code");
					} else {
						String title = tx8.getText();
						int Copies = Integer.parseInt(tx9.getText());
						String rating = "";
						if (rb1.isSelected()) {
							rating = "HR";
						} else if (rb2.isSelected()) {
							rating = "MR";
						} else if (rb3.isSelected()) {
							rating = "LR";
						}
						String Artist = tx14.getText();
						String Song = tx15.getText();
						

						if (cb1.getValue().equals("Movie")) {
							if(rating.equals("")||Code.equals("")||title.equals("")) {
								throw new Exception();
							}
							m.addMovie(Code, title, Copies, rating);
						} else if (cb1.getValue().equals("Album")) {
							if(Artist.equals("")||Code.equals("")||title.equals("")||Song.equals("")) {
								throw new Exception();
							}
							m.addAlbum(Code, title, Copies, Artist, Song);
						} else if (cb1.getValue().equals("Game")) {
							tx16.setText("0");
							int Weight = Integer.parseInt(tx16.getText());
							if(Weight==0 ||Code.equals("")||title.equals("")) {
								throw new Exception();
							}
							m.addGame(Code, title, Copies, Weight);
						}
						Alert.AlertBox("Alert", "Addition Complete");
						tx7.clear();
						tx8.clear();
						tx9.clear();
						tx14.clear();
						tx15.clear();
						tx16.clear();
						cb1.setPromptText("Media Type");
						vb6.getChildren().remove(hbMovie);
						vb6.getChildren().remove(vbAlbum);
						vb6.getChildren().remove(hbGame);
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter all the information");
				}

			});
			bt21.setOnAction(e -> {
				window.setScene(s6);
				tx7.clear();
				tx8.clear();
				tx9.clear();
				tx14.clear();
				tx15.clear();
				tx16.clear();
				cb1.setPromptText("Media Type");
				vb6.getChildren().remove(hbMovie);
				vb6.getChildren().remove(vbAlbum);
				vb6.getChildren().remove(hbGame);
				window.hide();
				window.setMaximized(true);
				window.show();
			});

			// Delete Media
			BorderPane root11 = new BorderPane();
			Label lb20 = new Label("Media Code:");
			TextField tx20 = new TextField();
			lb20.setPrefSize(140, 70);
			HBox hb28 = new HBox(10);
			hb28.setAlignment(Pos.CENTER);
			hb28.setPadding(new Insets(10, 10, 10, 10));
			hb28.getChildren().addAll(lb20, tx20);
			VBox vb10 = new VBox(20);
			vb10.setAlignment(Pos.CENTER);
			vb10.setPadding(new Insets(10, 10, 10, 10));
			vb10.getChildren().addAll(hb28);
			vb10.setLayoutX(40);
			vb10.setLayoutY(40);
			Button bt30 = new Button("Delete", imv6);
			Button bt31 = new Button("Back", imv5);
			bt30.setPrefSize(180, 90);
			bt31.setPrefSize(180, 90);
			bt30.setOnAction(e -> {

				String Code = tx20.getText();

				if (!(m.checkMedia(Code))) {
					Alert.AlertBox("Worning", "There is no such a media");
				} else if ((m.checkMedia(Code))) {
					m.deleteMedia(Code);
					Alert.AlertBox("Alert", "Deletion Complete");
					tx20.clear();

				}

			});
			bt31.setOnAction(e -> {
				window.setScene(s6);
				tx20.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hb29 = new HBox(200);
			hb29.setAlignment(Pos.CENTER);
			hb29.setPadding(new Insets(10, 10, 10, 10));
			hb29.getChildren().addAll(bt30, bt31);
			root11.setCenter(vb10);
			root11.setBottom(hb29);
			s11 = new Scene(root11);

			// Update info about Media
			BorderPane rootUpdateMeida = new BorderPane();
			Label lbUpdateCode = new Label("Media Code:");
			TextField txUpdateCode = new TextField();
			Label lbUpdateTitle = new Label("Media Title:");
			TextField txUpdateTitle = new TextField();
			Label lbUpdateNumber = new Label("Number Of Copies:");
			TextField txUpdateNumber = new TextField();
			lbUpdateCode.setPrefSize(140, 70);
			lbUpdateTitle.setPrefSize(140, 70);
			lbUpdateNumber.setPrefSize(140, 70);
			ComboBox<String> cbUpdate = new ComboBox<>();
			cbUpdate.getItems().addAll("Movie", "Album", "Game");
			cbUpdate.setPromptText("Media Type");
			cbUpdate.setPrefSize(140, 10);
			HBox hbUpdateMedia1 = new HBox(10);
			hbUpdateMedia1.setAlignment(Pos.CENTER);
			hbUpdateMedia1.setPadding(new Insets(10, 10, 10, 10));
			hbUpdateMedia1.getChildren().addAll(lbUpdateCode, txUpdateCode);
			HBox hbUpdateMedia2 = new HBox(10);
			hbUpdateMedia2.setAlignment(Pos.CENTER);
			hbUpdateMedia2.setPadding(new Insets(10, 10, 10, 10));
			hbUpdateMedia2.getChildren().addAll(lbUpdateTitle, txUpdateTitle);
			HBox hbUpdateMedia3 = new HBox(10);
			hbUpdateMedia3.setAlignment(Pos.CENTER);
			hbUpdateMedia3.setPadding(new Insets(10, 10, 10, 10));
			hbUpdateMedia3.getChildren().addAll(lbUpdateNumber, txUpdateNumber);
			HBox hbUpdatesubmit = new HBox(105);
			hbUpdatesubmit.setAlignment(Pos.CENTER);
			hbUpdatesubmit.setPadding(new Insets(10, 10, 10, 10));
			hbUpdatesubmit.getChildren().addAll(cbUpdate);

			// Movie
			Label lbUpdateRating = new Label("Rating:");
			RadioButton rbUpdate1 = new RadioButton("HR");
			RadioButton rbUpdate2 = new RadioButton("MR");
			RadioButton rbUpdate3 = new RadioButton("LR");
			lbUpdateRating.setPrefSize(140, 70);
			ToggleGroup tgUpdate = new ToggleGroup();
			rbUpdate1.setToggleGroup(tgUpdate);
			rbUpdate2.setToggleGroup(tgUpdate);
			rbUpdate3.setToggleGroup(tgUpdate);
			HBox hbUpdateMovie = new HBox(10);
			hbUpdateMovie.setAlignment(Pos.CENTER);
			hbUpdateMovie.setPadding(new Insets(10, 10, 10, 10));
			hbUpdateMovie.getChildren().addAll(lbUpdateRating, rbUpdate1, rbUpdate2, rbUpdate3);

			// Album
			Label lbUpdateArtist = new Label("Artist");
			TextField txUpdateArtist = new TextField();
			Label lbUpdateSongs = new Label("Songs");
			TextField txUpdateSongs = new TextField();
			lbUpdateArtist.setPrefSize(140, 70);
			lbUpdateSongs.setPrefSize(140, 70);
			HBox hbUpdateAlbum1 = new HBox(10);
			HBox hbUpdateAlbum2 = new HBox(10);
			hbUpdateAlbum1.setAlignment(Pos.CENTER);
			hbUpdateAlbum2.setAlignment(Pos.CENTER);
			hbUpdateAlbum1.setPadding(new Insets(10, 10, 10, 10));
			hbUpdateAlbum2.setPadding(new Insets(10, 10, 10, 10));
			hbUpdateAlbum1.getChildren().addAll(lbUpdateArtist, txUpdateArtist);
			hbUpdateAlbum2.getChildren().addAll(lbUpdateSongs, txUpdateSongs);
			VBox vbUpdateAlbum = new VBox(20);
			vbUpdateAlbum.setAlignment(Pos.CENTER);
			vbUpdateAlbum.setPadding(new Insets(10, 10, 10, 10));
			vbUpdateAlbum.getChildren().addAll(hbUpdateAlbum1, hbUpdateAlbum2);

			// Game
			Label lbUpdateWeight = new Label("Weight:");
			TextField txUpdateWeight = new TextField();
			lbUpdateWeight.setPrefSize(140, 70);
			HBox hbUpdateGame = new HBox(10);
			hbUpdateGame.setAlignment(Pos.CENTER);
			hbUpdateGame.setPadding(new Insets(10, 10, 10, 10));
			hbUpdateGame.getChildren().addAll(lbUpdateWeight, txUpdateWeight);

			VBox vbUpdateMedia = new VBox(10);
			vbUpdateMedia.setAlignment(Pos.CENTER);
			vbUpdateMedia.setPadding(new Insets(10, 10, 10, 10));
			vbUpdateMedia.getChildren().addAll(hbUpdateMedia1);
			Button btUpdate1 = new Button("Update", imv7);
			Button btUpdate2 = new Button("Find", imv8);
			Button btUpdate3 = new Button("Back", imv5);
			btUpdate1.setPrefSize(180, 90);
			btUpdate2.setPrefSize(180, 90);
			btUpdate3.setPrefSize(180, 90);
			HBox hbUpdateButton = new HBox(200);
			hbUpdateButton.setAlignment(Pos.CENTER);
			hbUpdateButton.setPadding(new Insets(10, 10, 10, 10));
			hbUpdateButton.getChildren().addAll(btUpdate1, btUpdate2, btUpdate3);
			rootUpdateMeida.setCenter(vbUpdateMedia);
			rootUpdateMeida.setBottom(hbUpdateButton);
			s9 = new Scene(rootUpdateMeida);

			cbUpdate.setOnAction(e -> {
				if (cbUpdate.getValue().equals("Movie")) {
					vbUpdateMedia.getChildren().add(hbUpdateMovie);
					vbUpdateMedia.getChildren().remove(vbUpdateAlbum);
					vbUpdateMedia.getChildren().remove(hbUpdateGame);
				} else if (cbUpdate.getValue().equals("Album")) {
					vbUpdateMedia.getChildren().remove(hbUpdateMovie);
					vbUpdateMedia.getChildren().add(vbUpdateAlbum);
					vbUpdateMedia.getChildren().remove(hbUpdateGame);
				} else if (cbUpdate.getValue().equals("Game")) {
					vbUpdateMedia.getChildren().remove(hbUpdateMovie);
					vbUpdateMedia.getChildren().remove(vbUpdateAlbum);
					vbUpdateMedia.getChildren().add(hbUpdateGame);
				}
			});
			btUpdate1.setOnAction(e -> {
				try {
					String Code = txUpdateCode.getText();
					String title = txUpdateTitle.getText();
					int Copies = Integer.parseInt(txUpdateNumber.getText());
					String rating = null;
					if (rbUpdate1.isSelected()) {
						rating = "HR";
					} else if (rbUpdate2.isSelected()) {
						rating = "MR";
					} else if (rbUpdate3.isSelected()) {
						rating = "LR";
					}
					String Artist = txUpdateArtist.getText();
					String Song = txUpdateSongs.getText();

					if (cbUpdate.getValue().equals("Movie")) {
						if(rating.equals("")||Code.equals("")||title.equals("")) {
							throw new Exception();
						}
						m.addMovie(Code, title, Copies, rating);
					} else if (cbUpdate.getValue().equals("Album")) {
						if(Artist.equals("")||Code.equals("")||title.equals("")||Song.equals("")) {
							throw new Exception();
						}
						m.addAlbum(Code, title, Copies, Artist, Song);
					} else if (cbUpdate.getValue().equals("Game")) {
						txUpdateWeight.setText("0");
						int Weight = Integer.parseInt(txUpdateWeight.getText());
						if(Weight==0 ||Code.equals("")||title.equals("")) {
							throw new Exception();
						}
						m.addGame(Code, title, Copies, Weight);
					}
					Alert.AlertBox("Alert", "Update Completed");
					txUpdateCode.clear();
					txUpdateTitle.clear();
					txUpdateNumber.clear();
					txUpdateArtist.clear();
					txUpdateSongs.clear();
					txUpdateWeight.clear();
					cbUpdate.setPromptText("Media Type");
					vbUpdateMedia.getChildren().remove(hbUpdateMovie);
					vbUpdateMedia.getChildren().remove(vbUpdateAlbum);
					vbUpdateMedia.getChildren().remove(hbUpdateGame);
				} catch (Exception e1) {
					Alert.AlertBox("Alert", "Please enter all the information in the correct way");
				}

			});

			btUpdate2.setOnAction(e -> {
				String Code = txUpdateCode.getText();
				if (!(m.checkMedia(Code))) {
					Alert.AlertBox("Worning", "There is no such a media");
				} else {
					String[] Split = m.getMediaInfo(Code).split(" ");
					if (Split[0].equals("Movie:-")) {
						vbUpdateMedia.getChildren().addAll(hbUpdateMedia2, hbUpdateMedia3, hbUpdatesubmit,
								hbUpdateMovie);
						txUpdateTitle.setText(Split[4]);
						txUpdateNumber.setText(Split[7]);
						cbUpdate.setPromptText("Movie");
						if (Split[9].equals("HR")) {
							tgUpdate.selectToggle(rbUpdate1);
						} else if (Split[9].equals("MR")) {
							tgUpdate.selectToggle(rbUpdate2);
						} else if (Split[9].equals("LR")) {
							tgUpdate.selectToggle(rbUpdate3);
						}
					} else if (Split[0].equals("Album:-")) {
						vbUpdateMedia.getChildren().addAll(hbUpdateMedia2, hbUpdateMedia3, hbUpdatesubmit,
								vbUpdateAlbum);
						txUpdateTitle.setText(Split[4]);
						txUpdateNumber.setText(Split[7]);
						cbUpdate.setPromptText("Album");
						txUpdateArtist.setText(Split[9]);
						txUpdateSongs.setText(Split[11]);
					} else if (Split[0].equals("Game:-")) {
						vbUpdateMedia.getChildren().addAll(hbUpdateMedia2, hbUpdateMedia3, hbUpdatesubmit,
								hbUpdateGame);
						txUpdateTitle.setText(Split[4]);
						txUpdateNumber.setText(Split[7]);
						cbUpdate.setPromptText("Game");
						txUpdateWeight.setText(Split[9]);
					}
					m.deleteMedia(Code);
				}

			});

			btUpdate3.setOnAction(e -> {
				window.setScene(s6);
				txUpdateCode.clear();
				txUpdateTitle.clear();
				txUpdateNumber.clear();
				txUpdateArtist.clear();
				txUpdateSongs.clear();
				txUpdateWeight.clear();
				cbUpdate.setPromptText("Media Type");
				vbUpdateMedia.getChildren().remove(hbUpdateMovie);
				vbUpdateMedia.getChildren().remove(vbUpdateAlbum);
				vbUpdateMedia.getChildren().remove(hbUpdateGame);
				window.hide();
				window.setMaximized(true);
				window.show();
			});

			// Search Media
			BorderPane rootSearchMeida = new BorderPane();
			Label lbSearchCode = new Label("Media Code:");
			TextField txSearchCode = new TextField();
			Label lbSearchTitle = new Label("Media Title:");
			TextField txSearchTitle = new TextField();
			txSearchTitle.setDisable(true);
			Label lbSearchNumber = new Label("Number Of Copies:");
			TextField txSearchNumber = new TextField();
			txSearchNumber.setDisable(true);
			lbSearchCode.setPrefSize(140, 70);
			lbSearchTitle.setPrefSize(140, 70);
			lbSearchNumber.setPrefSize(140, 70);
			ComboBox<String> cbSearch = new ComboBox<>();
			cbSearch.setDisable(true);
			cbSearch.getItems().addAll("Movie", "Album", "Game");
			cbSearch.setPromptText("Media Type");
			cbSearch.setPrefSize(140, 10);
			HBox hbSearchMedia1 = new HBox(10);
			hbSearchMedia1.setAlignment(Pos.CENTER);
			hbSearchMedia1.setPadding(new Insets(10, 10, 10, 10));
			hbSearchMedia1.getChildren().addAll(lbSearchCode, txSearchCode);
			HBox hbSearchMedia2 = new HBox(10);
			hbSearchMedia2.setAlignment(Pos.CENTER);
			hbSearchMedia2.setPadding(new Insets(10, 10, 10, 10));
			hbSearchMedia2.getChildren().addAll(lbSearchTitle, txSearchTitle);
			HBox hbSearchMedia3 = new HBox(10);
			hbSearchMedia3.setAlignment(Pos.CENTER);
			hbSearchMedia3.setPadding(new Insets(10, 10, 10, 10));
			hbSearchMedia3.getChildren().addAll(lbSearchNumber, txSearchNumber);
			HBox hbSearchsubmit = new HBox(105);
			hbSearchsubmit.setAlignment(Pos.CENTER);
			hbSearchsubmit.setPadding(new Insets(10, 10, 10, 10));
			hbSearchsubmit.getChildren().addAll(cbSearch);

			// Movie
			Label lbSearchRating = new Label("Rating:");
			RadioButton rbSearch1 = new RadioButton("HR");
			RadioButton rbSearch2 = new RadioButton("MR");
			RadioButton rbSearch3 = new RadioButton("LR");
			lbSearchRating.setPrefSize(140, 70);
			ToggleGroup tgSearch = new ToggleGroup();
			rbSearch1.setToggleGroup(tgSearch);
			rbSearch2.setToggleGroup(tgSearch);
			rbSearch3.setToggleGroup(tgSearch);
			rbSearch1.setDisable(true);
			rbSearch2.setDisable(true);
			rbSearch3.setDisable(true);
			HBox hbSearchMovie = new HBox(10);
			hbSearchMovie.setAlignment(Pos.CENTER);
			hbSearchMovie.setPadding(new Insets(10, 10, 10, 10));
			hbSearchMovie.getChildren().addAll(lbSearchRating, rbSearch1, rbSearch2, rbSearch3);

			// Album
			Label lbSearchArtist = new Label("Artist");
			TextField txSearchArtist = new TextField();
			txSearchArtist.setDisable(true);
			Label lbSearchSongs = new Label("Songs");
			TextField txSearchSongs = new TextField();
			txSearchSongs.setDisable(true);
			lbSearchArtist.setPrefSize(140, 70);
			lbSearchSongs.setPrefSize(140, 70);
			HBox hbSearchAlbum1 = new HBox(10);
			HBox hbSearchAlbum2 = new HBox(10);
			hbSearchAlbum1.setAlignment(Pos.CENTER);
			hbSearchAlbum2.setAlignment(Pos.CENTER);
			hbSearchAlbum1.setPadding(new Insets(10, 10, 10, 10));
			hbSearchAlbum2.setPadding(new Insets(10, 10, 10, 10));
			hbSearchAlbum1.getChildren().addAll(lbSearchArtist, txSearchArtist);
			hbSearchAlbum2.getChildren().addAll(lbSearchSongs, txSearchSongs);
			VBox vbSearchAlbum = new VBox(20);
			vbSearchAlbum.setAlignment(Pos.CENTER);
			vbSearchAlbum.setPadding(new Insets(10, 10, 10, 10));
			vbSearchAlbum.getChildren().addAll(hbSearchAlbum1, hbSearchAlbum2);

			// Game
			Label lbSearchWeight = new Label("Weight:");
			TextField txSearchWeight = new TextField();
			txSearchWeight.setDisable(true);
			lbSearchWeight.setPrefSize(140, 70);
			HBox hbSearchGame = new HBox(10);
			hbSearchGame.setAlignment(Pos.CENTER);
			hbSearchGame.setPadding(new Insets(10, 10, 10, 10));
			hbSearchGame.getChildren().addAll(lbSearchWeight, txSearchWeight);

			VBox vbSearchMedia = new VBox(10);
			vbSearchMedia.setAlignment(Pos.CENTER);
			vbSearchMedia.setPadding(new Insets(10, 10, 10, 10));
			vbSearchMedia.getChildren().addAll(hbSearchMedia1);
			Button btSearch2 = new Button("Find", imv8);
			Button btSearch3 = new Button("Back", imv5);
			btSearch2.setPrefSize(180, 90);
			btSearch3.setPrefSize(180, 90);
			HBox hbSearchButton = new HBox(200);
			hbSearchButton.setAlignment(Pos.CENTER);
			hbSearchButton.setPadding(new Insets(10, 10, 10, 10));
			hbSearchButton.getChildren().addAll(btSearch2, btSearch3);
			rootSearchMeida.setCenter(vbSearchMedia);
			rootSearchMeida.setBottom(hbSearchButton);
			s12 = new Scene(rootSearchMeida);



			btSearch2.setOnAction(e -> {
				txSearchCode.setDisable(true);
				String Code = txSearchCode.getText();
				if (!(m.checkMedia(Code))) {
					Alert.AlertBox("Worning", "There is no such a media");
				} else {
					txSearchCode.setDisable(true);
					String[] Split = m.getMediaInfo(Code).split(" ");
					if (Split[0].equals("Movie:-")) {
						vbSearchMedia.getChildren().addAll(hbSearchMedia2, hbSearchMedia3, hbSearchsubmit,
								hbSearchMovie);
						txSearchTitle.setText(Split[4]);
						txSearchNumber.setText(Split[7]);
						cbSearch.setPromptText("Movie");
						if (Split[9].equals("HR")) {
							tgSearch.selectToggle(rbSearch1);
						} else if (Split[9].equals("MR")) {
							tgSearch.selectToggle(rbSearch2);
						} else if (Split[9].equals("LR")) {
							tgSearch.selectToggle(rbSearch3);
						}
					} else if (Split[0].equals("Album:-")) {
						vbSearchMedia.getChildren().addAll(hbSearchMedia2, hbSearchMedia3, hbSearchsubmit,
								vbSearchAlbum);
						txSearchTitle.setText(Split[4]);
						txSearchNumber.setText(Split[7]);
						cbSearch.setPromptText("Album");
						txSearchArtist.setText(Split[9]);
						txSearchSongs.setText(Split[11]);
					} else if (Split[0].equals("Game:-")) {
						vbSearchMedia.getChildren().addAll(hbSearchMedia2, hbSearchMedia3, hbSearchsubmit,
								hbSearchGame);
						txSearchTitle.setText(Split[4]);
						txSearchNumber.setText(Split[7]);
						cbSearch.setPromptText("Game");
						txSearchWeight.setText(Split[9]);
					}
				}

			});

			btSearch3.setOnAction(e -> {
				window.setScene(s6);
				txSearchCode.clear();
				txSearchTitle.clear();
				txSearchNumber.clear();
				txSearchArtist.clear();
				txSearchSongs.clear();
				txSearchWeight.clear();
				cbSearch.setPromptText("Media Type");
				vbSearchMedia.getChildren().remove(hbSearchMovie);
				vbSearchMedia.getChildren().remove(vbSearchAlbum);
				vbSearchMedia.getChildren().remove(hbSearchGame);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			
			
			//Print All Medai
			BorderPane rootPrint = new BorderPane();
			TextArea taPrintAll = new TextArea();
			taPrintAll.setPrefSize(500, 500);
			VBox vbPrintAll = new VBox(20);
			vbPrintAll.setAlignment(Pos.CENTER);
			vbPrintAll.setPadding(new Insets(10, 10, 10, 10));
			vbPrintAll.getChildren().addAll(taPrintAll);
			vbPrintAll.setLayoutX(40);
			vbPrintAll.setLayoutY(40);
			Button btPrintAllMedia = new Button("Print", imv9);
			Button btBackAll = new Button("Back", imv5);
			btPrintAllMedia.setPrefSize(180, 90);
			btBackAll.setPrefSize(180, 90);
			btPrintAllMedia.setOnAction(e -> {
				taPrintAll.setText(m.getAllMediaInfo());
			});
			btBackAll.setOnAction(e -> {
				window.setScene(s6);
				taPrintAll.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hbPrintAll = new HBox(200);
			hbPrintAll.setAlignment(Pos.CENTER);
			hbPrintAll.setPadding(new Insets(10, 10, 10, 10));
			hbPrintAll.getChildren().addAll(btPrintAllMedia, btBackAll);
			rootPrint.setCenter(vbPrintAll);
			rootPrint.setBottom(hbPrintAll);
			s10 = new Scene(rootPrint);
			
			// Rent Media
			BorderPane root13 = new BorderPane();
			Label lb22 = new Label("Customer Id");
			TextField tx22 = new TextField();
			TextArea ta1 = new TextArea();
			Label lb23 = new Label("Media Code");
			TextField tx23 = new TextField();
			TextArea ta2 = new TextArea();
			lb22.setPrefSize(140, 70);
			lb23.setPrefSize(140, 70);
			ta1.setPrefSize(500, 500);
			ta2.setPrefSize(500, 500);
			HBox hb32 = new HBox(10);
			hb32.setAlignment(Pos.CENTER);
			hb32.setPadding(new Insets(10, 10, 10, 10));
			hb32.getChildren().addAll(lb22, tx22);
			HBox hb33 = new HBox(10);
			hb33.setAlignment(Pos.CENTER);
			hb33.setPadding(new Insets(10, 10, 10, 10));
			hb33.getChildren().addAll(lb23, tx23);
			VBox vb12 = new VBox(10);
			vb12.setAlignment(Pos.CENTER);
			vb12.setPadding(new Insets(10, 10, 10, 10));
			vb12.getChildren().addAll(hb32, ta1);
			VBox vb13 = new VBox(10);
			vb13.setAlignment(Pos.CENTER);
			vb13.setPadding(new Insets(10, 10, 10, 10));
			vb13.getChildren().addAll(hb33, ta2);
			Label lb24 = new Label("Rent Date");
			TextField tx24 = new TextField();
			lb24.setPrefSize(140, 70);
			HBox hb34 = new HBox(10);
			hb34.setAlignment(Pos.CENTER);
			hb34.setPadding(new Insets(10, 10, 10, 10));
			hb34.getChildren().addAll(lb24, tx24);

			

			Button btAdd = new Button("Add To Cart", imv4);
			Button btProsses = new Button("Prosses", imv7);
			Button btPrintForm = new Button("Print Rent Form", imv9);
			Button btBack = new Button("Back", imv5);
			btAdd.setPrefSize(240, 60);
			btProsses.setPrefSize(240, 60);
			btPrintForm.setPrefSize(240, 60);
			btBack.setPrefSize(240, 60);

			Date date = new Date();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");

			btAdd.setOnAction(e -> {
				try {
					if (!(m.checkCustomer(Integer.parseInt(tx22.getText()))) && !(m.checkMedia(tx23.getText()))) {
						Alert.AlertBox("Worning", "There no such customer or media");
					} else {
						m.addToCart(Integer.parseInt(tx22.getText()), tx23.getText());
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter ID and Code correctly");
				}
			});
			btProsses.setOnAction(e -> {
				Alert.AlertBox("Alert", m.processRequests());
			});
			btPrintForm.setOnAction(e -> {
				try {
					if (!(m.checkCustomer(Integer.parseInt(tx22.getText()))) && !(m.checkMedia(tx23.getText()))) {
						Alert.AlertBox("Worning", "There no such customer or media");
					} else {
						ta1.setText(m.getCustomerInfo(Integer.parseInt(tx22.getText())));
						ta2.setText(m.getMediaInfo(tx23.getText()));
						tx24.setText(DateFormat.format(date));
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "There is no informatin to print");
				}

			});
			btBack.setOnAction(e -> {
				tx22.clear();
				tx23.clear();
				ta1.clear();
				ta2.clear();
				window.setScene(s14);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hb35 = new HBox(200);
			hb35.setAlignment(Pos.CENTER);
			hb35.setPadding(new Insets(10, 10, 10, 10));
			hb35.getChildren().addAll(btAdd, btProsses, btPrintForm, btBack);
			VBox vb14 = new VBox(10);
			vb14.setAlignment(Pos.CENTER);
			vb14.setPadding(new Insets(10, 10, 10, 10));
			vb14.getChildren().addAll(vb12, vb13, hb34);
			root13.setCenter(vb14);
			root13.setBottom(hb35);
			s13 = new Scene(root13);

			//Rent Options
			BorderPane root14 = new BorderPane();
			Button btPrintIntrestedMedia = new Button("Intrested Media");
			Button btPrintRentedMedia = new Button("Rented Media");
			Button btReturn = new Button("Return Media");
			Button btRentMedia = new Button("Rent Media");
			Button btRentalBack = new Button("Returt to main Page");
			btPrintIntrestedMedia.setPrefSize(180, 90);
			btPrintRentedMedia.setPrefSize(180, 90);
			btReturn.setPrefSize(180, 90);
			btRentMedia.setPrefSize(180, 90);
			btRentalBack.setPrefSize(180, 90);
			VBox vbRental = new VBox(60);
			vbRental.setAlignment(Pos.CENTER);
			vbRental.setPadding(new Insets(10, 10, 10, 10));
			vbRental.getChildren().addAll(btPrintIntrestedMedia, btPrintRentedMedia, btReturn, btRentMedia,
					btRentalBack);
			btPrintIntrestedMedia.setOnAction(e -> {
				window.setScene(s15);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			btPrintRentedMedia.setOnAction(e -> {
				window.setScene(s16);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			btReturn.setOnAction(e -> {
				window.setScene(s17);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			btRentMedia.setOnAction(e -> {
				window.setScene(s13);
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			btRentalBack.setOnAction(e -> {
				window.setScene(s1);
				window.hide();
				window.setMaximized(true);
				window.show();
			});

			root14.setCenter(vbRental);
			s14 = new Scene(root14);

			//Interested
			BorderPane root15 = new BorderPane();
			Label lbIntrestedID = new Label("Customer ID");
			TextField txIntrestedID = new TextField();
			lbIntrestedID.setPrefSize(140, 70);
			HBox hbIntrested = new HBox(10);
			TextArea taIntrested = new TextArea();
			taIntrested.setPrefSize(500, 500);
			hbIntrested.setAlignment(Pos.CENTER);
			hbIntrested.setPadding(new Insets(10, 10, 10, 10));
			hbIntrested.getChildren().addAll(lbIntrestedID, txIntrestedID);
			VBox vbIntrested = new VBox(20);
			vbIntrested.setAlignment(Pos.CENTER);
			vbIntrested.setPadding(new Insets(10, 10, 10, 10));
			vbIntrested.getChildren().addAll(hbIntrested, taIntrested);
			vbIntrested.setLayoutX(40);
			vbIntrested.setLayoutY(40);
			Button btPrintIntrested = new Button("Print", imv9);
			Button btBackIntrested = new Button("Back", imv5);
			btPrintIntrested.setPrefSize(180, 90);
			btBackIntrested.setPrefSize(180, 90);
			btPrintIntrested.setOnAction(e -> {
				try {
					if (!(m.chechIntrested(Long.parseLong(txIntrestedID.getText())))) {
						Alert.AlertBox("Worning", "There no Interested media");
					}

					else {
						long Id = Long.parseLong(txIntrestedID.getText());
						taIntrested.setText(m.getIntrested(Id));
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter the ID");
				}
			});
			btBackIntrested.setOnAction(e -> {
				window.setScene(s14);
				taIntrested.clear();
				txIntrestedID.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hbIntrested2 = new HBox(200);
			hbIntrested2.setAlignment(Pos.CENTER);
			hbIntrested2.setPadding(new Insets(10, 10, 10, 10));
			hbIntrested2.getChildren().addAll(btPrintIntrested, btBackIntrested);
			root15.setCenter(vbIntrested);
			root15.setBottom(hbIntrested2);
			s15 = new Scene(root15);

			//Rented
			BorderPane root16 = new BorderPane();
			Label lbRentedID = new Label("Customer ID");
			TextField txRentedID = new TextField();
			lbRentedID.setPrefSize(140, 70);
			HBox hbRented = new HBox(10);
			TextArea taRentedID = new TextArea();
			taRentedID.setPrefSize(500, 500);
			hbRented.setAlignment(Pos.CENTER);
			hbRented.setPadding(new Insets(10, 10, 10, 10));
			hbRented.getChildren().addAll(lbRentedID, txRentedID);
			VBox vbRented = new VBox(20);
			vbRented.setAlignment(Pos.CENTER);
			vbRented.setPadding(new Insets(10, 10, 10, 10));
			vbRented.getChildren().addAll(hbRented, taRentedID);
			vbRented.setLayoutX(40);
			vbRented.setLayoutY(40);
			Button btPrintRented = new Button("Print", imv9);
			Button btBackRented = new Button("Back", imv5);
			btPrintRented.setPrefSize(180, 90);
			btBackRented.setPrefSize(180, 90);
			btPrintRented.setOnAction(e -> {
				try {
					if (!(m.chechRented(Long.parseLong(txRentedID.getText())))) {
						Alert.AlertBox("Worning", "There no Rented media");
					}

					else {
						long Id = Long.parseLong(txRentedID.getText());
						taRentedID.setText(m.getRented(Id));
					}
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter the ID");
				}
			});
			btBackRented.setOnAction(e -> {
				window.setScene(s14);
				taRentedID.clear();
				txRentedID.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hbRented2 = new HBox(200);
			hbRented2.setAlignment(Pos.CENTER);
			hbRented2.setPadding(new Insets(10, 10, 10, 10));
			hbRented2.getChildren().addAll(btPrintRented, btBackRented);
			root16.setCenter(vbRented);
			root16.setBottom(hbRented2);
			s16 = new Scene(root16);
			
			//Form
			BorderPane root17 = new BorderPane();
			Label lbReturnID = new Label("Customer ID");
			TextField txReturnID = new TextField();
			Label lbReturnCode = new Label("Media Code");
			TextField txReturnCode = new TextField();
			lbReturnID.setPrefSize(140, 70);
			lbReturnCode.setPrefSize(140, 70);
			HBox hbReturn1 = new HBox(10);
			hbReturn1.setAlignment(Pos.CENTER);
			hbReturn1.setPadding(new Insets(10, 10, 10, 10));
			hbReturn1.getChildren().addAll(lbReturnID, txReturnID);
			HBox hbReturn2 = new HBox(10);
			hbReturn2.setAlignment(Pos.CENTER);
			hbReturn2.setPadding(new Insets(10, 10, 10, 10));
			hbReturn2.getChildren().addAll(lbReturnCode, txReturnCode);
			VBox vbRerurn = new VBox(20);
			vbRerurn.setAlignment(Pos.CENTER);
			vbRerurn.setPadding(new Insets(10, 10, 10, 10));
			vbRerurn.getChildren().addAll(hbReturn1, hbReturn2);
			vbRerurn.setLayoutX(40);
			vbRerurn.setLayoutY(40);
			Image icon10 = new Image("return.png");
			ImageView imv10 = new ImageView(icon10);
			imv10.setFitHeight(70);
			imv10.setFitWidth(100);
			Button btReturnMedai = new Button("Return", imv10);
			Button btBackReturn = new Button("Back", imv5);
			btReturnMedai.setPrefSize(180, 90);
			btBackReturn.setPrefSize(180, 90);
			btReturnMedai.setOnAction(e -> {
				try {
					Long Id = Long.parseLong(txReturnID.getText());
					String Code = txReturnCode.getText();
					if (m.returnMedia(Id, Code)) {
						Alert.AlertBox("Alert", "Return Complete");
					} else
						Alert.AlertBox("Alert", "Their is not Such Media or Customer");
				} catch (Exception e1) {
					Alert.AlertBox("Worning", "Please enter ID and Code correctly");
				}
			});
			btBackReturn.setOnAction(e -> {
				window.setScene(s14);
				txReturnID.clear();
				window.hide();
				window.setMaximized(true);
				window.show();
			});
			HBox hbRented3 = new HBox(200);
			hbRented3.setAlignment(Pos.CENTER);
			hbRented3.setPadding(new Insets(10, 10, 10, 10));
			hbRented3.getChildren().addAll(btReturnMedai, btBackReturn);
			root17.setCenter(vbRerurn);
			root17.setBottom(hbRented3);
			s17 = new Scene(root17);

			window.setOnCloseRequest(e -> {
				PrintWriter writer1;
				try {
					writer1 = new PrintWriter("/Users/hp/Desktop/Project/Customer.txt");
					PrintWriter writer2 = new PrintWriter("/Users/hp/Desktop/Project/Media.txt");
					writer1.print(m.getAllCustomersInfo());
					writer2.print(m.getAllMediaInfo());
					writer1.close();
					writer2.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			});

			window.setScene(s1);
			window.setTitle("Title");
			window.setMaximized(true);
			window.show();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
