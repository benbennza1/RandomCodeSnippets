import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import me.tongfei.progressbar.*;

public class main {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://slackmojis.com/categories/19-random-emojis").get();
			System.out.println(doc.title());

			Elements gifs = doc.select(".emoji a");
			ProgressBarBuilder pbb = new ProgressBarBuilder().setTaskName("Stealing GIFs");
			for (Element gif : ProgressBar.wrap(gifs, pbb)) {
				Response resultImageResponse = Jsoup.connect(gif.attr("abs:href")).ignoreContentType(true).execute();
				
				FileOutputStream out = (new FileOutputStream(
						new File(".\\src\\main\\resources\\" + gif.attr("download"))));
				
				out.write(resultImageResponse.bodyAsBytes());
				out.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
