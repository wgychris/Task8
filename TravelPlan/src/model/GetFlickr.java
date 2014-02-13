package model;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import databeans.PhotoBean;

/**
 * Reference : http://java4ever.blogspot.com/2008/08/play-with-flickr-api-in-java.html
 */

/**
 * @author yusizhang
 * 
 */
public class GetFlickr {

	/**
	 * @param args
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	static String apiKey = "6184cec201170a02ac8d59623a97b9af";
	String secret = "a3522a63b83696b6";
	static String method = "flickr.photos.search";

	public static ArrayList<PhotoBean> getPhotos(String keyword, int count)
			throws MalformedURLException, IOException, XMLStreamException {
		ArrayList<PhotoBean> res = new ArrayList<PhotoBean>();
		// &min_date_taken=2000-00-00&has_geo=1
		// &tag_mode=all&accuracy=11
		URLConnection uc = new URL(
				"http://api.flickr.com/services/rest/?method=" + method
						+ "&api_key=" + apiKey + "&per_page=" + count
						+ "&text=" + URLEncoder.encode(keyword)
						+ "&tag_mode=all&content_type=1&sort=relevance")
				.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				uc.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
				"test.xml")));
		String nextline;
		String[] servers = new String[count];
		String[] ids = new String[count];
		String[] secrets = new String[count];
		while ((nextline = br.readLine()) != null) {
			bw.write(nextline);// fastest the way to read and write
		}
		br.close();
		bw.close();

		String filename = "test.xml";
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader r = factory.createXMLEventReader(filename,
				new FileInputStream(filename));
		int i = -1;
		while (r.hasNext()) {
			XMLEvent event = r.nextEvent();
			if (event.isStartElement()) {
				StartElement element = (StartElement) event;
				String elementName = element.getName().toString();

				if (elementName.equals("photo")) {// xml element starts with
													// photo
					i++;
					Iterator iterator = element.getAttributes();

					while (iterator.hasNext()) {

						Attribute attribute = (Attribute) iterator.next();
						/*
						 * attribute has two methods :
						 * getName(server,id,secret,owner,farm,title etc)
						 * getValue
						 */
						QName name = attribute.getName();
						String value = attribute.getValue();
						// isfamily,farm,id,title,ispublic,owner,secret,server,isfriend
						// System.out.println(name.toString());
						if ((name.toString()).equals("server")) {
							servers[i] = value;
						}
						if ((name.toString()).equals("id")) {
							ids[i] = value;
						}
						if ((name.toString()).equals("secret")) {
							secrets[i] = value;
						}
					}
				}
			}
		}
		for (int j = 0; j < i; j++) {
			String flickrurl = "http://static.flickr.com/" + servers[j] + "/"
					+ ids[j] + "_" + secrets[j] + ".jpg";
			PhotoBean pb = new PhotoBean();
			pb.setUrl(flickrurl);
			res.add(pb);
		}
		return res;
	}

}
