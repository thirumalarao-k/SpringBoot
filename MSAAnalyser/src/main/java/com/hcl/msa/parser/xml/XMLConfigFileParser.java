package com.hcl.msa.parser.xml;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.hcl.msa.parser.xml.struts.struts13.jaxbmodel.StrutsConfig;

public class XMLConfigFileParser {
	public static com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.EjbJar ejb2JarXmlParser(Path path) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel");
		marshaller.setProcessExternalEntities(true);
		com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.EjbJar ejbJar = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path.toFile().getAbsolutePath());
			StreamSource ss = new StreamSource(fis);

			ejbJar = (com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.EjbJar) marshaller.unmarshal(ss);
			List<Object> ejbs = ejbJar.getEnterpriseBeans().getSessionOrEntityOrMessageDriven();
			System.out.println("###### Number of EJBs defined in ejb-jar.xml" + ejbs.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return ejbJar;
	}
	
	public static com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EjbJar ejb21JarXmlParser(Path path) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel");
		marshaller.setProcessExternalEntities(true);
		com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EjbJar ejbJar = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path.toFile().getAbsolutePath());
			StreamSource ss = new StreamSource(fis);

			JAXBElement jaxBEmlt = (JAXBElement<?>) marshaller.unmarshal(ss);
			ejbJar = (com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EjbJar) jaxBEmlt.getValue();
			List<Object> ejbs = ejbJar.getEnterpriseBeans().getSessionOrEntityOrMessageDriven();
			System.out.println("###### Number of EJBs defined in ejb-jar.xml" + ejbs.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		   return ejbJar;
	}
	
	public static com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EjbJar ejb3JarXmlParser(Path path) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static StrutsConfig struts13XmlParser(Path path) {
		JAXBContext jaxbContext;
		StrutsConfig strutsConfig=null;
		try {
			jaxbContext = JAXBContext.newInstance("com.hcl.msa.parser.xml.struts.struts13.jaxbmodel");

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		FileInputStream fis=null;
		try {
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			fis = new FileInputStream(path.toFile().getAbsolutePath());
			StreamSource ss=new StreamSource(fis);
			strutsConfig = (StrutsConfig) unmarshaller.unmarshal(ss);
			System.out.println(strutsConfig.getId());
/*			List<ActionMap> actionMappings = (List)strutsConfig.getActionMappings();
			System.out.println("###### Number of Action Mappings defined in struts config xml > "+actionMappings.size());*/
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		   return strutsConfig;
	}
	
	public static StrutsConfig struts2XmlParser(Path path) {
		JAXBContext jaxbContext;
		StrutsConfig strutsConfig=null;
		try {
			jaxbContext = JAXBContext.newInstance("com.hcl.msa.parser.xml.struts.struts2.jaxbmodel");

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

		FileInputStream fis=null;
		try {
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			fis = new FileInputStream(path.toFile().getAbsolutePath());
			StreamSource ss=new StreamSource(fis);
			strutsConfig = (StrutsConfig) unmarshaller.unmarshal(ss);
			System.out.println(strutsConfig.getId());
			List actionMappings = (List)strutsConfig.getActionMappings();
			System.out.println("###### Number of Action Mappings defined in struts config xml > "+actionMappings.size());
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		   return strutsConfig;
	}
	
	public static String findVersion(Path path) {

		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		StringBuffer stringBuffer=new StringBuffer();
		
		try {
			fileReader = new FileReader(path.toFile().getAbsolutePath());
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.contains(".dtd")|| line.contains(".xsd")) {
					int lastIndex=line.lastIndexOf("\"");
					if(lastIndex == -1 )lastIndex = line.lastIndexOf("\'");
				stringBuffer.append(line.substring(line.lastIndexOf("/")+1, lastIndex));
				stringBuffer.append("\n");
				}
			}
			System.out.println("Version of EJB/Spring/Struts used in the project:"+stringBuffer.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if (fileReader != null)
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		   return stringBuffer.toString();
	}

}
