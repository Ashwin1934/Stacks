import java.util.Stack;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
public class BestBooks
{

		Stack<Book> BestBooks;
        public BestBooks(){
			BestBooks = new Stack<Book>();
			set("100BestSciFi21stCentury.txt");
			output();
		}

			public void set(String name){
                File file = new File(name);

                try{
					BufferedReader input = new BufferedReader(new FileReader(name));
					String text = "";
					while((text=input.readLine())!=null){
						int numberRank=Integer.parseInt(text.split(" ")[0]);
						input.readLine();
						String title=input.readLine().substring(1);
						String author=input.readLine();
						String rating = input.readLine();
						String score = input.readLine();
						input.readLine();
						Book book = new Book(title,author,rating,score);


						String [] split = book.getAuthor().split(" ");
					if(split.length==3){
						if((split[1].substring(0,1).equals("E"))||
							(split[1].substring(0,1).equals("H"))||
							(split[1].substring(0,1).equals("P"))||
							(split[1].substring(0,1).equals("S"))||
							(split[2].substring(0,1).equals("E"))||
							(split[2].substring(0,1).equals("H"))||
							(split[2].substring(0,1).equals("P"))||
							(split[2].substring(0,1).equals("S"))){

								BestBooks.add(book);
						}
					}else if(split.length==5){
						if((split[1].substring(0,1).equals("E"))||
						(split[1].substring(0,1).equals("H"))||
						(split[1].substring(0,1).equals("P"))||
						(split[1].substring(0,1).equals("S"))||
						(split[3].substring(0,1).equals("E"))||
						(split[3].substring(0,1).equals("H"))||
						(split[3].substring(0,1).equals("P"))||
						(split[3].substring(0,1).equals("S"))){

							BestBooks.add(book);
						}

					}
					}
				}catch(IOException io){
					System.err.println("File dont exist");
				}
			}

			public void output(){
				System.out.println("BestBooks:"+BestBooks.size());
				while(!BestBooks.isEmpty()){
					System.out.println(BestBooks.pop().toString());
				}

			}





	public static void main(String [] args){
		BestBooks app = new BestBooks();
	}

	public class Book{
		private String titleO;
		private String authorFirst;
		private String authorLast;
		private String ratingO;
		private String numOfRate;
		private String numOfVotes;
		private String score;
		private String authorFull;


		public Book(String title,String author,String rating, String score){
			titleO = title;
			String [] authorSplit = author.split(" ");
			if(authorSplit.length==4){
				authorFirst = authorSplit[1];
				authorFirst = authorSplit[3];
			}
			else{
			authorFirst = authorSplit[1];
			authorLast = authorSplit[2];
			}
			authorFull = author;
			String [] rate = rating.split(" ");
			ratingO = rate[0];
			numOfRate = rate[4];
			String [] scores = score.split(" ");
			score = scores[1];
			numOfVotes = scores[3];
		}
		public String toString(){
			return authorLast+","+authorFirst+"-"+titleO+";"+ratingO;
		}
		public String getAuthor(){
			return authorFull;
		}
		public String getRating(){
			return ratingO;
		}
		public String getScore(){
			return score;
		}




	}

	}
