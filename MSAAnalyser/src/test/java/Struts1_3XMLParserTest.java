import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.hcl.msa.parser.xml.struts.struts13.jaxbmodel.Action;
import com.hcl.msa.parser.xml.struts.struts13.jaxbmodel.StrutsConfig;


public class Struts1_3XMLParserTest {

	public static void main(String[] args) throws IOException {
		JAXBContext jaxbContext;

		try {
			jaxbContext = JAXBContext.newInstance("com.hcl.msa.parser.xml.struts.struts13.jaxbmodel");

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		
		FileReader fis=null;
	     fis = new FileReader(new File("src\\test\\java\\ejb2-ejb-jar.xml"));
		BufferedReader bufferedReader = new BufferedReader(fis);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			if(line.contains(".dtd")|| line.contains(".xsd")) {
				int lastIndex=line.lastIndexOf("\"");
				if(lastIndex == -1 )lastIndex = line.lastIndexOf("\'");
			stringBuffer.append(line.substring(line.lastIndexOf("/")+1, lastIndex));
			stringBuffer.append("\n");
			}
		}
		fis.close();
		System.out.println("Contents of file:");
		System.out.println(stringBuffer.toString());
		try {
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StrutsConfig strutsConfig = (StrutsConfig) unmarshaller
					.unmarshal(new File("src\\test\\java\\struts-config.xml"));
			System.out.println(strutsConfig.getId());
			List strutsConfigList = strutsConfig.getActionMappings().getAction();
			for (Iterator iterator = strutsConfigList.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				if (object instanceof Action) {
					Action ses = (Action) object;
					System.out.println(ses.getName());
					System.out.println(ses.getPath());
					System.out.println(ses.getType());
				}

			}

			Marshaller m = jaxbContext.createMarshaller();
			// for pretty-print XML in JAXB
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Write to File
			m.marshal(strutsConfig, new File("src\\test\\java\\reconstructed-struts-config.xml"));

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

	}

}
