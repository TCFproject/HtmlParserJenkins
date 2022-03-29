package fr.epsi.jenkins;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class HtmlIndexPerser extends HtmlPerser {
	private ArrayList<String> listInfo;
	public HtmlIndexPerser(ArrayList<String> listInfo) {
		this.listInfo = listInfo;
	}

	@Override
	public File createFile() throws URISyntaxException {
		// TODO Auto-generated method stub
		this.parseFile = new File("C:\\xampp\\htdocs\\index.html");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(this.parseFile) );
			bw.write("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <link href=\"./style.css\" rel=\"stylesheet\" />\r\n"
					+ "\r\n"
					+ "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com/%22%3E>\" />\r\n"
					+ "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com/\" crossorigin />\r\n"
					+ "    <link\r\n"
					+ "      href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap\"\r\n"
					+ "      rel=\"stylesheet\"\r\n"
					+ "    />\r\n"
					+ "    <title>Liste Agent</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <section>\r\n"
					+"\r\n"
					+ "        <div class=\"logo\">\r\n"
					+ "            <img src=\"./assets/logoSecu.png\" alt=\"logoSecu\">\r\n"
					+ "        </div>"
					+ "<div class=\"list\">\r\n"
					+ "            <ul class=\"list_employee\">");
			for (String name : this.listInfo) {
				bw.write("<li class=\"employee\"><a href=equipements/"+name+".html"+">");
				bw.write(name);
				bw.write("</a></li>");
			}
			bw.write("</ul>\r\n"
					+ "        </div>\r\n"
					+ "    </section>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.parseFile;
	}

}
