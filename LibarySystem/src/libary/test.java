package libary;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		
		Book ��ҹ=new Book(2, "��ҹ", 1,"����ɯ����˹��" , 2);
		Book ����=new Book(1, "����", 1," ������",1);
		Book ��Ǒ=new Book(3, "��Ǒ", 2, "�������", 3);
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(����);
		books.add(��ҹ);
		books.add(��Ǒ);
		FDlibrary x=new FDlibrary(books);
		x.addbooks();
		x.dataUpdateAuthorname(1, "����");//�������߱�����
		x.dataUpdateBookName("��ҹ","longnight" );//��������
		x.findbooks("����");//����ͼ��
		x.printall();
	}

}
