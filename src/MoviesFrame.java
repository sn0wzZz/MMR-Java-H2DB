import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class MoviesFrame extends JFrame {
	
	Connection conn=null;
	PreparedStatement state=null;
	ResultSet result=null;
	int id=-1;
	int idyear=-1;
	int idrating=-1;

	JTabbedPane tab=new JTabbedPane();

	JPanel moviePanel=new JPanel();
	
	JPanel moviePanel1=new JPanel();
	JPanel moviePanel2=new JPanel();
	JPanel moviePanel3=new JPanel();
		
	JLabel movieTitleL=new JLabel("Title:");
	JLabel movieRatingL=new JLabel("Rating:");
	JLabel movieYearL=new JLabel("Year:");
	JLabel movieDurationL=new JLabel("Duration:");
	JLabel movieDirectorL=new JLabel("Director:");
	JLabel movieStarringL=new JLabel("Starring:");
	JLabel movieStudiosL=new JLabel("Studio:");
	
	private static final long serialVersionUID = 4L;
	
	JTextField movieTitleTF=new JTextField();
	JTextField movieYearTF=new JTextField();
	JTextField movieRatingTF=new JTextField();
	JTextField movieDurationTF=new JTextField();
	JTextField movieDirectorTF=new JTextField();
	JTextField movieStarringTF=new JTextField();
	JTextField movieStudiosTF=new JTextField();
	
	JComboBox<String> comboYear=new JComboBox<String>();
	JComboBox<String> comboRating=new JComboBox<String>();
	
	JButton BAdd=new JButton("Add");
	JButton BDel=new JButton("Delete");
	JButton BEdit=new JButton("Edit");
	
	JTable moviesTable=new JTable();
	JScrollPane moviesScroll=new JScrollPane(moviesTable);
	

	JLabel ratingL=new JLabel("Rating:");
	JTextField ratingTF=new JTextField();

	JPanel ratingPanel=new JPanel();
	JPanel ratingPanel1=new JPanel();
	JPanel ratingPanel2=new JPanel();
	JPanel ratingPanel3=new JPanel();

	JButton ratingAdd=new JButton("Add");
	JButton ratingDel=new JButton("Delete");
	JButton ratingEdit=new JButton("Edit");
	
	JTable ratingTable=new JTable();
	JScrollPane ratingScroll=new JScrollPane(ratingTable);

	JLabel yearL=new JLabel("Year:");
	JTextField yearTF=new JTextField();

	JPanel yearPanel=new JPanel();
	JPanel yearPanel1=new JPanel();
	JPanel yearPanel2=new JPanel();
	JPanel yearPanel3=new JPanel();

	JButton yearAdd=new JButton("Add");
	JButton yearDel=new JButton("Delete");
	JButton yearEdit=new JButton("Edit");
	
	JTable yearTable=new JTable();
	JScrollPane yearScroll=new JScrollPane(yearTable);
	JLabel checkMovieDSL=new JLabel("Check for a movie's duration (short≈60, average≈130, long≈180) or rating(1-10):");
	JTextField checkMovieDSTF=new JTextField();

	JPanel checkPanel=new JPanel();
	JPanel checkPanel1=new JPanel();
	JPanel checkPanel2=new JPanel();
	JPanel checkPanel3=new JPanel();

	JButton checkSearch=new JButton("Check");
	
	JTable checkTable=new JTable();
	JScrollPane checkScroll=new JScrollPane(checkTable);

	public MoviesFrame() {
		
		conn=DBConnection.getConnection();

		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("MyMovieRecommendations");
		this.setResizable(false);
		
		tab.add(moviePanel,"Recommendations");
		moviePanel.setLayout(new GridLayout(3,1));
		moviePanel.add(moviePanel1);

		moviePanel1.add(movieTitleL);moviePanel1.add(movieTitleTF);
		moviePanel1.add(movieYearL);moviePanel1.add(comboYear);
		moviePanel1.add(movieRatingL);moviePanel1.add(comboRating);
		moviePanel1.add(movieDirectorL);moviePanel1.add(movieDurationTF);
		moviePanel1.add(movieDurationL);moviePanel1.add(movieDirectorTF);
		moviePanel1.add(movieStarringL);moviePanel1.add(movieStarringTF);
		moviePanel1.add(movieStudiosL);moviePanel1.add(movieStudiosTF);

		movieTitleTF.setPreferredSize(new Dimension(800,30));
		comboYear.setPreferredSize(new Dimension(345,30));
		comboRating.setPreferredSize(new Dimension(345,30));
		movieDurationTF.setPreferredSize(new Dimension(345,30));
		movieDirectorTF.setPreferredSize(new Dimension(345,30));
		movieStarringTF.setPreferredSize(new Dimension(800,30));
		movieStudiosTF.setPreferredSize(new Dimension(800,30));
		movieTitleL.setPreferredSize(new Dimension(100,30));
		movieYearL.setPreferredSize(new Dimension(100,30));
		movieRatingL.setPreferredSize(new Dimension(100,30));
		movieDurationL.setPreferredSize(new Dimension(100,30));
		movieDirectorL.setPreferredSize(new Dimension(100,30));
		movieStarringL.setPreferredSize(new Dimension(100,30));
		movieStudiosL.setPreferredSize(new Dimension(100,30));
		
		
		moviePanel.add(moviePanel2);
		moviePanel2.add(BAdd);moviePanel2.add(BDel);moviePanel2.add(BEdit);
		
		BAdd.addActionListener(new AddMovieDB());
		BDel.addActionListener(new DelMovieDB());
		BEdit.addActionListener(new EditMovieDB());
		
		moviePanel.add(moviePanel3);
		moviesScroll.setPreferredSize(new Dimension(950, 200));
		moviePanel3.add(moviesScroll);
		
	
		tab.add(yearPanel,"Year");
		yearPanel.setLayout(new GridLayout(3,1));
		yearPanel.add(yearPanel1);

		yearPanel1.add(yearL);yearPanel1.add(yearTF);
		yearTF.setPreferredSize(new Dimension(50,30));

		yearPanel.add(yearPanel2);
		yearPanel2.add(yearAdd);yearPanel2.add(yearDel);yearPanel2.add(yearEdit);
		
		yearAdd.addActionListener(new AddYearDB());
		yearDel.addActionListener(new DelYearDB());
		yearEdit.addActionListener(new EditYearDB());
		
		yearPanel.add(yearPanel3);
		yearScroll.setPreferredSize(new Dimension(200, 200));
		yearPanel3.add(yearScroll);
		
		tab.add(ratingPanel,"Rating");
		ratingPanel.setLayout(new GridLayout(3,1));
		ratingPanel.add(ratingPanel1);

		ratingPanel1.add(ratingL);ratingPanel1.add(ratingTF);
		ratingTF.setPreferredSize(new Dimension(50,30));

		ratingPanel.add(ratingPanel2);
		ratingPanel2.add(ratingAdd);ratingPanel2.add(ratingDel);ratingPanel2.add(ratingEdit);
		
		ratingAdd.addActionListener(new AddRatingDB());
		ratingDel.addActionListener(new DelRaingDB());
		ratingEdit.addActionListener(new EditRatingDB());
		
		ratingPanel.add(ratingPanel3);
		ratingScroll.setPreferredSize(new Dimension(200, 700));
		ratingPanel3.add(ratingScroll);
		
		tab.add(checkPanel,"Check");
		checkPanel.setLayout(new GridLayout(3,1));
		checkPanel.add(checkPanel1);

		checkPanel1.add(checkMovieDSL);checkPanel1.add(checkMovieDSTF);
		checkMovieDSTF.setPreferredSize(new Dimension(30,30));

		checkPanel.add(checkPanel2);
		checkPanel2.add(checkSearch);
		
		checkSearch.addActionListener(new SearchDB());
		
		checkPanel.add(checkPanel3);
		checkScroll.setPreferredSize(new Dimension(950, 200));
		checkPanel3.add(checkScroll);

		this.add(tab);
		this.setVisible(true);
		this.refreshArtTable(); // âàðèàíò áåç ïàðàìåòðè
		this.refreshComboYear();
		this.refreshComboRating();
		this.refreshYearTable("YEARTABLE", yearTable); // âàðèàíò ñ ïàðàìåòðè
		this.refreshRatingTable("RATINGTABLE", ratingTable); // âàðèàíò ñ ïàðàìåòðè
		
		moviesTable.addMouseListener(new MouseActionTable());
		yearTable.addMouseListener(new MouseActionYearTable());
		ratingTable.addMouseListener(new MouseActionRtingTable());
		
		comboYear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tab.getSelectedIndex()==0 && idyear>0) {
					String str="select * from yeartable where myear='"+comboYear.getSelectedItem().toString()+"'";
					try {
						state=conn.prepareStatement(str);
						result=state.executeQuery();
						result.next();
						idyear=Integer.parseInt(result.getObject(1).toString());
					} catch (SQLException e1) {
					e1.printStackTrace();
					}

					System.out.println(comboYear.getSelectedItem().toString());
					System.out.println(str);
					System.out.println(idyear);
				}
			}
		});

		comboRating.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tab.getSelectedIndex()==0 && idrating>0) {
					
					String str="select * from ratingtable where mrating='"+comboRating.getSelectedItem().toString()+"'";
					try {
						state=conn.prepareStatement(str);
						result=state.executeQuery();
						result.next();
						idrating=Integer.parseInt(result.getObject(1).toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					System.out.println(comboRating.getSelectedItem().toString());
					System.out.println(str);
					System.out.println(idrating);
				}

			}
		});

	}
	public void refreshArtTable() {
		String str="";
		str="select ARTTABLE.ID,title, YEARTABLE.MYEAR,ARTTABLE.idyear, RATINGTABLE.mrating,ARTTABLE.idrating, director, duration,starring,studios from ARTTABLE,RATINGTABLE,YEARTABLE where ARTTABLE.idrating=RATINGTABLE.id and ARTTABLE.idyear=YEARTABLE.id";
		try {
			state=conn.prepareStatement(str);
			result=state.executeQuery();
			moviesTable.setModel(new TableModel(result));
			
			moviesTable.getColumnModel().getColumn(0).setMinWidth(0);
			moviesTable.getColumnModel().getColumn(0).setMaxWidth(0);
			moviesTable.getColumnModel().getColumn(0).setWidth(0);

			moviesTable.getColumnModel().getColumn(3).setMinWidth(0);
			moviesTable.getColumnModel().getColumn(3).setMaxWidth(0);
			moviesTable.getColumnModel().getColumn(3).setWidth(0);

			moviesTable.getColumnModel().getColumn(5).setMinWidth(0);
			moviesTable.getColumnModel().getColumn(5).setMaxWidth(0);
			moviesTable.getColumnModel().getColumn(5).setWidth(0);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void refreshYearTable(String name, JTable table) {
		String str="select myear from "+name;
		try {
			state=conn.prepareStatement(str);
			result=state.executeQuery();
			table.setModel(new TableModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void refreshRatingTable(String name, JTable table) {
		String str="select mrating from "+name;
		try {
			state=conn.prepareStatement(str);
			result=state.executeQuery();
			table.setModel(new TableModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void refreshComboYear() {
		
		idyear=-1;
		comboYear.removeAllItems();
		
		String sql="select id, myear from yeartable";
		String item="";
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			if(result.next()) {
				idyear=Integer.parseInt(result.getObject(1).toString());
				do{
					item=result.getObject(2).toString();
					comboYear.addItem(item);
				}while(result.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void refreshComboRating() {
		
		idrating=-1;

		comboRating.removeAllItems();
		
		String sql="select id, mrating from ratingtable";
		String item="";
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			if(result.next()) {
				idrating=Integer.parseInt(result.getObject(1).toString());
				do {
					item=result.getObject(2).toString();
					comboRating.addItem(item);
				}while(result.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	class AddMovieDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if(!movieTitleTF.getText().isEmpty()) {
				String sql="insert into arttable values(null,?,?,?,?,?,?,?)";
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, movieTitleTF.getText());
					state.setInt(2, idyear);
					state.setInt(3, idrating);
					state.setString(4, movieDurationTF.getText());
					state.setString(5, movieDirectorTF.getText());
					state.setString(6, movieStarringTF.getText());
					state.setString(7, movieStudiosTF.getText());
					state.execute();
					refreshArtTable();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				movieTitleTF.setText("");
				movieDirectorTF.setText("");
				movieDurationTF.setText("");
				movieStudiosTF.setText("");
				movieStarringTF.setText("");
				id=-1;
			}
		}
	}
	class DelMovieDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if (id>0) {
				String sql="delete from arttable where id=?";
				try {
					state=conn.prepareStatement(sql);
					state.setInt(1, id);
					state.execute();
					refreshArtTable();
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				movieTitleTF.setText("");
				movieDirectorTF.setText("");
				movieDurationTF.setText("");
				movieStudiosTF.setText("");
				movieStarringTF.setText("");
				id=-1;
			}
		}
	}
	class EditMovieDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if(id>0) {
				String sql="update arttable set title=?, idyear=?, idrating=?, director=?, duration=?, starring=?, studios=? where id=?";
			
				try {
					state=conn.prepareStatement(sql);
					
					state.setString(1, movieTitleTF.getText());
					state.setInt(2, idyear);
					state.setInt(3, idrating);
					state.setString(5, movieDirectorTF.getText());
					state.setString(4, movieDurationTF.getText());
					state.setString(6, movieStarringTF.getText());
					state.setString(7, movieStudiosTF.getText());
					state.setInt(8, id);
					state.execute();
					
					refreshArtTable();
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				movieTitleTF.setText("");
				movieDurationTF.setText("");
				movieStudiosTF.setText("");
				movieDirectorTF.setText("");
				movieStarringTF.setText("");
			}
			
		}
	}
	class AddYearDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if(!yearTF.getText().isEmpty()) {
				String sql="insert into yeartable values(null,?)";
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, yearTF.getText());
					state.execute();
					
					refreshYearTable("YEARTABLE", yearTable);
					refreshComboYear();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				yearTF.setText("");
			}
		}
	}
	class DelYearDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if (idyear>0) {
				String sql="delete from yeartable where id=?";
				try {
					state=conn.prepareStatement(sql);
					state.setInt(1, idyear);
					state.execute();
					refreshYearTable("YEARTABLE", yearTable);
					refreshComboYear();
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				yearTF.setText("");
			}
		}
	}
	class EditYearDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if(idyear>0) {
				String sql="update yeartable set myear=? where id=?";
			
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, yearTF.getText());
					state.setInt(2, idyear);
					state.execute();
					refreshYearTable("YEARTABLE", yearTable);
					refreshComboYear();
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				yearTF.setText("");
			}
			
		}
	}
	class AddRatingDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if(!ratingTF.getText().isEmpty()) {
				String sql="insert into ratingtable values(null,?)";
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, ratingTF.getText());
					state.execute();
					refreshRatingTable("RATINGTABLE", ratingTable);
					refreshComboRating();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				ratingTF.setText("");
			}
		}
	}
	class DelRaingDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if (idrating>0) {
				String sql="delete from ratingtable where id=?";
				try {
					state=conn.prepareStatement(sql);
					state.setInt(1, idrating);
					state.execute();
					refreshRatingTable("RATINGTABLE", ratingTable);
					refreshComboRating();
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				ratingTF.setText("");
			}
		}
	}
	class EditRatingDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if(idrating>0) {
				String sql="update ratingtable set mrating=? where id=?";
			
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, ratingTF.getText());
					state.setInt(2, idrating);
					state.execute();
					refreshRatingTable("RATINGTABLE", ratingTable);
					refreshComboRating();
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				ratingTF.setText("");
			}
			
		}
	}
	class MouseActionTable implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			int row=moviesTable.getSelectedRow();
			
			id=Integer.parseInt(moviesTable.getValueAt(row, 0).toString());
			
			movieTitleTF.setText(moviesTable.getValueAt(row, 1).toString());
			movieDirectorTF.setText(moviesTable.getValueAt(row, 7).toString());
			movieDurationTF.setText(moviesTable.getValueAt(row, 6).toString());
			movieStarringTF.setText(moviesTable.getValueAt(row, 8).toString());
			movieStudiosTF.setText(moviesTable.getValueAt(row, 9).toString());
			
			comboYear.setSelectedItem(moviesTable.getValueAt(row, 2).toString());
			idyear=Integer.parseInt(moviesTable.getValueAt(row, 3).toString());
			
			comboRating.setSelectedItem(moviesTable.getValueAt(row, 4).toString());
			idrating=Integer.parseInt(moviesTable.getValueAt(row, 5).toString());
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	class MouseActionYearTable implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row=yearTable.getSelectedRow();
			idyear=Integer.parseInt(yearTable.getValueAt(row, 0).toString());
			
			yearTF.setText(yearTable.getValueAt(row, 1).toString());
		
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	class MouseActionRtingTable implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row=ratingTable.getSelectedRow();
			idrating=Integer.parseInt(ratingTable.getValueAt(row, 0).toString());
			
			ratingTF.setText(ratingTable.getValueAt(row, 1).toString());
		
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
	class SearchDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
			if(!checkMovieDSTF.getText().isEmpty()) {
				if(Integer.parseInt(checkMovieDSTF.getText())>0) {
					String str="select title, YEARTABLE.myear,ARTTABLE.idyear, RATINGTABLE.mrating,ARTTABLE.idrating, director, duration,starring,studios from ARTTABLE,RATINGTABLE,YEARTABLE where ARTTABLE.idrating=RATINGTABLE.id and ARTTABLE.idyear=YEARTABLE.id and ARTTABLE.duration="+Integer.parseInt(checkMovieDSTF.getText())+" OR ARTTABLE.idrating=RATINGTABLE.id and ARTTABLE.idyear=YEARTABLE.id and RATINGTABLE.mrating="+Integer.parseInt(checkMovieDSTF.getText());
					try {
						state=conn.prepareStatement(str);
						result=state.executeQuery();
						checkTable.setModel(new TableModel(result));
						
//						moviesTable.getColumnModel().getColumn(1).setMinWidth(0);
//						moviesTable.getColumnModel().getColumn(1).setMaxWidth(0);
//						moviesTable.getColumnModel().getColumn(1).setWidth(0);

				
						checkTable.getColumnModel().getColumn(2).setMinWidth(0);
						checkTable.getColumnModel().getColumn(2).setMaxWidth(0);
						checkTable.getColumnModel().getColumn(2).setWidth(0);

						checkTable.getColumnModel().getColumn(4).setMinWidth(0);
						checkTable.getColumnModel().getColumn(4).setMaxWidth(0);
						checkTable.getColumnModel().getColumn(4).setWidth(0);
						
						checkTable.getColumnModel().getColumn(1).setMinWidth(50);
						checkTable.getColumnModel().getColumn(1).setMaxWidth(50);
						checkTable.getColumnModel().getColumn(1).setWidth(50);

						checkTable.getColumnModel().getColumn(3).setMinWidth(60);
						checkTable.getColumnModel().getColumn(3).setMaxWidth(60);
						checkTable.getColumnModel().getColumn(3).setWidth(60);
						
						checkTable.getColumnModel().getColumn(5).setMinWidth(90);
						checkTable.getColumnModel().getColumn(5).setMaxWidth(90);
						checkTable.getColumnModel().getColumn(5).setWidth(90);
						
						checkTable.getColumnModel().getColumn(6).setMinWidth(70);
						checkTable.getColumnModel().getColumn(6).setMaxWidth(70);
						checkTable.getColumnModel().getColumn(6).setWidth(70);
			
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					checkMovieDSTF.setText("");
				}
			}
		}

	}
}
