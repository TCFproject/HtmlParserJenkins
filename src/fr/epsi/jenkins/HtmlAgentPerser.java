package fr.epsi.jenkins;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

public class HtmlAgentPerser extends HtmlPerser {
	private String nomFichier;
	private ArrayList<String> infoAgent;
	private HashMap<String, String> outils = new HashMap<>();
	
	public HtmlAgentPerser(String nomFichier, ArrayList<String> infoAgent, ArrayList<String> outils) {
		this.nomFichier = nomFichier;
		this.infoAgent = infoAgent;
		for (String parse_outils : outils) {
			String[] split_str = parse_outils.split(" ");
			this.outils.put(split_str[0], split_str[1]);
		}
	}

	@Override
	public File createFile() throws URISyntaxException {
		// TODO Auto-generated method stub
		if (this.nomFichier.contains(".txt")) {

			String[] parseNameFile = this.nomFichier.split(".txt");
			this.parseFile = new File(Main.cheminDeBase+"\\"+parseNameFile[0]+".html");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(this.parseFile));
				bw.write("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "  <head>\r\n"
						+ "    <meta charset=\"UTF-8\" />\r\n"
						+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
						+ "    <link href=\"/style.css\" rel=\"stylesheet\" />\r\n"
						+ "\r\n"
						+ "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com/%22%3E>\" />\r\n"
						+ "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com/\" crossorigin />\r\n"
						+ "    <link\r\n"
						+ "      href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap\"\r\n"
						+ "      rel=\"stylesheet\"\r\n"
						+ "    />\r\n"
						+ "\r\n"
						+ "    <title>GO Securi</title>\r\n"
						+ "  </head>\r\n"
						+ "  <body>\r\n"
						+ "    <section class=\"container\">\r\n"
						+ "      <div class=\"identity\">\r\n"
						+ "        <div class=\"name_lastname\">\r\n"
						+ "          <p class=\"firstName\">"+this.infoAgent.get(0)+"</p>\r\n"
						+ "          <p class=\"lastName\">"+this.infoAgent.get(1)+"</p>\r\n"
						+ "          <p class=\"job\">"+this.infoAgent.get(2)+"</p>\r\n"
						+ "          <p class=\"mdp\">"+this.infoAgent.get(3)+"</p>\r\n"
						+ "        </div>");
				
				bw.write("<div class=\"list\">\r\n"
						+ "        <ul class=\"list_item\">\r\n"
						+ "          ");
				outils.forEach((k,v)->{
					try {
						bw.write("<li><input type=\"checkbox\" ");
						bw.write("name="+k+" id="+k+"\"");
						if (this.infoAgent.get(5).equals(k) || this.infoAgent.get(6).equals(k) || this.infoAgent.get(7).equals(k)) {
							bw.write(" checked");
						}
						bw.write(">"+v);
						bw.write("</li>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				/*bw.write(this.outils.get(this.infoAgent.get(5)));
				bw.write("</li>");
				bw.write("<li>\r\n"
						+"<input type=\"checkbox\" name=\"gant\" id=\"gant\" />");
				bw.write(this.outils.get(this.infoAgent.get(6)));
				bw.write("<li>\r\n"
						+"<input type=\"checkbox\" name=\"gant\" id=\"gant\" />");
				bw.write(this.outils.get(this.infoAgent.get(7)));*/
				
				bw.write( "        </ul>\r\n"
						+ "      </div>\r\n"
						+ "    </section>\r\n"
						+ "  </body>\r\n"
						+ "</html>");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.parseFile;
	}

}
