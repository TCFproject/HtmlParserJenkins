package fr.epsi.jenkins;
import java.io.File;
import java.net.URISyntaxException;

public abstract class HtmlPerser {
	protected File parseFile;
	
	abstract public File createFile() throws URISyntaxException;
}
