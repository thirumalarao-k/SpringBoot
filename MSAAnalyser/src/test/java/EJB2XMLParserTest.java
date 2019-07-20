import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EjbJar;
import com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.EntityBean;
import com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel.SessionBean;

public class EJB2XMLParserTest {

	public static void main(String[] args) {
		// JAXBContext is thread safe and can be created once
		JAXBContext jaxbContext;

		try {
			jaxbContext = JAXBContext.newInstance("com.hcl.msa.parser.xml.ejb.ejb21.jaxbmodel");
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

		try {
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			//unmarshaller.setProperty("javax.xml.accessExternalDTD", "all");
			JAXBElement ejbJar = (JAXBElement) unmarshaller
					.unmarshal(new File("src\\test\\java\\ejb2_1-ejb-jar.xml"));
			System.out.println(ejbJar.getDeclaredType());
			EjbJar ejbJar1=(EjbJar)ejbJar.getValue();
			List ejbs=ejbJar1.getEnterpriseBeans().getSessionOrEntityOrMessageDriven();
			for (Iterator iterator = ejbs.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				if(object instanceof SessionBean) {
					SessionBean ses=(SessionBean)object;
				System.out.println(ses.getEjbName().getValue());
				}
				if(object instanceof EntityBean) {
					EntityBean entity=(EntityBean)object;
				System.out.println(entity.getEjbName().getValue());
				System.out.println(entity.getId());
				System.out.println((entity.getCmpField().get(0)).getFieldName().getValue());
				System.out.println(entity.getPersistenceType().getValue());
				}
			}
			
			
			 Marshaller m = jaxbContext.createMarshaller();
	            //for pretty-print XML in JAXB
	            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

	             // Write to File
	            m.marshal(ejbJar, new File("src\\test\\java\\reconstructed-ejb2-ejb-jar.xml"));

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		
		
	}

}
