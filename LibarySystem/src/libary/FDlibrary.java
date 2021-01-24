package libary;

import java.util.ArrayList;
import java.sql.*;

public class FDlibrary implements libarary {

	private ArrayList<Book> books = new ArrayList<Book>();


	public FDlibrary(ArrayList<Book> shu) {
		books.addAll(shu);
	}// ������

	public void addbooks() {
		Statement stmt = null;
		Connection conn = null;
		try {
			for (int i = 0; i < books.size(); i++) {
				
				String insertbook = "insert into bookborrow(name,ifOut,WID)values( " +"\""+books.get(i).getName()+"\""+ ","
						+ "\""+books.get(i).isIfborrowed()+ "\""+ "," + books.get(i).getRID() + ")";

				// 3.��ȡConnection����
				conn = DriverManager.getConnection("jdbc:mysql:///libarysystem", "root", "root");
				// 4.��ȡִ�еĶ��� Statement
				stmt = conn.createStatement();
				// 5.ִ��
				int count = stmt.executeUpdate(insertbook);// Ӱ�������
				// 6.������
				System.out.println(count);
				if (count > 0) {
					System.out.println("��ӳɹ���");
				} else {
					System.out.println("���ʧ�ܣ�");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			// stmt.close();
			// 7. �ͷ���Դ
			// �����ָ���쳣
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void findbooks(String bookname) {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

		
			String findbook = "select t1.BID,t1.name,t1.ifOut,t2.R_name from bookborrow t1,writter t2 where t1.WID=t2.RID and t1.name="+"\""+bookname+"\"";

			// 3.��ȡConnection����
			conn = DriverManager.getConnection("jdbc:mysql:///libarysystem", "root", "root");
			// 4.��ȡִ�еĶ��� Statement
			stmt = conn.createStatement();
			// 5.ִ��
			rs = stmt.executeQuery(findbook);
			// 6.������
			while (rs.next()) {
				// ��ȡ����
				// 6.2 ��ȡ����
				int BID = rs.getInt("BID");
				String name = rs.getString("name");
				boolean ifout = rs.getBoolean("ifOut");
				String wrname = rs.getString("R_name");
				System.out.println(BID + "---" + name + "---" + ifout + "---" + wrname);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			// stmt.close();
			// 7. �ͷ���Դ
			// �����ָ���쳣
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	//��������
	@Override
	public void dataUpdateBookName(String forbookname, String afterbookname) {
		Statement stmt = null;
		Connection conn = null;
		try {

			String dataupdate = "update bookborrow set name=" + "\""+afterbookname +"\""+ " where " + "name=" +"\""+forbookname+"\"";

			// 3.��ȡConnection����
			conn = DriverManager.getConnection("jdbc:mysql:///libarysystem", "root", "root");
			// 4.��ȡִ�еĶ��� Statement
			stmt = conn.createStatement();
			// 5.ִ��
			int count = stmt.executeUpdate(dataupdate);// Ӱ�������
			// 6.������
			System.out.println(count);
			if (count > 0) {
				System.out.println("�޸ĳɹ���");
			} else {
				System.out.println("�޸�ʧ�ܣ�");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			// stmt.close();
			// 7. �ͷ���Դ
			// �����ָ���쳣
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	//���½��״̬
	@Override
	public void dataUpdateifout(int BID, int ifout) {
		Statement stmt = null;
		Connection conn = null;
		try {

			String dataupdate = "update bookborrow set ifOut=" + ifout + " where " + "BID=" + BID;

			// 3.��ȡConnection����
			conn = DriverManager.getConnection("jdbc:mysql:///libarysystem", "root", "root");
			// 4.��ȡִ�еĶ��� Statement
			stmt = conn.createStatement();
			// 5.ִ��
			int count = stmt.executeUpdate(dataupdate);// Ӱ�������
			// 6.������
			System.out.println(count);
			if (count > 0) {
				System.out.println("�޸ĳɹ���");
			} else {
				System.out.println("�޸�ʧ�ܣ�");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			// stmt.close();
			// 7. �ͷ���Դ
			// �����ָ���쳣
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
//����������
	@Override
	public void dataUpdateAuthorname(int RID, String authorname) {
		Statement stmt = null;
		Connection conn = null;
		try {

			String dataupdate = "update writter set  R_name=" + "\""+authorname +"\""+ " where " + "RID=" + RID;

			// 3.��ȡConnection����
			conn = DriverManager.getConnection("jdbc:mysql:///libarysystem", "root", "root");
			// 4.��ȡִ�еĶ��� Statement
			stmt = conn.createStatement();
			// 5.ִ��
			int count = stmt.executeUpdate(dataupdate);// Ӱ�������
			// 6.������
			System.out.println(count);
			if (count > 0) {
				System.out.println("�޸ĳɹ���");
			} else {
				System.out.println("�޸�ʧ�ܣ�");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			// stmt.close();
			// 7. �ͷ���Դ
			// �����ָ���쳣
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void printall() {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

		
			String findbook = "select t1.BID,t1.name,t1.ifOut,t2.R_name from bookborrow t1,writter t2 where t1.WID=t2.RID ";

			// 3.��ȡConnection����
			conn = DriverManager.getConnection("jdbc:mysql:///libarysystem", "root", "root");
			// 4.��ȡִ�еĶ��� Statement
			stmt = conn.createStatement();
			// 5.ִ��
			rs = stmt.executeQuery(findbook);
			// 6.������
			while (rs.next()) {
				// ��ȡ����
				// 6.2 ��ȡ����
				int BID = rs.getInt("BID");
				String name = rs.getString("name");
				boolean ifout = rs.getBoolean("ifOut");
				String wrname = rs.getString("R_name");
				System.out.println(BID + "---" + name + "---" + ifout + "---" + wrname);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			// stmt.close();
			// 7. �ͷ���Դ
			// �����ָ���쳣
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

		
	}


