package libary;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		
		Book 长夜=new Book(2, "长夜", 1,"阿加莎克里斯蒂" , 2);
		Book 三体=new Book(1, "三体", 1," 刘慈欣",1);
		Book 冰菓=new Book(3, "冰菓", 2, "米泽惠信", 3);
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(三体);
		books.add(长夜);
		books.add(冰菓);
		FDlibrary x=new FDlibrary(books);
		x.addbooks();
		x.dataUpdateAuthorname(1, "大刘");//更新作者表名字
		x.dataUpdateBookName("长夜","longnight" );//更改书名
		x.findbooks("三体");//查找图书
		x.printall();
	}

}
