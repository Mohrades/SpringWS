package com.mycompany.hr.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

import com.mycompany.hr.service.HumanResourceService;

@SuppressWarnings("deprecation")
public class JDomHolidayEndpoint extends AbstractJDomPayloadEndpoint{
	
	private static final String NAMESPACE_URI = "http://mycompany.com/hr/schemas";
	private XPath startDateExpression;
	private XPath endDateExpression;
	private XPath nameExpression;
	private HumanResourceService humanResourceService;

	@Override
	protected Element invokeInternal(Element holidayRequest) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date startDate = dateFormat.parse(startDateExpression.valueOf(holidayRequest));
	    Date endDate = dateFormat.parse(endDateExpression.valueOf(holidayRequest));
	    String name = nameExpression.valueOf(holidayRequest);
	    humanResourceService.bookHoliday(startDate, endDate, name);
	    
	    Element response = new Element("holidayResponse", NAMESPACE_URI);
	    
	    for(int j=0;j<5;j++){
	    	Element todoListElement = new Element("TodoList", NAMESPACE_URI);
		    Element id = new Element("Id", NAMESPACE_URI);
		    id.setText(j+"");
		    todoListElement.addContent(id);
		    Element description = new Element("Description",NAMESPACE_URI);
		    description.setText("Name"+j);
		    todoListElement.addContent(description);
		    Element completed = new Element("Completed",NAMESPACE_URI);
		    completed.setText((j+1)%4==0? "true" : "false");
		    todoListElement.addContent(completed);
		    
		    Element priority = new Element("Priority",NAMESPACE_URI);
		    priority.setText(j%3==0? "true" : "false");
		    todoListElement.addContent(priority);
		    
		    Element creationDate = new Element("CreationDate", NAMESPACE_URI);
		    creationDate.setText(dateFormat.format(new Date()));
		    Thread.sleep(2100);
		    todoListElement.addContent(creationDate);
		    response.addContent(todoListElement);
	    }
	    
		return response;
	}
	
	public JDomHolidayEndpoint() throws JDOMException{
		Namespace namespace = Namespace.getNamespace("hr", NAMESPACE_URI);
	    startDateExpression = XPath.newInstance("//hr:StartDate");
	    startDateExpression.addNamespace(namespace);
	    endDateExpression = XPath.newInstance("//hr:EndDate");
	    endDateExpression.addNamespace(namespace);
	    nameExpression = XPath.newInstance("concat(//hr:FirstName,' ',//hr:LastName)");
	    nameExpression.addNamespace(namespace);
	}

	public HumanResourceService getHumanResourceService() {
		return humanResourceService;
	}

	public void setHumanResourceService(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}

}
